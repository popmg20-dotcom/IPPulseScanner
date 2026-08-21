package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k05 extends yz4 {
    public final wa4 b;

    public k05(wa4 wa4Var) {
        super(4);
        this.b = wa4Var;
    }

    @Override // defpackage.yz4
    public final boolean a(sz4 sz4Var) {
        if (sz4Var.h.get(null) == null) {
            return false;
        }
        st4.n();
        return false;
    }

    @Override // defpackage.yz4
    public final ic1[] b(sz4 sz4Var) {
        if (sz4Var.h.get(null) == null) {
            return null;
        }
        st4.n();
        return null;
    }

    @Override // defpackage.yz4
    public final void c(Status status) {
        this.b.a(new w9(status));
    }

    @Override // defpackage.yz4
    public final void d(Exception exc) {
        this.b.a(exc);
    }

    @Override // defpackage.yz4
    public final void e(sz4 sz4Var) throws DeadObjectException {
        try {
            h(sz4Var);
        } catch (DeadObjectException e) {
            c(yz4.g(e));
            throw e;
        } catch (RemoteException e2) {
            c(yz4.g(e2));
        } catch (RuntimeException e3) {
            this.b.a(e3);
        }
    }

    public final void h(sz4 sz4Var) {
        if (sz4Var.h.remove(null) == null) {
            this.b.b(Boolean.FALSE);
        } else {
            st4.n();
        }
    }

    @Override // defpackage.yz4
    public final /* bridge */ /* synthetic */ void f(e24 e24Var, boolean z) {
    }
}
