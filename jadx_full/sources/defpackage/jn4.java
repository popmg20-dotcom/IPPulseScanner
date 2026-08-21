package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jn4 {
    public final tt3 a;
    public final mn4 b;
    public final ih c;
    public final List d;
    public boolean e = false;
    public boolean f = false;

    public jn4(tt3 tt3Var, mn4 mn4Var, ih ihVar, List list) {
        this.a = tt3Var;
        this.b = mn4Var;
        this.c = ihVar;
        this.d = list;
    }

    public final String toString() {
        return "UseCaseAttachInfo{mSessionConfig=" + this.a + ", mUseCaseConfig=" + this.b + ", mStreamSpec=" + this.c + ", mCaptureTypes=" + this.d + ", mAttached=" + this.e + ", mActive=" + this.f + '}';
    }
}
