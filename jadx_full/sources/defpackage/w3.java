package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ExitHistoryActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.tencent.mars.xlog.Xlog;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w3 implements View.OnClickListener {
    public final /* synthetic */ int b;

    public /* synthetic */ w3(int i) {
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.b) {
            case 0:
                vs4 vs4Var = (vs4) ws4.c.d();
                if (vs4Var != null && vs4Var.b) {
                    Context context = view.getContext();
                    context.getClass();
                    zw1.c(context);
                    p95.C(R.string.print_connection_debug_info_in_logcat, new Object[0]);
                    break;
                }
                break;
            case 1:
                cr2.b();
                break;
            case 2:
                vs4 vs4Var2 = (vs4) ws4.c.d();
                if (vs4Var2 != null && vs4Var2.b) {
                    Context context2 = view.getContext();
                    context2.getClass();
                    zw1.c(context2);
                    p95.C(R.string.print_connection_debug_info_in_logcat, new Object[0]);
                    break;
                }
                break;
            case 3:
                view.getClass();
                if (Build.VERSION.SDK_INT >= 30) {
                    view.getContext().startActivity(new Intent(view.getContext(), (Class<?>) ExitHistoryActivity.class), l72.z(view));
                    break;
                }
                break;
            case 4:
                p95.C(R.string.garbage_collecting_toast, new Object[0]);
                System.gc();
                break;
            case 5:
                int i = TrafficListActivity.V0;
                view.getClass();
                ke0.E(view, cg4.b);
                break;
            case 6:
                cr2.d();
                break;
            case 7:
                p95.C(R.string.cannot_change_proxy_group_selection_manually, new Object[0]);
                break;
            case 8:
                cr2.e();
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                break;
            default:
                int i2 = TrafficListActivity.V0;
                view.getClass();
                ke0.E(view, cg4.f);
                break;
        }
    }

    private final void a(View view) {
    }
}
