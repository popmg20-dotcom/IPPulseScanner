package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sn1 extends a40 {
    public final Method A0;
    public final Method B0;
    public final Method C0;
    public final zs0 Y;
    public final Method Z;
    public final Method y0;
    public final boolean z0;

    public sn1(ft0 ft0Var, String str, Class cls, Class cls2, String str2) {
        super(ft0Var, str, cls, cls2, str2);
        this.Y = ft0Var.l();
        this.Z = yn1.y((Class) this.z, "valueOf", bt0.class);
        this.y0 = yn1.y((Class) this.z, "getValueDescriptor", new Class[0]);
        boolean zA = ft0Var.A();
        this.z0 = !zA;
        if (zA) {
            return;
        }
        this.A0 = yn1.y(cls, ha0.o("get", str, "Value"), new Class[0]);
        this.B0 = yn1.y(cls2, ha0.o("get", str, "Value"), new Class[0]);
        this.C0 = yn1.y(cls2, ha0.o("set", str, "Value"), Integer.TYPE);
    }

    @Override // defpackage.a40, defpackage.on1
    public final Object d(kn1 kn1Var) {
        if (this.z0) {
            return this.Y.j(((Integer) yn1.B(kn1Var, this.B0, new Object[0])).intValue());
        }
        return yn1.B(super.d(kn1Var), this.y0, new Object[0]);
    }

    @Override // defpackage.a40, defpackage.on1
    public final Object e(yn1 yn1Var) {
        if (this.z0) {
            return this.Y.j(((Integer) yn1.B(yn1Var, this.A0, new Object[0])).intValue());
        }
        return yn1.B(super.e(yn1Var), this.y0, new Object[0]);
    }

    @Override // defpackage.a40, defpackage.on1
    public final void j(kn1 kn1Var, Object obj) {
        if (this.z0) {
            yn1.B(kn1Var, this.C0, Integer.valueOf(((bt0) obj).z.Z));
        } else {
            super.j(kn1Var, yn1.B(null, this.Z, obj));
        }
    }
}
