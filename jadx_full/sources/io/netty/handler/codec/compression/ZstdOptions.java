package io.netty.handler.codec.compression;

import defpackage.e04;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ZstdOptions implements CompressionOptions {
    static final ZstdOptions DEFAULT = new ZstdOptions(3, 65536, 33554432);
    private final int blockSize;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdOptions(int i, int i2, int i3) {
        if (!Zstd.isAvailable()) {
            e04.l("zstd-jni is not available", Zstd.cause());
            throw null;
        }
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i2, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i3, "maxEncodeSize");
    }

    public int blockSize() {
        return this.blockSize;
    }

    public int compressionLevel() {
        return this.compressionLevel;
    }

    public int maxEncodeSize() {
        return this.maxEncodeSize;
    }
}
