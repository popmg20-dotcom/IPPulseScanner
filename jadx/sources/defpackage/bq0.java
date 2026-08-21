package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum bq0 implements ca3 {
    JSON_FORMAT_UNKNOWN(0),
    ALLOW(1),
    LEGACY_BEST_EFFORT(2);

    public final int b;

    static {
        ao3.a(5, "JsonFormat");
        values();
    }

    bq0(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
