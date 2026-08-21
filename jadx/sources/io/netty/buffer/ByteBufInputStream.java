package io.netty.buffer;

import defpackage.dw2;
import defpackage.s53;
import defpackage.zo2;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private StringBuilder lineBuf;
    private final boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf, int i, boolean z) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        if (i < 0) {
            if (z) {
                byteBuf.release();
            }
            ObjectUtil.checkPositiveOrZero(i, "length");
        }
        if (i > byteBuf.readableBytes()) {
            if (z) {
                byteBuf.release();
            }
            zo2.j(byteBuf.readableBytes(), dw2.D("Too many bytes to be read - Needs ", i, ", maximum is "));
            throw null;
        }
        this.releaseOnClose = z;
        this.buffer = byteBuf;
        int i2 = byteBuf.readerIndex();
        this.startIndex = i2;
        this.endIndex = i2 + i;
        byteBuf.markReaderIndex();
    }

    private void checkAvailable(int i) throws EOFException {
        if (i < 0) {
            s53.k("fieldSize cannot be a negative number");
        } else {
            if (i <= available()) {
                return;
            }
            StringBuilder sbD = dw2.D("fieldSize is too long! Length is ", i, ", but maximum is ");
            sbD.append(available());
            throw new EOFException(sbD.toString());
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } finally {
            if (this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.buffer.markReaderIndex();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int iAvailable = available();
        if (iAvailable == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i2);
        this.buffer.readBytes(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws EOFException {
        checkAvailable(1);
        return read() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() throws EOFException {
        if (available() != 0) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws EOFException {
        checkAvailable(i2);
        this.buffer.readBytes(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() throws EOFException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        int iAvailable = available();
        if (iAvailable == 0) {
            return null;
        }
        StringBuilder sb = this.lineBuf;
        if (sb != null) {
            sb.setLength(0);
        }
        while (true) {
            short unsignedByte = this.buffer.readUnsignedByte();
            iAvailable--;
            if (unsignedByte == 10) {
                break;
            }
            if (unsignedByte != 13) {
                StringBuilder sb2 = this.lineBuf;
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                    this.lineBuf = sb2;
                }
                sb2.append((char) unsignedByte);
                if (iAvailable <= 0) {
                    break;
                }
            } else if (iAvailable > 0) {
                ByteBuf byteBuf = this.buffer;
                if (((char) byteBuf.getUnsignedByte(byteBuf.readerIndex())) == '\n') {
                    this.buffer.skipBytes(1);
                }
            }
        }
        StringBuilder sb3 = this.lineBuf;
        return (sb3 == null || sb3.length() <= 0) ? "" : this.lineBuf.toString();
    }

    @Override // java.io.DataInput
    public long readLong() throws EOFException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws EOFException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.buffer.resetReaderIndex();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return j > 2147483647L ? skipBytes(ChannelUtils.WRITE_STATUS_SNDBUF_FULL) : skipBytes((int) j);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        int iMin = Math.min(available(), i);
        this.buffer.skipBytes(iMin);
        return iMin;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws EOFException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() == 0) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i) {
        this(byteBuf, i, false);
    }

    public ByteBufInputStream(ByteBuf byteBuf, boolean z) {
        this(byteBuf, byteBuf.readableBytes(), z);
    }

    public ByteBufInputStream(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readableBytes());
    }
}
