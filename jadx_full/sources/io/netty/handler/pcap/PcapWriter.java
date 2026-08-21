package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class PcapWriter implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriter.class);
    private boolean isClosed;
    private final OutputStream outputStream;

    public PcapWriter(OutputStream outputStream, ByteBuf byteBuf) {
        this.outputStream = outputStream;
        PcapHeaders.writeGlobalHeader(byteBuf);
        byteBuf.readBytes(outputStream, byteBuf.readableBytes());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed) {
            logger.debug("PcapWriter is already closed");
            return;
        }
        this.isClosed = true;
        this.outputStream.flush();
        this.outputStream.close();
        logger.debug("PcapWriter is now closed");
    }

    public void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (this.isClosed) {
            logger.debug("Pcap Write attempted on closed PcapWriter");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        PcapHeaders.writePacketHeader(byteBuf, (int) (jCurrentTimeMillis / 1000), (int) ((jCurrentTimeMillis % 1000) * 1000), byteBuf2.readableBytes(), byteBuf2.readableBytes());
        byteBuf.readBytes(this.outputStream, byteBuf.readableBytes());
        byteBuf2.readBytes(this.outputStream, byteBuf2.readableBytes());
    }

    public PcapWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
