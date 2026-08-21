package defpackage;

import android.app.Dialog;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import androidx.fragment.app.i;
import com.getsurfboard.R;
import com.getsurfboard.ui.receiver.appwidget.DNSProvider;
import com.getsurfboard.ui.receiver.appwidget.PrivateIPProvider;
import com.getsurfboard.ui.receiver.appwidget.PublicIPProvider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z5 extends i {
    public static final void n(z5 z5Var, int i) {
        ComponentName componentName;
        if (i == 0) {
            componentName = PublicIPProvider.a;
        } else if (i == 1) {
            componentName = DNSProvider.a;
        } else {
            if (i != 2) {
                xe.q("unknown index");
                return;
            }
            componentName = PrivateIPProvider.a;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(z5Var.getContext());
        if (appWidgetManager == null || !appWidgetManager.requestPinAppWidget(componentName, null, null)) {
            p95.C(R.string.add_widgets_not_supported, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        wh2 wh2Var = new wh2(requireContext());
        wh2Var.x(R.string.add_widgets);
        String[] strArr = {getString(R.string.public_ip), getString(R.string.dns), getString(R.string.private_ip)};
        y5 y5Var = new y5(0, this);
        p6 p6Var = (p6) wh2Var.z;
        p6Var.r = strArr;
        p6Var.t = y5Var;
        wh2Var.w(android.R.string.ok, null);
        return wh2Var.h();
    }
}
