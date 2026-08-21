package defpackage;

import io.netty.handler.codec.http.HttpConstants;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oe5 extends IllegalArgumentException {
    public oe5(int i, int i2) {
        super(za5.a(i2, i, HttpConstants.SP, "Unpaired surrogate at index ", " of "));
    }
}
