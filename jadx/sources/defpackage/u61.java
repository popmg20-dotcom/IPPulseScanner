package defpackage;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u61 implements ii4, Cloneable {
    public static final u61 A = new u61();
    public boolean b;
    public final List f;
    public final List z;

    public u61() {
        List list = Collections.EMPTY_LIST;
        this.f = list;
        this.z = list;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        Class cls = bk4Var.a;
        boolean zC = c(cls, true);
        boolean zC2 = c(cls, false);
        if (zC || zC2) {
            return new t61(this, zC2, zC, iq1Var, bk4Var);
        }
        return null;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final u61 clone() {
        try {
            return (u61) super.clone();
        } catch (CloneNotSupportedException e) {
            xe.i(e);
            return null;
        }
    }

    public final boolean c(Class cls, boolean z) {
        if (!z && !Enum.class.isAssignableFrom(cls)) {
            ez4 ez4Var = hh3.a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z ? this.f : this.z).iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        return false;
    }
}
