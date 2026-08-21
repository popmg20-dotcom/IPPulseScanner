package defpackage;

import j$.util.DesugarCollections;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qn1 extends eg0 {
    public final zs0 A;
    public final Method A0;
    public final Method X;
    public final Method Y;
    public final boolean Z;
    public final Method y0;
    public final Method z0;

    public qn1(ft0 ft0Var, String str, Class cls, Class cls2) {
        super(cls, cls2, str);
        this.A = ft0Var.l();
        this.X = yn1.y((Class) this.f, "valueOf", bt0.class);
        this.Y = yn1.y((Class) this.f, "getValueDescriptor", new Class[0]);
        boolean zA = ft0Var.A();
        this.Z = !zA;
        if (zA) {
            return;
        }
        String strO = ha0.o("get", str, "Value");
        Class cls3 = Integer.TYPE;
        this.y0 = yn1.y(cls, strO, cls3);
        this.z0 = yn1.y(cls2, ha0.o("get", str, "Value"), cls3);
        yn1.y(cls2, ha0.o("set", str, "Value"), cls3, cls3);
        this.A0 = yn1.y(cls2, ha0.o("add", str, "Value"), cls3);
    }

    @Override // defpackage.eg0, defpackage.on1
    public final Object d(kn1 kn1Var) {
        ArrayList arrayList = new ArrayList();
        j80 j80Var = (j80) this.z;
        int iIntValue = ((Integer) yn1.B(kn1Var, (Method) j80Var.g, new Object[0])).intValue();
        for (int i = 0; i < iIntValue; i++) {
            arrayList.add(this.Z ? this.A.j(((Integer) yn1.B(kn1Var, this.z0, Integer.valueOf(i))).intValue()) : yn1.B(yn1.B(kn1Var, (Method) j80Var.d, Integer.valueOf(i)), this.Y, new Object[0]));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    @Override // defpackage.eg0, defpackage.on1
    public final Object e(yn1 yn1Var) {
        ArrayList arrayList = new ArrayList();
        j80 j80Var = (j80) this.z;
        int iIntValue = ((Integer) yn1.B(yn1Var, (Method) j80Var.f, new Object[0])).intValue();
        for (int i = 0; i < iIntValue; i++) {
            arrayList.add(this.Z ? this.A.j(((Integer) yn1.B(yn1Var, this.y0, Integer.valueOf(i))).intValue()) : yn1.B(yn1.B(yn1Var, (Method) j80Var.c, Integer.valueOf(i)), this.Y, new Object[0]));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    @Override // defpackage.eg0, defpackage.on1
    public final void l(kn1 kn1Var, Object obj) {
        if (this.Z) {
            yn1.B(kn1Var, this.A0, Integer.valueOf(((bt0) obj).z.Z));
        } else {
            super.l(kn1Var, yn1.B(null, this.X, obj));
        }
    }
}
