package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yz4 {
    public final int a;

    public yz4(int i) {
        this.a = i;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(sz4 sz4Var);

    public abstract ic1[] b(sz4 sz4Var);

    public abstract void c(Status status);

    public abstract void d(Exception exc);

    public abstract void e(sz4 sz4Var);

    public abstract void f(e24 e24Var, boolean z);
}
