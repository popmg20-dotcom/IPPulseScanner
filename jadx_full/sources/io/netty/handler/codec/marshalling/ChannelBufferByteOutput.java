package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    public ChannelBufferByteOutput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public ByteBuf getBuffer() {
        return this.buffer;
    }

    public void write(int i) {
        this.buffer.writeByte(i);
    }

    public void write(byte[] bArr) {
        this.buffer.writeBytes(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.buffer.writeBytes(bArr, i, i2);
    }

    public void close() {
    }

    public void flush() {
    }
}
