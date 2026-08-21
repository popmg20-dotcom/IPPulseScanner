package defpackage;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class le3 implements Cloneable {
    public final ke3 A;
    public ue1 A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;
    public volatile boolean G0;
    public volatile ue1 H0;
    public final CopyOnWriteArrayList I0;
    public final AtomicBoolean X;
    public Object Y;
    public s61 Z;
    public final lu2 b;
    public final cm2 f;
    public me3 y0;
    public final oe3 z;
    public boolean z0;

    public le3(lu2 lu2Var, cm2 cm2Var) {
        lu2Var.getClass();
        cm2Var.getClass();
        this.b = lu2Var;
        this.f = cm2Var;
        this.z = (oe3) lu2Var.E.f;
        lu2Var.d.getClass();
        ke3 ke3Var = new ke3(this);
        ke3Var.g(lu2Var.w);
        this.A = ke3Var;
        this.X = new AtomicBoolean();
        this.F0 = true;
        this.I0 = new CopyOnWriteArrayList();
        new AtomicReference((p95) cm2Var.Y);
    }

    public final void a(me3 me3Var) {
        me3Var.getClass();
        TimeZone timeZone = jz4.a;
        if (this.y0 != null) {
            xe.q("Check failed.");
        } else {
            this.y0 = me3Var;
            me3Var.p.add(new je3(this, this.Y));
        }
    }

    public final IOException b(IOException iOException) {
        IOException interruptedIOException;
        Socket socketJ;
        TimeZone timeZone = jz4.a;
        me3 me3Var = this.y0;
        if (me3Var != null) {
            synchronized (me3Var) {
                socketJ = j();
            }
            if (this.y0 == null) {
                if (socketJ != null) {
                    jz4.c(socketJ);
                }
            } else if (socketJ != null) {
                xe.q("Check failed.");
                return null;
            }
        }
        if (!this.z0 && this.A.i()) {
            interruptedIOException = new InterruptedIOException(RtspHeaders.Values.TIMEOUT);
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            interruptedIOException.getClass();
        }
        return interruptedIOException;
    }

    public final void c() {
        if (this.G0) {
            return;
        }
        this.G0 = true;
        ue1 ue1Var = this.H0;
        if (ue1Var != null) {
            ((r61) ue1Var.A).cancel();
        }
        Iterator it = this.I0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((hm3) it.next()).cancel();
        }
    }

    public final Object clone() {
        return new le3(this.b, this.f);
    }

    public final void d(sv svVar) {
        if (!this.X.compareAndSet(false, true)) {
            xe.q("Already Executed");
            return;
        }
        k13 k13Var = k13.a;
        this.Y = k13.a.g();
        iv1 iv1Var = this.b.a;
        ie3 ie3Var = new ie3(this, svVar);
        iv1Var.getClass();
        iv1.y(iv1Var, ie3Var, null, null, 6);
    }

    public final kk3 e() {
        if (!this.X.compareAndSet(false, true)) {
            xe.q("Already Executed");
            return null;
        }
        this.A.h();
        k13 k13Var = k13.a;
        this.Y = k13.a.g();
        try {
            iv1 iv1Var = this.b.a;
            synchronized (iv1Var) {
                ((ArrayDeque) iv1Var.X).add(this);
            }
            return g();
        } finally {
            iv1 iv1Var2 = this.b.a;
            iv1Var2.getClass();
            iv1.y(iv1Var2, null, this, null, 5);
        }
    }

    public final void f(boolean z) {
        ue1 ue1Var;
        synchronized (this) {
            if (!this.F0) {
                throw new IllegalStateException("released");
            }
        }
        if (z && (ue1Var = this.H0) != null) {
            ((r61) ue1Var.A).cancel();
            ((le3) ue1Var.b).h(ue1Var, true, true, true, true, null);
        }
        this.A0 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final kk3 g() {
        ArrayList arrayList = new ArrayList();
        d70.U(this.b.b, arrayList);
        arrayList.add(new cp(this.b));
        arrayList.add(new cp(this.b.j));
        this.b.getClass();
        arrayList.add(new pv(2));
        arrayList.add(pv.z);
        d70.U(this.b.c, arrayList);
        arrayList.add(pv.f);
        cm2 cm2Var = this.f;
        lu2 lu2Var = this.b;
        ve3 ve3Var = new ve3(this, arrayList, 0, null, cm2Var, lu2Var.x, lu2Var.y, lu2Var.z);
        boolean z = false;
        try {
            try {
                kk3 kk3VarB = ve3Var.b(this.f);
                if (this.G0) {
                    hz4.b(kk3VarB);
                    throw new IOException("Canceled");
                }
                i(null);
                return kk3VarB;
            } catch (IOException e) {
                z = true;
                IOException iOExceptionI = i(e);
                iOExceptionI.getClass();
                throw iOExceptionI;
            }
        } catch (Throwable th) {
            if (!z) {
            }
            throw th;
        }
        if (!z) {
            i(null);
        }
        throw th;
    }

    public final IOException h(ue1 ue1Var, boolean z, boolean z2, boolean z3, boolean z4, IOException iOException) {
        boolean z5;
        boolean z6;
        ue1Var.getClass();
        if (ue1Var.equals(this.H0)) {
            synchronized (this) {
                z5 = false;
                if (z) {
                    try {
                        if (!this.B0) {
                            if ((z2 || !this.C0) && ((!z4 || !this.D0) && (!z3 || !this.E0))) {
                            }
                        }
                        if (z) {
                            this.B0 = false;
                        }
                        if (z2) {
                            this.C0 = false;
                        }
                        if (z4) {
                            this.D0 = false;
                        }
                        if (z3) {
                            this.E0 = false;
                        }
                        boolean z7 = (this.B0 || this.C0 || this.D0 || this.E0) ? false : true;
                        if (z7) {
                            if (!this.F0) {
                                z5 = true;
                            }
                        }
                        boolean z8 = z7;
                        z6 = z5;
                        z5 = z8;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    z6 = z2 ? false : false;
                }
            }
            if (z5) {
                this.H0 = null;
                me3 me3Var = this.y0;
                if (me3Var != null) {
                    me3Var.f();
                }
            }
            if (z6) {
                return b(iOException);
            }
        }
        return iOException;
    }

    public final IOException i(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.F0) {
                this.F0 = false;
                if (!this.B0 && !this.C0 && !this.D0) {
                    if (!this.E0) {
                        z = true;
                    }
                }
            }
        }
        return z ? b(iOException) : iOException;
    }

    public final Socket j() {
        me3 me3Var = this.y0;
        me3Var.getClass();
        TimeZone timeZone = jz4.a;
        ArrayList arrayList = me3Var.p;
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (n12.c(((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            xe.q("Check failed.");
            return null;
        }
        arrayList.remove(i);
        this.y0 = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        me3Var.q = System.nanoTime();
        oe3 oe3Var = this.z;
        za4 za4Var = (za4) oe3Var.c;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) oe3Var.e;
        TimeZone timeZone2 = jz4.a;
        if (!me3Var.j) {
            za4Var.d((ne3) oe3Var.d, 0L);
            return null;
        }
        me3Var.j = true;
        concurrentLinkedQueue.remove(me3Var);
        if (concurrentLinkedQueue.isEmpty()) {
            za4Var.a();
        }
        return me3Var.e;
    }
}
