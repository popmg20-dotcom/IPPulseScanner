package defpackage;

import android.os.Bundle;
import androidx.fragment.app.p;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nf3 implements aa2 {
    public final /* synthetic */ int b;
    public final Object f;

    public /* synthetic */ nf3(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                kp3 kp3Var = (kp3) obj;
                if (p92Var != p92.ON_CREATE) {
                    xe.i("Next event must be ON_CREATE");
                    return;
                }
                da2Var.getLifecycle().c(this);
                Bundle bundleA = kp3Var.getSavedStateRegistry().a("androidx.savedstate.Restarter");
                if (bundleA == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    xe.q("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    return;
                }
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str, false, nf3.class.getClassLoader()).asSubclass(fp3.class);
                        clsAsSubclass.getClass();
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                objNewInstance.getClass();
                                if (!(kp3Var instanceof pq4)) {
                                    zo2.m(kp3Var, "Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: ");
                                    return;
                                }
                                oq4 viewModelStore = ((pq4) kp3Var).getViewModelStore();
                                hp3 savedStateRegistry = kp3Var.getSavedStateRegistry();
                                viewModelStore.getClass();
                                LinkedHashMap linkedHashMap = viewModelStore.a;
                                for (String str2 : new HashSet(linkedHashMap.keySet())) {
                                    str2.getClass();
                                    iq4 iq4Var = (iq4) linkedHashMap.get(str2);
                                    if (iq4Var != null) {
                                        n12.d(iq4Var, savedStateRegistry, kp3Var.getLifecycle());
                                    }
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    savedStateRegistry.d();
                                }
                            } catch (Exception e) {
                                zo2.o(ha0.n("Failed to instantiate ", str), e);
                                return;
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        zo2.o(ha0.o("Class ", str, " wasn't found"), e3);
                        return;
                    }
                }
                return;
            case 1:
                p pVar = (p) obj;
                if (pVar.X == null) {
                    e90 e90Var = (e90) pVar.getLastNonConfigurationInstance();
                    if (e90Var != null) {
                        pVar.X = e90Var.a;
                    }
                    if (pVar.X == null) {
                        pVar.X = new oq4();
                    }
                }
                pVar.b.c(this);
                return;
            case 2:
                new HashMap();
                jn1[] jn1VarArr = (jn1[]) obj;
                if (jn1VarArr.length > 0) {
                    jn1 jn1Var = jn1VarArr[0];
                    throw null;
                }
                if (jn1VarArr.length <= 0) {
                    return;
                }
                jn1 jn1Var2 = jn1VarArr[0];
                throw null;
            case 3:
                ((jk1) obj).b(false);
                return;
            default:
                if (p92Var != p92.ON_CREATE) {
                    zo2.m(p92Var, "Next event must be ON_CREATE, it was ");
                    return;
                } else {
                    da2Var.getLifecycle().c(this);
                    ((dp3) obj).b();
                    return;
                }
        }
    }
}
