package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t83 {
    public static final LinkedHashMap a = new LinkedHashMap();

    static {
        yj0.a.info("Registering DAV property factories");
        for (n83 n83Var : e70.K(w5.b, w5.d, e6.b, w5.c, w5.e, w5.f, w5.g, e6.c, e6.d, e6.e, w5.h, e6.f, w5.i, w5.j, w5.k, w5.l, w5.n, w5.o, w5.m, w5.p, w5.q, e6.g, w5.r, w5.s, e6.h, w5.t, w5.u, w5.v, w5.w, e6.i, w5.x, w5.y, w5.z, w5.A, w5.B)) {
            n83Var.getClass();
            yj0.a.fine("Registering " + n83Var.getClass().getName() + " for " + n83Var.getName());
            a.put(n83Var.getName(), n83Var);
        }
    }
}
