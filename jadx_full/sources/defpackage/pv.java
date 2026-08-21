package defpackage;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pv implements e12 {
    public static final pv f = new pv(0);
    public static final pv z = new pv(1);
    public final /* synthetic */ int b;

    public /* synthetic */ pv(int i) {
        this.b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x038a A[Catch: IOException -> 0x0334, TryCatch #6 {IOException -> 0x0334, blocks: (B:156:0x032a, B:160:0x0337, B:169:0x0360, B:175:0x038a, B:181:0x0398, B:182:0x039f, B:184:0x03a2, B:190:0x03b3, B:194:0x0402, B:196:0x0415, B:203:0x042e, B:206:0x043b, B:207:0x045f, B:198:0x041f, B:193:0x03f1, B:209:0x0461, B:210:0x0464, B:192:0x03d2), top: B:226:0x032a, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x041f A[Catch: IOException -> 0x0334, TryCatch #6 {IOException -> 0x0334, blocks: (B:156:0x032a, B:160:0x0337, B:169:0x0360, B:175:0x038a, B:181:0x0398, B:182:0x039f, B:184:0x03a2, B:190:0x03b3, B:194:0x0402, B:196:0x0415, B:203:0x042e, B:206:0x043b, B:207:0x045f, B:198:0x041f, B:193:0x03f1, B:209:0x0461, B:210:0x0464, B:192:0x03d2), top: B:226:0x032a, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x046d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v4, types: [long] */
    @Override // defpackage.e12
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final kk3 a(ve3 ve3Var) throws Throwable {
        jk3 jk3VarU;
        ?? r2;
        IOException iOException;
        ?? r22;
        kk3 kk3VarA;
        int i;
        ok3 ok3Var;
        boolean z2;
        int i2;
        kk3 kk3VarA2;
        cm2 cm2Var;
        Object wt1Var;
        kk3 kk3Var;
        lr1 lr1Var;
        ?? r23 = 1;
        ?? r24 = 1;
        Throwable th = null;
        switch (this.b) {
            case 0:
                ue1 ue1Var = ve3Var.d;
                ue1Var.getClass();
                le3 le3Var = (le3) ue1Var.b;
                r61 r61Var = (r61) ue1Var.A;
                cm2 cm2Var2 = ve3Var.e;
                ej3 ej3Var = (ej3) cm2Var2.X;
                lr1 lr1Var2 = (lr1) cm2Var2.A;
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z3 = ek0.z((String) cm2Var2.z) && ej3Var != null;
                boolean zEqualsIgnoreCase = "upgrade".equalsIgnoreCase(lr1Var2.a("Connection"));
                try {
                    try {
                        r61Var.g(cm2Var2);
                        try {
                            if (z3) {
                                try {
                                    if ("100-continue".equalsIgnoreCase(lr1Var2.a(HttpHeaders.Names.EXPECT))) {
                                        try {
                                            try {
                                                r61Var.h();
                                                jk3VarU = ue1Var.u(true);
                                            } catch (IOException e) {
                                                ue1Var.z(e);
                                                throw e;
                                            }
                                        } catch (IOException e2) {
                                            e = e2;
                                            jk3VarU = null;
                                            r2 = jCurrentTimeMillis;
                                            if ((e instanceof bb0) || !ue1Var.f) {
                                                throw e;
                                            }
                                            iOException = e;
                                            r22 = r2;
                                            if (jk3VarU == null) {
                                            }
                                            jk3 jk3Var = jk3VarU;
                                            jk3Var.a = cm2Var2;
                                            jk3Var.e = ue1Var.k().f;
                                            jk3Var.l = r22;
                                            jk3Var.m = System.currentTimeMillis();
                                            kk3VarA = jk3Var.a();
                                            i = kk3VarA.A;
                                            while (true) {
                                                ok3Var = kk3VarA.Z;
                                                if (i == 100) {
                                                    if (i != 101) {
                                                    }
                                                    if (z2) {
                                                    }
                                                    if (z2) {
                                                    }
                                                    if (zEqualsIgnoreCase) {
                                                        try {
                                                            String strG = kk3.g(kk3VarA, "Content-Type");
                                                            long jC = r61Var.c(kk3VarA);
                                                            i2 = i;
                                                            xe3 xe3Var = new xe3(strG, jC, new he3(new p61(ue1Var, r61Var.e(kk3VarA), jC, false)));
                                                            jk3 jk3VarN = kk3VarA.n();
                                                            jk3VarN.g = xe3Var;
                                                            jk3VarN.o = new pr1();
                                                            kk3VarA2 = jk3VarN.a();
                                                        } catch (IOException e3) {
                                                            ue1Var.z(e3);
                                                            throw e3;
                                                        }
                                                    }
                                                    cm2Var = kk3VarA2.b;
                                                    cm2Var.getClass();
                                                    if (!"close".equalsIgnoreCase(((lr1) cm2Var.A).a("Connection"))) {
                                                        r61Var.j().d();
                                                    }
                                                    if (i2 == 204) {
                                                        throw new ProtocolException("HTTP " + i2 + " had non-zero Content-Length: " + kk3VarA2.Z.n());
                                                    }
                                                    throw new ProtocolException("HTTP " + i2 + " had non-zero Content-Length: " + kk3VarA2.Z.n());
                                                    return kk3VarA2;
                                                }
                                                jk3 jk3VarU2 = ue1Var.u(false);
                                                jk3VarU2.getClass();
                                                jk3VarU2.a = cm2Var2;
                                                jk3VarU2.e = ue1Var.k().f;
                                                jk3VarU2.l = r22;
                                                jk3VarU2.m = System.currentTimeMillis();
                                                kk3VarA = jk3VarU2.a();
                                                i = kk3VarA.A;
                                            }
                                        }
                                    } else {
                                        jk3VarU = null;
                                    }
                                    if (jk3VarU == null) {
                                        try {
                                            ej3Var.getClass();
                                            ej3 ej3Var2 = (ej3) cm2Var2.X;
                                            ej3Var2.getClass();
                                            long jA = ej3Var2.a();
                                            r24 = jCurrentTimeMillis;
                                            ge3 ge3Var = new ge3(new o61(ue1Var, r61Var.f(cm2Var2, jA), jA, false));
                                            ej3Var.c(ge3Var);
                                            ge3Var.close();
                                        } catch (IOException e4) {
                                            e = e4;
                                            r2 = jCurrentTimeMillis;
                                            if (e instanceof bb0) {
                                                throw e;
                                            }
                                            throw e;
                                        }
                                    } else {
                                        r24 = jCurrentTimeMillis;
                                        le3Var.h(ue1Var, true, false, false, false, null);
                                        if (!(ue1Var.k().i != null)) {
                                            r61Var.j().d();
                                        }
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    r23 = jCurrentTimeMillis;
                                    jk3VarU = null;
                                    r2 = r23;
                                    if (e instanceof bb0) {
                                    }
                                }
                            } else {
                                r24 = jCurrentTimeMillis;
                                le3Var.h(ue1Var, true, false, false, false, null);
                                jk3VarU = null;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            r2 = r24;
                        }
                    } catch (IOException e7) {
                        ue1Var.z(e7);
                        throw e7;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
                try {
                    r61Var.a();
                    iOException = null;
                    r22 = r24;
                    if (jk3VarU == null) {
                        try {
                            jk3VarU = ue1Var.u(false);
                            jk3VarU.getClass();
                        } catch (IOException e9) {
                            if (iOException == null) {
                                throw e9;
                            }
                            ek0.b(iOException, e9);
                            throw iOException;
                        }
                    }
                    jk3 jk3Var2 = jk3VarU;
                    jk3Var2.a = cm2Var2;
                    jk3Var2.e = ue1Var.k().f;
                    jk3Var2.l = r22;
                    jk3Var2.m = System.currentTimeMillis();
                    kk3VarA = jk3Var2.a();
                    i = kk3VarA.A;
                    while (true) {
                        ok3Var = kk3VarA.Z;
                        if (i == 100 || (102 <= i && i < 200)) {
                            jk3 jk3VarU22 = ue1Var.u(false);
                            jk3VarU22.getClass();
                            jk3VarU22.a = cm2Var2;
                            jk3VarU22.e = ue1Var.k().f;
                            jk3VarU22.l = r22;
                            jk3VarU22.m = System.currentTimeMillis();
                            kk3VarA = jk3VarU22.a();
                            i = kk3VarA.A;
                        }
                    }
                    z2 = i != 101;
                    if (z2) {
                        if (ue1Var.k().i != null) {
                            throw new ProtocolException("Unexpected 101 code on HTTP/2 connection");
                        }
                    }
                    boolean z4 = !z2 && "upgrade".equalsIgnoreCase(kk3.g(kk3VarA, "Connection"));
                    if (zEqualsIgnoreCase || !z4) {
                        String strG2 = kk3.g(kk3VarA, "Content-Type");
                        long jC2 = r61Var.c(kk3VarA);
                        i2 = i;
                        xe3 xe3Var2 = new xe3(strG2, jC2, new he3(new p61(ue1Var, r61Var.e(kk3VarA), jC2, false)));
                        jk3 jk3VarN2 = kk3VarA.n();
                        jk3VarN2.g = xe3Var2;
                        jk3VarN2.o = new pr1();
                        kk3VarA2 = jk3VarN2.a();
                    } else {
                        jk3 jk3VarN3 = kk3VarA.n();
                        jk3VarN3.g = new km4(ok3Var.s(), ok3Var.n());
                        jk3VarN3.h = ue1Var.A();
                        kk3VarA2 = jk3VarN3.a();
                        i2 = i;
                    }
                    cm2Var = kk3VarA2.b;
                    cm2Var.getClass();
                    if (!"close".equalsIgnoreCase(((lr1) cm2Var.A).a("Connection")) || "close".equalsIgnoreCase(kk3.g(kk3VarA2, "Connection"))) {
                        r61Var.j().d();
                    }
                    if ((i2 == 204 && i2 != 205) || kk3VarA2.Z.n() <= 0) {
                        return kk3VarA2;
                    }
                    throw new ProtocolException("HTTP " + i2 + " had non-zero Content-Length: " + kk3VarA2.Z.n());
                } catch (IOException e10) {
                    ue1Var.z(e10);
                    throw e10;
                }
            case 1:
                le3 le3Var2 = ve3Var.a;
                synchronized (le3Var2) {
                    if (!le3Var2.F0) {
                        throw new IllegalStateException("released");
                    }
                    if (le3Var2.C0 || le3Var2.B0 || le3Var2.E0 || le3Var2.D0) {
                        throw new IllegalStateException("Check failed.");
                    }
                }
                s61 s61Var = le3Var2.Z;
                s61Var.getClass();
                me3 me3VarA = s61Var.a();
                lu2 lu2Var = le3Var2.b;
                me3VarA.getClass();
                lu2Var.getClass();
                int i3 = ve3Var.g;
                ed4 ed4Var = me3VarA.h;
                fu1 fu1Var = me3VarA.i;
                if (fu1Var != null) {
                    wt1Var = new gu1(lu2Var, me3VarA, ve3Var, fu1Var);
                } else {
                    me3VarA.e.setSoTimeout(i3);
                    ((he3) ed4Var.z).b.i().g(i3);
                    ((ge3) ed4Var.A).b.i().g(ve3Var.h);
                    wt1Var = new wt1(lu2Var, me3VarA, ed4Var);
                }
                s61Var.getClass();
                ue1 ue1Var2 = new ue1();
                ue1Var2.b = le3Var2;
                ue1Var2.z = s61Var;
                ue1Var2.A = wt1Var;
                le3Var2.A0 = ue1Var2;
                le3Var2.H0 = ue1Var2;
                synchronized (le3Var2) {
                    le3Var2.B0 = true;
                    le3Var2.C0 = true;
                }
                if (!le3Var2.G0) {
                    return ve3.a(ve3Var, 0, ue1Var2, null, 61).b(ve3Var.e);
                }
                vp1.i("Canceled");
                return null;
            default:
                System.currentTimeMillis();
                cm2 cm2Var3 = ve3Var.e;
                cm2Var3.getClass();
                int i4 = 17;
                lb lbVar = new lb(i4, cm2Var3, th);
                if (cm2Var3.e().j) {
                    lbVar = new lb(i4, th, th);
                }
                cm2 cm2Var4 = (cm2) lbVar.f;
                kk3 kk3Var2 = (kk3) lbVar.z;
                if (cm2Var4 == null && kk3Var2 == null) {
                    return new kk3(cm2Var3, ba3.HTTP_1_1, "Unsatisfiable Request (only-if-cached)", 504, null, new lr1((String[]) new ArrayList(20).toArray(new String[0])), ok3.f, null, null, null, null, -1L, System.currentTimeMillis(), null, fg4.W);
                }
                if (cm2Var4 == null) {
                    kk3Var2.getClass();
                    jk3 jk3VarN4 = kk3Var2.n();
                    kk3 kk3VarA0 = gb4.a0(kk3Var2);
                    jk3.b(kk3VarA0, "cacheResponse");
                    jk3VarN4.j = kk3VarA0;
                    return jk3VarN4.a();
                }
                kk3 kk3VarB = ve3Var.b(cm2Var4);
                if (kk3Var2 == null) {
                    kk3Var = null;
                } else {
                    if (kk3VarB.A == 304) {
                        jk3 jk3VarN5 = kk3Var2.n();
                        lr1 lr1Var3 = kk3Var2.Y;
                        lr1 lr1Var4 = kk3VarB.Y;
                        ArrayList arrayList = new ArrayList(20);
                        int size = lr1Var3.size();
                        int i5 = 0;
                        while (i5 < size) {
                            String strZ = gb4.z(lr1Var3, i5);
                            Throwable th2 = th;
                            String strB = gb4.B(lr1Var3, i5);
                            if (HttpHeaders.Names.WARNING.equalsIgnoreCase(strZ)) {
                                lr1Var = lr1Var3;
                                if (w44.j0(strB, "1", false)) {
                                }
                                i5++;
                                th = th2;
                                lr1Var3 = lr1Var;
                            } else {
                                lr1Var = lr1Var3;
                            }
                            if ("Content-Length".equalsIgnoreCase(strZ) || "Content-Encoding".equalsIgnoreCase(strZ) || "Content-Type".equalsIgnoreCase(strZ) || !vf2.w(strZ) || lr1Var4.a(strZ) == null) {
                                arrayList.add(strZ);
                                arrayList.add(p44.U0(strB).toString());
                            }
                            i5++;
                            th = th2;
                            lr1Var3 = lr1Var;
                        }
                        Throwable th3 = th;
                        int size2 = lr1Var4.size();
                        for (int i6 = 0; i6 < size2; i6++) {
                            String strZ2 = gb4.z(lr1Var4, i6);
                            if (!"Content-Length".equalsIgnoreCase(strZ2) && !"Content-Encoding".equalsIgnoreCase(strZ2) && !"Content-Type".equalsIgnoreCase(strZ2) && vf2.w(strZ2)) {
                                String strB2 = gb4.B(lr1Var4, i6);
                                arrayList.add(strZ2);
                                arrayList.add(p44.U0(strB2).toString());
                            }
                        }
                        jk3VarN5.f = gb4.A(new lr1((String[]) arrayList.toArray(new String[0])));
                        jk3VarN5.l = kk3VarB.C0;
                        jk3VarN5.m = kk3VarB.D0;
                        kk3 kk3VarA02 = gb4.a0(kk3Var2);
                        jk3.b(kk3VarA02, "cacheResponse");
                        jk3VarN5.j = kk3VarA02;
                        kk3 kk3VarA03 = gb4.a0(kk3VarB);
                        jk3.b(kk3VarA03, "networkResponse");
                        jk3VarN5.i = kk3VarA03;
                        jk3VarN5.a();
                        kk3VarB.Z.close();
                        throw th3;
                    }
                    kk3Var = null;
                    hz4.b(kk3Var2.Z);
                }
                jk3 jk3VarN6 = kk3VarB.n();
                kk3 kk3VarA04 = kk3Var2 != null ? gb4.a0(kk3Var2) : kk3Var;
                jk3.b(kk3VarA04, "cacheResponse");
                jk3VarN6.j = kk3VarA04;
                kk3 kk3VarA05 = gb4.a0(kk3VarB);
                jk3.b(kk3VarA05, "networkResponse");
                jk3VarN6.i = kk3VarA05;
                return jk3VarN6.a();
        }
    }
}
