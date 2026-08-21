package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ol0 extends cu2 {
    public static final ol0 A;
    public final String z;
    public final int f = 2;
    public final char[] b = new char[32];

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable unused) {
            property = "\n";
        }
        A = new ol0(property);
    }

    public ol0(String str) {
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            "  ".getChars(0, 2, this.b, i);
            i += 2;
        }
        this.z = str;
    }

    @Override // defpackage.cu2
    public final void c0(dy4 dy4Var, int i) throws g52 {
        dy4Var.n0(this.z);
        if (i <= 0) {
            return;
        }
        int length = i * this.f;
        while (true) {
            char[] cArr = this.b;
            if (length <= cArr.length) {
                dy4Var.Z0(cArr, length);
                return;
            } else {
                dy4Var.Z0(cArr, cArr.length);
                length -= cArr.length;
            }
        }
    }
}
