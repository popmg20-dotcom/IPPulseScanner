package defpackage;

import android.app.ActivityManager;
import android.os.Process;
import android.util.Log;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s74 implements DefaultLifecycleObserver {
    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(da2 da2Var) {
        da2Var.getClass();
        xb5.c("App turn into foreground");
        String strConcat = "app foreground: ".concat(ContextUtilsKt.j());
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("SurfboardApp", strConcat, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(da2 da2Var) {
        ActivityManager.AppTask appTask;
        da2Var.getClass();
        xb5.c("App turn into background");
        String strConcat = "app background: ".concat(ContextUtilsKt.j());
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SurfboardApp", strConcat, null);
        }
        try {
            List<ActivityManager.AppTask> appTasks = ContextUtilsKt.a().getAppTasks();
            if (appTasks == null || (appTask = (ActivityManager.AppTask) d70.e0(appTasks)) == null) {
                return;
            }
            appTask.setExcludeFromRecents(t23.c(R.string.setting_hide_from_recent_task_key, false));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
