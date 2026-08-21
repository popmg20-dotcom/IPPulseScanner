package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.os.Trace;
import androidx.work.impl.WorkDatabase;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xw4 {
    public static xw4 k;
    public static xw4 l;
    public static final Object m;
    public final Context a;
    public final na0 b;
    public final WorkDatabase c;
    public final ih4 d;
    public final List e;
    public final n53 f;
    public final cx1 g;
    public boolean h = false;
    public BroadcastReceiver.PendingResult i;
    public final v92 j;

    static {
        ue2.i("WorkManagerImpl");
        k = null;
        l = null;
        m = new Object();
    }

    public xw4(Context context, final na0 na0Var, ih4 ih4Var, final WorkDatabase workDatabase, final List list, n53 n53Var, v92 v92Var) {
        int i = 0;
        Context applicationContext = context.getApplicationContext();
        ge0 ge0Var = null;
        if (Build.VERSION.SDK_INT >= 24 && ga5.s(applicationContext)) {
            xe.q("Cannot initialize WorkManager in direct boot mode");
            throw null;
        }
        ue2 ue2Var = new ue2(4, false);
        synchronized (ue2.f) {
            try {
                if (ue2.z == null) {
                    ue2.z = ue2Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a = applicationContext;
        this.d = ih4Var;
        this.c = workDatabase;
        this.f = n53Var;
        this.j = v92Var;
        this.b = na0Var;
        this.e = list;
        ef0 ef0Var = (ef0) ih4Var.b;
        ef0Var.getClass();
        ce0 ce0VarA = p95.a(ef0Var);
        this.g = new cx1(workDatabase);
        final la laVar = (la) ih4Var.a;
        String str = fq3.a;
        n53Var.a(new w61() { // from class: eq3
            @Override // defpackage.w61
            public final void b(vw4 vw4Var, boolean z) {
                laVar.execute(new iy(list, vw4Var, na0Var, workDatabase, 5));
            }
        });
        ((la) ih4Var.a).execute(new mi1(applicationContext, this));
        String str2 = ll4.a;
        if (m53.a(applicationContext, na0Var)) {
            pl3 pl3Var = workDatabase.x().a;
            ji0.B(ce0VarA, null, null, new mt(new pg1(ji0.n(p95.b(new tg1(new ph1(p95.b(pl3Var.g().a(true, (String[]) Arrays.copyOf(new String[]{"workspec"}, 1)), -1), pl3Var, new q74(15)), new kl4(4, null), i), -1)), new no1(applicationContext, null), 2), ge0Var, 5), 3);
        }
    }

    public static xw4 b() {
        synchronized (m) {
            try {
                xw4 xw4Var = k;
                if (xw4Var != null) {
                    return xw4Var;
                }
                return l;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static xw4 c(Context context) {
        xw4 xw4VarB;
        synchronized (m) {
            try {
                xw4VarB = b();
                if (xw4VarB == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xw4VarB;
    }

    public final k01 a() {
        t60 t60Var = this.b.g;
        String strConcat = "CancelWorkByTag_".concat("UpdateProfileWorker");
        la laVar = (la) this.d.a;
        laVar.getClass();
        return p95.w(t60Var, strConcat, laVar, new w00(this, 0));
    }

    public final void d() {
        synchronized (m) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        t60 t60Var = this.b.g;
        w00 w00Var = new w00(this, 1);
        boolean zA = vo.A();
        if (zA) {
            try {
                Trace.beginSection(vo.O("ReschedulingWork"));
            } finally {
                if (zA) {
                    Trace.endSection();
                }
            }
        }
        w00Var.a();
    }
}
