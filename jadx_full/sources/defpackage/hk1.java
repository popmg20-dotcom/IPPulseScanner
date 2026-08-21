package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hk1 extends FragmentManager$FragmentLifecycleCallbacks {
    public final /* synthetic */ o a;
    public final /* synthetic */ FrameLayout b;

    public hk1(kk1 kk1Var, o oVar, FrameLayout frameLayout) {
        this.a = oVar;
        this.b = frameLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        ((java.util.concurrent.CopyOnWriteArrayList) r4.z).remove(r1);
     */
    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(u uVar, o oVar, View view) {
        if (oVar == this.a) {
            eg0 eg0Var = uVar.p;
            eg0Var.getClass();
            synchronized (((CopyOnWriteArrayList) eg0Var.z)) {
                int size = ((CopyOnWriteArrayList) eg0Var.z).size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (((qj1) ((CopyOnWriteArrayList) eg0Var.z).get(i)).a == this) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            kk1.q(view, this.b);
        }
    }
}
