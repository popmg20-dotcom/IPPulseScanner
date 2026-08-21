package defpackage;

import android.webkit.MimeTypeMap;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.ge0 r18) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cv1.a(ge0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.cm2 r5, defpackage.ie0 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.av1
            if (r0 == 0) goto L13
            r0 = r6
            av1 r0 = (defpackage.av1) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            av1 r0 = new av1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.A
            int r1 = r0.Y
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            defpackage.n12.S(r6)
            goto L99
        L25:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L2c:
            defpackage.n12.S(r6)
            android.graphics.Bitmap$Config r6 = defpackage.j.a
            android.os.Looper r6 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            boolean r6 = defpackage.n12.c(r6, r1)
            n84 r1 = r4.c
            if (r6 == 0) goto L65
            rw2 r4 = r4.b
            mu r4 = r4.o
            boolean r4 = r4.b
            if (r4 != 0) goto L5f
            java.lang.Object r4 = r1.getValue()
            lu2 r4 = (defpackage.lu2) r4
            r4.getClass()
            r5.getClass()
            le3 r6 = new le3
            r6.<init>(r4, r5)
            kk3 r4 = r6.e()
            goto L9c
        L5f:
            android.os.NetworkOnMainThreadException r4 = new android.os.NetworkOnMainThreadException
            r4.<init>()
            throw r4
        L65:
            java.lang.Object r4 = r1.getValue()
            lu2 r4 = (defpackage.lu2) r4
            r4.getClass()
            r5.getClass()
            le3 r6 = new le3
            r6.<init>(r4, r5)
            r0.Y = r2
            z00 r4 = new z00
            ge0 r5 = defpackage.p95.u(r0)
            r4.<init>(r2, r5)
            r4.w()
            he0 r5 = new he0
            r0 = 0
            r5.<init>(r0, r6, r4)
            r6.d(r5)
            r4.y(r5)
            java.lang.Object r6 = r4.u()
            mf0 r4 = defpackage.mf0.b
            if (r6 != r4) goto L99
            return r4
        L99:
            r4 = r6
            kk3 r4 = (defpackage.kk3) r4
        L9c:
            boolean r5 = r4.H0
            int r6 = r4.A
            if (r5 != 0) goto Lc4
            r5 = 304(0x130, float:4.26E-43)
            if (r6 == r5) goto Lc4
            ok3 r5 = r4.Z
            if (r5 == 0) goto Lad
            defpackage.j.a(r5)
        Lad:
            t80 r5 = new t80
            java.lang.String r0 = "HTTP "
            java.lang.String r1 = ": "
            java.lang.StringBuilder r6 = defpackage.dw2.D(r0, r6, r1)
            java.lang.String r4 = r4.z
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        Lc4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cv1.b(cm2, ie0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.pe3 h(defpackage.pe3 r4, defpackage.cm2 r5, defpackage.kk3 r6, defpackage.ou r7) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cv1.h(pe3, cm2, kk3, ou):pe3");
    }
}
