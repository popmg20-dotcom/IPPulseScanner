package defpackage;

import com.getsurfboard.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mo1 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ iv1 Y;
    public final /* synthetic */ Exception Z;
    public final /* synthetic */ po1 y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mo1(iv1 iv1Var, Exception exc, po1 po1Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = iv1Var;
        this.Z = exc;
        this.y0 = po1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((mo1) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            default:
                ((mo1) n(ge0Var, lf0Var)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        switch (this.X) {
            case 0:
                return new mo1(this.Y, this.Z, this.y0, ge0Var, 0);
            default:
                return new mo1(this.Y, this.Z, this.y0, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        po1 po1Var = this.y0;
        Exception exc = this.Z;
        iv1 iv1Var = this.Y;
        switch (i) {
            case 0:
                n12.S(obj);
                ((MaterialButton) iv1Var.z).setEnabled(true);
                TextInputLayout textInputLayout = (TextInputLayout) iv1Var.f;
                String message = exc.getMessage();
                if (message == null) {
                    message = po1Var.getString(R.string.unknown_error);
                    message.getClass();
                }
                textInputLayout.setError(message);
                ((LoadingIndicator) iv1Var.A).setVisibility(8);
                break;
            default:
                n12.S(obj);
                ((MaterialButton) iv1Var.X).setEnabled(true);
                TextInputLayout textInputLayout2 = (TextInputLayout) iv1Var.f;
                String message2 = exc.getMessage();
                if (message2 == null) {
                    message2 = po1Var.getString(R.string.unknown_error);
                    message2.getClass();
                }
                textInputLayout2.setError(message2);
                ((LoadingIndicator) iv1Var.A).setVisibility(8);
                ((MaterialButton) iv1Var.z).setEnabled(true);
                break;
        }
        return xl4Var;
    }
}
