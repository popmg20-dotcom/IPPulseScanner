package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m84 extends i84 {
    public final cm2 b;
    public final Handler c;
    public final at3 d;
    public final xq1 e;
    public n10 f;
    public cp1 g;
    public yv h;
    public vv i;
    public pm1 j;
    public final xq1 o;
    public ArrayList q;
    public yb2 r;
    public final li1 s;
    public final zf2 t;
    public final sn u;
    public final id0 v;
    public final Object a = new Object();
    public List k = null;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public final Object p = new Object();
    public final AtomicBoolean w = new AtomicBoolean(false);

    public m84(oj1 oj1Var, oj1 oj1Var2, cm2 cm2Var, at3 at3Var, xq1 xq1Var, Handler handler) {
        this.b = cm2Var;
        this.c = handler;
        this.d = at3Var;
        this.e = xq1Var;
        this.s = new li1(oj1Var, oj1Var2);
        this.u = new sn(oj1Var.y(CaptureSessionStuckQuirk.class) || oj1Var.y(IncorrectCaptureStateQuirk.class));
        this.t = new zf2(oj1Var2);
        id0 id0Var = new id0();
        id0Var.b = oj1Var2.y(Preview3AThreadCrashQuirk.class);
        this.v = id0Var;
        this.o = xq1Var;
    }

    @Override // defpackage.i84
    public final void a(m84 m84Var) {
        Objects.requireNonNull(this.f);
        this.f.a(m84Var);
    }

    @Override // defpackage.i84
    public final void b(m84 m84Var) {
        Objects.requireNonNull(this.f);
        this.f.b(m84Var);
    }

    @Override // defpackage.i84
    public final void c(m84 m84Var) {
        synchronized (this.p) {
            this.s.a(this.q);
        }
        k("onClosed()");
        n(m84Var);
    }

    @Override // defpackage.i84
    public final void d(m84 m84Var) {
        m84 m84Var2;
        Objects.requireNonNull(this.f);
        p();
        this.u.s();
        cm2 cm2Var = this.b;
        Iterator it = cm2Var.s().iterator();
        while (it.hasNext() && (m84Var2 = (m84) it.next()) != this) {
            m84Var2.p();
            m84Var2.u.s();
        }
        synchronized (cm2Var.z) {
            ((LinkedHashSet) cm2Var.Y).remove(this);
        }
        this.f.d(m84Var);
    }

    @Override // defpackage.i84
    public final void e(m84 m84Var) {
        m84 m84Var2;
        m84 m84Var3;
        m84 m84Var4;
        k("Session onConfigured()");
        zf2 zf2Var = this.t;
        ArrayList arrayListQ = this.b.q();
        ArrayList arrayListP = this.b.p();
        if (((CaptureSessionOnClosedNotCalledQuirk) zf2Var.f) != null) {
            LinkedHashSet<m84> linkedHashSet = new LinkedHashSet();
            Iterator it = arrayListQ.iterator();
            while (it.hasNext() && (m84Var4 = (m84) it.next()) != m84Var) {
                linkedHashSet.add(m84Var4);
            }
            for (m84 m84Var5 : linkedHashSet) {
                m84Var5.getClass();
                m84Var5.d(m84Var5);
            }
        }
        Objects.requireNonNull(this.f);
        cm2 cm2Var = this.b;
        synchronized (cm2Var.z) {
            ((LinkedHashSet) cm2Var.A).add(this);
            ((LinkedHashSet) cm2Var.Y).remove(this);
        }
        Iterator it2 = cm2Var.s().iterator();
        while (it2.hasNext() && (m84Var3 = (m84) it2.next()) != this) {
            m84Var3.p();
            m84Var3.u.s();
        }
        this.f.e(m84Var);
        if (((CaptureSessionOnClosedNotCalledQuirk) zf2Var.f) != null) {
            LinkedHashSet<m84> linkedHashSet2 = new LinkedHashSet();
            Iterator it3 = arrayListP.iterator();
            while (it3.hasNext() && (m84Var2 = (m84) it3.next()) != m84Var) {
                linkedHashSet2.add(m84Var2);
            }
            for (m84 m84Var6 : linkedHashSet2) {
                m84Var6.getClass();
                m84Var6.c(m84Var6);
            }
        }
    }

    @Override // defpackage.i84
    public final void f(m84 m84Var) {
        Objects.requireNonNull(this.f);
        this.f.f(m84Var);
    }

    @Override // defpackage.i84
    public final void g(m84 m84Var) {
        int i;
        yv yvVar;
        synchronized (this.a) {
            try {
                i = 1;
                if (this.n) {
                    yvVar = null;
                } else {
                    this.n = true;
                    r25.i(this.h, "Need to call openCaptureSession before using this API.");
                    yvVar = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (yvVar != null) {
            yvVar.f.a(new j84(this, m84Var, i), yu0.a());
        }
    }

    @Override // defpackage.i84
    public final void h(m84 m84Var, Surface surface) {
        Objects.requireNonNull(this.f);
        this.f.h(m84Var, surface);
    }

    public final void i() {
        int i = 1;
        if (!this.w.compareAndSet(false, true)) {
            k("close() has been called. Skip this invocation.");
            return;
        }
        if (this.v.b) {
            try {
                k("Call abortCaptures() before closing session.");
                r25.i(this.g, "Need to call openCaptureSession before using this API.");
                ((CameraCaptureSession) ((lb) this.g.f).f).abortCaptures();
            } catch (Exception e) {
                k("Exception when calling abortCaptures()" + e);
            }
        }
        k("Session call close()");
        this.u.m().a(new k84(this, i), this.d);
    }

    public final void j(CameraCaptureSession cameraCaptureSession) {
        if (this.g == null) {
            this.g = new cp1(cameraCaptureSession, this.c);
        }
    }

    public final void k(String str) {
        ez4.o("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    public final void l(List list) {
        synchronized (this.a) {
            p();
            if (!list.isEmpty()) {
                int i = 0;
                do {
                    try {
                        ((dn0) list.get(i)).d();
                        i++;
                    } catch (cn0 e) {
                        for (int i2 = i - 1; i2 >= 0; i2--) {
                            ((dn0) list.get(i2)).b();
                        }
                        throw e;
                    }
                } while (i < list.size());
            }
            this.k = list;
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.h != null;
        }
        return z;
    }

    public final void n(m84 m84Var) {
        yv yvVar;
        synchronized (this.a) {
            try {
                if (this.l) {
                    yvVar = null;
                } else {
                    this.l = true;
                    r25.i(this.h, "Need to call openCaptureSession before using this API.");
                    yvVar = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        p();
        this.u.s();
        if (yvVar != null) {
            yvVar.f.a(new j84(this, m84Var, 0), yu0.a());
        }
    }

    public final nc2 o(CameraDevice cameraDevice, xt3 xt3Var, List list) {
        nc2 nc2VarK;
        synchronized (this.p) {
            try {
                ArrayList<m84> arrayListP = this.b.p();
                ArrayList arrayList = new ArrayList();
                for (m84 m84Var : arrayListP) {
                    arrayList.add(fx3.m(new sm1(m84Var.u.m(), m84Var.o, 1500L)));
                }
                yb2 yb2Var = new yb2(new ArrayList(arrayList), false, yu0.a());
                this.r = yb2Var;
                nc2VarK = n12.K(n12.W(pm1.b(yb2Var), new l84(this, cameraDevice, xt3Var, list), this.d));
            } catch (Throwable th) {
                throw th;
            }
        }
        return nc2VarK;
    }

    public final void p() {
        synchronized (this.a) {
            try {
                List list = this.k;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((dn0) it.next()).b();
                    }
                    this.k = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int q(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSession.CaptureCallback captureCallbackI = this.u.i(captureCallback);
        r25.i(this.g, "Need to call openCaptureSession before using this API.");
        return ((lb) this.g.f).N(captureRequest, this.d, captureCallbackI);
    }

    public final nc2 r(ArrayList arrayList) {
        nc2 nc2VarS;
        synchronized (this.p) {
            this.q = arrayList;
            nc2VarS = s(arrayList);
        }
        return nc2VarS;
    }

    public final nc2 s(ArrayList arrayList) {
        synchronized (this.a) {
            try {
                if (this.m) {
                    return new zy1(1, new CancellationException("Opener is disabled"));
                }
                r20 r20VarW = n12.W(pm1.b(fx3.M(arrayList, this.d, this.e)), new ed(17, this, arrayList), this.d);
                this.j = r20VarW;
                return n12.K(r20VarW);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean t() {
        boolean zU;
        synchronized (this.p) {
            try {
                if (m()) {
                    this.s.a(this.q);
                } else {
                    yb2 yb2Var = this.r;
                    if (yb2Var != null) {
                        yb2Var.cancel(true);
                    }
                }
                zU = u();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zU;
    }

    public final boolean u() {
        boolean z;
        try {
            synchronized (this.a) {
                try {
                    if (!this.m) {
                        pm1 pm1Var = this.j;
                        pm1Var = pm1Var != null ? pm1Var : null;
                        this.m = true;
                    }
                    z = !m();
                } finally {
                }
            }
            return z;
        } finally {
            if (pm1Var != null) {
                pm1Var.cancel(true);
            }
        }
    }

    public final cp1 v() {
        this.g.getClass();
        return this.g;
    }
}
