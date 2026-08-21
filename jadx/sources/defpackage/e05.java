package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e05 extends s05 {
    public final Context a;
    public final /* synthetic */ lp1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e05(lp1 lp1Var, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.b = lp1Var;
        this.a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            a1.n("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int i2 = mp1.a;
        lp1 lp1Var = this.b;
        Context context = this.a;
        int iB = lp1Var.b(context, i2);
        int i3 = up1.e;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = lp1Var.a(iB, context, "n");
            lp1Var.f(context, iB, intentA == null ? null : l72.o(context, 0, intentA, false));
        }
    }
}
