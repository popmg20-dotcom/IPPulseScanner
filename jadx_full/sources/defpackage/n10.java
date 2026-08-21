package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n10 extends i84 {
    public final /* synthetic */ int a;
    public final Object b;

    public n10(int i, List list) {
        this.a = i;
        switch (i) {
            case 2:
                ArrayList arrayList = new ArrayList();
                this.b = arrayList;
                arrayList.addAll(list);
                break;
            default:
                this.b = list.isEmpty() ? new qy() : list.size() == 1 ? (CameraCaptureSession.StateCallback) list.get(0) : new py(list);
                break;
        }
    }

    @Override // defpackage.i84
    public void a(m84 m84Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onActive((CameraCaptureSession) ((lb) m84Var.v().f).f);
                break;
            case 2:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).a(m84Var);
                }
                break;
        }
    }

    @Override // defpackage.i84
    public void b(m84 m84Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                v02.v((CameraCaptureSession.StateCallback) obj, (CameraCaptureSession) ((lb) m84Var.v().f).f);
                break;
            case 2:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).b(m84Var);
                }
                break;
        }
    }

    @Override // defpackage.i84
    public void c(m84 m84Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onClosed((CameraCaptureSession) ((lb) m84Var.v().f).f);
                break;
            case 2:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).c(m84Var);
                }
                break;
        }
    }

    @Override // defpackage.i84
    public final void d(m84 m84Var) {
        switch (this.a) {
            case 0:
                synchronized (((o10) this.b).a) {
                    try {
                        switch (fw.G(((o10) this.b).j)) {
                            case 0:
                            case 2:
                            case 3:
                            case 7:
                                throw new IllegalStateException("onConfigureFailed() should not be possible in state: ".concat(fw.J(((o10) this.b).j)));
                            case 1:
                                ez4.o("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                                break;
                            case 4:
                            case 5:
                            case 6:
                                ((o10) this.b).e();
                                break;
                        }
                        ez4.q("CaptureSession", "CameraCaptureSession.onConfigureFailed() ".concat(fw.J(((o10) this.b).j)));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                ((CameraCaptureSession.StateCallback) this.b).onConfigureFailed((CameraCaptureSession) ((lb) m84Var.v().f).f);
                return;
            default:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).d(m84Var);
                }
                return;
        }
    }

    @Override // defpackage.i84
    public final void e(m84 m84Var) {
        switch (this.a) {
            case 0:
                synchronized (((o10) this.b).a) {
                    try {
                        switch (fw.G(((o10) this.b).j)) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 7:
                                throw new IllegalStateException("onConfigured() should not be possible in state: ".concat(fw.J(((o10) this.b).j)));
                            case 4:
                                m84Var.i();
                                break;
                            case 5:
                                ((o10) this.b).e = m84Var;
                                break;
                            case 6:
                                ((o10) this.b).q(8);
                                ((o10) this.b).e = m84Var;
                                ez4.o("CaptureSession", "Attempting to send capture request onConfigured");
                                o10 o10Var = (o10) this.b;
                                o10Var.m(o10Var.f);
                                o10 o10Var2 = (o10) this.b;
                                o10Var2.p.m().a(new d4(9, o10Var2), yu0.a());
                                break;
                        }
                        ez4.o("CaptureSession", "CameraCaptureSession.onConfigured() mState=".concat(fw.J(((o10) this.b).j)));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                ((CameraCaptureSession.StateCallback) this.b).onConfigured((CameraCaptureSession) ((lb) m84Var.v().f).f);
                return;
            default:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).e(m84Var);
                }
                return;
        }
    }

    @Override // defpackage.i84
    public final void f(m84 m84Var) {
        switch (this.a) {
            case 0:
                synchronized (((o10) this.b).a) {
                    try {
                        if (fw.G(((o10) this.b).j) == 0) {
                            throw new IllegalStateException("onReady() should not be possible in state: ".concat(fw.J(((o10) this.b).j)));
                        }
                        ez4.o("CaptureSession", "CameraCaptureSession.onReady() ".concat(fw.J(((o10) this.b).j)));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                ((CameraCaptureSession.StateCallback) this.b).onReady((CameraCaptureSession) ((lb) m84Var.v().f).f);
                return;
            default:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).f(m84Var);
                }
                return;
        }
    }

    @Override // defpackage.i84
    public final void g(m84 m84Var) {
        switch (this.a) {
            case 0:
                synchronized (((o10) this.b).a) {
                    try {
                        int i = ((o10) this.b).j;
                        if (i == 1) {
                            throw new IllegalStateException("onSessionFinished() should not be possible in state: ".concat(fw.J(i)));
                        }
                        ez4.o("CaptureSession", "onSessionFinished()");
                        ((o10) this.b).e();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                return;
            default:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).g(m84Var);
                }
                return;
        }
    }

    @Override // defpackage.i84
    public void h(m84 m84Var, Surface surface) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onSurfacePrepared((CameraCaptureSession) ((lb) m84Var.v().f).f, surface);
                break;
            case 2:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((i84) it.next()).h(m84Var, surface);
                }
                break;
        }
    }

    private final void i(m84 m84Var) {
    }

    public n10(o10 o10Var) {
        this.a = 0;
        this.b = o10Var;
    }
}
