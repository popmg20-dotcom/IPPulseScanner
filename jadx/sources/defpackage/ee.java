package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ee implements Iterator, z72 {
    public final /* synthetic */ int A;
    public final /* synthetic */ Object X;
    public int b;
    public int f;
    public boolean z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ee(ie ieVar, int i) {
        this(ieVar.z);
        this.A = i;
        switch (i) {
            case 1:
                this.X = ieVar;
                this(ieVar.z);
                break;
            default:
                this.X = ieVar;
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        int i = this.f;
        int i2 = this.A;
        Object obj = this.X;
        switch (i2) {
            case 0:
                objF = ((ie) obj).f(i);
                break;
            case 1:
                objF = ((ie) obj).i(i);
                break;
            default:
                objF = ((me) obj).f[i];
                break;
        }
        this.f++;
        this.z = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.z) {
            xe.q("Call next() before removing an element.");
            return;
        }
        int i = this.f - 1;
        this.f = i;
        int i2 = this.A;
        Object obj = this.X;
        switch (i2) {
            case 0:
                ((ie) obj).g(i);
                break;
            case 1:
                ((ie) obj).g(i);
                break;
            default:
                ((me) obj).a(i);
                break;
        }
        this.b--;
        this.z = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ee(me meVar) {
        this(meVar.z);
        this.A = 2;
        this.X = meVar;
    }

    public ee(int i) {
        this.b = i;
    }
}
