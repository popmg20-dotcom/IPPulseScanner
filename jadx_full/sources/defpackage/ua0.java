package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ua0 implements af0 {
    public static final d7 f = new d7(14);
    public final z13 b;

    public ua0(z13 z13Var) {
        z13Var.getClass();
        this.b = z13Var;
    }

    @Override // defpackage.cf0
    public final cf0 N(bf0 bf0Var) {
        return tj4.P(this, bf0Var);
    }

    @Override // defpackage.cf0
    public final cf0 X(cf0 cf0Var) {
        return tj4.W(this, cf0Var);
    }

    @Override // defpackage.cf0
    public final af0 Z(bf0 bf0Var) {
        return tj4.A(this, bf0Var);
    }

    @Override // defpackage.cf0
    public final Object c0(Object obj, Function2 function2) {
        return function2.k(obj, this);
    }

    @Override // defpackage.af0
    public final bf0 getKey() {
        return f;
    }
}
