package defpackage;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ta {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, za zaVar) {
        Objects.requireNonNull(zaVar);
        sa saVar = new sa(0, zaVar);
        g.c(obj).registerOnBackInvokedCallback(1000000, saVar);
        return saVar;
    }

    public static void c(Object obj, Object obj2) {
        g.c(obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
