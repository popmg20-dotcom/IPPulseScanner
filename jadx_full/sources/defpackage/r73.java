package defpackage;

import android.content.Context;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r73 implements pl1 {
    public final /* synthetic */ Context A;
    public final /* synthetic */ String X;
    public final /* synthetic */ String Y;
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ d83 f;
    public final /* synthetic */ Throwable z;

    public r73(d83 d83Var, String str, String str2, Throwable th, Context context) {
        this.f = d83Var;
        this.X = str;
        this.Y = str2;
        this.z = th;
        this.A = context;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        d83 d83Var = this.f;
        switch (i) {
            case 0:
                ji0.B(uf2.t(d83Var), null, null, new q73(this.f, this.X, this.Y, this.z, this.A, null, 0), 3);
                break;
            default:
                CharSequence text = this.A.getText(R.string.profile_decode_error);
                text.getClass();
                d83 d83Var2 = this.f;
                Context context = this.A;
                String str = this.X;
                String str2 = this.Y;
                Throwable th = this.z;
                this.f.o(th, text, str, str2, new r73(d83Var2, str, str2, th, context));
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                ((LinearProgressIndicator) y3Var.g).b();
                break;
        }
        return xl4Var;
    }

    public r73(d83 d83Var, Throwable th, Context context, String str, String str2) {
        this.f = d83Var;
        this.z = th;
        this.A = context;
        this.X = str;
        this.Y = str2;
    }
}
