package defpackage;

import io.netty.handler.codec.http.HttpHeaders;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ru1 {
    public static final bu a;
    public static final bu b;

    static {
        bu buVar = bu.A;
        a = t60.n("\"\\");
        b = t60.n("\t ,=");
    }

    public static final boolean a(kk3 kk3Var) {
        if (n12.c((String) kk3Var.b.z, "HEAD")) {
            return false;
        }
        int i = kk3Var.A;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && jz4.e(kk3Var) == -1 && !HttpHeaders.Values.CHUNKED.equalsIgnoreCase(kk3.g(kk3Var, HttpHeaders.Names.TRANSFER_ENCODING))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0103, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0103, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(defpackage.hp r17, java.util.ArrayList r18) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ru1.b(hp, java.util.ArrayList):void");
    }

    public static final String c(hp hpVar) {
        long jN = hpVar.N(b);
        if (jN == -1) {
            jN = hpVar.f;
        }
        if (jN != 0) {
            return hpVar.r0(jN, y30.a);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(defpackage.ne0 r36, defpackage.ev1 r37, defpackage.lr1 r38) {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ru1.d(ne0, ev1, lr1):void");
    }

    public static final boolean e(hp hpVar) {
        boolean z = false;
        while (!hpVar.x()) {
            byte bC = hpVar.C(0L);
            if (bC != 44) {
                if (bC != 32 && bC != 9) {
                    break;
                }
                hpVar.U();
            } else {
                hpVar.U();
                z = true;
            }
        }
        return z;
    }
}
