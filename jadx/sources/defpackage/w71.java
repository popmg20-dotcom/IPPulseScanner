package defpackage;

import android.view.View;
import com.getsurfboard.ui.activity.ExitHistoryActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w71 implements em1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ExitHistoryActivity f;

    public /* synthetic */ w71(ExitHistoryActivity exitHistoryActivity, int i) {
        this.b = i;
        this.f = exitHistoryActivity;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        ExitHistoryActivity exitHistoryActivity = this.f;
        View view = (View) obj;
        long jLongValue = ((Long) obj2).longValue();
        int iIntValue = ((Integer) obj3).intValue();
        int i2 = ExitHistoryActivity.U0;
        switch (i) {
            case 0:
                view.getClass();
                exitHistoryActivity.z(iIntValue, jLongValue);
                break;
            default:
                view.getClass();
                exitHistoryActivity.z(iIntValue, jLongValue);
                break;
        }
        return xl4Var;
    }
}
