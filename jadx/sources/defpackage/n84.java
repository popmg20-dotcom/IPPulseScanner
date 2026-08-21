package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n84 implements z82, Serializable {
    public pl1 b;
    public volatile Object f;
    public final Object z;

    public n84(pl1 pl1Var) {
        pl1Var.getClass();
        this.b = pl1Var;
        this.f = vd3.y0;
        this.z = this;
    }

    @Override // defpackage.z82
    public final boolean c() {
        return this.f != vd3.y0;
    }

    @Override // defpackage.z82
    public final Object getValue() {
        Object objA;
        Object obj = this.f;
        vd3 vd3Var = vd3.y0;
        if (obj != vd3Var) {
            return obj;
        }
        synchronized (this.z) {
            objA = this.f;
            if (objA == vd3Var) {
                pl1 pl1Var = this.b;
                pl1Var.getClass();
                objA = pl1Var.a();
                this.f = objA;
                this.b = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return c() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
