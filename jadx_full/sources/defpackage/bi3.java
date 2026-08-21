package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bi3 extends ez1 {
    public static final bi3 Z = new bi3(0, new Object[0]);
    public final transient Object[] X;
    public final transient int Y;

    public bi3(int i, Object[] objArr) {
        super(0);
        this.X = objArr;
        this.Y = i;
    }

    @Override // defpackage.ez1, defpackage.bz1
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.X;
        int i = this.Y;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.bz1
    public final Object[] b() {
        return this.X;
    }

    @Override // defpackage.bz1
    public final int c() {
        return this.Y;
    }

    @Override // defpackage.bz1
    public final int d() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i) {
        co4.g(i, this.Y);
        Object obj = this.X[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.Y;
    }
}
