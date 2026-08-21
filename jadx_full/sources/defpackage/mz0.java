package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mz0 extends a1 {
    public cm4 A;
    public final ws0 b;
    public final jd1 f;
    public final ft0[] z;

    public mz0(ws0 ws0Var) {
        this.b = ws0Var;
        kd1 kd1Var = kd1.d;
        jy3 jy3VarG = jy3.g();
        jd1 jd1Var = new jd1();
        jd1Var.a = jy3VarG;
        jd1Var.c = true;
        this.f = jd1Var;
        this.A = cm4.f;
        this.z = new ft0[ws0Var.f.C0.size()];
    }

    public static void N(ft0 ft0Var, Object obj) {
        int iOrdinal = ft0Var.r().ordinal();
        if (iOrdinal == 10) {
            if (obj instanceof a1) {
                zo2.p("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(ft0Var.z.Z), ft0Var.o().b, obj.getClass().getName()});
            }
        } else {
            if (iOrdinal != 13) {
                return;
            }
            obj.getClass();
            if (obj instanceof bt0) {
                return;
            }
            xe.k("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        }
    }

    @Override // defpackage.a1
    public final void A(cm4 cm4Var) {
        cm4 cm4Var2 = this.A;
        cm4 cm4Var3 = cm4.f;
        yl4 yl4VarP = yl4.p();
        yl4VarP.w(cm4Var2);
        yl4VarP.w(cm4Var);
        this.A = yl4VarP.p();
    }

    @Override // defpackage.a1
    public final a1 B(ft0 ft0Var) {
        L(ft0Var);
        if (ft0Var.r().b == ct0.MESSAGE) {
            return new mz0(ft0Var.p());
        }
        xe.k("newBuilderForField is only valid for fields with message type.");
        return null;
    }

    @Override // defpackage.a1
    public final a1 D(ft0 ft0Var, Object obj) {
        L(ft0Var);
        if (ft0Var.y()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                N(ft0Var, it.next());
            }
        } else {
            N(ft0Var, obj);
        }
        kt0 kt0Var = ft0Var.C0;
        jd1 jd1Var = this.f;
        if (kt0Var != null) {
            int i = kt0Var.f;
            ft0[] ft0VarArr = this.z;
            ft0 ft0Var2 = ft0VarArr[i];
            if (ft0Var2 != null && ft0Var2 != ft0Var) {
                jd1Var.c(ft0Var2);
            }
            ft0VarArr[i] = ft0Var;
        } else if (!ft0Var.s() && (!ft0Var.y() ? obj.equals(ft0Var.k()) : ((List) obj).isEmpty())) {
            jd1Var.c(ft0Var);
            return this;
        }
        jd1Var.n(ft0Var, obj);
        return this;
    }

    @Override // defpackage.a1
    public final a1 G(cm4 cm4Var) {
        this.A = cm4Var;
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final nz0 p() {
        if (c()) {
            return q();
        }
        kd1 kd1VarB = this.f.b(false);
        ft0[] ft0VarArr = this.z;
        throw a1.C(new nz0(this.b, kd1VarB, (ft0[]) Arrays.copyOf(ft0VarArr, ft0VarArr.length), this.A));
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final nz0 q() {
        ws0 ws0Var = this.b;
        boolean z = ws0Var.n().A0;
        jd1 jd1Var = this.f;
        if (z) {
            for (ft0 ft0Var : ws0Var.m()) {
                if (ft0Var.v() && !jd1Var.h(ft0Var)) {
                    if (ft0Var.r().b == ct0.MESSAGE) {
                        jd1Var.n(ft0Var, nz0.v(ft0Var.p()));
                    } else {
                        jd1Var.n(ft0Var, ft0Var.k());
                    }
                }
            }
        }
        kd1 kd1VarB = jd1Var.b(true);
        ft0[] ft0VarArr = this.z;
        return new nz0(ws0Var, kd1VarB, (ft0[]) Arrays.copyOf(ft0VarArr, ft0VarArr.length), this.A);
    }

    public final void K(c1 c1Var) {
        if (!(c1Var instanceof nz0)) {
            super.v(c1Var);
            return;
        }
        nz0 nz0Var = (nz0) c1Var;
        ft0[] ft0VarArr = nz0Var.X;
        if (nz0Var.z != this.b) {
            xe.k("mergeFrom(Message) can only merge messages of the same type.");
            return;
        }
        kd1 kd1Var = nz0Var.A;
        jd1 jd1Var = this.f;
        jd1Var.j(kd1Var);
        cm4 cm4Var = nz0Var.Y;
        cm4 cm4Var2 = this.A;
        cm4 cm4Var3 = cm4.f;
        yl4 yl4VarP = yl4.p();
        yl4VarP.w(cm4Var2);
        yl4VarP.w(cm4Var);
        this.A = yl4VarP.p();
        int i = 0;
        while (true) {
            ft0[] ft0VarArr2 = this.z;
            if (i >= ft0VarArr2.length) {
                return;
            }
            ft0 ft0Var = ft0VarArr2[i];
            if (ft0Var == null) {
                ft0VarArr2[i] = ft0VarArr[i];
            } else {
                ft0 ft0Var2 = ft0VarArr[i];
                if (ft0Var2 != null && ft0Var != ft0Var2) {
                    jd1Var.c(ft0Var);
                    ft0VarArr2[i] = ft0VarArr[i];
                }
            }
            i++;
        }
    }

    public final void L(ft0 ft0Var) {
        if (ft0Var.B0 == this.b) {
            return;
        }
        xe.k("FieldDescriptor does not match message type.");
    }

    @Override // defpackage.ql2
    public final boolean b(ft0 ft0Var) {
        L(ft0Var);
        return this.f.h(ft0Var);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        Iterator it = this.b.m().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            jd1 jd1Var = this.f;
            if (!zHasNext) {
                return jd1Var.i();
            }
            ft0 ft0Var = (ft0) it.next();
            if (ft0Var.z() && !jd1Var.h(ft0Var)) {
                return false;
            }
        }
    }

    public final Object clone() {
        mz0 mz0Var = new mz0(this.b);
        mz0Var.f.j(this.f.b(false));
        cm4 cm4Var = this.A;
        cm4 cm4Var2 = mz0Var.A;
        cm4 cm4Var3 = cm4.f;
        yl4 yl4VarP = yl4.p();
        yl4VarP.w(cm4Var2);
        yl4VarP.w(cm4Var);
        mz0Var.A = yl4VarP.p();
        ft0[] ft0VarArr = mz0Var.z;
        ft0[] ft0VarArr2 = this.z;
        System.arraycopy(ft0VarArr2, 0, ft0VarArr, 0, ft0VarArr2.length);
        return mz0Var;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return this.b;
    }

    @Override // defpackage.ql2
    public final cm4 i() {
        return this.A;
    }

    @Override // defpackage.ql2
    public final Map l() {
        return this.f.e();
    }

    @Override // defpackage.ql2
    public final Object n(ft0 ft0Var) {
        L(ft0Var);
        Object objF = this.f.f(ft0Var);
        return objF == null ? ft0Var.y() ? Collections.EMPTY_LIST : ft0Var.n() == ct0.MESSAGE ? nz0.v(ft0Var.p()) : ft0Var.k() : objF;
    }

    @Override // defpackage.a1
    public final a1 o(ft0 ft0Var, Object obj) {
        L(ft0Var);
        N(ft0Var, obj);
        this.f.a(ft0Var, obj);
        return this;
    }

    @Override // defpackage.a1
    public final a1 r(ft0 ft0Var) {
        a1 a1VarU;
        L(ft0Var);
        if (ft0Var.t()) {
            vp1.n("Nested builder not supported for map fields.");
            return null;
        }
        if (ft0Var.r().b != ct0.MESSAGE) {
            vp1.n("getFieldBuilder() called on a non-Message type.");
            return null;
        }
        jd1 jd1Var = this.f;
        Object objG = jd1Var.g(ft0Var);
        if (objG == null) {
            a1VarU = new mz0(ft0Var.p());
        } else if (objG instanceof a1) {
            a1VarU = (a1) objG;
        } else {
            if (objG instanceof d92) {
                objG = ((d92) objG).b();
            }
            if (!(objG instanceof c1)) {
                xe.r("Cannot convert ", objG.getClass(), " to Message.Builder");
                return null;
            }
            a1VarU = ((c1) objG).u();
        }
        jd1Var.n(ft0Var, a1VarU);
        return a1VarU;
    }

    @Override // defpackage.a1
    public final /* bridge */ /* synthetic */ a1 v(c1 c1Var) {
        K(c1Var);
        return this;
    }

    @Override // defpackage.a1
    public final /* bridge */ /* synthetic */ a1 x(c1 c1Var) {
        K(c1Var);
        return this;
    }
}
