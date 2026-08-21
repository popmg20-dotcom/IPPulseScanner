package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hl3 implements Iterator, z72 {
    public int A;
    public final /* synthetic */ il3 X;
    public int b;
    public Object f;
    public int z;

    public hl3(il3 il3Var) {
        this.X = il3Var;
        this.z = il3Var.A;
        this.A = il3Var.z;
    }

    public final boolean a() {
        this.b = 3;
        int i = this.z;
        if (i == 0) {
            this.b = 2;
            return false;
        }
        il3 il3Var = this.X;
        Object[] objArr = il3Var.b;
        int i2 = this.A;
        this.f = objArr[i2];
        this.b = 1;
        this.A = (i2 + 1) % il3Var.f;
        this.z = i - 1;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        if (i == 0) {
            return a();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        xe.k("hasNext called when the iterator is in the FAILED state.");
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        if (i == 1) {
            this.b = 0;
            return this.f;
        }
        if (i == 2 || !a()) {
            vp1.g();
            return null;
        }
        this.b = 0;
        return this.f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
