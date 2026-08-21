package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.core.impl.utils.SurfaceUtil;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o10 {
    public final n10 c;
    public m84 d;
    public m84 e;
    public tt3 f;
    public yv k;
    public vv l;
    public final sn p;
    public final sz0 q;
    public final dt0 r;
    public final boolean s;
    public final Object a = new Object();
    public final ArrayList b = new ArrayList();
    public final HashMap g = new HashMap();
    public List h = Collections.EMPTY_LIST;
    public int i = 1;
    public int j = 1;
    public HashMap m = new HashMap();
    public final id0 n = new id0(3);
    public final id0 o = new id0(5);

    public o10(sz0 sz0Var, oj1 oj1Var, boolean z) {
        q(3);
        this.q = sz0Var;
        this.c = new n10(this);
        this.p = new sn(oj1Var.y(CaptureNoResponseQuirk.class));
        this.r = new dt0(oj1Var, 3);
        this.s = z;
    }

    public static hx c(List list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        CameraCaptureSession.CaptureCallback hxVar;
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            if (yxVar == null) {
                hxVar = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                ke0.G(yxVar, arrayList2);
                hxVar = arrayList2.size() == 1 ? (CameraCaptureSession.CaptureCallback) arrayList2.get(0) : new hx(arrayList2);
            }
            arrayList.add(hxVar);
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return new hx(arrayList);
    }

    public static HashMap d(HashMap map, HashMap map2) {
        HashMap map3 = new HashMap();
        for (Integer num : map.keySet()) {
            num.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) map.get(num)).iterator();
            if (it.hasNext()) {
                SurfaceUtil.a((Surface) map2.get(((fh) it.next()).a));
                k10.e();
                throw null;
            }
            ez4.q("CaptureSession", "Skips to create instances for multi-resolution output. imageFormat: 0, streamInfos size: " + arrayList.size());
        }
        return map3;
    }

    public static ArrayList h(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ax2 ax2Var = (ax2) it.next();
            if (!arrayList2.contains(ax2Var.a.e())) {
                arrayList2.add(ax2Var.a.e());
                arrayList3.add(ax2Var);
            }
        }
        return arrayList3;
    }

    public static HashMap i(ArrayList arrayList) {
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fh fhVar = (fh) it.next();
            int i = fhVar.d;
            if (i > 0 && fhVar.b.isEmpty()) {
                List arrayList2 = (List) map.get(Integer.valueOf(i));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(Integer.valueOf(i), arrayList2);
                }
                arrayList2.add(fhVar);
            }
        }
        HashMap map2 = new HashMap();
        for (Integer num : map.keySet()) {
            num.getClass();
            if (((List) map.get(num)).size() >= 2) {
                map2.put(num, (List) map.get(num));
            }
        }
        return map2;
    }

    public final int a(ArrayList arrayList, lw lwVar) {
        lw lwVar2 = new lw(1);
        Iterator it = arrayList.iterator();
        int iO = -1;
        while (it.hasNext()) {
            CaptureRequest captureRequest = (CaptureRequest) it.next();
            m84 m84Var = this.e;
            Objects.requireNonNull(m84Var);
            cp1 cp1Var = m84Var.g;
            cp1Var.getClass();
            CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) ((lb) cp1Var.f).f;
            List<CaptureRequest> listCreateHighSpeedRequestList = cameraCaptureSession instanceof CameraConstrainedHighSpeedCaptureSession ? ((CameraConstrainedHighSpeedCaptureSession) cameraCaptureSession).createHighSpeedRequestList(captureRequest) : Collections.EMPTY_LIST;
            Iterator<CaptureRequest> it2 = listCreateHighSpeedRequestList.iterator();
            while (it2.hasNext()) {
                lwVar2.a(it2.next(), Collections.singletonList(new kj3(captureRequest, lwVar)));
            }
            m84 m84Var2 = this.e;
            CameraCaptureSession.CaptureCallback captureCallbackI = m84Var2.u.i(lwVar2);
            r25.i(m84Var2.g, "Need to call openCaptureSession before using this API.");
            iO = ((lb) m84Var2.g.f).o(listCreateHighSpeedRequestList, m84Var2.d, captureCallbackI);
        }
        return iO;
    }

    public final void b() {
        synchronized (this.a) {
            try {
                int iG = fw.G(this.j);
                if (iG == 0) {
                    throw new IllegalStateException("close() should not be possible in state: ".concat(fw.J(this.j)));
                }
                if (iG == 2) {
                    q(2);
                } else if (iG == 3) {
                    r25.i(this.d, "The Opener shouldn't null in state:".concat(fw.J(this.j)));
                    this.d.t();
                    q(2);
                } else if (iG == 6 || iG == 7) {
                    r25.i(this.d, "The Opener shouldn't null in state:".concat(fw.J(this.j)));
                    this.d.t();
                    q(6);
                    this.p.s();
                    this.f = null;
                }
            } finally {
            }
        }
    }

    public final void e() {
        if (this.j == 2) {
            ez4.o("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        q(2);
        this.e = null;
        vv vvVar = this.l;
        if (vvVar != null) {
            vvVar.b(null);
            this.l = null;
        }
    }

    public final List f() {
        List listUnmodifiableList;
        synchronized (this.a) {
            listUnmodifiableList = DesugarCollections.unmodifiableList(this.b);
        }
        return listUnmodifiableList;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ax2 g(fh fhVar, HashMap map, String str) {
        long jLongValue;
        dn0 dn0Var = fhVar.a;
        List list = fhVar.b;
        Surface surface = (Surface) map.get(dn0Var);
        r25.i(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        ax2 ax2Var = new ax2(fhVar.d, surface);
        jx2 jx2Var = ax2Var.a;
        if (str != null) {
            jx2Var.i(str);
        } else {
            jx2Var.i(null);
        }
        int i = fhVar.c;
        if (i == 0) {
            jx2Var.h(1);
        } else if (i == 1) {
            jx2Var.h(2);
        }
        if (!list.isEmpty()) {
            jx2Var.b();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Surface surface2 = (Surface) map.get((dn0) it.next());
                r25.i(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                jx2Var.a(surface2);
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            sz0 sz0Var = this.q;
            sz0Var.getClass();
            r25.j("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", i2 >= 33);
            DynamicRangeProfiles dynamicRangeProfilesA = ((rz0) sz0Var.a).a();
            if (dynamicRangeProfilesA == null) {
                jLongValue = 1;
            } else {
                oz0 oz0Var = fhVar.e;
                Long lA = pz0.a(oz0Var, dynamicRangeProfilesA);
                if (lA == null) {
                    ez4.q("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + oz0Var);
                    jLongValue = 1;
                } else {
                    jLongValue = lA.longValue();
                }
            }
        }
        jx2Var.g(jLongValue);
        return ax2Var;
    }

    public final boolean j() {
        boolean z;
        synchronized (this.a) {
            int i = this.j;
            z = i == 8 || i == 7;
        }
        return z;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k(ArrayList arrayList) {
        lw lwVar;
        ArrayList arrayList2;
        boolean z;
        fy fyVar;
        synchronized (this.a) {
            try {
                if (this.j != 8) {
                    ez4.o("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                    return;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                try {
                    lwVar = new lw(1);
                    arrayList2 = new ArrayList();
                    ez4.o("CaptureSession", "Issuing capture request.");
                    Iterator it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                        f10 f10Var = (f10) it.next();
                        if (DesugarCollections.unmodifiableList(f10Var.a).isEmpty()) {
                            ez4.o("CaptureSession", "Skipping issuing empty capture request.");
                        } else {
                            Iterator it2 = DesugarCollections.unmodifiableList(f10Var.a).iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    dn0 dn0Var = (dn0) it2.next();
                                    if (!this.g.containsKey(dn0Var)) {
                                        ez4.o("CaptureSession", "Skipping capture request with invalid surface: " + dn0Var);
                                        break;
                                    }
                                } else {
                                    if (f10Var.c == 2) {
                                        z = true;
                                    }
                                    e10 e10Var = new e10(f10Var);
                                    if (f10Var.c == 5 && (fyVar = f10Var.g) != null) {
                                        e10Var.Z = fyVar;
                                    }
                                    tt3 tt3Var = this.f;
                                    if (tt3Var != null) {
                                        e10Var.d(tt3Var.g.b);
                                    }
                                    e10Var.d(f10Var.b);
                                    f10 f10VarE = e10Var.e();
                                    m84 m84Var = this.e;
                                    m84Var.g.getClass();
                                    CaptureRequest captureRequestM = gb4.m(f10VarE, ((CameraCaptureSession) ((lb) m84Var.g.f).f).getDevice(), this.g, false, this.r);
                                    if (captureRequestM == null) {
                                        ez4.o("CaptureSession", "Skipping issuing request without surface.");
                                        return;
                                    }
                                    ArrayList arrayList3 = new ArrayList();
                                    Iterator it3 = f10Var.d.iterator();
                                    while (it3.hasNext()) {
                                        ke0.G((yx) it3.next(), arrayList3);
                                    }
                                    lwVar.a(captureRequestM, arrayList3);
                                    arrayList2.add(captureRequestM);
                                }
                            }
                        }
                    }
                } catch (CameraAccessException e) {
                    ez4.q("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                if (arrayList2.isEmpty()) {
                    ez4.o("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                    return;
                }
                if (this.n.d(arrayList2, z)) {
                    m84 m84Var2 = this.e;
                    r25.i(m84Var2.g, "Need to call openCaptureSession before using this API.");
                    ((CameraCaptureSession) ((lb) m84Var2.g.f).f).stopRepeating();
                    lwVar.c = new l10(this);
                }
                if (this.o.c(arrayList2, z)) {
                    lwVar.a((CaptureRequest) arrayList2.get(arrayList2.size() - 1), Collections.singletonList(new hx(this)));
                }
                tt3 tt3Var2 = this.f;
                if (tt3Var2 != null && tt3Var2.h == 1) {
                    a(arrayList2, lwVar);
                    return;
                }
                m84 m84Var3 = this.e;
                CameraCaptureSession.CaptureCallback captureCallbackI = m84Var3.u.i(lwVar);
                r25.i(m84Var3.g, "Need to call openCaptureSession before using this API.");
                ((lb) m84Var3.g.f).o(arrayList2, m84Var3.d, captureCallbackI);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(List list) {
        synchronized (this.a) {
            try {
                switch (fw.G(this.j)) {
                    case 0:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: ".concat(fw.J(this.j)));
                    case 1:
                    case 4:
                    case 5:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                    case 2:
                    case 3:
                    case 6:
                        this.b.addAll(list);
                        break;
                    case 7:
                        this.b.addAll(list);
                        this.p.m().a(new d4(9, this), yu0.a());
                        break;
                }
            } finally {
            }
        }
    }

    public final void m(tt3 tt3Var) {
        synchronized (this.a) {
            try {
            } catch (Throwable th) {
                throw th;
            }
            if (tt3Var == null) {
                ez4.o("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return;
            }
            if (this.j != 8) {
                ez4.o("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                return;
            }
            f10 f10Var = tt3Var.g;
            if (DesugarCollections.unmodifiableList(f10Var.a).isEmpty()) {
                ez4.o("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    m84 m84Var = this.e;
                    r25.i(m84Var.g, "Need to call openCaptureSession before using this API.");
                    ((CameraCaptureSession) ((lb) m84Var.g.f).f).stopRepeating();
                } catch (CameraAccessException e) {
                    ez4.q("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                return;
            }
            try {
                ez4.o("CaptureSession", "Issuing request for session.");
                m84 m84Var2 = this.e;
                m84Var2.g.getClass();
                CaptureRequest captureRequestM = gb4.m(f10Var, ((CameraCaptureSession) ((lb) m84Var2.g.f).f).getDevice(), this.g, true, this.r);
                if (captureRequestM == null) {
                    ez4.o("CaptureSession", "Skipping issuing empty request for session.");
                    return;
                }
                CameraCaptureSession.CaptureCallback captureCallbackI = this.p.i(c(f10Var.d, new CameraCaptureSession.CaptureCallback[0]));
                int i = tt3Var.h;
                m84 m84Var3 = this.e;
                if (i != 1) {
                    m84Var3.q(captureRequestM, captureCallbackI);
                    return;
                }
                cp1 cp1Var = m84Var3.g;
                cp1Var.getClass();
                CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) ((lb) cp1Var.f).f;
                List<CaptureRequest> listCreateHighSpeedRequestList = cameraCaptureSession instanceof CameraConstrainedHighSpeedCaptureSession ? ((CameraConstrainedHighSpeedCaptureSession) cameraCaptureSession).createHighSpeedRequestList(captureRequestM) : Collections.EMPTY_LIST;
                m84 m84Var4 = this.e;
                r25.i(m84Var4.g, "Need to call openCaptureSession before using this API.");
                ((lb) m84Var4.g.f).L(listCreateHighSpeedRequestList, m84Var4.d, captureCallbackI);
                return;
            } catch (CameraAccessException e2) {
                ez4.q("CaptureSession", "Unable to access camera: " + e2.getMessage());
                Thread.dumpStack();
                return;
            }
            throw th;
        }
    }

    public final nc2 n(tt3 tt3Var, CameraDevice cameraDevice, m84 m84Var) {
        synchronized (this.a) {
            try {
                if (fw.G(this.j) != 2) {
                    ez4.q("CaptureSession", "Open not allowed in state: ".concat(fw.J(this.j)));
                    return new zy1(1, new IllegalStateException("open() should not allow the state: ".concat(fw.J(this.j))));
                }
                q(4);
                ArrayList arrayList = new ArrayList(tt3Var.b());
                this.h = arrayList;
                this.d = m84Var;
                int i = 0;
                r20 r20VarW = n12.W(pm1.b(m84Var.r(arrayList)), new m10(i, this, tt3Var, cameraDevice), this.d.d);
                w7 w7Var = new w7(16, this);
                r20VarW.a(new um1(i, r20VarW, w7Var), this.d.d);
                return n12.K(r20VarW);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0009, B:6:0x0011, B:23:0x006c, B:8:0x0015, B:10:0x0019, B:13:0x001f, B:15:0x003f, B:16:0x0043, B:18:0x0047, B:19:0x0052, B:21:0x0054, B:22:0x0068, B:26:0x0070, B:27:0x007f), top: B:30:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0009, B:6:0x0011, B:23:0x006c, B:8:0x0015, B:10:0x0019, B:13:0x001f, B:15:0x003f, B:16:0x0043, B:18:0x0047, B:19:0x0052, B:21:0x0054, B:22:0x0068, B:26:0x0070, B:27:0x007f), top: B:30:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final nc2 o() {
        yv yvVarM;
        synchronized (this.a) {
            try {
                int iG = fw.G(this.j);
                if (iG == 0) {
                    throw new IllegalStateException("release() should not be possible in state: ".concat(fw.J(this.j)));
                }
                switch (iG) {
                    case 2:
                        q(2);
                        return zy1.z;
                    case 3:
                        r25.i(this.d, "The Opener shouldn't null in state:".concat(fw.J(this.j)));
                        this.d.t();
                        q(2);
                        return zy1.z;
                    case 4:
                        yvVarM = this.k;
                        if (yvVarM == null) {
                            yvVarM = fx3.m(new l10(this));
                            this.k = yvVarM;
                        }
                        return yvVarM;
                    case 5:
                    case 7:
                        m84 m84Var = this.e;
                        if (m84Var != null) {
                            m84Var.i();
                        }
                        q(5);
                        this.p.s();
                        r25.i(this.d, "The Opener shouldn't null in state:".concat(fw.J(this.j)));
                        if (this.d.t()) {
                            e();
                            return zy1.z;
                        }
                        yvVarM = this.k;
                        if (yvVarM == null) {
                        }
                        return yvVarM;
                    case 6:
                        q(5);
                        this.p.s();
                        r25.i(this.d, "The Opener shouldn't null in state:".concat(fw.J(this.j)));
                        if (this.d.t()) {
                        }
                        yvVarM = this.k;
                        if (yvVarM == null) {
                        }
                        return yvVarM;
                    default:
                        return zy1.z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(tt3 tt3Var) {
        synchronized (this.a) {
            try {
                switch (fw.G(this.j)) {
                    case 0:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: ".concat(fw.J(this.j)));
                    case 1:
                    case 4:
                    case 5:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                    case 2:
                    case 3:
                    case 6:
                        this.f = tt3Var;
                        break;
                    case 7:
                        this.f = tt3Var;
                        if (tt3Var == null) {
                            return;
                        }
                        if (!this.g.keySet().containsAll(tt3Var.b())) {
                            ez4.q("CaptureSession", "Does not have the proper configured lists");
                            return;
                        } else {
                            ez4.o("CaptureSession", "Attempting to submit CaptureRequest after setting");
                            m(this.f);
                        }
                        break;
                }
            } finally {
            }
        }
    }

    public final void q(int i) {
        if (fw.G(i) > fw.G(this.i)) {
            this.i = i;
        }
        this.j = i;
        if (!vo.A() || fw.G(this.i) < 3) {
            return;
        }
        vo.L(fw.G(i), "CX:C2State[" + String.format("CaptureSession@%x", Integer.valueOf(hashCode())) + "]");
    }
}
