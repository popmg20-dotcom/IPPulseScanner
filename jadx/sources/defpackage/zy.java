package defpackage;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zy implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ xw f;
    public final /* synthetic */ CameraDevice z;

    public /* synthetic */ zy(xw xwVar, CameraDevice cameraDevice, int i) {
        this.b = i;
        this.f = xwVar;
        this.z = cameraDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        CameraDevice cameraDevice = this.z;
        xw xwVar = this.f;
        switch (i) {
            case 0:
                ((CameraDevice.StateCallback) xwVar.b).onClosed(cameraDevice);
                break;
            case 1:
                ((CameraDevice.StateCallback) xwVar.b).onDisconnected(cameraDevice);
                break;
            default:
                ((CameraDevice.StateCallback) xwVar.b).onOpened(cameraDevice);
                break;
        }
    }
}
