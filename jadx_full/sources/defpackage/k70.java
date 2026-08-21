package defpackage;

import android.content.Context;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class k70 implements lp, pw3, xy, m95 {
    public final /* synthetic */ int b;
    public Object f;
    public static final cp1[] z = new cp1[0];
    public static final Annotation[] A = new Annotation[0];

    public k70(int i) {
        this.b = 2;
        new AtomicReference();
        String name = getClass().getName();
        this.f = xe2.d(ga5.t("") ? name : name.concat("[]"));
    }

    @Override // defpackage.m95
    public f85 C() {
        throw null;
    }

    public abstract void F0();

    public ke0 G0(ke0 ke0Var, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            ke0Var = ke0Var.a(annotation);
            if (((cu2) this.f).W(annotation)) {
                ke0Var = J0(ke0Var, annotation);
            }
        }
        return ke0Var;
    }

    public ke0 H0(Annotation[] annotationArr) {
        ke0 ke0VarA = j9.e;
        for (Annotation annotation : annotationArr) {
            ke0VarA = ke0VarA.a(annotation);
            if (((cu2) this.f).W(annotation)) {
                ke0VarA = J0(ke0VarA, annotation);
            }
        }
        return ke0VarA;
    }

    @Override // defpackage.xy
    public void I(int i) {
        ((xy) this.f).I(i);
    }

    public ke0 I0(ke0 ke0Var, Annotation[] annotationArr) {
        cu2 cu2Var = (cu2) this.f;
        for (Annotation annotation : annotationArr) {
            if (!ke0Var.k(annotation)) {
                ke0Var = ke0Var.a(annotation);
                if (cu2Var.W(annotation)) {
                    for (Annotation annotation2 : n50.h(annotation.annotationType())) {
                        if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !ke0Var.k(annotation2)) {
                            ke0Var = ke0Var.a(annotation2);
                            if (cu2Var.W(annotation2)) {
                                ke0Var = J0(ke0Var, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return ke0Var;
    }

    public ke0 J0(ke0 ke0Var, Annotation annotation) {
        for (Annotation annotation2 : n50.h(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention)) {
                if (!((cu2) this.f).W(annotation2)) {
                    ke0Var = ke0Var.a(annotation2);
                } else if (!ke0Var.k(annotation2)) {
                    ke0Var = J0(ke0Var.a(annotation2), annotation2);
                }
            }
        }
        return ke0Var;
    }

    public void K0(k70 k70Var) throws qy4 {
        r51 r51Var = (r51) this.f;
        r51Var.a = 0L;
        r51Var.b = 0L;
        try {
            L0(k70Var, r51Var);
            r51Var.getClass();
        } catch (qy4 e) {
            r51Var.getClass();
            throw e;
        } catch (Exception e2) {
            r51Var.getClass();
            throw new qy4(e2);
        }
    }

    public abstract void L0(k70 k70Var, r51 r51Var);

    @Override // defpackage.xy
    public void M(vx1 vx1Var) {
        ((xy) this.f).M(vx1Var);
    }

    public abstract int M0(int i);

    @Override // defpackage.xy
    public void N() {
        ((xy) this.f).N();
    }

    public abstract int N0(int i);

    public abstract int O0();

    public abstract void P0(fu4 fu4Var);

    @Override // defpackage.xy
    public void Q(pt3 pt3Var) {
        ((xy) this.f).Q(pt3Var);
    }

    public abstract void Q0(fu4 fu4Var);

    public abstract bv4 R0(bv4 bv4Var, List list);

    public abstract int T0(int i, int i2);

    @Override // defpackage.m95
    public d84 U() {
        throw null;
    }

    public abstract int U0(int i, int i2);

    public void V0() {
        f85 f85Var = ((k85) this.f).Z;
        k85.h(f85Var);
        f85Var.V0();
    }

    public nc2 X(boolean z2) {
        return ((xy) this.f).X(z2);
    }

    @Override // defpackage.xy
    public ka0 c0() {
        return ((xy) this.f).c0();
    }

    @Override // defpackage.m95
    public t65 n() {
        throw null;
    }

    @Override // defpackage.xy
    public void n0() {
        ((xy) this.f).n0();
    }

    @Override // defpackage.m95
    public Context r0() {
        throw null;
    }

    public String toString() {
        switch (this.b) {
            case 1:
                return getClass().getSimpleName() + " - supported=" + ((Collection) this.f);
            case 3:
                StringBuilder sb = new StringBuilder(getClass().getSimpleName());
                sb.append("[");
                return fw.y(sb, (String) this.f, "]");
            case 7:
                StringBuilder sb2 = new StringBuilder("Region: \n");
                for (int i = 0; i < O0(); i++) {
                    StringBuilder sbD = dw2.D(" ", i, ": (");
                    sbD.append(M0(i));
                    sbD.append("-");
                    sbD.append(N0(i));
                    sbD.append(")");
                    sb2.append(sbD.toString());
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    @Override // defpackage.xy
    public void x(ka0 ka0Var) {
        ((xy) this.f).x(ka0Var);
    }

    @Override // defpackage.m95
    public wl3 z0() {
        throw null;
    }

    public /* synthetic */ k70(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public k70(k85 k85Var) {
        this.b = 9;
        tj4.i(k85Var);
        this.f = k85Var;
    }

    public k70(w7 w7Var) {
        this.b = 5;
        this.f = (r51) w7Var.f;
    }

    public k70(Class cls, Collection collection) {
        this.b = 1;
        n12.h(collection, "No supported types for %s", cls.getSimpleName());
        this.f = collection;
    }

    public e24 S0(fu4 fu4Var, e24 e24Var) {
        return e24Var;
    }

    public k70(String str, String str2) {
        this.b = 3;
        this.f = n12.g(str, "No signature algorithm specified");
        n12.g(str2, "Missing protocol name of the signature algorithm.");
    }

    public /* synthetic */ k70(byte b, int i) {
        this.b = i;
    }

    public k70() {
        this.b = 2;
        new AtomicReference();
        this.f = xe2.c(getClass());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k70(Class cls, String[] strArr) {
        this(cls, strArr.length <= 0 ? Collections.EMPTY_LIST : Arrays.asList(strArr));
        this.b = 1;
    }
}
