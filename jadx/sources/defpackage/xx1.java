package defpackage;

import android.util.Log;
import android.util.Pair;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xx1 extends in4 {
    public static final ux1 y = new ux1();
    public final int p;
    public final AtomicReference q;
    public final int r;
    public final mq3 s;
    public pt3 t;
    public ed4 u;
    public sa4 v;
    public qt3 w;
    public final vd3 x;

    public xx1(yx1 yx1Var) {
        super(yx1Var);
        this.q = new AtomicReference(null);
        this.r = -1;
        this.x = new vd3(this);
        yx1 yx1Var2 = (yx1) this.g;
        pg pgVar = yx1.f;
        yx1Var2.getClass();
        if (((sw2) yx1Var2.m()).K(pgVar)) {
            this.p = ((Integer) dw2.m(yx1Var2, pgVar)).intValue();
        } else {
            this.p = 1;
        }
        ((Integer) ((sw2) yx1Var2.m()).p(yx1.y0, 0)).getClass();
        this.s = new mq3((vx1) ((sw2) yx1Var2.m()).p(yx1.z0, null));
    }

    public static boolean G(int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).equals(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public final void D(boolean z) {
        sa4 sa4Var;
        Log.d("ImageCapture", "clearPipeline");
        co4.h();
        qt3 qt3Var = this.w;
        if (qt3Var != null) {
            qt3Var.b();
            this.w = null;
        }
        ed4 ed4Var = this.u;
        if (ed4Var != null) {
            ed4Var.m();
            this.u = null;
        }
        if (!z && (sa4Var = this.v) != null) {
            sa4Var.b();
            this.v = null;
        }
        d().N();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.pt3 E(java.lang.String r17, defpackage.yx1 r18, defpackage.ih r19) {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xx1.E(java.lang.String, yx1, ih):pt3");
    }

    public final int F() {
        int iIntValue;
        synchronized (this.q) {
            iIntValue = this.r;
            if (iIntValue == -1) {
                yx1 yx1Var = (yx1) this.g;
                yx1Var.getClass();
                iIntValue = ((Integer) dw2.n(yx1Var, yx1.z, 2)).intValue();
            }
        }
        return iIntValue;
    }

    @Override // defpackage.in4
    public final mn4 f(boolean z, pn4 pn4Var) {
        y.getClass();
        yx1 yx1Var = ux1.a;
        yx1Var.getClass();
        ka0 ka0VarA = pn4Var.a(qe4.a(yx1Var), this.p);
        if (z) {
            ka0VarA = ha0.y(ka0VarA, yx1Var);
        }
        if (ka0VarA == null) {
            return null;
        }
        return new yx1(sw2.a(((qx) l(ka0VarA)).b));
    }

    @Override // defpackage.in4
    public final Set k() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @Override // defpackage.in4
    public final ln4 l(ka0 ka0Var) {
        return new qx(qn2.d(ka0Var), 3);
    }

    @Override // defpackage.in4
    public final void r() {
        r25.i(c(), "Attached camera cannot be null");
        if (F() == 3) {
            mz mzVarC = c();
            if ((mzVarC != null ? mzVarC.b().i() : -1) == 0) {
                return;
            }
            xe.k("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    @Override // defpackage.in4
    public final void s() {
        ez4.o("ImageCapture", "onCameraControlReady");
        synchronized (this.q) {
            try {
                if (this.q.get() == null) {
                    d().I(F());
                }
            } finally {
            }
        }
        d().M(this.s);
    }

    @Override // defpackage.in4
    public final mn4 t(kz kzVar, ln4 ln4Var) {
        HashSet<eq1> hashSet = this.f;
        boolean z = false;
        if (hashSet != null) {
            int i = 0;
            for (eq1 eq1Var : hashSet) {
                if (eq1Var instanceof by1) {
                    i = ((by1) eq1Var).a;
                }
            }
            ln4Var.a().g(yx1.X, Integer.valueOf(i));
        }
        if (kzVar.n().y(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            qn2 qn2VarA = ln4Var.a();
            pg pgVar = yx1.Z;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(qn2VarA.p(pgVar, bool2))) {
                ez4.a0("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                ez4.D("ImageCapture", "Requesting software JPEG due to device quirk.");
                ln4Var.a().g(pgVar, bool2);
            }
        }
        qn2 qn2VarA2 = ln4Var.a();
        Boolean bool3 = Boolean.TRUE;
        pg pgVar2 = yx1.Z;
        Boolean bool4 = Boolean.FALSE;
        if (bool3.equals(qn2VarA2.p(pgVar2, bool4))) {
            if (c() != null) {
                ((zf2) c().i()).m0();
            }
            Integer num = (Integer) qn2VarA2.p(yx1.A, null);
            if (num == null || num.intValue() == 256) {
                z = true;
            } else {
                ez4.a0("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z) {
                ez4.a0("ImageCapture", "Unable to support software JPEG. Disabling.");
                qn2VarA2.g(pgVar2, bool4);
            }
        }
        Integer num2 = (Integer) ln4Var.a().p(yx1.A, null);
        if (num2 != null) {
            if (c() != null) {
                ((zf2) c().i()).m0();
            }
            ln4Var.a().g(dy1.s, Integer.valueOf(z ? 35 : num2.intValue()));
        } else {
            qn2 qn2VarA3 = ln4Var.a();
            pg pgVar3 = yx1.X;
            if (Objects.equals(qn2VarA3.p(pgVar3, null), 2)) {
                ln4Var.a().g(dy1.s, 32);
            } else if (Objects.equals(ln4Var.a().p(pgVar3, null), 3)) {
                ln4Var.a().g(dy1.s, 32);
                ln4Var.a().g(dy1.t, 256);
            } else if (Objects.equals(ln4Var.a().p(pgVar3, null), 1)) {
                ln4Var.a().g(dy1.s, 4101);
                ln4Var.a().g(dy1.u, oz0.c);
            } else if (z) {
                ln4Var.a().g(dy1.s, 35);
            } else {
                List list = (List) ln4Var.a().p(hy1.E, null);
                if (list == null || G(256, list)) {
                    ln4Var.a().g(dy1.s, 256);
                } else if (G(35, list)) {
                    ln4Var.a().g(dy1.s, 35);
                }
            }
        }
        return ln4Var.b();
    }

    public final String toString() {
        return "ImageCapture:".concat(g());
    }

    @Override // defpackage.in4
    public final void v() {
        mq3 mq3Var = this.s;
        mq3Var.b();
        mq3Var.a();
        sa4 sa4Var = this.v;
        if (sa4Var != null) {
            sa4Var.b();
        }
    }

    @Override // defpackage.in4
    public final ih w(ka0 ka0Var) {
        this.t.a(ka0Var);
        Object[] objArr = {this.t.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        C(DesugarCollections.unmodifiableList(arrayList));
        r90 r90VarB = this.h.b();
        r90VarB.f = ka0Var;
        return r90VarB.e();
    }

    @Override // defpackage.in4
    public final ih x(ih ihVar, ih ihVar2) {
        ez4.o("ImageCapture", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + ihVar + ", secondaryStreamSpec " + ihVar2);
        pt3 pt3VarE = E(e(), (yx1) this.g, ihVar);
        this.t = pt3VarE;
        Object[] objArr = {pt3VarE.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        C(DesugarCollections.unmodifiableList(arrayList));
        o();
        return ihVar;
    }

    @Override // defpackage.in4
    public final void y() {
        mq3 mq3Var = this.s;
        mq3Var.b();
        mq3Var.a();
        sa4 sa4Var = this.v;
        if (sa4Var != null) {
            sa4Var.b();
        }
        D(false);
        d().M(null);
    }
}
