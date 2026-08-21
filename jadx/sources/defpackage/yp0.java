package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum yp0 implements ca3 {
    ENFORCE_NAMING_STYLE_UNKNOWN(0),
    STYLE2024(1),
    STYLE_LEGACY(2);

    public final int b;

    static {
        ao3.a(5, "EnforceNamingStyle");
        values();
    }

    yp0(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
