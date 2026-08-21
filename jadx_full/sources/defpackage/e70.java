package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class e70 extends p95 {
    public static b12 I(Collection collection) {
        collection.getClass();
        return new b12(0, collection.size() - 1, 1);
    }

    public static int J(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static List K(Object... objArr) {
        if (objArr.length <= 0) {
            return g41.b;
        }
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        return listAsList;
    }

    public static ArrayList L(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new yd(objArr, true));
    }

    public static final List M(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : p95.x(list.get(0)) : g41.b;
    }

    public static final void N(int i, int i2) {
        if (i2 < 0) {
            xe.k(ha0.k("fromIndex (0) is greater than toIndex (", i2, ")."));
            return;
        }
        if (i2 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i + ").");
    }

    public static void O() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void P() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
