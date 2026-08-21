package defpackage;

import android.app.ActivityOptions;
import android.app.job.JobScheduler;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l2 {
    public static Context a(Context context, int i) {
        return context.createDeviceContext(i);
    }

    public static JobScheduler b(JobScheduler jobScheduler) {
        JobScheduler jobSchedulerForNamespace = jobScheduler.forNamespace("androidx.work.systemjobscheduler");
        jobSchedulerForNamespace.getClass();
        return jobSchedulerForNamespace;
    }

    public static AccessibilityNodeInfo.AccessibilityAction c() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static float d(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getAxisVelocity(i);
    }

    public static void e(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence f(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static float g(Context context, WindowMetrics windowMetrics) {
        try {
            return windowMetrics.getDensity();
        } catch (NoSuchMethodError unused) {
            return context.getResources().getDisplayMetrics().density;
        }
    }

    public static int h(Context context) {
        return context.getDeviceId();
    }

    public static int i(Context context) {
        return context.getDeviceId();
    }

    public static int j(ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i, i2, i3);
    }

    public static int k(ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i, i2, i3);
    }

    public static boolean l(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static void m(TextView textView, int i, float f) {
        textView.setLineHeight(i, f);
    }

    public static final void n(qx qxVar) {
        if (Build.VERSION.SDK_INT >= 34) {
            qxVar.e(CaptureRequest.CONTROL_SETTINGS_OVERRIDE, 1);
        }
    }

    public static void o(ActivityOptions activityOptions) {
        activityOptions.setShareIdentityEnabled(false);
    }
}
