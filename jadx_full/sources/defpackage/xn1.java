package defpackage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xn1 {
    public wn1 a;
    public final c1 b;
    public final Method c;
    public final Method d;

    public xn1(c1 c1Var) {
        if (c1.class.isAssignableFrom(g32.class) && !g32.class.isInstance(c1Var)) {
            xe.k("Bad messageDefaultInstance for ".concat(g32.class.getName()));
            throw null;
        }
        this.a = null;
        this.b = c1Var;
        if (ca3.class.isAssignableFrom(g32.class)) {
            this.c = yn1.y(g32.class, "valueOf", bt0.class);
            this.d = yn1.y(g32.class, "getValueDescriptor", new Class[0]);
        } else {
            this.c = null;
            this.d = null;
        }
    }

    public final Object a(Object obj) {
        ft0 ft0VarB = b();
        if (!ft0VarB.y()) {
            return c(obj);
        }
        if (ft0VarB.r().b != ct0.MESSAGE && ft0VarB.r().b != ct0.ENUM) {
            return obj;
        }
        w93 w93Var = new w93(w93.A, 0, true);
        List list = (List) obj;
        int size = list.size();
        Object[] objArr = w93Var.f;
        if (size > objArr.length) {
            if (objArr.length == 0) {
                w93Var.f = new Object[Math.max(size, 10)];
            } else {
                int length = objArr.length;
                while (length < size) {
                    length = qe4.q(length, 3, 2, 1, 10);
                }
                w93Var.f = Arrays.copyOf(w93Var.f, length);
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w93Var.add(c(it.next()));
        }
        w93Var.b();
        return w93Var;
    }

    public final ft0 b() {
        wn1 wn1Var = this.a;
        if (wn1Var != null) {
            return (ft0) wn1Var.f;
        }
        xe.q("getDescriptor() called before internalInit()");
        return null;
    }

    public final Object c(Object obj) {
        int iOrdinal = b().r().b.ordinal();
        return iOrdinal != 7 ? (iOrdinal == 8 && !g32.class.isInstance(obj)) ? this.b.r().x((c1) obj).p() : obj : yn1.B(null, this.c, obj);
    }
}
