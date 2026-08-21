package defpackage;

import android.hardware.camera2.CameraDevice;
import android.os.SystemClock;
import com.tencent.mars.xlog.Xlog;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dx extends CameraDevice.StateCallback {
    public final at3 a;
    public final xq1 b;
    public cx c;
    public ScheduledFuture d;
    public final bx e;
    public final /* synthetic */ ex f;

    public dx(ex exVar, at3 at3Var, xq1 xq1Var, long j) {
        this.f = exVar;
        this.a = at3Var;
        this.b = xq1Var;
        this.e = new bx(this, j);
    }

    public final boolean a() {
        if (this.d == null) {
            return false;
        }
        this.f.w("Cancelling scheduled re-open: " + this.c, null);
        this.c.f = true;
        this.c = null;
        this.d.cancel(false);
        this.d = null;
        return true;
    }

    public final void b() {
        r25.j(null, this.c == null);
        r25.j(null, this.d == null);
        long jUptimeMillis = SystemClock.uptimeMillis();
        bx bxVar = this.e;
        long j = bxVar.b;
        if (j == -1) {
            bxVar.b = jUptimeMillis;
            j = jUptimeMillis;
        }
        long j2 = jUptimeMillis - j;
        long jB = bxVar.b();
        ex exVar = this.f;
        if (j2 >= jB) {
            bxVar.b = -1L;
            ez4.q("Camera2CameraImpl", "Camera reopening attempted for " + bxVar.b() + "ms without success.");
            exVar.H(4, null, false);
            return;
        }
        this.c = new cx(this, this.a);
        exVar.w("Attempting camera re-open in " + bxVar.a() + "ms: " + this.c + " activeResuming = " + exVar.X0, null);
        this.d = this.b.schedule(this.c, (long) bxVar.a(), TimeUnit.MILLISECONDS);
    }

    public final boolean c() {
        ex exVar = this.f;
        if (!exVar.X0) {
            return false;
        }
        int i = exVar.B0;
        return i == 1 || i == 2;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        this.f.w("CameraDevice.onClosed()", null);
        r25.j("Unexpected onClose callback on camera device: " + cameraDevice, this.f.A0 == null);
        int iG = fw.G(this.f.c1);
        if (iG == 1 || iG == 5) {
            r25.j(null, this.f.G0.isEmpty());
            this.f.u();
            return;
        }
        if (iG != 6 && iG != 7) {
            xe.q("Camera closed while in state: ".concat(fw.H(this.f.c1)));
            return;
        }
        ex exVar = this.f;
        int i = exVar.B0;
        if (i == 0) {
            exVar.L(false);
        } else {
            exVar.w("Camera closed due to error: ".concat(ex.y(i)), null);
            b();
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        this.f.w("CameraDevice.onDisconnected()", null);
        onError(cameraDevice, 1);
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        ex exVar = this.f;
        exVar.A0 = cameraDevice;
        exVar.B0 = i;
        lb lbVar = exVar.b1;
        ((ex) lbVar.z).w("Camera receive onErrorCallback", null);
        lbVar.n();
        int iG = fw.G(this.f.c1);
        if (iG != 1) {
            switch (iG) {
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                case 10:
                    String id = cameraDevice.getId();
                    String strY = ex.y(i);
                    String strF = fw.F(this.f.c1);
                    StringBuilder sbE = fw.E("CameraDevice.onError(): ", id, " failed with ", strY, " while in ");
                    sbE.append(strF);
                    sbE.append(" state. Will attempt recovering from error.");
                    ez4.o("Camera2CameraImpl", sbE.toString());
                    r25.j("Attempt to handle open error from non open state: ".concat(fw.H(this.f.c1)), this.f.c1 == 9 || this.f.c1 == 10 || this.f.c1 == 11 || this.f.c1 == 8 || this.f.c1 == 7);
                    int i2 = 3;
                    if (i == 1 || i == 2 || i == 4) {
                        ez4.o("Camera2CameraImpl", fw.v("Attempt to reopen camera[", cameraDevice.getId(), "] after error[", ex.y(i), "]"));
                        ex exVar2 = this.f;
                        r25.j("Can only reopen camera device after error if the camera device is actually in an error state.", exVar2.B0 != 0);
                        if (i == 1) {
                            i2 = 2;
                        } else if (i == 2) {
                            i2 = 1;
                        }
                        exVar2.H(8, new mg(null, i2), true);
                        exVar2.t();
                    } else {
                        ez4.q("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + ex.y(i) + " closing camera.");
                        this.f.H(6, new mg(null, i == 3 ? 5 : 6), true);
                        this.f.t();
                    }
                    break;
                default:
                    xe.q("onError() should not be possible from state: ".concat(fw.H(this.f.c1)));
                    break;
            }
            return;
        }
        String id2 = cameraDevice.getId();
        String strY2 = ex.y(i);
        String strF2 = fw.F(this.f.c1);
        StringBuilder sbE2 = fw.E("CameraDevice.onError(): ", id2, " failed with ", strY2, " while in ");
        sbE2.append(strF2);
        sbE2.append(" state. Will finish closing camera.");
        ez4.q("Camera2CameraImpl", sbE2.toString());
        this.f.t();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f.w("CameraDevice.onOpened()", null);
        ex exVar = this.f;
        exVar.A0 = cameraDevice;
        exVar.B0 = 0;
        this.e.b = -1L;
        int iG = fw.G(exVar.c1);
        if (iG == 1 || iG == 5) {
            r25.j(null, this.f.G0.isEmpty());
            this.f.A0.close();
            this.f.A0 = null;
        } else {
            if (iG != 6 && iG != 7 && iG != 8) {
                xe.q("onOpened() should not be possible from state: ".concat(fw.H(this.f.c1)));
                return;
            }
            this.f.G(10);
            d00 d00Var = this.f.K0;
            String id = cameraDevice.getId();
            ex exVar2 = this.f;
            if (d00Var.e(id, exVar2.J0.c(exVar2.A0.getId()))) {
                this.f.E();
            }
        }
    }
}
