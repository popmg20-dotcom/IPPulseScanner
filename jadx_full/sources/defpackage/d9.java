package defpackage;

import j$.util.Objects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d9 extends i9 {
    public final transient Method E0;
    public Class[] F0;

    public d9(yj4 yj4Var, Method method, cp1 cp1Var, cp1[] cp1VarArr) {
        super(yj4Var, cp1Var, cp1VarArr);
        if (method != null) {
            this.E0 = method;
        } else {
            xe.k("Cannot construct AnnotatedMethod with null Method");
            throw null;
        }
    }

    @Override // defpackage.c9
    public final Class O() {
        return this.E0.getDeclaringClass();
    }

    @Override // defpackage.c9
    public final String P() {
        String strP = super.P();
        int iV = V();
        if (iV == 0) {
            return strP.concat("()");
        }
        if (iV != 1) {
            return String.format("%s(%d params)", super.P(), Integer.valueOf(V()));
        }
        StringBuilder sbQ = ha0.q(strP, "(");
        sbQ.append(X(0).getName());
        sbQ.append(")");
        return sbQ.toString();
    }

    @Override // defpackage.c9
    public final Member Q() {
        return this.E0;
    }

    @Override // defpackage.c9
    public final Object R(Object obj) {
        try {
            return this.E0.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Failed to getValue() with method " + this.P() + ": " + n50.g(e), e);
        }
    }

    @Override // defpackage.c9
    public final xb5 T(cp1 cp1Var) {
        return new d9(this.B0, this.E0, cp1Var, this.D0);
    }

    @Override // defpackage.i9
    public final int V() {
        return this.E0.getParameterTypes().length;
    }

    @Override // defpackage.i9
    public final nj4 W(int i) {
        Type[] genericParameterTypes = this.E0.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.B0.a(genericParameterTypes[i]);
    }

    @Override // defpackage.i9
    public final Class X(int i) {
        Class<?>[] parameterTypes = this.F0;
        if (parameterTypes == null) {
            parameterTypes = this.E0.getParameterTypes();
            this.F0 = parameterTypes;
        }
        if (i >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (n50.n(obj, d9.class)) {
            return Objects.equals(this.E0, ((d9) obj).E0);
        }
        return false;
    }

    public final int hashCode() {
        return this.E0.hashCode();
    }

    @Override // defpackage.xb5
    public final int p() {
        return this.E0.getModifiers();
    }

    @Override // defpackage.xb5
    public final String q() {
        return this.E0.getName();
    }

    public final String toString() {
        return "[method " + P() + "]";
    }

    @Override // defpackage.xb5
    public final Class u() {
        return this.E0.getReturnType();
    }

    @Override // defpackage.xb5
    public final nj4 x() {
        return this.B0.a(this.E0.getGenericReturnType());
    }
}
