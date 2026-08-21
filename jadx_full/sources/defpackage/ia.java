package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ia implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Context f;

    public /* synthetic */ ia(Context context, int i) {
        this.b = i;
        this.f = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        rd2 rd2Var;
        int i = this.b;
        Context context = this.f;
        switch (i) {
            case 0:
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 33) {
                    ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (i2 >= 33) {
                            Object objB = ma.b();
                            rd2Var = objB != null ? new rd2(new ud2(ka.a(objB))) : rd2.b;
                            if (rd2Var.a.isEmpty()) {
                                String strM = ji0.M(context);
                                Object systemService = context.getSystemService("locale");
                                if (systemService != null) {
                                    ka.b(systemService, ja.a(strM));
                                }
                            }
                            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                        } else {
                            rd2Var = ma.z;
                            if (rd2Var == null) {
                            }
                            if (rd2Var.a.isEmpty()) {
                            }
                            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                        }
                    }
                }
                ma.Y = true;
                break;
            case 1:
                ma.p(context);
                break;
            case 2:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new ia(context, 3));
                break;
            default:
                b73.b(context, new qd(1), b73.a, false);
                break;
        }
    }
}
