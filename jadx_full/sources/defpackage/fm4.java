package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fm4 extends zs2 {
    @Override // defpackage.zs2, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        if (gt3Var.b.h(dt3.FAIL_ON_EMPTY_BEANS)) {
            o(gt3Var, obj);
            throw null;
        }
        super.e(obj, i52Var, gt3Var);
    }

    @Override // defpackage.zs2, defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        if (gt3Var.b.h(dt3.FAIL_ON_EMPTY_BEANS)) {
            o(gt3Var, obj);
            throw null;
        }
        super.f(obj, i52Var, gt3Var, zj4Var);
    }

    public final void o(gt3 gt3Var, Object obj) {
        Class<?> cls = obj.getClass();
        boolean zA = yo2.a(cls);
        Class cls2 = this.b;
        if (zA) {
            gt3Var.z(cls2, "No serializer found for class " + cls.getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS). This appears to be a native image, in which case you may need to configure reflection for the class that is to be serialized");
            throw null;
        }
        gt3Var.z(cls2, "No serializer found for class " + cls.getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)");
        throw null;
    }
}
