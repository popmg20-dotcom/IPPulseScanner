package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j05 extends yz4 {
    public final fa5 b;
    public final wa4 c;
    public final t60 d;

    public j05(fa5 fa5Var, wa4 wa4Var, t60 t60Var) {
        super(2);
        this.c = wa4Var;
        this.b = fa5Var;
        this.d = t60Var;
        if (fa5Var.b) {
            xe.k("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw null;
        }
    }

    @Override // defpackage.yz4
    public final boolean a(sz4 sz4Var) {
        return this.b.b;
    }

    @Override // defpackage.yz4
    public final ic1[] b(sz4 sz4Var) {
        return (ic1[]) this.b.f;
    }

    @Override // defpackage.yz4
    public final void c(Status status) {
        this.d.getClass();
        this.c.a(status.z != null ? new vj3(status) : new w9(status));
    }

    @Override // defpackage.yz4
    public final void d(Exception exc) {
        this.c.a(exc);
    }

    @Override // defpackage.yz4
    public final void e(sz4 sz4Var) throws DeadObjectException {
        wa4 wa4Var = this.c;
        try {
            this.b.k(sz4Var.d, wa4Var);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            c(yz4.g(e2));
        } catch (RuntimeException e3) {
            wa4Var.a(e3);
        }
    }

    @Override // defpackage.yz4
    public final void f(e24 e24Var, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Map map = (Map) e24Var.z;
        wa4 wa4Var = this.c;
        map.put(wa4Var, boolValueOf);
        wt2 wt2Var = wa4Var.a;
        ((fa5) wt2Var.d).w(new f95(xa4.a, new e24(25, e24Var, wa4Var)));
        wt2Var.j();
    }
}
