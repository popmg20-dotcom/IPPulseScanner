package defpackage;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class e7 {
    public static final n84 a = new n84(new t4(1));

    public static final void a(Bundle bundle, String str) {
        b55 b55Var = ((FirebaseAnalytics) a.getValue()).a;
        b55Var.getClass();
        b55Var.a(new u45(b55Var, (String) null, str, bundle, false));
    }
}
