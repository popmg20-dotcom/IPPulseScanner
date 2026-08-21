package defpackage;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class mu1 implements wy3 {
    public long A;
    public final lu1 A0;
    public final lu1 B0;
    public t51 C0;
    public IOException D0;
    public long X;
    public final ArrayDeque Y;
    public boolean Z;
    public final int b;
    public final fu1 f;
    public final ku1 y0;
    public final bi4 z;
    public final ju1 z0;

    public mu1(int i, fu1 fu1Var, boolean z, boolean z2, lr1 lr1Var) {
        fu1Var.getClass();
        this.b = i;
        this.f = fu1Var;
        this.z = new bi4(i);
        this.X = fu1Var.I0.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.Y = arrayDeque;
        this.y0 = new ku1(this, fu1Var.H0.a(), z2);
        this.z0 = new ju1(this, z);
        this.A0 = new lu1(this);
        this.B0 = new lu1(this);
        if (lr1Var == null) {
            if (h()) {
                return;
            }
            xe.q("remotely-initiated streams should have headers");
            throw null;
        }
        if (h()) {
            xe.q("locally-initiated streams shouldn't have headers yet");
            throw null;
        }
        arrayDeque.add(lr1Var);
    }

    @Override // defpackage.wy3
    public final lz3 a() {
        return this.y0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        boolean z;
        boolean zI;
        TimeZone timeZone = jz4.a;
        synchronized (this) {
            try {
                ku1 ku1Var = this.y0;
                if (ku1Var.f || !ku1Var.X) {
                    z = false;
                } else {
                    ju1 ju1Var = this.z0;
                    if (ju1Var.b || ju1Var.z) {
                        z = true;
                    }
                }
                zI = i();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            d(t51.CANCEL, null);
        } else {
            if (zI) {
                return;
            }
            this.f.x(this.b);
        }
    }

    public final void c() throws IOException {
        ju1 ju1Var = this.z0;
        if (ju1Var.z) {
            vp1.i("stream closed");
            return;
        }
        if (ju1Var.b) {
            vp1.i("stream finished");
            return;
        }
        if (g() != null) {
            IOException iOException = this.D0;
            if (iOException != null) {
                throw iOException;
            }
            t51 t51VarG = g();
            t51VarG.getClass();
            throw new x34(t51VarG);
        }
    }

    public final void d(t51 t51Var, IOException iOException) {
        if (e(t51Var, iOException)) {
            fu1 fu1Var = this.f;
            fu1Var.getClass();
            fu1Var.N0.I(this.b, t51Var);
        }
    }

    public final boolean e(t51 t51Var, IOException iOException) {
        TimeZone timeZone = jz4.a;
        synchronized (this) {
            if (g() != null) {
                return false;
            }
            this.C0 = t51Var;
            this.D0 = iOException;
            notifyAll();
            if (this.y0.f) {
                if (this.z0.b) {
                    return false;
                }
            }
            this.f.x(this.b);
            return true;
        }
    }

    public final void f(t51 t51Var) {
        if (e(t51Var, null)) {
            this.f.M(this.b, t51Var);
        }
    }

    public final t51 g() {
        t51 t51Var;
        synchronized (this) {
            t51Var = this.C0;
        }
        return t51Var;
    }

    public final boolean h() {
        boolean z = (this.b & 1) == 1;
        this.f.getClass();
        return true == z;
    }

    public final boolean i() {
        synchronized (this) {
            try {
                if (g() != null) {
                    return false;
                }
                ku1 ku1Var = this.y0;
                if (ku1Var.f || ku1Var.X) {
                    ju1 ju1Var = this.z0;
                    if (ju1Var.b || ju1Var.z) {
                        if (this.Z) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(lr1 lr1Var, boolean z) {
        boolean zI;
        lr1Var.getClass();
        TimeZone timeZone = jz4.a;
        synchronized (this) {
            try {
                if (this.Z && lr1Var.a(":status") == null && lr1Var.a(":method") == null) {
                    this.y0.getClass();
                } else {
                    this.Z = true;
                    this.Y.add(lr1Var);
                }
                if (z) {
                    this.y0.f = true;
                }
                zI = i();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zI) {
            return;
        }
        this.f.x(this.b);
    }

    public final void k(t51 t51Var) {
        synchronized (this) {
            if (g() == null) {
                this.C0 = t51Var;
                notifyAll();
            }
        }
    }

    @Override // defpackage.wy3
    public final vx3 p() {
        return this.z0;
    }
}
