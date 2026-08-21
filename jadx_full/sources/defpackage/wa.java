package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.getsurfboard.R;
import com.getsurfboard.ui.fragment.card.LocalProxyFragment;
import com.getsurfboard.ui.service.ExplorerService;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wa extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final Object b;

    public wa(k85 k85Var) {
        this.a = 5;
        this.b = k85Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        vs4 vs4Var;
        int i = 8;
        switch (this.a) {
            case 0:
                ((m0) this.b).o();
                break;
            case 1:
                context.getClass();
                intent.getClass();
                ((dp) this.b).f(intent);
                break;
            case 2:
                context.getClass();
                String str = "onReceive() called with: context = " + context + ", intent = " + intent;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ExplorerDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ExplorerDialogFragment", str, null);
                }
                int i2 = ExplorerService.y0;
                n81 n81Var = ((q81) this.b).H0;
                n81Var.getClass();
                context.unbindService(n81Var);
                break;
            case 3:
                context.getClass();
                intent.getClass();
                String strN = ha0.n("onReceive() action = ", intent.getAction());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ExplorerService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ExplorerService", strN, null);
                }
                String action = intent.getAction();
                if (action != null) {
                    int iHashCode = action.hashCode();
                    if (iHashCode != -1755592597) {
                        if (iHashCode == 1477683860 && action.equals("com.getsurfboard.action.EXPLORER_COPY_URL")) {
                            InetSocketAddress inetSocketAddress = ((ExplorerService) this.b).Y;
                            if (inetSocketAddress != null) {
                                co4.k("http://" + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());
                                p95.C(R.string.url_copied, new Object[0]);
                                break;
                            } else {
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 1, "ExplorerService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "runningAddress is null, cannot copy URL");
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d("ExplorerService", "runningAddress is null, cannot copy URL", null);
                                    break;
                                }
                            }
                        }
                    } else if (action.equals("com.getsurfboard.action.STOP_EXPLORER")) {
                        ((ExplorerService) this.b).stopSelf();
                        break;
                    }
                }
                break;
            case 4:
                LocalProxyFragment localProxyFragment = (LocalProxyFragment) this.b;
                context.getClass();
                if (intent != null && (vs4Var = (vs4) ws4.c.d()) != null && vs4Var.b) {
                    if (!intent.getBooleanExtra("noConnectivity", false)) {
                        on2 on2Var = ws4.f;
                        if (((Map) on2Var.d()) != null && (!r2.isEmpty()) && t23.f(p10.X)) {
                            View view = localProxyFragment.getView();
                            if (view != null) {
                                Object parent = view.getParent();
                                parent.getClass();
                                ((View) parent).setVisibility(0);
                            }
                            Map map = (Map) on2Var.d();
                            if (map != null && localProxyFragment.f != null) {
                                for (Map.Entry entry : map.entrySet()) {
                                    if (((Proxy) entry.getKey()).type() == Proxy.Type.HTTP) {
                                        Object value = entry.getValue();
                                        eg0 eg0Var = localProxyFragment.f;
                                        if (value == null) {
                                            eg0Var.getClass();
                                            MaterialTextView materialTextView = (MaterialTextView) eg0Var.f;
                                            SocketAddress socketAddressAddress = ((Proxy) entry.getKey()).address();
                                            socketAddressAddress.getClass();
                                            String strG0 = tj4.g0(socketAddressAddress);
                                            String strA = l72.A();
                                            if (strA == null) {
                                                strA = "0.0.0.0";
                                            }
                                            materialTextView.setText(w44.i0(strG0, "0.0.0.0", strA));
                                        } else {
                                            eg0Var.getClass();
                                            MaterialTextView materialTextView2 = (MaterialTextView) eg0Var.f;
                                            Throwable th = (Throwable) entry.getValue();
                                            materialTextView2.setText(th != null ? th.getMessage() : null);
                                        }
                                    } else if (((Proxy) entry.getKey()).type() == Proxy.Type.SOCKS) {
                                        Object value2 = entry.getValue();
                                        eg0 eg0Var2 = localProxyFragment.f;
                                        if (value2 == null) {
                                            eg0Var2.getClass();
                                            MaterialTextView materialTextView3 = (MaterialTextView) eg0Var2.z;
                                            SocketAddress socketAddressAddress2 = ((Proxy) entry.getKey()).address();
                                            socketAddressAddress2.getClass();
                                            String strG02 = tj4.g0(socketAddressAddress2);
                                            String strA2 = l72.A();
                                            if (strA2 == null) {
                                                strA2 = "0.0.0.0";
                                            }
                                            materialTextView3.setText(w44.i0(strG02, "0.0.0.0", strA2));
                                        } else {
                                            eg0Var2.getClass();
                                            MaterialTextView materialTextView4 = (MaterialTextView) eg0Var2.z;
                                            Throwable th2 = (Throwable) entry.getValue();
                                            materialTextView4.setText(th2 != null ? th2.getMessage() : null);
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    View view2 = localProxyFragment.getView();
                    if (view2 != null) {
                        Object parent2 = view2.getParent();
                        parent2.getClass();
                        ((View) parent2).setVisibility(8);
                    }
                    break;
                }
                break;
            default:
                k85 k85Var = (k85) this.b;
                if (intent == null) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.C0.a("App receiver called with null intent");
                } else {
                    String action2 = intent.getAction();
                    if (action2 == null) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.C0.a("App receiver called with null action");
                    } else {
                        int iHashCode2 = action2.hashCode();
                        if (iHashCode2 != -1928239649) {
                            if (iHashCode2 == 1279883384 && action2.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                                t65 t65Var3 = k85Var.Y;
                                k85.h(t65Var3);
                                t65Var3.H0.a("[sgtm] App Receiver notified batches are available");
                                f85 f85Var = k85Var.Z;
                                k85.h(f85Var);
                                f85Var.e1(new qz4(i, this));
                            }
                            break;
                        } else if (action2.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                            mg5.a();
                            if (k85Var.A.f1(null, r55.R0)) {
                                t65 t65Var4 = k85Var.Y;
                                k85.h(t65Var4);
                                t65Var4.H0.a("App receiver notified triggers are available");
                                f85 f85Var2 = k85Var.Z;
                                k85.h(f85Var2);
                                f85Var2.e1(new qz4(9, k85Var));
                                break;
                            }
                        }
                        t65 t65Var5 = k85Var.Y;
                        k85.h(t65Var5);
                        t65Var5.C0.a("App receiver called with unknown action");
                    }
                }
                break;
        }
    }

    public /* synthetic */ wa(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
