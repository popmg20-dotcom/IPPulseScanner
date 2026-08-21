package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class aa implements gp3 {
    public final /* synthetic */ int a;
    public final Object b;

    public aa(hp3 hp3Var) {
        this.a = 1;
        this.b = new LinkedHashSet();
        hp3Var.c("androidx.savedstate.Restarter", this);
    }

    @Override // defpackage.gp3
    public final Bundle a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Bundle bundle = new Bundle();
                ((ca) obj).w();
                return bundle;
            default:
                Bundle bundleE = n12.e((e03[]) Arrays.copyOf(new e03[0], 0));
                List listY0 = d70.y0((LinkedHashSet) obj);
                bundleE.putStringArrayList("classes_to_restore", listY0 instanceof ArrayList ? (ArrayList) listY0 : new ArrayList<>(listY0));
                return bundleE;
        }
    }

    public aa(ca caVar) {
        this.a = 0;
        this.b = caVar;
    }
}
