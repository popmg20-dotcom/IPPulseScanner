package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lh0 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ xh0 f;

    public /* synthetic */ lh0(xh0 xh0Var, int i) {
        this.b = i;
        this.f = xh0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent;
        int i = this.b;
        xh0 xh0Var = this.f;
        switch (i) {
            case 0:
                xb5.c("dashboard fab clicked");
                Context context = view.getContext();
                context.getClass();
                xh0Var.j(context);
                return;
            case 1:
                new ci0().m(xh0Var.getChildFragmentManager(), null);
                return;
            case 2:
                int i2 = Build.VERSION.SDK_INT;
                int i3 = 0;
                if (i2 < 33) {
                    String packageName = view.getContext().getPackageName();
                    if (i2 >= 26) {
                        intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", packageName);
                    } else {
                        intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + packageName));
                    }
                    intent.getClass();
                    try {
                        xh0Var.startActivity(intent);
                        return;
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        j80 j80Var = xh0Var.b;
                        j80Var.getClass();
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var.a;
                        coordinatorLayout.getClass();
                        r25.R(coordinatorLayout, R.string.unknown_error, new Object[0]);
                        return;
                    }
                }
                if (xh0Var.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                    wh2 wh2Var = new wh2(xh0Var.requireContext());
                    wh2Var.x(R.string.permission_requirement);
                    wh2Var.t(R.string.notification_permission_rationale);
                    wh2Var.w(R.string.i_got_it, new mh0(xh0Var, 3));
                    wh2Var.u(R.string.no_thanks, new ph0(i3));
                    wh2Var.r();
                    return;
                }
                try {
                    r4 r4Var = xh0Var.A;
                    if (r4Var != null) {
                        r4Var.a("android.permission.POST_NOTIFICATIONS");
                        return;
                    } else {
                        n12.T("notificationPermissionLauncher");
                        throw null;
                    }
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                    j80 j80Var2 = xh0Var.b;
                    j80Var2.getClass();
                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) j80Var2.a;
                    coordinatorLayout2.getClass();
                    r25.R(coordinatorLayout2, R.string.unknown_error, new Object[0]);
                    return;
                }
            default:
                Bundle bundle = new Bundle();
                bundle.putString(RtspHeaders.Values.URL, "https://getsurfboard.com/docs/location_permision/");
                fn4 fn4Var = new fn4();
                fn4Var.setArguments(bundle);
                u childFragmentManager = xh0Var.getChildFragmentManager();
                childFragmentManager.getClass();
                fn4Var.m(childFragmentManager, null);
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putBoolean("location_permission_explanation_viewed", true);
                editorEdit.apply();
                return;
        }
    }
}
