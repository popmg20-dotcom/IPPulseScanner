package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.util.Size;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z34 extends in4 {
    public pt3 A;
    public qt3 B;
    public final a44 p;
    public final es4 q;
    public final lb r;
    public final lb s;
    public n02 t;
    public v92 u;
    public c74 v;
    public c74 w;
    public c74 x;
    public c74 y;
    public pt3 z;

    public z34(mz mzVar, mz mzVar2, lb lbVar, lb lbVar2, HashSet hashSet, pn4 pn4Var) {
        super(I(hashSet));
        this.p = I(hashSet);
        this.r = lbVar;
        this.s = lbVar2;
        this.q = new es4(mzVar, mzVar2, hashSet, pn4Var, new e04(4));
        HashSet hashSet2 = ((in4) hashSet.iterator().next()).f;
        this.f = hashSet2 != null ? new HashSet(hashSet2) : null;
    }

    public static ArrayList H(in4 in4Var) {
        ArrayList arrayList = new ArrayList();
        if (!(in4Var instanceof z34)) {
            arrayList.add(in4Var.g.M());
            return arrayList;
        }
        Iterator it = ((z34) in4Var).q.b.iterator();
        while (it.hasNext()) {
            arrayList.add(((in4) it.next()).g.M());
        }
        return arrayList;
    }

    public static a44 I(HashSet hashSet) {
        qn2 qn2VarC = qn2.c();
        new o00(qn2VarC);
        qn2VarC.g(dy1.s, 34);
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            in4 in4Var = (in4) it.next();
            if (in4Var.g.K(mn4.k0)) {
                arrayList.add(in4Var.g.M());
            } else {
                a1.d("StreamSharing", "A child does not have capture type.");
            }
        }
        qn2VarC.g(a44.f, arrayList);
        qn2VarC.g(hy1.y, 2);
        qn2VarC.g(mn4.o0, d44.PREVIEW_VIDEO_STILL);
        return new a44(sw2.a(qn2VarC));
    }

    public final void D() {
        qt3 qt3Var = this.B;
        if (qt3Var != null) {
            qt3Var.b();
            this.B = null;
        }
        c74 c74Var = this.v;
        if (c74Var != null) {
            c74Var.b();
            this.v = null;
        }
        c74 c74Var2 = this.w;
        if (c74Var2 != null) {
            c74Var2.b();
            this.w = null;
        }
        c74 c74Var3 = this.x;
        if (c74Var3 != null) {
            c74Var3.b();
            this.x = null;
        }
        c74 c74Var4 = this.y;
        if (c74Var4 != null) {
            c74Var4.b();
            this.y = null;
        }
        n02 n02Var = this.t;
        if (n02Var != null) {
            ((xm0) n02Var.f).e();
            co4.S(new ga1(20, n02Var));
            this.t = null;
        }
        v92 v92Var = this.u;
        if (v92Var != null) {
            ((yy0) v92Var.b).d();
            co4.S(new d4(24, v92Var));
            this.u = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List E(String str, String str2, mn4 mn4Var, ih ihVar, ih ihVar2) {
        boolean z;
        oz0 oz0Var = ihVar.c;
        co4.h();
        es4 es4Var = this.q;
        if (ihVar2 == null) {
            c74 c74VarF = F(str, str2, mn4Var, ihVar, null);
            mz mzVarC = c();
            Objects.requireNonNull(mzVarC);
            n02 n02Var = new n02(mzVarC, new xm0(oz0Var));
            this.t = n02Var;
            boolean z2 = this.j != null;
            int iF0 = ((hy1) this.g).f0(0);
            es4Var.getClass();
            HashMap map = new HashMap();
            for (in4 in4Var : es4Var.b) {
                uj3 uj3Var = es4Var.B0;
                mz mzVar = es4Var.Y;
                es4 es4Var2 = es4Var;
                boolean z3 = z2;
                bh bhVarD = es4Var2.d(in4Var, uj3Var, mzVar, c74VarF, iF0, z3);
                int iK = es4Var2.Y.b().k(((hy1) in4Var.g).f0(0));
                ds4 ds4Var = (ds4) es4Var2.z.get(in4Var);
                Objects.requireNonNull(ds4Var);
                ds4Var.z.c = iK;
                map.put(in4Var, bhVarD);
                es4Var = es4Var2;
                z2 = z3;
            }
            es4 es4Var3 = es4Var;
            boolean z4 = z2;
            ArrayList arrayList = new ArrayList(map.values());
            if (c74VarF == null) {
                zo2.n("Null surfaceEdge");
                return null;
            }
            co4.h();
            StringBuilder sb = new StringBuilder("SurfaceProcessorNode Transform (Processor=");
            xm0 xm0Var = (xm0) n02Var.f;
            sb.append(xm0Var);
            sb.append("\n   inputEdge = ");
            sb.append(c74VarF);
            ez4.o("SurfaceProcessorNode", sb.toString());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ez4.o("SurfaceProcessorNode", "   outputConfig = " + ((bh) it.next()));
            }
            n02Var.A = new zy0();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                bh bhVar = (bh) it2.next();
                zy0 zy0Var = (zy0) n02Var.A;
                Rect rect = bhVar.d;
                int i = bhVar.f;
                boolean z5 = bhVar.g;
                Matrix matrix = new Matrix(c74VarF.b);
                RectF rectF = new RectF(rect);
                Size size = bhVar.e;
                Iterator it3 = it2;
                matrix.postConcat(kg4.a(rectF, kg4.h(size), i, z5));
                r25.e(kg4.d(kg4.g(kg4.f(rect), i), false, size));
                HashMap map2 = map;
                Rect rect2 = new Rect(0, 0, size.getWidth(), size.getHeight());
                r90 r90VarB = c74VarF.g.b();
                r90VarB.a = size;
                zy0Var.put(bhVar, new c74(bhVar.b, bhVar.c, r90VarB.e(), matrix, false, rect2, c74VarF.i - i, -1, c74VarF.e != z5));
                it2 = it3;
                map = map2;
            }
            HashMap map3 = map;
            j74 j74VarC = c74VarF.c((mz) n02Var.z, true);
            if (xm0Var.e.get()) {
                j74VarC.c();
            } else {
                xm0Var.b(new s7(26, xm0Var, j74VarC), new wm0(j74VarC, 0));
            }
            for (Map.Entry entry : ((zy0) n02Var.A).entrySet()) {
                n02Var.h(c74VarF, entry);
                c74 c74Var = (c74) entry.getValue();
                b0 b0Var = new b0(15, n02Var, c74VarF, entry);
                c74Var.getClass();
                co4.h();
                c74Var.a();
                c74Var.m.add(b0Var);
            }
            c74VarF.o.add(new e74(0, (zy0) n02Var.A));
            zy0 zy0Var2 = (zy0) n02Var.A;
            HashMap map4 = new HashMap();
            for (Map.Entry entry2 : map3.entrySet()) {
                map4.put((in4) entry2.getKey(), (c74) zy0Var2.get(entry2.getValue()));
            }
            es4Var3.x(map4, es4Var3.u(c74VarF, z4));
            Object[] objArr = {this.z.c()};
            ArrayList arrayList2 = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList2.add(obj);
            return DesugarCollections.unmodifiableList(arrayList2);
        }
        c74 c74VarF2 = F(str, str2, mn4Var, ihVar, ihVar2);
        Matrix matrix2 = this.k;
        mz mzVarI = i();
        Objects.requireNonNull(mzVarI);
        boolean zP = mzVarI.p();
        Size size2 = ihVar2.a;
        Rect rect3 = this.j;
        if (rect3 != null) {
            z = false;
        } else {
            z = false;
            rect3 = new Rect(0, 0, size2.getWidth(), size2.getHeight());
        }
        mz mzVarI2 = i();
        Objects.requireNonNull(mzVarI2);
        int iH = h(mzVarI2, z);
        mz mzVarI3 = i();
        Objects.requireNonNull(mzVarI3);
        es4 es4Var4 = es4Var;
        c74 c74Var2 = new c74(3, 34, ihVar2, matrix2, zP, rect3, iH, -1, m(mzVarI3));
        this.w = c74Var2;
        Objects.requireNonNull(i());
        this.y = c74Var2;
        pt3 pt3VarG = G(this.w, mn4Var, ihVar2);
        this.A = pt3VarG;
        qt3 qt3Var = this.B;
        if (qt3Var != null) {
            qt3Var.b();
        }
        qt3 qt3Var2 = new qt3(new y34(this, str, str2, mn4Var, ihVar, ihVar2));
        this.B = qt3Var2;
        pt3VarG.f = qt3Var2;
        c74 c74Var3 = this.y;
        mz mzVarC2 = c();
        mz mzVarI4 = i();
        yy0 yy0Var = new yy0(oz0Var, this.r, this.s);
        v92 v92Var = new v92();
        v92Var.f = mzVarC2;
        v92Var.z = mzVarI4;
        v92Var.b = yy0Var;
        this.u = v92Var;
        boolean z6 = this.j != null;
        int iF02 = ((hy1) this.g).f0(0);
        es4Var4.getClass();
        HashMap map5 = new HashMap();
        for (in4 in4Var2 : es4Var4.b) {
            es4 es4Var5 = es4Var4;
            bh bhVarD2 = es4Var5.d(in4Var2, es4Var4.B0, es4Var4.Y, c74VarF2, iF02, z6);
            uj3 uj3Var2 = es4Var5.C0;
            Objects.requireNonNull(uj3Var2);
            mz mzVar2 = es4Var5.Z;
            Objects.requireNonNull(mzVar2);
            c74 c74Var4 = c74Var3;
            bh bhVarD3 = es4Var5.d(in4Var2, uj3Var2, mzVar2, c74Var4, iF02, z6);
            int iK2 = es4Var5.Y.b().k(((hy1) in4Var2.g).f0(0));
            ds4 ds4Var2 = (ds4) es4Var5.z.get(in4Var2);
            Objects.requireNonNull(ds4Var2);
            ds4Var2.z.c = iK2;
            map5.put(in4Var2, new rg(bhVarD2, bhVarD3));
            es4Var4 = es4Var5;
            c74Var3 = c74Var4;
        }
        c74 c74Var5 = c74Var3;
        es4 es4Var6 = es4Var4;
        v92 v92Var2 = this.u;
        ArrayList arrayList3 = new ArrayList(map5.values());
        sg sgVar = new sg(c74VarF2, c74Var5, arrayList3);
        v92Var2.getClass();
        co4.h();
        StringBuilder sb2 = new StringBuilder("DualSurfaceProcessorNode Transform Processor = ");
        yy0 yy0Var2 = (yy0) v92Var2.b;
        sb2.append(yy0Var2);
        sb2.append("\n   primary input = ");
        sb2.append(c74VarF2);
        sb2.append("\n   secondary input = ");
        sb2.append(c74Var5);
        ez4.o("DualSurfaceProcessorNode", sb2.toString());
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            ez4.o("SurfaceProcessorNode", "   outputConfig = " + ((rg) it4.next()));
        }
        v92Var2.X = sgVar;
        v92Var2.A = new zy0();
        sg sgVar2 = (sg) v92Var2.X;
        c74 c74Var6 = sgVar2.a;
        c74 c74Var7 = sgVar2.b;
        Iterator it5 = sgVar2.c.iterator();
        while (it5.hasNext()) {
            rg rgVar = (rg) it5.next();
            zy0 zy0Var3 = (zy0) v92Var2.A;
            bh bhVar2 = rgVar.a;
            Rect rect4 = bhVar2.d;
            int i2 = bhVar2.f;
            boolean z7 = bhVar2.g;
            Iterator it6 = it5;
            HashMap map6 = map5;
            Matrix matrix3 = new Matrix(c74Var6.b);
            RectF rectF2 = new RectF(rect4);
            Size size3 = bhVar2.e;
            matrix3.postConcat(kg4.a(rectF2, kg4.h(size3), i2, z7));
            r25.e(kg4.d(kg4.g(kg4.f(rect4), i2), false, size3));
            Rect rect5 = new Rect(0, 0, size3.getWidth(), size3.getHeight());
            r90 r90VarB2 = c74Var6.g.b();
            r90VarB2.a = size3;
            zy0Var3.put(rgVar, new c74(bhVar2.b, bhVar2.c, r90VarB2.e(), matrix3, false, rect5, c74Var6.i - i2, -1, c74Var6.e != z7));
            it5 = it6;
            map5 = map6;
        }
        HashMap map7 = map5;
        yy0Var2.c(c74Var6.c((mz) v92Var2.f, true));
        yy0Var2.c(c74Var7.c((mz) v92Var2.z, false));
        mz mzVar3 = (mz) v92Var2.f;
        mz mzVar4 = (mz) v92Var2.z;
        for (Map.Entry entry3 : ((zy0) v92Var2.A).entrySet()) {
            v92 v92Var3 = v92Var2;
            c74 c74Var8 = c74Var6;
            c74 c74Var9 = c74Var7;
            v92Var3.g(mzVar3, mzVar4, c74Var8, c74Var9, entry3);
            c74 c74Var10 = (c74) entry3.getValue();
            mz mzVar5 = mzVar4;
            mz mzVar6 = mzVar3;
            uw uwVar = new uw(v92Var3, mzVar6, mzVar5, c74Var8, c74Var9, entry3, 3);
            mzVar3 = mzVar6;
            mzVar4 = mzVar5;
            c74Var10.getClass();
            co4.h();
            c74Var10.a();
            c74Var10.m.add(uwVar);
            v92Var2 = v92Var3;
            c74Var6 = c74Var8;
            c74Var7 = c74Var9;
        }
        zy0 zy0Var4 = (zy0) v92Var2.A;
        HashMap map8 = new HashMap();
        for (Map.Entry entry4 : map7.entrySet()) {
            map8.put((in4) entry4.getKey(), (c74) zy0Var4.get(entry4.getValue()));
        }
        es4Var6.x(map8, es4Var6.u(c74VarF2, z6));
        Object[] objArr2 = {this.z.c(), this.A.c()};
        ArrayList arrayList4 = new ArrayList(2);
        for (int i3 = 0; i3 < 2; i3++) {
            Object obj2 = objArr2[i3];
            Objects.requireNonNull(obj2);
            arrayList4.add(obj2);
        }
        return DesugarCollections.unmodifiableList(arrayList4);
    }

    public final c74 F(String str, String str2, mn4 mn4Var, ih ihVar, ih ihVar2) {
        Matrix matrix = this.k;
        mz mzVarC = c();
        Objects.requireNonNull(mzVarC);
        boolean zP = mzVarC.p();
        Size size = ihVar.a;
        Rect rect = this.j;
        if (rect == null) {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        mz mzVarC2 = c();
        Objects.requireNonNull(mzVarC2);
        int iH = h(mzVarC2, false);
        mz mzVarC3 = c();
        Objects.requireNonNull(mzVarC3);
        c74 c74Var = new c74(3, 34, ihVar, matrix, zP, rect, iH, -1, m(mzVarC3));
        this.v = c74Var;
        Objects.requireNonNull(c());
        this.x = c74Var;
        pt3 pt3VarG = G(this.v, mn4Var, ihVar);
        this.z = pt3VarG;
        qt3 qt3Var = this.B;
        if (qt3Var != null) {
            qt3Var.b();
        }
        qt3 qt3Var2 = new qt3(new y34(this, str, str2, mn4Var, ihVar, ihVar2));
        this.B = qt3Var2;
        pt3VarG.f = qt3Var2;
        return this.x;
    }

    public final pt3 G(c74 c74Var, mn4 mn4Var, ih ihVar) {
        pt3 pt3VarD = pt3.d(mn4Var, ihVar.a);
        e10 e10Var = pt3VarD.b;
        es4 es4Var = this.q;
        Iterator it = es4Var.b.iterator();
        int i = -1;
        while (it.hasNext()) {
            int i2 = ((in4) it.next()).g.v().g.c;
            List list = tt3.j;
            if (list.indexOf(Integer.valueOf(i)) < list.indexOf(Integer.valueOf(i2))) {
                i = i2;
            }
        }
        if (i != -1) {
            e10Var.b = i;
        }
        Size size = ihVar.a;
        Iterator it2 = es4Var.b.iterator();
        while (it2.hasNext()) {
            tt3 tt3VarC = pt3.d(((in4) it2.next()).g, size).c();
            f10 f10Var = tt3VarC.g;
            e10Var.a(f10Var.d);
            List<yx> list2 = tt3VarC.e;
            ArrayList arrayList = pt3VarD.e;
            for (yx yxVar : list2) {
                e10Var.b(yxVar);
                if (!arrayList.contains(yxVar)) {
                    arrayList.add(yxVar);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback : tt3VarC.d) {
                ArrayList arrayList2 = pt3VarD.d;
                if (!arrayList2.contains(stateCallback)) {
                    arrayList2.add(stateCallback);
                }
            }
            for (CameraDevice.StateCallback stateCallback2 : tt3VarC.c) {
                ArrayList arrayList3 = pt3VarD.c;
                if (!arrayList3.contains(stateCallback2)) {
                    arrayList3.add(stateCallback2);
                }
            }
            e10Var.d(f10Var.b);
        }
        c74Var.getClass();
        co4.h();
        c74Var.a();
        r25.j("Consumer can only be linked once.", !c74Var.j);
        c74Var.j = true;
        pt3VarD.b(c74Var.l, ihVar.c, -1);
        e10Var.b(es4Var.y0);
        ka0 ka0Var = ihVar.f;
        if (ka0Var != null) {
            e10Var.d(ka0Var);
        }
        pt3VarD.h = ihVar.d;
        a(pt3VarD, ihVar);
        return pt3VarD;
    }

    @Override // defpackage.in4
    public final mn4 f(boolean z, pn4 pn4Var) {
        a44 a44Var = this.p;
        a44Var.getClass();
        ka0 ka0VarA = pn4Var.a(qe4.a(a44Var), 1);
        if (z) {
            ka0VarA = ha0.y(ka0VarA, a44Var.b);
        }
        if (ka0VarA == null) {
            return null;
        }
        return ((o00) l(ka0VarA)).b();
    }

    @Override // defpackage.in4
    public final Set j(kz kzVar) {
        HashSet hashSet = this.q.b;
        HashSet hashSet2 = null;
        if (hashSet.isEmpty()) {
            return null;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Set setJ = ((in4) it.next()).j(kzVar);
            if (setJ != null) {
                if (hashSet2 == null) {
                    hashSet2 = new HashSet(setJ);
                } else {
                    hashSet2.retainAll(setJ);
                }
            }
        }
        return hashSet2;
    }

    @Override // defpackage.in4
    public final Set k() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // defpackage.in4
    public final ln4 l(ka0 ka0Var) {
        return new o00(qn2.d(ka0Var));
    }

    @Override // defpackage.in4
    public final void r() {
        es4 es4Var = this.q;
        for (in4 in4Var : es4Var.b) {
            ds4 ds4Var = (ds4) es4Var.z.get(in4Var);
            Objects.requireNonNull(ds4Var);
            in4Var.b(ds4Var, null, null, in4Var.f(true, es4Var.X));
        }
    }

    @Override // defpackage.in4
    public final void s() {
        Iterator it = this.q.b.iterator();
        while (it.hasNext()) {
            ((in4) it.next()).s();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f4, code lost:
    
        if (r13 != false) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b0  */
    @Override // defpackage.in4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.mn4 t(defpackage.kz r17, defpackage.ln4 r18) {
        /*
            Method dump skipped, instruction units count: 689
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z34.t(kz, ln4):mn4");
    }

    @Override // defpackage.in4
    public final void u() {
        Iterator it = this.q.b.iterator();
        while (it.hasNext()) {
            ((in4) it.next()).u();
        }
    }

    @Override // defpackage.in4
    public final void v() {
        Iterator it = this.q.b.iterator();
        while (it.hasNext()) {
            ((in4) it.next()).v();
        }
    }

    @Override // defpackage.in4
    public final ih w(ka0 ka0Var) {
        this.z.a(ka0Var);
        Object[] objArr = {this.z.c()};
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
        ez4.o("StreamSharing", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + ihVar + ", secondaryStreamSpec " + ihVar2);
        C(E(e(), i() == null ? null : i().r().d(), this.g, ihVar, ihVar2));
        o();
        return ihVar;
    }

    @Override // defpackage.in4
    public final void y() {
        D();
        es4 es4Var = this.q;
        for (in4 in4Var : es4Var.b) {
            ds4 ds4Var = (ds4) es4Var.z.get(in4Var);
            Objects.requireNonNull(ds4Var);
            in4Var.B(ds4Var);
        }
    }
}
