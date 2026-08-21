package defpackage;

import j$.util.Objects;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class bk4<T> {
    public final Class a;
    public final Type b;
    public final int c;

    public bk4(Type type) {
        Objects.requireNonNull(type);
        Type typeD = l72.d(type);
        this.b = typeD;
        this.a = l72.B(typeD);
        this.c = typeD.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bk4) {
            return l72.k(this.b, ((bk4) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return l72.a0(this.b);
    }
}
