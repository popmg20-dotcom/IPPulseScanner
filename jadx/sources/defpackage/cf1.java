package defpackage;

import android.net.TrafficStats;
import android.text.TextUtils;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cf1 implements df1 {
    public static final Object k = new Object();
    public final ze1 a;
    public final af1 b;
    public final v62 c;
    public final a92 d;
    public final Object e;
    public final ExecutorService f;
    public final zs3 g;
    public String h;
    public final HashSet i;
    public final ArrayList j;

    static {
        new AtomicInteger(1);
    }

    public cf1(ze1 ze1Var, da3 da3Var, ExecutorService executorService, zs3 zs3Var) {
        ze1Var.a();
        af1 af1Var = new af1(ze1Var.a, da3Var);
        v62 v62Var = new v62(12, ze1Var);
        c84 c84Var = c84.f;
        if (c84Var == null) {
            c84Var = new c84(1);
            c84.f = c84Var;
        }
        if (do4.b == null) {
            do4.b = new do4(c84Var);
        }
        a92 a92Var = new a92(new m90(2, ze1Var));
        this.e = new Object();
        this.i = new HashSet();
        this.j = new ArrayList();
        this.a = ze1Var;
        this.b = af1Var;
        this.c = v62Var;
        this.d = a92Var;
        this.f = executorService;
        this.g = zs3Var;
    }

    public static cf1 d() {
        ze1 ze1VarB = ze1.b();
        ze1VarB.a();
        return (cf1) ze1VarB.d.get(df1.class);
    }

    public final wt2 a() {
        wa4 wa4Var = new wa4();
        vo1 vo1Var = new vo1(wa4Var);
        synchronized (this.e) {
            this.j.add(vo1Var);
        }
        return wa4Var.a;
    }

    public final eh b(eh ehVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        int responseCode;
        String str;
        rh rhVarF;
        ze1 ze1Var = this.a;
        ze1Var.a();
        String str2 = ze1Var.c.a;
        String str3 = ehVar.a;
        ze1Var.a();
        String str4 = ze1Var.c.g;
        String str5 = ehVar.d;
        af1 af1Var = this.b;
        lj3 lj3Var = af1Var.c;
        if (!lj3Var.b()) {
            throw new ef1("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = af1.a("projects/" + str4 + "/installations/" + str3 + "/authTokens:generate");
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = af1Var.c(urlA, str2);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str5);
                    httpURLConnectionC.setDoOutput(true);
                    af1.h(httpURLConnectionC);
                    responseCode = httpURLConnectionC.getResponseCode();
                    lj3Var.d(responseCode);
                } catch (IOException | AssertionError unused) {
                    httpURLConnection = httpURLConnectionC;
                }
                if (responseCode >= 200 && responseCode < 300) {
                    rhVarF = af1.f(httpURLConnectionC);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    str = null;
                } else {
                    af1.b(httpURLConnectionC, null, str2, str4);
                    httpURLConnection = httpURLConnectionC;
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            throw th;
                        }
                    } catch (IOException | AssertionError unused2) {
                    }
                    if (responseCode == 401 || responseCode == 404) {
                        if (((byte) (0 | 1)) != 1) {
                            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                        }
                        str = null;
                        rh rhVar = new rh(3, 0L, null);
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        rhVarF = rhVar;
                    } else {
                        if (responseCode == 429) {
                            throw new ef1("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                        if (responseCode < 500 || responseCode >= 600) {
                            a1.d("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                            if (((byte) (0 | 1)) != 1) {
                                throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                            }
                            rh rhVar2 = new rh(2, 0L, null);
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            rhVarF = rhVar2;
                            str = null;
                        }
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                }
                int iG = fw.G(rhVarF.c);
                if (iG == 0) {
                    String str6 = rhVarF.a;
                    long j = rhVarF.b;
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    dh dhVarA = ehVar.a();
                    dhVarA.c = str6;
                    dhVarA.e = j;
                    byte b = (byte) (dhVarA.h | 1);
                    dhVarA.f = jCurrentTimeMillis;
                    dhVarA.h = (byte) (b | 2);
                    return dhVarA.a();
                }
                if (iG == 1) {
                    dh dhVarA2 = ehVar.a();
                    dhVarA2.g = "BAD CONFIG";
                    dhVarA2.b = 5;
                    return dhVarA2.a();
                }
                if (iG != 2) {
                    throw new ef1("Firebase Installations Service is unavailable. Please try again later.");
                }
                j(str);
                dh dhVarA3 = ehVar.a();
                dhVarA3.b = 2;
                return dhVarA3.a();
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnectionC;
            }
        }
        throw new ef1("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final wt2 c() {
        String str;
        ze1 ze1Var = this.a;
        ze1Var.a();
        tj4.g(ze1Var.c.b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        ze1 ze1Var2 = this.a;
        ze1Var2.a();
        tj4.g(ze1Var2.c.g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        ze1 ze1Var3 = this.a;
        ze1Var3.a();
        tj4.g(ze1Var3.c.a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        ze1 ze1Var4 = this.a;
        ze1Var4.a();
        String str2 = ze1Var4.c.b;
        Pattern pattern = do4.a;
        if (!str2.contains(":")) {
            xe.k("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
            return null;
        }
        ze1 ze1Var5 = this.a;
        ze1Var5.a();
        if (!do4.a.matcher(ze1Var5.c.a).matches()) {
            xe.k("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
            return null;
        }
        synchronized (this) {
            str = this.h;
        }
        if (str != null) {
            wt2 wt2Var = new wt2();
            wt2Var.g(str);
            return wt2Var;
        }
        wt2 wt2VarA = a();
        this.f.execute(new bf1(this, 0));
        return wt2VarA;
    }

    /* JADX WARN: Finally extract failed */
    public final void e(eh ehVar) {
        synchronized (k) {
            try {
                ze1 ze1Var = this.a;
                ze1Var.a();
                eg0 eg0VarS = eg0.s(ze1Var.a);
                try {
                    this.c.D(ehVar);
                    if (eg0VarS != null) {
                        eg0VarS.R();
                    }
                } catch (Throwable th) {
                    if (eg0VarS != null) {
                        eg0VarS.R();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(defpackage.eh r3) {
        /*
            r2 = this;
            ze1 r0 = r2.a
            r0.a()
            java.lang.String r0 = r0.b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            ze1 r0 = r2.a
            java.lang.String r1 = "[DEFAULT]"
            r0.a()
            java.lang.String r0 = r0.b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4b
        L1e:
            int r3 = r3.b
            r0 = 1
            if (r3 != r0) goto L4b
            a92 r2 = r2.d
            java.lang.Object r2 = r2.get()
            fx1 r2 = (defpackage.fx1) r2
            android.content.SharedPreferences r3 = r2.a
            monitor-enter(r3)
            java.lang.String r0 = r2.a()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            goto L3d
        L36:
            r2 = move-exception
            goto L49
        L38:
            java.lang.String r0 = r2.b()     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
        L3d:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L48
            java.lang.String r2 = defpackage.jd3.a()
            return r2
        L48:
            return r0
        L49:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r2
        L4b:
            java.lang.String r2 = defpackage.jd3.a()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cf1.f(eh):java.lang.String");
    }

    public final eh g(eh ehVar) throws ef1 {
        int responseCode;
        yg ygVarE;
        String str = ehVar.a;
        String string = null;
        if (str != null && str.length() == 11) {
            fx1 fx1Var = (fx1) this.d.get();
            synchronized (fx1Var.a) {
                try {
                    String[] strArr = fx1.c;
                    int i = 0;
                    while (true) {
                        if (i < 4) {
                            String str2 = strArr[i];
                            String string2 = fx1Var.a.getString("|T|" + fx1Var.b + "|" + str2, null);
                            if (string2 == null || string2.isEmpty()) {
                                i++;
                            } else if (string2.startsWith("{")) {
                                try {
                                    string = new JSONObject(string2).getString("token");
                                } catch (JSONException unused) {
                                }
                            } else {
                                string = string2;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        af1 af1Var = this.b;
        ze1 ze1Var = this.a;
        ze1Var.a();
        String str3 = ze1Var.c.a;
        String str4 = ehVar.a;
        ze1 ze1Var2 = this.a;
        ze1Var2.a();
        String str5 = ze1Var2.c.g;
        ze1 ze1Var3 = this.a;
        ze1Var3.a();
        String str6 = ze1Var3.c.b;
        lj3 lj3Var = af1Var.c;
        if (!lj3Var.b()) {
            throw new ef1("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = af1.a("projects/" + str5 + "/installations");
        for (int i2 = 0; i2 <= 1; i2++) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = af1Var.c(urlA, str3);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    af1.g(httpURLConnectionC, str4, str6);
                    responseCode = httpURLConnectionC.getResponseCode();
                    lj3Var.d(responseCode);
                } finally {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused2) {
            }
            if (responseCode >= 200 && responseCode < 300) {
                ygVarE = af1.e(httpURLConnectionC);
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
            } else {
                af1.b(httpURLConnectionC, str6, str3, str5);
                if (responseCode == 429) {
                    throw new ef1("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                }
                if (responseCode < 500 || responseCode >= 600) {
                    a1.d("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    yg ygVar = new yg(null, null, null, null, 2);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    ygVarE = ygVar;
                }
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
            int iG = fw.G(ygVarE.e);
            if (iG != 0) {
                if (iG != 1) {
                    throw new ef1("Firebase Installations Service is unavailable. Please try again later.");
                }
                dh dhVarA = ehVar.a();
                dhVarA.g = "BAD CONFIG";
                dhVarA.b = 5;
                return dhVarA.a();
            }
            String str7 = ygVarE.b;
            String str8 = ygVarE.c;
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            rh rhVar = ygVarE.d;
            String str9 = rhVar.a;
            long j = rhVar.b;
            dh dhVarA2 = ehVar.a();
            dhVarA2.a = str7;
            dhVarA2.b = 4;
            dhVarA2.c = str9;
            dhVarA2.d = str8;
            dhVarA2.e = j;
            byte b = (byte) (dhVarA2.h | 1);
            dhVarA2.f = jCurrentTimeMillis;
            dhVarA2.h = (byte) (b | 2);
            return dhVarA2.a();
        }
        throw new ef1("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void h() {
        synchronized (this.e) {
            try {
                Iterator it = this.j.iterator();
                while (it.hasNext()) {
                    ((vo1) it.next()).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(eh ehVar) {
        synchronized (this.e) {
            try {
                Iterator it = this.j.iterator();
                while (it.hasNext()) {
                    vo1 vo1Var = (vo1) it.next();
                    vo1Var.getClass();
                    int i = ehVar.b;
                    if (!(i == 3)) {
                        if (!(i == 4)) {
                            if (i == 5) {
                            }
                        }
                    }
                    vo1Var.a.b(ehVar.a);
                    it.remove();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void j(String str) {
        this.h = str;
    }

    public final synchronized void k(eh ehVar, eh ehVar2) {
        try {
            if (this.i.size() != 0 && !TextUtils.equals(ehVar.a, ehVar2.a)) {
                Iterator it = this.i.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
        } finally {
        }
    }
}
