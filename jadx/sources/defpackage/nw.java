package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Size;
import android.view.Surface;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nw implements xy {
    public final sy A;
    public final sn A0;
    public final sn B0;
    public final dz4 C0;
    public final ew D0;
    public final wl3 E0;
    public final wn1 F0;
    public int G0;
    public volatile int H0;
    public volatile int I0;
    public volatile int J0;
    public final dt0 K0;
    public final AtomicLong L0;
    public int M0;
    public long N0;
    public final kw O0;
    public final cp1 X;
    public final pt3 Y;
    public final qh1 Z;
    public final lw b;
    public final at3 f;
    public final bz4 y0;
    public final Object z = new Object();
    public final xf4 z0;

    public nw(sy syVar, xq1 xq1Var, at3 at3Var, cp1 cp1Var, oj1 oj1Var) {
        pt3 pt3Var = new pt3();
        this.Y = pt3Var;
        this.G0 = 0;
        this.H0 = 0;
        this.J0 = 2;
        this.L0 = new AtomicLong(0L);
        this.M0 = 1;
        this.N0 = 0L;
        kw kwVar = new kw();
        kwVar.b = new HashSet();
        kwVar.c = new ArrayMap();
        this.O0 = kwVar;
        this.A = syVar;
        this.X = cp1Var;
        this.f = at3Var;
        this.F0 = new wn1(at3Var);
        lw lwVar = new lw(at3Var);
        this.b = lwVar;
        pt3Var.b.b = this.M0;
        pt3Var.b.b(new d10(lwVar));
        pt3Var.b.b(kwVar);
        sn snVar = new sn();
        snVar.b = false;
        snVar.f = new cp1(26);
        this.B0 = snVar;
        this.Z = new qh1(this, xq1Var, at3Var);
        this.y0 = new bz4(this, syVar, at3Var);
        this.z0 = new xf4(this, syVar, at3Var);
        this.I0 = syVar.b();
        sn snVar2 = new sn();
        new AtomicInteger(-1);
        snVar2.f = new Object();
        boolean zG = sn.g(syVar);
        new on2(-1);
        hf2 hf2Var = new hf2();
        if (zG) {
            a(hf2Var);
        }
        this.A0 = snVar2;
        this.C0 = new dz4(syVar, at3Var);
        this.K0 = new dt0(oj1Var, 1);
        this.D0 = new ew(this, at3Var);
        this.E0 = new wl3(this, syVar, oj1Var, at3Var, xq1Var);
    }

    public static int e(sy syVar, int i) {
        int[] iArr = (int[]) syVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return g(iArr, i) ? i : g(iArr, 1) ? 1 : 0;
    }

    public static boolean g(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.xy
    public final void I(int i) {
        if (!f()) {
            ez4.a0("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.J0 = i;
        ez4.o("Camera2CameraControlImp", "setFlashMode: mFlashMode = " + this.J0);
        dz4 dz4Var = this.C0;
        if (this.J0 != 1) {
            int i2 = this.J0;
        }
        dz4Var.getClass();
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            this.f.execute(new s7(4, this, vvVar));
            vvVar.a = "updateSessionConfigAsync";
        } catch (Exception e) {
            yvVar.b(e);
        }
        n12.K(yvVar);
    }

    @Override // defpackage.xy
    public final void N() {
        this.C0.a();
    }

    @Override // defpackage.xy
    public final void Q(pt3 pt3Var) {
        StreamConfigurationMap streamConfigurationMap;
        int i;
        HashMap map;
        StreamConfigurationMap streamConfigurationMap2;
        int[] validOutputFormatsForInput;
        e10 e10Var = pt3Var.b;
        dz4 dz4Var = this.C0;
        at3 at3Var = dz4Var.b;
        sy syVar = dz4Var.a;
        dz4Var.a();
        if (dz4Var.d) {
            e10Var.b = 1;
            return;
        }
        if (dz4Var.f) {
            e10Var.b = 1;
            return;
        }
        try {
            streamConfigurationMap = (StreamConfigurationMap) syVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            ez4.q("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
            streamConfigurationMap = null;
        }
        if (streamConfigurationMap == null || streamConfigurationMap.getInputFormats() == null) {
            i = 0;
            map = new HashMap();
        } else {
            map = new HashMap();
            for (int i2 : streamConfigurationMap.getInputFormats()) {
                Size[] inputSizes = streamConfigurationMap.getInputSizes(i2);
                if (inputSizes != null) {
                    Arrays.sort(inputSizes, new l80(true));
                    map.put(Integer.valueOf(i2), inputSizes[0]);
                }
            }
            i = 0;
        }
        if (dz4Var.e && !map.isEmpty() && map.containsKey(34) && (streamConfigurationMap2 = (StreamConfigurationMap) syVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) != null && (validOutputFormatsForInput = streamConfigurationMap2.getValidOutputFormatsForInput(34)) != null) {
            int length = validOutputFormatsForInput.length;
            for (int i3 = i; i3 < length; i3++) {
                if (validOutputFormatsForInput[i3] == 256) {
                    Size size = (Size) map.get(34);
                    wl2 wl2Var = new wl2(size.getWidth(), size.getHeight(), 34, 9);
                    e10 e10Var2 = new e10(wl2Var);
                    Surface surface = e10Var2.getSurface();
                    Objects.requireNonNull(surface);
                    az1 az1Var = new az1(surface, new Size(e10Var2.f(), e10Var2.c()), 34);
                    e24 e24Var = new e24(at3Var);
                    dz4Var.g = e10Var2;
                    dz4Var.h = az1Var;
                    dz4Var.i = e24Var;
                    e10Var2.p(new o73(16, dz4Var), d22.a());
                    n12.K(az1Var.e).a(new xy0(26, e10Var2, e24Var), at3Var);
                    pt3Var.b(az1Var, oz0.d, -1);
                    vl2 vl2Var = wl2Var.f;
                    e10Var.b(vl2Var);
                    ArrayList arrayList = pt3Var.e;
                    if (!arrayList.contains(vl2Var)) {
                        arrayList.add(vl2Var);
                    }
                    py pyVar = new py(2, e24Var);
                    ArrayList arrayList2 = pt3Var.d;
                    if (!arrayList2.contains(pyVar)) {
                        arrayList2.add(pyVar);
                    }
                    pt3Var.g = new InputConfiguration(e10Var2.f(), e10Var2.c(), e10Var2.j());
                    return;
                }
            }
        }
        e10Var.b = 1;
    }

    @Override // defpackage.xy
    public final nc2 X(final boolean z) {
        nc2 nc2VarM;
        if (!f()) {
            return new zy1(1, new w9("Camera is not active."));
        }
        final xf4 xf4Var = this.z0;
        if (xf4Var.d) {
            xf4Var.a(z ? 1 : 0);
            final int i = z ? 1 : 0;
            nc2VarM = fx3.m(new wv() { // from class: vf4
                @Override // defpackage.wv
                public final Object n(vv vvVar) {
                    xf4 xf4Var2 = xf4Var;
                    xf4Var2.e.execute(new iw(xf4Var2, vvVar, i, 8));
                    return "enableTorch: " + z;
                }
            });
        } else {
            ez4.o("TorchControl", "Unable to enableTorch due to there is no flash unit.");
            nc2VarM = new zy1(1, new IllegalStateException("No flash unit"));
        }
        return n12.K(nc2VarM);
    }

    public final void a(mw mwVar) {
        ((HashSet) this.b.b).add(mwVar);
    }

    public final void b() {
        synchronized (this.z) {
            try {
                int i = this.G0;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.G0 = i - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(int i) {
        this.H0 = i;
        if (i == 0) {
            e10 e10Var = new e10();
            e10Var.b = this.M0;
            e10Var.f = true;
            qn2 qn2VarC = qn2.c();
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
            qn2VarC.g(rx.k0(key), Integer.valueOf(e(this.A, 1)));
            qn2VarC.g(rx.k0(CaptureRequest.FLASH_MODE), 0);
            e10Var.d(new rx(14, sw2.a(qn2VarC)));
            j(Collections.singletonList(e10Var.e()));
        }
        k();
    }

    @Override // defpackage.xy
    public final ka0 c0() {
        rx rxVar;
        ew ewVar = this.D0;
        synchronized (ewVar.e) {
            rxVar = new rx(14, sw2.a(((qx) ewVar.f).b));
        }
        return rxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.tt3 d() {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nw.d():tt3");
    }

    public final boolean f() {
        int i;
        synchronized (this.z) {
            i = this.G0;
        }
        return i > 0;
    }

    public final void h(boolean z) {
        xg xgVar;
        ez4.o("Camera2CameraControlImp", "setActive: isActive = " + z);
        qh1 qh1Var = this.Z;
        if (z != qh1Var.b) {
            qh1Var.b = z;
            if (!qh1Var.b) {
                nw nwVar = qh1Var.a;
                ((HashSet) nwVar.b.b).remove(null);
                ((HashSet) nwVar.b.b).remove(null);
                if (qh1Var.d.length > 0 && qh1Var.b) {
                    e10 e10Var = new e10();
                    e10Var.f = true;
                    e10Var.b = qh1Var.c;
                    qn2 qn2VarC = qn2.c();
                    qn2VarC.g(rx.k0(CaptureRequest.CONTROL_AF_TRIGGER), 2);
                    e10Var.d(new rx(14, sw2.a(qn2VarC)));
                    qh1Var.a.j(Collections.singletonList(e10Var.e()));
                }
                MeteringRectangle[] meteringRectangleArr = qh1.h;
                qh1Var.d = meteringRectangleArr;
                qh1Var.e = meteringRectangleArr;
                qh1Var.f = meteringRectangleArr;
                nwVar.k();
            }
        }
        bz4 bz4Var = this.y0;
        if (bz4Var.e != z) {
            bz4Var.e = z;
            if (!z) {
                synchronized (bz4Var.b) {
                    bz4Var.b.e();
                    cz4 cz4Var = bz4Var.b;
                    xgVar = new xg(cz4Var.d(), cz4Var.b(), cz4Var.c(), cz4Var.a());
                }
                Looper looperMyLooper = Looper.myLooper();
                Looper mainLooper = Looper.getMainLooper();
                on2 on2Var = bz4Var.c;
                if (looperMyLooper == mainLooper) {
                    on2Var.l(xgVar);
                } else {
                    on2Var.i(xgVar);
                }
                bz4Var.d.g0();
                bz4Var.a.k();
            }
        }
        sn snVar = this.A0;
        if (snVar.b != z) {
            snVar.b = z;
        }
        xf4 xf4Var = this.z0;
        int i = xf4Var.g;
        int i2 = 0;
        if (xf4Var.f != z) {
            xf4Var.f = z;
            if (!z) {
                if (xf4Var.i) {
                    xf4Var.i = false;
                    xf4Var.a.c(0);
                    xf4Var.a(0);
                    on2 on2Var2 = xf4Var.c;
                    Integer numValueOf = Integer.valueOf(i);
                    if (co4.E()) {
                        on2Var2.l(numValueOf);
                    } else {
                        on2Var2.i(numValueOf);
                    }
                }
                vv vvVar = xf4Var.h;
                if (vvVar != null) {
                    vvVar.d(new w9("Camera is not active."));
                    xf4Var.h = null;
                }
            }
        }
        this.B0.r(z);
        ew ewVar = this.D0;
        ((at3) ewVar.d).execute(new cw(i2, ewVar, z));
        if (z) {
            return;
        }
        ((AtomicInteger) this.F0.f).set(0);
        ez4.o("VideoUsageControl", "resetDirectly: mVideoUsage reset!");
    }

    public final void i(boolean z) {
        synchronized (this.A0.f) {
            try {
                if (z) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(List list) {
        int iC;
        int iB;
        fy fyVar;
        ex exVar = (ex) this.X.f;
        list.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f10 f10Var = (f10) it.next();
            HashSet hashSet = new HashSet();
            qn2.c();
            ArrayList arrayList2 = new ArrayList();
            vn2.a();
            hashSet.addAll(f10Var.a);
            qn2 qn2VarD = qn2.d(f10Var.b);
            int i = f10Var.c;
            arrayList2.addAll(f10Var.d);
            boolean z = f10Var.e;
            pa4 pa4Var = f10Var.f;
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = pa4Var.a;
            for (String str : arrayMap2.keySet()) {
                arrayMap.put(str, arrayMap2.get(str));
            }
            vn2 vn2Var = new vn2(arrayMap);
            fy fyVar2 = (f10Var.c != 5 || (fyVar = f10Var.g) == null) ? null : fyVar;
            if (DesugarCollections.unmodifiableList(f10Var.a).isEmpty() && f10Var.e) {
                if (hashSet.isEmpty()) {
                    e24 e24Var = exVar.b;
                    e24Var.getClass();
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry entry : ((LinkedHashMap) e24Var.z).entrySet()) {
                        jn4 jn4Var = (jn4) entry.getValue();
                        if (jn4Var.f && jn4Var.e) {
                            arrayList3.add(((jn4) entry.getValue()).a);
                        }
                    }
                    Iterator it2 = DesugarCollections.unmodifiableCollection(arrayList3).iterator();
                    while (it2.hasNext()) {
                        f10 f10Var2 = ((tt3) it2.next()).g;
                        List listUnmodifiableList = DesugarCollections.unmodifiableList(f10Var2.a);
                        if (!listUnmodifiableList.isEmpty()) {
                            if (f10Var2.b() != 0 && (iB = f10Var2.b()) != 0) {
                                qn2VarD.g(mn4.l0, Integer.valueOf(iB));
                            }
                            if (f10Var2.c() != 0 && (iC = f10Var2.c()) != 0) {
                                qn2VarD.g(mn4.m0, Integer.valueOf(iC));
                            }
                            Iterator it3 = listUnmodifiableList.iterator();
                            while (it3.hasNext()) {
                                hashSet.add((dn0) it3.next());
                            }
                        }
                    }
                    if (hashSet.isEmpty()) {
                        ez4.a0("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
                    }
                } else {
                    ez4.a0("Camera2CameraImpl", "The capture config builder already has surface inside.");
                }
            }
            ArrayList arrayList4 = new ArrayList(hashSet);
            sw2 sw2VarA = sw2.a(qn2VarD);
            ArrayList arrayList5 = new ArrayList(arrayList2);
            pa4 pa4Var2 = pa4.b;
            ArrayMap arrayMap3 = new ArrayMap();
            ArrayMap arrayMap4 = vn2Var.a;
            for (String str2 : arrayMap4.keySet()) {
                arrayMap3.put(str2, arrayMap4.get(str2));
            }
            arrayList.add(new f10(arrayList4, sw2VarA, i, arrayList5, z, new pa4(arrayMap3), fyVar2));
        }
        exVar.w("Issue capture request", null);
        exVar.C0.l(arrayList);
    }

    public final long k() {
        this.N0 = this.L0.getAndIncrement();
        ((ex) this.X.f).M();
        return this.N0;
    }

    @Override // defpackage.xy
    public final void n0() {
        int i;
        ew ewVar = this.D0;
        synchronized (ewVar.e) {
            i = 0;
            ewVar.f = new qx(0);
        }
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            ((at3) ewVar.d).execute(new dw(ewVar, vvVar, i));
            vvVar.a = "clearCaptureRequestOptions";
        } catch (Exception e) {
            yvVar.b(e);
        }
        n12.K(yvVar).a(new hw(0), yu0.a());
    }

    @Override // defpackage.xy
    public final void x(ka0 ka0Var) {
        ew ewVar = this.D0;
        cp1 cp1VarC = qx.d(ka0Var).c();
        synchronized (ewVar.e) {
            qx qxVar = (qx) ewVar.f;
            ia0 ia0Var = ia0.A;
            for (pg pgVar : cp1VarC.t()) {
                qxVar.b.f(pgVar, ia0Var, cp1VarC.u(pgVar));
            }
        }
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            ((at3) ewVar.d).execute(new dw(ewVar, vvVar, 1));
            vvVar.a = "addCaptureRequestOptions";
        } catch (Exception e) {
            yvVar.b(e);
        }
        n12.K(yvVar).a(new hw(0), yu0.a());
    }

    @Override // defpackage.xy
    public final void M(vx1 vx1Var) {
    }
}
