package io.netty.handler.codec.compression;

import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;
    private ByteBuf in;

    public boolean hasReadableBits(int i) {
        if (i >= 0) {
            return this.bitCount >= i || ((this.in.readableBytes() << 3) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL) >= i - this.bitCount;
        }
        xe.k(ha0.k("count: ", i, " (expected value greater than 0)"));
        return false;
    }

    public boolean hasReadableBytes(int i) {
        if (i >= 0 && i <= MAX_COUNT_OF_READABLE_BYTES) {
            return hasReadableBits(i << 3);
        }
        xe.k(ha0.k("count: ", i, " (expected: 0-268435455)"));
        return false;
    }

    public boolean isReadable() {
        return this.bitCount > 0 || this.in.isReadable();
    }

    public int readBits(int i) {
        long unsignedByte;
        int i2;
        if (i < 0 || i > 32) {
            xe.k(ha0.k("count: ", i, " (expected: 0-32 )"));
            return 0;
        }
        int i3 = this.bitCount;
        long j = this.bitBuffer;
        if (i3 < i) {
            int i4 = this.in.readableBytes();
            if (i4 == 1) {
                unsignedByte = this.in.readUnsignedByte();
                i2 = 8;
            } else if (i4 != 2) {
                ByteBuf byteBuf = this.in;
                if (i4 != 3) {
                    unsignedByte = byteBuf.readUnsignedInt();
                    i2 = 32;
                } else {
                    unsignedByte = byteBuf.readUnsignedMedium();
                    i2 = 24;
                }
            } else {
                unsignedByte = this.in.readUnsignedShort();
                i2 = 16;
            }
            j = (j << i2) | unsignedByte;
            i3 += i2;
            this.bitBuffer = j;
        }
        int i5 = i3 - i;
        this.bitCount = i5;
        return (int) ((i != 32 ? (1 << i) - 1 : 4294967295L) & (j >>> i5));
    }

    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    public int readInt() {
        return readBits(32);
    }

    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | ((long) this.in.readUnsignedByte());
        this.bitCount += 8;
    }

    public void setByteBuf(ByteBuf byteBuf) {
        this.in = byteBuf;
    }
}
