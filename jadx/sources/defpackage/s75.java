package defpackage;

import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s75 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ x75 b;
    public final /* synthetic */ String c;

    public /* synthetic */ s75(x75 x75Var, String str, int i) {
        this.a = i;
        this.b = x75Var;
        this.c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        String str = this.c;
        x75 x75Var = this.b;
        switch (i) {
            case 0:
                return new ha5(new s75(x75Var, str, 1));
            case 1:
                m25 m25Var = x75Var.X.z;
                ff5.R(m25Var);
                b75 b75VarX1 = m25Var.X1(str);
                HashMap map = new HashMap();
                map.put("platform", "android");
                map.put("package_name", str);
                ((k85) x75Var.f).A.a1();
                map.put("gmp_version", 133005L);
                if (b75VarX1 != null) {
                    String strN = b75VarX1.N();
                    if (strN != null) {
                        map.put("app_version", strN);
                    }
                    map.put("app_version_int", Long.valueOf(b75VarX1.P()));
                    map.put("dynamite_version", Long.valueOf(b75VarX1.b()));
                }
                return map;
            default:
                e24 e24Var = new e24(29, x75Var, str);
                uc5 uc5Var = new uc5("internal.remoteConfig", 0);
                uc5Var.f.put("getValue", new ha5(uc5Var, e24Var));
                return uc5Var;
        }
    }
}
