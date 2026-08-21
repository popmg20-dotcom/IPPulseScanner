package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cf2 implements Iterator, z72 {
    public long A;
    public final long b;
    public final long f;
    public boolean z;

    public cf2(long j, long j2, long j3) {
        this.b = j3;
        this.f = j2;
        boolean z = false;
        if (j3 <= 0 ? j >= j2 : j <= j2) {
            z = true;
        }
        this.z = z;
        this.A = z ? j : j2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.z;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j = this.A;
        if (j != this.f) {
            this.A = this.b + j;
        } else {
            if (!this.z) {
                vp1.g();
                return null;
            }
            this.z = false;
        }
        return Long.valueOf(j);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
