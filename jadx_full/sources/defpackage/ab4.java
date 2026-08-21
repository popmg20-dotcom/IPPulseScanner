package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ab4 {
    public static final Logger k;
    public static final ab4 l;
    public final oj1 a;
    public final Logger b;
    public int c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public final ArrayList h;
    public final ArrayList i;
    public final f33 j;

    static {
        Logger logger = Logger.getLogger(ab4.class.getName());
        logger.getClass();
        k = logger;
        l = new ab4(new oj1(new iz4(fw.y(new StringBuilder(), jz4.b, " TaskRunner"), true)));
    }

    public ab4(oj1 oj1Var) {
        Logger logger = k;
        logger.getClass();
        this.a = oj1Var;
        this.b = logger;
        this.c = 10000;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new f33(24, this);
    }

    public final void a(ua4 ua4Var, long j, boolean z) {
        TimeZone timeZone = jz4.a;
        za4 za4Var = ua4Var.c;
        za4Var.getClass();
        if (za4Var.d != ua4Var) {
            xe.q("Check failed.");
            return;
        }
        boolean z2 = za4Var.f;
        za4Var.f = false;
        za4Var.d = null;
        this.h.remove(za4Var);
        if (j != -1 && !z2 && !za4Var.c) {
            za4Var.e(ua4Var, j, true);
        }
        if (za4Var.e.isEmpty()) {
            return;
        }
        this.i.add(za4Var);
        if (z) {
            return;
        }
        e();
    }

    public final ua4 b() {
        boolean z;
        TimeZone timeZone = jz4.a;
        while (true) {
            ArrayList arrayList = this.i;
            if (arrayList.isEmpty()) {
                break;
            }
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            ua4 ua4Var = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ua4 ua4Var2 = (ua4) ((za4) it.next()).e.get(0);
                long jMax = Math.max(0L, ua4Var2.d - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (ua4Var != null) {
                        z = true;
                        break;
                    }
                    ua4Var = ua4Var2;
                }
            }
            ArrayList arrayList2 = this.h;
            if (ua4Var != null) {
                TimeZone timeZone2 = jz4.a;
                ua4Var.d = -1L;
                za4 za4Var = ua4Var.c;
                za4Var.getClass();
                za4Var.e.remove(ua4Var);
                arrayList.remove(za4Var);
                za4Var.d = ua4Var;
                arrayList2.add(za4Var);
                if (z || (!this.d && !arrayList.isEmpty())) {
                    e();
                }
                return ua4Var;
            }
            if (!this.d) {
                this.d = true;
                this.e = jNanoTime + jMin;
                try {
                    try {
                        TimeZone timeZone3 = jz4.a;
                        if (jMin > 0) {
                            long j = jMin / 1000000;
                            Long.signum(j);
                            long j2 = jMin - (1000000 * j);
                            if (j > 0 || jMin > 0) {
                                wait(j, (int) j2);
                            }
                        }
                    } catch (InterruptedException unused) {
                        TimeZone timeZone4 = jz4.a;
                        for (int size = arrayList2.size() - 1; -1 < size; size--) {
                            ((za4) arrayList2.get(size)).b();
                        }
                        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
                            za4 za4Var2 = (za4) arrayList.get(size2);
                            za4Var2.b();
                            if (za4Var2.e.isEmpty()) {
                                arrayList.remove(size2);
                            }
                        }
                    }
                } finally {
                    this.d = false;
                }
            } else if (jMin < this.e - jNanoTime) {
                notify();
            }
        }
        return null;
    }

    public final void c(za4 za4Var) {
        za4Var.getClass();
        TimeZone timeZone = jz4.a;
        if (za4Var.d == null) {
            boolean zIsEmpty = za4Var.e.isEmpty();
            ArrayList arrayList = this.i;
            if (zIsEmpty) {
                arrayList.remove(za4Var);
            } else {
                byte[] bArr = hz4.a;
                if (!arrayList.contains(za4Var)) {
                    arrayList.add(za4Var);
                }
            }
        }
        if (this.d) {
            notify();
        } else {
            e();
        }
    }

    public final za4 d() {
        int i;
        synchronized (this) {
            i = this.c;
            this.c = i + 1;
        }
        return new za4(this, dw2.A(i, "Q"));
    }

    public final void e() {
        TimeZone timeZone = jz4.a;
        int i = this.f;
        if (i > this.g) {
            return;
        }
        this.f = i + 1;
        ((ThreadPoolExecutor) this.a.f).execute(this.j);
    }
}
