package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.util.LogUtils;
import com.github.xfalcon.vhosts.vservice.Packet;
import com.github.xfalcon.vhosts.vservice.TCB;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public class TCPOutput implements Runnable {
    private static final String TAG = TCPOutput.class.getSimpleName();
    private ConcurrentLinkedQueue<Packet> inputQueue;
    private ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private Random random = new Random();
    private Selector selector;
    private ReentrantLock tcpSelectorLock;
    private VhostsService vpnService;

    public TCPOutput(ConcurrentLinkedQueue<Packet> inputQueue, ConcurrentLinkedQueue<ByteBuffer> outputQueue, Selector selector, ReentrantLock tcpSelectorLock, VhostsService vpnService) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        this.selector = selector;
        this.vpnService = vpnService;
        this.tcpSelectorLock = tcpSelectorLock;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogUtils.i(TAG, "Started");
        while (!Thread.interrupted()) {
            try {
                try {
                    try {
                        Packet currentPacket = this.inputQueue.poll();
                        if (currentPacket == null) {
                            Thread.sleep(11L);
                        } else {
                            ByteBuffer payloadBuffer = currentPacket.backingBuffer;
                            currentPacket.backingBuffer = null;
                            ByteBuffer responseBuffer = ByteBufferPool.acquire();
                            InetAddress destinationAddress = currentPacket.ipHeader.destinationAddress;
                            Packet.TCPHeader tcpHeader = currentPacket.tcpHeader;
                            int destinationPort = tcpHeader.destinationPort;
                            int sourcePort = tcpHeader.sourcePort;
                            String ipAndPort = destinationAddress.getHostAddress() + ":" + destinationPort + ":" + sourcePort;
                            TCB tcb = TCB.getTCB(ipAndPort);
                            if (tcb == null) {
                                initializeConnection(ipAndPort, destinationAddress, destinationPort, currentPacket, tcpHeader, responseBuffer);
                            } else if (tcpHeader.isSYN()) {
                                processDuplicateSYN(tcb, tcpHeader, responseBuffer);
                            } else if (tcpHeader.isRST()) {
                                closeCleanly(tcb, responseBuffer);
                            } else if (tcpHeader.isFIN()) {
                                processFIN(tcb, tcpHeader, responseBuffer);
                            } else if (tcpHeader.isACK()) {
                                processACK(tcb, tcpHeader, payloadBuffer, responseBuffer);
                            }
                            if (responseBuffer.position() == 0) {
                                ByteBufferPool.release(responseBuffer);
                            }
                            ByteBufferPool.release(payloadBuffer);
                        }
                    } catch (IOException e) {
                        LogUtils.e(TAG, e.toString(), e);
                    }
                } catch (InterruptedException e2) {
                    LogUtils.i(TAG, "Stopping");
                }
            } finally {
                TCB.closeAll();
            }
        }
    }

    private void initializeConnection(String ipAndPort, InetAddress destinationAddress, int destinationPort, Packet currentPacket, Packet.TCPHeader tcpHeader, ByteBuffer responseBuffer) throws IOException {
        currentPacket.swapSourceAndDestination();
        if (tcpHeader.isSYN()) {
            SocketChannel outputChannel = SocketChannel.open();
            outputChannel.configureBlocking(false);
            this.vpnService.protect(outputChannel.socket());
            TCB tcb = new TCB(ipAndPort, this.random.nextInt(32768), tcpHeader.sequenceNumber, tcpHeader.sequenceNumber + 1, tcpHeader.acknowledgementNumber, outputChannel, currentPacket);
            TCB.putTCB(ipAndPort, tcb);
            try {
            } catch (IOException e) {
                e = e;
            }
            try {
                outputChannel.connect(new InetSocketAddress(destinationAddress, destinationPort));
            } catch (IOException e2) {
                e = e2;
                LogUtils.e(TAG, "Connection error: " + ipAndPort, e);
                currentPacket.updateTCPBuffer(responseBuffer, (byte) 4, 0L, tcb.myAcknowledgementNum, 0);
                TCB.closeTCB(tcb);
            }
            if (outputChannel.finishConnect()) {
                tcb.status = TCB.TCBStatus.SYN_RECEIVED;
                currentPacket.updateTCPBuffer(responseBuffer, (byte) 18, tcb.mySequenceNum, tcb.myAcknowledgementNum, 0);
                tcb.mySequenceNum++;
            } else {
                tcb.status = TCB.TCBStatus.SYN_SENT;
                this.tcpSelectorLock.lock();
                this.selector.wakeup();
                tcb.selectionKey = outputChannel.register(this.selector, 8, tcb);
                this.tcpSelectorLock.unlock();
                return;
            }
        } else {
            currentPacket.updateTCPBuffer(responseBuffer, (byte) 4, 0L, tcpHeader.sequenceNumber + 1, 0);
        }
        this.outputQueue.offer(responseBuffer);
    }

    private void processDuplicateSYN(TCB tcb, Packet.TCPHeader tcpHeader, ByteBuffer responseBuffer) {
        synchronized (tcb) {
            if (tcb.status == TCB.TCBStatus.SYN_SENT) {
                tcb.myAcknowledgementNum = tcpHeader.sequenceNumber + 1;
            } else {
                sendRST(tcb, 1, responseBuffer);
            }
        }
    }

    private void processFIN(TCB tcb, Packet.TCPHeader tcpHeader, ByteBuffer responseBuffer) throws Throwable {
        synchronized (tcb) {
            try {
                Packet referencePacket = tcb.referencePacket;
                tcb.myAcknowledgementNum = tcpHeader.sequenceNumber + 1;
                tcb.theirAcknowledgementNum = tcpHeader.acknowledgementNumber;
                if (tcb.waitingForNetworkData) {
                    tcb.status = TCB.TCBStatus.CLOSE_WAIT;
                    referencePacket.updateTCPBuffer(responseBuffer, (byte) 16, tcb.mySequenceNum, tcb.myAcknowledgementNum, 0);
                } else {
                    tcb.status = TCB.TCBStatus.LAST_ACK;
                    referencePacket.updateTCPBuffer(responseBuffer, (byte) 17, tcb.mySequenceNum, tcb.myAcknowledgementNum, 0);
                    tcb.mySequenceNum++;
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        this.outputQueue.offer(responseBuffer);
    }

    private void processACK(TCB tcb, Packet.TCPHeader tcpHeader, ByteBuffer payloadBuffer, ByteBuffer responseBuffer) throws IOException {
        int payloadSize = payloadBuffer.limit() - payloadBuffer.position();
        synchronized (tcb) {
            try {
                try {
                    SocketChannel outputChannel = tcb.channel;
                    if (tcb.status == TCB.TCBStatus.SYN_RECEIVED) {
                        tcb.status = TCB.TCBStatus.ESTABLISHED;
                        this.tcpSelectorLock.lock();
                        this.selector.wakeup();
                        tcb.selectionKey = outputChannel.register(this.selector, 1, tcb);
                        this.tcpSelectorLock.unlock();
                        tcb.waitingForNetworkData = true;
                    } else if (tcb.status == TCB.TCBStatus.LAST_ACK) {
                        closeCleanly(tcb, responseBuffer);
                        return;
                    }
                    if (payloadSize == 0) {
                        return;
                    }
                    if (!tcb.waitingForNetworkData) {
                        this.selector.wakeup();
                        tcb.selectionKey.interestOps(1);
                        tcb.waitingForNetworkData = true;
                    }
                    while (payloadBuffer.hasRemaining()) {
                        try {
                        } catch (IOException e) {
                            e = e;
                        }
                        try {
                            outputChannel.write(payloadBuffer);
                        } catch (IOException e2) {
                            e = e2;
                            LogUtils.e(TAG, "Network write error: " + tcb.ipAndPort, e);
                            sendRST(tcb, payloadSize, responseBuffer);
                            return;
                        }
                    }
                    tcb.myAcknowledgementNum = tcpHeader.sequenceNumber + ((long) payloadSize);
                    tcb.theirAcknowledgementNum = tcpHeader.acknowledgementNumber;
                    Packet referencePacket = tcb.referencePacket;
                    referencePacket.updateTCPBuffer(responseBuffer, (byte) 16, tcb.mySequenceNum, tcb.myAcknowledgementNum, 0);
                    this.outputQueue.offer(responseBuffer);
                } catch (Throwable th) {
                    e = th;
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                throw e;
            }
        }
    }

    private void sendRST(TCB tcb, int prevPayloadSize, ByteBuffer buffer) {
        tcb.referencePacket.updateTCPBuffer(buffer, (byte) 4, 0L, tcb.myAcknowledgementNum + ((long) prevPayloadSize), 0);
        this.outputQueue.offer(buffer);
        TCB.closeTCB(tcb);
    }

    private void closeCleanly(TCB tcb, ByteBuffer buffer) {
        ByteBufferPool.release(buffer);
        TCB.closeTCB(tcb);
    }
}
