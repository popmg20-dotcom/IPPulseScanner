package defpackage;

import android.util.Log;
import android.util.Size;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dn0 {
    public static final Size k = new Size(0, 0);
    public static final boolean l = ez4.F("DeferrableSurface");
    public static final AtomicInteger m = new AtomicInteger(0);
    public static final AtomicInteger n = new AtomicInteger(0);
    public final Object a = new Object();
    public int b = 0;
    public boolean c = false;
    public vv d;
    public final yv e;
    public vv f;
    public final yv g;
    public final Size h;
    public final int i;
    public Class j;

    public dn0(Size size, int i) {
        final int i2 = 0;
        this.h = size;
        this.i = i;
        yv yvVarM = fx3.m(new wv(this) { // from class: bn0
            public final /* synthetic */ dn0 f;

            {
                this.f = this;
            }

            private final Object a(vv vvVar) {
                dn0 dn0Var = this.f;
                synchronized (dn0Var.a) {
                    dn0Var.d = vvVar;
                }
                return "DeferrableSurface-termination(" + dn0Var + ")";
            }

            @Override // defpackage.wv
            public final Object n(vv vvVar) {
                switch (i2) {
                    case 0:
                        return a(vvVar);
                    default:
                        dn0 dn0Var = this.f;
                        synchronized (dn0Var.a) {
                            dn0Var.f = vvVar;
                            break;
                        }
                        return "DeferrableSurface-close(" + dn0Var + ")";
                }
            }
        });
        this.e = yvVarM;
        final int i3 = 1;
        this.g = fx3.m(new wv(this) { // from class: bn0
            public final /* synthetic */ dn0 f;

            {
                this.f = this;
            }

            private final Object a(vv vvVar) {
                dn0 dn0Var = this.f;
                synchronized (dn0Var.a) {
                    dn0Var.d = vvVar;
                }
                return "DeferrableSurface-termination(" + dn0Var + ")";
            }

            @Override // defpackage.wv
            public final Object n(vv vvVar) {
                switch (i3) {
                    case 0:
                        return a(vvVar);
                    default:
                        dn0 dn0Var = this.f;
                        synchronized (dn0Var.a) {
                            dn0Var.f = vvVar;
                            break;
                        }
                        return "DeferrableSurface-close(" + dn0Var + ")";
                }
            }
        });
        if (ez4.F("DeferrableSurface")) {
            e(n.incrementAndGet(), m.get(), "Surface created");
            yvVarM.f.a(new s7(27, this, Log.getStackTraceString(new Exception())), yu0.a());
        }
    }

    public void a() {
        vv vvVar;
        synchronized (this.a) {
            try {
                if (this.c) {
                    vvVar = null;
                } else {
                    this.c = true;
                    this.f.b(null);
                    if (this.b == 0) {
                        vvVar = this.d;
                        this.d = null;
                    } else {
                        vvVar = null;
                    }
                    if (ez4.F("DeferrableSurface")) {
                        ez4.o("DeferrableSurface", "surface closed,  useCount=" + this.b + " closed=true " + this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vvVar != null) {
            vvVar.b(null);
        }
    }

    public final void b() {
        vv vvVar;
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i2 = i - 1;
                this.b = i2;
                if (i2 == 0 && this.c) {
                    vvVar = this.d;
                    this.d = null;
                } else {
                    vvVar = null;
                }
                if (ez4.F("DeferrableSurface")) {
                    ez4.o("DeferrableSurface", "use count-1,  useCount=" + this.b + " closed=" + this.c + " " + this);
                    if (this.b == 0) {
                        e(n.get(), m.decrementAndGet(), "Surface no longer in use");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vvVar != null) {
            vvVar.b(null);
        }
    }

    public final nc2 c() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return new zy1(1, new cn0("DeferrableSurface already closed.", this));
                }
                return f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0 && this.c) {
                    throw new cn0("Cannot begin use on a closed surface.", this);
                }
                this.b = i + 1;
                if (ez4.F("DeferrableSurface")) {
                    if (this.b == 1) {
                        e(n.get(), m.incrementAndGet(), "New surface in use");
                    }
                    ez4.o("DeferrableSurface", "use count+1, useCount=" + this.b + " " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(int i, int i2, String str) {
        if (!l && ez4.F("DeferrableSurface")) {
            ez4.o("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        ez4.o("DeferrableSurface", str + "[total_surfaces=" + i + ", used_surfaces=" + i2 + "](" + this + "}");
    }

    public abstract nc2 f();
}
