package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class no0 {
    public final /* synthetic */ int a = 0;
    public boolean b;
    public boolean c;
    public Object d;
    public Object e;
    public Serializable f;
    public Serializable g;
    public Object h;
    public Object i;

    public no0(boolean z, boolean z2, u03 u03Var, Long l, Long l2, Long l3, Long l4, Map map) {
        map.getClass();
        this.b = z;
        this.c = z2;
        this.d = u03Var;
        this.e = l;
        this.f = l2;
        this.g = l3;
        this.h = l4;
        this.i = fh2.Y(map);
    }

    public void a(oo0 oo0Var, int i, ArrayList arrayList, yn3 yn3Var) {
        nt4 nt4Var = oo0Var.d;
        yn3 yn3Var2 = nt4Var.c;
        oo0 oo0Var2 = nt4Var.i;
        oo0 oo0Var3 = nt4Var.h;
        if (yn3Var2 == null) {
            kc0 kc0Var = (kc0) this.d;
            if (nt4Var == kc0Var.d || nt4Var == kc0Var.e) {
                return;
            }
            if (yn3Var == null) {
                yn3Var = new yn3();
                yn3Var.a = null;
                yn3Var.b = new ArrayList();
                yn3Var.a = nt4Var;
                arrayList.add(yn3Var);
            }
            nt4Var.c = yn3Var;
            yn3Var.b.add(nt4Var);
            for (io0 io0Var : oo0Var3.k) {
                if (io0Var instanceof oo0) {
                    a((oo0) io0Var, i, arrayList, yn3Var);
                }
            }
            for (io0 io0Var2 : oo0Var2.k) {
                if (io0Var2 instanceof oo0) {
                    a((oo0) io0Var2, i, arrayList, yn3Var);
                }
            }
            if (i == 1 && (nt4Var instanceof dp4)) {
                for (io0 io0Var3 : ((dp4) nt4Var).k.k) {
                    if (io0Var3 instanceof oo0) {
                        a((oo0) io0Var3, i, arrayList, yn3Var);
                    }
                }
            }
            Iterator it = oo0Var3.l.iterator();
            while (it.hasNext()) {
                a((oo0) it.next(), i, arrayList, yn3Var);
            }
            Iterator it2 = oo0Var2.l.iterator();
            while (it2.hasNext()) {
                a((oo0) it2.next(), i, arrayList, yn3Var);
            }
            if (i == 1 && (nt4Var instanceof dp4)) {
                Iterator it3 = ((dp4) nt4Var).k.l.iterator();
                while (it3.hasNext()) {
                    a((oo0) it3.next(), i, arrayList, yn3Var);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x027e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0278 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x000a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(kc0 kc0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ArrayList<jc0> arrayList = kc0Var.p0;
        int[] iArr = kc0Var.o0;
        for (jc0 jc0Var : arrayList) {
            int[] iArr2 = jc0Var.o0;
            lb0[] lb0VarArr = jc0Var.P;
            lb0 lb0Var = jc0Var.K;
            lb0 lb0Var2 = jc0Var.I;
            lb0 lb0Var3 = jc0Var.J;
            lb0 lb0Var4 = jc0Var.H;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            if (jc0Var.f0 == 8) {
                jc0Var.a = true;
            } else {
                float f = jc0Var.w;
                if (f < 1.0f && i13 == 3) {
                    jc0Var.r = 2;
                }
                float f2 = jc0Var.z;
                if (f2 < 1.0f && i14 == 3) {
                    jc0Var.s = 2;
                }
                if (jc0Var.V > 0.0f) {
                    if (i13 == 3 && (i14 == 2 || i14 == 1)) {
                        jc0Var.r = 3;
                    } else if (i14 == 3 && (i13 == 2 || i13 == 1)) {
                        jc0Var.s = 3;
                    } else if (i13 == 3 && i14 == 3) {
                        if (jc0Var.r == 0) {
                            jc0Var.r = 3;
                        }
                        if (jc0Var.s == 0) {
                            jc0Var.s = 3;
                        }
                    }
                }
                if (i13 == 3 && jc0Var.r == 1 && (lb0Var4.f == null || lb0Var3.f == null)) {
                    i13 = 2;
                }
                if (i14 == 3 && jc0Var.s == 1 && (lb0Var2.f == null || lb0Var.f == null)) {
                    i14 = 2;
                }
                ks1 ks1Var = jc0Var.d;
                ks1Var.d = i13;
                int i15 = jc0Var.r;
                ks1Var.a = i15;
                dp4 dp4Var = jc0Var.e;
                dp4Var.d = i14;
                int i16 = jc0Var.s;
                dp4Var.a = i16;
                if (i13 == 4 || i13 == 1) {
                    if (i14 != 4) {
                        if (i14 != 1) {
                            i4 = 2;
                            if (i14 != 2) {
                                if (i13 == 3) {
                                    i5 = i14;
                                    i6 = 1;
                                } else if (i14 != i4 && i14 != 1) {
                                    i5 = i14;
                                    i7 = 3;
                                    i6 = 1;
                                    if (i5 != i7) {
                                    }
                                    if (i13 != i11) {
                                    }
                                } else if (i15 == 3) {
                                    if (i14 == i4) {
                                        f(i4, 0, i4, 0, jc0Var);
                                    }
                                    int i17 = jc0Var.i();
                                    f(1, (int) ((i17 * jc0Var.V) + 0.5f), 1, i17, jc0Var);
                                    jc0Var.d.e.d(jc0Var.o());
                                    jc0Var.e.e.d(jc0Var.i());
                                    jc0Var.a = true;
                                } else {
                                    int i18 = i4;
                                    i6 = 1;
                                    if (i15 == 1) {
                                        f(i18, 0, i14, 0, jc0Var);
                                        jc0Var.d.e.m = jc0Var.o();
                                    } else {
                                        i4 = i18;
                                        i5 = i14;
                                        if (i15 == 2) {
                                            int i19 = iArr[0];
                                            if (i19 == 1 || i19 == 4) {
                                                f(1, (int) ((f * kc0Var.o()) + 0.5f), i5, jc0Var.i(), jc0Var);
                                                jc0Var.d.e.d(jc0Var.o());
                                                jc0Var.e.e.d(jc0Var.i());
                                                jc0Var.a = true;
                                            }
                                        } else if (lb0VarArr[0].f == null || lb0VarArr[1].f == null) {
                                            f(i4, 0, i5, 0, jc0Var);
                                            jc0Var.d.e.d(jc0Var.o());
                                            jc0Var.e.e.d(jc0Var.i());
                                            jc0Var.a = true;
                                        }
                                        if (i5 != i7) {
                                            if (i13 != i4 && i13 != i6) {
                                                i11 = i7;
                                                i8 = i5;
                                                i9 = i4;
                                            } else if (i16 == i7) {
                                                if (i13 == i4) {
                                                    i12 = i6;
                                                    f(i4, 0, i4, 0, jc0Var);
                                                } else {
                                                    i12 = i6;
                                                }
                                                int iO = jc0Var.o();
                                                float f3 = jc0Var.V;
                                                if (jc0Var.W == -1) {
                                                    f3 = 1.0f / f3;
                                                }
                                                f(i12, iO, i12, (int) ((iO * f3) + 0.5f), jc0Var);
                                                jc0Var.d.e.d(jc0Var.o());
                                                jc0Var.e.e.d(jc0Var.i());
                                                jc0Var.a = true;
                                            } else {
                                                i8 = i5;
                                                i9 = i4;
                                                if (i16 == 1) {
                                                    f(i13, 0, i9, 0, jc0Var);
                                                    jc0Var.e.e.m = jc0Var.i();
                                                } else if (i16 == 2) {
                                                    int i20 = iArr[1];
                                                    if (i20 == i6 || i20 == 4) {
                                                        f(i13, jc0Var.o(), i6, (int) ((f2 * kc0Var.i()) + 0.5f), jc0Var);
                                                        jc0Var.d.e.d(jc0Var.o());
                                                        jc0Var.e.e.d(jc0Var.i());
                                                        jc0Var.a = true;
                                                    } else {
                                                        i11 = 3;
                                                    }
                                                } else if (lb0VarArr[2].f == null || lb0VarArr[3].f == null) {
                                                    f(i9, 0, i8, 0, jc0Var);
                                                    jc0Var.d.e.d(jc0Var.o());
                                                    jc0Var.e.e.d(jc0Var.i());
                                                    jc0Var.a = true;
                                                } else {
                                                    i11 = 3;
                                                }
                                            }
                                            i10 = 1;
                                        } else {
                                            i8 = i5;
                                            i9 = i4;
                                            i10 = 1;
                                            i11 = 3;
                                        }
                                        if (i13 != i11 && i8 == i11) {
                                            if (i15 == i10 || i16 == i10) {
                                                f(i9, 0, i9, 0, jc0Var);
                                                jc0Var.d.e.m = jc0Var.o();
                                                jc0Var.e.e.m = jc0Var.i();
                                            } else if (i16 == 2 && i15 == 2 && iArr[0] == i6 && iArr[i10] == i6) {
                                                f(i6, (int) ((f * kc0Var.o()) + 0.5f), i6, (int) ((f2 * kc0Var.i()) + 0.5f), jc0Var);
                                                jc0Var.d.e.d(jc0Var.o());
                                                jc0Var.e.e.d(jc0Var.i());
                                                jc0Var.a = true;
                                            }
                                        }
                                    }
                                }
                                i7 = 3;
                                if (i5 != i7) {
                                }
                                if (i13 != i11) {
                                }
                            }
                        } else {
                            i = 1;
                            int iO2 = jc0Var.o();
                            if (i13 == 4) {
                                iO2 = (kc0Var.o() - lb0Var4.g) - lb0Var3.g;
                                i13 = i;
                            }
                            int i21 = jc0Var.i();
                            if (i14 != 4) {
                                i2 = (kc0Var.i() - lb0Var2.g) - lb0Var.g;
                                i3 = i;
                            } else {
                                i2 = i21;
                                i3 = i14;
                            }
                            f(i13, iO2, i3, i2, jc0Var);
                            jc0Var.d.e.d(jc0Var.o());
                            jc0Var.e.e.d(jc0Var.i());
                            jc0Var.a = true;
                        }
                    }
                    i = 1;
                    int iO22 = jc0Var.o();
                    if (i13 == 4) {
                    }
                    int i212 = jc0Var.i();
                    if (i14 != 4) {
                    }
                    f(i13, iO22, i3, i2, jc0Var);
                    jc0Var.d.e.d(jc0Var.o());
                    jc0Var.e.e.d(jc0Var.i());
                    jc0Var.a = true;
                } else {
                    i4 = 2;
                    if (i13 == 2) {
                    }
                    if (i13 == 3) {
                    }
                    i7 = 3;
                    if (i5 != i7) {
                    }
                    if (i13 != i11) {
                    }
                }
            }
        }
    }

    public void c() {
        kc0 kc0Var = (kc0) this.d;
        ArrayList arrayList = (ArrayList) this.g;
        ArrayList<nt4> arrayList2 = (ArrayList) this.f;
        arrayList2.clear();
        kc0 kc0Var2 = (kc0) this.e;
        kc0Var2.d.f();
        kc0Var2.e.f();
        arrayList2.add(kc0Var2.d);
        arrayList2.add(kc0Var2.e);
        HashSet hashSet = null;
        for (jc0 jc0Var : kc0Var2.p0) {
            if (jc0Var instanceof nq1) {
                oq1 oq1Var = new oq1(jc0Var);
                jc0Var.d.f();
                jc0Var.e.f();
                oq1Var.f = ((nq1) jc0Var).t0;
                arrayList2.add(oq1Var);
            } else {
                if (jc0Var.v()) {
                    if (jc0Var.b == null) {
                        jc0Var.b = new q20(jc0Var, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(jc0Var.b);
                } else {
                    arrayList2.add(jc0Var.d);
                }
                if (jc0Var.w()) {
                    if (jc0Var.c == null) {
                        jc0Var.c = new q20(jc0Var, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(jc0Var.c);
                } else {
                    arrayList2.add(jc0Var.e);
                }
                if (jc0Var instanceof wj) {
                    arrayList2.add(new bs1(jc0Var));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((nt4) it.next()).f();
        }
        for (nt4 nt4Var : arrayList2) {
            if (nt4Var.b != kc0Var2) {
                nt4Var.d();
            }
        }
        arrayList.clear();
        e(kc0Var.d, 0, arrayList);
        e(kc0Var.e, 1, arrayList);
        this.b = false;
    }

    public int d(kc0 kc0Var, int i) {
        ArrayList arrayList;
        int i2;
        long jMax;
        float f;
        kc0 kc0Var2 = kc0Var;
        ArrayList arrayList2 = (ArrayList) this.g;
        int size = arrayList2.size();
        long j = 0;
        int i3 = 0;
        long jMax2 = 0;
        while (i3 < size) {
            nt4 nt4Var = ((yn3) arrayList2.get(i3)).a;
            if (!(nt4Var instanceof q20) ? !(i != 0 ? (nt4Var instanceof dp4) : (nt4Var instanceof ks1)) : ((q20) nt4Var).f != i) {
                oo0 oo0Var = (i == 0 ? kc0Var2.d : kc0Var2.e).h;
                oo0 oo0Var2 = (i == 0 ? kc0Var2.d : kc0Var2.e).i;
                oo0 oo0Var3 = nt4Var.h;
                oo0 oo0Var4 = nt4Var.i;
                boolean zContains = oo0Var3.l.contains(oo0Var);
                boolean zContains2 = oo0Var4.l.contains(oo0Var2);
                long j2 = nt4Var.j();
                if (zContains && zContains2) {
                    long jB = yn3.b(oo0Var3, j);
                    arrayList = arrayList2;
                    long jA = yn3.a(oo0Var4, j);
                    long j3 = jB - j2;
                    int i4 = oo0Var4.f;
                    i2 = i3;
                    if (j3 >= (-i4)) {
                        j3 += (long) i4;
                    }
                    long j4 = oo0Var3.f;
                    long j5 = ((-jA) - j2) - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    jc0 jc0Var = nt4Var.b;
                    if (i == 0) {
                        f = jc0Var.c0;
                    } else if (i == 1) {
                        f = jc0Var.d0;
                    } else {
                        jc0Var.getClass();
                        f = -1.0f;
                    }
                    float f2 = f > 0.0f ? (long) ((j3 / (1.0f - f)) + (j5 / f)) : 0L;
                    jMax = (((long) oo0Var3.f) + ((((long) ((f2 * f) + 0.5f)) + j2) + ((long) ha0.h(1.0f, f, f2, 0.5f)))) - ((long) oo0Var4.f);
                } else {
                    arrayList = arrayList2;
                    i2 = i3;
                    jMax = zContains ? Math.max(yn3.b(oo0Var3, oo0Var3.f), ((long) oo0Var3.f) + j2) : zContains2 ? Math.max(-yn3.a(oo0Var4, oo0Var4.f), ((long) (-oo0Var4.f)) + j2) : (nt4Var.j() + ((long) oo0Var3.f)) - ((long) oo0Var4.f);
                }
            } else {
                arrayList = arrayList2;
                jMax = j;
                i2 = i3;
            }
            jMax2 = Math.max(jMax2, jMax);
            i3 = i2 + 1;
            arrayList2 = arrayList;
            kc0Var2 = kc0Var;
            j = 0;
        }
        return (int) jMax2;
    }

    public void e(nt4 nt4Var, int i, ArrayList arrayList) {
        oo0 oo0Var = nt4Var.h;
        oo0 oo0Var2 = nt4Var.i;
        for (io0 io0Var : oo0Var.k) {
            if (io0Var instanceof oo0) {
                a((oo0) io0Var, i, arrayList, null);
            } else if (io0Var instanceof nt4) {
                a(((nt4) io0Var).h, i, arrayList, null);
            }
        }
        for (io0 io0Var2 : oo0Var2.k) {
            if (io0Var2 instanceof oo0) {
                a((oo0) io0Var2, i, arrayList, null);
            } else if (io0Var2 instanceof nt4) {
                a(((nt4) io0Var2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            for (io0 io0Var3 : ((dp4) nt4Var).k.k) {
                if (io0Var3 instanceof oo0) {
                    a((oo0) io0Var3, i, arrayList, null);
                }
            }
        }
    }

    public void f(int i, int i2, int i3, int i4, jc0 jc0Var) {
        zl zlVar = (zl) this.i;
        zlVar.a = i;
        zlVar.b = i3;
        zlVar.c = i2;
        zlVar.d = i4;
        ((rb0) this.h).b(jc0Var, zlVar);
        jc0Var.K(zlVar.e);
        jc0Var.H(zlVar.f);
        jc0Var.E = zlVar.h;
        int i5 = zlVar.g;
        jc0Var.Z = i5;
        jc0Var.E = i5 > 0;
    }

    public void g() {
        no0 no0Var;
        tl tlVar;
        for (jc0 jc0Var : ((kc0) this.d).p0) {
            if (!jc0Var.a) {
                int[] iArr = jc0Var.o0;
                boolean z = false;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = jc0Var.r;
                int i4 = jc0Var.s;
                boolean z2 = i == 2 || (i == 3 && i3 == 1);
                if (i2 == 2 || (i2 == 3 && i4 == 1)) {
                    z = true;
                }
                su0 su0Var = jc0Var.d.e;
                boolean z3 = su0Var.j;
                su0 su0Var2 = jc0Var.e.e;
                boolean z4 = su0Var2.j;
                boolean z5 = z2;
                if (z3 && z4) {
                    no0Var = this;
                    no0Var.f(1, su0Var.g, 1, su0Var2.g, jc0Var);
                    jc0Var.a = true;
                } else if (z3 && z) {
                    no0Var = this;
                    no0Var.f(1, su0Var.g, 2, su0Var2.g, jc0Var);
                    dp4 dp4Var = jc0Var.e;
                    if (i2 == 3) {
                        dp4Var.e.m = jc0Var.i();
                    } else {
                        dp4Var.e.d(jc0Var.i());
                        jc0Var.a = true;
                    }
                } else {
                    no0Var = this;
                    if (z4 && z5) {
                        no0Var.f(2, su0Var.g, 1, su0Var2.g, jc0Var);
                        ks1 ks1Var = jc0Var.d;
                        if (i == 3) {
                            ks1Var.e.m = jc0Var.o();
                        } else {
                            ks1Var.e.d(jc0Var.o());
                            jc0Var.a = true;
                        }
                    }
                }
                if (jc0Var.a && (tlVar = jc0Var.e.l) != null) {
                    tlVar.d(jc0Var.Z);
                }
                this = no0Var;
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 1:
                Map map = (Map) this.i;
                Long l = (Long) this.h;
                Long l2 = (Long) this.g;
                Long l3 = (Long) this.f;
                Long l4 = (Long) this.e;
                ArrayList arrayList = new ArrayList();
                if (this.b) {
                    arrayList.add("isRegularFile");
                }
                if (this.c) {
                    arrayList.add("isDirectory");
                }
                if (l4 != null) {
                    arrayList.add("byteCount=" + l4.longValue());
                }
                if (l3 != null) {
                    arrayList.add("createdAt=" + l3.longValue());
                }
                if (l2 != null) {
                    arrayList.add("lastModifiedAt=" + l2.longValue());
                }
                if (l != null) {
                    arrayList.add("lastAccessedAt=" + l.longValue());
                }
                if (!map.isEmpty()) {
                    arrayList.add("extras=" + map);
                }
                return d70.j0(arrayList, ", ", "FileMetadata(", ")", null, 56);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ no0() {
    }

    public /* synthetic */ no0(boolean z, boolean z2, u03 u03Var, Long l, Long l2, Long l3, Long l4) {
        this(z, z2, u03Var, l, l2, l3, l4, h41.b);
    }
}
