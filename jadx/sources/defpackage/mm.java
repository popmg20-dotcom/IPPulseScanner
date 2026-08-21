package defpackage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mm extends rm {
    public final rm B0;

    public mm(qm qmVar) {
        super(qmVar, (wt2) null, qmVar.Y);
        this.B0 = qmVar;
    }

    public final void A(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        if (this.X != null) {
            gt3Var.getClass();
        }
        pm[] pmVarArr = this.A;
        int i = 0;
        try {
            int length = pmVarArr.length;
            while (i < length) {
                pm pmVar = pmVarArr[i];
                if (pmVar == null) {
                    i52Var.U();
                } else {
                    pmVar.j(obj, i52Var, gt3Var);
                }
                i++;
            }
        } catch (Exception e) {
            l34.n(gt3Var, e, obj, pmVarArr[i].f.b);
            throw null;
        } catch (StackOverflowError e2) {
            a62 a62Var = new a62(i52Var, "Infinite recursion (StackOverflowError)", e2);
            z52 z52Var = new z52(obj, pmVarArr[i].f.b);
            LinkedList linkedList = a62Var.b;
            if (linkedList == null) {
                linkedList = new LinkedList();
                a62Var.b = linkedList;
            }
            if (linkedList.size() >= 1000) {
                throw a62Var;
            }
            a62Var.b.addFirst(z52Var);
            throw a62Var;
        }
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        if (gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && this.A.length == 1) {
            A(obj, i52Var, gt3Var);
            return;
        }
        i52Var.q0(obj);
        A(obj, i52Var, gt3Var);
        i52Var.I();
    }

    @Override // defpackage.rm, defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) throws IOException {
        if (this.y0 != null) {
            o(obj, i52Var, gt3Var, zj4Var);
            return;
        }
        e10 e10VarQ = q(zj4Var, obj, g72.X);
        zj4Var.e(i52Var, e10VarQ);
        i52Var.s(obj);
        A(obj, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarQ);
    }

    @Override // defpackage.b72
    public final b72 g(po2 po2Var) {
        return this.B0.g(po2Var);
    }

    public final String toString() {
        return "BeanAsArraySerializer for ".concat(this.b.getName());
    }

    @Override // defpackage.rm
    public final rm w(Set set, Set set2) {
        return new mm(this, set, set2);
    }

    @Override // defpackage.rm
    public final rm x(Object obj) {
        return new mm(this, this.y0, obj);
    }

    @Override // defpackage.rm
    public final rm y(wt2 wt2Var) {
        return this.B0.y(wt2Var);
    }

    public mm(mm mmVar, wt2 wt2Var, Object obj) {
        super(mmVar, wt2Var, obj);
        this.B0 = mmVar;
    }

    public mm(mm mmVar, Set set, Set set2) {
        super(mmVar, set, set2);
        this.B0 = mmVar;
    }

    @Override // defpackage.rm
    public final rm r() {
        return this;
    }

    @Override // defpackage.rm
    public final rm z(pm[] pmVarArr, pm[] pmVarArr2) {
        return this;
    }
}
