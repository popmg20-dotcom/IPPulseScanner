package defpackage;

import j$.util.Objects;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n51 extends ue4 implements ee0 {
    public final l9 A;
    public final Boolean X;
    public final l9 Y;

    public n51(l9 l9Var, Boolean bool, l9 l9Var2) {
        super((Class) l9Var.f);
        this.A = l9Var;
        this.X = bool;
        this.Y = l9Var2;
    }

    public static Boolean p(Class cls, e52 e52Var, boolean z, Boolean bool) {
        d52 d52Var = e52Var.f;
        if (d52Var == null || d52Var == d52.b || d52Var == d52.z) {
            return bool;
        }
        if (d52Var == d52.z0 || d52Var == d52.f) {
            return Boolean.FALSE;
        }
        if (d52Var.a() || d52Var == d52.A) {
            return Boolean.TRUE;
        }
        String name = cls.getName();
        String str = z ? "class" : "property";
        StringBuilder sb = new StringBuilder("Unsupported serialization shape (");
        sb.append(d52Var);
        sb.append(") for Enum ");
        sb.append(name);
        sb.append(", not supported as ");
        throw new IllegalArgumentException(fw.y(sb, str, " annotation"));
    }

    public static n51 q(Class cls, bt3 bt3Var, ul ulVar, e52 e52Var) {
        w8 w8Var = (w8) ulVar.f;
        l9 l9VarE = l9.e(bt3Var, w8Var);
        r(bt3Var, w8Var);
        cu2 cu2VarD = bt3Var.d();
        boolean zE = bt3Var.e(k51.WRITE_ENUMS_TO_LOWERCASE);
        Class cls2 = w8Var.C0;
        Annotation[] annotationArr = n50.a;
        Enum[] enumArr = (Enum[]) (cls2.getSuperclass() != Enum.class ? cls2.getSuperclass() : cls2).getEnumConstants();
        if (enumArr == null) {
            xe.k("No enum constants for class ".concat(cls2.getName()));
            return null;
        }
        String[] strArr = new String[enumArr.length];
        cu2VarD.f(w8Var, enumArr, strArr);
        ft3[] ft3VarArr = new ft3[enumArr.length];
        for (int i = 0; i < enumArr.length; i++) {
            String string = enumArr[i].toString();
            if (string == null) {
                string = "";
            }
            String str = strArr[i];
            if (str != null) {
                string = str;
            } else if (zE) {
                string = string.toLowerCase();
            }
            ft3VarArr[i] = new ft3(string);
        }
        return new n51(l9VarE, p(cls, e52Var, true, null), new l9(cls2, ft3VarArr));
    }

    public static void r(bt3 bt3Var, w8 w8Var) {
        Class cls;
        Object objE = bt3Var.d().e(w8Var);
        boolean zF = bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS);
        if (objE == null || (cls = (Class) objE) == m51.class) {
            return;
        }
        if (!m51.class.isAssignableFrom(cls)) {
            xe.k(ha0.o("Problem with AnnotationIntrospector returned Class ", n50.e(cls), "; expected `Class<EnumNamingStrategy>`"));
        } else {
            if (n50.f(cls, zF) == null) {
                return;
            }
            st4.n();
        }
    }

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) {
        Class cls = this.b;
        e52 e52VarK = l34.k(gt3Var, nmVar, cls);
        if (e52VarK != null) {
            Boolean bool = this.X;
            Boolean boolP = p(cls, e52VarK, false, bool);
            if (!Objects.equals(boolP, bool)) {
                return new n51(this.A, boolP, this.Y);
            }
        }
        return this;
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        boolean zH;
        Enum r3 = (Enum) obj;
        Boolean bool = this.X;
        if (bool != null) {
            zH = bool.booleanValue();
        } else {
            zH = gt3Var.b.h(dt3.WRITE_ENUMS_USING_INDEX);
        }
        if (zH) {
            i52Var.c0(r3.ordinal());
            return;
        }
        if (gt3Var.b.h(dt3.WRITE_ENUMS_USING_TO_STRING)) {
            i52Var.F0(((ft3[]) this.Y.z)[r3.ordinal()]);
        } else {
            i52Var.F0(((ft3[]) this.A.z)[r3.ordinal()]);
        }
    }
}
