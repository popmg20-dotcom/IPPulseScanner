package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ov0 extends va4 {
    public int z;

    public ov0(int i) {
        super(0L, false);
        this.z = i;
    }

    public abstract ge0 e();

    public Throwable g(Object obj) {
        r80 r80Var = obj instanceof r80 ? (r80) obj : null;
        if (r80Var != null) {
            return r80Var.a;
        }
        return null;
    }

    public final void i(Throwable th) {
        r25.E(e().j(), new rf0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object k();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ge0 ge0VarE = e();
            ge0VarE.getClass();
            lv0 lv0Var = (lv0) ge0VarE;
            ie0 ie0Var = lv0Var.X;
            Object obj = lv0Var.Z;
            cf0 cf0VarJ = ie0Var.j();
            Object objC = nd4.c(cf0VarJ, obj);
            v32 v32Var = null;
            bl4 bl4VarC0 = objC != nd4.a ? co4.c0(ie0Var, cf0VarJ, objC) : null;
            try {
                cf0 cf0VarJ2 = ie0Var.j();
                Object objK = k();
                Throwable thG = g(objK);
                if (thG == null) {
                    int i = this.z;
                    boolean z = true;
                    if (i != 1 && i != 2) {
                        z = false;
                    }
                    if (z) {
                        v32Var = (v32) cf0VarJ2.Z(pr1.X);
                    }
                }
                if (v32Var != null && !v32Var.isActive()) {
                    CancellationException cancellationExceptionF = v32Var.F();
                    b(cancellationExceptionF);
                    ie0Var.d(n12.r(cancellationExceptionF));
                } else if (thG != null) {
                    ie0Var.d(new tk3(thG));
                } else {
                    ie0Var.d(h(objK));
                }
                if (bl4VarC0 == null || bl4VarC0.n0()) {
                    nd4.a(cf0VarJ, objC);
                }
            } catch (Throwable th) {
                if (bl4VarC0 == null || bl4VarC0.n0()) {
                    nd4.a(cf0VarJ, objC);
                }
                throw th;
            }
        } catch (kv0 e) {
            r25.E(e().j(), e.b);
        } catch (Throwable th2) {
            i(th2);
        }
    }

    public void b(CancellationException cancellationException) {
    }

    public Object h(Object obj) {
        return obj;
    }
}
