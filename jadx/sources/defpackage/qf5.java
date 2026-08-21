package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import android.util.Log;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qf5 extends k95 {
    public static final String[] C0 = {"firebase_", "google_", "ga_"};
    public static final String[] D0 = {"_err"};
    public Boolean A0;
    public Integer B0;
    public SecureRandom Y;
    public final AtomicLong Z;
    public int y0;
    public nj2 z0;

    public qf5(k85 k85Var) {
        super(k85Var);
        this.B0 = null;
        this.Z = new AtomicLong(0L);
    }

    public static byte[] B1(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList M1(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            q15 q15Var = (q15) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", q15Var.b);
            bundle.putString("origin", q15Var.f);
            bundle.putLong("creation_timestamp", q15Var.A);
            bundle.putString("name", q15Var.z.f);
            Object objA = q15Var.z.a();
            tj4.i(objA);
            ke0.K(bundle, objA);
            bundle.putBoolean("active", q15Var.X);
            String str = q15Var.Y;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            z25 z25Var = q15Var.Z;
            if (z25Var != null) {
                bundle.putString("timed_out_event_name", z25Var.b);
                y25 y25Var = z25Var.f;
                if (y25Var != null) {
                    bundle.putBundle("timed_out_event_params", y25Var.l());
                }
            }
            bundle.putLong("trigger_timeout", q15Var.y0);
            z25 z25Var2 = q15Var.z0;
            if (z25Var2 != null) {
                bundle.putString("triggered_event_name", z25Var2.b);
                y25 y25Var2 = z25Var2.f;
                if (y25Var2 != null) {
                    bundle.putBundle("triggered_event_params", y25Var2.l());
                }
            }
            bundle.putLong("triggered_timestamp", q15Var.z.z);
            bundle.putLong("time_to_live", q15Var.A0);
            z25 z25Var3 = q15Var.B0;
            if (z25Var3 != null) {
                bundle.putString("expired_event_name", z25Var3.b);
                y25 y25Var3 = z25Var3.f;
                if (y25Var3 != null) {
                    bundle.putBundle("expired_event_params", y25Var3.l());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean N1(Context context) {
        ActivityInfo receiverInfo;
        tj4.i(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void O1(rb5 rb5Var, Bundle bundle, boolean z) {
        if (bundle != null && rb5Var != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = rb5Var.a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = rb5Var.b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", rb5Var.c);
                return;
            }
            z = false;
        }
        if (bundle != null && rb5Var == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean Q1(int i, Bundle bundle) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean V1(String str) {
        tj4.f(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static String a1(int i, String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return str.substring(0, str.offsetByCodePoints(0, i)).concat("...");
        }
        return null;
    }

    public static boolean f2(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static void l1(of5 of5Var, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        Q1(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        of5Var.b(str, "_err", bundle);
    }

    public static MessageDigest m1() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long n1(byte[] bArr) {
        tj4.i(bArr);
        int length = bArr.length;
        long j = 0;
        if (length <= 0) {
            st4.g();
            return 0L;
        }
        int i = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
        }
        return j;
    }

    public static boolean o1(Context context) {
        tj4.i(context);
        return Build.VERSION.SDK_INT >= 24 ? p1(context, "com.google.android.gms.measurement.AppMeasurementJobService") : p1(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean p1(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static int r1() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public static boolean t1(String str) {
        String str2 = (String) r55.s0.a(null);
        return str2.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean v1(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean w1(String str, String[] strArr) {
        tj4.i(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean A1(Context context, String str) {
        Signature[] signatureArr;
        k85 k85Var = (k85) this.f;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoA = ay4.a(context).a(64, str);
            if (packageInfoA == null || (signatureArr = packageInfoA.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.b(e, "Package name not found");
            return true;
        } catch (CertificateException e2) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(e2, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean C1(int i) {
        Boolean bool = ((k85) this.f).j().y0;
        if (D1() < i / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int D1() {
        Integer numValueOf = this.B0;
        if (numValueOf == null) {
            k85 k85Var = (k85) this.f;
            mp1 mp1Var = mp1.b;
            Context context = k85Var.b;
            mp1Var.getClass();
            int i = up1.e;
            int i2 = 0;
            try {
                i2 = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                a1.n("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            numValueOf = Integer.valueOf(i2 / 1000);
            this.B0 = numValueOf;
        }
        return numValueOf.intValue();
    }

    public final void E1(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(Long.valueOf(j2), "Params already contained engagement");
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void F1(String str, v35 v35Var) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning string value to wrapper");
        }
    }

    public final void G1(v35 v35Var, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning long value to wrapper");
        }
    }

    public final void H1(v35 v35Var, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning int value to wrapper");
        }
    }

    public final void I1(v35 v35Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning byte array to wrapper");
        }
    }

    public final void J1(v35 v35Var, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning boolean value to wrapper");
        }
    }

    public final void K1(v35 v35Var, Bundle bundle) {
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning bundle value to wrapper");
        }
    }

    public final void L1(v35 v35Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning bundle list to wrapper");
        }
    }

    public final String P1() {
        byte[] bArr = new byte[16];
        U1().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object R1(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return a1(i, obj.toString(), z);
        }
        if (!z2) {
            return null;
        }
        if (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[])) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleY1 = y1((Bundle) parcelable);
                if (!bundleY1.isEmpty()) {
                    arrayList.add(bundleY1);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int S1(String str) {
        k85 k85Var = (k85) this.f;
        if ("_ldl".equals(str)) {
            x15 x15Var = k85Var.A;
            return 2048;
        }
        if ("_id".equals(str)) {
            x15 x15Var2 = k85Var.A;
            return 256;
        }
        if ("_lgclid".equals(str)) {
            x15 x15Var3 = k85Var.A;
            return 100;
        }
        x15 x15Var4 = k85Var.A;
        return 36;
    }

    public final long T1() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.Z;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.Z;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNanoTime = System.nanoTime();
            ((k85) this.f).B0.getClass();
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.y0 + 1;
            this.y0 = i;
            j = jNextLong + ((long) i);
        }
        return j;
    }

    public final SecureRandom U1() {
        V0();
        SecureRandom secureRandom = this.Y;
        if (secureRandom != null) {
            return secureRandom;
        }
        SecureRandom secureRandom2 = new SecureRandom();
        this.Y = secureRandom2;
        return secureRandom2;
    }

    @Override // defpackage.k95
    public final boolean W0() {
        return true;
    }

    public final Bundle W1(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                    queryParameter5 = uri.getQueryParameter("gbraid");
                    queryParameter6 = uri.getQueryParameter("utm_id");
                    queryParameter7 = uri.getQueryParameter("dclid");
                    queryParameter8 = uri.getQueryParameter("srsltid");
                    queryParameter9 = uri.getQueryParameter("sfmc_id");
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                    queryParameter5 = null;
                    queryParameter6 = null;
                    queryParameter7 = null;
                    queryParameter8 = null;
                    queryParameter9 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (TextUtils.isEmpty(queryParameter)) {
                    str = "sfmc_id";
                } else {
                    str = "sfmc_id";
                    bundle.putString("campaign", queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("source", queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("medium", queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("gbraid", queryParameter5);
                }
                String queryParameter10 = uri.getQueryParameter("gad_source");
                if (!TextUtils.isEmpty(queryParameter10)) {
                    bundle.putString("gad_source", queryParameter10);
                }
                String queryParameter11 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter11)) {
                    bundle.putString("term", queryParameter11);
                }
                String queryParameter12 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter12)) {
                    bundle.putString("content", queryParameter12);
                }
                String queryParameter13 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter13)) {
                    bundle.putString("aclid", queryParameter13);
                }
                String queryParameter14 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter14)) {
                    bundle.putString("cp1", queryParameter14);
                }
                String queryParameter15 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter15)) {
                    bundle.putString("anid", queryParameter15);
                }
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("campaign_id", queryParameter6);
                }
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("dclid", queryParameter7);
                }
                String queryParameter16 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter16)) {
                    bundle.putString("source_platform", queryParameter16);
                }
                String queryParameter17 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter17)) {
                    bundle.putString("creative_format", queryParameter17);
                }
                String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter18)) {
                    bundle.putString("marketing_tactic", queryParameter18);
                }
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("srsltid", queryParameter8);
                }
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString(str, queryParameter9);
                }
                for (String str2 : uri.getQueryParameterNames()) {
                    if (str2.startsWith("gad_")) {
                        String queryParameter19 = uri.getQueryParameter(str2);
                        if (!TextUtils.isEmpty(queryParameter19)) {
                            bundle.putString(str2, queryParameter19);
                        }
                    }
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.C0.b(e, "Install referrer url isn't a hierarchical URI");
            }
        }
        return null;
    }

    public final boolean X1(String str, String str2) {
        k85 k85Var = (k85) this.f;
        if (str2 == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.B0.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.B0.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            t65 t65Var3 = k85Var.Y;
            k85.h(t65Var3);
            t65Var3.B0.c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                t65 t65Var4 = k85Var.Y;
                k85.h(t65Var4);
                t65Var4.B0.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean Y1(String str, String str2) {
        k85 k85Var = (k85) this.f;
        if (str2 == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.B0.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.B0.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                t65 t65Var3 = k85Var.Y;
                k85.h(t65Var3);
                t65Var3.B0.c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                t65 t65Var4 = k85Var.Y;
                k85.h(t65Var4);
                t65Var4.B0.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean Z0(String str) {
        k85 k85Var = (k85) this.f;
        if (TextUtils.isEmpty(str)) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.B0.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        tj4.i(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        t65 t65Var2 = k85Var.Y;
        k85.h(t65Var2);
        t65Var2.B0.b(t65.Z0(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
        return false;
    }

    public final boolean Z1(String str, String[] strArr, String[] strArr2, String str2) {
        k85 k85Var = (k85) this.f;
        if (str2 == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.B0.b(str, "Name is required and can't be null. Type");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(C0[i])) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.B0.c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !w1(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && w1(str2, strArr2)) {
            return true;
        }
        t65 t65Var3 = k85Var.Y;
        k85.h(t65Var3);
        t65Var3.B0.c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean a2(String str, int i, String str2) {
        k85 k85Var = (k85) this.f;
        if (str2 == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.B0.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        t65 t65Var2 = k85Var.Y;
        k85.h(t65Var2);
        t65Var2.B0.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b1(java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf5.b1(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int b2(String str) {
        if (!Y1("event", str)) {
            return 2;
        }
        if (!Z1("event", xb5.Z, xb5.y0, str)) {
            return 13;
        }
        x15 x15Var = ((k85) this.f).A;
        return !a2("event", 40, str) ? 2 : 0;
    }

    public final Object c1(Object obj, String str) {
        k85 k85Var = (k85) this.f;
        int iMax = 500;
        if ("_ev".equals(str)) {
            k85Var.A.getClass();
            return R1(Math.max(500, 256), obj, true, true);
        }
        if (v1(str)) {
            k85Var.A.getClass();
            iMax = Math.max(500, 256);
        } else {
            k85Var.A.getClass();
        }
        return R1(iMax, obj, false, true);
    }

    public final int c2(String str) {
        if (!Y1("user property", str)) {
            return 6;
        }
        if (!Z1("user property", ye.d, null, str)) {
            return 15;
        }
        x15 x15Var = ((k85) this.f).A;
        return !a2("user property", 24, str) ? 6 : 0;
    }

    public final Bundle d1(String str, Bundle bundle, List list, boolean z) {
        int iD2;
        String str2;
        List list2 = list;
        boolean zW1 = w1(str, xb5.A0);
        String str3 = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        k85 k85Var = (k85) this.f;
        x15 x15Var = k85Var.A;
        k65 k65Var = k85Var.A0;
        qf5 qf5Var = ((k85) x15Var.f).z0;
        k85.f(qf5Var);
        int i = qf5Var.C1(201500000) ? 100 : 25;
        int i2 = 0;
        boolean z2 = false;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                iD2 = !z ? d2(str4) : 0;
                if (iD2 == 0) {
                    iD2 = e2(str4);
                }
            } else {
                iD2 = 0;
            }
            if (iD2 != 0) {
                h1(bundle2, iD2, str4, iD2 == 3 ? str4 : str3);
                bundle2.remove(str4);
            } else {
                int iB1 = b1(str, str4, bundle.get(str4), bundle2, list2, z, zW1);
                if (iB1 == 17) {
                    h1(bundle2, 17, str4, Boolean.FALSE);
                } else if (iB1 != 0 && !"_ev".equals(str4)) {
                    h1(bundle2, iB1, iB1 == 21 ? str : str4, bundle.get(str4));
                    bundle2.remove(str4);
                }
                if (V1(str4)) {
                    i2++;
                    if (i2 > i) {
                        if (k85Var.A.f1(str3, r55.f1) && z2) {
                            str2 = str3;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(i);
                            sb.append(" params");
                            String string = sb.toString();
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            str2 = str3;
                            t65Var.B0.c(string, k65Var.a(str), k65Var.e(bundle));
                        }
                        Q1(5, bundle2);
                        bundle2.remove(str4);
                        z2 = true;
                        list2 = list;
                        str3 = str2;
                    } else {
                        list2 = list;
                    }
                }
            }
            str2 = str3;
            list2 = list;
            str3 = str2;
        }
        return bundle2;
    }

    public final int d2(String str) {
        if (!X1("event param", str)) {
            return 3;
        }
        if (!Z1("event param", null, null, str)) {
            return 14;
        }
        x15 x15Var = ((k85) this.f).A;
        return !a2("event param", 40, str) ? 3 : 0;
    }

    public final void e1(oe3 oe3Var, int i) {
        Bundle bundle = (Bundle) oe3Var.e;
        int i2 = 0;
        boolean z = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (V1(str) && (i2 = i2 + 1) > i) {
                k85 k85Var = (k85) this.f;
                x15 x15Var = k85Var.A;
                k65 k65Var = k85Var.A0;
                if (!x15Var.f1(null, r55.f1) || !z) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i);
                    sb.append(" params");
                    String string = sb.toString();
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.B0.c(string, k65Var.a((String) oe3Var.c), k65Var.e(bundle));
                    Q1(5, bundle);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    public final int e2(String str) {
        if (!Y1("event param", str)) {
            return 3;
        }
        if (!Z1("event param", null, null, str)) {
            return 14;
        }
        x15 x15Var = ((k85) this.f).A;
        return !a2("event param", 40, str) ? 3 : 0;
    }

    public final void f1(Parcelable[] parcelableArr, int i) {
        tj4.i(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i2 = 0;
            boolean z = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (V1(str) && !w1(str, je.y0) && (i2 = i2 + 1) > i) {
                    k85 k85Var = (k85) this.f;
                    x15 x15Var = k85Var.A;
                    k65 k65Var = k85Var.A0;
                    if (!x15Var.f1(null, r55.f1) || !z) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        q65 q65Var = t65Var.B0;
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i);
                        sb.append(" item-scoped custom parameters");
                        q65Var.c(sb.toString(), k65Var.b(str), k65Var.e(bundle));
                    }
                    Q1(28, bundle);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    public final void g1(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                qf5 qf5Var = ((k85) this.f).z0;
                k85.f(qf5Var);
                qf5Var.k1(bundle, str, bundle2.get(str));
            }
        }
    }

    public final boolean g2(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String string = obj.toString();
        if (string.codePointCount(0, string.length()) <= i) {
            return true;
        }
        t65 t65Var = ((k85) this.f).Y;
        k85.h(t65Var);
        t65Var.E0.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
        return false;
    }

    public final void h1(Bundle bundle, int i, String str, Object obj) {
        if (Q1(i, bundle)) {
            x15 x15Var = ((k85) this.f).A;
            bundle.putString("_ev", a1(40, str, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final void h2(String str, String str2, Bundle bundle, List list, boolean z) {
        int iD2;
        String str3;
        int iB1;
        List list2 = list;
        k85 k85Var = (k85) this.f;
        x15 x15Var = k85Var.A;
        t65 t65Var = k85Var.Y;
        k65 k65Var = k85Var.A0;
        qf5 qf5Var = ((k85) x15Var.f).z0;
        k85.f(qf5Var);
        int i = true != qf5Var.C1(231100000) ? 0 : 35;
        int i2 = 0;
        boolean z2 = false;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                iD2 = !z ? d2(str4) : 0;
                if (iD2 == 0) {
                    iD2 = e2(str4);
                }
            } else {
                iD2 = 0;
            }
            if (iD2 != 0) {
                h1(bundle, iD2, str4, iD2 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (f2(bundle.get(str4))) {
                    k85.h(t65Var);
                    t65Var.E0.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                    iB1 = 22;
                    str3 = null;
                } else {
                    str3 = null;
                    iB1 = b1(str, str4, bundle.get(str4), bundle, list2, z, false);
                }
                if (iB1 != 0 && !"_ev".equals(str4)) {
                    h1(bundle, iB1, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (V1(str4) && !w1(str4, je.y0)) {
                    int i3 = i2 + 1;
                    if (!C1(231100000)) {
                        k85.h(t65Var);
                        t65Var.B0.c("Item array not supported on client's version of Google Play Services (Android Only)", k65Var.a(str), k65Var.e(bundle));
                        Q1(23, bundle);
                        bundle.remove(str4);
                    } else if (i3 > i) {
                        if (!k85Var.A.f1(str3, r55.f1) || !z2) {
                            k85.h(t65Var);
                            q65 q65Var = t65Var.B0;
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i);
                            sb.append(" item-scoped custom params");
                            q65Var.c(sb.toString(), k65Var.a(str), k65Var.e(bundle));
                        }
                        Q1(28, bundle);
                        bundle.remove(str4);
                        list2 = list;
                        i2 = i3;
                        z2 = true;
                    }
                    list2 = list;
                    i2 = i3;
                }
            }
            list2 = list;
        }
    }

    public final int i1(Object obj, String str) {
        return "_ldl".equals(str) ? g2("user property referrer", str, S1(str), obj) : g2("user property", str, S1(str), obj) ? 0 : 7;
    }

    public final Object j1(Object obj, String str) {
        return "_ldl".equals(str) ? R1(S1(str), obj, true, false) : R1(S1(str), obj, false, false);
    }

    public final void k1(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            k85 k85Var = (k85) this.f;
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.E0.c("Not putting event parameter. Invalid value type. name, type", k85Var.A0.b(str), simpleName);
        }
    }

    public final nj2 q1() {
        mj2 mj2Var;
        nj2 nj2Var = this.z0;
        if (nj2Var != null) {
            return nj2Var;
        }
        Context context = ((k85) this.f).b;
        context.getClass();
        StringBuilder sb = new StringBuilder("AdServicesInfo.version=");
        int i = Build.VERSION.SDK_INT;
        f5 f5Var = f5.a;
        sb.append(i >= 33 ? f5Var.a() : 0);
        Log.d("MeasurementManager", sb.toString());
        if ((i >= 33 ? f5Var.a() : 0) >= 5) {
            mj2Var = new mj2(context, 1);
        } else {
            e5 e5Var = e5.a;
            if (((i == 31 || i == 32) ? e5Var.a() : 0) >= 9) {
                try {
                    mj2Var = new mj2(context, 0);
                } catch (NoClassDefFoundError unused) {
                    StringBuilder sb2 = new StringBuilder("Unable to find adservices code, check manifest for uses-library tag, versionS=");
                    int i2 = Build.VERSION.SDK_INT;
                    sb2.append((i2 == 31 || i2 == 32) ? e5Var.a() : 0);
                    Log.d("MeasurementManager", sb2.toString());
                    mj2Var = null;
                }
            } else {
                mj2Var = null;
            }
        }
        nj2 nj2Var2 = mj2Var != null ? new nj2(mj2Var) : null;
        this.z0 = nj2Var2;
        return nj2Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long s1() {
        /*
            r12 = this;
            r12.V0()
            java.lang.Object r0 = r12.f
            k85 r0 = (defpackage.k85) r0
            d65 r1 = r0.l()
            t65 r0 = r0.Y
            java.lang.String r1 = r1.b1()
            boolean r1 = t1(r1)
            r2 = 0
            if (r1 != 0) goto L1a
            return r2
        L1a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r5 = 30
            if (r1 >= r5) goto L24
            r5 = 4
            goto L44
        L24:
            int r1 = android.os.ext.SdkExtensions.getExtensionVersion(r5)
            r5 = 4
            if (r1 >= r5) goto L2e
            r5 = 8
            goto L44
        L2e:
            int r1 = r1()
            q55 r5 = defpackage.r55.m0
            java.lang.Object r5 = r5.a(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r1 >= r5) goto L43
            r5 = 16
            goto L44
        L43:
            r5 = r2
        L44:
            java.lang.String r1 = "android.permission.ACCESS_ADSERVICES_ATTRIBUTION"
            boolean r1 = r12.u1(r1)
            if (r1 != 0) goto L4f
            r7 = 2
            long r5 = r5 | r7
        L4f:
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 != 0) goto Lb3
            java.lang.Boolean r1 = r12.A0
            if (r1 != 0) goto La9
            nj2 r1 = r12.q1()
            r7 = 0
            if (r1 != 0) goto L5f
            goto Laf
        L5f:
            nc2 r1 = r1.b()
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L87 java.lang.InterruptedException -> L89 java.util.concurrent.ExecutionException -> L8b java.util.concurrent.CancellationException -> L8d
            r9 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r1 = r1.get(r9, r8)     // Catch: java.util.concurrent.TimeoutException -> L87 java.lang.InterruptedException -> L89 java.util.concurrent.ExecutionException -> L8b java.util.concurrent.CancellationException -> L8d
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.util.concurrent.TimeoutException -> L87 java.lang.InterruptedException -> L89 java.util.concurrent.ExecutionException -> L8b java.util.concurrent.CancellationException -> L8d
            if (r1 == 0) goto L80
            int r4 = r1.intValue()     // Catch: java.util.concurrent.TimeoutException -> L78 java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c java.util.concurrent.CancellationException -> L7e
            r8 = 1
            if (r4 != r8) goto L80
            r7 = r8
            goto L80
        L78:
            r4 = move-exception
            goto L91
        L7a:
            r4 = move-exception
            goto L91
        L7c:
            r4 = move-exception
            goto L91
        L7e:
            r4 = move-exception
            goto L91
        L80:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r7)     // Catch: java.util.concurrent.TimeoutException -> L78 java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c java.util.concurrent.CancellationException -> L7e
            r12.A0 = r4     // Catch: java.util.concurrent.TimeoutException -> L78 java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c java.util.concurrent.CancellationException -> L7e
            goto L9f
        L87:
            r1 = move-exception
            goto L8e
        L89:
            r1 = move-exception
            goto L8e
        L8b:
            r1 = move-exception
            goto L8e
        L8d:
            r1 = move-exception
        L8e:
            r11 = r4
            r4 = r1
            r1 = r11
        L91:
            defpackage.k85.h(r0)
            q65 r7 = r0.C0
            java.lang.String r8 = "Measurement manager api exception"
            r7.b(r4, r8)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r12.A0 = r4
        L9f:
            defpackage.k85.h(r0)
            q65 r0 = r0.H0
            java.lang.String r4 = "Measurement manager api status result"
            r0.b(r1, r4)
        La9:
            java.lang.Boolean r12 = r12.A0
            boolean r7 = r12.booleanValue()
        Laf:
            if (r7 != 0) goto Lb3
            r5 = 64
        Lb3:
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 != 0) goto Lba
            r0 = 1
            return r0
        Lba:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf5.s1():long");
    }

    public final boolean u1(String str) {
        V0();
        k85 k85Var = (k85) this.f;
        if (ay4.a(k85Var.b).a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.G0.b(str, "Permission not granted");
        return false;
    }

    public final boolean x1(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((k85) this.f).A.Z0("debug.firebase.analytics.app").equals(str);
    }

    public final Bundle y1(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objC1 = c1(bundle.get(str), str);
                if (objC1 == null) {
                    k85 k85Var = (k85) this.f;
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.E0.b(k85Var.A0.b(str), "Param value can't be null");
                } else {
                    k1(bundle2, str, objC1);
                }
            }
        }
        return bundle2;
    }

    public final z25 z1(String str, Bundle bundle, String str2, long j, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b2(str) != 0) {
            k85 k85Var = (k85) this.f;
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.b(k85Var.A0.c(str), "Invalid conditional property event name");
            s53.d();
            return null;
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleD1 = d1(str, bundle2, Collections.singletonList("_o"), true);
        if (z) {
            bundleD1 = y1(bundleD1);
        }
        tj4.i(bundleD1);
        return new z25(str, new y25(bundleD1), str2, j);
    }
}
