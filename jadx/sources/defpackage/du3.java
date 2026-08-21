package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class du3 extends wi1 {
    public final Object A;
    public final cy1 X;
    public final int Y;
    public final int Z;

    public du3(my1 my1Var, Size size, cy1 cy1Var) {
        super(my1Var);
        this.A = new Object();
        if (size == null) {
            this.Y = this.f.f();
            this.Z = this.f.c();
        } else {
            this.Y = size.getWidth();
            this.Z = size.getHeight();
        }
        this.X = cy1Var;
    }

    @Override // defpackage.wi1, defpackage.my1
    public final int c() {
        return this.Z;
    }

    @Override // defpackage.wi1, defpackage.my1
    public final int f() {
        return this.Y;
    }

    @Override // defpackage.wi1, defpackage.my1
    public final cy1 g0() {
        return this.X;
    }
}
