package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l9 implements o9, Serializable, nm, z82 {
    public final /* synthetic */ int b = 4;
    public Object f;
    public Object z;

    public l9(Class cls, ft3[] ft3VarArr) {
        this.f = cls;
        this.z = ft3VarArr;
    }

    public static l9 e(yg2 yg2Var, w8 w8Var) {
        cu2 cu2VarD = yg2Var.d();
        boolean zE = yg2Var.e(k51.WRITE_ENUMS_TO_LOWERCASE);
        Class cls = w8Var.C0;
        Annotation[] annotationArr = n50.a;
        Enum[] enumArr = (Enum[]) (cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls).getEnumConstants();
        if (enumArr == null) {
            xe.k("No enum constants for class ".concat(cls.getName()));
            return null;
        }
        String[] strArrF = cu2VarD.f(w8Var, enumArr, new String[enumArr.length]);
        ft3[] ft3VarArr = new ft3[enumArr.length];
        int length = enumArr.length;
        for (int i = 0; i < length; i++) {
            Enum r5 = enumArr[i];
            String lowerCase = strArrF[i];
            String strName = r5.name();
            if (lowerCase == null) {
                lowerCase = zE ? strName.toLowerCase() : strName;
            }
            ft3VarArr[r5.ordinal()] = new ft3(lowerCase);
        }
        return new l9(cls, ft3VarArr);
    }

    @Override // defpackage.nm
    public c9 a() {
        return (c9) this.z;
    }

    @Override // defpackage.nm
    public e52 b(yg2 yg2Var, Class cls) {
        e52 e52VarH;
        ((zg2) yg2Var).getClass();
        e52 e52Var = e52.y0;
        cu2 cu2VarD = yg2Var.d();
        c9 c9Var = (c9) this.z;
        return (c9Var == null || (e52VarH = cu2VarD.h(c9Var)) == null) ? e52Var : e52Var.d(e52VarH);
    }

    @Override // defpackage.z82
    public boolean c() {
        return this.z != vd3.y0;
    }

    @Override // defpackage.nm
    public t52 d(yg2 yg2Var, Class cls) {
        Class cls2 = ((nj4) this.f).L0;
        t52 t52Var = (t52) ((zg2) yg2Var).Z.f;
        cu2 cu2VarD = yg2Var.d();
        c9 c9Var = (c9) this.z;
        return c9Var == null ? t52Var : t52Var.a(cu2VarD.x(c9Var));
    }

    public boolean f(Object obj) {
        Set set = (Set) this.z;
        return !(set == null || set.contains(obj)) || ((Set) this.f).contains(obj);
    }

    @Override // defpackage.o9
    public Annotation get(Class cls) {
        if (((Class) this.f) == cls) {
            return (Annotation) this.z;
        }
        return null;
    }

    @Override // defpackage.z82
    public Object getValue() {
        Object obj = this.z;
        if (obj != vd3.y0) {
            return obj;
        }
        pl1 pl1Var = (pl1) this.f;
        pl1Var.getClass();
        Object objA = pl1Var.a();
        this.z = objA;
        this.f = null;
        return objA;
    }

    @Override // defpackage.o9
    public int size() {
        return 1;
    }

    public String toString() {
        switch (this.b) {
            case 4:
                return c() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ l9() {
    }

    public l9(Set set, Set set2) {
        this.f = set == null ? Collections.EMPTY_SET : set;
        this.z = set2;
    }

    public l9(Class cls, Annotation annotation) {
        this.f = cls;
        this.z = annotation;
    }

    public l9(nj4 nj4Var, c9 c9Var, o83 o83Var) {
        this.f = nj4Var;
        this.z = c9Var;
    }
}
