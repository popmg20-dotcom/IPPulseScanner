package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class cx2 extends jx2 {
    public cx2(int i, Surface surface) {
        super(new bx2(new OutputConfiguration(i, surface)));
    }

    @Override // defpackage.jx2
    public void b() {
        ((bx2) this.a).c = true;
    }

    @Override // defpackage.jx2
    public Object c() {
        Object obj = this.a;
        r25.e(obj instanceof bx2);
        return ((bx2) obj).a;
    }

    @Override // defpackage.jx2
    public String d() {
        return ((bx2) this.a).b;
    }

    @Override // defpackage.jx2
    public final Surface e() {
        return ((OutputConfiguration) c()).getSurface();
    }

    @Override // defpackage.jx2
    public boolean f() {
        return ((bx2) this.a).c;
    }

    @Override // defpackage.jx2
    public void g(long j) {
        ((bx2) this.a).d = j;
    }

    @Override // defpackage.jx2
    public void i(String str) {
        ((bx2) this.a).b = str;
    }
}
