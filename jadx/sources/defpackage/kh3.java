package defpackage;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kh3 extends jh3 {
    public final st2 b;

    public kh3(st2 st2Var, lh3 lh3Var) {
        super(lh3Var);
        this.b = st2Var;
    }

    @Override // defpackage.jh3
    public final Object d() {
        return this.b.a();
    }

    @Override // defpackage.jh3
    public final void f(Object obj, r62 r62Var, ih3 ih3Var) throws IllegalAccessException {
        Field field = ih3Var.b;
        Object objB = ih3Var.f.b(r62Var);
        if (objB == null && ih3Var.g) {
            return;
        }
        if (ih3Var.h) {
            throw new l52("Cannot set value of 'static final' ".concat(hh3.d(field, false)));
        }
        field.set(obj, objB);
    }

    @Override // defpackage.jh3
    public final Object e(Object obj) {
        return obj;
    }
}
