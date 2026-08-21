package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ex2 extends cx2 {
    public ex2(int i, Surface surface) {
        super(new dx2(new OutputConfiguration(i, surface)));
    }

    @Override // defpackage.jx2
    public final void a(Surface surface) {
        ((OutputConfiguration) c()).addSurface(surface);
    }

    @Override // defpackage.cx2, defpackage.jx2
    public final void b() {
        ((OutputConfiguration) c()).enableSurfaceSharing();
    }

    @Override // defpackage.cx2, defpackage.jx2
    public Object c() {
        Object obj = this.a;
        r25.e(obj instanceof dx2);
        return ((dx2) obj).a;
    }

    @Override // defpackage.cx2, defpackage.jx2
    public String d() {
        return ((dx2) this.a).b;
    }

    @Override // defpackage.cx2, defpackage.jx2
    public final boolean f() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    @Override // defpackage.cx2, defpackage.jx2
    public void g(long j) {
        ((dx2) this.a).c = j;
    }

    @Override // defpackage.cx2, defpackage.jx2
    public void i(String str) {
        ((dx2) this.a).b = str;
    }
}
