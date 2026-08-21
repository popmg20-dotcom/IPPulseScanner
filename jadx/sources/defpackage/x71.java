package defpackage;

import android.view.View;
import com.getsurfboard.ui.activity.ExitHistoryActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x71 implements em1 {
    public final /* synthetic */ int b;

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        View view = (View) obj;
        long jLongValue = ((Long) obj2).longValue();
        Integer num = (Integer) obj3;
        switch (i) {
            case 0:
                int iIntValue = num.intValue();
                int i2 = ExitHistoryActivity.U0;
                view.getClass();
                uf2.P(view, jLongValue, iIntValue);
                break;
            default:
                int iIntValue2 = num.intValue();
                int i3 = ExitHistoryActivity.U0;
                view.getClass();
                uf2.P(view, jLongValue, iIntValue2);
                break;
        }
        return xl4Var;
    }
}
