package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dz2 {
    public final ue2 a;
    public final ArrayList b;
    public final ArrayList c;
    public int d;
    public int e;
    public int f;
    public final xp g;
    public final xp h;
    public final LinkedHashMap i;
    public final n02 j;

    public dz2(ue2 ue2Var) {
        this.a = ue2Var;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = arrayList;
        this.g = uf2.a(-1, null, null, 6);
        this.h = uf2.a(-1, null, null, 6);
        this.i = new LinkedHashMap();
        n02 n02Var = new n02(10);
        n02Var.N(hd2.b, dd2.b);
        this.j = n02Var;
    }

    public final b03 a(yr4 yr4Var) {
        Integer numValueOf;
        ArrayList arrayList = this.c;
        List listY0 = d70.y0(arrayList);
        if (yr4Var != null) {
            int i = yr4Var.e;
            int size = this.e;
            int i2 = -this.d;
            int size2 = (arrayList.size() - 1) - this.d;
            int i3 = i2;
            while (i3 < i) {
                size += i3 > size2 ? 100 : ((zz2) arrayList.get(this.d + i3)).b.size();
                i3++;
            }
            int i4 = size + yr4Var.f;
            if (i < i2) {
                i4 -= 100;
            }
            numValueOf = Integer.valueOf(i4);
        } else {
            numValueOf = null;
        }
        return new b03(listY0, numValueOf, this.a, this.e);
    }

    public final boolean b(int i, hd2 hd2Var, zz2 zz2Var) {
        hd2Var.getClass();
        zz2Var.getClass();
        int i2 = zz2Var.A;
        List list = zz2Var.b;
        int i3 = zz2Var.X;
        int iOrdinal = hd2Var.ordinal();
        ArrayList arrayList = this.b;
        ArrayList arrayList2 = this.c;
        if (iOrdinal == 0) {
            if (!arrayList2.isEmpty()) {
                xe.q("cannot receive multiple init calls");
                return false;
            }
            if (i != 0) {
                xe.q("init loadId must be the initial value, 0");
                return false;
            }
            arrayList.add(zz2Var);
            this.d = 0;
            if (i3 == Integer.MIN_VALUE) {
                i3 = 0;
            }
            this.f = i3;
            if (i2 == Integer.MIN_VALUE) {
                i2 = 0;
            }
            this.e = i2;
            return true;
        }
        LinkedHashMap linkedHashMap = this.i;
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                g.d();
                return false;
            }
            if (arrayList2.isEmpty()) {
                xe.q("should've received an init before append");
                return false;
            }
            if (i == 0) {
                arrayList.add(zz2Var);
                if (i3 == Integer.MIN_VALUE) {
                    int size = this.f - list.size();
                    i3 = size < 0 ? 0 : size;
                }
                this.f = i3 != Integer.MIN_VALUE ? i3 : 0;
                linkedHashMap.remove(hd2.z);
                return true;
            }
        } else {
            if (arrayList2.isEmpty()) {
                xe.q("should've received an init before prepend");
                return false;
            }
            if (i == 0) {
                arrayList.add(0, zz2Var);
                this.d++;
                if (i2 == Integer.MIN_VALUE) {
                    int size2 = this.e - list.size();
                    i2 = size2 < 0 ? 0 : size2;
                }
                this.e = i2 != Integer.MIN_VALUE ? i2 : 0;
                linkedHashMap.remove(hd2.f);
                return true;
            }
        }
        return false;
    }

    public final hy2 c(zz2 zz2Var, hd2 hd2Var) {
        zz2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        int size = 0;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                size = 0 - this.d;
            } else {
                if (iOrdinal != 2) {
                    g.d();
                    return null;
                }
                size = (this.c.size() - this.d) - 1;
            }
        }
        List listX = p95.x(new lg4(size, zz2Var.b));
        int iOrdinal2 = hd2Var.ordinal();
        n02 n02Var = this.j;
        if (iOrdinal2 == 0) {
            hy2 hy2Var = hy2.g;
            return new hy2(hd2.b, listX, this.e, this.f, n02Var.O(), null);
        }
        if (iOrdinal2 == 1) {
            hy2 hy2Var2 = hy2.g;
            return new hy2(hd2.f, listX, this.e, -1, n02Var.O(), null);
        }
        if (iOrdinal2 != 2) {
            g.d();
            return null;
        }
        hy2 hy2Var3 = hy2.g;
        return new hy2(hd2.z, listX, -1, this.f, n02Var.O(), null);
    }
}
