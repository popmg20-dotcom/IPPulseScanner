package io.netty.handler.codec.marshalling;

import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class LimitingByteInput implements ByteInput {
    private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
    private final ByteInput input;
    private final long limit;
    private long read;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class TooBigObjectException extends IOException {
        private static final long serialVersionUID = 1;
    }

    public LimitingByteInput(ByteInput byteInput, long j) {
        this.input = byteInput;
        this.limit = ObjectUtil.checkPositive(j, "limit");
    }

    private int readable(int i) {
        return (int) Math.min(i, this.limit - this.read);
    }

    public int available() {
        return readable(this.input.available());
    }

    public int read() throws TooBigObjectException {
        if (readable(1) <= 0) {
            throw EXCEPTION;
        }
        int i = this.input.read();
        this.read++;
        return i;
    }

    public long skip(long j) throws TooBigObjectException {
        int i = readable((int) j);
        if (i <= 0) {
            throw EXCEPTION;
        }
        long jSkip = this.input.skip(i);
        this.read += jSkip;
        return jSkip;
    }

    public void close() {
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws TooBigObjectException {
        int i3 = readable(i2);
        if (i3 > 0) {
            int i4 = this.input.read(bArr, i, i3);
            this.read += (long) i4;
            return i4;
        }
        throw EXCEPTION;
    }
}
