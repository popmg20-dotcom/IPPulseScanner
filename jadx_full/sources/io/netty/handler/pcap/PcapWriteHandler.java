package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.pcap.TCPPacket;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class PcapWriteHandler extends ChannelDuplexHandler implements Closeable {
    private final boolean captureZeroByte;
    private ChannelType channelType;
    private InetSocketAddress handlerAddr;
    private boolean initialized;
    private InetSocketAddress initiatiorAddr;
    private boolean isClosed;
    private boolean isServerPipeline;
    private final InternalLogger logger;
    private final OutputStream outputStream;
    private PcapWriter pCapWriter;
    private int receiveSegmentNumber;
    private int sendSegmentNumber;
    private final boolean writePcapGlobalHeader;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Builder {
        private boolean captureZeroByte;
        private ChannelType channelType;
        private InetSocketAddress handlerAddr;
        private InetSocketAddress initiatiorAddr;
        private boolean isServerPipeline;
        private boolean writePcapGlobalHeader;

        private Builder() {
            this.writePcapGlobalHeader = true;
        }

        public PcapWriteHandler build(OutputStream outputStream) {
            ObjectUtil.checkNotNull(outputStream, "outputStream");
            return new PcapWriteHandler(this, outputStream);
        }

        public Builder captureZeroByte(boolean z) {
            this.captureZeroByte = z;
            return this;
        }

        public Builder forceTcpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z) {
            this.channelType = ChannelType.TCP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "serverAddress");
            this.initiatiorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "clientAddress");
            this.isServerPipeline = z;
            return this;
        }

        public Builder forceUdpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            this.channelType = ChannelType.UDP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "remoteAddress");
            this.initiatiorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "localAddress");
            return this;
        }

        public Builder writePcapGlobalHeader(boolean z) {
            this.writePcapGlobalHeader = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum ChannelType {
        TCP,
        UDP
    }

    private PcapWriteHandler(Builder builder, OutputStream outputStream) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.outputStream = outputStream;
        this.captureZeroByte = builder.captureZeroByte;
        this.writePcapGlobalHeader = builder.writePcapGlobalHeader;
        this.channelType = builder.channelType;
        this.handlerAddr = builder.handlerAddr;
        this.initiatiorAddr = builder.initiatiorAddr;
        this.isServerPipeline = builder.isServerPipeline;
    }

    public static Builder builder() {
        return new Builder();
    }

    private void completeTCPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer2 = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer3 = byteBufAllocator.buffer();
        try {
            try {
            } catch (IOException e) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e);
                channelHandlerContext.fireExceptionCaught((Throwable) e);
            }
            if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                IPPacket.writeTCPv4(byteBufBuffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                EthernetPacket.writeIPv4(byteBufBuffer2, byteBufBuffer);
            } else {
                if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                    byteBufBuffer.release();
                    byteBufBuffer2.release();
                    byteBufBuffer3.release();
                }
                IPPacket.writeTCPv6(byteBufBuffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                EthernetPacket.writeIPv6(byteBufBuffer2, byteBufBuffer);
            }
            this.pCapWriter.writePacket(byteBufBuffer3, byteBufBuffer2);
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
        } catch (Throwable th) {
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
            throw th;
        }
    }

    private void completeUDPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer2 = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer3 = byteBufAllocator.buffer();
        try {
            try {
            } catch (IOException e) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e);
                channelHandlerContext.fireExceptionCaught((Throwable) e);
            }
            if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                IPPacket.writeUDPv4(byteBufBuffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                EthernetPacket.writeIPv4(byteBufBuffer2, byteBufBuffer);
            } else {
                if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                    byteBufBuffer.release();
                    byteBufBuffer2.release();
                    byteBufBuffer3.release();
                }
                IPPacket.writeUDPv6(byteBufBuffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                EthernetPacket.writeIPv6(byteBufBuffer2, byteBufBuffer);
            }
            this.pCapWriter.writePacket(byteBufBuffer3, byteBufBuffer2);
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
        } catch (Throwable th) {
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [io.netty.util.ReferenceCounted] */
    private void handleTCP(ChannelHandlerContext channelHandlerContext, Object obj, boolean z) throws Throwable {
        ?? r8;
        InetSocketAddress inetSocketAddress;
        InetSocketAddress inetSocketAddress2;
        ByteBuf byteBuf;
        ?? r7;
        InetSocketAddress inetSocketAddress3;
        InetSocketAddress inetSocketAddress4;
        InetSocketAddress inetSocketAddress5;
        if (!(obj instanceof ByteBuf)) {
            this.logger.debug("Discarding Pcap Write for TCP Object: {}", obj);
            return;
        }
        ByteBuf byteBuf2 = (ByteBuf) obj;
        if (byteBuf2.readableBytes() == 0 && !this.captureZeroByte) {
            this.logger.debug("Discarding Zero Byte TCP Packet. isWriteOperation {}", Boolean.valueOf(z));
            return;
        }
        ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
        ByteBuf byteBufDuplicate = byteBuf2.duplicate();
        ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
        int i = byteBufDuplicate.readableBytes();
        boolean z2 = this.isServerPipeline;
        try {
            try {
                try {
                    try {
                        if (z) {
                            if (z2) {
                                inetSocketAddress4 = this.handlerAddr;
                                inetSocketAddress5 = this.initiatiorAddr;
                            } else {
                                inetSocketAddress4 = this.initiatiorAddr;
                                inetSocketAddress5 = this.handlerAddr;
                            }
                            int i2 = this.sendSegmentNumber;
                            int i3 = this.receiveSegmentNumber;
                            int port = inetSocketAddress4.getPort();
                            int port2 = inetSocketAddress5.getPort();
                            TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.ACK;
                            TCPPacket.writePacket(byteBufBuffer, byteBufDuplicate, i2, i3, port, port2, tCPFlag);
                            completeTCPWrite(inetSocketAddress4, inetSocketAddress5, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            InetSocketAddress inetSocketAddress6 = inetSocketAddress4;
                            InetSocketAddress inetSocketAddress7 = inetSocketAddress5;
                            logTCP(true, i, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress6, inetSocketAddress7, false);
                            int i4 = this.sendSegmentNumber + i;
                            this.sendSegmentNumber = i4;
                            TCPPacket.writePacket(byteBufBuffer, null, this.receiveSegmentNumber, i4, inetSocketAddress7.getPort(), inetSocketAddress6.getPort(), tCPFlag);
                            completeTCPWrite(inetSocketAddress7, inetSocketAddress6, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            byteBuf = byteBufBuffer;
                            r7 = 1;
                            inetSocketAddress3 = inetSocketAddress7;
                            logTCP(true, i, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress3, inetSocketAddress6, true);
                        } else {
                            if (z2) {
                                inetSocketAddress = this.initiatiorAddr;
                                inetSocketAddress2 = this.handlerAddr;
                            } else {
                                inetSocketAddress = this.handlerAddr;
                                inetSocketAddress2 = this.initiatiorAddr;
                            }
                            int i5 = this.receiveSegmentNumber;
                            int i6 = this.sendSegmentNumber;
                            int port3 = inetSocketAddress.getPort();
                            int port4 = inetSocketAddress2.getPort();
                            TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                            TCPPacket.writePacket(byteBufBuffer, byteBufDuplicate, i5, i6, port3, port4, tCPFlag2);
                            completeTCPWrite(inetSocketAddress, inetSocketAddress2, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            InetSocketAddress inetSocketAddress8 = inetSocketAddress;
                            InetSocketAddress inetSocketAddress9 = inetSocketAddress2;
                            logTCP(false, i, this.receiveSegmentNumber, this.sendSegmentNumber, inetSocketAddress8, inetSocketAddress9, false);
                            int i7 = this.receiveSegmentNumber + i;
                            this.receiveSegmentNumber = i7;
                            TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber, i7, inetSocketAddress9.getPort(), inetSocketAddress8.getPort(), tCPFlag2);
                            completeTCPWrite(inetSocketAddress9, inetSocketAddress8, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                            byteBuf = byteBufBuffer;
                            r7 = 1;
                            inetSocketAddress3 = inetSocketAddress9;
                            logTCP(false, i, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress3, inetSocketAddress8, true);
                        }
                        byteBuf.release();
                    } catch (Throwable th) {
                        th = th;
                        r8.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r8 = r7;
                    r8.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r8 = inetSocketAddress3;
                r8.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r8 = byteBufBuffer;
            r8.release();
            throw th;
        }
    }

    private void handleUDP(ChannelHandlerContext channelHandlerContext, Object obj) {
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
        try {
            if (obj instanceof DatagramPacket) {
                if (((DatagramPacket) obj).content().readableBytes() == 0 && !this.captureZeroByte) {
                    this.logger.debug("Discarding Zero Byte UDP Packet");
                    byteBufBuffer.release();
                    return;
                }
                DatagramPacket datagramPacketDuplicate = ((DatagramPacket) obj).duplicate();
                InetSocketAddress inetSocketAddressSender = datagramPacketDuplicate.sender();
                InetSocketAddress inetSocketAddressRecipient = datagramPacketDuplicate.recipient();
                if (inetSocketAddressSender == null) {
                    inetSocketAddressSender = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                }
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(datagramPacketDuplicate.content().readableBytes()), inetSocketAddressSender, inetSocketAddressRecipient);
                UDPPacket.writePacket(byteBufBuffer, datagramPacketDuplicate.content(), inetSocketAddressSender.getPort(), inetSocketAddressRecipient.getPort());
                completeUDPWrite(inetSocketAddressSender, inetSocketAddressRecipient, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
            } else if (!(obj instanceof ByteBuf) || ((channelHandlerContext.channel() instanceof DatagramChannel) && !((DatagramChannel) channelHandlerContext.channel()).isConnected())) {
                this.logger.debug("Discarding Pcap Write for UDP Object: {}", obj);
            } else if (((ByteBuf) obj).readableBytes() == 0 && !this.captureZeroByte) {
                this.logger.debug("Discarding Zero Byte UDP Packet");
                byteBufBuffer.release();
                return;
            } else {
                ByteBuf byteBufDuplicate = ((ByteBuf) obj).duplicate();
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(byteBufDuplicate.readableBytes()), this.initiatiorAddr, this.handlerAddr);
                UDPPacket.writePacket(byteBufBuffer, byteBufDuplicate, this.initiatiorAddr.getPort(), this.handlerAddr.getPort());
                completeUDPWrite(this.initiatiorAddr, this.handlerAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
            }
            byteBufBuffer.release();
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    private void initializeIfNecessary(ChannelHandlerContext channelHandlerContext) throws Throwable {
        ChannelHandlerContext channelHandlerContext2;
        int port;
        int port2;
        TCPPacket.TCPFlag tCPFlag;
        ByteBuf byteBuf;
        if (this.initialized) {
            return;
        }
        ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
        if (this.writePcapGlobalHeader) {
            ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
            try {
                try {
                    this.pCapWriter = new PcapWriter(this.outputStream, byteBufBuffer);
                    byteBufBuffer.release();
                    channelHandlerContext2 = channelHandlerContext;
                } catch (IOException e) {
                    channelHandlerContext.channel().close();
                    channelHandlerContext2 = channelHandlerContext;
                    channelHandlerContext2.fireExceptionCaught((Throwable) e);
                    this.logger.error("Caught Exception While Initializing PcapWriter, Closing Channel.", (Throwable) e);
                    byteBufBuffer.release();
                }
            } catch (Throwable th) {
                byteBufBuffer.release();
                throw th;
            }
        } else {
            channelHandlerContext2 = channelHandlerContext;
            this.pCapWriter = new PcapWriter(this.outputStream);
        }
        if (this.channelType == null) {
            if (channelHandlerContext2.channel() instanceof SocketChannel) {
                this.channelType = ChannelType.TCP;
                if (channelHandlerContext2.channel().parent() instanceof ServerSocketChannel) {
                    this.isServerPipeline = true;
                    this.initiatiorAddr = (InetSocketAddress) channelHandlerContext2.channel().remoteAddress();
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext2.channel().localAddress();
                } else {
                    this.isServerPipeline = false;
                    this.initiatiorAddr = (InetSocketAddress) channelHandlerContext2.channel().localAddress();
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext2.channel().remoteAddress();
                }
            } else if (channelHandlerContext2.channel() instanceof DatagramChannel) {
                this.channelType = ChannelType.UDP;
                if (((DatagramChannel) channelHandlerContext2.channel()).isConnected()) {
                    this.initiatiorAddr = (InetSocketAddress) channelHandlerContext2.channel().localAddress();
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext2.channel().remoteAddress();
                }
            }
        }
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Initiating Fake TCP 3-Way Handshake");
            ByteBuf byteBufBuffer2 = byteBufAllocatorAlloc.buffer();
            try {
                port = this.initiatiorAddr.getPort();
                port2 = this.handlerAddr.getPort();
                tCPFlag = TCPPacket.TCPFlag.SYN;
                byteBuf = byteBufBuffer2;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                TCPPacket.writePacket(byteBuf, null, 0, 0, port, port2, tCPFlag);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, byteBufBuffer2, byteBufAllocatorAlloc, channelHandlerContext2);
                int port3 = this.handlerAddr.getPort();
                int port4 = this.initiatiorAddr.getPort();
                TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(byteBufBuffer2, null, 0, 1, port3, port4, tCPFlag, tCPFlag2);
                completeTCPWrite(this.handlerAddr, this.initiatiorAddr, byteBufBuffer2, byteBufAllocatorAlloc, channelHandlerContext);
                byteBuf = byteBufBuffer2;
                TCPPacket.writePacket(byteBuf, null, 1, 1, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, byteBufBuffer2, byteBufAllocatorAlloc, channelHandlerContext);
                byteBufBuffer2.release();
                this.logger.debug("Finished Fake TCP 3-Way Handshake");
            } catch (Throwable th3) {
                th = th3;
                byteBufBuffer2 = byteBuf;
                byteBufBuffer2.release();
                throw th;
            }
        }
        this.initialized = true;
    }

    private void logDiscard() {
        this.logger.warn("Discarding pcap write because channel type is unknown. The channel this handler is registered on is not a SocketChannel or DatagramChannel, so the inference does not work. Please call forceTcpChannel or forceUdpChannel before registering the handler.");
    }

    private void logTCP(boolean z, int i, int i2, int i3, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z2) {
        if (this.logger.isDebugEnabled()) {
            InternalLogger internalLogger = this.logger;
            if (z2) {
                internalLogger.debug("Writing TCP ACK, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), inetSocketAddress2, inetSocketAddress);
            } else {
                internalLogger.debug("Writing TCP Data of {} Bytes, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), inetSocketAddress, inetSocketAddress2);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Throwable {
        initializeIfNecessary(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Throwable {
        if (!this.isClosed) {
            initializeIfNecessary(channelHandlerContext);
            ChannelType channelType = this.channelType;
            if (channelType == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, false);
            } else if (channelType == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed) {
            this.logger.debug("PcapWriterHandler is already closed");
            return;
        }
        this.isClosed = true;
        this.pCapWriter.close();
        this.logger.debug("PcapWriterHandler is now closed");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Throwable {
        PcapWriteHandler pcapWriteHandler;
        ChannelHandlerContext channelHandlerContext2;
        ByteBuf byteBuf;
        if (this.channelType == ChannelType.TCP) {
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
            try {
                TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.RST, TCPPacket.TCPFlag.ACK);
                channelHandlerContext2 = channelHandlerContext;
                byteBuf = byteBufBuffer;
                pcapWriteHandler = this;
                try {
                    pcapWriteHandler.completeTCPWrite(this.initiatiorAddr, this.handlerAddr, byteBuf, channelHandlerContext.alloc(), channelHandlerContext2);
                    byteBuf.release();
                    pcapWriteHandler.logger.debug("Sent Fake TCP RST to close connection");
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    byteBuf.release();
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
                byteBuf = byteBufBuffer;
            }
        } else {
            pcapWriteHandler = this;
            channelHandlerContext2 = channelHandlerContext;
        }
        pcapWriteHandler.close();
        channelHandlerContext2.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Throwable {
        int i;
        int i2;
        int port;
        int port2;
        TCPPacket.TCPFlag tCPFlag;
        TCPPacket.TCPFlag tCPFlag2;
        ByteBuf byteBuf;
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Starting Fake TCP FIN+ACK Flow to close connection");
            ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
            ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
            try {
                i = this.sendSegmentNumber;
                i2 = this.receiveSegmentNumber;
                port = this.initiatiorAddr.getPort();
                port2 = this.handlerAddr.getPort();
                tCPFlag = TCPPacket.TCPFlag.FIN;
                tCPFlag2 = TCPPacket.TCPFlag.ACK;
                byteBuf = byteBufBuffer;
            } catch (Throwable th) {
                th = th;
            }
            try {
                TCPPacket.writePacket(byteBuf, null, i, i2, port, port2, tCPFlag, tCPFlag2);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                TCPPacket.writePacket(byteBufBuffer, null, this.receiveSegmentNumber, this.sendSegmentNumber, this.handlerAddr.getPort(), this.initiatiorAddr.getPort(), tCPFlag, tCPFlag2);
                completeTCPWrite(this.handlerAddr, this.initiatiorAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                byteBuf = byteBufBuffer;
                TCPPacket.writePacket(byteBuf, null, this.sendSegmentNumber + 1, this.receiveSegmentNumber + 1, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                byteBufBuffer.release();
                this.logger.debug("Finished Fake TCP FIN+ACK Flow to close connection");
            } catch (Throwable th2) {
                th = th2;
                byteBufBuffer = byteBuf;
                byteBufBuffer.release();
                throw th;
            }
        }
        close();
        super.handlerRemoved(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Throwable {
        if (!this.isClosed) {
            initializeIfNecessary(channelHandlerContext);
            ChannelType channelType = this.channelType;
            if (channelType == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, true);
            } else if (channelType == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream) {
        this(outputStream, false, true);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream, boolean z, boolean z2) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.outputStream = (OutputStream) ObjectUtil.checkNotNull(outputStream, "OutputStream");
        this.captureZeroByte = z;
        this.writePcapGlobalHeader = z2;
    }
}
