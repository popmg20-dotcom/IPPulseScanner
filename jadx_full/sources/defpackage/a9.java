package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a9 extends c9 {
    public final transient Field D0;

    public a9(yj4 yj4Var, Field field, cp1 cp1Var) {
        super(yj4Var, cp1Var);
        this.D0 = field;
    }

    @Override // defpackage.c9
    public final Class O() {
        return this.D0.getDeclaringClass();
    }

    @Override // defpackage.c9
    public final Member Q() {
        return this.D0;
    }

    @Override // defpackage.c9
    public final Object R(Object obj) {
        try {
            return this.D0.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed to getValue() for field " + this.P() + ": " + e.getMessage(), e);
        }
    }

    @Override // defpackage.c9
    public final xb5 T(cp1 cp1Var) {
        return new a9(this.B0, this.D0, cp1Var);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (n50.n(obj, a9.class)) {
            return this.D0.equals(((a9) obj).D0);
        }
        return false;
    }

    public final int hashCode() {
        return this.D0.hashCode();
    }

    @Override // defpackage.xb5
    public final int p() {
        return this.D0.getModifiers();
    }

    @Override // defpackage.xb5
    public final String q() {
        return this.D0.getName();
    }

    public final String toString() {
        return "[field " + P() + "]";
    }

    @Override // defpackage.xb5
    public final Class u() {
        return this.D0.getType();
    }

    @Override // defpackage.xb5
    public final nj4 x() {
        return this.B0.a(this.D0.getGenericType());
    }
}
