package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import io.sentry.android.core.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o75 {
    public final k85 a;

    public o75(ff5 ff5Var) {
        this.a = ff5Var.C0;
    }

    public boolean a() {
        k85 k85Var = this.a;
        try {
            return ay4.a(k85Var.b).a(128, "com.android.vending").versionCode >= 80837300;
        } catch (Exception e) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.b(e, "Failed to retrieve Play Store version for Install Referrer");
            return false;
        }
    }

    public void b(Bundle bundle, String str) {
        String string;
        k85 k85Var = this.a;
        f85 f85Var = k85Var.Z;
        l75 l75Var = k85Var.X;
        k85.h(f85Var);
        f85Var.V0();
        if (k85Var.a()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        k85.f(l75Var);
        l75Var.Q0.C(string);
        u uVar = l75Var.R0;
        k85Var.B0.getClass();
        uVar.b(System.currentTimeMillis());
    }

    public boolean c() {
        if (!d()) {
            return false;
        }
        k85 k85Var = this.a;
        k85Var.B0.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        l75 l75Var = k85Var.X;
        k85.f(l75Var);
        return jCurrentTimeMillis - l75Var.R0.a() > k85Var.A.c1(null, r55.k0);
    }

    public boolean d() {
        l75 l75Var = this.a.X;
        k85.f(l75Var);
        return l75Var.R0.a() > 0;
    }

    public o75(k85 k85Var) {
        this.a = k85Var;
    }
}
