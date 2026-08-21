package defpackage;

import android.hardware.camera2.CameraCaptureSession;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ly implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ my f;
    public final /* synthetic */ CameraCaptureSession z;

    public /* synthetic */ ly(my myVar, CameraCaptureSession cameraCaptureSession, int i) {
        this.b = i;
        this.f = myVar;
        this.z = cameraCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        CameraCaptureSession cameraCaptureSession = this.z;
        my myVar = this.f;
        switch (i) {
            case 0:
                myVar.a.onActive(cameraCaptureSession);
                break;
            case 1:
                myVar.a.onClosed(cameraCaptureSession);
                break;
            case 2:
                v02.v(myVar.a, cameraCaptureSession);
                break;
            case 3:
                myVar.a.onConfigured(cameraCaptureSession);
                break;
            case 4:
                myVar.a.onReady(cameraCaptureSession);
                break;
            default:
                myVar.a.onConfigureFailed(cameraCaptureSession);
                break;
        }
    }
}
