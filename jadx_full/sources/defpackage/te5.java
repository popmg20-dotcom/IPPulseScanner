package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class te5 extends he5 {
    public static final boolean Y0(String str) {
        String str2 = (String) r55.t.a(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
    
        if (java.lang.Math.abs(r7.hashCode() % 100) < r9.C().n()) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final re5 W0(String str) {
        k85 k85Var = (k85) this.f;
        ff5 ff5Var = this.X;
        m25 m25Var = ff5Var.z;
        x75 x75Var = ff5Var.b;
        ff5.R(m25Var);
        b75 b75VarX1 = m25Var.X1(str);
        qb5 qb5Var = qb5.GOOGLE_ANALYTICS;
        re5 re5Var = null;
        if (b75VarX1 == null || !b75VarX1.y()) {
            return new re5(X0(str), Collections.EMPTY_MAP, qb5Var, null);
        }
        x85 x85VarO = y85.o();
        x85VarO.c();
        ((y85) x85VarO.f).t(2);
        int iM = qe4.m(b75VarX1.t());
        if (iM == 0) {
            zo2.n("null reference");
        }
        x85VarO.h(iM);
        String strE = b75VarX1.E();
        ff5.R(x75Var);
        j65 j65VarH1 = x75Var.h1(str);
        if (j65VarH1 != null) {
            m25 m25Var2 = ff5Var.z;
            ff5.R(m25Var2);
            b75 b75VarX12 = m25Var2.X1(str);
            if (b75VarX12 != null) {
                if (!j65VarH1.B() || j65VarH1.C().n() != 100) {
                    qf5 qf5Var = k85Var.z0;
                    k85.f(qf5Var);
                    if (!qf5Var.x1(str, b75VarX12.C())) {
                        if (!TextUtils.isEmpty(strE)) {
                        }
                    }
                }
                String strD = b75VarX1.D();
                x85VarO.c();
                ((y85) x85VarO.f).t(2);
                ff5.R(x75Var);
                j65 j65VarH12 = x75Var.h1(b75VarX1.D());
                if (j65VarH12 == null || !j65VarH12.B()) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.H0.b(strD, "[sgtm] Missing sgtm_setting in remote config. appId");
                    x85VarO.c();
                    ((y85) x85VarO.f).u(4);
                } else {
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(b75VarX1.C())) {
                        map.put("x-gtm-server-preview", b75VarX1.C());
                    }
                    String strO = j65VarH12.C().o();
                    int iM2 = qe4.m(b75VarX1.t());
                    if (iM2 != 0 && iM2 != 2) {
                        x85VarO.h(iM2);
                    } else if (Y0(b75VarX1.D())) {
                        x85VarO.h(11);
                    } else if (TextUtils.isEmpty(strO)) {
                        x85VarO.h(12);
                    } else {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.H0.b(strD, "[sgtm] Eligible for client side upload. appId");
                        x85VarO.c();
                        ((y85) x85VarO.f).t(3);
                        x85VarO.h(2);
                        re5Var = new re5(strO, map, qb5.SGTM_CLIENT, (y85) x85VarO.e());
                    }
                    j65VarH12.C().getClass();
                    j65VarH12.C().getClass();
                    k85Var.getClass();
                    t65 t65Var3 = k85Var.Y;
                    if (TextUtils.isEmpty(strO)) {
                        x85VarO.c();
                        ((y85) x85VarO.f).u(6);
                        k85.h(t65Var3);
                        t65Var3.H0.b(b75VarX1.D(), "[sgtm] Local service, missing sgtm_server_url");
                    } else {
                        k85.h(t65Var3);
                        t65Var3.H0.b(strD, "[sgtm] Eligible for local service direct upload. appId");
                        x85VarO.c();
                        ((y85) x85VarO.f).t(5);
                        x85VarO.c();
                        ((y85) x85VarO.f).u(2);
                        re5Var = new re5(strO, map, qb5.SGTM, (y85) x85VarO.e());
                    }
                }
                return re5Var != null ? re5Var : new re5(X0(str), Collections.EMPTY_MAP, qb5Var, (y85) x85VarO.e());
            }
        }
        x85VarO.c();
        ((y85) x85VarO.f).u(3);
        return new re5(X0(str), Collections.EMPTY_MAP, qb5Var, (y85) x85VarO.e());
    }

    public final String X0(String str) {
        x75 x75Var = this.X.b;
        ff5.R(x75Var);
        String strI1 = x75Var.i1(str);
        if (TextUtils.isEmpty(strI1)) {
            return (String) r55.r.a(null);
        }
        Uri uri = Uri.parse((String) r55.r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String authority = uri.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(strI1).length() + 1 + String.valueOf(authority).length());
        sb.append(strI1);
        sb.append(".");
        sb.append(authority);
        builderBuildUpon.authority(sb.toString());
        return builderBuildUpon.build().toString();
    }
}
