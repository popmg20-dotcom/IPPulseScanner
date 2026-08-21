package defpackage;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mq1 implements WildcardType, Serializable {
    public final Type b;
    public final Type f;

    public mq1(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            xe.k("At most one lower bound is supported");
            throw null;
        }
        if (typeArr.length != 1) {
            xe.k("Exactly one upper bound must be specified");
            throw null;
        }
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            l72.e(typeArr[0]);
            this.f = null;
            this.b = l72.d(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        l72.e(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            xe.k("When lower bound is specified, upper bound must be Object");
            throw null;
        }
        this.f = l72.d(typeArr2[0]);
        this.b = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && l72.k(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f;
        return type != null ? new Type[]{type} : l72.b;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.b};
    }

    public final int hashCode() {
        Type type = this.f;
        return (this.b.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.f;
        if (type != null) {
            return "? super " + l72.a0(type);
        }
        Type type2 = this.b;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + l72.a0(type2);
    }
}
