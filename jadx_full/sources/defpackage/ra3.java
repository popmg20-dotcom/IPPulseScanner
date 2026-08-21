package defpackage;

import android.os.Bundle;
import androidx.fragment.app.o;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ra3 extends kk1 {
    public final String m;
    public final List n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ra3(o oVar, String str, List list) {
        super(oVar.getChildFragmentManager(), oVar.getLifecycle());
        str.getClass();
        this.m = str;
        this.n = list;
    }

    @Override // defpackage.rf3
    public final int b() {
        return this.n.size();
    }

    @Override // defpackage.kk1
    public final o s(int i) {
        na3 na3Var = (na3) this.n.get(i);
        String str = this.m;
        str.getClass();
        na3Var.getClass();
        ya3 ya3Var = new ya3();
        Bundle bundle = new Bundle();
        bundle.putString("profile_name", str);
        bundle.putParcelable("group", na3Var);
        ya3Var.setArguments(bundle);
        return ya3Var;
    }
}
