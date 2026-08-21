package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class rz extends qz {
    @Override // defpackage.qz, defpackage.lb
    public final void F(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws xx {
        try {
            ((CameraManager) this.f).openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }

    @Override // defpackage.qz, defpackage.lb
    public final CameraCharacteristics w(String str) throws xx {
        try {
            return ((CameraManager) this.f).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }
}
