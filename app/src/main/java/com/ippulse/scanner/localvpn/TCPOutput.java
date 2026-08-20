package com.ippulse.scanner.localvpn;

import com.ippulse.scanner.GamingVpnService;

import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.ippulse.scanner.localvpn.Packet.TCPHeader;
import com.ippulse.scanner.localvpn.TCB.TCBStatus;

public class TCPOutput implements Runnable
{
    private static final String TAG = TCPOutput.class.getSimpleName();

    private static final long CONNECT_TIMEOUT_MS = 10000L;
    private static final long CONNECT_POLL_MS = 20L;

    private final GamingVpnService vpnService;
    private final ConcurrentLinkedQueue<Packet> inputQueue;
    private final ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private final Selector selector;

    private final Random random = new Random();

    public TCPOutput(
            ConcurrentLinkedQueue<Packet> inputQueue,
            ConcurrentLinkedQueue<ByteBuffer> outputQueue,
            Selector selector,
            GamingVpnService vpnService)
    {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        this.selector = selector;
        this.vpnService = vpnService;
    }

    @Override
    public void run()
    {
        Log.i(TAG, "Started");

        try
        {
            Thread currentThread = Thread.currentThread();

            while (!currentThread.isInterrupted())
            {
                Packet currentPacket;

                do
                {
                    currentPacket = inputQueue.poll();

                    if (currentPacket != null)
                        break;

                    Thread.sleep(10);
                }
                while (!currentThread.isInterrupted());

                if (currentThread.isInterrupted())
                    break;

                ByteBuffer payloadBuffer = currentPacket.backingBuffer;
                currentPacket.backingBuffer = null;

                ByteBuffer responseBuffer = ByteBufferPool.acquire();

                InetAddress destinationAddress =
                        currentPacket.ip4Header.destinationAddress;

                TCPHeader tcpHeader = currentPacket.tcpHeader;

                int destinationPort = tcpHeader.destinationPort;
                int sourcePort = tcpHeader.sourcePort;

                String ipAndPort =
                        destinationAddress.getHostAddress()
                                + ":" + destinationPort
                                + ":" + sourcePort;

                Log.i(TAG,
                        "TCP packet "
                                + ipAndPort
                                + " SYN=" + tcpHeader.isSYN()
                                + " ACK=" + tcpHeader.isACK()
                                + " FIN=" + tcpHeader.isFIN()
                                + " RST=" + tcpHeader.isRST());

                TCB tcb = TCB.getTCB(ipAndPort);

                if (tcb == null)
                {
                    initializeConnection(
                            ipAndPort,
                            destinationAddress,
                            destinationPort,
                            currentPacket,
                            tcpHeader,
                            responseBuffer);
                }
                else if (tcpHeader.isSYN())
                {
                    processDuplicateSYN(
                            tcb,
                            tcpHeader,
                            responseBuffer);
                }
                else if (tcpHeader.isRST())
                {
                    closeCleanly(tcb, responseBuffer);
                }
                else if (tcpHeader.isFIN())
                {
                    processFIN(
                            tcb,
                            tcpHeader,
                            responseBuffer);
                }
                else if (tcpHeader.isACK())
                {
                    processACK(
                            tcb,
                            tcpHeader,
                            payloadBuffer,
                            responseBuffer);
                }

                if (responseBuffer.position() == 0)
                {
                    ByteBufferPool.release(responseBuffer);
                }

                ByteBufferPool.release(payloadBuffer);
            }
        }
        catch (InterruptedException e)
        {
            Log.i(TAG, "Stopping");
        }
        catch (Exception e)
        {
            Log.e(TAG, "TCPOutput fatal error", e);
        }
        finally
        {
            TCB.closeAll();
        }
    }

    private void initializeConnection(
            String ipAndPort,
            InetAddress destinationAddress,
            int destinationPort,
            Packet currentPacket,
            TCPHeader tcpHeader,
            ByteBuffer responseBuffer)
            throws IOException
    {
        currentPacket.swapSourceAndDestination();

        if (!tcpHeader.isSYN())
        {
            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0);

            outputQueue.offer(responseBuffer);
            return;
        }

        SocketChannel outputChannel = SocketChannel.open();
        outputChannel.configureBlocking(false);

        Log.i(TAG,
                "TCP socket created "
                        + destinationAddress.getHostAddress()
                        + ":" + destinationPort);

        if (!vpnService.protectOrBind(outputChannel.socket()))
        {
            try
            {
                outputChannel.close();
            }
            catch (IOException ignored)
            {
            }

            throw new IOException(
                    "Unable to bind/protect TCP socket");
        }

        TCB tcb = new TCB(
                ipAndPort,
                random.nextInt(Short.MAX_VALUE + 1),
                tcpHeader.sequenceNumber,
                tcpHeader.sequenceNumber + 1,
                tcpHeader.acknowledgementNumber,
                outputChannel,
                currentPacket);

        tcb.status = TCBStatus.SYN_SENT;

        TCB.putTCB(ipAndPort, tcb);

        Log.i(TAG,
                "TCP connect start "
                        + destinationAddress.getHostAddress()
                        + ":" + destinationPort);

        boolean connected;

        try
        {
            connected = outputChannel.connect(
                    new InetSocketAddress(
                            destinationAddress,
                            destinationPort));

            Log.i(TAG,
                    "TCP connect() returned "
                            + connected
                            + " for "
                            + ipAndPort);
        }
        catch (IOException e)
        {
            Log.e(TAG,
                    "TCP connect() failed: " + ipAndPort,
                    e);

            sendConnectionRST(
                    tcb,
                    responseBuffer);

            return;
        }

        if (connected)
        {
            completeConnection(tcb);
            outputQueue.offer(responseBuffer);
            return;
        }

        /*
         * Do not depend on selector connect events here.
         * The watchdog completes the pending connection and then
         * registers the channel for network reads.
         */
        startConnectWatchdog(tcb);

        /*
         * The response buffer remains empty here. Do not enqueue it.
         */
        Log.i(TAG,
                "TCP connect pending; watchdog started: "
                        + ipAndPort);
    }

    private void startConnectWatchdog(final TCB tcb)
    {
        Thread thread = new Thread(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        final long deadline =
                                System.currentTimeMillis()
                                        + CONNECT_TIMEOUT_MS;

                        try
                        {
                            while (System.currentTimeMillis()
                                    < deadline)
                            {
                                synchronized (tcb)
                                {
                                    if (tcb.status
                                            != TCBStatus.SYN_SENT)
                                    {
                                        return;
                                    }
                                }

                                SocketChannel channel =
                                        tcb.channel;

                                if (channel == null
                                        || !channel.isOpen())
                                {
                                    failPendingConnection(tcb);
                                    return;
                                }

                                boolean connected;

                                try
                                {
                                    connected =
                                            channel.finishConnect();
                                }
                                catch (IOException e)
                                {
                                    Log.e(TAG,
                                            "finishConnect failed: "
                                                    + tcb.ipAndPort,
                                            e);

                                    failPendingConnection(tcb);
                                    return;
                                }

                                if (connected)
                                {
                                    Log.i(TAG,
                                            "TCP CONNECTED: "
                                                    + tcb.ipAndPort);

                                    ByteBuffer response =
                                            ByteBufferPool.acquire();

                                    try
                                    {
                                        completeConnection(tcb);

                                        synchronized (tcb)
                                        {
                                            tcb.referencePacket
                                                    .updateTCPBuffer(
                                                            response,
                                                            (byte)
                                                                    (TCPHeader.SYN
                                                                            | TCPHeader.ACK),
                                                            tcb.mySequenceNum,
                                                            tcb.myAcknowledgementNum,
                                                            0);

                                            tcb.mySequenceNum++;
                                        }

                                        outputQueue.offer(response);
                                    }
                                    catch (Exception e)
                                    {
                                        ByteBufferPool.release(
                                                response);

                                        Log.e(TAG,
                                                "TCP SYN-ACK build failed: "
                                                        + tcb.ipAndPort,
                                                e);

                                        failPendingConnection(tcb);
                                    }

                                    return;
                                }

                                Thread.sleep(
                                        CONNECT_POLL_MS);
                            }

                            Log.e(TAG,
                                    "TCP CONNECT TIMEOUT: "
                                            + tcb.ipAndPort);

                            failPendingConnection(tcb);
                        }
                        catch (InterruptedException e)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                },
                "tcp-connect-watchdog");

        thread.setDaemon(true);
        thread.start();
    }

    private void completeConnection(TCB tcb)
            throws IOException
    {
        synchronized (tcb)
        {
            if (tcb.status != TCBStatus.SYN_SENT)
            {
                return;
            }

            tcb.status = TCBStatus.SYN_RECEIVED;
        }

        selector.wakeup();

        synchronized (tcb)
        {
            if (tcb.selectionKey == null
                    || !tcb.selectionKey.isValid())
            {
                tcb.selectionKey =
                        tcb.channel.register(
                                selector,
                                SelectionKey.OP_READ,
                                tcb);
            }
            else
            {
                tcb.selectionKey.attach(tcb);
                tcb.selectionKey.interestOps(
                        SelectionKey.OP_READ);
            }
        }

        Log.i(TAG,
                "TCP registered OP_READ: "
                        + tcb.ipAndPort);
    }

    private void failPendingConnection(TCB tcb)
    {
        ByteBuffer buffer =
                ByteBufferPool.acquire();

        try
        {
            synchronized (tcb)
            {
                if (tcb.status != TCBStatus.SYN_SENT)
                {
                    ByteBufferPool.release(buffer);
                    return;
                }

                tcb.referencePacket.updateTCPBuffer(
                        buffer,
                        (byte) TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum,
                        0);
            }

            outputQueue.offer(buffer);

            TCB.closeTCB(tcb);

            Log.e(TAG,
                    "TCP pending connection closed: "
                            + tcb.ipAndPort);
        }
        catch (Exception e)
        {
            ByteBufferPool.release(buffer);

            Log.e(TAG,
                    "TCP pending connection cleanup failed: "
                            + tcb.ipAndPort,
                    e);

            TCB.closeTCB(tcb);
        }
    }

    private void sendConnectionRST(
            TCB tcb,
            ByteBuffer buffer)
    {
        try
        {
            synchronized (tcb)
            {
                tcb.referencePacket.updateTCPBuffer(
                        buffer,
                        (byte) TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum,
                        0);
            }

            outputQueue.offer(buffer);
        }
        finally
        {
            TCB.closeTCB(tcb);
        }
    }

    private void processDuplicateSYN(
            TCB tcb,
            TCPHeader tcpHeader,
            ByteBuffer responseBuffer)
    {
        synchronized (tcb)
        {
            if (tcb.status == TCBStatus.SYN_SENT)
            {
                tcb.myAcknowledgementNum =
                        tcpHeader.sequenceNumber + 1;

                ByteBufferPool.release(responseBuffer);

                return;
            }
        }

        sendRST(
                tcb,
                1,
                responseBuffer);
    }

    private void processFIN(
            TCB tcb,
            TCPHeader tcpHeader,
            ByteBuffer responseBuffer)
    {
        synchronized (tcb)
        {
            Packet referencePacket =
                    tcb.referencePacket;

            tcb.myAcknowledgementNum =
                    tcpHeader.sequenceNumber + 1;

            tcb.theirAcknowledgementNum =
                    tcpHeader.acknowledgementNumber;

            if (tcb.waitingForNetworkData)
            {
                tcb.status =
                        TCBStatus.CLOSE_WAIT;

                referencePacket.updateTCPBuffer(
                        responseBuffer,
                        (byte) TCPHeader.ACK,
                        tcb.mySequenceNum,
                        tcb.myAcknowledgementNum,
                        0);
            }
            else
            {
                tcb.status =
                        TCBStatus.LAST_ACK;

                referencePacket.updateTCPBuffer(
                        responseBuffer,
                        (byte)
                                (TCPHeader.FIN
                                        | TCPHeader.ACK),
                        tcb.mySequenceNum,
                        tcb.myAcknowledgementNum,
                        0);

                tcb.mySequenceNum++;
            }
        }

        outputQueue.offer(responseBuffer);
    }

    private void processACK(
            TCB tcb,
            TCPHeader tcpHeader,
            ByteBuffer payloadBuffer,
            ByteBuffer responseBuffer)
            throws IOException
    {
        int payloadSize =
                payloadBuffer.limit()
                        - payloadBuffer.position();

        synchronized (tcb)
        {
            SocketChannel outputChannel =
                    tcb.channel;

            if (tcb.status == TCBStatus.SYN_RECEIVED)
            {
                tcb.status =
                        TCBStatus.ESTABLISHED;

                tcb.theirAcknowledgementNum =
                        tcpHeader.acknowledgementNumber;

                selector.wakeup();

                if (tcb.selectionKey == null
                        || !tcb.selectionKey.isValid())
                {
                    tcb.selectionKey =
                            outputChannel.register(
                                    selector,
                                    SelectionKey.OP_READ,
                                    tcb);
                }
                else
                {
                    tcb.selectionKey.interestOps(
                            SelectionKey.OP_READ);
                }

                tcb.waitingForNetworkData = true;

                Log.i(TAG,
                        "TCP ESTABLISHED: "
                                + tcb.ipAndPort);
            }
            else if (tcb.status == TCBStatus.LAST_ACK)
            {
                closeCleanly(
                        tcb,
                        responseBuffer);
                return;
            }

            if (payloadSize == 0)
            {
                ByteBufferPool.release(
                        responseBuffer);

                return;
            }

            if (!tcb.waitingForNetworkData)
            {
                selector.wakeup();

                tcb.selectionKey.interestOps(
                        SelectionKey.OP_READ);

                tcb.waitingForNetworkData = true;
            }

            try
            {
                while (payloadBuffer.hasRemaining())
                {
                    int written =
                            outputChannel.write(
                                    payloadBuffer);

                    if (written == 0)
                    {
                        break;
                    }
                }
            }
            catch (IOException e)
            {
                Log.e(TAG,
                        "TCP network write error: "
                                + tcb.ipAndPort,
                        e);

                sendRST(
                        tcb,
                        payloadSize,
                        responseBuffer);

                return;
            }

            tcb.myAcknowledgementNum =
                    tcpHeader.sequenceNumber
                            + payloadSize;

            tcb.theirAcknowledgementNum =
                    tcpHeader.acknowledgementNumber;

            Packet referencePacket =
                    tcb.referencePacket;

            referencePacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.ACK,
                    tcb.mySequenceNum,
                    tcb.myAcknowledgementNum,
                    0);
        }

        outputQueue.offer(responseBuffer);
    }

    private void sendRST(
            TCB tcb,
            int prevPayloadSize,
            ByteBuffer buffer)
    {
        try
        {
            synchronized (tcb)
            {
                tcb.referencePacket.updateTCPBuffer(
                        buffer,
                        (byte) TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum
                                + prevPayloadSize,
                        0);
            }

            outputQueue.offer(buffer);
        }
        finally
        {
            TCB.closeTCB(tcb);
        }
    }

    private void closeCleanly(
            TCB tcb,
            ByteBuffer buffer)
    {
        ByteBufferPool.release(buffer);
        TCB.closeTCB(tcb);
    }
}
