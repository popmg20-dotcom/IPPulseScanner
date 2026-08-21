package defpackage;

import android.view.View;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ow0 implements View.OnLongClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ ow0(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                co4.k((String) obj);
                p95.C(R.string.ip_copied, new Object[0]);
                return true;
            case 1:
                co4.k((String) obj);
                p95.C(R.string.ip_copied, new Object[0]);
                return true;
            case 2:
                co4.k((String) obj);
                p95.C(R.string.ip_copied, new Object[0]);
                return true;
            default:
                zi3 zi3Var = (zi3) obj;
                String str = zi3Var.c;
                String str2 = zi3Var.f;
                String str3 = zi3Var.e;
                String strH0 = p44.H0(p44.H0(zi3Var.d, "\""), "'");
                StringBuilder sbE = fw.E("[", str, "] to ", str2, " hit ");
                sbE.append(str3);
                sbE.append(" through ");
                sbE.append(strH0);
                if (!co4.k(sbE.toString())) {
                    return false;
                }
                p95.C(R.string.traffic_info_copied, new Object[0]);
                return true;
        }
    }
}
