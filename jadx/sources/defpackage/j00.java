package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j00 implements wx {
    public final jz A;
    public final uy A0;
    public in4 E0;
    public z34 F0;
    public final lb G0;
    public final lb H0;
    public final e24 J0;
    public final ow Z;
    public final i5 b;
    public final i5 f;
    public final pn4 z;
    public final ArrayList X = new ArrayList();
    public final ArrayList Y = new ArrayList();
    public List y0 = Collections.EMPTY_LIST;
    public Range z0 = ih.h;
    public final Object B0 = new Object();
    public boolean C0 = true;
    public ka0 D0 = null;
    public final e24 I0 = new e24(1);

    public j00(mz mzVar, mz mzVar2, h5 h5Var, h5 h5Var2, lb lbVar, lb lbVar2, ow owVar, e24 e24Var, pn4 pn4Var) {
        uy uyVar = h5Var.c;
        this.A0 = uyVar;
        this.b = new i5(mzVar, h5Var);
        if (mzVar2 == null || h5Var2 == null) {
            this.f = null;
        } else {
            this.f = new i5(mzVar2, h5Var2);
        }
        this.G0 = lbVar;
        this.H0 = lbVar2;
        this.Z = owVar;
        this.z = pn4Var;
        String strD = h5Var2 != null ? h5Var2.a.d() : null;
        vg vgVar = (vg) ((zf2) uyVar).f;
        String strD2 = h5Var.a.d();
        strD2.getClass();
        ArrayList arrayListL = e70.L(strD2);
        if (strD != null) {
            arrayListL.add(strD);
        }
        this.A = new jz(arrayListL, vgVar);
        this.J0 = e24Var;
    }

    public static HashMap A(ArrayList arrayList, pn4 pn4Var, pn4 pn4Var2, Range range) {
        mn4 mn4VarF;
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            in4 in4Var = (in4) it.next();
            if (in4Var instanceof z34) {
                z34 z34Var = (z34) in4Var;
                k43 k43Var = new k43(sw2.a(new qx(4).b));
                gy1.e(k43Var);
                j43 j43Var = new j43(k43Var);
                j43Var.q = j43.x;
                mn4 mn4VarF2 = j43Var.f(false, pn4Var);
                if (mn4VarF2 == null) {
                    mn4VarF = null;
                } else {
                    qn2 qn2VarD = qn2.d(mn4VarF2);
                    qn2VarD.b.remove(ta4.U);
                    mn4VarF = ((o00) z34Var.l(qn2VarD)).b();
                }
            } else {
                mn4VarF = in4Var.f(false, pn4Var);
            }
            mn4 mn4VarF3 = in4Var.f(true, pn4Var2);
            qn2 qn2VarD2 = mn4VarF3 != null ? qn2.d(mn4VarF3) : qn2.c();
            qn2VarD2.g(mn4.f0, 0);
            if (!ih.h.equals(range)) {
                qn2VarD2.f(mn4.g0, ia0.f, range);
                qn2VarD2.g(mn4.h0, Boolean.TRUE);
            }
            mn4 mn4VarB = in4Var.l(qn2VarD2).b();
            i00 i00Var = new i00();
            i00Var.a = mn4VarF;
            i00Var.b = mn4VarB;
            map.put(in4Var, i00Var);
        }
        return map;
    }

    public static boolean F(in4 in4Var) {
        if (in4Var != null) {
            if (!in4Var.g.K(mn4.k0)) {
                a1.d("CameraUseCaseAdapter", in4Var + " UseCase does not have capture type.");
            } else if (in4Var.g.M() == on4.A) {
                return true;
            }
        }
        return false;
    }

    public static void H(HashMap map) {
        HashSet hashSet;
        for (Map.Entry entry : map.entrySet()) {
            in4 in4Var = (in4) entry.getKey();
            Set set = (Set) entry.getValue();
            if (set != null) {
                in4Var.getClass();
                hashSet = new HashSet(set);
            } else {
                hashSet = null;
            }
            in4Var.f = hashSet;
        }
    }

    public static ArrayList K(ArrayList arrayList, List list) {
        ArrayList arrayList2 = new ArrayList(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((in4) it.next()).getClass();
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                throw dw2.z(it2);
            }
        }
        return arrayList2;
    }

    public static HashMap j(LinkedHashSet linkedHashSet, cp1 cp1Var) {
        HashMap map = new HashMap();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            in4 in4Var = (in4) it.next();
            map.put(in4Var, in4Var.f);
            HashSet hashSet = null;
            LinkedHashSet linkedHashSet2 = cp1Var != null ? (LinkedHashSet) cp1Var.f : null;
            if (linkedHashSet2 != null) {
                hashSet = new HashSet(linkedHashSet2);
            }
            in4Var.f = hashSet;
        }
        return map;
    }

    public static Matrix v(Rect rect, Size size) {
        r25.f(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    public static xx1 w() {
        qx qxVar = new qx(3);
        pg pgVar = ta4.T;
        qn2 qn2Var = qxVar.b;
        qn2Var.g(pgVar, "ImageCapture-Extra");
        Integer num = (Integer) qn2Var.p(yx1.A, null);
        if (num != null) {
            qn2Var.g(dy1.s, num);
        } else {
            ux1 ux1Var = xx1.y;
            pg pgVar2 = yx1.X;
            if (Objects.equals(qn2Var.p(pgVar2, null), 2)) {
                qn2Var.g(dy1.s, 32);
            } else if (Objects.equals(qn2Var.p(pgVar2, null), 3)) {
                qn2Var.g(dy1.s, 32);
                qn2Var.g(dy1.t, 256);
            } else if (Objects.equals(qn2Var.p(pgVar2, null), 1)) {
                qn2Var.g(dy1.s, 4101);
                qn2Var.g(dy1.u, oz0.c);
            } else {
                qn2Var.g(dy1.s, 256);
            }
        }
        yx1 yx1Var = new yx1(sw2.a(qn2Var));
        gy1.e(yx1Var);
        xx1 xx1Var = new xx1(yx1Var);
        Size size = (Size) qn2Var.p(hy1.B, null);
        if (size != null) {
            new Rational(size.getWidth(), size.getHeight());
        }
        r25.i((Executor) qn2Var.p(c22.H, d22.a()), "The IO executor can't be null");
        pg pgVar3 = yx1.z;
        if (qn2Var.b.containsKey(pgVar3)) {
            Integer num2 = (Integer) qn2Var.u(pgVar3);
            if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                vp1.h(num2, "The flash mode is not allowed to set: ");
                return null;
            }
            if (num2.intValue() == 3 && qn2Var.p(yx1.z0, null) == null) {
                xe.k("A ScreenFlash instance is required for FLASH_MODE_SCREEN but was not found. If value from PreviewView.getScreenFlash() is set to ImageCapture.setScreenFlash(), ensure PreviewView.setScreenFlashWindow() is invoked first.");
                return null;
            }
        }
        return xx1Var;
    }

    public final HashSet B(LinkedHashSet linkedHashSet, boolean z) {
        int i;
        HashSet hashSet = new HashSet();
        synchronized (this.B0) {
            Iterator it = this.y0.iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    throw null;
                }
                throw new ClassCastException();
            }
            i = z ? 3 : 0;
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            in4 in4Var = (in4) it2.next();
            r25.f(!(in4Var instanceof z34), "Only support one level of sharing for now.");
            Iterator it3 = in4Var.k().iterator();
            while (true) {
                if (it3.hasNext()) {
                    int iIntValue = ((Integer) it3.next()).intValue();
                    if ((i & iIntValue) == iIntValue) {
                        hashSet.add(in4Var);
                        break;
                    }
                }
            }
        }
        return hashSet;
    }

    public final List C() {
        ArrayList arrayList;
        synchronized (this.B0) {
            arrayList = new ArrayList(this.X);
        }
        return arrayList;
    }

    public final void D() {
        synchronized (this.B0) {
            ((zf2) this.A0).m0();
        }
    }

    public final boolean E() {
        boolean z;
        synchronized (this.B0) {
            zf2 zf2Var = (zf2) this.A0;
            zf2Var.getClass();
            int i = ty.a;
            z = ((Integer) ((sw2) zf2Var.m()).p(uy.h, 0)).intValue() == 1;
        }
        return z;
    }

    public final void G(ArrayList arrayList) {
        synchronized (this.B0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((in4) it.next()).f = null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.X);
            linkedHashSet.removeAll(arrayList);
            g(t(linkedHashSet, this.f != null));
        }
    }

    public final void I() {
        synchronized (this.B0) {
            try {
                ka0 ka0Var = this.D0;
                if (ka0Var != null) {
                    this.b.z.x(ka0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void J(List list) {
        synchronized (this.B0) {
            this.y0 = list;
        }
    }

    public final void L(Range range) {
        synchronized (this.B0) {
            this.z0 = range;
        }
    }

    public final void M() {
        synchronized (this.B0) {
        }
    }

    public final void N() {
        synchronized (this.B0) {
        }
    }

    @Override // defpackage.wx
    public final kz b() {
        return this.b.f;
    }

    @Override // defpackage.wx
    public final xy d() {
        return this.b.z;
    }

    public final void e(Collection collection, cp1 cp1Var) {
        ez4.o("CameraUseCaseAdapter", "addUseCases: appUseCasesToAdd = " + collection + ", featureGroup = " + cp1Var);
        synchronized (this.B0) {
            try {
                i5 i5Var = this.b;
                uy uyVar = this.A0;
                i5Var.c(uyVar);
                i5 i5Var2 = this.f;
                if (i5Var2 != null) {
                    i5Var2.c(uyVar);
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.X);
                linkedHashSet.addAll(collection);
                HashMap mapJ = j(linkedHashSet, cp1Var);
                try {
                    g(t(linkedHashSet, this.f != null));
                } catch (IllegalArgumentException e) {
                    H(mapJ);
                    throw new h00(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(ev evVar) {
        Map map = evVar.i.a;
        ArrayList<in4> arrayList = evVar.b;
        synchronized (this.B0) {
            try {
                for (in4 in4Var : arrayList) {
                    Rect rectH = this.b.f.a.h();
                    ih ihVar = (ih) map.get(in4Var);
                    ihVar.getClass();
                    in4Var.z(v(rectH, ihVar.a));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        List list = this.y0;
        ArrayList arrayList2 = evVar.b;
        LinkedHashSet linkedHashSet = evVar.a;
        ArrayList arrayListK = K(arrayList2, list);
        ArrayList arrayList3 = new ArrayList(linkedHashSet);
        arrayList3.removeAll(arrayList2);
        ArrayList arrayListK2 = K(arrayList3, arrayListK);
        if (!arrayListK2.isEmpty()) {
            ez4.a0("CameraUseCaseAdapter", "Unused effects: " + arrayListK2);
        }
        Iterator it = evVar.e.iterator();
        while (it.hasNext()) {
            ((in4) it.next()).B(this.b);
        }
        this.b.l(evVar.e);
        if (this.f != null) {
            for (in4 in4Var2 : evVar.e) {
                i5 i5Var = this.f;
                Objects.requireNonNull(i5Var);
                in4Var2.B(i5Var);
            }
            i5 i5Var2 = this.f;
            Objects.requireNonNull(i5Var2);
            i5Var2.l(evVar.e);
        }
        if (evVar.e.isEmpty()) {
            for (in4 in4Var3 : evVar.d) {
                Map map2 = evVar.i.a;
                if (map2.containsKey(in4Var3)) {
                    ih ihVar2 = (ih) map2.get(in4Var3);
                    Objects.requireNonNull(ihVar2);
                    ka0 ka0Var = ihVar2.f;
                    if (ka0Var != null) {
                        tt3 tt3Var = in4Var3.n;
                        sw2 sw2Var = tt3Var.g.b;
                        Objects.requireNonNull(ka0Var);
                        if (ka0Var.t().size() == tt3Var.g.b.t().size()) {
                            for (pg pgVar : ka0Var.t()) {
                                if (!sw2Var.b.containsKey(pgVar) || !Objects.equals(sw2Var.u(pgVar), ka0Var.u(pgVar))) {
                                }
                            }
                        }
                        in4Var3.h = in4Var3.w(ka0Var);
                        if (this.C0) {
                            this.b.j(in4Var3);
                            i5 i5Var3 = this.f;
                            if (i5Var3 != null) {
                                i5Var3.j(in4Var3);
                            }
                        }
                    }
                }
            }
        }
        for (in4 in4Var4 : evVar.c) {
            i00 i00Var = (i00) evVar.h.get(in4Var4);
            Objects.requireNonNull(i00Var);
            i5 i5Var4 = this.f;
            i5 i5Var5 = this.b;
            mn4 mn4Var = i00Var.a;
            if (i5Var4 != null) {
                in4Var4.b(i5Var5, i5Var4, mn4Var, i00Var.b);
                ih ihVar3 = (ih) evVar.i.a.get(in4Var4);
                ihVar3.getClass();
                b44 b44Var = evVar.j;
                b44Var.getClass();
                in4Var4.h = in4Var4.x(ihVar3, (ih) b44Var.a.get(in4Var4));
            } else {
                in4Var4.b(i5Var5, null, mn4Var, i00Var.b);
                ih ihVar4 = (ih) evVar.i.a.get(in4Var4);
                ihVar4.getClass();
                in4Var4.h = in4Var4.x(ihVar4, null);
            }
        }
        if (this.C0) {
            this.b.m(evVar.c);
            i5 i5Var6 = this.f;
            if (i5Var6 != null) {
                i5Var6.m(evVar.c);
            }
        }
        Iterator it2 = evVar.c.iterator();
        while (it2.hasNext()) {
            ((in4) it2.next()).q();
        }
        this.X.clear();
        this.X.addAll(evVar.a);
        this.Y.clear();
        this.Y.addAll(evVar.b);
        this.E0 = evVar.g;
        this.F0 = evVar.f;
    }

    public final void n() {
        synchronized (this.B0) {
            try {
                if (!this.C0) {
                    if (!this.Y.isEmpty()) {
                        this.b.c(this.A0);
                        i5 i5Var = this.f;
                        if (i5Var != null) {
                            i5Var.c(this.A0);
                        }
                    }
                    this.b.m(this.Y);
                    i5 i5Var2 = this.f;
                    if (i5Var2 != null) {
                        i5Var2.m(this.Y);
                    }
                    I();
                    Iterator it = this.Y.iterator();
                    while (it.hasNext()) {
                        ((in4) it.next()).q();
                    }
                    this.C0 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        synchronized (this.B0) {
            g5 g5Var = this.b.z;
            this.D0 = ((xy) g5Var.f).c0();
            g5Var.n0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x015d, code lost:
    
        if (r3 != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0163, code lost:
    
        return t(r19, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ev t(java.util.LinkedHashSet r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j00.t(java.util.LinkedHashSet, boolean):ev");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.in4 u(java.util.LinkedHashSet r8, defpackage.z34 r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.B0
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L15
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L15
            if (r9 == 0) goto L18
            r1.add(r9)     // Catch: java.lang.Throwable -> L15
            es4 r8 = r9.q     // Catch: java.lang.Throwable -> L15
            java.util.HashSet r8 = r8.b     // Catch: java.lang.Throwable -> L15
            r1.removeAll(r8)     // Catch: java.lang.Throwable -> L15
            goto L18
        L15:
            r7 = move-exception
            goto Lb5
        L18:
            boolean r8 = r7.E()     // Catch: java.lang.Throwable -> L15
            if (r8 == 0) goto Lb2
            java.util.Iterator r8 = r1.iterator()     // Catch: java.lang.Throwable -> L15
            r9 = 0
            r2 = r9
            r3 = r2
        L25:
            boolean r4 = r8.hasNext()     // Catch: java.lang.Throwable -> L15
            r5 = 1
            if (r4 == 0) goto L43
            java.lang.Object r4 = r8.next()     // Catch: java.lang.Throwable -> L15
            in4 r4 = (defpackage.in4) r4     // Catch: java.lang.Throwable -> L15
            boolean r6 = r4 instanceof defpackage.j43     // Catch: java.lang.Throwable -> L15
            if (r6 != 0) goto L41
            boolean r6 = r4 instanceof defpackage.z34     // Catch: java.lang.Throwable -> L15
            if (r6 == 0) goto L3b
            goto L41
        L3b:
            boolean r4 = r4 instanceof defpackage.xx1     // Catch: java.lang.Throwable -> L15
            if (r4 == 0) goto L25
            r2 = r5
            goto L25
        L41:
            r3 = r5
            goto L25
        L43:
            if (r2 == 0) goto L80
            if (r3 != 0) goto L80
            in4 r7 = r7.E0     // Catch: java.lang.Throwable -> L15
            boolean r8 = r7 instanceof defpackage.j43     // Catch: java.lang.Throwable -> L15
            if (r8 == 0) goto L4f
            goto Lb3
        L4f:
            qx r7 = new qx     // Catch: java.lang.Throwable -> L15
            r8 = 4
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L15
            java.lang.String r8 = "Preview-Extra"
            qn2 r9 = r7.b     // Catch: java.lang.Throwable -> L15
            pg r1 = defpackage.ta4.T     // Catch: java.lang.Throwable -> L15
            r9.g(r1, r8)     // Catch: java.lang.Throwable -> L15
            k43 r8 = new k43     // Catch: java.lang.Throwable -> L15
            qn2 r7 = r7.b     // Catch: java.lang.Throwable -> L15
            sw2 r7 = defpackage.sw2.a(r7)     // Catch: java.lang.Throwable -> L15
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L15
            defpackage.gy1.e(r8)     // Catch: java.lang.Throwable -> L15
            j43 r7 = new j43     // Catch: java.lang.Throwable -> L15
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L15
            java.util.concurrent.ScheduledExecutorService r8 = defpackage.j43.x     // Catch: java.lang.Throwable -> L15
            r7.q = r8     // Catch: java.lang.Throwable -> L15
            xe r8 = new xe     // Catch: java.lang.Throwable -> L15
            r9 = 20
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L15
            r7.E(r8)     // Catch: java.lang.Throwable -> L15
            goto Lb3
        L80:
            java.util.Iterator r8 = r1.iterator()     // Catch: java.lang.Throwable -> L15
            r1 = r9
        L85:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto La2
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L15
            in4 r2 = (defpackage.in4) r2     // Catch: java.lang.Throwable -> L15
            boolean r3 = r2 instanceof defpackage.j43     // Catch: java.lang.Throwable -> L15
            if (r3 != 0) goto La0
            boolean r3 = r2 instanceof defpackage.z34     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L9a
            goto La0
        L9a:
            boolean r2 = r2 instanceof defpackage.xx1     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L85
            r1 = r5
            goto L85
        La0:
            r9 = r5
            goto L85
        La2:
            if (r9 == 0) goto Lb2
            if (r1 != 0) goto Lb2
            in4 r7 = r7.E0     // Catch: java.lang.Throwable -> L15
            boolean r8 = r7 instanceof defpackage.xx1     // Catch: java.lang.Throwable -> L15
            if (r8 == 0) goto Lad
            goto Lb3
        Lad:
            xx1 r7 = w()     // Catch: java.lang.Throwable -> L15
            goto Lb3
        Lb2:
            r7 = 0
        Lb3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r7
        Lb5:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j00.u(java.util.LinkedHashSet, z34):in4");
    }

    public final z34 x(LinkedHashSet linkedHashSet, boolean z) {
        boolean z2;
        synchronized (this.B0) {
            try {
                HashSet<in4> hashSetB = B(linkedHashSet, z);
                if (hashSetB.size() < 2) {
                    D();
                    return null;
                }
                z34 z34Var = this.F0;
                if (z34Var != null && z34Var.q.b.equals(hashSetB)) {
                    z34 z34Var2 = this.F0;
                    z34Var2.getClass();
                    HashSet hashSet = ((in4) hashSetB.iterator().next()).f;
                    z34Var2.f = hashSet != null ? new HashSet(hashSet) : null;
                    z34 z34Var3 = this.F0;
                    Objects.requireNonNull(z34Var3);
                    return z34Var3;
                }
                int[] iArr = {1, 2, 4};
                HashSet hashSet2 = new HashSet();
                for (in4 in4Var : hashSetB) {
                    for (int i = 0; i < 3; i++) {
                        int i2 = iArr[i];
                        Iterator it = in4Var.k().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            int iIntValue = ((Integer) it.next()).intValue();
                            if ((i2 & iIntValue) == iIntValue) {
                                z2 = true;
                                break;
                            }
                        }
                        if (z2) {
                            if (hashSet2.contains(Integer.valueOf(i2))) {
                                return null;
                            }
                            hashSet2.add(Integer.valueOf(i2));
                        }
                    }
                }
                return new z34(this.b, this.f, this.G0, this.H0, hashSetB, this.z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y() {
        synchronized (this.B0) {
            try {
                if (this.C0) {
                    this.b.l(new ArrayList(this.Y));
                    i5 i5Var = this.f;
                    if (i5Var != null) {
                        i5Var.l(new ArrayList(this.Y));
                    }
                    s();
                    this.C0 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int z() {
        synchronized (this.B0) {
            try {
                return this.Z.b() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
