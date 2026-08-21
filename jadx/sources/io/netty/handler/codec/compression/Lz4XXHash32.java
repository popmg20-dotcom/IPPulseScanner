package io.netty.handler.codec.compression;

import defpackage.st4;
import io.netty.buffer.ByteBuf;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Lz4XXHash32 extends ByteBufChecksum {
    private static final XXHash32 XXHASH32 = XXHashFactory.fastestInstance().hash32();
    private final int seed;
    private boolean used;
    private int value;

    public Lz4XXHash32(int i) {
        this.seed = i;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        if (this.used) {
            return ((long) this.value) & 268435455;
        }
        st4.g();
        return 0L;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.used = false;
    }

    @Override // io.netty.handler.codec.compression.ByteBufChecksum
    public void update(ByteBuf byteBuf, int i, int i2) {
        if (this.used) {
            st4.g();
            return;
        }
        if (byteBuf.hasArray()) {
            this.value = XXHASH32.hash(byteBuf.array(), byteBuf.arrayOffset() + i, i2, this.seed);
        } else {
            this.value = XXHASH32.hash(CompressionUtil.safeNioBuffer(byteBuf, i, i2), this.seed);
        }
        this.used = true;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        if (!this.used) {
            this.value = XXHASH32.hash(bArr, i, i2, this.seed);
            this.used = true;
        } else {
            st4.g();
        }
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        throw new UnsupportedOperationException();
    }
}
