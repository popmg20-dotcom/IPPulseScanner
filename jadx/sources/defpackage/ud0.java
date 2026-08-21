package defpackage;

import android.text.GetChars;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ud0 implements CharSequence, GetChars, Cloneable {
    public pa2 A;
    public char[] b;
    public int f;
    public int z;

    public ud0(ud0 ud0Var) {
        this(ud0Var.f + 16);
        int i = ud0Var.f;
        this.f = i;
        this.z = ud0Var.z;
        this.A = ud0Var.A;
        System.arraycopy(ud0Var.b, 0, this.b, 0, i);
    }

    public final void a(int i) {
        if (i < 0 || i > this.f) {
            StringBuilder sbD = dw2.D("index = ", i, ", length = ");
            sbD.append(this.f);
            throw new StringIndexOutOfBoundsException(sbD.toString());
        }
    }

    public final void b(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i3 = this.f;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException();
        }
        int i4 = i2 - i;
        if (i4 <= 0) {
            return;
        }
        int i5 = i;
        while (true) {
            char[] cArr = this.b;
            if (i5 >= i2) {
                System.arraycopy(cArr, i + i4, cArr, i, this.f - i2);
                this.f -= i4;
                return;
            } else {
                if (ji0.j(cArr[i5])) {
                    this.z--;
                }
                i5++;
            }
        }
    }

    public final void c(int i) {
        char[] cArr = this.b;
        if (cArr.length < i) {
            char[] cArr2 = new char[cArr.length * 2 < i ? i + 2 : cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, this.f);
            this.b = cArr2;
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (i < this.f) {
            return this.b[i];
        }
        if (d().f > 0) {
            return d().b.charAt(i - this.f);
        }
        return '\n';
    }

    public final pa2 d() {
        pa2 pa2Var = this.A;
        return pa2Var == null ? pa2.NONE : pa2Var;
    }

    public final void e(int i, int i2, int i3, CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "null";
        }
        if (i < 0 || i > this.f) {
            s53.k(dw2.A(i, "dstOffset "));
            return;
        }
        if (i2 < 0 || i3 < 0 || i2 > i3 || i3 > charSequence.length()) {
            zo2.j(charSequence.length(), fw.A(i2, i3, "start ", ", end ", ", s.length() "));
            return;
        }
        int i4 = i3 - i2;
        c(this.f + i4);
        char[] cArr = this.b;
        System.arraycopy(cArr, i, cArr, i + i4, this.f - i);
        while (i2 < i3) {
            char cCharAt = charSequence.charAt(i2);
            int i5 = i + 1;
            this.b[i] = cCharAt;
            if (ji0.j(cCharAt)) {
                this.z++;
            }
            i2++;
            i = i5;
        }
        this.f += i4;
    }

    @Override // java.lang.CharSequence
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final ud0 subSequence(int i, int i2) {
        a(i);
        a(i2);
        if (i2 < i) {
            throw new StringIndexOutOfBoundsException("start is greater than end");
        }
        int i3 = i2 - i;
        char[] cArr = new char[i3 + 16];
        System.arraycopy(this.b, i, cArr, 0, i3);
        ud0 ud0Var = new ud0();
        ud0Var.b = cArr;
        ud0Var.f = i3;
        if (this.z > 0) {
            for (int i4 = 0; i4 < ud0Var.f; i4++) {
                if (ji0.j(cArr[i4])) {
                    ud0Var.z++;
                }
            }
        }
        return ud0Var;
    }

    @Override // android.text.GetChars
    public final void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 > this.f) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("srcBegin > srcEnd");
        }
        System.arraycopy(this.b, i, cArr, i3, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return new String(this.b, 0, this.f);
    }

    public ud0(int i) {
        this.f = 0;
        this.b = new char[i];
    }

    public ud0(Object obj) {
        this.f = 0;
        this.b = new char[32];
    }
}
