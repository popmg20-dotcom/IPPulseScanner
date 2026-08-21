package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jw4 extends s0 {
    public final int A;
    public final int X;
    public final c03 Y;
    public final /* synthetic */ lw4 Z;
    public final int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw4(lw4 lw4Var, u0 u0Var, int i, int i2, int i3) {
        super(lw4Var, u0Var);
        this.Z = lw4Var;
        this.z = i2;
        this.X = i;
        this.A = i3;
        c03 c03Var = new c03(lw4Var.b.A1);
        this.Y = c03Var;
        c03Var.set(lw4Var.b.getTextPaint());
        c03Var.b();
    }

    @Override // defpackage.s0
    public final Object a() {
        ArrayList arrayList = new ArrayList();
        this.Z.f.y(this.z, this.A, new ed(20, this, arrayList));
        kw4 kw4Var = new kw4();
        kw4Var.b = this.X;
        kw4Var.f = arrayList;
        return kw4Var;
    }
}
