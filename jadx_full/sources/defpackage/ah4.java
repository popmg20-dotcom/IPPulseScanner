package defpackage;

import android.view.ViewGroup;
import com.getsurfboard.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ah4 {
    public static final ig a = new ig();
    public static final ThreadLocal b = new ThreadLocal();
    public static final ArrayList c = new ArrayList();

    public static void a(ViewGroup viewGroup, vg4 vg4Var) {
        ArrayList arrayList = c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (vg4Var == null) {
            vg4Var = a;
        }
        vg4 vg4VarClone = vg4Var.clone();
        c(viewGroup, vg4VarClone);
        viewGroup.setTag(R.id.transition_current_scene, null);
        zg4 zg4Var = new zg4();
        zg4Var.b = vg4VarClone;
        zg4Var.f = viewGroup;
        viewGroup.addOnAttachStateChangeListener(zg4Var);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(zg4Var);
    }

    public static ie b() {
        ie ieVar;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (ieVar = (ie) weakReference.get()) != null) {
            return ieVar;
        }
        ie ieVar2 = new ie(0);
        threadLocal.set(new WeakReference(ieVar2));
        return ieVar2;
    }

    public static void c(ViewGroup viewGroup, vg4 vg4Var) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((vg4) it.next()).C(viewGroup);
            }
        }
        if (vg4Var != null) {
            vg4Var.i(viewGroup, true);
        }
        if (viewGroup.getTag(R.id.transition_current_scene) == null) {
            return;
        }
        st4.n();
    }
}
