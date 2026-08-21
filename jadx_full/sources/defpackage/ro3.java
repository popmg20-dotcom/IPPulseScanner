package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ro3 extends so3 implements Iterator {
    public qo3 b;
    public boolean f = true;
    public final /* synthetic */ to3 z;

    public ro3(to3 to3Var) {
        this.z = to3Var;
    }

    @Override // defpackage.so3
    public final void a(qo3 qo3Var) {
        qo3 qo3Var2 = this.b;
        if (qo3Var == qo3Var2) {
            qo3 qo3Var3 = qo3Var2.A;
            this.b = qo3Var3;
            this.f = qo3Var3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f) {
            return this.z.b != null;
        }
        qo3 qo3Var = this.b;
        return (qo3Var == null || qo3Var.z == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f) {
            this.f = false;
            qo3 qo3Var = this.z.b;
            this.b = qo3Var;
            return qo3Var;
        }
        qo3 qo3Var2 = this.b;
        qo3 qo3Var3 = qo3Var2 != null ? qo3Var2.z : null;
        this.b = qo3Var3;
        return qo3Var3;
    }
}
