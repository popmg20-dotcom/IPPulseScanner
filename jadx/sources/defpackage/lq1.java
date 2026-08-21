package defpackage;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lq1 implements ParameterizedType, Serializable {
    public final Type b;
    public final Type f;
    public final Type[] z;

    public lq1(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            xe.k(dw2.B(cls, "Must specify owner type for "));
            throw null;
        }
        this.b = type != null ? l72.d(type) : null;
        this.f = l72.d(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.z = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Objects.requireNonNull(this.z[i]);
            l72.e(this.z[i]);
            Type[] typeArr3 = this.z;
            typeArr3[i] = l72.d(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && l72.k(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.z.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.z) ^ this.f.hashCode();
        Type type = this.b;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        Type[] typeArr = this.z;
        int length = typeArr.length;
        Type type = this.f;
        if (length == 0) {
            return l72.a0(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(l72.a0(type));
        sb.append("<");
        sb.append(l72.a0(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(l72.a0(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
