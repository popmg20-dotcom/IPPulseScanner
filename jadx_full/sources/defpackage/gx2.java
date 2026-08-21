package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class gx2 extends ex2 {
    public gx2(int i, Surface surface) {
        super(new fx2(new OutputConfiguration(i, surface)));
    }

    @Override // defpackage.ex2, defpackage.cx2, defpackage.jx2
    public Object c() {
        Object obj = this.a;
        r25.e(obj instanceof fx2);
        return ((fx2) obj).a;
    }

    @Override // defpackage.ex2, defpackage.cx2, defpackage.jx2
    public final String d() {
        return null;
    }

    @Override // defpackage.ex2, defpackage.cx2, defpackage.jx2
    public void g(long j) {
        ((fx2) this.a).b = j;
    }

    @Override // defpackage.ex2, defpackage.cx2, defpackage.jx2
    public final void i(String str) {
        ((OutputConfiguration) c()).setPhysicalCameraId(str);
    }
}
