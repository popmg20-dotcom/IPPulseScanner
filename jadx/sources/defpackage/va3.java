package defpackage;

import com.getsurfboard.R;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class va3 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ya3 f;

    public /* synthetic */ va3(ya3 ya3Var, int i) {
        this.b = i;
        this.f = ya3Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        ya3 ya3Var = this.f;
        switch (i) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int iOrdinal = t23.m().ordinal();
                v70 v70Var = v70.f;
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            g.d();
                            return null;
                        }
                        if (zBooleanValue) {
                            p95.C(R.string.already_largest_size, new Object[0]);
                        } else {
                            ya3Var.l(v70Var);
                        }
                    } else if (zBooleanValue) {
                        ya3Var.l(v70.z);
                    } else {
                        ya3Var.l(v70.b);
                    }
                } else if (zBooleanValue) {
                    ya3Var.l(v70Var);
                } else {
                    p95.C(R.string.already_smallest_size, new Object[0]);
                }
                return xl4Var;
            case 1:
                ya3Var.k();
                return xl4Var;
            case 2:
                t53 t53Var = (t53) obj;
                if (t53Var != null) {
                    rj2 rj2Var = ya3Var.X;
                    if (rj2Var != null) {
                        rj2Var.k(ya3Var.getViewLifecycleOwner());
                    }
                    String str = ya3Var.Z;
                    if (str == null) {
                        n12.T("profileName");
                        throw null;
                    }
                    rj2 rj2VarX = ji0.x(str);
                    ya3Var.X = rj2VarX;
                    rj2VarX.e(ya3Var.getViewLifecycleOwner(), new yh0(4, new va3(ya3Var, 3)));
                    ql3 ql3Var = ya3Var.A;
                    if (ql3Var != null) {
                        ql3Var.k(ya3Var.getViewLifecycleOwner());
                    }
                    String str2 = ya3Var.Z;
                    if (str2 == null) {
                        n12.T("profileName");
                        throw null;
                    }
                    na3 na3Var = ya3Var.y0;
                    if (na3Var == null) {
                        n12.T("proxyGroup");
                        throw null;
                    }
                    String name = na3Var.getName();
                    name.getClass();
                    ua3 ua3VarT = oj0.a.t();
                    ua3VarT.getClass();
                    ql3 ql3VarB = ua3VarT.a.g().b(new String[]{"proxy_group_selection"}, new ta3(str2, name, 0));
                    ya3Var.A = ql3VarB;
                    ql3VarB.e(ya3Var.getViewLifecycleOwner(), new yh0(4, new gj(17, ya3Var, t53Var)));
                }
                return xl4Var;
            default:
                Map map = (Map) obj;
                if (map == null) {
                    map = h41.b;
                }
                ya3Var.Y = map;
                pa3 pa3Var = ya3Var.z;
                if (pa3Var != null && !n12.c(pa3Var.h, map)) {
                    pa3Var.h = map;
                    if (pa3Var.b() > 0) {
                        pa3Var.a.d(0, pa3Var.b(), "payload_udp");
                    }
                }
                return xl4Var;
        }
    }
}
