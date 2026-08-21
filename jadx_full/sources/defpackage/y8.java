package defpackage;

import j$.util.Objects;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y8 extends i9 {
    public final Constructor E0;

    public y8(yj4 yj4Var, Constructor constructor, cp1 cp1Var, cp1[] cp1VarArr) {
        super(yj4Var, cp1Var, cp1VarArr);
        Objects.requireNonNull(constructor);
        this.E0 = constructor;
    }

    @Override // defpackage.c9
    public final Class O() {
        return this.E0.getDeclaringClass();
    }

    @Override // defpackage.c9
    public final Member Q() {
        return this.E0;
    }

    @Override // defpackage.c9
    public final Object R(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of ".concat(this.E0.getDeclaringClass().getName()));
    }

    @Override // defpackage.c9
    public final xb5 T(cp1 cp1Var) {
        return new y8(this.B0, this.E0, cp1Var, this.D0);
    }

    @Override // defpackage.i9
    public final int V() {
        return this.E0.getParameterCount();
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
        Class<?>[] parameterTypes = this.E0.getParameterTypes();
        if (i >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (n50.n(obj, y8.class)) {
            return Objects.equals(this.E0, ((y8) obj).E0);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.E0);
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
        Constructor constructor = this.E0;
        int parameterCount = constructor.getParameterCount();
        return String.format("[constructor for %s (%d arg%s), annotations: %s", n50.t(constructor.getDeclaringClass()), Integer.valueOf(parameterCount), parameterCount == 1 ? "" : "s", this.C0);
    }

    @Override // defpackage.xb5
    public final Class u() {
        return this.E0.getDeclaringClass();
    }

    @Override // defpackage.xb5
    public final nj4 x() {
        return this.B0.a(this.E0.getDeclaringClass());
    }
}
