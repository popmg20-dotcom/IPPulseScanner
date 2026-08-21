package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rn1 extends eg0 {
    public final Method A;

    public rn1(Class cls, Class cls2, String str) {
        super(cls, cls2, str);
        this.A = yn1.y((Class) this.f, "newBuilder", new Class[0]);
        yn1.y(cls2, ha0.o("get", str, "Builder"), Integer.TYPE);
    }

    @Override // defpackage.eg0, defpackage.on1
    public final a1 h() {
        return (a1) yn1.B(null, this.A, new Object[0]);
    }

    @Override // defpackage.eg0, defpackage.on1
    public final void l(kn1 kn1Var, Object obj) {
        if (!((Class) this.f).isInstance(obj)) {
            obj = ((a1) yn1.B(null, this.A, new Object[0])).x((c1) obj).p();
        }
        super.l(kn1Var, obj);
    }
}
