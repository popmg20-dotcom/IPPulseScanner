package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hi3 extends hz1 {
    public static final Object[] B0;
    public static final hi3 C0;
    public final transient int A0;
    public final transient Object[] Y;
    public final transient int Z;
    public final transient Object[] y0;
    public final transient int z0;

    static {
        Object[] objArr = new Object[0];
        B0 = objArr;
        C0 = new hi3(0, 0, 0, objArr, objArr);
    }

    public hi3(int i, int i2, int i3, Object[] objArr, Object[] objArr2) {
        super(0);
        this.Y = objArr;
        this.Z = i;
        this.y0 = objArr2;
        this.z0 = i2;
        this.A0 = i3;
    }

    @Override // defpackage.bz1
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.Y;
        int i = this.A0;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.bz1
    public final Object[] b() {
        return this.Y;
    }

    @Override // defpackage.bz1
    public final int c() {
        return this.A0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Object[] objArr = this.y0;
        if (objArr.length == 0) {
            return false;
        }
        int iP = r25.P(obj.hashCode());
        while (true) {
            int i = iP & this.z0;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iP = i + 1;
        }
    }

    @Override // defpackage.bz1
    public final int d() {
        return 0;
    }

    @Override // defpackage.hz1, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.Z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return i().listIterator(0);
    }

    @Override // defpackage.hz1
    public final ez1 l() {
        cz1 cz1Var = ez1.A;
        int i = this.A0;
        return i == 0 ? bi3.Z : new bi3(i, this.Y);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.A0;
    }
}
