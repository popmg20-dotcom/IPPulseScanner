package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a12 implements Iterator, z72 {
    public int A;
    public final int b;
    public final int f;
    public boolean z;

    public a12(int i, int i2, int i3) {
        this.b = i3;
        this.f = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.z = z;
        this.A = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.z;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i = this.A;
        if (i != this.f) {
            this.A = this.b + i;
            return i;
        }
        if (this.z) {
            this.z = false;
            return i;
        }
        vp1.g();
        return 0;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
