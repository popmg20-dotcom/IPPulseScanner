package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pd4 implements af0 {
    public final Object b;
    public final ThreadLocal f;
    public final rd4 z;

    public pd4(Object obj, ThreadLocal threadLocal) {
        this.b = obj;
        this.f = threadLocal;
        this.z = new rd4(threadLocal);
    }

    @Override // defpackage.cf0
    public final cf0 N(bf0 bf0Var) {
        return this.z.equals(bf0Var) ? c41.b : this;
    }

    @Override // defpackage.cf0
    public final cf0 X(cf0 cf0Var) {
        return tj4.W(this, cf0Var);
    }

    @Override // defpackage.cf0
    public final af0 Z(bf0 bf0Var) {
        if (this.z.equals(bf0Var)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.cf0
    public final Object c0(Object obj, Function2 function2) {
        return function2.k(obj, this);
    }

    @Override // defpackage.af0
    public final bf0 getKey() {
        return this.z;
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.b + ", threadLocal = " + this.f + ')';
    }
}
