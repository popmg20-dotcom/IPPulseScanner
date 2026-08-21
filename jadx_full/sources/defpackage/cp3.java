package defpackage;

import android.os.Bundle;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class cp3 {
    public static final vd3 a;
    public static final wl3 b;
    public static final t60 c = new t60();

    static {
        int i = 28;
        a = new vd3(i);
        b = new wl3(i);
    }

    public static final ap3 a(in2 in2Var) {
        ap3 ap3Var;
        LinkedHashMap linkedHashMap = in2Var.a;
        kp3 kp3Var = (kp3) linkedHashMap.get(a);
        Bundle bundle = null;
        if (kp3Var == null) {
            xe.k("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
            return null;
        }
        pq4 pq4Var = (pq4) linkedHashMap.get(b);
        if (pq4Var == null) {
            xe.k("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            return null;
        }
        Bundle bundle2 = (Bundle) linkedHashMap.get(c);
        String str = (String) linkedHashMap.get(nq4.a);
        if (str == null) {
            xe.k("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            return null;
        }
        gp3 gp3VarB = kp3Var.getSavedStateRegistry().b();
        dp3 dp3Var = gp3VarB instanceof dp3 ? (dp3) gp3VarB : null;
        if (dp3Var == null) {
            xe.q("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
            return null;
        }
        LinkedHashMap linkedHashMap2 = c(pq4Var).b;
        ap3 ap3Var2 = (ap3) linkedHashMap2.get(str);
        if (ap3Var2 != null) {
            return ap3Var2;
        }
        dp3Var.b();
        Bundle bundle3 = dp3Var.c;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = n12.e((e03[]) Arrays.copyOf(new e03[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                dp3Var.c = null;
            }
            bundle = bundle4;
        }
        if (bundle != null) {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            ap3Var = new ap3();
        } else {
            ClassLoader classLoader = ap3.class.getClassLoader();
            classLoader.getClass();
            bundle2.setClassLoader(classLoader);
            dg2 dg2Var = new dg2(bundle2.size());
            for (String str2 : bundle2.keySet()) {
                str2.getClass();
                dg2Var.put(str2, bundle2.get(str2));
            }
            ap3Var = new ap3(dg2Var.b());
        }
        linkedHashMap2.put(str, ap3Var);
        return ap3Var;
    }

    public static final void b(kp3 kp3Var) {
        q92 q92VarB = kp3Var.getLifecycle().b();
        if (q92VarB != q92.f && q92VarB != q92.z) {
            xe.k("Failed requirement.");
        } else if (kp3Var.getSavedStateRegistry().b() == null) {
            dp3 dp3Var = new dp3(kp3Var.getSavedStateRegistry(), (pq4) kp3Var);
            kp3Var.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", dp3Var);
            kp3Var.getLifecycle().a(new nf3(4, dp3Var));
        }
    }

    public static final ep3 c(pq4 pq4Var) {
        ck1 ck1Var = new ck1(2);
        dg0 defaultViewModelCreationExtras = pq4Var instanceof er1 ? ((er1) pq4Var).getDefaultViewModelCreationExtras() : cg0.b;
        defaultViewModelCreationExtras.getClass();
        oq4 viewModelStore = pq4Var.getViewModelStore();
        viewModelStore.getClass();
        return (ep3) new ih4(viewModelStore, ck1Var, defaultViewModelCreationExtras).a(dh3.a(ep3.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
