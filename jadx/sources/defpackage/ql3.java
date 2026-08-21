package defpackage;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(defpackage.ie0 r12) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ql3.m(ie0):java.lang.Object");
    }
}
