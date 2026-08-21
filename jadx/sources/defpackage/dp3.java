package defpackage;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dp3 implements gp3 {
    public final hp3 a;
    public boolean b;
    public Bundle c;
    public final n84 d;

    public dp3(hp3 hp3Var, pq4 pq4Var) {
        hp3Var.getClass();
        this.a = hp3Var;
        this.d = new n84(new fn(21, pq4Var));
    }

    @Override // defpackage.gp3
    public final Bundle a() {
        Bundle bundleE = n12.e((e03[]) Arrays.copyOf(new e03[0], 0));
        Bundle bundle = this.c;
        if (bundle != null) {
            bundleE.putAll(bundle);
        }
        for (Map.Entry entry : ((ep3) this.d.getValue()).b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((c90) ((ap3) entry.getValue()).a.X).a();
            if (!bundleA.isEmpty()) {
                str.getClass();
                bundleE.putBundle(str, bundleA);
            }
        }
        this.b = false;
        return bundleE;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        Bundle bundleA = this.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleE = n12.e((e03[]) Arrays.copyOf(new e03[0], 0));
        Bundle bundle = this.c;
        if (bundle != null) {
            bundleE.putAll(bundle);
        }
        if (bundleA != null) {
            bundleE.putAll(bundleA);
        }
        this.c = bundleE;
        this.b = true;
    }
}
