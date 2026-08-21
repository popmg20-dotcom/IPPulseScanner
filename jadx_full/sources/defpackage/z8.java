package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z8 extends k70 {
    public final boolean X;
    public final Object Y;
    public Object Z;

    public z8(cu2 cu2Var, rj4 rj4Var, g50 g50Var, boolean z) {
        super(0, cu2Var);
        this.Y = rj4Var;
        this.Z = cu2Var == null ? null : g50Var;
        this.X = z;
    }

    public Map W0(yj4 yj4Var, nj4 nj4Var) {
        g50 g50Var;
        Class clsA;
        b9 b9Var;
        nj4 nj4VarD0 = nj4Var.d0();
        if (nj4VarD0 == null) {
            return null;
        }
        Class cls = nj4Var.L0;
        Map mapW0 = W0(new e24(12, (rj4) this.Y, nj4VarD0.X(), false), nj4VarD0);
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() || (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers()))) {
                if (mapW0 == null) {
                    mapW0 = new LinkedHashMap();
                }
                b9 b9Var2 = new b9(yj4Var, field);
                if (this.X) {
                    b9Var2.c = G0(j9.e, field.getDeclaredAnnotations());
                }
                mapW0.put(field.getName(), b9Var2);
            }
        }
        if (mapW0 != null && (g50Var = (g50) this.Z) != null && (clsA = g50Var.a(cls)) != null) {
            Iterator it = n50.i(clsA, cls, true).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if ((field2.isEnumConstant() || (!field2.isSynthetic() && !Modifier.isStatic(field2.getModifiers()))) && (b9Var = (b9) mapW0.get(field2.getName())) != null) {
                        b9Var.c = G0(b9Var.c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapW0;
    }

    public cp1 X0(l50 l50Var, l50 l50Var2) {
        if (!this.X) {
            return new cp1(5, false);
        }
        Annotation[] declaredAnnotations = l50Var.b;
        if (declaredAnnotations == null) {
            declaredAnnotations = l50Var.a.getDeclaredAnnotations();
            l50Var.b = declaredAnnotations;
        }
        ke0 ke0VarH0 = H0(declaredAnnotations);
        if (l50Var2 != null) {
            Annotation[] declaredAnnotations2 = l50Var2.b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = l50Var2.a.getDeclaredAnnotations();
                l50Var2.b = declaredAnnotations2;
            }
            ke0VarH0 = G0(ke0VarH0, declaredAnnotations2);
        }
        return ke0VarH0.c();
    }

    public cp1[] Y0(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.X) {
            return k70.z;
        }
        int length = annotationArr.length;
        cp1[] cp1VarArr = new cp1[length];
        for (int i = 0; i < length; i++) {
            ke0 ke0VarG0 = G0(j9.e, annotationArr[i]);
            if (annotationArr2 != null) {
                ke0VarG0 = G0(ke0VarG0, annotationArr2[i]);
            }
            cp1VarArr[i] = ke0VarG0.c();
        }
        return cp1VarArr;
    }

    public d9 Z0(Method method, yj4 yj4Var, Method method2) {
        int length = method.getParameterTypes().length;
        cu2 cu2Var = (cu2) this.f;
        cp1[] cp1VarArr = k70.z;
        if (cu2Var == null) {
            cp1 cp1Var = new cp1(5, false);
            if (length != 0) {
                cp1VarArr = new cp1[length];
                for (int i = 0; i < length; i++) {
                    cp1VarArr[i] = new cp1(5, false);
                }
            }
            return new d9(yj4Var, method, cp1Var, cp1VarArr);
        }
        if (length == 0) {
            ke0 ke0VarH0 = H0(method.getDeclaredAnnotations());
            if (method2 != null) {
                ke0VarH0 = G0(ke0VarH0, method2.getDeclaredAnnotations());
            }
            return new d9(yj4Var, method, ke0VarH0.c(), cp1VarArr);
        }
        ke0 ke0VarH02 = H0(method.getDeclaredAnnotations());
        if (method2 != null) {
            ke0VarH02 = G0(ke0VarH02, method2.getDeclaredAnnotations());
        }
        return new d9(yj4Var, method, ke0VarH02.c(), Y0(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y8 a1(l50 l50Var, l50 l50Var2) {
        Annotation[][] annotationArr;
        w8 w8Var = (w8) this.Y;
        int iA = l50Var.a();
        Constructor constructor = l50Var.a;
        cu2 cu2Var = (cu2) this.f;
        cp1[] cp1VarArr = k70.z;
        if (cu2Var == null) {
            cp1 cp1Var = new cp1(5, false);
            if (iA != 0) {
                cp1VarArr = new cp1[iA];
                for (int i = 0; i < iA; i++) {
                    cp1VarArr[i] = new cp1(5, false);
                }
            }
            return new y8(w8Var, constructor, cp1Var, cp1VarArr);
        }
        if (iA == 0) {
            return new y8(w8Var, constructor, X0(l50Var, l50Var2), cp1VarArr);
        }
        Annotation[][] parameterAnnotations = l50Var.c;
        if (parameterAnnotations == null) {
            parameterAnnotations = constructor.getParameterAnnotations();
            l50Var.c = parameterAnnotations;
        }
        Annotation[][] annotationArr2 = null;
        cp1VarArrY0 = null;
        cp1[] cp1VarArrY0 = null;
        if (iA != parameterAnnotations.length) {
            Class declaringClass = constructor.getDeclaringClass();
            Annotation[] annotationArr3 = n50.a;
            if (Enum.class.isAssignableFrom(declaringClass) && iA == parameterAnnotations.length + 2) {
                annotationArr = new Annotation[parameterAnnotations.length + 2][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 2, parameterAnnotations.length);
                cp1VarArrY0 = Y0(annotationArr, null);
            } else {
                if (declaringClass.isMemberClass() && iA == parameterAnnotations.length + 1) {
                    annotationArr = new Annotation[parameterAnnotations.length + 1][];
                    System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                    annotationArr[0] = k70.A;
                    cp1VarArrY0 = Y0(annotationArr, null);
                }
                if (cp1VarArrY0 == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", constructor.getDeclaringClass().getName(), Integer.valueOf(iA), Integer.valueOf(parameterAnnotations.length)));
                }
            }
            parameterAnnotations = annotationArr;
            if (cp1VarArrY0 == null) {
            }
        } else {
            if (l50Var2 != null) {
                Annotation[][] parameterAnnotations2 = l50Var2.c;
                if (parameterAnnotations2 == null) {
                    parameterAnnotations2 = l50Var2.a.getParameterAnnotations();
                    l50Var2.c = parameterAnnotations2;
                }
                annotationArr2 = parameterAnnotations2;
            }
            cp1VarArrY0 = Y0(parameterAnnotations, annotationArr2);
        }
        return new y8(w8Var, constructor, X0(l50Var, l50Var2), cp1VarArrY0);
    }

    public z8(cu2 cu2Var, w8 w8Var, boolean z) {
        super(0, cu2Var);
        this.Y = w8Var;
        this.X = z;
    }
}
