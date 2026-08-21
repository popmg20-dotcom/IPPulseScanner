package defpackage;

import java.io.Serializable;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j51 extends z0 implements i51, RandomAccess, Serializable {
    public final Enum[] b;

    public j51(Enum[] enumArr) {
        enumArr.getClass();
        this.b = enumArr;
    }

    @Override // defpackage.g0
    public final int a() {
        return this.b.length;
    }

    @Override // defpackage.g0, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r3 = (Enum) obj;
        return ((Enum) qe.m0(r3.ordinal(), this.b)) == r3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.b;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        s53.k(fw.s(i, length, "index: ", ", size: "));
        return null;
    }

    @Override // defpackage.z0, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (((Enum) qe.m0(iOrdinal, this.b)) == r3) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // defpackage.z0, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (((Enum) qe.m0(iOrdinal, this.b)) == r3) {
            return iOrdinal;
        }
        return -1;
    }
}
