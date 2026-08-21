package defpackage;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ql3 extends yc2 {
    public final pl3 l;
    public final eg0 m;
    public final ul3 n;
    public final AtomicBoolean o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public final cf0 r;
    public final am1 s;

    public ql3(pl3 pl3Var, eg0 eg0Var, String[] strArr, am1 am1Var) {
        cf0 cf0Var;
        eg0Var.getClass();
        this.l = pl3Var;
        this.m = eg0Var;
        this.n = new ul3(strArr, this);
        this.o = new AtomicBoolean(true);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        if (pl3Var.k()) {
            ce0 ce0Var = pl3Var.a;
            if (ce0Var == null) {
                n12.T("coroutineScope");
                throw null;
            }
            cf0Var = ce0Var.b;
        } else {
            cf0Var = c41.b;
        }
        this.r = cf0Var;
        this.s = am1Var;
    }

    @Override // defpackage.yc2
    public final void g() {
        eg0 eg0Var = this.m;
        eg0Var.getClass();
        ((Set) eg0Var.z).add(this);
        ji0.B(this.l.f(), this.r, null, new tl3(this, null, 1), 2);
    }

    @Override // defpackage.yc2
    public final void h() {
        eg0 eg0Var = this.m;
        eg0Var.getClass();
        ((Set) eg0Var.z).remove(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6 A[Catch: all -> 0x002c, Exception -> 0x002f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x0027, B:44:0x00b6), top: B:64:0x0027, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d5 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #2 {all -> 0x002c, blocks: (B:12:0x0027, B:42:0x00ae, B:44:0x00b6, B:52:0x00d5, B:49:0x00cb, B:50:0x00d2), top: B:64:0x0027, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ac -> B:42:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00e4 -> B:57:0x00e5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(ie0 ie0Var) {
        vl3 vl3Var;
        ql3 ql3Var;
        if (ie0Var instanceof vl3) {
            vl3Var = (vl3) ie0Var;
            int i = vl3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                vl3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                vl3Var = new vl3(this, ie0Var);
            }
        }
        Object objS = vl3Var.Y;
        int i2 = vl3Var.y0;
        ge0 ge0Var = null;
        boolean z = false;
        Object[] objArr = 0;
        if (i2 != 0) {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i3 = vl3Var.X;
            ql3Var = vl3Var.A;
            try {
                try {
                    n12.S(objS);
                    while (ql3Var.o.compareAndSet(true, false)) {
                        vl3Var.A = ql3Var;
                        vl3Var.X = 1;
                        vl3Var.y0 = 1;
                        objS = ke0.s(vl3Var, ql3Var.s, ql3Var.l, true);
                        mf0 mf0Var = mf0.b;
                        if (objS == mf0Var) {
                            return mf0Var;
                        }
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        ql3Var.i(objS);
                    }
                    if (i3 != 0 || !ql3Var.o.get()) {
                        return xl4.a;
                    }
                    this = ql3Var;
                    ql3Var = this;
                    if (this.p.compareAndSet(false, true)) {
                        i3 = 0;
                        if (i3 != 0) {
                        }
                        return xl4.a;
                    }
                    objS = null;
                    i3 = 0;
                    while (ql3Var.o.compareAndSet(true, false)) {
                    }
                    if (i3 != 0) {
                    }
                    if (i3 != 0) {
                    }
                    return xl4.a;
                } catch (Exception e) {
                    throw new RuntimeException("Exception while computing database live data.", e);
                }
            } finally {
                ql3Var.p.set(false);
            }
        }
        n12.S(objS);
        if (this.q.compareAndSet(false, true)) {
            y12 y12VarG = this.l.g();
            ul3 ul3Var = this.n;
            ul3Var.getClass();
            ct4 ct4Var = new ct4(y12VarG, ul3Var);
            LinkedHashMap linkedHashMap = y12VarG.c;
            vh4 vh4Var = y12VarG.b;
            e03 e03VarH = vh4Var.h(ct4Var.a);
            String[] strArr = (String[]) e03VarH.b;
            int[] iArr = (int[]) e03VarH.f;
            iu2 iu2Var = new iu2(ct4Var, iArr, strArr);
            ReentrantLock reentrantLock = y12VarG.d;
            reentrantLock.lock();
            try {
                iu2 iu2Var2 = linkedHashMap.containsKey(ct4Var) ? (iu2) fh2.T(linkedHashMap, ct4Var) : (iu2) linkedHashMap.put(ct4Var, iu2Var);
                reentrantLock.unlock();
                if ((iu2Var2 == null && vh4Var.h.r(iArr)) != false) {
                    co4.R(new w12(y12VarG, ge0Var, objArr == true ? 1 : 0));
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        ql3Var = this;
        if (this.p.compareAndSet(false, true)) {
        }
    }
}
