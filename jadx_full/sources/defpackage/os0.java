package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum os0 implements ca3 {
    VISIBILITY_UNSET(0),
    VISIBILITY_LOCAL(1),
    VISIBILITY_EXPORT(2);

    public final int b;

    static {
        ao3.a(5, "SymbolVisibility");
        values();
    }

    os0(int i) {
        this.b = i;
    }

    public static os0 b(int i) {
        if (i == 0) {
            return VISIBILITY_UNSET;
        }
        if (i == 1) {
            return VISIBILITY_LOCAL;
        }
        if (i != 2) {
            return null;
        }
        return VISIBILITY_EXPORT;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
