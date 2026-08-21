package defpackage;

import j$.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ta2 {
    public final xp1 a;
    public final zv2 b;
    public boolean c;
    public int d;
    public t24 e;
    public final ua2 f;
    public int g = -1;
    public boolean h;

    static {
        ve2.a(ta2.class.getName());
    }

    public ta2(xp1 xp1Var, zv2 zv2Var, boolean z, int i, t24 t24Var, ua2 ua2Var) {
        this.a = xp1Var;
        this.b = zv2Var;
        this.c = z;
        this.d = i;
        this.e = t24Var;
        this.f = ua2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.xp1 r22, defpackage.zv2 r23, boolean r24, defpackage.t24 r25, defpackage.ua2 r26, java.util.List r27, defpackage.sv2[] r28) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ta2.a(xp1, zv2, boolean, t24, ua2, java.util.List, sv2[]):void");
    }

    public static wn1 b(xp1 xp1Var, zv2 zv2Var, boolean z, int i, t24 t24Var, ua2 ua2Var, boolean z2, Duration duration) {
        long j;
        long j2;
        int i2;
        sv2[] sv2VarArr;
        int i3;
        int i4;
        Object obj;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        String str;
        int i7;
        ta2 ta2Var = new ta2(xp1Var, zv2Var, z, i, t24Var, ua2Var);
        long millis = duration.toMillis();
        ta2Var.h = false;
        if (z2) {
            boolean z5 = ta2Var.c;
            int i8 = ta2Var.d;
            t24 t24Var2 = ta2Var.e;
            int i9 = t24Var2.f ? 0 : -1;
            ArrayList arrayList = new ArrayList();
            for (t24 t24Var3 = t24Var2; t24Var3 != null; t24Var3 = t24Var3.d) {
                sn3 sn3VarD = xp1Var.d(t24Var3.e);
                if (sn3VarD instanceof vm) {
                    arrayList.add(new qa2(t24Var3, (vm) sn3VarD));
                }
            }
            int i10 = i9;
            boolean z6 = z5;
            int i11 = i10;
            int i12 = i8;
            int size = arrayList.size() - 1;
            while (size >= 0) {
                qa2 qa2Var = (qa2) arrayList.get(size);
                vm vmVar = qa2Var.b;
                t24 t24Var4 = qa2Var.a;
                qt qtVar = t24Var4.i;
                String str2 = t24Var4.g;
                int i13 = size;
                t24 t24Var5 = t24Var4.d;
                boolean z7 = i11 == i12;
                boolean z8 = vmVar.j;
                qh3 qh3Var = vmVar.n;
                if (qh3Var == null) {
                    qh3Var = new qh3();
                    j = millis;
                    oh3 oh3Var = vmVar.i;
                    if (z8) {
                        str = str2;
                        oh3Var = new oh3(oh3Var.a, oh3Var.b);
                    } else {
                        str = str2;
                    }
                    qh3Var.a(oh3Var);
                    vmVar.n = qh3Var;
                } else {
                    j = millis;
                    str = str2;
                }
                if (z8) {
                    qh3Var.c(0, str == null ? "\uffff" : str);
                }
                n80 n80VarB = qh3Var.b(z6, z7);
                wv2 wv2VarN = n80VarB.a.n(zv2Var, i12);
                if (wv2VarN != null) {
                    sv2[] sv2VarArr2 = wv2VarN.b;
                    if (-2 == n80VarB.b[wv2VarN.a].a) {
                        if (sv2VarArr2.length > 0) {
                            int i14 = sv2VarArr2[0].a;
                            ua2Var.getClass();
                            ua2Var.c(qtVar, i14);
                            i7 = i13;
                            a(xp1Var, zv2Var, z6, t24Var4, ua2Var, qa2Var.b.h, sv2VarArr2);
                            ua2Var.c(qtVar, sv2VarArr2[0].b);
                            i11 = sv2VarArr2[0].b;
                            if (i11 > i12) {
                                i12 = i11;
                                z6 = false;
                            }
                        } else {
                            i7 = i13;
                        }
                        size = i7 - 1;
                        millis = j;
                    }
                }
                t24Var2 = t24Var5;
                break;
            }
            j = millis;
            ta2Var.e = t24Var2;
            ta2Var.d = i12;
            ta2Var.c = z6;
            ta2Var.g = i11;
        } else {
            j = millis;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!ta2Var.h) {
            if (j > 0 && System.currentTimeMillis() - jCurrentTimeMillis > j) {
                return new wn1(ta2Var.e, true);
            }
            zv2 zv2Var2 = ta2Var.b;
            String str3 = zv2Var2.a;
            boolean z9 = ta2Var.c;
            int i15 = ta2Var.d;
            t24 t24Var6 = ta2Var.e;
            int i16 = ta2Var.g;
            wn3 wn3Var = t24Var6.e;
            xp1 xp1Var2 = ta2Var.a;
            n80 n80VarB2 = xp1Var2.d(wn3Var).b(xp1Var2, t24Var6.g, z9, i15 == i16);
            wv2 wv2VarN2 = n80VarB2.a.n(zv2Var2, i15);
            v62 v62Var = wv2VarN2 != null ? new v62(1, n80VarB2.b[wv2VarN2.a], wv2VarN2.b) : null;
            ArrayList arrayList2 = (ArrayList) xp1Var2.c();
            if (arrayList2.isEmpty()) {
                j2 = jCurrentTimeMillis;
            } else {
                qt qtVar2 = t24Var6.i;
                Object objB = qtVar2 != null ? ((v62) qtVar2.d).B() : Collections.EMPTY_LIST;
                int size2 = arrayList2.size();
                int i17 = Integer.MAX_VALUE;
                wn3 wn3Var2 = wn3.c;
                int i18 = 0;
                int i19 = 0;
                sv2[] sv2VarArr3 = null;
                while (true) {
                    if (i18 >= size2) {
                        j2 = jCurrentTimeMillis;
                        i2 = i19;
                        sv2VarArr = sv2VarArr3;
                        break;
                    }
                    e02 e02Var = (e02) arrayList2.get(i18);
                    j2 = jCurrentTimeMillis;
                    if (e02Var.b.a(objB)) {
                        obj = objB;
                        n80 n80VarB3 = xp1Var2.d(e02Var.d).b(xp1Var2, null, z9, i15 == i16);
                        wv2 wv2VarN3 = n80VarB3.a.n(zv2Var2, i15);
                        if (wv2VarN3 == null) {
                            z3 = z9;
                        } else {
                            sv2[] sv2VarArr4 = wv2VarN3.b;
                            z3 = z9;
                            int i20 = sv2VarArr4[0].a;
                            i5 = i17;
                            if (i20 > i5) {
                                i17 = i5;
                            } else {
                                wn3Var2 = n80VarB3.b[wv2VarN3.a];
                                i2 = e02Var.c;
                                if (i20 == i15) {
                                    sv2VarArr = sv2VarArr4;
                                    break;
                                }
                                i19 = i2;
                                i17 = i20;
                                sv2VarArr3 = sv2VarArr4;
                            }
                            i18++;
                            z9 = z3;
                            jCurrentTimeMillis = j2;
                            objB = obj;
                        }
                    } else {
                        z3 = z9;
                        obj = objB;
                    }
                    i5 = i17;
                    i17 = i5;
                    i18++;
                    z9 = z3;
                    jCurrentTimeMillis = j2;
                    objB = obj;
                }
                sa2 sa2Var = sv2VarArr != null ? new sa2(wn3Var2, sv2VarArr, i2 == -1) : null;
                if (sa2Var != null && (v62Var == null || (i4 = ((sv2[]) sa2Var.f)[0].a) < (i3 = ((sv2[]) v62Var.f)[0].a) || (sa2Var.A && i4 == i3))) {
                    v62Var = sa2Var;
                }
            }
            if (v62Var == null) {
                ua2Var.b(ta2Var.e, str3.length());
                ta2Var.h = true;
            } else {
                sv2[] sv2VarArr5 = (sv2[]) v62Var.f;
                wn3 wn3Var3 = (wn3) v62Var.z;
                boolean z10 = sv2VarArr5.length > 0 && sv2VarArr5[0].b > ta2Var.d;
                if (wn3Var3.a == -1) {
                    um umVar = (um) xp1Var2.d(ta2Var.e.e);
                    ua2Var.b(ta2Var.e, sv2VarArr5[0].a);
                    t24 t24Var7 = ta2Var.e;
                    t24 t24VarB = t24Var7.b(t24Var7.h);
                    ta2Var.e = t24VarB;
                    a(ta2Var.a, zv2Var2, ta2Var.c, t24VarB, ta2Var.f, umVar.i, sv2VarArr5);
                    ua2Var.b(ta2Var.e, sv2VarArr5[0].b);
                    t24 t24Var8 = ta2Var.e;
                    ta2Var.e = t24Var8.d;
                    ta2Var.g = t24Var8.b;
                    if (!z10 && t24Var8.a == ta2Var.d) {
                        ta2Var.e = t24Var8;
                        ua2Var.c(t24Var8.i, str3.length());
                        z4 = true;
                        ta2Var.h = true;
                    }
                    if (sv2VarArr5.length <= 0 && (i6 = sv2VarArr5[0].b) > ta2Var.d) {
                        ta2Var.d = i6;
                        ta2Var.c = false;
                    }
                } else {
                    if (sv2VarArr5.length > 0) {
                        sn3 sn3VarD2 = xp1Var2.d(wn3Var3);
                        ua2Var.b(ta2Var.e, sv2VarArr5[0].a);
                        t24 t24Var9 = ta2Var.e;
                        qt qtVarO = ta2Var.e.i.o(sn3VarD2.c(str3, sv2VarArr5), xp1Var2);
                        t24 t24Var10 = ta2Var.e;
                        int i21 = ta2Var.d;
                        int i22 = ta2Var.g;
                        boolean z11 = sv2VarArr5[0].b == str3.length();
                        t24Var10.getClass();
                        t24 t24Var11 = new t24(t24Var10, wn3Var3, i21, i22, z11, null, qtVarO, qtVarO);
                        ta2Var.e = t24Var11;
                        if (sn3VarD2 instanceof um) {
                            um umVar2 = (um) sn3VarD2;
                            a(ta2Var.a, zv2Var2, ta2Var.c, t24Var11, ta2Var.f, umVar2.g, sv2VarArr5);
                            ua2Var.b(ta2Var.e, sv2VarArr5[0].b);
                            ta2Var.g = sv2VarArr5[0].b;
                            String strB = umVar2.d;
                            if (umVar2.e && strB != null) {
                                strB = vh3.b(strB, str3, sv2VarArr5);
                            }
                            t24 t24VarB2 = ta2Var.e.b(qtVarO.o(strB, xp1Var2));
                            ta2Var.e = t24VarB2;
                            if (umVar2.j) {
                                t24VarB2 = t24VarB2.c(umVar2.h.b(str3, sv2VarArr5));
                                ta2Var.e = t24VarB2;
                            }
                            if (!z10) {
                                t24Var9.getClass();
                                while (t24Var9 != null && t24Var9.a == t24VarB2.a) {
                                    if (t24Var9.e == t24VarB2.e) {
                                        t24 t24Var12 = ta2Var.e.d;
                                        ta2Var.e = t24Var12;
                                        ua2Var.b(t24Var12, str3.length());
                                        z4 = true;
                                        ta2Var.h = true;
                                    } else {
                                        t24Var9 = t24Var9.d;
                                    }
                                }
                            }
                        } else if (sn3VarD2 instanceof vm) {
                            vm vmVar2 = (vm) sn3VarD2;
                            a(ta2Var.a, zv2Var2, ta2Var.c, t24Var11, ta2Var.f, vmVar2.g, sv2VarArr5);
                            ua2Var.b(ta2Var.e, sv2VarArr5[0].b);
                            ta2Var.g = sv2VarArr5[0].b;
                            String strB2 = vmVar2.d;
                            if (vmVar2.e && strB2 != null) {
                                strB2 = vh3.b(strB2, str3, sv2VarArr5);
                            }
                            t24 t24VarB3 = ta2Var.e.b(qtVarO.o(strB2, xp1Var2));
                            ta2Var.e = t24VarB3;
                            if (vmVar2.j) {
                                t24VarB3 = t24VarB3.c(vmVar2.i.b(str3, sv2VarArr5));
                                ta2Var.e = t24VarB3;
                            }
                            if (!z10) {
                                t24Var9.getClass();
                                while (t24Var9 != null && t24Var9.a == t24VarB3.a) {
                                    if (t24Var9.e == t24VarB3.e) {
                                        t24 t24Var13 = ta2Var.e.d;
                                        ta2Var.e = t24Var13;
                                        ua2Var.b(t24Var13, str3.length());
                                        z4 = true;
                                        ta2Var.h = true;
                                    } else {
                                        t24Var9 = t24Var9.d;
                                    }
                                }
                            }
                        } else {
                            a(ta2Var.a, zv2Var2, ta2Var.c, t24Var11, ta2Var.f, ((lh2) sn3VarD2).g, sv2VarArr5);
                            ua2Var.b(ta2Var.e, sv2VarArr5[0].b);
                            t24 t24Var14 = ta2Var.e.d;
                            ta2Var.e = t24Var14;
                            if (!z10) {
                                t24 t24Var15 = t24Var14.d;
                                if (t24Var15 != null) {
                                    t24Var14 = t24Var15;
                                }
                                ta2Var.e = t24Var14;
                                ua2Var.c(t24Var14.i, str3.length());
                                ta2Var.h = true;
                            }
                        }
                    }
                    if (sv2VarArr5.length <= 0) {
                    }
                }
                jCurrentTimeMillis = j2;
            }
            jCurrentTimeMillis = j2;
        }
        return new wn1(ta2Var.e, false);
    }
}
