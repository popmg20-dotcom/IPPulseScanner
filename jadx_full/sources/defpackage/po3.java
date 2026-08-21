package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class po3 extends so3 implements Iterator {
    public qo3 b;
    public qo3 f;
    public final /* synthetic */ int z;

    public po3(qo3 qo3Var, qo3 qo3Var2, int i) {
        this.z = i;
        this.b = qo3Var2;
        this.f = qo3Var;
    }

    @Override // defpackage.so3
    public final void a(qo3 qo3Var) {
        qo3 qo3Var2;
        qo3 qo3Var3 = this.b;
        qo3 qo3VarB = null;
        if (qo3Var3 == qo3Var && qo3Var == this.f) {
            this.f = null;
            this.b = null;
            qo3Var3 = null;
        }
        qo3 qo3Var4 = qo3Var3;
        if (qo3Var3 == qo3Var) {
            switch (this.z) {
                case 0:
                    qo3Var2 = qo3Var3.A;
                    break;
                default:
                    qo3Var2 = qo3Var3.z;
                    break;
            }
            qo3Var4 = qo3Var2;
            this.b = qo3Var4;
        }
        qo3 qo3Var5 = this.f;
        if (qo3Var5 == qo3Var) {
            if (qo3Var5 != qo3Var4 && qo3Var4 != null) {
                qo3VarB = b(qo3Var5);
            }
            this.f = qo3VarB;
        }
    }

    public final qo3 b(qo3 qo3Var) {
        switch (this.z) {
            case 0:
                return qo3Var.z;
            default:
                return qo3Var.A;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        qo3 qo3Var = this.f;
        qo3 qo3Var2 = this.b;
        this.f = (qo3Var == qo3Var2 || qo3Var2 == null) ? null : b(qo3Var);
        return qo3Var;
    }
}
