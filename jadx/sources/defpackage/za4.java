package defpackage;

import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(defpackage.ua4 r12, long r13, boolean r15) {
        /*
            r11 = this;
            ab4 r0 = r11.a
            java.util.logging.Logger r0 = r0.b
            r12.getClass()
            za4 r1 = r12.c
            r2 = 0
            if (r1 != r11) goto Ld
            goto L11
        Ld:
            if (r1 != 0) goto L88
            r12.c = r11
        L11:
            long r3 = java.lang.System.nanoTime()
            long r5 = r3 + r13
            java.util.ArrayList r1 = r11.e
            int r7 = r1.indexOf(r12)
            r8 = -1
            if (r7 == r8) goto L37
            long r9 = r12.d
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 > 0) goto L34
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r13 = r0.isLoggable(r13)
            if (r13 == 0) goto L87
            java.lang.String r13 = "already scheduled"
            defpackage.ye.D(r0, r12, r11, r13)
            return r2
        L34:
            r1.remove(r7)
        L37:
            r12.d = r5
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            boolean r7 = r0.isLoggable(r7)
            if (r7 == 0) goto L5d
            if (r15 == 0) goto L4f
            long r5 = r5 - r3
            java.lang.String r15 = defpackage.ye.s(r5)
            java.lang.String r5 = "run again after "
            java.lang.String r15 = r5.concat(r15)
            goto L5a
        L4f:
            long r5 = r5 - r3
            java.lang.String r15 = defpackage.ye.s(r5)
            java.lang.String r5 = "scheduled after "
            java.lang.String r15 = r5.concat(r15)
        L5a:
            defpackage.ye.D(r0, r12, r11, r15)
        L5d:
            java.util.Iterator r11 = r1.iterator()
            r15 = r2
        L62:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L79
            java.lang.Object r0 = r11.next()
            ua4 r0 = (defpackage.ua4) r0
            long r5 = r0.d
            long r5 = r5 - r3
            int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r0 <= 0) goto L76
            goto L7a
        L76:
            int r15 = r15 + 1
            goto L62
        L79:
            r15 = r8
        L7a:
            if (r15 != r8) goto L80
            int r15 = r1.size()
        L80:
            r1.add(r15, r12)
            if (r15 != 0) goto L87
            r11 = 1
            return r11
        L87:
            return r2
        L88:
            java.lang.String r11 = "task is in multiple queues"
            defpackage.xe.q(r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za4.e(ua4, long, boolean):boolean");
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
