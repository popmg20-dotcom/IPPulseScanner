package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import defpackage.b73;
import defpackage.co4;
import defpackage.ga5;
import defpackage.oj1;
import defpackage.qd;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            b73.b(context, new qd(1), new oj1(21, this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                oj1 oj1Var = new oj1(21, this);
                try {
                    b73.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    oj1Var.k(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    oj1Var.k(7, e);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            oj1 oj1Var2 = new oj1(21, this);
            if (Build.VERSION.SDK_INT < 24) {
                oj1Var2.k(13, null);
                return;
            } else {
                Process.sendSignal(Process.myPid(), 10);
                oj1Var2.k(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        oj1 oj1Var3 = new oj1(21, this);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            oj1Var3.k(16, null);
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (co4.m(i >= 34 ? ga5.e(context).getCacheDir() : i >= 24 ? ga5.e(context).getCodeCacheDir() : i == 23 ? context.getCodeCacheDir() : context.getCacheDir())) {
            oj1Var3.k(14, null);
        } else {
            oj1Var3.k(15, null);
        }
    }
}
