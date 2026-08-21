package defpackage;

import android.view.View;
import com.getsurfboard.ui.activity.OverrideDoHActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class op implements em1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ op(yn2 yn2Var, xn2 xn2Var) {
        this.b = 2;
        this.f = yn2Var;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, final Object obj3) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        Object obj4 = this.f;
        switch (i) {
            case 0:
                final xp xpVar = (xp) obj4;
                final xr3 xr3Var = (xr3) obj;
                break;
            case 1:
                ((f0) obj4).g((Throwable) obj);
                break;
            case 2:
                yn2 yn2Var = (yn2) obj4;
                yn2.z0.set(yn2Var, null);
                yn2Var.n(null);
                break;
            case 3:
                OverrideDoHActivity overrideDoHActivity = (OverrideDoHActivity) obj4;
                View view = (View) obj;
                int iIntValue = ((Integer) obj2).intValue();
                String str = (String) obj3;
                int i2 = OverrideDoHActivity.X0;
                view.getClass();
                str.getClass();
                overrideDoHActivity.U0 = view;
                overrideDoHActivity.y(iIntValue, str);
                break;
            default:
                ((ms3) obj4).c();
                break;
        }
        return xl4Var;
    }

    public /* synthetic */ op(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
