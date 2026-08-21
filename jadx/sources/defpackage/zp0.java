package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum zp0 implements ca3 {
    ENUM_TYPE_UNKNOWN(0),
    OPEN(1),
    CLOSED(2);

    public final int b;

    static {
        ao3.a(5, "EnumType");
        values();
    }

    zp0(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
