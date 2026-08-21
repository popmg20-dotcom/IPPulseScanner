package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sz extends rz {
    @Override // defpackage.lb
    public final Set x() throws xx {
        try {
            return ((CameraManager) this.f).getConcurrentCameraIds();
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }
}
