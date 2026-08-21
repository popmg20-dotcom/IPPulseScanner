package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ez2 {
    public static final ez2 e;
    public final ArrayList a;
    public int b;
    public int c;
    public int d;

    static {
        hy2 hy2Var = hy2.g;
        hy2Var.getClass();
        e = new ez2(hy2Var.b, hy2Var.c, hy2Var.d);
    }

    public ez2(List list, int i, int i2) {
        list.getClass();
        this.a = new ArrayList(list);
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((lg4) it.next()).b.size();
        }
        this.b = size;
        this.c = i;
        this.d = i2;
    }

    public final yr4 a(int i) {
        ArrayList arrayList;
        int i2 = 0;
        int size = i - this.c;
        while (true) {
            arrayList = this.a;
            if (size < ((lg4) arrayList.get(i2)).b.size() || i2 >= e70.J(arrayList)) {
                break;
            }
            size -= ((lg4) arrayList.get(i2)).b.size();
            i2++;
        }
        return new yr4(((lg4) arrayList.get(i2)).c, size, i - this.c, ((f() - i) - this.d) - 1, d(), e());
    }

    public final Object b(int i) {
        if (i < 0 || i >= f()) {
            zo2.j(f(), dw2.D("Index: ", i, ", Size: "));
            return null;
        }
        int i2 = i - this.c;
        if (i2 < 0 || i2 >= this.b) {
            return null;
        }
        return c(i2);
    }

    public final Object c(int i) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            int size2 = ((lg4) arrayList.get(i2)).b.size();
            if (size2 > i) {
                break;
            }
            i -= size2;
            i2++;
        }
        return ((lg4) arrayList.get(i2)).b.get(i);
    }

    public final int d() {
        Integer numValueOf;
        int[] iArr = ((lg4) d70.d0(this.a)).a;
        if (iArr.length == 0) {
            numValueOf = null;
        } else {
            int i = iArr[0];
            int i2 = 1;
            int length = iArr.length - 1;
            if (1 <= length) {
                while (true) {
                    int i3 = iArr[i2];
                    if (i > i3) {
                        i = i3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            numValueOf = Integer.valueOf(i);
        }
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    public final int e() {
        Integer numValueOf;
        int[] iArr = ((lg4) d70.k0(this.a)).a;
        if (iArr.length == 0) {
            numValueOf = null;
        } else {
            int i = iArr[0];
            int i2 = 1;
            int length = iArr.length - 1;
            if (1 <= length) {
                while (true) {
                    int i3 = iArr[i2];
                    if (i < i3) {
                        i = i3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            numValueOf = Integer.valueOf(i);
        }
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    public final int f() {
        return this.c + this.b + this.d;
    }

    public final ke0 g(jy2 jy2Var) {
        jy2Var.getClass();
        boolean z = jy2Var instanceof hy2;
        ArrayList arrayList = this.a;
        if (!z) {
            if (!(jy2Var instanceof gy2)) {
                xe.q("Paging received an event to process StaticList or LoadStateUpdate while\nprocessing Inserts and Drops. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
                return null;
            }
            b12 b12Var = new b12(0, 0, 1);
            Iterator it = arrayList.iterator();
            int size = 0;
            while (it.hasNext()) {
                lg4 lg4Var = (lg4) it.next();
                int[] iArr = lg4Var.a;
                int length = iArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        int i2 = iArr[i];
                        if (b12Var.b <= i2 && i2 <= b12Var.f) {
                            size += lg4Var.b.size();
                            it.remove();
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            int i3 = this.b - size;
            this.b = i3;
            int i4 = this.d;
            this.d = 0;
            return new nz2(this.c + i3, size, 0, i4);
        }
        hy2 hy2Var = (hy2) jy2Var;
        List list = hy2Var.b;
        Iterator it2 = list.iterator();
        int size2 = 0;
        while (it2.hasNext()) {
            size2 += ((lg4) it2.next()).b.size();
        }
        int iOrdinal = hy2Var.a.ordinal();
        if (iOrdinal == 0) {
            xe.q("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
            return null;
        }
        if (iOrdinal == 1) {
            int i5 = this.c;
            arrayList.addAll(0, list);
            this.b += size2;
            this.c = hy2Var.c;
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                d70.U(((lg4) it3.next()).b, arrayList2);
            }
            return new pz2(arrayList2, this.c, i5);
        }
        if (iOrdinal != 2) {
            g.d();
            return null;
        }
        int i6 = this.d;
        int i7 = this.b;
        arrayList.addAll(arrayList.size(), list);
        this.b += size2;
        this.d = hy2Var.d;
        int i8 = this.c + i7;
        ArrayList arrayList3 = new ArrayList();
        Iterator it4 = list.iterator();
        while (it4.hasNext()) {
            d70.U(((lg4) it4.next()).b, arrayList3);
        }
        return new mz2(i8, arrayList3, this.d, i6);
    }

    public final String toString() {
        int i = this.b;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(c(i2));
        }
        String strJ0 = d70.j0(arrayList, null, null, null, null, 63);
        StringBuilder sb = new StringBuilder("[(");
        sb.append(this.c);
        sb.append(" placeholders), ");
        sb.append(strJ0);
        sb.append(", (");
        return fw.w(" placeholders)]", sb, this.d);
    }
}
