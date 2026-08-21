package defpackage;

import j$.util.Objects;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uo2 implements Serializable {
    public final Class b;
    public final int f;
    public final String z;

    public uo2(Class cls, String str) {
        this.b = cls;
        this.f = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        this.z = (str == null || str.isEmpty()) ? null : str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != uo2.class) {
            return false;
        }
        uo2 uo2Var = (uo2) obj;
        return this.b == uo2Var.b && Objects.equals(this.z, uo2Var.z);
    }

    public final int hashCode() {
        return this.f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[NamedType, class ");
        sb.append(this.b.getName());
        sb.append(", name: ");
        String str = this.z;
        return fw.y(sb, str == null ? "null" : fw.y(new StringBuilder("'"), str, "'"), "]");
    }
}
