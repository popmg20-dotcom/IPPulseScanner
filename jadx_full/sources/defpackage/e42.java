package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function2;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e42 implements v32 {
    public static final /* synthetic */ long b;
    public static final /* synthetic */ long f;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        Unsafe unsafe = re.a;
        f = unsafe.objectFieldOffset(e42.class.getDeclaredField("_state$volatile"));
        b = unsafe.objectFieldOffset(e42.class.getDeclaredField("_parentHandle$volatile"));
    }

    public e42(boolean z) {
        this._state$volatile = z ? f42.g : f42.f;
    }

    public static h40 V(xd2 xd2Var) {
        while (xd2Var.j()) {
            xd2Var = xd2Var.i();
        }
        while (true) {
            xd2Var = xd2Var.h();
            if (!xd2Var.j()) {
                if (xd2Var instanceof h40) {
                    return (h40) xd2Var;
                }
                if (xd2Var instanceof gs2) {
                    return null;
                }
            }
        }
    }

    public static String f0(Object obj) {
        if (!(obj instanceof c42)) {
            return obj instanceof oz1 ? ((oz1) obj).isActive() ? "Active" : "New" : obj instanceof r80 ? "Cancelled" : "Completed";
        }
        c42 c42Var = (c42) obj;
        return c42Var.d() ? "Cancelling" : c42Var.e() ? "Completing" : "Active";
    }

    public final Object A() throws Throwable {
        Object objH = H();
        if (objH instanceof oz1) {
            xe.q("This job has not completed yet");
            return null;
        }
        if (objH instanceof r80) {
            throw ((r80) objH).a;
        }
        return f42.a(objH);
    }

    public final Throwable B(c42 c42Var, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (c42Var.d()) {
                return new w32(u(), null, this);
            }
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof ee4) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof ee4)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        return r5;
     */
    @Override // defpackage.v32
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final g40 C(e42 e42Var) {
        e42 e42Var2;
        h40 h40Var = new h40(e42Var);
        h40Var.A = this;
        loop0: while (true) {
            Object objH = this.H();
            if (objH instanceof a41) {
                a41 a41Var = (a41) objH;
                if (a41Var.b) {
                    while (true) {
                        Unsafe unsafe = re.a;
                        long j = f;
                        e42Var2 = this;
                        if (unsafe.compareAndSwapObject(e42Var2, j, objH, h40Var)) {
                            break loop0;
                        }
                        if (unsafe.getObjectVolatile(e42Var2, j) != objH) {
                            break;
                        }
                        this = e42Var2;
                    }
                } else {
                    e42Var2 = this;
                    e42Var2.b0(a41Var);
                }
                this = e42Var2;
            } else {
                e42Var2 = this;
                boolean z = objH instanceof oz1;
                js2 js2Var = js2.b;
                if (!z) {
                    Object objH2 = e42Var2.H();
                    r80 r80Var = objH2 instanceof r80 ? (r80) objH2 : null;
                    h40Var.m(r80Var != null ? r80Var.a : null);
                    return js2Var;
                }
                gs2 gs2VarB = ((oz1) objH).b();
                if (gs2VarB == null) {
                    e42Var2.d0((y32) objH);
                    this = e42Var2;
                } else if (!gs2VarB.d(h40Var, 7)) {
                    boolean zD = gs2VarB.d(h40Var, 3);
                    Object objH3 = e42Var2.H();
                    if (objH3 instanceof c42) {
                        thC = ((c42) objH3).c();
                    } else {
                        r80 r80Var2 = objH3 instanceof r80 ? (r80) objH3 : null;
                        if (r80Var2 != null) {
                            thC = r80Var2.a;
                        }
                    }
                    h40Var.m(thC);
                    if (zD) {
                        break loop0;
                    }
                    return js2Var;
                }
            }
        }
    }

    public boolean D() {
        return true;
    }

    public boolean E() {
        return this instanceof o80;
    }

    @Override // defpackage.v32
    public final CancellationException F() {
        CancellationException cancellationException;
        Object objH = H();
        if (objH instanceof c42) {
            Throwable thC = ((c42) objH).c();
            if (thC == null) {
                ad0.o(this, "Job is still new or active: ");
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
            return cancellationException == null ? new w32(strConcat, thC, this) : cancellationException;
        }
        if (objH instanceof oz1) {
            ad0.o(this, "Job is still new or active: ");
            return null;
        }
        if (!(objH instanceof r80)) {
            return new w32(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((r80) objH).a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new w32(u(), th, this) : cancellationException;
    }

    public final gs2 G(oz1 oz1Var) {
        gs2 gs2VarB = oz1Var.b();
        if (gs2VarB != null) {
            return gs2VarB;
        }
        if (oz1Var instanceof a41) {
            return new gs2();
        }
        if (oz1Var instanceof y32) {
            d0((y32) oz1Var);
            return null;
        }
        ad0.o(oz1Var, "State should have list: ");
        return null;
    }

    public final Object H() {
        return re.a.getObjectVolatile(this, f);
    }

    public boolean J(Throwable th) {
        return false;
    }

    public final void L(v32 v32Var) {
        long j = b;
        js2 js2Var = js2.b;
        if (v32Var == null) {
            re.a.putObjectVolatile(this, j, js2Var);
            return;
        }
        v32Var.start();
        g40 g40VarC = v32Var.C(this);
        Unsafe unsafe = re.a;
        unsafe.putObjectVolatile(this, j, g40VarC);
        if (P()) {
            g40VarC.c();
            unsafe.putObjectVolatile(this, j, js2Var);
        }
    }

    @Override // defpackage.v32
    public final zv0 M(am1 am1Var) {
        return O(true, new a22(am1Var));
    }

    @Override // defpackage.cf0
    public final cf0 N(bf0 bf0Var) {
        return tj4.P(this, bf0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zv0 O(boolean z, y32 y32Var) {
        e42 e42Var;
        y32 y32Var2;
        boolean zD;
        y32Var.A = this;
        loop0: while (true) {
            Object objH = this.H();
            if (objH instanceof a41) {
                a41 a41Var = (a41) objH;
                if (a41Var.b) {
                    while (true) {
                        Unsafe unsafe = re.a;
                        long j = f;
                        e42Var = this;
                        y32Var2 = y32Var;
                        if (unsafe.compareAndSwapObject(e42Var, j, objH, y32Var2)) {
                            break loop0;
                        }
                        if (unsafe.getObjectVolatile(e42Var, j) != objH) {
                            break;
                        }
                        this = e42Var;
                        y32Var = y32Var2;
                    }
                } else {
                    e42Var = this;
                    y32Var2 = y32Var;
                    e42Var.b0(a41Var);
                }
                this = e42Var;
                y32Var = y32Var2;
            } else {
                e42Var = this;
                y32Var2 = y32Var;
                boolean z2 = objH instanceof oz1;
                js2 js2Var = js2.b;
                if (z2) {
                    oz1 oz1Var = (oz1) objH;
                    gs2 gs2VarB = oz1Var.b();
                    if (gs2VarB == null) {
                        e42Var.d0((y32) objH);
                    } else {
                        if (y32Var2.l()) {
                            c42 c42Var = oz1Var instanceof c42 ? (c42) oz1Var : null;
                            Throwable thC = c42Var != null ? c42Var.c() : null;
                            if (thC == null) {
                                zD = gs2VarB.d(y32Var2, 5);
                            } else if (z) {
                                y32Var2.m(thC);
                                return js2Var;
                            }
                        } else {
                            zD = gs2VarB.d(y32Var2, 1);
                        }
                        if (zD) {
                            break;
                        }
                    }
                    this = e42Var;
                    y32Var = y32Var2;
                } else if (z) {
                    Object objH2 = e42Var.H();
                    r80 r80Var = objH2 instanceof r80 ? (r80) objH2 : null;
                    y32Var2.m(r80Var != null ? r80Var.a : null);
                }
            }
        }
        return y32Var2;
    }

    public final boolean P() {
        return !(H() instanceof oz1);
    }

    public boolean R() {
        return this instanceof vn;
    }

    public final boolean S(Object obj) {
        Object objG0;
        do {
            objG0 = g0(H(), obj);
            if (objG0 == f42.a) {
                return false;
            }
            if (objG0 == f42.b) {
                return true;
            }
        } while (objG0 == f42.c);
        o(objG0);
        return true;
    }

    public final Object T(Object obj) {
        Object objG0;
        do {
            objG0 = g0(H(), obj);
            if (objG0 == f42.a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                r80 r80Var = obj instanceof r80 ? (r80) obj : null;
                throw new IllegalStateException(str, r80Var != null ? r80Var.a : null);
            }
        } while (objG0 == f42.c);
        return objG0;
    }

    public String U() {
        return getClass().getSimpleName();
    }

    public final void W(gs2 gs2Var, Throwable th) {
        gs2Var.d(new vb2(4), 4);
        Object objG = gs2Var.g();
        objG.getClass();
        t80 t80Var = null;
        for (xd2 xd2VarH = (xd2) objG; !xd2VarH.equals(gs2Var); xd2VarH = xd2VarH.h()) {
            if ((xd2VarH instanceof y32) && ((y32) xd2VarH).l()) {
                try {
                    ((y32) xd2VarH).m(th);
                } catch (Throwable th2) {
                    if (t80Var != null) {
                        ek0.b(t80Var, th2);
                    } else {
                        t80Var = new t80("Exception in completion handler " + xd2VarH + " for " + this, th2);
                    }
                }
            }
        }
        if (t80Var != null) {
            K(t80Var);
        }
        t(th);
    }

    @Override // defpackage.cf0
    public final cf0 X(cf0 cf0Var) {
        return tj4.W(this, cf0Var);
    }

    @Override // defpackage.cf0
    public final af0 Z(bf0 bf0Var) {
        return tj4.A(this, bf0Var);
    }

    public final void b0(a41 a41Var) {
        gs2 gs2Var = new gs2();
        Object mz1Var = a41Var.b ? gs2Var : new mz1(gs2Var);
        while (true) {
            Unsafe unsafe = re.a;
            long j = f;
            e42 e42Var = this;
            a41 a41Var2 = a41Var;
            if (unsafe.compareAndSwapObject(e42Var, j, a41Var2, mz1Var) || unsafe.getObjectVolatile(e42Var, j) != a41Var2) {
                return;
            }
            this = e42Var;
            a41Var = a41Var2;
        }
    }

    @Override // defpackage.cf0
    public final Object c0(Object obj, Function2 function2) {
        return function2.k(obj, this);
    }

    public final void d0(y32 y32Var) {
        y32 y32Var2;
        e42 e42Var;
        gs2 gs2Var = new gs2();
        Unsafe unsafe = re.a;
        unsafe.putObjectVolatile(gs2Var, xd2.f, y32Var);
        long j = xd2.b;
        unsafe.putObjectVolatile(gs2Var, j, y32Var);
        loop0: while (true) {
            if (y32Var.g() != y32Var) {
                y32Var2 = y32Var;
                break;
            }
            while (true) {
                Unsafe unsafe2 = re.a;
                y32Var2 = y32Var;
                if (unsafe2.compareAndSwapObject(y32Var2, xd2.b, y32Var, gs2Var)) {
                    gs2Var.f(y32Var2);
                    break loop0;
                }
                e42Var = this;
                y32Var = y32Var2;
                if (unsafe2.getObjectVolatile(y32Var2, j) != y32Var2) {
                    break;
                } else {
                    this = e42Var;
                }
            }
            this = e42Var;
        }
        xd2 xd2VarH = y32Var2.h();
        while (true) {
            Unsafe unsafe3 = re.a;
            long j2 = f;
            e42 e42Var2 = this;
            if (unsafe3.compareAndSwapObject(e42Var2, j2, y32Var2, xd2VarH) || unsafe3.getObjectVolatile(e42Var2, j2) != y32Var2) {
                return;
            } else {
                this = e42Var2;
            }
        }
    }

    public final int e0(Object obj) {
        Unsafe unsafe;
        boolean z = obj instanceof a41;
        long j = f;
        if (!z) {
            e42 e42Var = this;
            Object obj2 = obj;
            if (!(obj2 instanceof mz1)) {
                return 0;
            }
            gs2 gs2Var = ((mz1) obj2).b;
            do {
                e42 e42Var2 = e42Var;
                unsafe = re.a;
                Object obj3 = obj2;
                boolean zCompareAndSwapObject = unsafe.compareAndSwapObject(e42Var2, f, obj3, gs2Var);
                e42Var = e42Var2;
                obj2 = obj3;
                if (zCompareAndSwapObject) {
                    e42Var.a0();
                    return 1;
                }
            } while (unsafe.getObjectVolatile(e42Var, j) == obj2);
            return -1;
        }
        if (((a41) obj).b) {
            return 0;
        }
        while (true) {
            Unsafe unsafe2 = re.a;
            e42 e42Var3 = this;
            Object obj4 = obj;
            if (unsafe2.compareAndSwapObject(e42Var3, f, obj4, f42.g)) {
                e42Var3.a0();
                return 1;
            }
            if (unsafe2.getObjectVolatile(e42Var3, j) != obj4) {
                return -1;
            }
            this = e42Var3;
            obj = obj4;
        }
    }

    @Override // defpackage.v32
    public void g(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new w32(u(), null, this);
        }
        r(cancellationException);
    }

    public final Object g0(Object obj, Object obj2) {
        Unsafe unsafe;
        long j;
        if (!(obj instanceof oz1)) {
            return f42.a;
        }
        if ((!(obj instanceof a41) && !(obj instanceof y32)) || (obj instanceof h40) || (obj2 instanceof r80)) {
            e42 e42Var = this;
            oz1 oz1Var = (oz1) obj;
            gs2 gs2VarG = e42Var.G(oz1Var);
            if (gs2VarG == null) {
                return f42.c;
            }
            c42 c42Var = oz1Var instanceof c42 ? (c42) oz1Var : null;
            if (c42Var == null) {
                c42Var = new c42(gs2VarG, null);
            }
            c42 c42Var2 = c42Var;
            synchronized (c42Var2) {
                if (c42Var2.e()) {
                    return f42.a;
                }
                re.a.putIntVolatile(c42Var2, c42.z, 1);
                if (c42Var2 != oz1Var) {
                    do {
                        unsafe = re.a;
                        j = f;
                        e42 e42Var2 = e42Var;
                        e42Var = e42Var2;
                        if (unsafe.compareAndSwapObject(e42Var2, j, oz1Var, c42Var2)) {
                        }
                    } while (unsafe.getObjectVolatile(e42Var, j) == oz1Var);
                    return f42.c;
                }
                boolean zD = c42Var2.d();
                r80 r80Var = obj2 instanceof r80 ? (r80) obj2 : null;
                if (r80Var != null) {
                    c42Var2.a(r80Var.a);
                }
                Throwable thC = zD ? null : c42Var2.c();
                if (thC != null) {
                    e42Var.W(gs2VarG, thC);
                }
                h40 h40VarV = V(gs2VarG);
                if (h40VarV != null && e42Var.h0(c42Var2, h40VarV, obj2)) {
                    return f42.b;
                }
                gs2VarG.d(new vb2(2), 2);
                h40 h40VarV2 = V(gs2VarG);
                return (h40VarV2 == null || !e42Var.h0(c42Var2, h40VarV2, obj2)) ? e42Var.z(c42Var2, obj2) : f42.b;
            }
        }
        oz1 oz1Var2 = (oz1) obj;
        Object pz1Var = obj2 instanceof oz1 ? new pz1((oz1) obj2) : obj2;
        while (true) {
            Unsafe unsafe2 = re.a;
            long j2 = f;
            e42 e42Var3 = this;
            if (unsafe2.compareAndSwapObject(e42Var3, j2, oz1Var2, pz1Var)) {
                e42Var3.Y(obj2);
                e42Var3.w(oz1Var2, obj2);
                return obj2;
            }
            if (unsafe2.getObjectVolatile(e42Var3, j2) != oz1Var2) {
                return f42.c;
            }
            this = e42Var3;
        }
    }

    @Override // defpackage.af0
    public final bf0 getKey() {
        return pr1.X;
    }

    public final boolean h0(c42 c42Var, h40 h40Var, Object obj) {
        while (je.K(h40Var.X, false, new b42(this, c42Var, h40Var, obj)) == js2.b) {
            h40Var = V(h40Var);
            if (h40Var == null) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.v32
    public final Object i0(ie0 ie0Var) {
        Object objH;
        xl4 xl4Var;
        do {
            objH = H();
            boolean z = objH instanceof oz1;
            xl4Var = xl4.a;
            if (!z) {
                je.A(ie0Var.j());
                return xl4Var;
            }
        } while (e0(objH) < 0);
        z00 z00Var = new z00(1, p95.u(ie0Var));
        z00Var.w();
        z00Var.z(new s00(2, je.K(this, true, new zk3(z00Var))));
        Object objU = z00Var.u();
        mf0 mf0Var = mf0.b;
        if (objU != mf0Var) {
            objU = xl4Var;
        }
        return objU == mf0Var ? objU : xl4Var;
    }

    @Override // defpackage.v32
    public boolean isActive() {
        Object objH = H();
        return (objH instanceof oz1) && ((oz1) objH).isActive();
    }

    @Override // defpackage.v32
    public final boolean isCancelled() {
        Object objH = H();
        if (objH instanceof r80) {
            return true;
        }
        return (objH instanceof c42) && ((c42) objH).d();
    }

    public Object n() {
        return A();
    }

    public void p(Object obj) {
        o(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00be, code lost:
    
        r0 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[PHI: r0
      0x003a: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v10 java.lang.Object) binds: [B:3:0x0008, B:16:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(Object obj) {
        e42 e42Var;
        br1 br1Var;
        Object objG0;
        Object objG02 = f42.a;
        if (E()) {
            do {
                Object objH = H();
                if (!(objH instanceof oz1) || ((objH instanceof c42) && ((c42) objH).e())) {
                    objG02 = f42.a;
                    break;
                }
                objG02 = g0(objH, new r80(y(obj), false));
            } while (objG02 == f42.c);
            if (objG02 != f42.b) {
                if (objG02 == f42.a) {
                    Throwable thY = null;
                    loop1: while (true) {
                        Object objH2 = this.H();
                        if (!(objH2 instanceof c42)) {
                            if (!(objH2 instanceof oz1)) {
                                e42Var = this;
                                objG0 = f42.d;
                                break;
                            }
                            if (thY == null) {
                                thY = this.y(obj);
                            }
                            oz1 oz1Var = (oz1) objH2;
                            if (oz1Var.isActive()) {
                                gs2 gs2VarG = this.G(oz1Var);
                                if (gs2VarG == null) {
                                    e42Var = this;
                                } else {
                                    c42 c42Var = new c42(gs2VarG, thY);
                                    while (true) {
                                        Unsafe unsafe = re.a;
                                        long j = f;
                                        e42Var = this;
                                        if (unsafe.compareAndSwapObject(e42Var, j, oz1Var, c42Var)) {
                                            e42Var.W(gs2VarG, thY);
                                            objG0 = f42.a;
                                            break loop1;
                                        }
                                        if (unsafe.getObjectVolatile(e42Var, j) != oz1Var) {
                                            break;
                                        }
                                        this = e42Var;
                                    }
                                }
                                this = e42Var;
                            } else {
                                e42Var = this;
                                objG0 = e42Var.g0(objH2, new r80(thY, false));
                                if (objG0 == f42.a) {
                                    ad0.o(objH2, "Cannot happen in ");
                                    return false;
                                }
                                if (objG0 != f42.c) {
                                    break;
                                }
                                this = e42Var;
                            }
                        } else {
                            synchronized (objH2) {
                                if (re.a.getObjectVolatile((c42) objH2, c42.f) == f42.e) {
                                    br1Var = f42.d;
                                } else {
                                    boolean zD = ((c42) objH2).d();
                                    if (thY == null) {
                                        thY = this.y(obj);
                                    }
                                    ((c42) objH2).a(thY);
                                    Throwable thC = zD ? null : ((c42) objH2).c();
                                    if (thC != null) {
                                        this.W(((c42) objH2).b, thC);
                                    }
                                    br1Var = f42.a;
                                }
                            }
                            e42Var = this;
                            objG02 = br1Var;
                        }
                    }
                } else {
                    e42Var = this;
                }
                if (objG02 != f42.a && objG02 != f42.b) {
                    if (objG02 == f42.d) {
                        return false;
                    }
                    e42Var.o(objG02);
                    return true;
                }
            }
        }
        return true;
    }

    public void r(CancellationException cancellationException) {
        q(cancellationException);
    }

    @Override // defpackage.v32
    public final ss3 s() {
        return new j70(2, new d42(this, null));
    }

    @Override // defpackage.v32
    public final boolean start() {
        int iE0;
        do {
            iE0 = e0(H());
            if (iE0 == 0) {
                return false;
            }
        } while (iE0 != 1);
        return true;
    }

    public final boolean t(Throwable th) {
        if (R()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        g40 g40Var = (g40) re.a.getObjectVolatile(this, b);
        return (g40Var == null || g40Var == js2.b) ? z : g40Var.a(th) || z;
    }

    public final String toString() {
        return (U() + '{' + f0(H()) + '}') + '@' + ek0.l(this);
    }

    public String u() {
        return "Job was cancelled";
    }

    public boolean v(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return q(th) && D();
    }

    public final void w(oz1 oz1Var, Object obj) {
        Unsafe unsafe = re.a;
        long j = b;
        g40 g40Var = (g40) unsafe.getObjectVolatile(this, j);
        if (g40Var != null) {
            g40Var.c();
            unsafe.putObjectVolatile(this, j, js2.b);
        }
        t80 t80Var = null;
        r80 r80Var = obj instanceof r80 ? (r80) obj : null;
        Throwable th = r80Var != null ? r80Var.a : null;
        if (oz1Var instanceof y32) {
            try {
                ((y32) oz1Var).m(th);
                return;
            } catch (Throwable th2) {
                K(new t80("Exception in completion handler " + oz1Var + " for " + this, th2));
                return;
            }
        }
        gs2 gs2VarB = oz1Var.b();
        if (gs2VarB != null) {
            gs2VarB.d(new vb2(1), 1);
            Object objG = gs2VarB.g();
            objG.getClass();
            for (xd2 xd2VarH = (xd2) objG; !xd2VarH.equals(gs2VarB); xd2VarH = xd2VarH.h()) {
                if (xd2VarH instanceof y32) {
                    try {
                        ((y32) xd2VarH).m(th);
                    } catch (Throwable th3) {
                        if (t80Var != null) {
                            ek0.b(t80Var, th3);
                        } else {
                            t80Var = new t80("Exception in completion handler " + xd2VarH + " for " + this, th3);
                        }
                    }
                }
            }
            if (t80Var != null) {
                K(t80Var);
            }
        }
    }

    @Override // defpackage.v32
    public final zv0 x(boolean z, boolean z2, x12 x12Var) {
        return O(z2, z ? new z12(x12Var) : new a22(x12Var));
    }

    public final Throwable y(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        e42 e42Var = (e42) obj;
        Object objH = e42Var.H();
        if (objH instanceof c42) {
            thC = ((c42) objH).c();
        } else if (objH instanceof r80) {
            thC = ((r80) objH).a;
        } else {
            if (objH instanceof oz1) {
                ad0.o(objH, "Cannot be cancelling child in this state: ");
                return null;
            }
            thC = null;
        }
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        return cancellationException == null ? new w32("Parent job is ".concat(f0(objH)), thC, e42Var) : cancellationException;
    }

    public final Object z(c42 c42Var, Object obj) throws Throwable {
        c42 c42Var2;
        Throwable th;
        Throwable thB;
        e42 e42Var;
        c42 c42Var3;
        r80 r80Var = obj instanceof r80 ? (r80) obj : null;
        Throwable th2 = r80Var != null ? r80Var.a : null;
        synchronized (c42Var) {
            try {
                c42Var.d();
                ArrayList<Throwable> arrayListF = c42Var.f(th2);
                thB = B(c42Var, arrayListF);
                if (thB != null) {
                    try {
                        if (arrayListF.size() > 1) {
                            Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                            for (Throwable th3 : arrayListF) {
                                if (th3 != thB && th3 != thB && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                                    ek0.b(thB, th3);
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        c42Var2 = c42Var;
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                c42Var2 = c42Var;
                th = th5;
            }
        }
        if (thB != null && thB != th2) {
            obj = new r80(thB, false);
        }
        if (thB != null && (t(thB) || J(thB))) {
            obj.getClass();
            re.a.compareAndSwapInt((r80) obj, r80.b, 0, 1);
        }
        Y(obj);
        Object pz1Var = obj instanceof oz1 ? new pz1((oz1) obj) : obj;
        while (true) {
            Unsafe unsafe = re.a;
            long j = f;
            e42Var = this;
            c42Var3 = c42Var;
            if (unsafe.compareAndSwapObject(e42Var, j, c42Var3, pz1Var) || unsafe.getObjectVolatile(e42Var, j) != c42Var3) {
                break;
            }
            this = e42Var;
            c42Var = c42Var3;
        }
        e42Var.w(c42Var3, obj);
        return obj;
    }

    public void a0() {
    }

    public void K(t80 t80Var) {
        throw t80Var;
    }

    public void Y(Object obj) {
    }

    public void o(Object obj) {
    }
}
