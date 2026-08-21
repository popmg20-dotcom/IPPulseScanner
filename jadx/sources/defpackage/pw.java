package defpackage;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.SessionConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pw implements dz {
    public final CameraDevice.CameraDeviceSetup a;

    public pw(CameraManager cameraManager, String str) {
        this.a = cameraManager.getCameraDeviceSetup(str);
    }

    @Override // defpackage.dz
    public final ue2 a(SessionConfiguration sessionConfiguration) {
        int i = this.a.isSessionConfigurationSupported(sessionConfiguration) ? 1 : 2;
        String property = System.getProperty("ro.build.date.utc");
        if (property != null) {
            try {
                Long.parseLong(property);
            } catch (NumberFormatException unused) {
            }
        }
        return new ue2(i, false);
    }
}
