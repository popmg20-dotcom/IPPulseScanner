package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum dq0 implements ca3 {
    REPEATED_FIELD_ENCODING_UNKNOWN(0),
    PACKED(1),
    EXPANDED(2);

    public final int b;

    static {
        ao3.a(5, "RepeatedFieldEncoding");
        values();
    }

    dq0(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
