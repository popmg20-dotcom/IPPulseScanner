package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cl3 {
    public static final cl3 d = new cl3(0, false, false);
    public static final cl3 e = new cl3(500, true, false);
    public static final cl3 f;
    public final long a;
    public final boolean b;
    public final boolean c;

    static {
        new cl3(100L, true, false);
        f = new cl3(0L, false, true);
    }

    public cl3(long j, boolean z, boolean z2) {
        this.b = z;
        this.a = j;
        if (z2) {
            r25.f(!z, "shouldRetry must be false when completeWithoutFailure is set to true");
        }
        this.c = z2;
    }
}
