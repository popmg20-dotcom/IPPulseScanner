package defpackage;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.concurrent.CancellationException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class z00 extends ov0 implements y00, nf0, xs4 {
    public static final /* synthetic */ long Y;
    public static final /* synthetic */ long Z;
    public static final /* synthetic */ long y0;
    public final ge0 A;
    public final cf0 X;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        Unsafe unsafe = re.a;
        Y = unsafe.objectFieldOffset(z00.class.getDeclaredField("_decisionAndIndex$volatile"));
        y0 = unsafe.objectFieldOffset(z00.class.getDeclaredField("_state$volatile"));
        Z = unsafe.objectFieldOffset(z00.class.getDeclaredField("_parentHandle$volatile"));
    }

    public z00(int i, ge0 ge0Var) {
        super(i);
        this.A = ge0Var;
        this.X = ge0Var.j();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = v3.b;
    }

    public static void B(ps2 ps2Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + ps2Var + ", already has " + obj).toString());
    }

    public static Object G(ps2 ps2Var, Object obj, int i, em1 em1Var) {
        if (obj instanceof r80) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (em1Var != null || (ps2Var instanceof t00)) {
            return new p80(obj, ps2Var instanceof t00 ? (t00) ps2Var : null, em1Var, (Throwable) null, 16);
        }
        return obj;
    }

    public final boolean A() {
        if (this.z == 2) {
            return re.a.getObjectVolatile((lv0) this.A, lv0.y0) != null;
        }
        return false;
    }

    public String C() {
        return "CancellableContinuation";
    }

    public final void D() {
        z00 z00Var;
        Unsafe unsafe;
        ge0 ge0Var = this.A;
        Throwable th = null;
        lv0 lv0Var = ge0Var instanceof lv0 ? (lv0) ge0Var : null;
        if (lv0Var != null) {
            long j = lv0.y0;
            loop0: while (true) {
                Object objectVolatile = re.a.getObjectVolatile(lv0Var, j);
                br1 br1Var = mv0.b;
                if (objectVolatile != br1Var) {
                    z00Var = this;
                    if (!(objectVolatile instanceof Throwable)) {
                        ad0.o(objectVolatile, "Inconsistent state ");
                        return;
                    }
                    do {
                        unsafe = re.a;
                        if (unsafe.compareAndSwapObject(lv0Var, lv0.y0, objectVolatile, (Object) null)) {
                            th = (Throwable) objectVolatile;
                        }
                    } while (unsafe.getObjectVolatile(lv0Var, j) == objectVolatile);
                    xe.k("Failed requirement.");
                    return;
                }
                while (true) {
                    Unsafe unsafe2 = re.a;
                    z00 z00Var2 = this;
                    z00Var = z00Var2;
                    if (unsafe2.compareAndSwapObject(lv0Var, lv0.y0, br1Var, z00Var2)) {
                        break loop0;
                    } else if (unsafe2.getObjectVolatile(lv0Var, j) != br1Var) {
                        break;
                    } else {
                        this = z00Var;
                    }
                }
                this = z00Var;
            }
            if (th == null) {
                return;
            }
            z00Var.r();
            z00Var.q(th);
        }
    }

    public final void E(Object obj, int i, em1 em1Var) {
        z00 z00Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = y0;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (!(objectVolatile instanceof ps2)) {
                z00 z00Var2 = this;
                if (objectVolatile instanceof c10) {
                    c10 c10Var = (c10) objectVolatile;
                    if (unsafe.compareAndSwapInt(c10Var, c10.c, 0, 1)) {
                        if (em1Var != null) {
                            z00Var2.o(em1Var, c10Var.a, obj);
                            return;
                        }
                        return;
                    }
                }
                ad0.o(obj, "Already resumed, but proposed with update ");
                return;
            }
            Object objG = G((ps2) objectVolatile, obj, i, em1Var);
            while (true) {
                Unsafe unsafe2 = re.a;
                z00Var = this;
                if (unsafe2.compareAndSwapObject(z00Var, y0, objectVolatile, objG)) {
                    if (!z00Var.A()) {
                        z00Var.r();
                    }
                    z00Var.s(i);
                    return;
                } else if (unsafe2.getObjectVolatile(z00Var, j) != objectVolatile) {
                    break;
                } else {
                    this = z00Var;
                }
            }
            this = z00Var;
        }
    }

    public final void F(ef0 ef0Var) {
        ge0 ge0Var = this.A;
        lv0 lv0Var = ge0Var instanceof lv0 ? (lv0) ge0Var : null;
        E(xl4.a, (lv0Var != null ? lv0Var.A : null) == ef0Var ? 4 : this.z, null);
    }

    public final br1 H(Object obj, em1 em1Var) {
        z00 z00Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = y0;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (!(objectVolatile instanceof ps2)) {
                return null;
            }
            Object objG = G((ps2) objectVolatile, obj, this.z, em1Var);
            while (true) {
                Unsafe unsafe2 = re.a;
                z00Var = this;
                if (unsafe2.compareAndSwapObject(z00Var, y0, objectVolatile, objG)) {
                    boolean zA = z00Var.A();
                    br1 br1Var = a10.a;
                    if (!zA) {
                        z00Var.r();
                    }
                    return br1Var;
                }
                if (unsafe2.getObjectVolatile(z00Var, j) != objectVolatile) {
                    break;
                }
                this = z00Var;
            }
            this = z00Var;
        }
    }

    @Override // defpackage.xs4
    public final void a(sr3 sr3Var, int i) {
        while (true) {
            Unsafe unsafe = re.a;
            long j = Y;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if ((intVolatile & 536870911) != 536870911) {
                xe.q("invokeOnCancellation should be called at most once");
                return;
            }
            z00 z00Var = this;
            if (unsafe.compareAndSwapInt(z00Var, j, intVolatile, ((intVolatile >> 29) << 29) + i)) {
                z00Var.z(sr3Var);
                return;
            }
            this = z00Var;
        }
    }

    @Override // defpackage.ov0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        z00 z00Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = y0;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (objectVolatile instanceof ps2) {
                xe.q("Not completed");
                return;
            }
            if (objectVolatile instanceof r80) {
                return;
            }
            if (objectVolatile instanceof p80) {
                p80 p80Var = (p80) objectVolatile;
                if (p80Var.e != null) {
                    xe.q("Must be called at most once");
                    return;
                }
                p80 p80VarA = p80.a(p80Var, null, cancellationException, 15);
                while (true) {
                    Unsafe unsafe2 = re.a;
                    z00 z00Var2 = this;
                    if (unsafe2.compareAndSwapObject(z00Var2, y0, objectVolatile, p80VarA)) {
                        t00 t00Var = p80Var.b;
                        if (t00Var != null) {
                            z00Var2.n(t00Var, cancellationException);
                        }
                        em1 em1Var = p80Var.c;
                        if (em1Var != null) {
                            z00Var2.o(em1Var, cancellationException, p80Var.a);
                            return;
                        }
                        return;
                    }
                    if (unsafe2.getObjectVolatile(z00Var2, j) != objectVolatile) {
                        cancellationException2 = cancellationException;
                        z00Var = z00Var2;
                        break;
                    }
                    this = z00Var2;
                }
            } else {
                z00 z00Var3 = this;
                CancellationException cancellationException3 = cancellationException;
                p80 p80Var2 = new p80(objectVolatile, (t00) null, (em1) null, cancellationException3, 14);
                cancellationException2 = cancellationException3;
                while (true) {
                    p80 p80Var3 = p80Var2;
                    Unsafe unsafe3 = re.a;
                    z00Var = z00Var3;
                    boolean zCompareAndSwapObject = unsafe3.compareAndSwapObject(z00Var, y0, objectVolatile, p80Var3);
                    p80Var2 = p80Var3;
                    if (zCompareAndSwapObject) {
                        return;
                    }
                    if (unsafe3.getObjectVolatile(z00Var, j) != objectVolatile) {
                        break;
                    } else {
                        z00Var3 = z00Var;
                    }
                }
            }
            cancellationException = cancellationException2;
            this = z00Var;
        }
    }

    @Override // defpackage.nf0
    public final nf0 c() {
        ge0 ge0Var = this.A;
        if (ge0Var instanceof nf0) {
            return (nf0) ge0Var;
        }
        return null;
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        Throwable thA = uk3.a(obj);
        if (thA != null) {
            obj = new r80(thA, false);
        }
        E(obj, this.z, null);
    }

    @Override // defpackage.ov0
    public final ge0 e() {
        return this.A;
    }

    @Override // defpackage.y00
    public final br1 f(Object obj, em1 em1Var) {
        return H(obj, em1Var);
    }

    @Override // defpackage.ov0
    public final Throwable g(Object obj) {
        Throwable thG = super.g(obj);
        if (thG != null) {
            return thG;
        }
        return null;
    }

    @Override // defpackage.ov0
    public final Object h(Object obj) {
        return obj instanceof p80 ? ((p80) obj).a : obj;
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return this.X;
    }

    @Override // defpackage.ov0
    public final Object k() {
        return v();
    }

    @Override // defpackage.y00
    public final void l(Object obj, em1 em1Var) {
        E(obj, this.z, em1Var);
    }

    @Override // defpackage.y00
    public final void m(Object obj) {
        s(this.z);
    }

    public final void n(t00 t00Var, Throwable th) {
        try {
            t00Var.b(th);
        } catch (Throwable th2) {
            r25.E(this.X, new t80("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(em1 em1Var, Throwable th, Object obj) {
        cf0 cf0Var = this.X;
        try {
            em1Var.e(th, obj, cf0Var);
        } catch (Throwable th2) {
            r25.E(cf0Var, new t80("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void p(sr3 sr3Var, Throwable th) {
        cf0 cf0Var = this.X;
        int intVolatile = re.a.getIntVolatile(this, Y) & 536870911;
        if (intVolatile == 536870911) {
            xe.q("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            sr3Var.h(intVolatile, cf0Var);
        } catch (Throwable th2) {
            r25.E(cf0Var, new t80("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final boolean q(Throwable th) {
        Throwable cancellationException;
        z00 z00Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = y0;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (!(objectVolatile instanceof ps2)) {
                return false;
            }
            boolean z = (objectVolatile instanceof t00) || (objectVolatile instanceof sr3);
            if (th == null) {
                cancellationException = new CancellationException("Continuation " + this + " was cancelled normally");
            } else {
                cancellationException = th;
            }
            c10 c10Var = new c10(cancellationException, z);
            while (true) {
                Unsafe unsafe2 = re.a;
                z00Var = this;
                if (unsafe2.compareAndSwapObject(z00Var, y0, objectVolatile, c10Var)) {
                    ps2 ps2Var = (ps2) objectVolatile;
                    if (ps2Var instanceof t00) {
                        z00Var.n((t00) objectVolatile, th);
                    } else if (ps2Var instanceof sr3) {
                        z00Var.p((sr3) objectVolatile, th);
                    }
                    if (!z00Var.A()) {
                        z00Var.r();
                    }
                    z00Var.s(z00Var.z);
                    return true;
                }
                if (unsafe2.getObjectVolatile(z00Var, j) != objectVolatile) {
                    break;
                }
                this = z00Var;
            }
            this = z00Var;
        }
    }

    public final void r() {
        Unsafe unsafe = re.a;
        long j = Z;
        zv0 zv0Var = (zv0) unsafe.getObjectVolatile(this, j);
        if (zv0Var == null) {
            return;
        }
        zv0Var.c();
        unsafe.putObjectVolatile(this, j, js2.b);
    }

    public final void s(int i) {
        while (true) {
            Unsafe unsafe = re.a;
            long j = Y;
            int intVolatile = unsafe.getIntVolatile(this, j);
            int i2 = intVolatile >> 29;
            if (i2 != 0) {
                if (i2 != 1) {
                    xe.q("Already resumed");
                    return;
                }
                boolean z = i == 4;
                ge0 ge0Var = this.A;
                if (!z && (ge0Var instanceof lv0)) {
                    boolean z2 = i == 1 || i == 2;
                    int i3 = this.z;
                    if (z2 == (i3 == 1 || i3 == 2)) {
                        lv0 lv0Var = (lv0) ge0Var;
                        ef0 ef0Var = lv0Var.A;
                        cf0 cf0VarJ = lv0Var.X.j();
                        if (mv0.c(ef0Var, cf0VarJ)) {
                            mv0.b(ef0Var, cf0VarJ, this);
                            return;
                        }
                        b61 b61VarA = qd4.a();
                        if (b61VarA.z >= 4294967296L) {
                            b61VarA.z0(this);
                            return;
                        }
                        b61VarA.F0(true);
                        try {
                            xb5.K(this, ge0Var, true);
                            do {
                            } while (b61VarA.H0());
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        return;
                    }
                }
                xb5.K(this, ge0Var, z);
                return;
            }
            z00 z00Var = this;
            if (unsafe.compareAndSwapInt(z00Var, j, intVolatile, Pow2.MAX_POW2 + (536870911 & intVolatile))) {
                return;
            } else {
                this = z00Var;
            }
        }
    }

    public Throwable t(e42 e42Var) {
        return e42Var.F();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C());
        sb.append('(');
        sb.append(ek0.H(this.A));
        sb.append("){");
        Object objV = v();
        sb.append(objV instanceof ps2 ? "Active" : objV instanceof c10 ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(ek0.l(this));
        return sb.toString();
    }

    public final Object u() {
        v32 v32Var;
        boolean zA = A();
        while (true) {
            Unsafe unsafe = re.a;
            long j = Y;
            int intVolatile = unsafe.getIntVolatile(this, j);
            int i = intVolatile >> 29;
            if (i != 0) {
                if (i != 2) {
                    xe.q("Already suspended");
                    return null;
                }
                if (zA) {
                    this.D();
                }
                Object objV = this.v();
                if (objV instanceof r80) {
                    throw ((r80) objV).a;
                }
                int i2 = this.z;
                if ((i2 != 1 && i2 != 2) || (v32Var = (v32) this.X.Z(pr1.X)) == null || v32Var.isActive()) {
                    return this.h(objV);
                }
                CancellationException cancellationExceptionF = v32Var.F();
                this.b(cancellationExceptionF);
                throw cancellationExceptionF;
            }
            z00 z00Var = this;
            if (unsafe.compareAndSwapInt(z00Var, j, intVolatile, 536870912 + (536870911 & intVolatile))) {
                if (((zv0) unsafe.getObjectVolatile(z00Var, Z)) == null) {
                    z00Var.x();
                }
                if (zA) {
                    z00Var.D();
                }
                return mf0.b;
            }
            this = z00Var;
        }
    }

    public final Object v() {
        return re.a.getObjectVolatile(this, y0);
    }

    public final void w() {
        zv0 zv0VarX = x();
        if (zv0VarX == null || (v() instanceof ps2)) {
            return;
        }
        zv0VarX.c();
        re.a.putObjectVolatile(this, Z, js2.b);
    }

    public final zv0 x() {
        v32 v32Var = (v32) this.X.Z(pr1.X);
        if (v32Var == null) {
            return null;
        }
        zv0 zv0VarK = je.K(v32Var, true, new f40(this));
        while (true) {
            Unsafe unsafe = re.a;
            long j = Z;
            z00 z00Var = this;
            if (unsafe.compareAndSwapObject(z00Var, j, (Object) null, zv0VarK) || unsafe.getObjectVolatile(z00Var, j) != null) {
                break;
            }
            this = z00Var;
        }
        return zv0VarK;
    }

    public final void y(am1 am1Var) {
        z(new s00(1, am1Var));
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c6, code lost:
    
        B(r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c9, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(defpackage.ps2 r11) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z00.z(ps2):void");
    }
}
