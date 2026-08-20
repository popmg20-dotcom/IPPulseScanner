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

        /*
         * Only an initial SYN can create a new outbound connection.
         */
        if (!tcpHeader.isSYN())
        {
            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0);

            outputQueue.offer(responseBuffer);

            vpnService.debug(
                    "TCP NON-SYN WITHOUT TCB -> RST "
                            + ipAndPort);

            return;
        }

        SocketChannel outputChannel = SocketChannel.open();

        /*
         * IMPORTANT:
         *
         * Connect while blocking, with a real timeout.
         * After the physical connection succeeds, switch the channel
         * back to non-blocking mode for the existing TCPInput selector.
         *
         * This completely avoids the selector connect-event path.
         */
        outputChannel.configureBlocking(true);

        vpnService.debug(
                "TCP SOCKET CREATED "
                        + destinationAddress.getHostAddress()
                        + ":" + destinationPort);

        if (!vpnService.protectOrBind(outputChannel.socket()))
        {
            vpnService.debug(
                    "TCP PROTECT/BIND FAILED "
                            + ipAndPort);

            try
            {
                outputChannel.close();
            }
            catch (IOException ignored)
            {
            }

            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0);

            outputQueue.offer(responseBuffer);

            return;
        }

        vpnService.debug(
                "TCP PROTECT/BIND OK "
                        + ipAndPort);

        TCB tcb = new TCB(
                ipAndPort,
                random.nextInt(Short.MAX_VALUE + 1),
                tcpHeader.sequenceNumber,
                tcpHeader.sequenceNumber + 1,
                tcpHeader.acknowledgementNumber,
                outputChannel,
                currentPacket);

        tcb.status = TCBStatus.SYN_SENT;

        TCB.putTCB(
                ipAndPort,
                tcb);

        vpnService.debug(
                "TCP CONNECT START "
                        + destinationAddress.getHostAddress()
                        + ":" + destinationPort);

        try
        {
            /*
             * The bind/protect has already happened.
             * Therefore this connect must go through the physical
             * network instead of returning to the VPN.
             */
            outputChannel.socket().connect(
                    new InetSocketAddress(
                            destinationAddress,
                            destinationPort),
                    (int) CONNECT_TIMEOUT_MS);

            vpnService.debug(
                    "TCP CONNECTED "
                            + ipAndPort);

            /*
             * Existing TCPInput expects a selectable non-blocking
             * SocketChannel for OP_READ.
             */
            outputChannel.configureBlocking(false);

            synchronized (tcb)
            {
                tcb.status =
                        TCBStatus.SYN_RECEIVED;
            }

            /*
             * Register only OP_READ.
             * There is intentionally no selector connect-event path anymore.
             */
            selector.wakeup();

            SelectionKey key =
                    outputChannel.register(
                            selector,
                            SelectionKey.OP_READ,
                            tcb);

            tcb.selectionKey = key;
            tcb.waitingForNetworkData = true;

            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte)
                            (TCPHeader.SYN
                                    | TCPHeader.ACK),
                    tcb.mySequenceNum,
                    tcb.myAcknowledgementNum,
                    0);

            tcb.mySequenceNum++;

            outputQueue.offer(
                    responseBuffer);

            vpnService.debug(
                    "TCP SYN-ACK QUEUED "
                            + ipAndPort);
        }
        catch (IOException e)
        {
            vpnService.debug(
                    "TCP CONNECT FAILED "
                            + ipAndPort
                            + " "
                            + e);

            try
            {
                currentPacket.updateTCPBuffer(
                        responseBuffer,
                        (byte) TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum,
                        0);

                outputQueue.offer(
                        responseBuffer);
            }
            finally
            {
                TCB.closeTCB(tcb);
            }
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
