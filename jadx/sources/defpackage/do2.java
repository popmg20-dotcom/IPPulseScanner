package defpackage;

import android.widget.AutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class do2 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ NATDetectActivity Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ do2(NATDetectActivity nATDetectActivity, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = nATDetectActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((do2) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            default:
                ((do2) n(ge0Var, lf0Var)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        NATDetectActivity nATDetectActivity = this.Y;
        switch (i) {
            case 0:
                return new do2(nATDetectActivity, ge0Var, 0);
            default:
                return new do2(nATDetectActivity, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        NATDetectActivity nATDetectActivity = this.Y;
        switch (i) {
            case 0:
                n12.S(obj);
                boolean z = nATDetectActivity.U0;
                h4 h4Var = nATDetectActivity.S0;
                if (z) {
                    if (h4Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((LinearProgressIndicator) h4Var.e).e();
                } else {
                    if (h4Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((LinearProgressIndicator) h4Var.e).b();
                }
                return xl4Var;
            default:
                n12.S(obj);
                boolean z2 = nATDetectActivity.U0;
                h4 h4Var2 = nATDetectActivity.S0;
                if (z2) {
                    if (h4Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((AppCompatButton) h4Var2.h).setEnabled(false);
                } else {
                    if (h4Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    AppCompatButton appCompatButton = (AppCompatButton) h4Var2.h;
                    ((AutoCompleteTextView) h4Var2.d).getEditableText().getClass();
                    appCompatButton.setEnabled(!p44.x0(r4));
                }
                return xl4Var;
        }
    }
}
