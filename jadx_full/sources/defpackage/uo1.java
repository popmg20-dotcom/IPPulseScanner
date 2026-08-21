package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uo1 implements l83 {
    public static final k83 b = new k83("DAV:", "getetag");
    public final String a;

    public uo1(String str) {
        if (str != null) {
            if (w44.j0(str, "W/", false) && str.length() >= 3) {
                str = str.substring(2);
            }
            str = yr2.r(str);
        }
        this.a = str;
    }

    public final String toString() {
        String str = this.a;
        return str == null ? "(null)" : str;
    }
}
