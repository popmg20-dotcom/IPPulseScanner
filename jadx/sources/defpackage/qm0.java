package defpackage;

import android.util.Log;
import androidx.fragment.app.a0;
import androidx.fragment.app.g;
import androidx.fragment.app.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qm0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ a0 f;
    public final /* synthetic */ g z;

    public /* synthetic */ qm0(a0 a0Var, g gVar, int i) {
        this.b = i;
        this.f = a0Var;
        this.z = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        g gVar = this.z;
        a0 a0Var = this.f;
        switch (i) {
            case 0:
                if (u.M(2)) {
                    Log.v("FragmentManager", "Transition for operation " + a0Var + " has completed");
                }
                a0Var.c(gVar);
                break;
            default:
                if (u.M(2)) {
                    Log.v("FragmentManager", "Transition for operation " + a0Var + " has completed");
                }
                a0Var.c(gVar);
                break;
        }
    }
}
