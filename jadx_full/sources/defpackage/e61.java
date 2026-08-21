package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e61 implements Runnable, Comparable, zv0 {
    private volatile Object _heap;
    public long b;
    public int f = -1;

    public e61(long j) {
        this.b = j;
    }

    public final td4 b() {
        Object obj = this._heap;
        if (obj instanceof td4) {
            return (td4) obj;
        }
        return null;
    }

    @Override // defpackage.zv0
    public final void c() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                br1 br1Var = h61.a;
                if (obj == br1Var) {
                    return;
                }
                f61 f61Var = obj instanceof f61 ? (f61) obj : null;
                if (f61Var != null) {
                    f61Var.c(this);
                }
                this._heap = br1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.b - ((e61) obj).b;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    public final int d(long j, f61 f61Var, g61 g61Var) {
        synchronized (this) {
            if (this._heap == h61.a) {
                return 2;
            }
            synchronized (f61Var) {
                try {
                    e61[] e61VarArr = f61Var.a;
                    e61 e61Var = e61VarArr != null ? e61VarArr[0] : null;
                    int i = g61.A0;
                    if (re.a.getIntVolatile(g61Var, g61.y0) == 1) {
                        return 1;
                    }
                    if (e61Var == null) {
                        f61Var.c = j;
                    } else {
                        long j2 = e61Var.b;
                        if (j2 - j < 0) {
                            j = j2;
                        }
                        long j3 = f61Var.c;
                        if (j - j3 > 0) {
                            f61Var.c = j;
                        } else {
                            j = j3;
                        }
                    }
                    if (this.b - j < 0) {
                        this.b = j;
                    }
                    f61Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void e(f61 f61Var) {
        if (this._heap != h61.a) {
            this._heap = f61Var;
        } else {
            xe.k("Failed requirement.");
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.b + ']';
    }
}
