package defpackage;

import android.app.Dialog;
import android.content.Context;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import com.getsurfboard.R;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class no1 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public /* synthetic */ boolean Y;
    public final /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no1(po1 po1Var, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = po1Var;
        this.Y = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                ((no1) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                break;
            default:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                ((no1) n((ge0) obj2, bool)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.Z;
        switch (i) {
            case 0:
                return new no1((po1) obj2, this.Y, ge0Var);
            default:
                no1 no1Var = new no1((Context) obj2, ge0Var);
                no1Var.Y = ((Boolean) obj).booleanValue();
                return no1Var;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.Z;
        switch (i) {
            case 0:
                n12.S(obj);
                Dialog dialog = ((po1) obj2).C0;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (this.Y) {
                    p95.C(R.string.pls_restart_app_to_take_effect, new Object[0]);
                }
                break;
            default:
                n12.S(obj);
                dy2.a((Context) obj2, RescheduleReceiver.class, this.Y);
                break;
        }
        return xl4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no1(Context context, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = context;
    }
}
