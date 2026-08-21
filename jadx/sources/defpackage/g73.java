package defpackage;

import android.net.Uri;
import android.os.Build;
import android.os.FileObserver;
import android.webkit.URLUtil;
import androidx.core.content.FileProvider;
import com.getsurfboard.base.ContextUtilsKt;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class g73 {
    public static final FileObserver a;

    static {
        a = Build.VERSION.SDK_INT >= 29 ? new e73(d73.f()) : new f73(d73.f().getAbsolutePath(), 904);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0016, B:6:0x001d, B:9:0x0034), top: B:16:0x0016 }] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(android.net.Uri r7) throws java.io.IOException {
        /*
            r7.getClass()
            android.content.Context r0 = com.getsurfboard.base.ContextUtilsKt.getContext()
            android.content.ContentResolver r1 = r0.getContentResolver()
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            r2 = r7
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)
            if (r7 == 0) goto L34
            boolean r0 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L31
            r1 = 1
            if (r0 != r1) goto L34
            java.lang.String r0 = "_display_name"
            int r0 = r7.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r7.getString(r0)     // Catch: java.lang.Throwable -> L31
            r0.getClass()     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = ".conf"
            java.lang.String r0 = defpackage.p44.G0(r1, r0)     // Catch: java.lang.Throwable -> L31
            goto L3c
        L31:
            r0 = move-exception
            r1 = r0
            goto L45
        L34:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L31
        L3c:
            r1 = 0
            defpackage.ez4.l(r7, r1)
            java.lang.String r7 = d(r0)
            return r7
        L45:
            throw r1     // Catch: java.lang.Throwable -> L46
        L46:
            r0 = move-exception
            defpackage.ez4.l(r7, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g73.a(android.net.Uri):java.lang.String");
    }

    public static final String b(String str) {
        str.getClass();
        String strG0 = "Profile";
        if (w44.j0(str, "http://", false) || w44.j0(str, "https://", false)) {
            String strGuessFileName = URLUtil.guessFileName(str, null, null);
            List<String> listK = e70.K(".bin", ".php", ".html", ".htm", ".asp", ".aspx", ".jsp");
            if (listK.isEmpty()) {
                strGuessFileName.getClass();
                strG0 = p44.G0(".conf", strGuessFileName);
            } else {
                for (String str2 : listK) {
                    strGuessFileName.getClass();
                    if (w44.d0(strGuessFileName, str2, false)) {
                        String host = Uri.parse(str).getHost();
                        if (host != null) {
                            List listK0 = p44.K0(host, new char[]{'.'}, 6);
                            if (listK0.size() >= 2) {
                                strG0 = (String) listK0.get(listK0.size() - 2);
                            }
                        }
                    }
                }
                strGuessFileName.getClass();
                strG0 = p44.G0(".conf", strGuessFileName);
            }
        }
        return d(strG0);
    }

    public static final Uri c(String str) {
        str.getClass();
        File file = new File(d73.f(), str.concat(".conf"));
        if (!file.exists()) {
            return null;
        }
        try {
            return FileProvider.c(ContextUtilsKt.getContext(), ContextUtilsKt.getContext().getPackageName() + ".files_provider", file);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String d(String str) {
        str.getClass();
        boolean zExists = d73.g(str).exists();
        String str2 = str;
        if (zExists) {
            Pattern patternCompile = Pattern.compile("^([^(]+)\\(\\d+\\)$");
            patternCompile.getClass();
            Matcher matcher = patternCompile.matcher(str);
            matcher.getClass();
            uh2 uh2Var = !matcher.matches() ? null : new uh2(matcher, str);
            int i = 1;
            Object obj = str;
            if (uh2Var != null) {
                obj = ((sh2) uh2Var.a()).get(1);
            }
            while (true) {
                e1 e1Var = d73.a;
                if (!d73.g(obj + "(" + i + ")").exists()) {
                    break;
                }
                i++;
            }
            str2 = obj + "(" + i + ")";
        }
        boolean zP0 = p44.p0(str2, '/');
        String str3 = str2;
        if (zP0) {
            String strReplace = str2.replace('/', '-');
            strReplace.getClass();
            str3 = strReplace;
        }
        return str3.length() > 255 ? r25.K(str3) : str3;
    }
}
