package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hx2 extends gx2 {
    public hx2(int i, Surface surface) {
        super(new OutputConfiguration(i, surface));
    }

    @Override // defpackage.gx2, defpackage.ex2, defpackage.cx2, defpackage.jx2
    public final Object c() {
        Object obj = this.a;
        r25.e(obj instanceof OutputConfiguration);
        return obj;
    }

    @Override // defpackage.gx2, defpackage.ex2, defpackage.cx2, defpackage.jx2
    public final void g(long j) {
        ((OutputConfiguration) c()).setDynamicRangeProfile(j);
    }

    @Override // defpackage.jx2
    public final void h(int i) {
        ((OutputConfiguration) c()).setMirrorMode(i);
    }

    @Override // defpackage.jx2
    public final void j(long j) {
        if (j == -1) {
            return;
        }
        ((OutputConfiguration) c()).setStreamUseCase(j);
    }
}
