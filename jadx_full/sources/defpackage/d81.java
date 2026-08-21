package defpackage;

import android.app.ApplicationExitInfo;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.card.MaterialCardView;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d81 implements View.OnClickListener {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ d81(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        Object obj = this.A;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case 0:
                ConstraintLayout constraintLayout = (ConstraintLayout) ((e81) obj).u.b;
                constraintLayout.getClass();
                ((Function2) obj3).k((ApplicationExitInfo) obj2, constraintLayout);
                break;
            case 1:
                e22 e22Var = (e22) obj2;
                Context context = e22Var.a.getContext();
                n02 n02Var = new n02(context, e22Var.b);
                new a64(context).inflate(R.menu.external_resources_item, (nk2) n02Var.f);
                n02Var.A = new m10(2, (ca1) obj3, (aa1) obj, e22Var);
                al2 al2Var = (al2) n02Var.z;
                if (!al2Var.b()) {
                    if (al2Var.e == null) {
                        xe.q("MenuPopupHelper cannot be used without an anchor");
                    } else {
                        al2Var.d(0, 0, false, false);
                    }
                    break;
                }
                break;
            case 2:
                bt1 bt1Var = (bt1) obj3;
                ls1 ls1Var = (ls1) obj2;
                at1 at1Var = (at1) obj;
                Context context2 = view.getContext();
                n02 n02Var2 = new n02(context2, view);
                new a64(context2).inflate(R.menu.host, (nk2) n02Var2.f);
                al2 al2Var2 = (al2) n02Var2.z;
                al2Var2.g = true;
                yk2 yk2Var = al2Var2.i;
                if (yk2Var != null) {
                    yk2Var.q(true);
                }
                n02Var2.A = new m10(4, bt1Var, ls1Var, at1Var);
                if (!al2Var2.b()) {
                    if (al2Var2.e == null) {
                        xe.q("MenuPopupHelper cannot be used without an anchor");
                    } else {
                        al2Var2.d(0, 0, false, false);
                    }
                    break;
                }
                break;
            case 3:
                xb5.c("profile item more clicked");
                ((bx0) obj3).u((dk1) obj2, (zk) obj);
                break;
            case 4:
                pa3 pa3Var = (pa3) obj3;
                f82 f82Var = (f82) obj2;
                na3 na3Var = pa3Var.f;
                t53 t53Var = pa3Var.e;
                ka3 ka3Var = (ka3) na3Var;
                String str = ka3Var.b;
                String str2 = f82Var.z;
                xb5.c("proxy group " + str + " item " + str2 + " clicked");
                if (!((MaterialCardView) ((fb3) obj).u.z).C0) {
                    String str3 = t53Var.b;
                    String str4 = ka3Var.b;
                    str3.getClass();
                    str4.getClass();
                    str2.getClass();
                    ua3 ua3VarT = oj0.a.t();
                    ke0.r(ua3VarT.a, false, true, new gj(16, ua3VarT, new sa3[]{new sa3(str3, str4, str2)}));
                    if (n12.c(ws4.a.d(), Boolean.TRUE)) {
                        Context context3 = view.getContext();
                        context3.getClass();
                        zw1.a(context3, SurfboardVpn.class, t53Var.b, ka3Var.b, f82Var.z, true);
                    }
                }
                break;
            default:
                ((cd) ((bx0) obj3).f).k((pd) obj2, (String) obj);
                break;
        }
    }
}
