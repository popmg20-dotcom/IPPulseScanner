package defpackage;

import java.io.Serializable;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a80 implements cf0, Serializable {
    public final cf0 b;
    public final af0 f;

    public a80(af0 af0Var, cf0 cf0Var) {
        cf0Var.getClass();
        this.b = cf0Var;
        this.f = af0Var;
    }

    @Override // defpackage.cf0
    public final cf0 N(bf0 bf0Var) {
        bf0Var.getClass();
        af0 af0Var = this.f;
        af0 af0VarZ = af0Var.Z(bf0Var);
        cf0 cf0Var = this.b;
        if (af0VarZ != null) {
            return cf0Var;
        }
        cf0 cf0VarN = cf0Var.N(bf0Var);
        return cf0VarN == cf0Var ? this : cf0VarN == c41.b ? af0Var : new a80(af0Var, cf0VarN);
    }

    @Override // defpackage.cf0
    public final cf0 X(cf0 cf0Var) {
        cf0Var.getClass();
        return cf0Var == c41.b ? this : (cf0) cf0Var.c0(this, new dt(2));
    }

    @Override // defpackage.cf0
    public final af0 Z(bf0 bf0Var) {
        bf0Var.getClass();
        while (true) {
            af0 af0VarZ = this.f.Z(bf0Var);
            if (af0VarZ != null) {
                return af0VarZ;
            }
            cf0 cf0Var = this.b;
            if (!(cf0Var instanceof a80)) {
                return cf0Var.Z(bf0Var);
            }
            this = (a80) cf0Var;
        }
    }

    @Override // defpackage.cf0
    public final Object c0(Object obj, Function2 function2) {
        return function2.k(this.b.c0(obj, function2), this.f);
    }

    public final boolean equals(Object obj) {
        boolean zC;
        if (this == obj) {
            return true;
        }
        if (obj instanceof a80) {
            a80 a80Var = (a80) obj;
            int i = 2;
            a80 a80Var2 = a80Var;
            int i2 = 2;
            while (true) {
                cf0 cf0Var = a80Var2.b;
                a80Var2 = cf0Var instanceof a80 ? (a80) cf0Var : null;
                if (a80Var2 == null) {
                    break;
                }
                i2++;
            }
            a80 a80Var3 = this;
            while (true) {
                cf0 cf0Var2 = a80Var3.b;
                a80Var3 = cf0Var2 instanceof a80 ? (a80) cf0Var2 : null;
                if (a80Var3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                while (true) {
                    af0 af0Var = this.f;
                    if (!n12.c(a80Var.Z(af0Var.getKey()), af0Var)) {
                        zC = false;
                        break;
                    }
                    cf0 cf0Var3 = this.b;
                    if (!(cf0Var3 instanceof a80)) {
                        cf0Var3.getClass();
                        af0 af0Var2 = (af0) cf0Var3;
                        zC = n12.c(a80Var.Z(af0Var2.getKey()), af0Var2);
                        break;
                    }
                    this = (a80) cf0Var3;
                }
                if (zC) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode() + this.b.hashCode();
    }

    public final String toString() {
        return fw.x(new StringBuilder("["), (String) c0("", new dt(1)), ']');
    }
}
