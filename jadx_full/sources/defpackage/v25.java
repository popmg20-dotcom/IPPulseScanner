package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v25 {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final y25 f;

    public v25(k85 k85Var, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        y25 y25Var;
        tj4.f(str2);
        tj4.f(str3);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.C0.b(t65.Z0(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            y25Var = new y25(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.a("Param name can't be null");
                    it.remove();
                } else {
                    qf5 qf5Var = k85Var.z0;
                    k85.f(qf5Var);
                    Object objC1 = qf5Var.c1(bundle2.get(next), next);
                    if (objC1 == null) {
                        t65 t65Var3 = k85Var.Y;
                        k85.h(t65Var3);
                        t65Var3.C0.b(k85Var.A0.b(next), "Param value can't be null");
                        it.remove();
                    } else {
                        qf5 qf5Var2 = k85Var.z0;
                        k85.f(qf5Var2);
                        qf5Var2.k1(bundle2, next, objC1);
                    }
                }
            }
            y25Var = new y25(bundle2);
        }
        this.f = y25Var;
    }

    public final v25 a(k85 k85Var, long j) {
        return new v25(k85Var, this.c, this.a, this.b, this.d, j, this.f);
    }

    public final String toString() {
        String string = this.f.b.toString();
        String str = this.a;
        int length = String.valueOf(str).length();
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + string.length() + 1);
        ha0.v(sb, "Event{appId='", str, "', name='", str2);
        return fw.z(sb, "', params=", string, "}");
    }

    public v25(k85 k85Var, String str, String str2, String str3, long j, long j2, y25 y25Var) {
        tj4.f(str2);
        tj4.f(str3);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.C0.c("Event created with reverse previous/current timestamps. appId, name", t65.Z0(str2), t65.Z0(str3));
        }
        this.f = y25Var;
    }
}
