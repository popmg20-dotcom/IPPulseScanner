package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class un1 extends a40 {
    public final Method Y;

    public un1(ft0 ft0Var, String str, Class cls, Class cls2, String str2) {
        super(ft0Var, str, cls, cls2, str2);
        yn1.y(cls, ha0.o("get", str, "Bytes"), new Class[0]);
        this.Y = yn1.y(cls2, ha0.o("set", str, "Bytes"), zt.class);
    }

    @Override // defpackage.a40, defpackage.on1
    public final void j(kn1 kn1Var, Object obj) {
        if (obj instanceof zt) {
            yn1.B(kn1Var, this.Y, obj);
        } else {
            super.j(kn1Var, obj);
        }
    }
}
