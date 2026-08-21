package defpackage;

import j$.util.Optional;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w34 {
    public final StringReader a;
    public int e = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int[] c = new int[0];
    public int d = 0;
    public boolean f = false;
    public final char[] b = new char[1025];

    public w34(uf4 uf4Var, StringReader stringReader) {
        this.a = stringReader;
    }

    public final boolean a(int i) {
        if (!this.f && this.e + i >= this.d) {
            StringReader stringReader = this.a;
            char[] cArr = this.b;
            try {
                int i2 = stringReader.read(cArr);
                if (i2 <= 0) {
                    this.f = true;
                } else {
                    int i3 = this.d;
                    int i4 = this.e;
                    int i5 = i3 - i4;
                    this.c = Arrays.copyOfRange(this.c, i4, i3 + i2);
                    int i6 = i2 - 1;
                    if (Character.isHighSurrogate(cArr[i6])) {
                        if (stringReader.read(cArr, i2, 1) == -1) {
                            throw new ce3(this.g + i2, cArr[i6], "The last char is HighSurrogate (no LowSurrogate detected).");
                        }
                        i2++;
                    }
                    int iCharCount = 0;
                    while (iCharCount < i2) {
                        int iCodePointAt = Character.codePointAt(cArr, iCharCount);
                        this.c[i5] = iCodePointAt;
                        if ((iCodePointAt < 32 || iCodePointAt > 126) && iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 13 && iCodePointAt != 133 && ((iCodePointAt < 160 || iCodePointAt > 55295) && ((iCodePointAt < 57344 || iCodePointAt > 65533) && (iCodePointAt < 65536 || iCodePointAt > 1114111)))) {
                            throw new ce3(this.g + i5, iCodePointAt, "special characters are not allowed");
                        }
                        iCharCount += Character.charCount(iCodePointAt);
                        i5++;
                    }
                    this.d = i5;
                    this.e = 0;
                }
            } catch (IOException e) {
                throw new hy4(e);
            }
        }
        return this.e + i < this.d;
    }

    public final void b(int i) {
        for (int i2 = 0; i2 < i && a(0); i2++) {
            int[] iArr = this.c;
            int i3 = this.e;
            this.e = i3 + 1;
            int i4 = iArr[i3];
            this.g++;
            this.h++;
            if (p30.b.b(i4) || (i4 == 13 && a(0) && this.c[this.e] != 10)) {
                this.i++;
                this.j = 0;
            } else if (i4 != 65279) {
                this.j++;
            }
        }
    }

    public final Optional c() {
        return Optional.of(new gh2(this.i, this.j, this.c, this.e));
    }

    public final int d() {
        if (a(0)) {
            return this.c[this.e];
        }
        return 0;
    }

    public final int e(int i) {
        if (a(i)) {
            return this.c[this.e + i];
        }
        return 0;
    }

    public final String f(int i) {
        if (i == 0) {
            return "";
        }
        boolean zA = a(i);
        int[] iArr = this.c;
        if (zA) {
            return new String(iArr, this.e, i);
        }
        int i2 = this.e;
        return new String(iArr, i2, Math.min(i, this.d - i2));
    }

    public final String g(int i) {
        String strF = f(i);
        this.e += i;
        this.g += i;
        this.h += i;
        this.j += i;
        return strF;
    }
}
