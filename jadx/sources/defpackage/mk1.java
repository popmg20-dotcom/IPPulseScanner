package defpackage;

import android.util.Log;
import androidx.fragment.app.o;
import androidx.fragment.app.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class mk1 {
    public static final lk1 a = lk1.a;

    public static lk1 a(o oVar) {
        while (oVar != null) {
            if (oVar.isAdded()) {
                oVar.getParentFragmentManager().getClass();
            }
            oVar = oVar.getParentFragment();
        }
        return a;
    }

    public static void b(bs4 bs4Var) {
        if (u.M(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(bs4Var.b.getClass().getName()), bs4Var);
        }
    }

    public static final void c(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        b(new fk1(oVar, "Attempting to reuse fragment " + oVar + " with previous ID " + str));
        a(oVar).getClass();
    }
}
