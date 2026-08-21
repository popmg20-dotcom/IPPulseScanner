package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum up0 implements ca3 {
    DECLARATION(0),
    UNVERIFIED(1);

    public final int b;

    static {
        ao3.a(5, "VerificationState");
        values();
    }

    up0(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
