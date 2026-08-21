package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class r30 implements Iterator, z72 {
    public final int b;
    public boolean f;
    public int z;

    public r30(char c, char c2) {
        this.b = c2;
        boolean z = n12.l(c, c2) <= 0;
        this.f = z;
        this.z = z ? c : c2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.z;
        if (i != this.b) {
            this.z = i + 1;
        } else {
            if (!this.f) {
                vp1.g();
                return null;
            }
            this.f = false;
        }
        return Character.valueOf((char) i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
