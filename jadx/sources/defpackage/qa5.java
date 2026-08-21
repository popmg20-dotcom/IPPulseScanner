package defpackage;

import android.os.Bundle;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qa5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ib5 f;
    public final /* synthetic */ Bundle z;

    public /* synthetic */ qa5(ib5 ib5Var, Bundle bundle, int i) {
        this.b = i;
        this.z = bundle;
        this.f = ib5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        int i = this.b;
        Bundle bundle2 = this.z;
        ib5 ib5Var = this.f;
        switch (i) {
            case 0:
                ib5Var.V0();
                ib5Var.W0();
                String string = bundle2.getString("name");
                tj4.f(string);
                k85 k85Var = (k85) ib5Var.f;
                if (!k85Var.a()) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.H0.a("Conditional property not cleared since app measurement is disabled");
                } else {
                    kf5 kf5Var = new kf5(0L, null, string, "");
                    try {
                        qf5 qf5Var = k85Var.z0;
                        k85.f(qf5Var);
                        bundle2.getString("app_id");
                        k85Var.j().o1(new q15(bundle2.getString("app_id"), "", kf5Var, bundle2.getLong("creation_timestamp"), bundle2.getBoolean("active"), bundle2.getString("trigger_event_name"), null, bundle2.getLong("trigger_timeout"), null, bundle2.getLong("time_to_live"), qf5Var.z1(bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), "", bundle2.getLong("creation_timestamp"), true)));
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
                break;
            default:
                rz4 rz4Var = ib5Var.Q0;
                k85 k85Var2 = (k85) ib5Var.f;
                if (bundle2.isEmpty()) {
                    bundle = bundle2;
                } else {
                    l75 l75Var = k85Var2.X;
                    qf5 qf5Var2 = k85Var2.z0;
                    x15 x15Var = k85Var2.A;
                    t65 t65Var2 = k85Var2.Y;
                    k85.f(l75Var);
                    bundle = new Bundle(l75Var.S0.f());
                    for (String str : bundle2.keySet()) {
                        Object obj = bundle2.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            k85.f(qf5Var2);
                            if (qf5.f2(obj)) {
                                qf5.l1(rz4Var, null, 27, null, null, 0);
                            }
                            k85.h(t65Var2);
                            t65Var2.E0.c("Invalid default event parameter type. Name, value", str, obj);
                        } else if (qf5.v1(str)) {
                            k85.h(t65Var2);
                            t65Var2.E0.b(str, "Invalid default event parameter name. Name");
                        } else if (obj == null) {
                            bundle.remove(str);
                        } else {
                            k85.f(qf5Var2);
                            x15Var.getClass();
                            if (qf5Var2.g2("param", str, 500, obj)) {
                                qf5Var2.k1(bundle, str, obj);
                            }
                        }
                    }
                    k85.f(qf5Var2);
                    qf5 qf5Var3 = ((k85) x15Var.f).z0;
                    k85.f(qf5Var3);
                    int i2 = qf5Var3.C1(201500000) ? 100 : 25;
                    if (bundle.size() > i2) {
                        int i3 = 0;
                        for (String str2 : new TreeSet(bundle.keySet())) {
                            i3++;
                            if (i3 > i2) {
                                bundle.remove(str2);
                            }
                        }
                        k85.f(qf5Var2);
                        qf5.l1(rz4Var, null, 26, null, null, 0);
                        k85.h(t65Var2);
                        t65Var2.E0.a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                }
                l75 l75Var2 = k85Var2.X;
                k85.f(l75Var2);
                l75Var2.S0.j(bundle);
                if (!bundle2.isEmpty() || k85Var2.A.f1(null, r55.X0)) {
                    k85Var2.j().a1(bundle);
                }
                break;
        }
    }
}
