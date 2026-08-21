package defpackage;

import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hp3 {
    public final jp3 a;
    public aa b;

    public hp3(jp3 jp3Var) {
        this.a = jp3Var;
    }

    public final Bundle a(String str) {
        jp3 jp3Var = this.a;
        if (!jp3Var.g) {
            xe.q("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
            return null;
        }
        Bundle bundle = jp3Var.f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleV = bundle.containsKey(str) ? vo.v(bundle, str) : null;
        bundle.remove(str);
        if (bundle.isEmpty()) {
            jp3Var.f = null;
        }
        return bundleV;
    }

    public final gp3 b() {
        gp3 gp3Var;
        jp3 jp3Var = this.a;
        synchronized (jp3Var.c) {
            Iterator it = jp3Var.d.entrySet().iterator();
            do {
                gp3Var = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                gp3 gp3Var2 = (gp3) entry.getValue();
                if (n12.c(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    gp3Var = gp3Var2;
                }
            } while (gp3Var == null);
        }
        return gp3Var;
    }

    public final void c(String str, gp3 gp3Var) {
        jp3 jp3Var = this.a;
        synchronized (jp3Var.c) {
            if (jp3Var.d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            jp3Var.d.put(str, gp3Var);
        }
    }

    public final void d() {
        if (!this.a.h) {
            xe.q("Can not perform this action after onSaveInstanceState");
            return;
        }
        aa aaVar = this.b;
        if (aaVar == null) {
            aaVar = new aa(this);
        }
        this.b = aaVar;
        try {
            j92.class.getDeclaredConstructor(null);
            aa aaVar2 = this.b;
            if (aaVar2 != null) {
                ((LinkedHashSet) aaVar2.b).add(j92.class.getName());
            }
        } catch (NoSuchMethodException e) {
            s53.o("Class ", j92.class.getSimpleName(), " must have default constructor in order to be automatically recreated", e);
        }
    }
}
