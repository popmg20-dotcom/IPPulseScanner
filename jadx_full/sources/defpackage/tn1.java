package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tn1 extends a40 {
    public final Method Y;
    public final Method Z;

    public tn1(ft0 ft0Var, String str, Class cls, Class cls2, String str2) {
        super(ft0Var, str, cls, cls2, str2);
        this.Y = yn1.y((Class) this.z, "newBuilder", new Class[0]);
        this.Z = yn1.y(cls2, ha0.o("get", str, "Builder"), new Class[0]);
    }

    @Override // defpackage.a40, defpackage.on1
    public final a1 h() {
        return (a1) yn1.B(null, this.Y, new Object[0]);
    }

    @Override // defpackage.a40, defpackage.on1
    public final void j(kn1 kn1Var, Object obj) {
        if (!((Class) this.z).isInstance(obj)) {
            obj = ((a1) yn1.B(null, this.Y, new Object[0])).x((c1) obj).q();
        }
        super.j(kn1Var, obj);
    }

    @Override // defpackage.a40, defpackage.on1
    public final a1 o(kn1 kn1Var) {
        return (a1) yn1.B(kn1Var, this.Z, new Object[0]);
    }
}
