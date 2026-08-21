package io.netty.util.internal;

import defpackage.dw2;
import defpackage.fw;
import defpackage.ha0;
import defpackage.s53;
import defpackage.st4;
import defpackage.xe;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    private AppendableCharSequence(char[] cArr) {
        this.chars = ObjectUtil.checkNonEmpty(cArr, "chars");
        this.pos = cArr.length;
    }

    private static char[] expand(char[] cArr, int i, int i2) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                st4.g();
                return null;
            }
        } while (i > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i2);
        return cArr2;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i, int i2) {
        if (charSequence.length() < i2) {
            StringBuilder sbD = dw2.D("expected: csq.length() >= (", i2, "),but actual is (");
            sbD.append(charSequence.length());
            sbD.append(")");
            throw new IndexOutOfBoundsException(sbD.toString());
        }
        int i3 = i2 - i;
        char[] cArrExpand = this.chars;
        int length = cArrExpand.length;
        int i4 = this.pos;
        if (i3 > length - i4) {
            cArrExpand = expand(cArrExpand, i4 + i3, i4);
            this.chars = cArrExpand;
        }
        if (charSequence instanceof AppendableCharSequence) {
            System.arraycopy(((AppendableCharSequence) charSequence).chars, i, cArrExpand, this.pos, i3);
            this.pos += i3;
            return this;
        }
        while (i < i2) {
            char[] cArr = this.chars;
            int i5 = this.pos;
            this.pos = i5 + 1;
            cArr[i5] = charSequence.charAt(i);
            i++;
        }
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i <= this.pos) {
            return this.chars[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i) {
        return this.chars[i];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public void setLength(int i) {
        if (i < 0 || i > this.pos) {
            xe.k(ha0.p(dw2.D("length: ", i, " (length: >= 0, <= "), this.pos, ')'));
        } else {
            this.pos = i;
        }
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i, int i2) {
        char[] cArr = this.chars;
        return i == i2 ? new AppendableCharSequence(Math.min(16, cArr.length)) : new AppendableCharSequence(Arrays.copyOfRange(cArr, i, i2));
    }

    public String subStringUnsafe(int i, int i2) {
        return new String(this.chars, i, i2 - i);
    }

    public String substring(int i, int i2) {
        int i3 = i2 - i;
        int i4 = this.pos;
        if (i <= i4 && i3 <= i4) {
            return new String(this.chars, i, i3);
        }
        s53.k(fw.w(")", new StringBuilder("expected: start and length <= ("), this.pos));
        return null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    public AppendableCharSequence(int i) {
        this.chars = new char[ObjectUtil.checkPositive(i, "length")];
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c) {
        int i = this.pos;
        char[] cArr = this.chars;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length << 1];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i2 = this.pos;
        this.pos = i2 + 1;
        cArr3[i2] = c;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }
}
