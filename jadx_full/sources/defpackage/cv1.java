package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cv1 implements gd1 {
    public static final ku e = new ku(true, true, -1, -1, false, false, false, -1, -1, false, false, false, null);
    public static final ku f = new ku(true, false, -1, -1, false, false, false, -1, -1, true, false, false, null);
    public final String a;
    public final rw2 b;
    public final n84 c;
    public final n84 d;

    public cv1(String str, rw2 rw2Var, n84 n84Var, n84 n84Var2) {
        this.a = str;
        this.b = rw2Var;
        this.c = n84Var;
        this.d = n84Var2;
    }

    public static String d(String str, pj2 pj2Var) {
        String strB;
        String str2 = pj2Var != null ? pj2Var.a : null;
        if ((str2 == null || w44.j0(str2, HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE, false)) && (strB = j.b(MimeTypeMap.getSingleton(), str)) != null) {
            return strB;
        }
        if (str2 != null) {
            return p44.Q0(str2, ';');
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[Catch: Exception -> 0x005d, TRY_ENTER, TryCatch #0 {Exception -> 0x005d, blocks: (B:20:0x0052, B:56:0x012e, B:101:0x01ee, B:102:0x01f3, B:36:0x009d, B:38:0x00a7, B:45:0x00d5, B:48:0x00ee, B:53:0x0119, B:41:0x00bd, B:43:0x00c7, B:50:0x0104, B:51:0x010b, B:52:0x010c), top: B:106:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c A[Catch: Exception -> 0x005d, TryCatch #0 {Exception -> 0x005d, blocks: (B:20:0x0052, B:56:0x012e, B:101:0x01ee, B:102:0x01f3, B:36:0x009d, B:38:0x00a7, B:45:0x00d5, B:48:0x00ee, B:53:0x0119, B:41:0x00bd, B:43:0x00c7, B:50:0x0104, B:51:0x010b, B:52:0x010c), top: B:106:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b4 A[Catch: Exception -> 0x01da, TryCatch #2 {Exception -> 0x01da, blocks: (B:83:0x01ae, B:85:0x01b4, B:89:0x01d6, B:93:0x01dd, B:94:0x01e2), top: B:109:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01dd A[Catch: Exception -> 0x01da, TryCatch #2 {Exception -> 0x01da, blocks: (B:83:0x01ae, B:85:0x01b4, B:89:0x01d6, B:93:0x01dd, B:94:0x01e2), top: B:109:0x01ae }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v19 */
    @Override // defpackage.gd1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ge0 ge0Var) throws Exception {
        bv1 bv1Var;
        pe3 pe3Var;
        qu quVarA;
        Object objB;
        qe3 qe3Var;
        pe3 pe3Var2;
        kk3 kk3Var;
        kk3 kk3Var2;
        ok3 ok3Var;
        cv1 cv1Var = this;
        if (ge0Var instanceof bv1) {
            bv1Var = (bv1) ge0Var;
            int i = bv1Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                bv1Var.z0 = i - Integer.MIN_VALUE;
            } else {
                bv1Var = new bv1(cv1Var, (ie0) ge0Var);
            }
        }
        Object obj = bv1Var.Z;
        ?? r3 = bv1Var.z0;
        pi0 pi0Var = pi0.A;
        pi0 pi0Var2 = pi0.z;
        mf0 mf0Var = mf0.b;
        try {
        } catch (Exception e2) {
            e = e2;
        }
        if (r3 == 0) {
            n12.S(obj);
            rw2 rw2Var = cv1Var.b;
            boolean z = rw2Var.n.b;
            String str = cv1Var.a;
            if (z && (qe3Var = (qe3) cv1Var.d.getValue()) != null) {
                String str2 = rw2Var.i;
                if (str2 == null) {
                    str2 = str;
                }
                jv0 jv0Var = qe3Var.b;
                bu buVar = bu.A;
                hv0 hv0VarS = jv0Var.s(t60.n(str2).c("SHA-256").e());
                if (hv0VarS != null) {
                    pe3Var = new pe3(hv0VarS);
                }
                if (pe3Var == null) {
                }
                cm2 cm2Var = quVarA.a;
                cm2Var.getClass();
                bv1Var.A = cv1Var;
                bv1Var.X = pe3Var;
                bv1Var.Y = quVarA;
                bv1Var.z0 = 1;
                objB = cv1Var.b(cm2Var, bv1Var);
                if (objB != mf0Var) {
                }
                return mf0Var;
            }
            pe3Var = null;
            if (pe3Var == null) {
                ge1 ge1VarC = cv1Var.c();
                hv0 hv0Var = pe3Var.b;
                if (hv0Var.f) {
                    throw new IllegalStateException("snapshot is closed");
                }
                Long l = (Long) ge1VarC.M((u03) hv0Var.b.c.get(0)).e;
                if (l != null && l.longValue() == 0) {
                    return new pz3(cv1Var.g(pe3Var), d(str, null), pi0Var2);
                }
                quVarA = new pu(cv1Var.e(), cv1Var.f(pe3Var)).a();
                ou ouVar = quVarA.b;
                if (quVarA.a == null && ouVar != null) {
                    return new pz3(cv1Var.g(pe3Var), d(str, (pj2) ouVar.b.getValue()), pi0Var2);
                }
            } else {
                quVarA = new pu(cv1Var.e(), null).a();
            }
            cm2 cm2Var2 = quVarA.a;
            cm2Var2.getClass();
            bv1Var.A = cv1Var;
            bv1Var.X = pe3Var;
            bv1Var.Y = quVarA;
            bv1Var.z0 = 1;
            objB = cv1Var.b(cm2Var2, bv1Var);
            if (objB != mf0Var) {
            }
            return mf0Var;
            if (r3 != 0) {
                j.a(r3);
            }
            throw e;
        }
        if (r3 == 1) {
            qu quVar = (qu) bv1Var.Y;
            pe3Var = bv1Var.X;
            cv1 cv1Var2 = bv1Var.A;
            n12.S(obj);
            quVarA = quVar;
            cv1Var = cv1Var2;
            objB = obj;
        } else {
            if (r3 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            kk3Var = (kk3) bv1Var.Y;
            pe3Var2 = bv1Var.X;
            cv1Var = bv1Var.A;
            try {
                n12.S(obj);
                kk3Var2 = (kk3) obj;
                try {
                    Bitmap.Config config = j.a;
                    ok3Var = kk3Var2.Z;
                    if (ok3Var != null) {
                        throw new IllegalStateException("response body == null");
                    }
                    cv1Var.getClass();
                    cq cqVarX = ok3Var.x();
                    Context context = cv1Var.b.a;
                    nz3 nz3Var = new nz3(cqVarX, null);
                    String strD = d(cv1Var.a, ok3Var.s());
                    if (kk3Var2.z0 == null) {
                        pi0Var = pi0Var2;
                    }
                    return new pz3(nz3Var, strD, pi0Var);
                } catch (Exception e3) {
                    e = e3;
                    kk3Var = kk3Var2;
                    try {
                        j.a(kk3Var);
                        throw e;
                    } catch (Exception e4) {
                        e = e4;
                        r3 = pe3Var2;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                j.a(kk3Var);
                throw e;
            }
        }
        kk3 kk3Var3 = (kk3) objB;
        Bitmap.Config config2 = j.a;
        ok3 ok3Var2 = kk3Var3.Z;
        if (ok3Var2 == null) {
            throw new IllegalStateException("response body == null");
        }
        try {
            pe3 pe3VarH = cv1Var.h(pe3Var, quVarA.a, kk3Var3, quVarA.b);
            String str3 = cv1Var.a;
            try {
                if (pe3VarH != null) {
                    sd1 sd1VarG = cv1Var.g(pe3VarH);
                    ou ouVarF = cv1Var.f(pe3VarH);
                    return new pz3(sd1VarG, d(str3, ouVarF != null ? (pj2) ouVarF.b.getValue() : null), pi0Var);
                }
                if (ok3Var2.x().request(1L)) {
                    cq cqVarX2 = ok3Var2.x();
                    Context context2 = cv1Var.b.a;
                    nz3 nz3Var2 = new nz3(cqVarX2, null);
                    String strD2 = d(str3, ok3Var2.s());
                    if (kk3Var3.z0 == null) {
                        pi0Var = pi0Var2;
                    }
                    return new pz3(nz3Var2, strD2, pi0Var);
                }
                j.a(kk3Var3);
                cm2 cm2VarE = cv1Var.e();
                bv1Var.A = cv1Var;
                bv1Var.X = pe3VarH;
                bv1Var.Y = kk3Var3;
                bv1Var.z0 = 2;
                Object objB2 = cv1Var.b(cm2VarE, bv1Var);
                if (objB2 != mf0Var) {
                    pe3Var2 = pe3VarH;
                    obj = objB2;
                    kk3Var = kk3Var3;
                    kk3Var2 = (kk3) obj;
                    Bitmap.Config config3 = j.a;
                    ok3Var = kk3Var2.Z;
                    if (ok3Var != null) {
                    }
                }
                return mf0Var;
            } catch (Exception e6) {
                e = e6;
                pe3Var2 = pe3VarH;
                kk3Var = kk3Var3;
                j.a(kk3Var);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            pe3Var2 = pe3Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(cm2 cm2Var, ie0 ie0Var) {
        av1 av1Var;
        kk3 kk3VarE;
        boolean z;
        if (ie0Var instanceof av1) {
            av1Var = (av1) ie0Var;
            int i = av1Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                av1Var.Y = i - Integer.MIN_VALUE;
            } else {
                av1Var = new av1(this, ie0Var);
            }
        }
        Object objU = av1Var.A;
        int i2 = av1Var.Y;
        if (i2 == 0) {
            n12.S(objU);
            Bitmap.Config config = j.a;
            boolean zC = n12.c(Looper.myLooper(), Looper.getMainLooper());
            n84 n84Var = this.c;
            if (zC) {
                if (this.b.o.b) {
                    throw new NetworkOnMainThreadException();
                }
                lu2 lu2Var = (lu2) n84Var.getValue();
                lu2Var.getClass();
                cm2Var.getClass();
                kk3VarE = new le3(lu2Var, cm2Var).e();
                z = kk3VarE.H0;
                int i3 = kk3VarE.A;
                if (!z || i3 == 304) {
                    return kk3VarE;
                }
                ok3 ok3Var = kk3VarE.Z;
                if (ok3Var != null) {
                    j.a(ok3Var);
                }
                StringBuilder sbD = dw2.D("HTTP ", i3, ": ");
                sbD.append(kk3VarE.z);
                throw new t80(sbD.toString());
            }
            lu2 lu2Var2 = (lu2) n84Var.getValue();
            lu2Var2.getClass();
            cm2Var.getClass();
            le3 le3Var = new le3(lu2Var2, cm2Var);
            av1Var.Y = 1;
            z00 z00Var = new z00(1, p95.u(av1Var));
            z00Var.w();
            he0 he0Var = new he0(0, le3Var, z00Var);
            le3Var.d(he0Var);
            z00Var.y(he0Var);
            objU = z00Var.u();
            mf0 mf0Var = mf0.b;
            if (objU == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objU);
        }
        kk3VarE = (kk3) objU;
        z = kk3VarE.H0;
        int i32 = kk3VarE.A;
        if (z) {
        }
        return kk3VarE;
    }

    public final ge1 c() {
        Object value = this.d.getValue();
        value.getClass();
        return ((qe3) value).a;
    }

    public final cm2 e() {
        v92 v92Var = new v92(15);
        v92Var.w(this.a);
        rw2 rw2Var = this.b;
        lr1 lr1Var = rw2Var.j;
        lr1Var.getClass();
        v92Var.z = gb4.A(lr1Var);
        for (Map.Entry entry : rw2Var.k.a.entrySet()) {
            Object key = entry.getKey();
            key.getClass();
            Object value = entry.getValue();
            v92Var.X = ((p95) v92Var.X).A(dh3.a((Class) key), value);
        }
        mu muVar = rw2Var.n;
        boolean z = muVar.b;
        boolean z2 = rw2Var.o.b;
        if (!z2 && z) {
            v92Var.f(ku.o);
        } else if (!z2 || z) {
            if (!z2 && !z) {
                v92Var.f(f);
            }
        } else if (muVar.f) {
            v92Var.f(ku.n);
        } else {
            v92Var.f(e);
        }
        return new cm2(v92Var);
    }

    public final ou f(pe3 pe3Var) throws Throwable {
        Throwable th;
        ou ouVar;
        try {
            ge1 ge1VarC = c();
            hv0 hv0Var = pe3Var.b;
            if (hv0Var.f) {
                throw new IllegalStateException("snapshot is closed");
            }
            lz3 lz3VarX = ge1VarC.X((u03) hv0Var.b.c.get(0));
            lz3VarX.getClass();
            he3 he3Var = new he3(lz3VarX);
            try {
                ouVar = new ou(he3Var);
                try {
                    he3Var.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    he3Var.close();
                } catch (Throwable th4) {
                    ek0.b(th3, th4);
                }
                th = th3;
                ouVar = null;
            }
            if (th == null) {
                return ouVar;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    public final sd1 g(pe3 pe3Var) {
        hv0 hv0Var = pe3Var.b;
        if (hv0Var.f) {
            xe.q("snapshot is closed");
            return null;
        }
        u03 u03Var = (u03) hv0Var.b.c.get(1);
        ge1 ge1VarC = c();
        String str = this.b.i;
        if (str == null) {
            str = this.a;
        }
        return new sd1(u03Var, ge1VarC, str, pe3Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final pe3 h(pe3 pe3Var, cm2 cm2Var, kk3 kk3Var, ou ouVar) {
        wn1 wn1Var;
        Throwable th;
        ue1 ue1VarN;
        Throwable th2 = null;
        if (this.b.n.f && !cm2Var.e().b) {
            ku kuVarI = kk3Var.G0;
            if (kuVarI == null) {
                ku kuVar = ku.n;
                kuVarI = uf2.I(kk3Var.Y);
                kk3Var.G0 = kuVarI;
            }
            if (!kuVarI.b && !n12.c(kk3Var.Y.a("Vary"), WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                int i = 14;
                if (pe3Var != null) {
                    hv0 hv0Var = pe3Var.b;
                    jv0 jv0Var = hv0Var.z;
                    synchronized (jv0Var) {
                        hv0Var.close();
                        ue1VarN = jv0Var.n(hv0Var.b.a);
                    }
                    wn1Var = ue1VarN != null ? new wn1(i, ue1VarN) : null;
                    if (wn1Var != null) {
                        try {
                            try {
                                if (kk3Var.A != 304 || ouVar == null) {
                                    ge3 ge3VarD = co4.d(c().U(((ue1) wn1Var.f).h(0)));
                                    try {
                                        new ou(kk3Var).a(ge3VarD);
                                        try {
                                            ge3VarD.close();
                                            th = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    } catch (Throwable th4) {
                                        try {
                                            ge3VarD.close();
                                        } catch (Throwable th5) {
                                            ek0.b(th4, th5);
                                        }
                                        th = th4;
                                    }
                                    if (th != null) {
                                        throw th;
                                    }
                                    ge3 ge3VarD2 = co4.d(c().U(((ue1) wn1Var.f).h(1)));
                                    try {
                                        ok3 ok3Var = kk3Var.Z;
                                        ok3Var.getClass();
                                        ok3Var.x().u0(ge3VarD2);
                                        try {
                                            ge3VarD2.close();
                                        } catch (Throwable th6) {
                                            th2 = th6;
                                        }
                                    } catch (Throwable th7) {
                                        th2 = th7;
                                        try {
                                            ge3VarD2.close();
                                        } catch (Throwable th8) {
                                            ek0.b(th2, th8);
                                        }
                                    }
                                    if (th2 != null) {
                                        throw th2;
                                    }
                                } else {
                                    jk3 jk3VarN = kk3Var.n();
                                    jk3VarN.f = gb4.A(yr2.j(ouVar.f, kk3Var.Y));
                                    kk3 kk3VarA = jk3VarN.a();
                                    ge3 ge3VarD3 = co4.d(c().U(((ue1) wn1Var.f).h(0)));
                                    try {
                                        new ou(kk3VarA).a(ge3VarD3);
                                        try {
                                            ge3VarD3.close();
                                        } catch (Throwable th9) {
                                            th2 = th9;
                                        }
                                    } catch (Throwable th10) {
                                        th2 = th10;
                                        try {
                                            ge3VarD3.close();
                                        } catch (Throwable th11) {
                                            ek0.b(th2, th11);
                                        }
                                    }
                                    if (th2 != null) {
                                        throw th2;
                                    }
                                }
                                pe3 pe3VarY = wn1Var.y();
                                j.a(kk3Var);
                                return pe3VarY;
                            } catch (Exception e2) {
                                Bitmap.Config config = j.a;
                                try {
                                    ((ue1) wn1Var.f).e(false);
                                } catch (Exception unused) {
                                }
                                throw e2;
                            }
                        } catch (Throwable th12) {
                            j.a(kk3Var);
                            throw th12;
                        }
                    }
                } else {
                    qe3 qe3Var = (qe3) this.d.getValue();
                    if (qe3Var != null) {
                        String str = this.b.i;
                        if (str == null) {
                            str = this.a;
                        }
                        jv0 jv0Var2 = qe3Var.b;
                        bu buVar = bu.A;
                        ue1 ue1VarN2 = jv0Var2.n(t60.n(str).c("SHA-256").e());
                        if (ue1VarN2 != null) {
                            wn1Var = new wn1(i, ue1VarN2);
                        }
                        if (wn1Var != null) {
                        }
                    }
                }
            }
        } else if (pe3Var != null) {
            j.a(pe3Var);
        }
        return null;
    }
}
