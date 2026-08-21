package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wp1 {
    public static wp1 c;
    public final Context a;
    public volatile String b;

    public wp1(Context context) {
        this.a = context.getApplicationContext();
    }

    public static wp1 a(Context context) {
        wp1 wp1Var;
        tj4.i(context);
        synchronized (wp1.class) {
            try {
                wp1Var = c;
                if (wp1Var == null) {
                    wd5.a(context);
                    wp1Var = new wp1(context);
                    c = wp1Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wp1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f4, code lost:
    
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(android.content.pm.PackageInfo r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wp1.c(android.content.pm.PackageInfo, boolean):boolean");
    }

    public static g95 d(PackageInfo packageInfo, g95... g95VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                a1.n("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            ja5 ja5Var = new ja5(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < g95VarArr.length; i++) {
                if (g95VarArr[i].equals(ja5Var)) {
                    return g95VarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r18) {
        /*
            Method dump skipped, instruction units count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wp1.b(int):boolean");
    }
}
