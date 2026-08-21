package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum pa2 {
    NONE(""),
    LF("\n"),
    CR("\r"),
    CRLF("\r\n");

    public final String b;
    public final int f;

    pa2(String str) {
        this.b = str;
        this.f = str.length();
        str.toCharArray();
    }
}
