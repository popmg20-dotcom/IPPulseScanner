package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hb2 implements Iterator, z72 {
    public int A;
    public int X;
    public final CharSequence b;
    public int f;
    public int z;

    public hb2(CharSequence charSequence) {
        charSequence.getClass();
        this.b = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        int i3 = this.f;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.X < 0) {
            this.f = 2;
            return false;
        }
        CharSequence charSequence = this.b;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i4 = this.z; i4 < length2; i4++) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < charSequence.length() && charSequence.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.f = 1;
                this.X = i;
                this.A = length;
                return true;
            }
        }
        i = -1;
        this.f = 1;
        this.X = i;
        this.A = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        this.f = 0;
        int i = this.A;
        int i2 = this.z;
        this.z = this.X + i;
        return this.b.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
