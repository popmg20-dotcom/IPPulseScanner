package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s51 implements Serializable {
    public static final k83 f = new k83("DAV:", "error");
    public final k83 b;

    static {
        new s51(new k83("DAV:", "need-privileges"));
        new s51(new k83("DAV:", "valid-sync-token"));
    }

    public s51(k83 k83Var) {
        k83Var.getClass();
        this.b = k83Var;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s51) && n12.c(((s51) obj).b, this.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
