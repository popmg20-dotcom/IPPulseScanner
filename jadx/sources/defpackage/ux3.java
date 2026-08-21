package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ux3 extends n1 implements yr {
    public final qo2 b;

    public ux3(o1 o1Var) {
        Objects.requireNonNull(o1Var, "No factory");
        this.b = o1Var;
        Objects.requireNonNull((n1) o1Var.a(), "No random instance created");
    }

    @Override // defpackage.nw2
    public final boolean g() {
        qo2 qo2Var = this.b;
        if (qo2Var instanceof nw2) {
            return ((nw2) qo2Var).g();
        }
        return true;
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b.getName();
    }

    @Override // defpackage.va1
    public final Object a() {
        return this;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this;
    }
}
