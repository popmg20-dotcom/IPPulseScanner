package defpackage;

import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.i;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b84 extends i {
    public a84 H0;
    public ed4 I0;

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_switch_import_loading, (ViewGroup) null, false);
        int i = R.id.progress;
        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) vf2.l(viewInflate, R.id.progress);
        if (linearProgressIndicator != null) {
            i = R.id.text;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.text);
            if (textView != null) {
                this.I0 = new ed4(13, (LinearLayoutCompat) viewInflate, linearProgressIndicator, textView);
                t6 t6Var = new t6(requireContext(), this.Y);
                p6 p6Var = (p6) t6Var.z;
                p6Var.e = p6Var.a.getText(R.string.setting_switch_import_title);
                ed4 ed4Var = this.I0;
                if (ed4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                p6Var.v = (LinearLayoutCompat) ed4Var.f;
                p6Var.u = 0;
                return t6Var.h();
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Z = false;
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.setCancelable(false);
        }
    }

    @Override // androidx.fragment.app.o
    public final void onDestroy() {
        a84 a84Var = this.H0;
        if (a84Var != null) {
            ContextUtilsKt.b().unregisterNetworkCallback(a84Var);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStart() {
        super.onStart();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ssid") : null;
        if (string == null) {
            xe.k("Required value was null.");
            return;
        }
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("passphrase") : null;
        if (string2 == null) {
            xe.k("Required value was null.");
            return;
        }
        WifiNetworkSpecifier wifiNetworkSpecifierBuild = new WifiNetworkSpecifier.Builder().setSsid(string).setWpa2Passphrase(string2).build();
        wifiNetworkSpecifierBuild.getClass();
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(wifiNetworkSpecifierBuild).build();
        this.H0 = new a84(0, this);
        ConnectivityManager connectivityManagerB = ContextUtilsKt.b();
        a84 a84Var = this.H0;
        a84Var.getClass();
        connectivityManagerB.requestNetwork(networkRequestBuild, a84Var);
    }
}
