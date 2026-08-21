package defpackage;

import android.os.Bundle;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q85 implements Runnable {
    public final /* synthetic */ long A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public q85(yb5 yb5Var, Bundle bundle, rb5 rb5Var, rb5 rb5Var2, long j) {
        this.b = 2;
        this.f = bundle;
        this.z = rb5Var;
        this.X = rb5Var2;
        this.A = j;
        Objects.requireNonNull(yb5Var);
        this.Y = yb5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Object obj = this.X;
        Object obj2 = this.z;
        Object obj3 = this.f;
        Object obj4 = this.Y;
        switch (i) {
            case 0:
                String str = (String) obj2;
                ff5 ff5Var = ((i95) obj4).c;
                String str2 = (String) obj3;
                if (str2 != null) {
                    rb5 rb5Var = new rb5((String) obj, str2, this.A);
                    ff5Var.C().V0();
                    String str3 = ff5Var.X0;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    ff5Var.X0 = str;
                    ff5Var.W0 = rb5Var;
                } else {
                    ff5Var.C().V0();
                    String str4 = ff5Var.X0;
                    if (str4 == null || str4.equals(str)) {
                        ff5Var.X0 = str;
                        ff5Var.W0 = null;
                    }
                }
                break;
            case 1:
                String str5 = (String) obj2;
                Object obj5 = this.X;
                ((ib5) obj4).g1(this.A, obj5, (String) obj3, str5);
                break;
            default:
                yb5 yb5Var = (yb5) obj4;
                Bundle bundle = (Bundle) obj3;
                yb5Var.getClass();
                bundle.remove("screen_name");
                bundle.remove("screen_class");
                qf5 qf5Var = ((k85) yb5Var.f).z0;
                k85.f(qf5Var);
                yb5Var.f1((rb5) obj2, (rb5) obj, this.A, true, qf5Var.d1("screen_view", bundle, null, false));
                break;
        }
    }

    public /* synthetic */ q85(Object obj, String str, String str2, Object obj2, long j, int i) {
        this.b = i;
        this.f = str;
        this.z = str2;
        this.X = obj2;
        this.A = j;
        this.Y = obj;
    }
}
