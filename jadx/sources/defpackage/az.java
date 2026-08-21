package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class az extends lb {
    @Override // defpackage.lb
    public void r(xt3 xt3Var) throws xx {
        CameraDevice cameraDevice = (CameraDevice) this.f;
        lb.q(cameraDevice, xt3Var);
        wt3 wt3Var = xt3Var.a;
        my myVar = new my(wt3Var.e(), wt3Var.f());
        List listG = wt3Var.g();
        cz czVar = (cz) this.z;
        czVar.getClass();
        Handler handler = czVar.a;
        j02 j02VarD = wt3Var.d();
        try {
            if (j02VarD != null) {
                InputConfiguration inputConfiguration = j02VarD.a.a;
                inputConfiguration.getClass();
                cameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfiguration, xt3.a(listG), myVar, handler);
            } else if (wt3Var.b() == 1) {
                cameraDevice.createConstrainedHighSpeedCaptureSession(lb.Q(listG), myVar, handler);
            } else {
                cameraDevice.createCaptureSessionByOutputConfigurations(xt3.a(listG), myVar, handler);
            }
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }
}
