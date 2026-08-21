package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;
import defpackage.e04;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BrotliOptions implements CompressionOptions {
    static final BrotliOptions DEFAULT = new BrotliOptions(new Encoder.Parameters().setQuality(4).setMode(Encoder.Mode.TEXT));
    private final Encoder.Parameters parameters;

    public BrotliOptions(Encoder.Parameters parameters) {
        if (Brotli.isAvailable()) {
            this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters, "Parameters");
        } else {
            e04.l("Brotli is not available", Brotli.cause());
            throw null;
        }
    }

    public Encoder.Parameters parameters() {
        return this.parameters;
    }
}
