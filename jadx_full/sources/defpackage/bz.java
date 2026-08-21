package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bz extends az {
    @Override // defpackage.az, defpackage.lb
    public final void r(xt3 xt3Var) throws xx {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) xt3Var.a.c();
        sessionConfiguration.getClass();
        try {
            ((CameraDevice) this.f).createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }
}
