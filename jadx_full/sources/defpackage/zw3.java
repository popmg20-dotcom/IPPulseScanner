package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class zw3 extends b22 {
    public final wk0 X;
    public final AtomicBoolean Y;

    public zw3(String str, Object obj) {
        super(0);
        this.X = new wk0(str, obj);
        this.Y = new AtomicBoolean(false);
    }

    @Override // defpackage.b22
    public final wk0 W0(boolean z) {
        if (this.Y.compareAndSet(false, true)) {
            Y0(z);
        }
        return this.X;
    }

    @Override // defpackage.b22
    public final boolean X0() {
        return this.Y.get();
    }

    public void Y0(boolean z) {
        this.X.b1();
    }

    @Override // defpackage.b22
    public final boolean isClosed() {
        boolean z;
        wk0 wk0Var = this.X;
        synchronized (wk0Var.Y) {
            z = wk0Var.y0 != null;
        }
        if (z) {
            return ((Boolean) wk0Var.Z0()).booleanValue();
        }
        return false;
    }

    @Override // defpackage.k70
    public final String toString() {
        return getClass().getSimpleName() + "[" + this.X + "]";
    }
}
