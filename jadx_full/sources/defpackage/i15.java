package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i15 extends o15 {
    public final transient o15 X;

    public i15(o15 o15Var) {
        super(1);
        this.X = o15Var;
    }

    @Override // defpackage.o15, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.X.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        o15 o15Var = this.X;
        vf2.F(i, o15Var.size());
        return o15Var.get((o15Var.size() - 1) - i);
    }

    @Override // defpackage.o15
    public final o15 i() {
        return this.X;
    }

    @Override // defpackage.o15, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.X.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (r1.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // defpackage.o15, java.util.List
    /* JADX INFO: renamed from: j */
    public final o15 subList(int i, int i2) {
        o15 o15Var = this.X;
        vf2.G(i, i2, o15Var.size());
        return o15Var.subList(o15Var.size() - i2, o15Var.size() - i).i();
    }

    @Override // defpackage.o15, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.X.indexOf(obj);
        if (iIndexOf >= 0) {
            return (r1.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.X.size();
    }
}
