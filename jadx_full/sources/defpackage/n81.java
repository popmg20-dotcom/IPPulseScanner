package defpackage;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.ui.service.ExplorerService;
import com.tencent.mars.xlog.Xlog;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n81 implements ServiceConnection {
    public final /* synthetic */ q81 b;

    public n81(q81 q81Var) {
        this.b = q81Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        componentName.getClass();
        iBinder.getClass();
        String str = "onServiceConnected() called with: componentName = " + componentName + ", binder = " + iBinder;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ExplorerDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ExplorerDialogFragment", str, null);
        }
        ExplorerService explorerService = ((w81) iBinder).c;
        q81 q81Var = this.b;
        zf2 zf2Var = new zf2(22, q81Var);
        explorerService.A = zf2Var;
        k5 k5Var = explorerService.f;
        if (k5Var != null && k5Var.a != -1) {
            k5 k5Var2 = explorerService.f;
            k5Var2.getClass();
            InetAddress inetAddress = (InetAddress) k5Var2.c;
            k5 k5Var3 = explorerService.f;
            k5Var3.getClass();
            zf2Var.p0(new InetSocketAddress(inetAddress, k5Var3.a));
            return;
        }
        String str2 = explorerService.X;
        if (str2 != null) {
            Dialog dialog = q81Var.C0;
            if (dialog != null) {
                dialog.dismiss();
            }
            p95.D(str2);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        componentName.getClass();
        String str = "onServiceDisconnected() called with: componentName = " + componentName;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ExplorerDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("ExplorerDialogFragment", str, null);
    }
}
