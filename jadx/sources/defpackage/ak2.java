package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum ak2 implements ca3 {
    GWP_ASAN(0),
    /* JADX INFO: Fake field, exist only in values array */
    SCUDO(1),
    UNRECOGNIZED(-1);

    public final int b;

    static {
        ao3.a(4, "Tool");
        values();
    }

    ak2(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.b;
        }
        xe.k("Can't get the number of an unknown enum value.");
        return 0;
    }
}
