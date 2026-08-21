package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sb1 implements s61 {
    public Object A;
    public final Object X;
    public long b;
    public Object f;
    public Object z;

    public sb1(ye3 ye3Var, ab4 ab4Var) {
        ab4Var.getClass();
        this.f = ye3Var;
        this.z = ab4Var;
        this.b = Long.MIN_VALUE;
        this.A = new CopyOnWriteArrayList();
        this.X = new LinkedBlockingDeque();
    }

    @Override // defpackage.s61
    public me3 a() throws IOException {
        gm3 gm3VarC;
        long j;
        gm3 gm3Var;
        IOException iOException = null;
        while (true) {
            try {
                if (((CopyOnWriteArrayList) this.A).isEmpty() && !((ye3) this.f).a(null)) {
                    b();
                    iOException.getClass();
                    throw iOException;
                }
                if (((ye3) this.f).k.G0) {
                    throw new IOException("Canceled");
                }
                oj1 oj1Var = ((ab4) this.z).a;
                long jNanoTime = System.nanoTime();
                long j2 = this.b - jNanoTime;
                if (((CopyOnWriteArrayList) this.A).isEmpty() || j2 <= 0) {
                    gm3VarC = c();
                    j = 250000000;
                    this.b = jNanoTime + 250000000;
                } else {
                    j = j2;
                    gm3VarC = null;
                }
                if (gm3VarC == null) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.A;
                    if (copyOnWriteArrayList.isEmpty() || (gm3Var = (gm3) ((LinkedBlockingDeque) this.X).poll(j, timeUnit)) == null) {
                        gm3VarC = null;
                    } else {
                        copyOnWriteArrayList.remove(gm3Var.a);
                        gm3VarC = gm3Var;
                    }
                    if (gm3VarC == null) {
                    }
                }
                boolean z = false;
                if (gm3VarC.b == null && gm3VarC.c == null) {
                    b();
                    if (!gm3VarC.a.isReady()) {
                        gm3VarC = gm3VarC.a.f();
                    }
                    if (gm3VarC.b == null && gm3VarC.c == null) {
                        z = true;
                    }
                    if (z) {
                        return gm3VarC.a.b();
                    }
                }
                Throwable th = gm3VarC.c;
                if (th != null) {
                    if (!(th instanceof IOException)) {
                        throw th;
                    }
                    if (iOException == null) {
                        iOException = (IOException) th;
                    } else {
                        ek0.b(iOException, th);
                    }
                }
                hm3 hm3Var = gm3VarC.b;
                if (hm3Var != null) {
                    ((ye3) this.f).p.addFirst(hm3Var);
                }
            } finally {
                b();
            }
        }
    }

    public void b() {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.A;
        Iterator it = copyOnWriteArrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            hm3 hm3Var = (hm3) it.next();
            hm3Var.cancel();
            hm3 hm3VarA = hm3Var.a();
            if (hm3VarA != null) {
                ((ye3) this.f).p.addLast(hm3VarA);
            }
        }
        copyOnWriteArrayList.clear();
    }

    public gm3 c() {
        hm3 cb1Var;
        ye3 ye3Var = (ye3) this.f;
        if (ye3Var.a(null)) {
            try {
                cb1Var = ye3Var.b();
            } catch (Throwable th) {
                cb1Var = new cb1(th);
            }
            if (cb1Var.isReady()) {
                return new gm3(cb1Var, null, null, 6);
            }
            if (cb1Var instanceof cb1) {
                return ((cb1) cb1Var).a;
            }
            ((CopyOnWriteArrayList) this.A).add(cb1Var);
            ((ab4) this.z).d().d(new rb1(jz4.b + " connect " + ye3Var.i.i.h(), cb1Var, this), 0L);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(long r11, defpackage.w75 r13) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sb1.d(long, w75):boolean");
    }

    @Override // defpackage.s61
    public ye3 k() {
        return (ye3) this.f;
    }

    public /* synthetic */ sb1(ff5 ff5Var) {
        this.X = ff5Var;
    }
}
