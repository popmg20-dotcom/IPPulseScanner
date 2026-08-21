package defpackage;

import android.hardware.camera2.CaptureRequest;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qx implements z81, ln4 {
    public final /* synthetic */ int a;
    public final qn2 b;

    public qx(qn2 qn2Var, int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.b = qn2Var;
                pg pgVar = ta4.U;
                Class cls = (Class) qn2Var.p(pgVar, null);
                if (cls != null && !cls.equals(xx1.class)) {
                    ad0.k("Invalid target class configuration for ", this, ": ", cls);
                    throw null;
                }
                qn2Var.g(mn4.k0, on4.b);
                qn2Var.g(pgVar, xx1.class);
                pg pgVar2 = ta4.T;
                if (qn2Var.p(pgVar2, null) == null) {
                    qn2Var.g(pgVar2, xx1.class.getCanonicalName() + "-" + UUID.randomUUID());
                    return;
                }
                return;
            case 4:
                this.b = qn2Var;
                pg pgVar3 = ta4.U;
                Class cls2 = (Class) qn2Var.p(pgVar3, null);
                if (cls2 != null && !cls2.equals(j43.class)) {
                    ad0.k("Invalid target class configuration for ", this, ": ", cls2);
                    throw null;
                }
                qn2Var.g(mn4.k0, on4.f);
                qn2Var.g(pgVar3, j43.class);
                pg pgVar4 = ta4.T;
                if (qn2Var.p(pgVar4, null) == null) {
                    qn2Var.g(pgVar4, j43.class.getCanonicalName() + "-" + UUID.randomUUID());
                }
                pg pgVar5 = hy1.y;
                if (((Integer) qn2Var.p(pgVar5, -1)).intValue() == -1) {
                    qn2Var.g(pgVar5, 2);
                    return;
                }
                return;
            default:
                this.b = qn2Var;
                pg pgVar6 = ta4.U;
                Class cls3 = (Class) qn2Var.p(pgVar6, null);
                if (cls3 != null && !cls3.equals(lx1.class)) {
                    ad0.k("Invalid target class configuration for ", this, ": ", cls3);
                    throw null;
                }
                qn2Var.g(mn4.k0, on4.z);
                qn2Var.g(pgVar6, lx1.class);
                pg pgVar7 = ta4.T;
                if (qn2Var.p(pgVar7, null) == null) {
                    qn2Var.g(pgVar7, lx1.class.getCanonicalName() + "-" + UUID.randomUUID());
                    return;
                }
                return;
        }
    }

    public static qx d(ka0 ka0Var) {
        qx qxVar = new qx(1);
        ka0Var.l(new ed(2, qxVar, ka0Var));
        return qxVar;
    }

    @Override // defpackage.z81
    public final qn2 a() {
        switch (this.a) {
            case 0:
                throw null;
            case 1:
                throw null;
            case 2:
                return this.b;
            case 3:
                return this.b;
            default:
                return this.b;
        }
    }

    @Override // defpackage.ln4
    public mn4 b() {
        int i = this.a;
        qn2 qn2Var = this.b;
        switch (i) {
            case 2:
                return new px1(sw2.a(qn2Var));
            case 3:
                return new yx1(sw2.a(qn2Var));
            default:
                return new k43(sw2.a(qn2Var));
        }
    }

    public cp1 c() {
        return new cp1(14, sw2.a(this.b));
    }

    public void e(CaptureRequest.Key key, Object obj) {
        this.b.f(rx.k0(key), ia0.z, obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public qx(int i) {
        this(qn2.c(), 4);
        this.a = i;
        switch (i) {
            case 1:
                this.b = qn2.c();
                break;
            case 2:
                this(qn2.c(), 2);
                break;
            case 3:
                this(qn2.c(), 3);
                break;
            case 4:
                break;
            default:
                this.b = qn2.c();
                break;
        }
    }
}
