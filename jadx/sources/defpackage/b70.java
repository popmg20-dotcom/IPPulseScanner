package defpackage;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b70 extends hi4 {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object c;

    public b70(xg2 xg2Var, st2 st2Var) {
        this.b = xg2Var;
        this.c = st2Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                if (r62Var.X() == 9) {
                    r62Var.N();
                    return null;
                }
                Collection collection = (Collection) ((st2) obj).a();
                r62Var.B0();
                while (r62Var.hasNext()) {
                    collection.add(((xg2) obj2).c.b(r62Var));
                }
                r62Var.w0();
                return collection;
            default:
                Class cls = (Class) obj2;
                Object objB = ((cj4) obj).z.b(r62Var);
                if (objB == null || cls.isInstance(objB)) {
                    return objB;
                }
                throw new l52("Expected a " + cls.getName() + " but was " + objB.getClass().getName() + "; at path " + r62Var.x(true));
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        switch (this.a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    v72Var.B0();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((xg2) this.b).c(v72Var, it.next());
                    }
                    v72Var.w0();
                } else {
                    v72Var.C();
                }
                break;
            default:
                ((cj4) this.c).z.c(v72Var, obj);
                break;
        }
    }

    public b70(cj4 cj4Var, Class cls) {
        this.c = cj4Var;
        this.b = cls;
    }
}
