package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jb2 implements Iterator {
    public e53 b;
    public final /* synthetic */ int f;

    public jb2(e53 e53Var, int i) {
        this.f = i;
        this.b = e53Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        e53 e53Var;
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        e53 e53Var2 = this.b;
        switch (this.f) {
            case 0:
                e53Var = this.b.z;
                break;
            default:
                e53Var = this.b.f;
                break;
        }
        this.b = e53Var;
        return e53Var2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
