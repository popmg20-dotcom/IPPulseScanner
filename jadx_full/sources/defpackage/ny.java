package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ny extends lb {
    @Override // defpackage.lb
    public final int L(List list, at3 at3Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f).setRepeatingBurstRequests(list, at3Var, captureCallback);
    }

    @Override // defpackage.lb
    public final int N(CaptureRequest captureRequest, at3 at3Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f).setSingleRepeatingRequest(captureRequest, at3Var, captureCallback);
    }

    @Override // defpackage.lb
    public final int o(List list, at3 at3Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f).captureBurstRequests(list, at3Var, captureCallback);
    }
}
