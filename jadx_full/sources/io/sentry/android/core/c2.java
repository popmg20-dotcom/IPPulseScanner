package io.sentry.android.core;

import android.view.Choreographer;
import defpackage.i60;
import io.sentry.h3;
import io.sentry.j3;
import io.sentry.w4;
import io.sentry.x5;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c2 implements io.sentry.android.core.internal.util.p, io.sentry.a1 {
    public static final x5 h = new x5(0, 0);
    public final boolean a;
    public final io.sentry.android.core.internal.util.r c;
    public volatile String d;
    public final io.sentry.util.a b = new io.sentry.util.a();
    public final TreeSet e = new TreeSet(new i60(14));
    public final ConcurrentSkipListSet f = new ConcurrentSkipListSet();
    public long g = 16666666;

    public c2(SentryAndroidOptions sentryAndroidOptions, io.sentry.android.core.internal.util.r rVar) {
        this.c = rVar;
        this.a = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    public static long g(w4 w4Var) {
        if (w4Var instanceof x5) {
            return w4Var.b(h);
        }
        return System.nanoTime() - ((System.currentTimeMillis() * 1000000) - w4Var.d());
    }

    @Override // io.sentry.android.core.internal.util.p
    public final void b(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
        ConcurrentSkipListSet concurrentSkipListSet = this.f;
        if (concurrentSkipListSet.size() > 3600) {
            return;
        }
        long j5 = (long) (1.0E9d / ((double) f));
        this.g = j5;
        if (z || z2) {
            concurrentSkipListSet.add(new b2(j, j2, j3, j4, z, z2, j5));
        }
    }

    public final void d() {
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            if (this.d != null) {
                this.c.c(this.d);
                this.d = null;
            }
            this.f.clear();
            this.e.clear();
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01de A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #3 {all -> 0x00c7, blocks: (B:34:0x008f, B:76:0x0144, B:78:0x014e, B:80:0x0152, B:82:0x015a, B:88:0x0167, B:97:0x017f, B:99:0x018b, B:102:0x0197, B:104:0x01a1, B:105:0x01ab, B:100:0x0190, B:106:0x01ad, B:108:0x01de, B:42:0x00ad, B:44:0x00b7, B:46:0x00be, B:58:0x00db, B:66:0x0110, B:68:0x0114, B:70:0x011b), top: B:142:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(io.sentry.n1 n1Var) throws Throwable {
        io.sentry.util.a aVar;
        boolean zRemove;
        ConcurrentSkipListSet concurrentSkipListSet;
        w4 w4VarS;
        TreeSet treeSet;
        ConcurrentSkipListSet concurrentSkipListSet2;
        int i;
        int i2;
        long j;
        long j2;
        long j3;
        long jLongValue;
        Field field;
        Iterator it;
        ConcurrentSkipListSet concurrentSkipListSet3;
        TreeSet treeSet2 = this.e;
        if (!this.a || (n1Var instanceof h3) || (n1Var instanceof j3)) {
            return;
        }
        io.sentry.util.a aVar2 = this.b;
        aVar2.g();
        try {
            if (!treeSet2.contains(n1Var)) {
                aVar2.close();
                return;
            }
            aVar2.close();
            aVar2.g();
            try {
                zRemove = treeSet2.remove(n1Var);
                concurrentSkipListSet = this.f;
            } catch (Throwable th) {
                th = th;
                aVar = aVar2;
            }
            if (zRemove && (w4VarS = n1Var.s()) != null) {
                long jG = g(n1Var.u());
                long jG2 = g(w4VarS);
                long j4 = jG2 - jG;
                if (j4 <= 0) {
                    aVar2.close();
                    treeSet = treeSet2;
                    aVar = aVar2;
                    concurrentSkipListSet2 = concurrentSkipListSet;
                } else {
                    long j5 = this.g;
                    int i3 = 1;
                    if (concurrentSkipListSet.isEmpty()) {
                        treeSet = treeSet2;
                        aVar = aVar2;
                        concurrentSkipListSet2 = concurrentSkipListSet;
                        i = 0;
                        i2 = 0;
                        j = 0;
                        j2 = 0;
                        j3 = 0;
                    } else {
                        Iterator it2 = concurrentSkipListSet.tailSet(new b2(jG)).iterator();
                        j = 0;
                        j2 = 0;
                        j3 = 0;
                        i = 0;
                        i2 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                treeSet = treeSet2;
                                aVar = aVar2;
                                break;
                            }
                            b2 b2Var = (b2) it2.next();
                            treeSet = treeSet2;
                            aVar = aVar2;
                            try {
                                long j6 = b2Var.b;
                                long j7 = b2Var.A;
                                long j8 = b2Var.Z;
                                long j9 = b2Var.f;
                                if (j6 > jG2) {
                                    break;
                                }
                                if (j6 < jG || j9 > jG2) {
                                    if ((jG > j6 && jG < j9) || (jG2 > j6 && jG2 < j9)) {
                                        it = it2;
                                        concurrentSkipListSet3 = concurrentSkipListSet;
                                        long jMin = Math.min(j7 - Math.max(0L, Math.max(0L, jG - j6) - j8), j4);
                                        long jMin2 = Math.min(jG2, j9) - Math.max(jG, b2Var.b);
                                        boolean z = jMin2 > j8;
                                        j3 += jMin2;
                                        if (jMin2 > 700000000) {
                                            j2 += jMin;
                                            i2++;
                                        } else if (z) {
                                            j += jMin;
                                            i++;
                                        }
                                    }
                                    treeSet2 = treeSet;
                                    aVar2 = aVar;
                                    concurrentSkipListSet = concurrentSkipListSet3;
                                    it2 = it;
                                    j5 = j8;
                                } else {
                                    long j10 = b2Var.z;
                                    boolean z2 = b2Var.X;
                                    j3 += j10;
                                    if (b2Var.Y) {
                                        j2 += j7;
                                        i2++;
                                    } else if (z2) {
                                        j += j7;
                                        i++;
                                    }
                                }
                                it = it2;
                                concurrentSkipListSet3 = concurrentSkipListSet;
                                treeSet2 = treeSet;
                                aVar2 = aVar;
                                concurrentSkipListSet = concurrentSkipListSet3;
                                it2 = it;
                                j5 = j8;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        concurrentSkipListSet2 = concurrentSkipListSet;
                    }
                    int iCeil = i + i2;
                    io.sentry.android.core.internal.util.r rVar = this.c;
                    Choreographer choreographer = rVar.B0;
                    if (choreographer == null || (field = rVar.C0) == null) {
                        jLongValue = -1;
                        if (jLongValue != -1) {
                            long jMax = Math.max(0L, jG2 - jLongValue);
                            if (jMax > j5) {
                                boolean z3 = jMax > 700000000;
                                long jMax2 = Math.max(0L, jMax - j5);
                                j3 += jMax;
                                if (z3) {
                                    j2 += jMax2;
                                    i2++;
                                } else {
                                    j += jMax2;
                                    i++;
                                }
                            } else {
                                i3 = 0;
                            }
                            long j11 = j4 - j3;
                            iCeil = iCeil + i3 + (j11 > 0 ? (int) Math.ceil(j11 / j5) : 0);
                        }
                        double d = (j + j2) / 1.0E9d;
                        n1Var.h(Integer.valueOf(iCeil), "frames.total");
                        n1Var.h(Integer.valueOf(i), "frames.slow");
                        n1Var.h(Integer.valueOf(i2), "frames.frozen");
                        n1Var.h(Double.valueOf(d), "frames.delay");
                        if (n1Var instanceof io.sentry.p1) {
                            n1Var.e(Integer.valueOf(iCeil), "frames_total");
                            n1Var.e(Integer.valueOf(i), "frames_slow");
                            n1Var.e(Integer.valueOf(i2), "frames_frozen");
                            n1Var.e(Double.valueOf(d), "frames_delay");
                        }
                        aVar.close();
                    } else {
                        try {
                            Long l = (Long) field.get(choreographer);
                            if (l != null) {
                                jLongValue = l.longValue();
                            }
                        } catch (IllegalAccessException unused) {
                        }
                        if (jLongValue != -1) {
                        }
                        double d2 = (j + j2) / 1.0E9d;
                        n1Var.h(Integer.valueOf(iCeil), "frames.total");
                        n1Var.h(Integer.valueOf(i), "frames.slow");
                        n1Var.h(Integer.valueOf(i2), "frames.frozen");
                        n1Var.h(Double.valueOf(d2), "frames.delay");
                        if (n1Var instanceof io.sentry.p1) {
                        }
                        aVar.close();
                    }
                }
                Throwable th3 = th;
                try {
                    aVar.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
            aVar2.close();
            treeSet = treeSet2;
            aVar = aVar2;
            concurrentSkipListSet2 = concurrentSkipListSet;
            aVar.g();
            try {
                if (treeSet.isEmpty()) {
                    d();
                } else {
                    concurrentSkipListSet2.headSet(new b2(g(((io.sentry.n1) treeSet.first()).u()))).clear();
                }
                aVar.close();
            } catch (Throwable th5) {
                try {
                    aVar.close();
                    throw th5;
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                    throw th5;
                }
            }
        } finally {
        }
    }

    public final void f(io.sentry.n1 n1Var) {
        if (!this.a || (n1Var instanceof h3) || (n1Var instanceof j3)) {
            return;
        }
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            this.e.add(n1Var);
            if (this.d == null) {
                this.d = this.c.b(this);
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
