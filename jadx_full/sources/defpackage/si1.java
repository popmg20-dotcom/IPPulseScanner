package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class si1 {
    public static final si1 d = new si1("", "", false);
    public final String a;
    public final String b;
    public final boolean c;

    static {
        new si1("\n", "  ", true);
    }

    public si1(String str, String str2, boolean z) {
        if (!str.matches("[\r\n]*")) {
            xe.k("Only combinations of \\n and \\r are allowed in newline.");
            throw null;
        }
        if (!str2.matches("[ \t]*")) {
            xe.k("Only combinations of spaces and tabs are allowed in indent.");
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = z;
    }
}
