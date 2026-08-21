package defpackage;

import android.text.GetChars;
import java.nio.CharBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o30 implements CharSequence, GetChars {
    public final char[] b;
    public final int f;

    public o30(char[] cArr, int i) {
        this.b = cArr;
        this.f = i;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.b[i];
    }

    @Override // android.text.GetChars
    public final void getChars(int i, int i2, char[] cArr, int i3) {
        if (i2 > this.f) {
            throw new StringIndexOutOfBoundsException();
        }
        System.arraycopy(this.b, i, cArr, i3, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return CharBuffer.wrap(this.b, i, i2 - i);
    }
}
