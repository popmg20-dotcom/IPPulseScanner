package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fi3 extends ez1 {
    public final transient Object[] X;
    public final transient int Y;
    public final transient int Z;

    public fi3(Object[] objArr, int i, int i2) {
        super(0);
        this.X = objArr;
        this.Y = i;
        this.Z = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        co4.g(i, this.Z);
        Object obj = this.X[(i * 2) + this.Y];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.Z;
    }
}
