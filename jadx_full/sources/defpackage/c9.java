package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class c9 extends xb5 implements Serializable {
    public final transient yj4 B0;
    public final transient cp1 C0;

    public c9(yj4 yj4Var, cp1 cp1Var) {
        this.B0 = yj4Var;
        this.C0 = cp1Var;
    }

    public abstract Class O();

    public String P() {
        return O().getName() + "#" + q();
    }

    public abstract Member Q();

    public abstract Object R(Object obj);

    public final boolean S(Class[] clsArr) {
        cp1 cp1Var = this.C0;
        if (cp1Var == null || ((HashMap) cp1Var.f) == null) {
            return false;
        }
        for (Class cls : clsArr) {
            if (((HashMap) cp1Var.f).containsKey(cls)) {
                return true;
            }
        }
        return false;
    }

    public abstract xb5 T(cp1 cp1Var);

    @Override // defpackage.xb5
    public final Annotation m(Class cls) {
        cp1 cp1Var = this.C0;
        if (cp1Var == null) {
            return null;
        }
        return cp1Var.get(cls);
    }
}
