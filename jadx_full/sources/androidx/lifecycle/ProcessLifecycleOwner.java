package androidx.lifecycle;

import android.os.Handler;
import defpackage.da2;
import defpackage.fa2;
import defpackage.ga1;
import defpackage.ha1;
import defpackage.p92;
import defpackage.r92;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleOwner implements da2 {
    public static final ProcessLifecycleOwner z0 = new ProcessLifecycleOwner();
    public Handler X;
    public int b;
    public int f;
    public boolean z = true;
    public boolean A = true;
    public final fa2 Y = new fa2(this);
    public final ga1 Z = new ga1(16, this);
    public final ha1 y0 = new ha1(18, this);

    private ProcessLifecycleOwner() {
    }

    public final void a() {
        int i = this.f + 1;
        this.f = i;
        if (i == 1) {
            if (this.z) {
                this.Y.f(p92.ON_RESUME);
                this.z = false;
            } else {
                Handler handler = this.X;
                handler.getClass();
                handler.removeCallbacks(this.Z);
            }
        }
    }

    @Override // defpackage.da2
    public final r92 getLifecycle() {
        return this.Y;
    }
}
