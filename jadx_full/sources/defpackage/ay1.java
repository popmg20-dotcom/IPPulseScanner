package defpackage;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ay1 {
    public static void a(int i, qx qxVar) {
        if (((ImageCapturePixelHDRPlusQuirk) xt0.a.z(ImageCapturePixelHDRPlusQuirk.class)) == null) {
            return;
        }
        if (i == 0) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_ENABLE_ZSL;
            Boolean bool = Boolean.TRUE;
            qxVar.b.g(rx.k0(key), bool);
            return;
        }
        if (i != 1) {
            return;
        }
        CaptureRequest.Key key2 = CaptureRequest.CONTROL_ENABLE_ZSL;
        Boolean bool2 = Boolean.FALSE;
        qxVar.b.g(rx.k0(key2), bool2);
    }
}
