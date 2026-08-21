package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.fragment.app.p;
import com.google.android.gms.common.api.GoogleApiActivity;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lp1 extends mp1 {
    public static final Object c = new Object();
    public static final lp1 d = new lp1();

    public static AlertDialog d(Activity activity, int i, h05 h05Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(wz4.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(com.getsurfboard.R.string.common_google_play_services_enable_button) : resources.getString(com.getsurfboard.R.string.common_google_play_services_update_button) : resources.getString(com.getsurfboard.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, h05Var);
        }
        String strC = wz4.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        a1.o("GoogleApiAvailability", dw2.A(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof p) {
                ak1 ak1VarU = ((p) activity).u();
                x54 x54Var = new x54();
                tj4.j(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                x54Var.H0 = alertDialog;
                if (onCancelListener != null) {
                    x54Var.I0 = onCancelListener;
                }
                x54Var.m(ak1VarU, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        u51 u51Var = new u51();
        tj4.j(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        u51Var.b = alertDialog;
        if (onCancelListener != null) {
            u51Var.f = onCancelListener;
        }
        u51Var.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i, new c05(super.a(i, googleApiActivity, "d"), googleApiActivity), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        a1.o("GoogleApiAvailability", ha0.k("GMS core API Availability. ConnectionResult=", i, ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new e05(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                a1.n("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i == 6 ? wz4.e(context, "common_google_play_services_resolution_required_title") : wz4.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(com.getsurfboard.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? wz4.d(context, "common_google_play_services_resolution_required_text", wz4.a(context)) : wz4.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        tj4.i(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        us2 us2Var = new us2(context, null);
        us2Var.m = true;
        us2Var.s.flags |= 16;
        us2Var.e = us2.b(strE);
        v62 v62Var = new v62(7, false);
        v62Var.z = us2.b(strD);
        us2Var.d(v62Var);
        PackageManager packageManager = context.getPackageManager();
        Boolean boolValueOf = tj4.h;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
            tj4.h = boolValueOf;
        }
        if (boolValueOf.booleanValue()) {
            us2Var.s.icon = context.getApplicationInfo().icon;
            us2Var.h = 2;
            if (tj4.L(context)) {
                us2Var.b.add(new ts2(com.getsurfboard.R.drawable.common_full_open_on_phone, resources.getString(com.getsurfboard.R.string.common_open_on_phone), pendingIntent));
            } else {
                us2Var.g = pendingIntent;
            }
        } else {
            us2Var.s.icon = R.drawable.stat_sys_warning;
            us2Var.s.tickerText = us2.b(resources.getString(com.getsurfboard.R.string.common_google_play_services_notification_ticker));
            us2Var.s.when = System.currentTimeMillis();
            us2Var.g = pendingIntent;
            us2Var.c(strD);
        }
        if (vf2.v()) {
            if (!vf2.v()) {
                st4.g();
                return;
            }
            synchronized (c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.getsurfboard.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            us2Var.q = "com.google.android.gms.availability";
        }
        Notification notificationA = us2Var.a();
        if (i == 1 || i == 2 || i == 3) {
            up1.a.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationA);
    }

    public final void g(Activity activity, ba2 ba2Var, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i, new g05(super.a(i, activity, "d"), ba2Var), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
