package defpackage;

import android.content.Context;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p63 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Object z;

    public p63(d83 d83Var, lf0 lf0Var, List list, boolean z) {
        this.z = d83Var;
        this.A = lf0Var;
        this.X = list;
        this.f = z;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        boolean z = this.f;
        Object obj = this.X;
        Object obj2 = this.A;
        Object obj3 = this.z;
        switch (i) {
            case 0:
                String str = (String) obj2;
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj;
                if (((String) obj3) == null) {
                    new v62((Context) profileEditorActivity).O(new fa5(profileEditorActivity, str, z));
                } else {
                    cm2 cm2Var = profileEditorActivity.S0;
                    if (cm2Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((LinearProgressIndicator) cm2Var.A).e();
                    ji0.B(uf2.t(profileEditorActivity), null, null, new o63((String) obj3, str, new p53(1, profileEditorActivity), profileEditorActivity, this.f, null), 3);
                }
                return xl4Var;
            default:
                d83 d83Var = (d83) obj3;
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                ((LinearProgressIndicator) y3Var.g).e();
                ji0.B((lf0) obj2, null, null, new dh0((List) obj, z, d83Var, (ge0) null), 3);
                y3 y3Var2 = d83Var.b;
                y3Var2.getClass();
                ((LinearProgressIndicator) y3Var2.g).b();
                return xl4Var;
        }
    }

    public p63(String str, ProfileEditorActivity profileEditorActivity, String str2, boolean z) {
        this.z = str;
        this.X = profileEditorActivity;
        this.A = str2;
        this.f = z;
    }
}
