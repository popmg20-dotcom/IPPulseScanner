package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rx extends cp1 {
    public static final pg A = new pg("camera2.captureRequest.templateType", Integer.TYPE, null);
    public static final pg X = new pg("camera2.cameraCaptureSession.streamUseCase", Long.TYPE, null);
    public static final pg Y = new pg("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class, null);
    public static final pg Z = new pg("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class, null);
    public static final pg y0 = new pg("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class, null);
    public static final pg z0 = new pg("camera2.cameraCaptureSession.physicalCameraId", String.class, null);

    public static pg k0(CaptureRequest.Key key) {
        return new pg("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }
}
