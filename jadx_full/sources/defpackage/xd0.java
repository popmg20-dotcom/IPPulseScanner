package defpackage;

import j$.util.Objects;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xd0 implements Serializable {
    public final transient Object b;

    static {
        new xd0();
        new xd0();
    }

    public xd0(me2 me2Var, qv qvVar) {
        this.b = me2Var;
        qvVar.getClass();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof xd0)) {
            return false;
        }
        Object obj2 = ((xd0) obj).b;
        Object obj3 = this.b;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return ((obj3 instanceof File) || (obj3 instanceof URL) || (obj3 instanceof URI)) ? obj3.equals(obj2) : obj3 == obj2;
    }

    public final int hashCode() {
        return Objects.hashCode(this.b);
    }

    public xd0() {
        this(null, qv.f);
    }
}
