package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class za4 {
    public final ab4 a;
    public final String b;
    public boolean c;
    public ua4 d;
    public final ArrayList e = new ArrayList();
    public boolean f;

    public za4(ab4 ab4Var, String str) {
        this.a = ab4Var;
        this.b = str;
    }

    public static void c(za4 za4Var, String str, pl1 pl1Var) {
        za4Var.getClass();
        str.getClass();
        pl1Var.getClass();
        za4Var.d(new ne3(str, pl1Var), 0L);
    }

    public final void a() {
        ab4 ab4Var = this.a;
        TimeZone timeZone = jz4.a;
        synchronized (ab4Var) {
            if (b()) {
                this.a.c(this);
            }
        }
    }

    public final boolean b() {
        ua4 ua4Var = this.d;
        if (ua4Var != null && ua4Var.b) {
            this.f = true;
        }
        ArrayList arrayList = this.e;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((ua4) arrayList.get(size)).b) {
                Logger logger = this.a.b;
                ua4 ua4Var2 = (ua4) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    ye.D(logger, ua4Var2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void d(ua4 ua4Var, long j) {
        ua4Var.getClass();
        synchronized (this.a) {
            if (!this.c) {
                if (e(ua4Var, j, false)) {
                    this.a.c(this);
                }
                return;
            }
            boolean z = ua4Var.b;
            Logger logger = this.a.b;
            if (z) {
                if (logger.isLoggable(Level.FINE)) {
                    ye.D(logger, ua4Var, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (logger.isLoggable(Level.FINE)) {
                    ye.D(logger, ua4Var, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0079 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(ua4 ua4Var, long j, boolean z) {
        Iterator it;
        int size;
        Logger logger = this.a.b;
        ua4Var.getClass();
        za4 za4Var = ua4Var.c;
        if (za4Var != this) {
            if (za4Var != null) {
                xe.q("task is in multiple queues");
                return false;
            }
            ua4Var.c = this;
        }
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime + j;
        ArrayList arrayList = this.e;
        int iIndexOf = arrayList.indexOf(ua4Var);
        if (iIndexOf == -1) {
            ua4Var.d = j2;
            if (logger.isLoggable(Level.FINE)) {
                ye.D(logger, ua4Var, this, z ? "run again after ".concat(ye.s(j2 - jNanoTime)) : "scheduled after ".concat(ye.s(j2 - jNanoTime)));
            }
            it = arrayList.iterator();
            size = 0;
            while (true) {
                if (it.hasNext()) {
                    size = -1;
                    break;
                }
                if (((ua4) it.next()).d - jNanoTime > j) {
                    break;
                }
                size++;
            }
            if (size == -1) {
                size = arrayList.size();
            }
            arrayList.add(size, ua4Var);
            if (size != 0) {
                return true;
            }
        } else if (ua4Var.d > j2) {
            arrayList.remove(iIndexOf);
            ua4Var.d = j2;
            if (logger.isLoggable(Level.FINE)) {
            }
            it = arrayList.iterator();
            size = 0;
            while (true) {
                if (it.hasNext()) {
                }
                size++;
            }
            if (size == -1) {
            }
            arrayList.add(size, ua4Var);
            if (size != 0) {
            }
        } else if (logger.isLoggable(Level.FINE)) {
            ye.D(logger, ua4Var, this, "already scheduled");
            return false;
        }
        return false;
    }

    public final void f() {
        ab4 ab4Var = this.a;
        TimeZone timeZone = jz4.a;
        synchronized (ab4Var) {
            this.c = true;
            if (b()) {
                this.a.c(this);
            }
        }
    }

    public final String toString() {
        return this.b;
    }
}
