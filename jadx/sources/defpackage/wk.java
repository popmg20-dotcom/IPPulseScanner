package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wk {
    public final String a;
    public final int b;
    public final int c;
    public final boolean d;
    public String e;

    public wk(String str, int i, int i2, boolean z) {
        this.a = str;
        this.c = i;
        this.b = i2;
        byte[] bArr = new byte[i2];
        this.d = z;
    }

    public final String toString() {
        String str;
        synchronized (this) {
            try {
                str = this.e;
                if (str == null) {
                    str = wk.class.getSimpleName() + "[" + this.a + "] -  block=" + this.c + "/" + this.b + " bytes, encrypt-then-mac=" + this.d;
                    this.e = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
