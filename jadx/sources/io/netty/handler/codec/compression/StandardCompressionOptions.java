package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class StandardCompressionOptions {
    private StandardCompressionOptions() {
    }

    public static BrotliOptions brotli(Encoder.Parameters parameters) {
        return new BrotliOptions(parameters);
    }

    public static DeflateOptions deflate(int i, int i2, int i3) {
        return new DeflateOptions(i, i2, i3);
    }

    public static GzipOptions gzip(int i, int i2, int i3) {
        return new GzipOptions(i, i2, i3);
    }

    public static ZstdOptions zstd(int i, int i2, int i3) {
        return new ZstdOptions(i, i2, i3);
    }

    public static BrotliOptions brotli() {
        return BrotliOptions.DEFAULT;
    }

    public static DeflateOptions deflate() {
        return DeflateOptions.DEFAULT;
    }

    public static GzipOptions gzip() {
        return GzipOptions.DEFAULT;
    }

    public static ZstdOptions zstd() {
        return ZstdOptions.DEFAULT;
    }
}
