package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mb2 implements Iterator {
    public final /* synthetic */ pb2 A;
    public final /* synthetic */ int X;
    public ob2 b;
    public ob2 f = null;
    public int z;

    public mb2(pb2 pb2Var, int i) {
        this.X = i;
        this.A = pb2Var;
        this.b = pb2Var.Y.A;
        this.z = pb2Var.X;
    }

    public final Object a() {
        return b();
    }

    public final ob2 b() {
        ob2 ob2Var = this.b;
        pb2 pb2Var = this.A;
        if (ob2Var == pb2Var.Y) {
            vp1.g();
            return null;
        }
        if (pb2Var.X != this.z) {
            throw new ConcurrentModificationException();
        }
        this.b = ob2Var.A;
        this.f = ob2Var;
        return ob2Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != this.A.Y;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.X) {
            case 1:
                return b().Y;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        ob2 ob2Var = this.f;
        if (ob2Var == null) {
            st4.g();
            return;
        }
        pb2 pb2Var = this.A;
        pb2Var.c(ob2Var, true);
        this.f = null;
        this.z = pb2Var.X;
    }
}
