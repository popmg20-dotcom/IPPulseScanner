package defpackage;

import android.hardware.camera2.CameraManager;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sx extends CameraManager.AvailabilityCallback {
    public final /* synthetic */ tx a;

    public sx(tx txVar) {
        this.a = txVar;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAccessPrioritiesChanged() {
        Log.d("Camera2PresenceSrc", "System onCameraAccessPrioritiesChanged.");
        fx3.m(new rm1(this.a.b(), 1));
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String str) {
        str.getClass();
        Log.d("Camera2PresenceSrc", "System onCameraAvailable: ".concat(str));
        fx3.m(new rm1(this.a.b(), 1));
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String str) {
        str.getClass();
        Log.d("Camera2PresenceSrc", "System onCameraUnavailable: ".concat(str));
        fx3.m(new rm1(this.a.b(), 1));
    }
}
