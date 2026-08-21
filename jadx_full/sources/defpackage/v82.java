package defpackage;

import android.app.ApplicationExitInfo;
import com.getsurfboard.ui.fragment.LastExitReasonFragment;
import com.google.android.material.textview.MaterialTextView;
import java.text.SimpleDateFormat;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v82 extends v74 implements Function2 {
    public int X;
    public final /* synthetic */ LastExitReasonFragment Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v82(LastExitReasonFragment lastExitReasonFragment, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = lastExitReasonFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((v82) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new v82(this.Y, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        String strO;
        int i = this.X;
        ge0 ge0Var = null;
        if (i == 0) {
            n12.S(obj);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            lt ltVar = new lt(2, ge0Var, 5);
            this.X = 1;
            obj = ji0.b0(pl0Var, ltVar, this);
            mf0 mf0Var = mf0.b;
            if (obj == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
        }
        ApplicationExitInfo applicationExitInfoA = a71.a(obj);
        eg0 eg0Var = this.Y.b;
        eg0Var.getClass();
        MaterialTextView materialTextView = (MaterialTextView) eg0Var.z;
        if (applicationExitInfoA != null) {
            SimpleDateFormat simpleDateFormat = g81.a;
            strO = ha0.o(g81.e(applicationExitInfoA.getReason()), "\n", g81.b(applicationExitInfoA.getTimestamp()));
        } else {
            strO = "";
        }
        materialTextView.setText(strO);
        return xl4.a;
    }
}
