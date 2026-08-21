package defpackage;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ne3 extends ua4 {
    public final /* synthetic */ int e = 1;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ne3(oe3 oe3Var, String str) {
        super(str);
        this.f = oe3Var;
    }

    @Override // defpackage.ua4
    public final long a() {
        switch (this.e) {
            case 0:
                oe3 oe3Var = (oe3) this.f;
                long jNanoTime = System.nanoTime();
                long j = (jNanoTime - oe3Var.b) + 1;
                Iterator it = ((ConcurrentLinkedQueue) oe3Var.e).iterator();
                it.getClass();
                me3 me3Var = null;
                long j2 = Long.MAX_VALUE;
                int i = 0;
                me3 me3Var2 = null;
                me3 me3Var3 = null;
                int i2 = 0;
                while (it.hasNext()) {
                    me3 me3Var4 = (me3) it.next();
                    me3Var4.getClass();
                    synchronized (me3Var4) {
                        if (oe3Var.a(me3Var4, jNanoTime) > 0) {
                            i2++;
                        } else {
                            long j3 = me3Var4.q;
                            if (j3 < j) {
                                j = j3;
                                me3Var2 = me3Var4;
                            }
                            i++;
                            if (j3 < j2) {
                                j2 = j3;
                                me3Var3 = me3Var4;
                            }
                        }
                    }
                }
                if (me3Var2 != null) {
                    me3Var = me3Var2;
                } else if (i > 5) {
                    j = j2;
                    me3Var = me3Var3;
                } else {
                    j = -1;
                }
                if (me3Var == null) {
                    if (me3Var3 != null) {
                        return (j2 + oe3Var.b) - jNanoTime;
                    }
                    if (i2 > 0) {
                        return oe3Var.b;
                    }
                    return -1L;
                }
                synchronized (me3Var) {
                    if (me3Var.p.isEmpty() && me3Var.q == j) {
                        me3Var.j = true;
                        ((ConcurrentLinkedQueue) oe3Var.e).remove(me3Var);
                        jz4.c(me3Var.e);
                        if (!((ConcurrentLinkedQueue) oe3Var.e).isEmpty()) {
                            return 0L;
                        }
                        ((za4) oe3Var.c).a();
                        return 0L;
                    }
                    return 0L;
                }
            default:
                ((pl1) this.f).a();
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ne3(String str, pl1 pl1Var) {
        super(str);
        this.f = pl1Var;
    }
}
