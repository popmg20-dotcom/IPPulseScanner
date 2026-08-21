package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q90 implements da3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ q90(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.da3
    public final Object get() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                x80 x80Var = (x80) obj;
                return x80Var.f.g(new rk3(x80Var, (r90) obj2));
            case 1:
                return new tr1((Context) obj2, (String) obj);
            default:
                ze1 ze1Var = (ze1) obj2;
                Context contextF = (Context) obj;
                String strC = ze1Var.c();
                ii0 ii0Var = new ii0();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 24) {
                    contextF = i2 >= 24 ? ga5.f(contextF) : null;
                }
                SharedPreferences sharedPreferences = contextF.getSharedPreferences("com.google.firebase.common.prefs:".concat(strC), 0);
                boolean z = true;
                if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
                    z = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
                } else {
                    try {
                        PackageManager packageManager = contextF.getPackageManager();
                        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextF.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                            z = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                        }
                        break;
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                ii0Var.a = z;
                return ii0Var;
        }
    }
}
