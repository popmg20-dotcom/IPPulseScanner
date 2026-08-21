package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m15 extends o15 {
    public final transient int X;
    public final transient int Y;
    public final /* synthetic */ o15 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m15(o15 o15Var, int i, int i2) {
        super(1);
        this.Z = o15Var;
        this.X = i;
        this.Y = i2;
    }

    @Override // defpackage.bz1
    public final Object[] e() {
        return this.Z.e();
    }

    @Override // defpackage.bz1
    public final int f() {
        return this.Z.f() + this.X;
    }

    @Override // defpackage.bz1
    public final int g() {
        return this.Z.f() + this.X + this.Y;
    }

    @Override // java.util.List
    public final Object get(int i) {
        vf2.F(i, this.Y);
        return this.Z.get(i + this.X);
    }

    @Override // defpackage.o15, java.util.List
    /* JADX INFO: renamed from: j */
    public final o15 subList(int i, int i2) {
        vf2.G(i, i2, this.Y);
        int i3 = this.X;
        return this.Z.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.Y;
    }
}
