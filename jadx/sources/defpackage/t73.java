package defpackage;

import android.content.Context;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t73 implements pl1 {
    public final /* synthetic */ Context A;
    public final /* synthetic */ int b;
    public final /* synthetic */ d83 f;
    public final /* synthetic */ Throwable z;

    public /* synthetic */ t73(d83 d83Var, Throwable th, Context context, int i) {
        this.b = i;
        this.f = d83Var;
        this.z = th;
        this.A = context;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        Context context = this.A;
        Throwable th = this.z;
        d83 d83Var = this.f;
        switch (i) {
            case 0:
                CharSequence text = context.getText(R.string.profile_decode_error);
                text.getClass();
                d83Var.o(th, text, null, null, null);
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                ((LinearProgressIndicator) y3Var.g).b();
                break;
            default:
                CharSequence text2 = context.getText(R.string.unknown_error);
                text2.getClass();
                d83Var.o(th, text2, null, null, null);
                break;
        }
        return xl4Var;
    }
}
