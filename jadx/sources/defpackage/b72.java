package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b72 {
    public abstract Class b();

    public boolean c(gt3 gt3Var, Object obj) {
        return false;
    }

    public boolean d() {
        return this instanceof an4;
    }

    public abstract void e(Object obj, i52 i52Var, gt3 gt3Var);

    public void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        Class<?> clsB = b();
        if (clsB == null) {
            clsB = obj.getClass();
        }
        gt3Var.z(clsB, fw.v("Type id handling not implemented for type ", clsB.getName(), " (by serializer of type ", getClass().getName(), ")"));
        throw null;
    }

    public boolean h() {
        return false;
    }

    public b72 g(po2 po2Var) {
        return this;
    }

    public b72 i(Set set) {
        return this;
    }
}
