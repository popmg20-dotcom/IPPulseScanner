package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ei3 extends hz1 {
    public final transient gz1 Y;
    public final transient fi3 Z;

    public ei3(gz1 gz1Var, fi3 fi3Var) {
        super(0);
        this.Y = gz1Var;
        this.Z = fi3Var;
    }

    @Override // defpackage.bz1
    public final int a(Object[] objArr) {
        return this.Z.a(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.Y.get(obj) != null;
    }

    @Override // defpackage.hz1
    public final ez1 i() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final hm4 iterator() {
        return this.Z.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return ((gi3) this.Y).Y;
    }
}
