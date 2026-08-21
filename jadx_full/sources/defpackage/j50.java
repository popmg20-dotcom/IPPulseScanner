package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class j50 implements f50 {
    public static final Map b;
    public final Class a;

    static {
        int i = 0;
        List listK = e70.K(pl1.class, am1.class, Function2.class, em1.class, fm1.class, gm1.class, yw4.class, l60.class, hm1.class, im1.class, ql1.class, rl1.class, sl1.class, tl1.class, ul1.class, vl1.class, wl1.class, xl1.class, yl1.class, zl1.class, bm1.class, cm1.class, dm1.class);
        ArrayList arrayList = new ArrayList(f70.Q(10, listK));
        for (Object obj : listK) {
            int i2 = i + 1;
            if (i < 0) {
                e70.P();
                throw null;
            }
            arrayList.add(new e03((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = fh2.X(arrayList);
    }

    public j50(Class cls) {
        cls.getClass();
        this.a = cls;
    }

    public final Class a() {
        return this.a;
    }

    public final String b() {
        String strS;
        Class cls = this.a;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strS2 = gb4.s(cls.getName());
            return strS2 == null ? cls.getCanonicalName() : strS2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strS = gb4.s(componentType.getName())) != null) {
            strConcat = strS.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final String c() {
        String strX;
        Class cls = this.a;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strX2 = gb4.X(cls.getName());
                return strX2 == null ? cls.getSimpleName() : strX2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strX = gb4.X(componentType.getName())) != null) {
                strConcat = strX.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return p44.O0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return p44.N0(simpleName, '$');
        }
        return p44.O0(simpleName, enclosingConstructor.getName() + '$');
    }

    public final boolean d(Object obj) {
        Class clsU = this.a;
        clsU.getClass();
        Map map = b;
        map.getClass();
        Integer num = (Integer) map.get(clsU);
        if (num != null) {
            return tj4.K(num.intValue(), obj);
        }
        if (clsU.isPrimitive()) {
            clsU = ye.u(dh3.a(clsU));
        }
        return clsU.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j50) && ye.u(this).equals(ye.u((j50) obj));
    }

    public final int hashCode() {
        return ye.u(this).hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
