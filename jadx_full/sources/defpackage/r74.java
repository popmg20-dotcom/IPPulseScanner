package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.os.Bundle;
import com.getsurfboard.R;
import com.getsurfboard.ui.SurfboardApp;
import com.getsurfboard.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r74 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        activity.getClass();
        boolean z = nj3.a;
        nj3.e.d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        cd4 cd4VarG = t23.g();
        Object obj = ke0.j().get(cd4VarG);
        obj.getClass();
        activity.setTheme(((Number) obj).intValue());
        if (cd4VarG == cd4.b && kz0.a() && kz0.a()) {
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(kz0.a);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            gb4.i(activity, resourceId);
            ez4.a(activity, dr1.a());
        }
        if ((activity instanceof MainActivity) || !t23.d("pure_dark", false)) {
            return;
        }
        int i = SurfboardApp.A;
        if ((activity.getResources().getConfiguration().uiMode & 48) == 32) {
            activity.getTheme().applyStyle(R.style.PureDarkOverlay, true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        activity.getClass();
        if (t23.c(R.string.setting_masked_from_recent_task_key, false)) {
            activity.getWindow().addFlags(8192);
        } else {
            activity.getWindow().clearFlags(8192);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activity.getClass();
        bundle.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        activity.getClass();
    }
}
