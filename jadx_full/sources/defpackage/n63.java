package defpackage;

import androidx.appcompat.widget.Toolbar;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n63 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Object z;

    public /* synthetic */ n63(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.z = obj;
        this.A = obj2;
        this.f = z;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        boolean z = this.f;
        Object obj = this.A;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj2;
                cm2 cm2Var = profileEditorActivity.S0;
                if (cm2Var == null) {
                    n12.T("binding");
                    throw null;
                }
                ((Toolbar) cm2Var.Z).setTitle((String) obj);
                cm2 cm2Var2 = profileEditorActivity.S0;
                if (cm2Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((LinearProgressIndicator) cm2Var2.A).b();
                p95.C(R.string.profile_saved, new Object[0]);
                if (z) {
                    profileEditorActivity.b().d();
                }
                return xl4Var;
            default:
                d83 d83Var = (d83) obj2;
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                ((LinearProgressIndicator) y3Var.g).e();
                ji0.B((lf0) obj, null, null, new bi0((ge0) null, d83Var, z), 3);
                y3 y3Var2 = d83Var.b;
                y3Var2.getClass();
                ((LinearProgressIndicator) y3Var2.g).b();
                return xl4Var;
        }
    }
}
