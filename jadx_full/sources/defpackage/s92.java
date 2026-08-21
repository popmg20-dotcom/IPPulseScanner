package defpackage;

import android.os.Build;
import android.util.Range;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s92 implements ca2, wx {
    public final da2 f;
    public final j00 z;
    public final Object b = new Object();
    public boolean A = false;
    public r90 X = null;

    public s92(da2 da2Var, j00 j00Var) {
        this.f = da2Var;
        this.z = j00Var;
        if (da2Var.getLifecycle().b().compareTo(q92.A) >= 0) {
            j00Var.n();
        } else {
            j00Var.y();
        }
        da2Var.getLifecycle().a(this);
    }

    @Override // defpackage.wx
    public final kz b() {
        return this.z.b.f;
    }

    @Override // defpackage.wx
    public final xy d() {
        return this.z.b.z;
    }

    public final void e(r90 r90Var) {
        synchronized (this.b) {
            try {
                if (this.X == null) {
                    this.X = r90Var;
                } else {
                    ArrayList arrayList = new ArrayList((List) this.X.e);
                    arrayList.addAll((List) r90Var.e);
                    this.X = new r90(arrayList, (List) r90Var.a);
                }
                this.z.N();
                this.z.J((List) r90Var.a);
                this.z.M();
                this.z.L((Range) r90Var.b);
                kz kzVarB = b();
                kzVarB.getClass();
                cp1 cp1VarP = d7.p(kzVarB, r90Var);
                ((ScheduledExecutorService) r90Var.g).execute(new xy0(5, cp1VarP, r90Var));
                this.z.e((List) r90Var.e, cp1VarP);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final da2 j() {
        da2 da2Var;
        synchronized (this.b) {
            da2Var = this.f;
        }
        return da2Var;
    }

    @ev2(p92.ON_DESTROY)
    public void onDestroy(da2 da2Var) {
        synchronized (this.b) {
            j00 j00Var = this.z;
            j00Var.G((ArrayList) j00Var.C());
        }
    }

    @ev2(p92.ON_PAUSE)
    public void onPause(da2 da2Var) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.z.b.k(false);
        }
    }

    @ev2(p92.ON_RESUME)
    public void onResume(da2 da2Var) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.z.b.k(true);
        }
    }

    @ev2(p92.ON_START)
    public void onStart(da2 da2Var) {
        synchronized (this.b) {
            try {
                if (!this.A) {
                    this.z.n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ev2(p92.ON_STOP)
    public void onStop(da2 da2Var) {
        synchronized (this.b) {
            try {
                if (!this.A) {
                    this.z.y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final List t() {
        List listUnmodifiableList;
        synchronized (this.b) {
            listUnmodifiableList = DesugarCollections.unmodifiableList(this.z.C());
        }
        return listUnmodifiableList;
    }

    public final boolean u(in4 in4Var) {
        boolean zContains;
        synchronized (this.b) {
            zContains = ((ArrayList) this.z.C()).contains(in4Var);
        }
        return zContains;
    }

    public final boolean v() {
        boolean z;
        synchronized (this.b) {
            z = this.X != null;
        }
        return z;
    }

    public final void w() {
        synchronized (this.b) {
            try {
                if (this.A) {
                    return;
                }
                onStop(this.f);
                this.A = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x() {
        synchronized (this.b) {
            j00 j00Var = this.z;
            j00Var.G((ArrayList) j00Var.C());
            this.X = null;
        }
    }

    public final void y() {
        synchronized (this.b) {
            try {
                if (this.A) {
                    this.A = false;
                    if (this.f.getLifecycle().b().compareTo(q92.A) >= 0) {
                        onStart(this.f);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
