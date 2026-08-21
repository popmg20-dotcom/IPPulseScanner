package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g44 implements CharSequence {
    public char[] b;
    public String f;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.b[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.b.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new String(this.b, i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.b);
        this.f = str2;
        return str2;
    }
}
