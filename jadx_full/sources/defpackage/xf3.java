package defpackage;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xf3 {
    public qf3 a;
    public ArrayList b;
    public long c;
    public long d;
    public long e;
    public long f;

    public static void b(rg3 rg3Var) {
        int i = rg3Var.j;
        if (!rg3Var.h() && (i & 4) == 0) {
            rg3Var.b();
        }
    }

    public abstract boolean a(rg3 rg3Var, rg3 rg3Var2, hm2 hm2Var, hm2 hm2Var2);

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(rg3 rg3Var) {
        qf3 qf3Var = this.a;
        if (qf3Var != null) {
            RecyclerView recyclerView = qf3Var.b;
            boolean z = true;
            rg3Var.p(true);
            View view = rg3Var.a;
            if (rg3Var.h != null && rg3Var.i == null) {
                rg3Var.h = null;
            }
            rg3Var.i = null;
            if ((rg3Var.j & 16) != 0) {
                return;
            }
            ig3 ig3Var = recyclerView.z;
            recyclerView.p0();
            j40 j40Var = recyclerView.z0;
            i40 i40Var = (i40) j40Var.d;
            gk1 gk1Var = (gk1) j40Var.c;
            int i = j40Var.b;
            if (i != 1) {
                if (i == 2) {
                    xe.q("Cannot call removeViewIfHidden within removeViewIfHidden");
                    return;
                }
                try {
                    j40Var.b = 2;
                    int iIndexOfChild = gk1Var.a.indexOfChild(view);
                    if (iIndexOfChild == -1) {
                        j40Var.j(view);
                    } else if (i40Var.e(iIndexOfChild)) {
                        i40Var.h(iIndexOfChild);
                        j40Var.j(view);
                        gk1Var.a(iIndexOfChild);
                    }
                    if (z) {
                        rg3 rg3VarO = RecyclerView.O(view);
                        ig3Var.m(rg3VarO);
                        ig3Var.j(rg3VarO);
                        if (RecyclerView.U1) {
                            Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                        }
                    }
                    recyclerView.r0(!z);
                    if (z && rg3Var.l()) {
                        recyclerView.removeDetachedView(view, false);
                        return;
                    }
                } finally {
                    j40Var.b = 0;
                }
            }
            if (((View) j40Var.f) != view) {
                xe.q("Cannot call removeViewIfHidden within removeView(At) for a different view");
                return;
            }
            z = false;
            if (z) {
            }
            recyclerView.r0(!z);
            if (z) {
            }
        }
    }

    public abstract void d(rg3 rg3Var);

    public abstract void e();

    public abstract boolean f();
}
