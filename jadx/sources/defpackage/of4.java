package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.a;
import androidx.fragment.app.u;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.ExternalResourcesManagerActivity;
import com.getsurfboard.ui.activity.LogcatViewerActivity;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.fragment.ToolsFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class of4 implements w23, l4, mu2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ToolsFragment f;

    public /* synthetic */ of4(ToolsFragment toolsFragment, int i) {
        this.b = i;
        this.f = toolsFragment;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        view.getClass();
        RecyclerView listView = this.f.getListView();
        listView.getClass();
        listView.setPadding(listView.getPaddingLeft(), listView.getPaddingTop(), listView.getPaddingRight(), ContextUtilsKt.c(16.0f) + bv4Var.a.h(519).d);
        return bv4Var;
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        int i = this.b;
        ToolsFragment toolsFragment = this.f;
        switch (i) {
            case 2:
                if (!((Boolean) obj).booleanValue()) {
                    p95.C(R.string.get_camera_permission_failed, new Object[0]);
                    return;
                }
                r4 r4Var = toolsFragment.f;
                if (r4Var != null) {
                    r4Var.a(new tp3(R.string.setting_switch_import_title, R.drawable.ic_round_videogame_asset_24));
                    return;
                } else {
                    n12.T("scanQRCodeLauncher");
                    throw null;
                }
            default:
                yp3 yp3Var = (yp3) obj;
                if (!(yp3Var instanceof wp3)) {
                    if (yp3Var instanceof vp3) {
                        p95.C(R.string.unknown_error, new Object[0]);
                        return;
                    } else {
                        if (yp3Var instanceof xp3) {
                            return;
                        }
                        g.d();
                        return;
                    }
                }
                String str = ((wp3) yp3Var).a;
                uh2 uh2VarC = qf4.b.c(str);
                if (uh2VarC == null || ((g0) uh2VarC.a()).a() != 3) {
                    p95.C(R.string.unknown_qrcode, str);
                    return;
                }
                String str2 = (String) ((sh2) uh2VarC.a()).get(1);
                String str3 = (String) ((sh2) uh2VarC.a()).get(2);
                if (Build.VERSION.SDK_INT >= 29) {
                    str2.getClass();
                    str3.getClass();
                    Bundle bundle = new Bundle();
                    bundle.putString("ssid", str2);
                    bundle.putString("passphrase", str3);
                    b84 b84Var = new b84();
                    b84Var.setArguments(bundle);
                    b84Var.m(toolsFragment.getChildFragmentManager(), null);
                    return;
                }
                return;
        }
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        r4 r4Var;
        int i = this.b;
        ToolsFragment toolsFragment = this.f;
        switch (i) {
            case 0:
                xb5.c("settings logcat_viewer clicked");
                View viewP = t23.p(toolsFragment, preference);
                if (viewP != null) {
                    int i2 = LogcatViewerActivity.S0;
                    List list = qf4.a;
                    list.getClass();
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Pattern) it.next()).pattern());
                    }
                    Intent intentPutStringArrayListExtra = new Intent(viewP.getContext(), (Class<?>) LogcatViewerActivity.class).putStringArrayListExtra("exclude_list", arrayList);
                    intentPutStringArrayListExtra.getClass();
                    viewP.getContext().startActivity(intentPutStringArrayListExtra, l72.z(viewP));
                }
                return true;
            case 1:
                new qo1().m(toolsFragment.getChildFragmentManager(), null);
                return true;
            case 2:
            case 3:
            case 5:
            default:
                try {
                    r4Var = toolsFragment.b;
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    p95.C(R.string.unknown_error, new Object[0]);
                }
                if (r4Var != null) {
                    r4Var.a("android.permission.CAMERA");
                    return true;
                }
                n12.T("requestCameraPermission");
                throw null;
            case 4:
                ji0.B(uf2.t(toolsFragment), null, null, new pf4(preference, toolsFragment, (ge0) null), 3);
                return true;
            case 6:
                View viewP2 = t23.p(toolsFragment, preference);
                if (viewP2 != null) {
                    viewP2.getContext().startActivity(new Intent(viewP2.getContext(), (Class<?>) ExternalResourcesManagerActivity.class), l72.z(viewP2));
                }
                return true;
            case 7:
                View viewP3 = t23.p(toolsFragment, preference);
                if (viewP3 != null) {
                    viewP3.getContext().startActivity(new Intent(viewP3.getContext(), (Class<?>) BypassConfigActivity.class), l72.z(viewP3));
                }
                return true;
            case 8:
                View viewP4 = t23.p(toolsFragment, preference);
                if (viewP4 != null) {
                    viewP4.getContext().startActivity(new Intent(viewP4.getContext(), (Class<?>) RecentRequestsActivity.class), l72.z(viewP4));
                }
                return true;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                View viewP5 = t23.p(toolsFragment, preference);
                if (viewP5 != null) {
                    viewP5.getContext().startActivity(new Intent(viewP5.getContext(), (Class<?>) NATDetectActivity.class), l72.z(viewP5));
                }
                return true;
            case 10:
                Bundle bundle = new Bundle();
                bundle.putString(RtspHeaders.Values.URL, "https://speed.cloudflare.com");
                fn4 fn4Var = new fn4();
                fn4Var.setArguments(bundle);
                u childFragmentManager = toolsFragment.getChildFragmentManager();
                childFragmentManager.getClass();
                fn4Var.m(childFragmentManager, null);
                return true;
            case 11:
                u childFragmentManager2 = toolsFragment.getChildFragmentManager();
                childFragmentManager2.getClass();
                a aVar = new a(childFragmentManager2);
                aVar.g(0, new qp1(), null, 1);
                aVar.e();
                return true;
        }
    }
}
