package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u15 extends o15 {
    public static final u15 Z = new u15(0, new Object[0]);
    public final transient Object[] X;
    public final transient int Y;

    public u15(int i, Object[] objArr) {
        super(1);
        this.X = objArr;
        this.Y = i;
    }

    @Override // defpackage.bz1
    public final Object[] e() {
        return this.X;
    }

    @Override // defpackage.bz1
    public final int f() {
        return 0;
    }

    @Override // defpackage.bz1
    public final int g() {
        return this.Y;
    }

    @Override // java.util.List
    public final Object get(int i) {
        vf2.F(i, this.Y);
        Object obj = this.X[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // defpackage.o15, defpackage.bz1
    public final int h(Object[] objArr) {
        Object[] objArr2 = this.X;
        int i = this.Y;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.Y;
    }
}
