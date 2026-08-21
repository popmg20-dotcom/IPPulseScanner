package defpackage;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k42 implements ii4 {
    public static final j42 A;
    public static final j42 z;
    public final lb b;
    public final ConcurrentHashMap f = new ConcurrentHashMap();

    static {
        int i = 0;
        z = new j42(i);
        A = new j42(i);
    }

    public k42(lb lbVar) {
        this.b = lbVar;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        i42 i42Var = (i42) bk4Var.a.getAnnotation(i42.class);
        if (i42Var == null) {
            return null;
        }
        return b(this.b, iq1Var, bk4Var, i42Var, true);
    }

    public final hi4 b(lb lbVar, iq1 iq1Var, bk4 bk4Var, i42 i42Var, boolean z2) {
        hi4 hi4VarA;
        Object objA = lbVar.t(new bk4(i42Var.value()), true).a();
        boolean zNullSafe = i42Var.nullSafe();
        if (objA instanceof hi4) {
            hi4VarA = (hi4) objA;
        } else if (objA instanceof ii4) {
            ii4 ii4Var = (ii4) objA;
            if (z2) {
                ii4 ii4Var2 = (ii4) this.f.putIfAbsent(bk4Var.a, ii4Var);
                if (ii4Var2 != null) {
                    ii4Var = ii4Var2;
                }
            }
            hi4VarA = ii4Var.a(iq1Var, bk4Var);
        } else {
            if (!(objA instanceof t82)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + l72.a0(bk4Var.b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            kh4 kh4Var = new kh4((t82) objA, iq1Var, bk4Var, z2 ? z : A, zNullSafe);
            zNullSafe = false;
            hi4VarA = kh4Var;
        }
        return (hi4VarA == null || !zNullSafe) ? hi4VarA : hi4VarA.a();
    }
}
