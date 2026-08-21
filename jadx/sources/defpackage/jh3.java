package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class jh3 extends hi4 {
    public final lh3 a;

    public jh3(lh3 lh3Var) {
        this.a = lh3Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        Object objD = d();
        Map map = this.a.a;
        try {
            r62Var.p0();
            while (r62Var.hasNext()) {
                ih3 ih3Var = (ih3) map.get(r62Var.R());
                if (ih3Var == null) {
                    r62Var.t();
                } else {
                    f(objD, r62Var, ih3Var);
                }
            }
            r62Var.V();
            return e(objD);
        } catch (IllegalAccessException e) {
            ez4 ez4Var = hh3.a;
            zo2.o("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            return null;
        } catch (IllegalStateException e2) {
            throw new l52(e2);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        if (obj == null) {
            v72Var.C();
            return;
        }
        v72Var.p0();
        try {
            Iterator it = this.a.b.iterator();
            while (it.hasNext()) {
                ((ih3) it.next()).a(v72Var, obj);
            }
            v72Var.V();
        } catch (IllegalAccessException e) {
            ez4 ez4Var = hh3.a;
            zo2.o("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        }
    }

    public abstract Object d();

    public abstract Object e(Object obj);

    public abstract void f(Object obj, r62 r62Var, ih3 ih3Var);
}
