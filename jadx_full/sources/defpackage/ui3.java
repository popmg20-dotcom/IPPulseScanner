package defpackage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import defpackage.wi3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ui3 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, p92 p92Var) {
        p92Var.getClass();
        if (activity instanceof da2) {
            r92 lifecycle = ((da2) activity).getLifecycle();
            if (lifecycle instanceof fa2) {
                ((fa2) lifecycle).f(p92Var);
            }
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            wi3.a.Companion.getClass();
            vi3.a(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new wi3(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
