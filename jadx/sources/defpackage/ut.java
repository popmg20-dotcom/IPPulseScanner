package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ut implements Iterator {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b = 1;
    public int f = 0;
    public final int z;

    public ut(hb5 hb5Var) {
        this.A = hb5Var;
        this.z = hb5Var.c();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.b) {
            case 0:
                if (this.f < this.z) {
                }
                break;
            case 1:
                if (this.f < this.z) {
                }
                break;
            default:
                if (this.f < this.z) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Object obj = this.A;
        int i2 = this.z;
        switch (i) {
            case 0:
                int i3 = this.f;
                if (i3 >= i2) {
                    vp1.g();
                } else {
                    this.f = i3 + 1;
                }
                break;
            case 1:
                int i4 = this.f;
                if (i4 >= i2) {
                    vp1.g();
                } else {
                    this.f = i4 + 1;
                }
                break;
            default:
                int i5 = this.f;
                if (i5 >= i2) {
                    vp1.g();
                } else {
                    this.f = i5 + 1;
                }
                break;
        }
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public ut(zt ztVar) {
        this.A = ztVar;
        this.z = ztVar.size();
    }

    public ut(au auVar) {
        this.A = auVar;
        this.z = auVar.size();
    }
}
