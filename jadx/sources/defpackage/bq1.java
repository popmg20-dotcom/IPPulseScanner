package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bq1 implements dq3, zu2, w61 {
    public static final String F0 = ue2.i("GreedyScheduler");
    public boolean A;
    public Boolean B0;
    public final m20 C0;
    public final ih4 D0;
    public final iv1 E0;
    public final n53 Z;
    public final Context b;
    public final e24 y0;
    public final rn0 z;
    public final na0 z0;
    public final HashMap f = new HashMap();
    public final Object X = new Object();
    public final e24 Y = new e24(new wn1(20));
    public final HashMap A0 = new HashMap();

    public bq1(Context context, na0 na0Var, v92 v92Var, n53 n53Var, e24 e24Var, ih4 ih4Var) {
        this.b = context;
        w7 w7Var = na0Var.e;
        this.z = new rn0(this, w7Var, na0Var.d);
        this.E0 = new iv1(w7Var, e24Var);
        this.D0 = ih4Var;
        this.C0 = new m20(v92Var);
        this.z0 = na0Var;
        this.Z = n53Var;
        this.y0 = e24Var;
    }

    @Override // defpackage.zu2
    public final void a(gx4 gx4Var, qc0 qc0Var) {
        vw4 vw4VarM = l72.m(gx4Var);
        boolean z = qc0Var instanceof oc0;
        e24 e24Var = this.y0;
        iv1 iv1Var = this.E0;
        String str = F0;
        e24 e24Var2 = this.Y;
        if (z) {
            if (e24Var2.h(vw4VarM)) {
                return;
            }
            ue2.g().a(str, "Constraints met: Scheduling work ID " + vw4VarM);
            h24 h24VarG = e24Var2.G(vw4VarM);
            iv1Var.E(h24VarG);
            e24Var.getClass();
            e24Var.E(h24VarG, null);
            return;
        }
        ue2.g().a(str, "Constraints not met: Cancelling work ID " + vw4VarM);
        h24 h24VarB = e24Var2.B(vw4VarM);
        if (h24VarB != null) {
            iv1Var.f(h24VarB);
            int i = ((pc0) qc0Var).a;
            e24Var.getClass();
            e24Var.F(h24VarB, i);
        }
    }

    @Override // defpackage.w61
    public final void b(vw4 vw4Var, boolean z) {
        h24 h24VarB = this.Y.B(vw4Var);
        if (h24VarB != null) {
            this.E0.f(h24VarB);
        }
        f(vw4Var);
        if (z) {
            return;
        }
        synchronized (this.X) {
            this.A0.remove(vw4Var);
        }
    }

    @Override // defpackage.dq3
    public final boolean c() {
        return false;
    }

    @Override // defpackage.dq3
    public final void d(String str) {
        List<h24> listE;
        Runnable runnable;
        String str2 = F0;
        Boolean boolValueOf = this.B0;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(m53.a(this.b, this.z0));
            this.B0 = boolValueOf;
        }
        if (!boolValueOf.booleanValue()) {
            ue2.g().h(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.A) {
            this.Z.a(this);
            this.A = true;
        }
        ue2.g().a(str2, "Cancelling work ID " + str);
        rn0 rn0Var = this.z;
        if (rn0Var != null && (runnable = (Runnable) rn0Var.c.remove(str)) != null) {
            ((Handler) rn0Var.b.f).removeCallbacks(runnable);
        }
        e24 e24Var = this.Y;
        e24Var.getClass();
        str.getClass();
        synchronized (e24Var.z) {
            listE = ((wn1) e24Var.f).E(str);
        }
        for (h24 h24Var : listE) {
            this.E0.f(h24Var);
            e24 e24Var2 = this.y0;
            e24Var2.getClass();
            e24Var2.F(h24Var, -512);
        }
    }

    @Override // defpackage.dq3
    public final void e(gx4... gx4VarArr) {
        Boolean boolValueOf = this.B0;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(m53.a(this.b, this.z0));
            this.B0 = boolValueOf;
        }
        if (!boolValueOf.booleanValue()) {
            ue2.g().h(F0, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.A) {
            this.Z.a(this);
            this.A = true;
        }
        HashSet<gx4> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        boolean z = false;
        for (gx4 gx4Var : gx4VarArr) {
            if (!this.Y.h(l72.m(gx4Var))) {
                long jMax = Math.max(gx4Var.a(), g(gx4Var));
                d84 d84Var = this.z0.d;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (gx4Var.b == ww4.b) {
                    if (jCurrentTimeMillis < jMax) {
                        rn0 rn0Var = this.z;
                        if (rn0Var != null) {
                            w7 w7Var = rn0Var.b;
                            HashMap map = rn0Var.c;
                            Runnable runnable = (Runnable) map.remove(gx4Var.a);
                            if (runnable != null) {
                                ((Handler) w7Var.f).removeCallbacks(runnable);
                            }
                            tm1 tm1Var = new tm1(7, rn0Var, gx4Var, z);
                            map.put(gx4Var.a, tm1Var);
                            ((Handler) w7Var.f).postDelayed(tm1Var, jMax - System.currentTimeMillis());
                        }
                    } else if (!n12.c(mc0.j, gx4Var.j)) {
                        mc0 mc0Var = gx4Var.j;
                        if (mc0Var.d) {
                            ue2.g().a(F0, "Ignoring " + gx4Var + ". Requires device idle.");
                        } else if (Build.VERSION.SDK_INT < 24 || !mc0Var.b()) {
                            hashSet.add(gx4Var);
                            hashSet2.add(gx4Var.a);
                        } else {
                            ue2.g().a(F0, "Ignoring " + gx4Var + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.Y.h(l72.m(gx4Var))) {
                        ue2.g().a(F0, "Starting work for " + gx4Var.a);
                        e24 e24Var = this.Y;
                        e24Var.getClass();
                        h24 h24VarG = e24Var.G(l72.m(gx4Var));
                        this.E0.E(h24VarG);
                        e24 e24Var2 = this.y0;
                        e24Var2.getClass();
                        e24Var2.E(h24VarG, null);
                    }
                }
            }
        }
        synchronized (this.X) {
            try {
                if (!hashSet.isEmpty()) {
                    ue2.g().a(F0, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    for (gx4 gx4Var2 : hashSet) {
                        vw4 vw4VarM = l72.m(gx4Var2);
                        if (!this.f.containsKey(vw4VarM)) {
                            this.f.put(vw4VarM, mw4.a(this.C0, gx4Var2, (ef0) this.D0.b, this));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(vw4 vw4Var) {
        v32 v32Var;
        synchronized (this.X) {
            v32Var = (v32) this.f.remove(vw4Var);
        }
        if (v32Var != null) {
            ue2.g().a(F0, "Stopping tracking for " + vw4Var);
            v32Var.g(null);
        }
    }

    public final long g(gx4 gx4Var) {
        long jMax;
        synchronized (this.X) {
            try {
                vw4 vw4VarM = l72.m(gx4Var);
                aq1 aq1Var = (aq1) this.A0.get(vw4VarM);
                if (aq1Var == null) {
                    int i = gx4Var.k;
                    d84 d84Var = this.z0.d;
                    aq1Var = new aq1(i, System.currentTimeMillis());
                    this.A0.put(vw4VarM, aq1Var);
                }
                jMax = (((long) Math.max((gx4Var.k - aq1Var.a) - 5, 0)) * 30000) + aq1Var.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jMax;
    }
}
