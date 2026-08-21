package defpackage;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dz1 extends ez1 {
    public final transient int X;
    public final transient int Y;
    public final /* synthetic */ ez1 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz1(ez1 ez1Var, int i, int i2) {
        super(0);
        this.Z = ez1Var;
        this.X = i;
        this.Y = i2;
    }

    @Override // defpackage.bz1
    public final Object[] b() {
        return this.Z.b();
    }

    @Override // defpackage.bz1
    public final int c() {
        return this.Z.d() + this.X + this.Y;
    }

    @Override // defpackage.bz1
    public final int d() {
        return this.Z.d() + this.X;
    }

    @Override // java.util.List
    public final Object get(int i) {
        co4.g(i, this.Y);
        return this.Z.get(i + this.X);
    }

    @Override // defpackage.ez1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // defpackage.ez1, java.util.List
    /* JADX INFO: renamed from: j */
    public final ez1 subList(int i, int i2) {
        co4.j(i, i2, this.Y);
        int i3 = this.X;
        return this.Z.subList(i + i3, i2 + i3);
    }

    @Override // defpackage.ez1, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.Y;
    }

    @Override // defpackage.ez1, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }
}
