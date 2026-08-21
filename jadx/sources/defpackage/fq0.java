package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum fq0 implements ca3 {
    DEFAULT_SYMBOL_VISIBILITY_UNKNOWN(0),
    EXPORT_ALL(1),
    EXPORT_TOP_LEVEL(2),
    LOCAL_ALL(3),
    STRICT(4);

    public final int b;

    static {
        ao3.a(5, "DefaultSymbolVisibility");
        values();
    }

    fq0(int i) {
        this.b = i;
    }

    public static fq0 b(int i) {
        if (i == 0) {
            return DEFAULT_SYMBOL_VISIBILITY_UNKNOWN;
        }
        if (i == 1) {
            return EXPORT_ALL;
        }
        if (i == 2) {
            return EXPORT_TOP_LEVEL;
        }
        if (i == 3) {
            return LOCAL_ALL;
        }
        if (i != 4) {
            return null;
        }
        return STRICT;
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
