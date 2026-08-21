package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ex implements mz {
    public final xq1 A;
    public CameraDevice A0;
    public int B0;
    public o10 C0;
    public final AtomicInteger D0;
    public nc2 E0;
    public vv F0;
    public final LinkedHashMap G0;
    public int H0;
    public final zw I0;
    public final ow J0;
    public final d00 K0;
    public final q00 L0;
    public final boolean M0;
    public final boolean N0;
    public boolean O0;
    public boolean P0;
    public boolean Q0;
    public cm2 R0;
    public final cm2 S0;
    public final cm2 T0;
    public final HashSet U0;
    public zf2 V0;
    public final Object W0;
    public final n02 X;
    public boolean X0;
    public final lb Y;
    public final sv0 Y0;
    public final nw Z;
    public final sz0 Z0;
    public final r64 a1;
    public final e24 b;
    public final lb b1;
    public volatile int c1 = 3;
    public final pz f;
    public final dx y0;
    public final at3 z;
    public final gx z0;

    public ex(Context context, pz pzVar, String str, gx gxVar, ow owVar, d00 d00Var, Executor executor, Handler handler, sv0 sv0Var, long j, q00 q00Var) throws e00 {
        n02 n02Var = new n02(4);
        this.X = n02Var;
        this.B0 = 0;
        this.D0 = new AtomicInteger(0);
        this.G0 = new LinkedHashMap();
        this.H0 = 0;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = true;
        this.U0 = new HashSet();
        this.V0 = wy.a;
        this.W0 = new Object();
        this.X0 = false;
        this.b1 = new lb(this);
        this.f = pzVar;
        this.J0 = owVar;
        this.K0 = d00Var;
        xq1 xq1Var = new xq1(handler);
        this.A = xq1Var;
        at3 at3Var = new at3(executor);
        this.z = at3Var;
        this.y0 = new dx(this, at3Var, xq1Var, j);
        this.b = new e24(str);
        ((on2) n02Var.f).i(new ad2(lz.CLOSED));
        lb lbVar = new lb(d00Var);
        this.Y = lbVar;
        cm2 cm2Var = new cm2(at3Var);
        this.S0 = cm2Var;
        this.Y0 = sv0Var;
        this.L0 = q00Var;
        try {
            sy syVarB = pzVar.b(str);
            int i = 11;
            nw nwVar = new nw(syVarB, xq1Var, at3Var, new cp1(i, this), gxVar.i);
            this.Z = nwVar;
            this.z0 = gxVar;
            gxVar.t(nwVar);
            gxVar.g.n((on2) lbVar.z);
            this.Z0 = sz0.d(syVarB);
            this.C0 = C();
            this.T0 = new cm2(at3Var, xq1Var, handler, cm2Var, gxVar.i, xt0.a, 14);
            oj1 oj1Var = gxVar.i;
            this.M0 = oj1Var.y(LegacyCameraOutputConfigNullPointerQuirk.class) || oj1Var.y(CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk.class);
            this.N0 = gxVar.i.y(LegacyCameraSurfaceCleanupQuirk.class);
            zw zwVar = new zw(this, str);
            this.I0 = zwVar;
            zf2 zf2Var = new zf2(10, this);
            synchronized (d00Var.b) {
                r25.j("Camera is already registered: " + this, !d00Var.e.containsKey(this));
                d00Var.e.put(this, new c00(at3Var, zf2Var, zwVar));
            }
            pzVar.a.I(at3Var, zwVar);
            this.a1 = new r64(context, str, pzVar, new vd3(i), mc1.r);
        } catch (xx e) {
            throw new e00(e);
        }
    }

    public static String A(in4 in4Var) {
        return in4Var.g() + in4Var.hashCode();
    }

    public static String y(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    public static String z(cm2 cm2Var) {
        StringBuilder sb = new StringBuilder("MeteringRepeating");
        cm2Var.getClass();
        sb.append(cm2Var.hashCode());
        return sb.toString();
    }

    public final boolean B(cm2 cm2Var) {
        int i;
        q00 q00Var;
        cm2Var.getClass();
        ArrayList arrayList = new ArrayList();
        synchronized (this.W0) {
            try {
                i = this.J0.b() == 2 ? 1 : 0;
            } finally {
            }
        }
        e24 e24Var = this.b;
        e24Var.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) e24Var.z).entrySet()) {
            if (((jn4) entry.getValue()).e) {
                arrayList2.add((jn4) entry.getValue());
            }
        }
        for (jn4 jn4Var : DesugarCollections.unmodifiableCollection(arrayList2)) {
            List list = jn4Var.d;
            if (list == null || list.get(0) != on4.Y) {
                if (jn4Var.c == null || jn4Var.d == null) {
                    ez4.a0("Camera2CameraImpl", "Invalid stream spec or capture types in " + jn4Var);
                    break;
                }
                tt3 tt3Var = jn4Var.a;
                mn4 mn4Var = jn4Var.b;
                for (dn0 dn0Var : tt3Var.b()) {
                    r64 r64Var = this.a1;
                    int iN = mn4Var.n();
                    Size size = dn0Var.h;
                    d44 d44VarJ = mn4Var.J();
                    ph phVarL = r64Var.l(iN);
                    u64 u64Var = u64.f;
                    d44 d44Var = w64.e;
                    w64 w64VarJ0 = tj4.j0(iN, size, phVarL, i, u64Var, d44VarJ);
                    int iN2 = mn4Var.n();
                    Size size2 = dn0Var.h;
                    ih ihVar = jn4Var.c;
                    arrayList.add(new jg(w64VarJ0, iN2, size2, ihVar.c, jn4Var.d, ihVar.f, ihVar.d, ihVar.e, mn4Var.X()));
                }
            }
        }
        HashMap map = new HashMap();
        map.put((bm2) cm2Var.A, Collections.singletonList((Size) cm2Var.X));
        try {
            this.a1.j(i, arrayList, map, false, false, false);
            w("Surface combination with metering repeating supported!", null);
            q00Var = this.L0;
        } catch (IllegalArgumentException e) {
            w("Surface combination with metering repeating  not supported!", e);
        }
        return (q00Var == null || ((Boolean) q00Var.b.p(q00.D0, Boolean.TRUE)).booleanValue()) ? false : true;
    }

    public final o10 C() {
        o10 o10Var;
        synchronized (this.W0) {
            try {
                q00 q00Var = this.L0;
                if (q00Var != null) {
                    pg pgVar = lx.a;
                    if (q00Var.b.p(lx.a, null) != null) {
                        throw new ClassCastException();
                    }
                }
                o10Var = new o10(this.Z0, this.z0.i, false);
            } catch (Throwable th) {
                throw th;
            }
        }
        return o10Var;
    }

    public final void D(boolean z) {
        if (!z) {
            this.y0.e.b = -1L;
        }
        this.y0.a();
        this.b1.n();
        w("Opening camera.", null);
        G(9);
        try {
            this.f.a.F(this.z0.a, this.z, v());
        } catch (SecurityException e) {
            w("Unable to open camera due to " + e.getMessage(), null);
            G(8);
            this.y0.b();
        } catch (RuntimeException e2) {
            w("Unexpected error occurred when opening camera.", e2);
            H(5, new mg(null, 6), true);
        } catch (xx e3) {
            w("Unable to open camera due to " + e3.getMessage(), null);
            if (e3.b == 10001) {
                H(3, new mg(e3, 7), true);
                return;
            }
            lb lbVar = this.b1;
            int i = ((ex) lbVar.z).c1;
            ex exVar = (ex) lbVar.z;
            if (i != 9) {
                exVar.w("Don't need the onError timeout handler.", null);
                return;
            }
            exVar.w("Camera waiting for onError.", null);
            lbVar.n();
            lbVar.f = new ed4(lbVar);
        }
    }

    public final void E() {
        int i = 0;
        int i2 = 1;
        r25.j(null, this.c1 == 10);
        st3 st3VarR = this.b.r();
        if (!st3VarR.c()) {
            w("Unable to create capture session due to conflicting configurations", null);
            return;
        }
        if (!this.K0.e(this.A0.getId(), this.J0.c(this.A0.getId()))) {
            w("Unable to create capture session in camera operating mode = " + this.J0.b(), null);
            return;
        }
        HashMap map = new HashMap();
        Collection<tt3> collectionS = this.b.s();
        Collection collectionT = this.b.t();
        pg pgVar = e44.a;
        collectionS.getClass();
        collectionT.getClass();
        ArrayList arrayList = new ArrayList(collectionT);
        Iterator it = collectionS.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            tt3 tt3Var = (tt3) it.next();
            if (tt3Var.g.b.b.containsKey(pgVar) && tt3Var.b().size() != 1) {
                ez4.q("StreamUseCaseUtil", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Arrays.copyOf(new Object[]{Integer.valueOf(tt3Var.b().size())}, 1)));
                break;
            }
            if (tt3Var.g.b.b.containsKey(pgVar)) {
                int i3 = 0;
                for (tt3 tt3Var2 : collectionS) {
                    if (((mn4) arrayList.get(i3)).M() == on4.Y) {
                        tt3Var2.b().getClass();
                        r25.j("MeteringRepeating should contain a surface", !r10.isEmpty());
                        map.put(tt3Var2.b().get(0), 1L);
                    } else if (tt3Var2.g.b.b.containsKey(pgVar)) {
                        List listB = tt3Var2.b();
                        listB.getClass();
                        if (!listB.isEmpty()) {
                            Object obj = tt3Var2.b().get(0);
                            Object objU = tt3Var2.g.b.u(pgVar);
                            objU.getClass();
                            map.put(obj, objU);
                        }
                    }
                    i3++;
                }
            }
        }
        ez4.o("StreamUseCaseUtil", "populateSurfaceToStreamUseCaseMapping() - streamUseCaseMap = " + map);
        o10 o10Var = this.C0;
        synchronized (o10Var.a) {
            o10Var.m = map;
        }
        o10 o10Var2 = this.C0;
        tt3 tt3VarB = st3VarR.b();
        CameraDevice cameraDevice = this.A0;
        cameraDevice.getClass();
        cm2 cm2Var = this.T0;
        nc2 nc2VarN = o10Var2.n(tt3VarB, cameraDevice, new m84((oj1) cm2Var.Y, (oj1) cm2Var.Z, (cm2) cm2Var.X, (at3) cm2Var.f, (xq1) cm2Var.z, (Handler) cm2Var.A));
        nc2VarN.a(new um1(i, nc2VarN, new yw(this, o10Var2, i2)), this.z);
    }

    public final void F() {
        tt3 tt3Var;
        int i = 0;
        r25.j(null, this.C0 != null);
        w("Resetting Capture Session", null);
        o10 o10Var = this.C0;
        synchronized (o10Var.a) {
            tt3Var = o10Var.f;
        }
        List listF = o10Var.f();
        o10 o10VarC = C();
        this.C0 = o10VarC;
        o10VarC.p(tt3Var);
        this.C0.l(listF);
        if (fw.G(this.c1) != 9) {
            w("Skipping Capture Session state check due to current camera state: " + fw.H(this.c1) + " and previous session status: " + o10Var.j(), null);
        } else if (this.M0 && o10Var.j()) {
            w("Close camera before creating new session", null);
            G(7);
        }
        if (this.N0 && o10Var.j()) {
            w("ConfigAndClose is required when close the camera.", null);
            this.O0 = true;
        }
        o10Var.b();
        nc2 nc2VarO = o10Var.o();
        w("Releasing session in state ".concat(fw.F(this.c1)), null);
        this.G0.put(o10Var, nc2VarO);
        nc2VarO.a(new um1(i, nc2VarO, new yw(this, o10Var, i)), yu0.a());
    }

    public final void G(int i) {
        H(i, null, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:28:0x009e, B:31:0x00a6, B:33:0x00ae, B:46:0x00e0, B:50:0x00e6, B:52:0x00ef, B:54:0x00f3, B:56:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x011c, B:64:0x0122, B:66:0x0134, B:74:0x0160, B:75:0x0163, B:67:0x0144, B:69:0x0148, B:71:0x014c, B:35:0x00b6, B:37:0x00c9, B:41:0x00d0, B:43:0x00d7), top: B:94:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(int r10, defpackage.mg r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ex.H(int, mg, boolean):void");
    }

    public final ArrayList I(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            in4 in4Var = (in4) it.next();
            boolean z = this.Q0;
            String strA = A(in4Var);
            Class<?> cls = in4Var.getClass();
            tt3 tt3Var = z ? in4Var.n : in4Var.o;
            mn4 mn4Var = in4Var.g;
            ih ihVar = in4Var.h;
            arrayList2.add(new kg(strA, cls, tt3Var, mn4Var, ihVar != null ? ihVar.a : null, ihVar, in4Var.c() != null ? z34.H(in4Var) : null));
        }
        return arrayList2;
    }

    public final void J(ArrayList arrayList) {
        Size size;
        boolean zIsEmpty = this.b.s().isEmpty();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        Rational rational = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            kg kgVar = (kg) it.next();
            if (!this.b.v(kgVar.a)) {
                e24 e24Var = this.b;
                String str = kgVar.a;
                tt3 tt3Var = kgVar.c;
                mn4 mn4Var = kgVar.d;
                ih ihVar = kgVar.f;
                List list = kgVar.g;
                LinkedHashMap linkedHashMap = (LinkedHashMap) e24Var.z;
                jn4 jn4Var = (jn4) linkedHashMap.get(str);
                if (jn4Var == null) {
                    jn4Var = new jn4(tt3Var, mn4Var, ihVar, list);
                    linkedHashMap.put(str, jn4Var);
                }
                jn4Var.e = true;
                e24Var.H(str, tt3Var, mn4Var, ihVar, list);
                arrayList2.add(kgVar.a);
                if (kgVar.b == j43.class && (size = kgVar.e) != null) {
                    rational = new Rational(size.getWidth(), size.getHeight());
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        w("Use cases [" + TextUtils.join(", ", arrayList2) + "] now ATTACHED", null);
        if (zIsEmpty) {
            this.Z.h(true);
            nw nwVar = this.Z;
            synchronized (nwVar.z) {
                nwVar.G0++;
            }
        }
        s();
        O();
        N();
        M();
        F();
        if (this.c1 == 10) {
            E();
        } else {
            int iG = fw.G(this.c1);
            if (iG == 2 || iG == 3 || iG == 4) {
                K(false);
            } else if (iG != 5) {
                w("open() ignored due to being in state: ".concat(fw.H(this.c1)), null);
            } else {
                G(8);
                if (!this.G0.isEmpty() && !this.P0 && this.B0 == 0) {
                    r25.j("Camera Device should be open if session close is not complete", this.A0 != null);
                    G(10);
                    E();
                }
            }
        }
        if (rational != null) {
            this.Z.Z.getClass();
        }
    }

    public final void K(boolean z) {
        w("Attempting to force open the camera.", null);
        if (this.K0.d(this)) {
            D(z);
        } else {
            w("No cameras available. Waiting for available camera before opening camera.", null);
            G(4);
        }
    }

    public final void L(boolean z) {
        w("Attempting to open the camera.", null);
        if (this.I0.b && this.K0.d(this)) {
            D(z);
        } else {
            w("No cameras available. Waiting for available camera before opening camera.", null);
            G(4);
        }
    }

    public final void M() {
        st3 st3VarO = this.b.o();
        boolean zC = st3VarO.c();
        nw nwVar = this.Z;
        if (!zC) {
            nwVar.M0 = 1;
            nwVar.Z.c = 1;
            nwVar.E0.getClass();
            this.C0.p(nwVar.d());
            return;
        }
        int i = st3VarO.b().g.c;
        nwVar.M0 = i;
        nwVar.Z.c = i;
        nwVar.E0.getClass();
        st3VarO.a(nwVar.d());
        this.C0.p(st3VarO.b());
    }

    public final void N() {
        if (sn.g(this.z0.b)) {
            st3 st3VarO = this.b.o();
            if (st3VarO.c()) {
                int iIntValue = ((Integer) st3VarO.b().g.a().getUpper()).intValue();
                nw nwVar = this.Z;
                if (iIntValue > 30) {
                    nwVar.i(true);
                } else {
                    nwVar.i(false);
                }
            }
        }
    }

    public final void O() {
        Iterator it = this.b.t().iterator();
        boolean zE0 = false;
        while (it.hasNext()) {
            zE0 |= ((mn4) it.next()).e0();
        }
        dz4 dz4Var = this.Z.C0;
        if (dz4Var.d != zE0 && zE0) {
            dz4Var.b();
        }
        dz4Var.d = zE0;
    }

    @Override // defpackage.mz
    public final eu2 a() {
        return this.X;
    }

    @Override // defpackage.mz, defpackage.wx
    public final kz b() {
        return this.z0;
    }

    @Override // defpackage.mz
    public final void c(uy uyVar) {
        if (uyVar == null) {
            uyVar = wy.a;
        }
        zf2 zf2Var = (zf2) uyVar;
        zf2Var.m0();
        this.V0 = zf2Var;
        synchronized (this.W0) {
        }
    }

    @Override // defpackage.wx
    public final xy d() {
        return this.Z;
    }

    @Override // defpackage.hn4
    public final void e(in4 in4Var) {
        this.z.execute(new uw(this, A(in4Var), this.Q0 ? in4Var.n : in4Var.o, in4Var.g, in4Var.h, in4Var.c() == null ? null : z34.H(in4Var), 0));
    }

    @Override // defpackage.mz
    public final boolean f() {
        return ((gx) b()).i() == 0;
    }

    @Override // defpackage.hn4
    public final void g(in4 in4Var) {
        this.z.execute(new uw(this, A(in4Var), this.Q0 ? in4Var.n : in4Var.o, in4Var.g, in4Var.h, in4Var.c() == null ? null : z34.H(in4Var), 2));
    }

    @Override // defpackage.mz
    public final xy h() {
        return this.Z;
    }

    @Override // defpackage.mz
    public final uy i() {
        return this.V0;
    }

    @Override // defpackage.hn4
    public final void j(in4 in4Var) {
        this.z.execute(new uw(this, A(in4Var), this.Q0 ? in4Var.n : in4Var.o, in4Var.g, in4Var.h, in4Var.c() == null ? null : z34.H(in4Var), 1));
    }

    @Override // defpackage.mz
    public final void k(boolean z) {
        this.z.execute(new cw(1, this, z));
    }

    @Override // defpackage.mz
    public final void l(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList(I(arrayList2));
        for (in4 in4Var : new ArrayList(arrayList2)) {
            String strA = A(in4Var);
            HashSet hashSet = this.U0;
            if (hashSet.contains(strA)) {
                in4Var.v();
                hashSet.remove(strA);
            }
        }
        this.z.execute(new tw(this, arrayList3, 0));
    }

    @Override // defpackage.mz
    public final void m(ArrayList arrayList) {
        int i;
        nw nwVar = this.Z;
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        synchronized (nwVar.z) {
            i = 1;
            nwVar.G0++;
        }
        ArrayList<in4> arrayList3 = new ArrayList(arrayList2);
        HashSet hashSet = this.U0;
        for (in4 in4Var : arrayList3) {
            String strA = A(in4Var);
            if (!hashSet.contains(strA)) {
                hashSet.add(strA);
                in4Var.u();
                in4Var.s();
            }
        }
        try {
            this.z.execute(new tw(this, new ArrayList(I(arrayList2)), i));
        } catch (RejectedExecutionException e) {
            w("Unable to attach use cases.", e);
            nwVar.b();
        }
    }

    @Override // defpackage.hn4
    public final void n(in4 in4Var) {
        this.z.execute(new s7(9, this, A(in4Var)));
    }

    @Override // defpackage.mz
    public final void o() {
        this.z.execute(new vw(this, 0));
    }

    @Override // defpackage.mz
    public final boolean p() {
        return true;
    }

    @Override // defpackage.mz
    public final void q(boolean z) {
        this.Q0 = z;
    }

    @Override // defpackage.mz
    public final kz r() {
        return this.z0;
    }

    @Override // defpackage.mz
    public final nc2 release() {
        return fx3.m(new sw(this, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ex.s():void");
    }

    public final void t() {
        ArrayList<f10> arrayList;
        r25.j("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + fw.H(this.c1) + " (error: " + y(this.B0) + ")", this.c1 == 6 || this.c1 == 2 || (this.c1 == 8 && this.B0 != 0));
        F();
        o10 o10Var = this.C0;
        synchronized (o10Var.a) {
            try {
                if (o10Var.b.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(o10Var.b);
                    o10Var.b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            for (f10 f10Var : arrayList) {
                for (yx yxVar : f10Var.d) {
                    Object obj = f10Var.f.a.get("CAPTURE_CONFIG_ID_KEY");
                    yxVar.a(obj == null ? -1 : ((Integer) obj).intValue());
                }
            }
        }
    }

    public final String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.z0.a);
    }

    public final void u() {
        int i = 1;
        r25.j(null, this.c1 == 2 || this.c1 == 6);
        r25.j(null, this.G0.isEmpty());
        if (!this.O0) {
            x();
            return;
        }
        if (this.P0) {
            w("Ignored since configAndClose is processing", null);
            return;
        }
        if (!this.I0.b) {
            this.O0 = false;
            x();
            w("Ignore configAndClose and finish the close flow directly since camera is unavailable.", null);
        } else {
            w("Open camera to configAndClose", null);
            yv yvVarM = fx3.m(new sw(this, i));
            this.P0 = true;
            yvVarM.f.a(new vw(this, i), this.z);
        }
    }

    public final CameraDevice.StateCallback v() {
        ArrayList arrayList = new ArrayList(this.b.r().b().c);
        arrayList.add((ez) this.S0.Z);
        arrayList.add(this.y0);
        return co4.l(arrayList);
    }

    public final void w(String str, Throwable th) {
        ez4.p("Camera2CameraImpl", fw.u("{", toString(), "} ", str), th);
    }

    public final void x() {
        r25.j(null, this.c1 == 2 || this.c1 == 6);
        r25.j(null, this.G0.isEmpty());
        this.A0 = null;
        if (this.c1 == 6) {
            G(3);
            return;
        }
        this.f.a.R(this.I0);
        G(1);
        vv vvVar = this.F0;
        if (vvVar != null) {
            vvVar.b(null);
            this.F0 = null;
        }
    }
}
