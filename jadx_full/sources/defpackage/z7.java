package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z7 implements az4 {
    public final Range b;
    public final boolean f;

    public z7(sy syVar) {
        this.f = false;
        this.b = (Range) syVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        this.f = syVar.f();
    }

    @Override // defpackage.az4
    public final float G() {
        return ((Float) this.b.getLower()).floatValue();
    }

    @Override // defpackage.az4
    public final void Y(qx qxVar) {
        qxVar.e(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(1.0f));
        if (this.f) {
            l2.n(qxVar);
        }
    }

    @Override // defpackage.az4
    public final float o() {
        return ((Float) this.b.getUpper()).floatValue();
    }

    @Override // defpackage.az4
    public final void g0() {
    }

    @Override // defpackage.az4
    public final void d(TotalCaptureResult totalCaptureResult) {
    }
}
