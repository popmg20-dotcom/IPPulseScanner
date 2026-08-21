package defpackage;

import j$.util.Objects;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v54 implements s54, Serializable {
    public final Object b;

    public v54(Object obj) {
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v54) {
            return this.b.equals(((v54) obj).b);
        }
        return false;
    }

    @Override // defpackage.s54
    public final Object get() {
        return this.b;
    }

    public final int hashCode() {
        return Objects.hash(this.b);
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.b + ")";
    }
}
