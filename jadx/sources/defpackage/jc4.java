package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jc4 implements CharSequence {
    public s01 A;
    public final CharSequence b;
    public final int f;
    public final int z;

    public jc4(CharSequence charSequence, int i, int i2) {
        this.b = charSequence;
        this.f = i;
        this.z = i2;
        if (i > i2) {
            xe.k("start > end");
            throw null;
        }
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 > charSequence.length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    public final void a() {
        s01 s01Var = this.A;
        if (s01Var != null) {
            if (s01Var.Z.H0 != s01Var.X || s01Var.Y) {
                throw new s80();
            }
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        a();
        return this.b.charAt(this.f + i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        a();
        return this.z - this.f;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 >= length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        a();
        int i3 = this.f;
        jc4 jc4Var = new jc4(this.b, i + i3, i3 + i2);
        jc4Var.A = this.A;
        return jc4Var;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.b.subSequence(this.f, this.z).toString();
    }
}
