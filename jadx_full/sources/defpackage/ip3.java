package defpackage;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ip3 {
    public final jp3 a;
    public final hp3 b;

    public ip3(jp3 jp3Var) {
        this.a = jp3Var;
        this.b = new hp3(jp3Var);
    }

    public final void a(Bundle bundle) {
        jp3 jp3Var = this.a;
        kp3 kp3Var = jp3Var.a;
        if (!jp3Var.e) {
            jp3Var.a();
        }
        if (kp3Var.getLifecycle().b().compareTo(q92.A) >= 0) {
            zo2.m(kp3Var.getLifecycle().b(), "performRestore cannot be called when owner is ");
            return;
        }
        if (jp3Var.g) {
            xe.q("SavedStateRegistry was already restored.");
            return;
        }
        Bundle bundleV = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleV = vo.v(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        jp3Var.f = bundleV;
        jp3Var.g = true;
    }

    public final void b(Bundle bundle) {
        jp3 jp3Var = this.a;
        Bundle bundleE = n12.e((e03[]) Arrays.copyOf(new e03[0], 0));
        Bundle bundle2 = jp3Var.f;
        if (bundle2 != null) {
            bundleE.putAll(bundle2);
        }
        synchronized (jp3Var.c) {
            for (Map.Entry entry : jp3Var.d.entrySet()) {
                String str = (String) entry.getKey();
                Bundle bundleA = ((gp3) entry.getValue()).a();
                str.getClass();
                bundleE.putBundle(str, bundleA);
            }
        }
        if (bundleE.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleE);
    }
}
