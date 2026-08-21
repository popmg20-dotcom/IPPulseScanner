package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n53 {
    public static final String l = ue2.i("Processor");
    public final Context b;
    public final na0 c;
    public final ih4 d;
    public final WorkDatabase e;
    public final HashMap g = new HashMap();
    public final HashMap f = new HashMap();
    public final HashSet i = new HashSet();
    public final ArrayList j = new ArrayList();
    public PowerManager.WakeLock a = null;
    public final Object k = new Object();
    public final HashMap h = new HashMap();

    public n53(Context context, na0 na0Var, ih4 ih4Var, WorkDatabase workDatabase) {
        this.b = context;
        this.c = na0Var;
        this.d = ih4Var;
        this.e = workDatabase;
    }

    public static boolean e(String str, yx4 yx4Var, int i) {
        String str2 = l;
        if (yx4Var == null) {
            ue2.g().a(str2, "WorkerWrapper could not be found for " + str);
            return false;
        }
        yx4Var.l.q(new nx4(i));
        ue2.g().a(str2, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(w61 w61Var) {
        synchronized (this.k) {
            this.j.add(w61Var);
        }
    }

    public final yx4 b(String str) {
        yx4 yx4Var = (yx4) this.f.remove(str);
        boolean z = yx4Var != null;
        if (!z) {
            yx4Var = (yx4) this.g.remove(str);
        }
        this.h.remove(str);
        if (z) {
            synchronized (this.k) {
                try {
                    if (this.f.isEmpty()) {
                        Context context = this.b;
                        String str2 = y84.A0;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.b.startService(intent);
                        } catch (Throwable th) {
                            ue2.g().f(l, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return yx4Var;
    }

    public final gx4 c(String str) {
        synchronized (this.k) {
            try {
                yx4 yx4VarD = d(str);
                if (yx4VarD == null) {
                    return null;
                }
                return yx4VarD.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final yx4 d(String str) {
        yx4 yx4Var = (yx4) this.f.get(str);
        return yx4Var == null ? (yx4) this.g.get(str) : yx4Var;
    }

    public final boolean f(String str) {
        boolean z;
        synchronized (this.k) {
            z = d(str) != null;
        }
        return z;
    }

    public final void g(w61 w61Var) {
        synchronized (this.k) {
            this.j.remove(w61Var);
        }
    }

    public final boolean h(h24 h24Var, int i) {
        String str = h24Var.a.a;
        synchronized (this.k) {
            try {
                if (this.f.get(str) == null) {
                    Set set = (Set) this.h.get(str);
                    if (set != null && set.contains(h24Var)) {
                        return e(str, b(str), i);
                    }
                    return false;
                }
                ue2.g().a(l, "Ignored stopWork. WorkerWrapper " + str + " is in foreground");
                return false;
            } finally {
            }
        }
    }
}
