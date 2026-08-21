package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {
    public static final p1 c;
    public static final p1 d;
    public final boolean a;
    public final Throwable b;

    static {
        if (x1.A) {
            d = null;
            c = null;
        } else {
            d = new p1(null, false);
            c = new p1(null, true);
        }
    }

    public p1(Throwable th, boolean z) {
        this.a = z;
        this.b = th;
    }
}
