package defpackage;

import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class u03 implements Comparable {
    public static final String f;
    public final bu b;

    static {
        String str = File.separator;
        str.getClass();
        f = str;
    }

    public u03(bu buVar) {
        buVar.getClass();
        this.b = buVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iC = f.c(this);
        bu buVar = this.b;
        if (iC == -1) {
            iC = 0;
        } else if (iC < buVar.d() && buVar.i(iC) == 92) {
            iC++;
        }
        int iD = buVar.d();
        int i = iC;
        while (iC < iD) {
            if (buVar.i(iC) == 47 || buVar.i(iC) == 92) {
                arrayList.add(buVar.o(i, iC));
                i = iC + 1;
            }
            iC++;
        }
        if (i < buVar.d()) {
            arrayList.add(buVar.o(i, buVar.d()));
        }
        return arrayList;
    }

    public final u03 b() {
        bu buVar = f.d;
        bu buVar2 = this.b;
        if (n12.c(buVar2, buVar)) {
            return null;
        }
        bu buVar3 = f.a;
        if (n12.c(buVar2, buVar3)) {
            return null;
        }
        bu buVar4 = f.b;
        if (n12.c(buVar2, buVar4)) {
            return null;
        }
        bu buVar5 = f.e;
        buVar2.getClass();
        buVar5.getClass();
        int iD = buVar2.d();
        byte[] bArr = buVar5.b;
        if (buVar2.m(iD - bArr.length, buVar5, bArr.length) && (buVar2.d() == 2 || buVar2.m(buVar2.d() - 3, buVar3, 1) || buVar2.m(buVar2.d() - 3, buVar4, 1))) {
            return null;
        }
        int iK = bu.k(buVar2, buVar3);
        if (iK == -1) {
            iK = bu.k(buVar2, buVar4);
        }
        if (iK == 2 && e() != null) {
            if (buVar2.d() == 3) {
                return null;
            }
            return new u03(bu.p(buVar2, 0, 3, 1));
        }
        if (iK == 1) {
            buVar4.getClass();
            if (buVar2.m(0, buVar4, buVar4.d())) {
                return null;
            }
        }
        if (iK != -1 || e() == null) {
            return iK == -1 ? new u03(buVar) : iK == 0 ? new u03(bu.p(buVar2, 0, 1, 1)) : new u03(bu.p(buVar2, 0, iK, 1));
        }
        if (buVar2.d() == 2) {
            return null;
        }
        return new u03(bu.p(buVar2, 0, 2, 1));
    }

    public final u03 c(u03 u03Var) {
        u03Var.getClass();
        bu buVar = u03Var.b;
        int iC = f.c(this);
        bu buVar2 = this.b;
        u03 u03Var2 = iC == -1 ? null : new u03(buVar2.o(0, iC));
        int iC2 = f.c(u03Var);
        if (!n12.c(u03Var2, iC2 != -1 ? new u03(buVar.o(0, iC2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + u03Var).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = u03Var.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i = 0;
        while (i < iMin && n12.c(arrayListA.get(i), arrayListA2.get(i))) {
            i++;
        }
        if (i == iMin && buVar2.d() == buVar.d()) {
            return pr1.q(".");
        }
        if (arrayListA2.subList(i, arrayListA2.size()).indexOf(f.e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + u03Var).toString());
        }
        if (n12.c(buVar, f.d)) {
            return this;
        }
        hp hpVar = new hp();
        bu buVarB = f.b(u03Var);
        if (buVarB == null && (buVarB = f.b(this)) == null) {
            buVarB = f.f(f);
        }
        int size = arrayListA2.size();
        for (int i2 = i; i2 < size; i2++) {
            hpVar.I0(f.e);
            hpVar.I0(buVarB);
        }
        int size2 = arrayListA.size();
        while (i < size2) {
            hpVar.I0((bu) arrayListA.get(i));
            hpVar.I0(buVarB);
            i++;
        }
        return f.d(hpVar, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        u03 u03Var = (u03) obj;
        u03Var.getClass();
        return this.b.compareTo(u03Var.b);
    }

    public final u03 d(String str) {
        str.getClass();
        hp hpVar = new hp();
        hpVar.Q0(str);
        return f.a(this, f.d(hpVar, false), false);
    }

    public final Character e() {
        bu buVar = f.a;
        bu buVar2 = this.b;
        if (bu.g(buVar2, buVar) != -1 || buVar2.d() < 2 || buVar2.i(1) != 58) {
            return null;
        }
        char cI = (char) buVar2.i(0);
        if (('a' > cI || cI >= '{') && ('A' > cI || cI >= '[')) {
            return null;
        }
        return Character.valueOf(cI);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u03) && n12.c(((u03) obj).b, this.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final File toFile() {
        return new File(this.b.r());
    }

    public final String toString() {
        return this.b.r();
    }
}
