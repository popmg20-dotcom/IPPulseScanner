package defpackage;

import io.sentry.android.core.cache.a;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class z42 extends hi4 {
    public static final z42 a = new z42();

    private z42() {
    }

    public static y42 d(int i, r62 r62Var) {
        int iG = fw.G(i);
        if (iG == 5) {
            return new k62(r62Var.q());
        }
        if (iG == 6) {
            return new k62(new y82(r62Var.q()));
        }
        if (iG == 7) {
            return new k62(Boolean.valueOf(r62Var.I()));
        }
        if (iG == 8) {
            r62Var.N();
            return f62.b;
        }
        xe.q("Unexpected token: ".concat(ha0.B(i)));
        return null;
    }

    public static void e(y42 y42Var, v72 v72Var) throws IOException {
        if (y42Var == null || (y42Var instanceof f62)) {
            v72Var.C();
            return;
        }
        if (y42Var instanceof k62) {
            k62 k62Var = (k62) y42Var;
            Serializable serializable = k62Var.b;
            if (serializable instanceof Number) {
                v72Var.X(k62Var.f());
                return;
            } else if (serializable instanceof Boolean) {
                v72Var.c0(k62Var.a());
                return;
            } else {
                v72Var.Z(k62Var.d());
                return;
            }
        }
        if (y42Var instanceof q42) {
            v72Var.B0();
            Iterator it = ((q42) y42Var).b.iterator();
            while (it.hasNext()) {
                e((y42) it.next(), v72Var);
            }
            v72Var.w0();
            return;
        }
        if (!(y42Var instanceof g62)) {
            a.c(y42Var.getClass(), "Couldn't write ");
            return;
        }
        v72Var.p0();
        Iterator it2 = ((nb2) y42Var.c().b.entrySet()).iterator();
        while (((mb2) it2).hasNext()) {
            ob2 ob2VarB = ((mb2) it2).b();
            v72Var.s((String) ob2VarB.getKey());
            e((y42) ob2VarB.getValue(), v72Var);
        }
        v72Var.V();
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        y42 q42Var;
        y42 q42Var2;
        int iX = r62Var.X();
        int iG = fw.G(iX);
        if (iG == 0) {
            r62Var.B0();
            q42Var = new q42();
        } else if (iG != 2) {
            q42Var = null;
        } else {
            r62Var.p0();
            q42Var = new g62();
        }
        if (q42Var == null) {
            return d(iX, r62Var);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (r62Var.hasNext()) {
                String strR = q42Var instanceof g62 ? r62Var.R() : null;
                int iX2 = r62Var.X();
                int iG2 = fw.G(iX2);
                if (iG2 == 0) {
                    r62Var.B0();
                    q42Var2 = new q42();
                } else if (iG2 != 2) {
                    q42Var2 = null;
                } else {
                    r62Var.p0();
                    q42Var2 = new g62();
                }
                boolean z = q42Var2 != null;
                if (q42Var2 == null) {
                    q42Var2 = d(iX2, r62Var);
                }
                if (q42Var instanceof q42) {
                    ((q42) q42Var).b.add(q42Var2);
                } else {
                    ((g62) q42Var).e(strR, q42Var2);
                }
                if (z) {
                    arrayDeque.addLast(q42Var);
                    q42Var = q42Var2;
                }
            } else {
                if (q42Var instanceof q42) {
                    r62Var.w0();
                } else {
                    r62Var.V();
                }
                if (arrayDeque.isEmpty()) {
                    return q42Var;
                }
                q42Var = (y42) arrayDeque.removeLast();
            }
        }
    }

    @Override // defpackage.hi4
    public final /* bridge */ /* synthetic */ void c(v72 v72Var, Object obj) throws IOException {
        e((y42) obj, v72Var);
    }
}
