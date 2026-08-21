package defpackage;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kq1 implements GenericArrayType, Serializable {
    public final Type b;

    public kq1(Type type) {
        Objects.requireNonNull(type);
        this.b = l72.d(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && l72.k(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.b;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return l72.a0(this.b) + "[]";
    }
}
