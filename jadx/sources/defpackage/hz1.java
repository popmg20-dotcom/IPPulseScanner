package defpackage;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hz1 extends bz1 implements Set, j$.util.Set {
    public static final /* synthetic */ int X = 0;
    public transient ez1 A;

    public static int j(int i) {
        int iMax = Math.max(i, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
            return iHighestOneBit;
        }
        if (iMax < 1073741824) {
            return Pow2.MAX_POW2;
        }
        xe.k("collection too large");
        return 0;
    }

    public static hz1 k(int i, Object... objArr) {
        if (i == 0) {
            return hi3.C0;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new tx3(obj);
        }
        int iJ = j(i);
        Object[] objArr2 = new Object[iJ];
        int i2 = iJ - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            if (obj2 == null) {
                zo2.n(dw2.A(i5, "at index "));
                return null;
            }
            int iHashCode = obj2.hashCode();
            int iP = r25.P(iHashCode);
            while (true) {
                int i6 = iP & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iP++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new tx3(obj4);
        }
        if (j(i4) < iJ / 2) {
            return k(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new hi3(i3, i2, i4, objArr, objArr2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof hz1) && (this instanceof hi3) && (((hz1) obj) instanceof hi3) && ((hi3) this).Z != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        try {
            if (size() == set.size()) {
                return containsAll(set);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public ez1 i() {
        ez1 ez1Var = this.A;
        if (ez1Var != null) {
            return ez1Var;
        }
        ez1 ez1VarL = l();
        this.A = ez1VarL;
        return ez1VarL;
    }

    public ez1 l() {
        Object[] array = toArray(bz1.f);
        cz1 cz1Var = ez1.A;
        int length = array.length;
        return length == 0 ? bi3.Z : new bi3(length, array);
    }
}
