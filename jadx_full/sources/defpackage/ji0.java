package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RemoteViews;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.receiver.appwidget.DNSProvider;
import com.getsurfboard.ui.receiver.appwidget.WidgetRetryReceiver;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.sentry.android.core.a1;
import io.sentry.android.core.cache.a;
import j$.util.DesugarTimeZone;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ji0 {
    public static final Object a = new Object();
    public static final byte[] b = {112, 114, 111, 0};
    public static final byte[] c = {112, 114, 109, 0};
    public static boolean d = false;
    public static Method e = null;
    public static boolean f = false;
    public static Field g;

    public static final z14 A(lf0 lf0Var, cf0 cf0Var, of0 of0Var, Function2 function2) {
        cf0 cf0VarI = co4.I(lf0Var, cf0Var);
        of0Var.getClass();
        z14 f92Var = of0Var == of0.f ? new f92(cf0VarI, function2) : new z14(cf0VarI, true);
        f92Var.l0(of0Var, f92Var, function2);
        return f92Var;
    }

    public static z14 B(lf0 lf0Var, cf0 cf0Var, of0 of0Var, Function2 function2, int i) {
        if ((i & 1) != 0) {
            cf0Var = c41.b;
        }
        if ((i & 2) != 0) {
            of0Var = of0.b;
        }
        return A(lf0Var, cf0Var, of0Var, function2);
    }

    public static ParameterizedType C(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return C(upperBounds[0]);
            }
        }
        return null;
    }

    public static TypeVariable D(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return D(upperBounds[0]);
            }
        }
        return null;
    }

    public static ju G(jr2 jr2Var) {
        long j;
        boolean z;
        long j2;
        long j3;
        long j4;
        long jI;
        long j5;
        long j6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = (Map) jr2Var.d;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jI2 = str != null ? I(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j2 = 0;
            j3 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals(HttpHeaders.Values.NO_STORE)) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            j = 0;
            i = 1;
        } else {
            j = 0;
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jI3 = str3 != null ? I(str3) : j;
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j4 = jCurrentTimeMillis;
            jI = I(str4);
        } else {
            j4 = jCurrentTimeMillis;
            jI = j;
        }
        String str5 = (String) map.get(HttpHeaders.Names.ETAG);
        if (i != 0) {
            long j7 = (j2 * 1000) + j4;
            if (z) {
                j6 = j7;
            } else {
                Long.signum(j3);
                j6 = (j3 * 1000) + j7;
            }
            j5 = j7;
        } else {
            j5 = (jI2 <= j || jI3 < jI2) ? j : (jI3 - jI2) + j4;
            j6 = j5;
        }
        ju juVar = new ju();
        juVar.a = (byte[]) jr2Var.c;
        juVar.b = str5;
        juVar.f = j5;
        juVar.e = j6;
        juVar.c = jI2;
        juVar.d = jI;
        juVar.g = map;
        juVar.h = (List) jr2Var.e;
        return juVar;
    }

    public static String H(String str, Map map) {
        String str2;
        if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long I(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            if ("0".equals(str) || "-1".equals(str)) {
                qs4.d("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            a1.e("Volley", qs4.a("Unable to parse dateStr: %s, falling back to 0", str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void J(Context context, String str) {
        synchronized (a) {
            if (str.equals("")) {
                context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                return;
            }
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                        xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                        xmlSerializerNewSerializer.startTag(null, "locales");
                        xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                        xmlSerializerNewSerializer.endTag(null, "locales");
                        xmlSerializerNewSerializer.endDocument();
                    } catch (Throwable th) {
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    a1.o("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales in storage ", e2);
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (FileNotFoundException unused3) {
                a1.n("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
            }
        }
    }

    public static boolean K(w8 w8Var, nj4 nj4Var, Type type) {
        if (nj4Var.k0(w8Var.a(type).L0)) {
            ParameterizedType parameterizedTypeC = C(type);
            if (parameterizedTypeC == null || !Objects.equals(nj4Var.L0, parameterizedTypeC.getRawType())) {
                return true;
            }
            Type[] actualTypeArguments = parameterizedTypeC.getActualTypeArguments();
            qj4 qj4VarX = nj4Var.X();
            if (qj4VarX.f.length == actualTypeArguments.length) {
                for (int i = 0; i < qj4VarX.f.length; i++) {
                    if (K(w8Var, qj4VarX.d(i), actualTypeArguments[i])) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int[] L(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int iR = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iR += (int) ez4.R(byteArrayInputStream, 2);
            iArr[i2] = iR;
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r1 = r3.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0046 A[EXC_TOP_SPLITTER, PHI: r1
      0x0046: PHI (r1v2 java.lang.String) = (r1v0 java.lang.String), (r1v4 java.lang.String) binds: [B:29:0x0053, B:23:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String M(Context context) {
        String attributeValue;
        synchronized (a) {
            attributeValue = "";
            try {
                FileInputStream fileInputStreamOpenFileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        int depth = xmlPullParserNewPullParser.getDepth();
                        while (true) {
                            int next = xmlPullParserNewPullParser.next();
                            if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                                if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } catch (IOException | XmlPullParserException unused) {
                        a1.n("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                        if (fileInputStreamOpenFileInput != null) {
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (attributeValue.isEmpty()) {
                        context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    }
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                return "";
            }
        }
        return attributeValue;
    }

    public static yt0[] N(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, yt0[] yt0VarArr) throws IOException {
        byte[] bArr3 = ek0.j;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, ek0.k)) {
                xe.q("Unsupported meta version");
                return null;
            }
            int iR = (int) ez4.R(fileInputStream, 2);
            byte[] bArrQ = ez4.Q(fileInputStream, (int) ez4.R(fileInputStream, 4), (int) ez4.R(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                xe.q("Content found after the end of file");
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrQ);
            try {
                yt0[] yt0VarArrP = P(byteArrayInputStream, bArr2, iR, yt0VarArr);
                byteArrayInputStream.close();
                return yt0VarArrP;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(ek0.e, bArr2)) {
            xe.q("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            return null;
        }
        if (!Arrays.equals(bArr, bArr3)) {
            xe.q("Unsupported meta version");
            return null;
        }
        int iR2 = (int) ez4.R(fileInputStream, 1);
        byte[] bArrQ2 = ez4.Q(fileInputStream, (int) ez4.R(fileInputStream, 4), (int) ez4.R(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            xe.q("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrQ2);
        try {
            yt0[] yt0VarArrO = O(byteArrayInputStream2, iR2, yt0VarArr);
            byteArrayInputStream2.close();
            return yt0VarArrO;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static yt0[] O(ByteArrayInputStream byteArrayInputStream, int i, yt0[] yt0VarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new yt0[0];
        }
        if (i != yt0VarArr.length) {
            xe.q("Mismatched number of dex files found in metadata");
            return null;
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iR = (int) ez4.R(byteArrayInputStream, 2);
            iArr[i2] = (int) ez4.R(byteArrayInputStream, 2);
            strArr[i2] = new String(ez4.P(byteArrayInputStream, iR), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            yt0 yt0Var = yt0VarArr[i3];
            if (!yt0Var.b.equals(strArr[i3])) {
                xe.q("Order of dexfiles in metadata did not match baseline");
                return null;
            }
            int i4 = iArr[i3];
            yt0Var.e = i4;
            yt0Var.h = L(byteArrayInputStream, i4);
        }
        return yt0VarArr;
    }

    public static yt0[] P(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, yt0[] yt0VarArr) throws IOException {
        yt0 yt0Var;
        if (byteArrayInputStream.available() == 0) {
            return new yt0[0];
        }
        if (i != yt0VarArr.length) {
            xe.q("Mismatched number of dex files found in metadata");
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            ez4.R(byteArrayInputStream, 2);
            String str = new String(ez4.P(byteArrayInputStream, (int) ez4.R(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jR = ez4.R(byteArrayInputStream, 4);
            int iR = (int) ez4.R(byteArrayInputStream, 2);
            if (yt0VarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i3 = 0; i3 < yt0VarArr.length; i3++) {
                    if (yt0VarArr[i3].b.equals(strSubstring)) {
                        yt0Var = yt0VarArr[i3];
                        break;
                    }
                }
                yt0Var = null;
            } else {
                yt0Var = null;
            }
            if (yt0Var == null) {
                xe.q("Missing profile key: ".concat(str));
                return null;
            }
            yt0Var.d = jR;
            int[] iArrL = L(byteArrayInputStream, iR);
            if (Arrays.equals(bArr, ek0.i)) {
                yt0Var.e = iR;
                yt0Var.h = iArrL;
            }
        }
        return yt0VarArr;
    }

    public static yt0[] Q(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, ek0.f)) {
            xe.q("Unsupported version");
            return null;
        }
        int iR = (int) ez4.R(fileInputStream, 1);
        byte[] bArrQ = ez4.Q(fileInputStream, (int) ez4.R(fileInputStream, 4), (int) ez4.R(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            xe.q("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrQ);
        try {
            yt0[] yt0VarArrR = R(byteArrayInputStream, str, iR);
            byteArrayInputStream.close();
            return yt0VarArrR;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static yt0[] R(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        int i2 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new yt0[0];
        }
        yt0[] yt0VarArr = new yt0[i];
        for (int i3 = 0; i3 < i; i3++) {
            int iR = (int) ez4.R(byteArrayInputStream, 2);
            int iR2 = (int) ez4.R(byteArrayInputStream, 2);
            yt0VarArr[i3] = new yt0(str, new String(ez4.P(byteArrayInputStream, iR), StandardCharsets.UTF_8), ez4.R(byteArrayInputStream, 4), iR2, (int) ez4.R(byteArrayInputStream, 4), (int) ez4.R(byteArrayInputStream, 4), new int[iR2], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i) {
            yt0 yt0Var = yt0VarArr[i4];
            int iAvailable = byteArrayInputStream.available();
            int i5 = yt0Var.f;
            int i6 = yt0Var.g;
            TreeMap treeMap = yt0Var.i;
            int i7 = iAvailable - i5;
            int iR3 = i2;
            while (byteArrayInputStream.available() > i7) {
                iR3 += (int) ez4.R(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iR3), 1);
                int iR4 = (int) ez4.R(byteArrayInputStream, 2);
                while (iR4 > 0) {
                    ez4.R(byteArrayInputStream, 2);
                    int iR5 = (int) ez4.R(byteArrayInputStream, 1);
                    if (iR5 != 6 && iR5 != 7) {
                        while (iR5 > 0) {
                            ez4.R(byteArrayInputStream, 1);
                            int i8 = i2;
                            int i9 = i4;
                            for (int iR6 = (int) ez4.R(byteArrayInputStream, 1); iR6 > 0; iR6--) {
                                ez4.R(byteArrayInputStream, 2);
                            }
                            iR5--;
                            i2 = i8;
                            i4 = i9;
                        }
                    }
                    iR4--;
                    i2 = i2;
                    i4 = i4;
                }
            }
            int i10 = i2;
            int i11 = i4;
            if (byteArrayInputStream.available() != i7) {
                xe.q("Read too much data during profile line parse");
                return null;
            }
            yt0Var.h = L(byteArrayInputStream, yt0Var.e);
            BitSet bitSetValueOf = BitSet.valueOf(ez4.P(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i12 = i10; i12 < i6; i12++) {
                int i13 = bitSetValueOf.get(i12) ? 2 : i10;
                if (bitSetValueOf.get(i12 + i6)) {
                    i13 |= 4;
                }
                if (i13 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i12));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i10);
                    }
                    treeMap.put(Integer.valueOf(i12), Integer.valueOf(i13 | numValueOf.intValue()));
                }
            }
            i4 = i11 + 1;
            i2 = i10;
        }
        return yt0VarArr;
    }

    public static final void S() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "DNSProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "refreshWidgets() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("DNSProvider", "refreshWidgets() called", null);
        }
        ei0 ei0Var = (ei0) cr2.c.d();
        if (ei0Var == null) {
            return;
        }
        ComponentName componentName = DNSProvider.a;
        if (xb5.C(componentName)) {
            RemoteViews remoteViews = new RemoteViews(ContextUtilsKt.getContext().getPackageName(), R.layout.widget_dns);
            String str = "refreshWidgets() start update layout: " + ei0Var;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "DNSProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("DNSProvider", str, null);
            }
            int iOrdinal = ei0Var.a.ordinal();
            if (iOrdinal == 0) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setViewVisibility(R.id.title, 0);
                remoteViews.setViewVisibility(R.id.loading, 0);
                remoteViews.setViewVisibility(R.id.ip, 4);
                remoteViews.setViewVisibility(R.id.retry, 4);
            } else if (iOrdinal == 1) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setViewVisibility(R.id.title, 0);
                remoteViews.setViewVisibility(R.id.loading, 4);
                remoteViews.setViewVisibility(R.id.ip, 0);
                remoteViews.setViewVisibility(R.id.retry, 4);
                Object obj = ei0Var.b;
                if (obj != null) {
                    remoteViews.setTextViewText(R.id.ip, (CharSequence) obj);
                } else {
                    remoteViews.setTextViewText(R.id.ip, ContextUtilsKt.k(R.string.no_network));
                }
            } else {
                if (iOrdinal != 2) {
                    g.d();
                    return;
                }
                remoteViews.setViewVisibility(R.id.icon, 4);
                remoteViews.setViewVisibility(R.id.title, 4);
                remoteViews.setViewVisibility(R.id.loading, 4);
                remoteViews.setViewVisibility(R.id.ip, 4);
                remoteViews.setViewVisibility(R.id.retry, 0);
            }
            Intent action = new Intent(ContextUtilsKt.getContext(), (Class<?>) WidgetRetryReceiver.class).putExtra("type", "dns").setAction("com.getsurfboard.ACTION_WIDGET_RETRY");
            action.getClass();
            remoteViews.setOnClickPendingIntent(R.id.retry, PendingIntent.getBroadcast(ContextUtilsKt.getContext(), fj3.g, action, l72.a(134217728, true)));
            Intent intentS = p95.s(ContextUtilsKt.getContext(), false);
            intentS.setFlags(intentS.getFlags() + 67108864);
            intentS.setFlags(intentS.getFlags() + 536870912);
            intentS.putExtra("tab", "dashboard");
            remoteViews.setOnClickPendingIntent(android.R.id.background, l72.o(ContextUtilsKt.getContext(), fj3.c, intentS, true));
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(ContextUtilsKt.getContext());
            if (appWidgetManager != null) {
                appWidgetManager.updateAppWidget(componentName, remoteViews);
            }
        }
    }

    public static final void T(String str, HashMap map) {
        str.getClass();
        ua3 ua3VarT = oj0.a.t();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new sa3(str, (String) entry.getKey(), (String) entry.getValue()));
        }
        sa3[] sa3VarArr = (sa3[]) arrayList.toArray(new sa3[0]);
        ke0.r(ua3VarT.a, false, true, new gj(16, ua3VarT, (sa3[]) Arrays.copyOf(sa3VarArr, sa3VarArr.length)));
    }

    public static void U(lb lbVar, float f2) {
        yl3 yl3Var = (yl3) lbVar.f;
        q10 q10Var = (q10) lbVar.z;
        boolean useCompatPadding = q10Var.getUseCompatPadding();
        boolean preventCornerOverlap = q10Var.getPreventCornerOverlap();
        if (f2 != yl3Var.e || yl3Var.f != useCompatPadding || yl3Var.g != preventCornerOverlap) {
            yl3Var.e = f2;
            yl3Var.f = useCompatPadding;
            yl3Var.g = preventCornerOverlap;
            yl3Var.b(null);
            yl3Var.invalidateSelf();
        }
        if (!q10Var.getUseCompatPadding()) {
            lbVar.M(0, 0, 0, 0);
            return;
        }
        yl3 yl3Var2 = (yl3) lbVar.f;
        float f3 = yl3Var2.e;
        float f4 = yl3Var2.a;
        int iCeil = (int) Math.ceil(zl3.a(f3, f4, q10Var.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(zl3.b(f3, f4, q10Var.getPreventCornerOverlap()));
        lbVar.M(iCeil, iCeil2, iCeil, iCeil2);
    }

    public static final Object V(r92 r92Var, q92 q92Var, boolean z, tq1 tq1Var, pl1 pl1Var, ge0 ge0Var) {
        int i = 1;
        z00 z00Var = new z00(1, p95.u(ge0Var));
        z00Var.w();
        gw4 gw4Var = new gw4(q92Var, r92Var, z00Var, pl1Var);
        if (z) {
            tq1Var.j0(c41.b, new tm1(14, r92Var, gw4Var));
        } else {
            r92Var.a(gw4Var);
        }
        z00Var.y(new fr4(i, tq1Var, r92Var, gw4Var));
        return z00Var.u();
    }

    public static final boolean W(String str) {
        if (str == null) {
            return false;
        }
        if (Boolean.parseBoolean(str)) {
            return true;
        }
        return str.equals("1");
    }

    /* JADX WARN: Finally extract failed */
    public static boolean X(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, yt0[] yt0VarArr) throws IOException {
        int i;
        long j;
        int length;
        byte[] bArr2 = ek0.i;
        byte[] bArr3 = ek0.h;
        byte[] bArr4 = ek0.e;
        int i2 = 0;
        if (!Arrays.equals(bArr, bArr4)) {
            byte[] bArr5 = ek0.f;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrK = k(yt0VarArr, bArr5);
                ez4.c0(byteArrayOutputStream, yt0VarArr.length, 1);
                ez4.c0(byteArrayOutputStream, bArrK.length, 4);
                byte[] bArrM = ez4.m(bArrK);
                ez4.c0(byteArrayOutputStream, bArrM.length, 4);
                byteArrayOutputStream.write(bArrM);
                return true;
            }
            if (Arrays.equals(bArr, bArr3)) {
                ez4.c0(byteArrayOutputStream, yt0VarArr.length, 1);
                for (yt0 yt0Var : yt0VarArr) {
                    int size = yt0Var.i.size() * 4;
                    String strR = r(yt0Var.a, yt0Var.b, bArr3);
                    Charset charset = StandardCharsets.UTF_8;
                    ez4.d0(byteArrayOutputStream, strR.getBytes(charset).length);
                    ez4.d0(byteArrayOutputStream, yt0Var.h.length);
                    ez4.c0(byteArrayOutputStream, size, 4);
                    ez4.c0(byteArrayOutputStream, yt0Var.c, 4);
                    byteArrayOutputStream.write(strR.getBytes(charset));
                    Iterator it = yt0Var.i.keySet().iterator();
                    while (it.hasNext()) {
                        ez4.d0(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        ez4.d0(byteArrayOutputStream, 0);
                    }
                    for (int i3 : yt0Var.h) {
                        ez4.d0(byteArrayOutputStream, i3);
                    }
                }
                return true;
            }
            byte[] bArr6 = ek0.g;
            if (Arrays.equals(bArr, bArr6)) {
                byte[] bArrK2 = k(yt0VarArr, bArr6);
                ez4.c0(byteArrayOutputStream, yt0VarArr.length, 1);
                ez4.c0(byteArrayOutputStream, bArrK2.length, 4);
                byte[] bArrM2 = ez4.m(bArrK2);
                ez4.c0(byteArrayOutputStream, bArrM2.length, 4);
                byteArrayOutputStream.write(bArrM2);
                return true;
            }
            if (!Arrays.equals(bArr, bArr2)) {
                return false;
            }
            ez4.d0(byteArrayOutputStream, yt0VarArr.length);
            for (yt0 yt0Var2 : yt0VarArr) {
                String str = yt0Var2.a;
                TreeMap treeMap = yt0Var2.i;
                String strR2 = r(str, yt0Var2.b, bArr2);
                Charset charset2 = StandardCharsets.UTF_8;
                ez4.d0(byteArrayOutputStream, strR2.getBytes(charset2).length);
                ez4.d0(byteArrayOutputStream, treeMap.size());
                ez4.d0(byteArrayOutputStream, yt0Var2.h.length);
                ez4.c0(byteArrayOutputStream, yt0Var2.c, 4);
                byteArrayOutputStream.write(strR2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    ez4.d0(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i4 : yt0Var2.h) {
                    ez4.d0(byteArrayOutputStream, i4);
                }
            }
            return true;
        }
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            ez4.d0(byteArrayOutputStream2, yt0VarArr.length);
            int i5 = 2;
            int i6 = 2;
            for (yt0 yt0Var3 : yt0VarArr) {
                ez4.c0(byteArrayOutputStream2, yt0Var3.c, 4);
                ez4.c0(byteArrayOutputStream2, yt0Var3.d, 4);
                ez4.c0(byteArrayOutputStream2, yt0Var3.g, 4);
                String strR3 = r(yt0Var3.a, yt0Var3.b, bArr4);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strR3.getBytes(charset3).length;
                ez4.d0(byteArrayOutputStream2, length2);
                i6 = i6 + 14 + length2;
                byteArrayOutputStream2.write(strR3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i6 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            }
            by4 by4Var = new by4(byteArray, 1, false);
            byteArrayOutputStream2.close();
            arrayList.add(by4Var);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i7 = 0;
            int i8 = 0;
            while (i7 < yt0VarArr.length) {
                try {
                    yt0 yt0Var4 = yt0VarArr[i7];
                    ez4.d0(byteArrayOutputStream3, i7);
                    ez4.d0(byteArrayOutputStream3, yt0Var4.e);
                    i8 = i8 + 4 + (yt0Var4.e * i5);
                    int[] iArr = yt0Var4.h;
                    int length3 = iArr.length;
                    int i9 = i2;
                    while (i2 < length3) {
                        int i10 = iArr[i2];
                        ez4.d0(byteArrayOutputStream3, i10 - i9);
                        i2++;
                        i5 = i5;
                        i9 = i10;
                    }
                    i7++;
                    i2 = 0;
                } catch (Throwable th) {
                }
            }
            int i11 = i5;
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i8 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
            }
            by4 by4Var2 = new by4(byteArray2, 3, true);
            byteArrayOutputStream3.close();
            arrayList.add(by4Var2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i12 = 0;
            for (int i13 = 0; i13 < yt0VarArr.length; i13++) {
                try {
                    yt0 yt0Var5 = yt0VarArr[i13];
                    Iterator it3 = yt0Var5.i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        e0(byteArrayOutputStream4, iIntValue, yt0Var5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            f0(byteArrayOutputStream4, yt0Var5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            ez4.d0(byteArrayOutputStream3, i13);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i14 = i12 + 6;
                            ez4.c0(byteArrayOutputStream3, length4, 4);
                            ez4.d0(byteArrayOutputStream3, iIntValue);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i12 = i14 + length4;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            }
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i12 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i12 + ", does not match actual size " + byteArray5.length);
            }
            by4 by4Var3 = new by4(byteArray5, 4, true);
            byteArrayOutputStream3.close();
            arrayList.add(by4Var3);
            long size2 = 12 + ((long) (arrayList.size() * 16));
            ez4.c0(byteArrayOutputStream, arrayList.size(), 4);
            int i15 = 0;
            while (i15 < arrayList.size()) {
                by4 by4Var4 = (by4) arrayList.get(i15);
                int i16 = by4Var4.a;
                byte[] bArr7 = by4Var4.b;
                if (i16 != 1) {
                    i = i11;
                    if (i16 == i) {
                        j = 1;
                    } else if (i16 == 3) {
                        j = 2;
                    } else if (i16 == 4) {
                        j = 3;
                    } else {
                        if (i16 != 5) {
                            throw null;
                        }
                        j = 4;
                    }
                } else {
                    i = i11;
                    j = 0;
                }
                ez4.c0(byteArrayOutputStream, j, 4);
                ez4.c0(byteArrayOutputStream, size2, 4);
                if (by4Var4.c) {
                    long length5 = bArr7.length;
                    byte[] bArrM3 = ez4.m(bArr7);
                    arrayList2.add(bArrM3);
                    ez4.c0(byteArrayOutputStream, bArrM3.length, 4);
                    ez4.c0(byteArrayOutputStream, length5, 4);
                    length = bArrM3.length;
                } else {
                    arrayList2.add(bArr7);
                    ez4.c0(byteArrayOutputStream, bArr7.length, 4);
                    ez4.c0(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i15++;
                i11 = i;
            }
            for (int i17 = 0; i17 < arrayList2.size(); i17++) {
                byteArrayOutputStream.write((byte[]) arrayList2.get(i17));
            }
            return true;
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream2.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static void Y(String str, String str2) {
        if (str.length() <= 0) {
            xe.k("Package name must not be empty");
            return;
        }
        if (str2.length() <= 0) {
            xe.k("Activity class name must not be empty");
            return;
        }
        if (p44.o0(str, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, false) && p44.v0(str, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, 0, false, 6) != str.length() - 1) {
            xe.k("Wildcard in package name is only allowed at the end.");
        } else {
            if (!p44.o0(str2, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, false) || p44.v0(str2, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, 0, false, 6) == str2.length() - 1) {
                return;
            }
            xe.k("Wildcard in class name is only allowed at the end.");
        }
    }

    public static boolean Z(String str, String str2) {
        if (!p44.o0(str2, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, false)) {
            return false;
        }
        if (str2.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            return true;
        }
        if (p44.v0(str2, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, 0, false, 6) == p44.A0(str2, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, 6) && w44.d0(str2, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, false)) {
            return w44.j0(str, str2.substring(0, str2.length() - 1), false);
        }
        xe.k("Name pattern with a wildcard must only contain a single wildcard in the end");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(f4 f4Var, f4 f4Var2) {
        String str = f4Var2.b;
        String str2 = f4Var2.a;
        if (f4Var == null) {
            return str2.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) && str.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
        }
        String str3 = f4Var.b;
        String str4 = f4Var.a;
        if (p44.o0(f4Var.toString(), WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, false)) {
            xe.k("Wildcard can only be part of the rule.");
            return false;
        }
        boolean z = str4.equals(str2) || Z(str4, str2);
        boolean z2 = str3.equals(str) || Z(str3, str);
        if (!z || !z2) {
        }
    }

    public static final boolean a0(String str, String str2) {
        String[] strArr;
        boolean z;
        int i;
        String str3 = str2;
        str.getClass();
        str3.getClass();
        String[] strArr2 = ke1.a;
        uv1 uv1Var = uv1.SENSITIVE;
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            strArr = new String[]{str};
        } else {
            char[] charArray = str.toCharArray();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int length = charArray.length;
            int i2 = 0;
            char c2 = 0;
            while (i2 < length) {
                char c3 = charArray[i2];
                if (c3 == '?' || c3 == '*') {
                    if (sb.length() != 0) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    if (c3 == '?') {
                        arrayList.add("?");
                    } else if (c2 != '*') {
                        arrayList.add(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
                    }
                } else {
                    sb.append(c3);
                }
                i2++;
                c2 = c3;
            }
            if (sb.length() != 0) {
                arrayList.add(sb.toString());
            }
            strArr = (String[]) arrayList.toArray(ke1.a);
        }
        String[] strArr3 = strArr;
        ArrayDeque arrayDeque = new ArrayDeque(strArr3.length);
        boolean z2 = false;
        int length2 = 0;
        int i3 = 0;
        while (true) {
            if (arrayDeque.isEmpty()) {
                z = z2;
                i = i3;
            } else {
                int[] iArr = (int[]) arrayDeque.pop();
                int i4 = iArr[0];
                length2 = iArr[1];
                i = i4;
                z = true;
            }
            while (i < strArr3.length) {
                if (strArr3[i].equals("?")) {
                    length2++;
                    if (length2 > str3.length()) {
                        break;
                    }
                    z = false;
                } else if (strArr3[i].equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                    if (i == strArr3.length - 1) {
                        length2 = str3.length();
                    }
                    z = true;
                } else {
                    if (z) {
                        length2 = uv1Var.a(str3, length2, strArr3[i]);
                        if (length2 == -1) {
                            break;
                        }
                        int iA = uv1Var.a(str3, length2 + 1, strArr3[i]);
                        if (iA >= 0) {
                            arrayDeque.push(new int[]{i, iA});
                        }
                        length2 = strArr3[i].length() + length2;
                    } else {
                        String str4 = strArr3[i];
                        if (str4 == null || !str2.regionMatches(false, length2, str4, 0, str4.length())) {
                            break;
                        }
                        length2 = strArr3[i].length() + length2;
                    }
                    z = false;
                }
                i++;
                str3 = str2;
            }
            if (i == strArr3.length && length2 == str2.length()) {
                return true;
            }
            if (arrayDeque.isEmpty()) {
                return false;
            }
            str3 = str2;
            z2 = z;
            i3 = i;
        }
    }

    public static gn0 b(lf0 lf0Var, cf0 cf0Var, Function2 function2, int i) {
        if ((i & 1) != 0) {
            cf0Var = c41.b;
        }
        gn0 gn0Var = new gn0(co4.I(lf0Var, cf0Var), true);
        gn0Var.l0(of0.b, gn0Var, function2);
        return gn0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object b0(cf0 cf0Var, Function2 function2, ge0 ge0Var) {
        Unsafe unsafe;
        long j;
        cf0 cf0VarJ = ge0Var.j();
        cf0 cf0VarX = !((Boolean) cf0Var.c0(Boolean.FALSE, new dt(3))).booleanValue() ? cf0VarJ.X(cf0Var) : co4.p(cf0VarJ, cf0Var, false);
        je.A(cf0VarX);
        if (cf0VarX == cf0VarJ) {
            iq3 iq3Var = new iq3(ge0Var, cf0VarX);
            return fx3.J(iq3Var, true, iq3Var, function2);
        }
        pr1 pr1Var = pr1.f;
        if (n12.c(cf0VarX.Z(pr1Var), cf0VarJ.Z(pr1Var))) {
            bl4 bl4Var = new bl4(ge0Var, cf0VarX);
            cf0 cf0Var2 = bl4Var.z;
            Object objC = nd4.c(cf0Var2, null);
            try {
                return fx3.J(bl4Var, true, bl4Var, function2);
            } finally {
                nd4.a(cf0Var2, objC);
            }
        }
        nv0 nv0Var = new nv0(ge0Var, cf0VarX);
        try {
            mv0.a(p95.u(((kk) function2).n(nv0Var, nv0Var)), xl4.a);
            do {
                unsafe = re.a;
                j = nv0.X;
                int intVolatile = unsafe.getIntVolatile(nv0Var, j);
                if (intVolatile != 0) {
                    if (intVolatile != 2) {
                        xe.q("Already suspended");
                        return null;
                    }
                    Object objA = f42.a(nv0Var.H());
                    if (objA instanceof r80) {
                        throw ((r80) objA).a;
                    }
                    return objA;
                }
            } while (!unsafe.compareAndSwapInt(nv0Var, j, 0, 1));
            return mf0.b;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof kv0) {
                th2 = ((kv0) th2).b;
            }
            nv0Var.d(new tk3(th2));
            throw th2;
        }
    }

    public static void c0(ByteArrayOutputStream byteArrayOutputStream, yt0 yt0Var) throws IOException {
        f0(byteArrayOutputStream, yt0Var);
        int i = yt0Var.g;
        int[] iArr = yt0Var.h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            ez4.d0(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        byte[] bArr = new byte[(((i * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : yt0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i5 = iIntValue / 8;
                bArr[i5] = (byte) (bArr[i5] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i6 = iIntValue + i;
                int i7 = i6 / 8;
                bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static int d(ng3 ng3Var, h31 h31Var, View view, View view2, ag3 ag3Var, boolean z) {
        if (ag3Var.v() == 0 || ng3Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(ag3.K(view) - ag3.K(view2)) + 1;
        }
        return Math.min(h31Var.n(), h31Var.d(view2) - h31Var.g(view));
    }

    public static void d0(ByteArrayOutputStream byteArrayOutputStream, yt0 yt0Var, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        ez4.d0(byteArrayOutputStream, str.getBytes(charset).length);
        ez4.d0(byteArrayOutputStream, yt0Var.e);
        ez4.c0(byteArrayOutputStream, yt0Var.f, 4);
        ez4.c0(byteArrayOutputStream, yt0Var.c, 4);
        ez4.c0(byteArrayOutputStream, yt0Var.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static int e(ng3 ng3Var, h31 h31Var, View view, View view2, ag3 ag3Var, boolean z, boolean z2) {
        if (ag3Var.v() == 0 || ng3Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (ng3Var.b() - Math.max(ag3.K(view), ag3.K(view2))) - 1) : Math.max(0, Math.min(ag3.K(view), ag3.K(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(h31Var.d(view2) - h31Var.g(view)) / (Math.abs(ag3.K(view) - ag3.K(view2)) + 1))) + (h31Var.m() - h31Var.g(view)));
        }
        return iMax;
    }

    public static void e0(ByteArrayOutputStream byteArrayOutputStream, int i, yt0 yt0Var) throws IOException {
        int i2 = yt0Var.g;
        byte[] bArr = new byte[(((Integer.bitCount(i & (-2)) * i2) + 7) & (-8)) / 8];
        for (Map.Entry entry : yt0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i3 = 0;
            for (int i4 = 1; i4 <= 4; i4 <<= 1) {
                if (i4 != 1 && (i4 & i) != 0) {
                    if ((i4 & iIntValue2) == i4) {
                        int i5 = (i3 * i2) + iIntValue;
                        int i6 = i5 / 8;
                        bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
                    }
                    i3++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static int f(ng3 ng3Var, h31 h31Var, View view, View view2, ag3 ag3Var, boolean z) {
        if (ag3Var.v() == 0 || ng3Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return ng3Var.b();
        }
        return (int) (((h31Var.d(view2) - h31Var.g(view)) / (Math.abs(ag3.K(view) - ag3.K(view2)) + 1)) * ng3Var.b());
    }

    public static void f0(ByteArrayOutputStream byteArrayOutputStream, yt0 yt0Var) throws IOException {
        int i = 0;
        for (Map.Entry entry : yt0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                ez4.d0(byteArrayOutputStream, iIntValue - i);
                ez4.d0(byteArrayOutputStream, 0);
                i = iIntValue;
            }
        }
    }

    public static final String g(String str) {
        int iCodePointAt = Character.codePointAt(str, 0) - (-127397);
        int iCodePointAt2 = Character.codePointAt(str, 1) - (-127397);
        char[] chars = Character.toChars(iCodePointAt);
        chars.getClass();
        String str2 = new String(chars);
        char[] chars2 = Character.toChars(iCodePointAt2);
        chars2.getClass();
        return str2.concat(new String(chars2));
    }

    public static int g0(byte[] bArr, int i, za5 za5Var) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return h0(b2, bArr, i2, za5Var);
        }
        za5Var.a = b2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (defpackage.uf2.j(r9, r1, defpackage.n12.c(r7, r2) ? r0.getWidth() : defpackage.j.e(r7.a, r8), defpackage.n12.c(r7, r2) ? r0.getHeight() : defpackage.j.e(r7.b, r8), r8) == 1.0d) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap h(Drawable drawable, Bitmap.Config config, wx3 wx3Var, sp3 sp3Var, boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap3 = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap3.getConfig() == ((config == null || v02.q(config)) ? Bitmap.Config.ARGB_8888 : config)) {
                if (!z) {
                    int width = bitmap3.getWidth();
                    int height = bitmap3.getHeight();
                    wx3 wx3Var2 = wx3.c;
                }
                return bitmap3;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        Bitmap.Config config2 = j.a;
        boolean z2 = drawableMutate instanceof BitmapDrawable;
        BitmapDrawable bitmapDrawable = z2 ? (BitmapDrawable) drawableMutate : null;
        int intrinsicWidth = (bitmapDrawable == null || (bitmap2 = bitmapDrawable.getBitmap()) == null) ? drawableMutate.getIntrinsicWidth() : bitmap2.getWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 512;
        }
        BitmapDrawable bitmapDrawable2 = z2 ? (BitmapDrawable) drawableMutate : null;
        int intrinsicHeight = (bitmapDrawable2 == null || (bitmap = bitmapDrawable2.getBitmap()) == null) ? drawableMutate.getIntrinsicHeight() : bitmap.getHeight();
        int i = intrinsicHeight > 0 ? intrinsicHeight : 512;
        wx3 wx3Var3 = wx3.c;
        double dJ = uf2.j(intrinsicWidth, i, n12.c(wx3Var, wx3Var3) ? intrinsicWidth : j.e(wx3Var.a, sp3Var), n12.c(wx3Var, wx3Var3) ? i : j.e(wx3Var.b, sp3Var), sp3Var);
        int iA = vf2.A(((double) intrinsicWidth) * dJ);
        int iA2 = vf2.A(dJ * ((double) i));
        if (config == null || v02.q(config)) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, iA2, config);
        Rect bounds = drawableMutate.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iA, iA2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }

    public static int h0(int i, byte[] bArr, int i2, za5 za5Var) {
        byte b2 = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b2 >= 0) {
            za5Var.a = i4 | (b2 << 7);
            return i3;
        }
        int i5 = i4 | ((b2 & 127) << 7);
        int i6 = i2 + 2;
        byte b3 = bArr[i3];
        if (b3 >= 0) {
            za5Var.a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i2 + 3;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            za5Var.a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i2 + 4;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            za5Var.a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                za5Var.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static final void i(String str, String str2) {
        str2.getClass();
        List<sa3> listB = oj0.a.t().b(str);
        if (listB.isEmpty()) {
            return;
        }
        int iU = fh2.U(f70.Q(10, listB));
        if (iU < 16) {
            iU = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iU);
        for (sa3 sa3Var : listB) {
            linkedHashMap.put(sa3Var.b, sa3Var.c);
        }
        T(str2, linkedHashMap);
    }

    public static int i0(byte[] bArr, int i, za5 za5Var) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            za5Var.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & 127)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & 127)) << i4;
            b2 = b3;
            i3 = i5;
        }
        za5Var.b = j2;
        return i3;
    }

    public static boolean j(char c2) {
        if ((1424 <= c2 && c2 <= 2303) || c2 == 8206 || c2 == 8207) {
            return true;
        }
        if (8234 <= c2 && c2 <= 8238) {
            return true;
        }
        if (8294 <= c2 && c2 <= 8297) {
            return true;
        }
        if (55296 <= c2 && c2 <= 57343) {
            return true;
        }
        if (64285 > c2 || c2 > 65023) {
            return 65136 <= c2 && c2 <= 65278;
        }
        return true;
    }

    public static int j0(int i, byte[] bArr) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static byte[] k(yt0[] yt0VarArr, byte[] bArr) throws IOException {
        int i = 0;
        int length = 0;
        for (yt0 yt0Var : yt0VarArr) {
            length += ((((yt0Var.g * 2) + 7) & (-8)) / 8) + (yt0Var.e * 2) + r(yt0Var.a, yt0Var.b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + yt0Var.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, ek0.g)) {
            int length2 = yt0VarArr.length;
            while (i < length2) {
                yt0 yt0Var2 = yt0VarArr[i];
                d0(byteArrayOutputStream, yt0Var2, r(yt0Var2.a, yt0Var2.b, bArr));
                c0(byteArrayOutputStream, yt0Var2);
                i++;
            }
        } else {
            for (yt0 yt0Var3 : yt0VarArr) {
                d0(byteArrayOutputStream, yt0Var3, r(yt0Var3.a, yt0Var3.b, bArr));
            }
            int length3 = yt0VarArr.length;
            while (i < length3) {
                c0(byteArrayOutputStream, yt0VarArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        s53.e(byteArrayOutputStream.size(), length, " expected=", "The bytes saved do not match expectation. actual=");
        return null;
    }

    public static long k0(int i, byte[] bArr) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public static final void l(ge1 ge1Var, u03 u03Var) throws IOException {
        try {
            IOException iOException = null;
            for (u03 u03Var2 : ge1Var.I(u03Var)) {
                try {
                    if (ge1Var.M(u03Var2).c) {
                        l(ge1Var, u03Var2);
                    }
                    ge1Var.x(u03Var2);
                } catch (IOException e2) {
                    if (iOException == null) {
                        iOException = e2;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static int l0(byte[] bArr, int i, za5 za5Var) throws pc5 {
        int iG0 = g0(bArr, i, za5Var);
        int i2 = za5Var.a;
        if (i2 < 0) {
            a.d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 == 0) {
            za5Var.c = "";
            return iG0;
        }
        int i3 = qe5.a;
        int length = bArr.length;
        if ((((length - iG0) - i2) | iG0 | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iG0), Integer.valueOf(i2)));
        }
        int i4 = iG0 + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (iG0 < i4) {
            byte b2 = bArr[iG0];
            if (b2 < 0) {
                break;
            }
            iG0++;
            cArr[i5] = (char) b2;
            i5++;
        }
        while (iG0 < i4) {
            int i6 = iG0 + 1;
            byte b3 = bArr[iG0];
            if (b3 >= 0) {
                cArr[i5] = (char) b3;
                i5++;
                iG0 = i6;
                while (iG0 < i4) {
                    byte b4 = bArr[iG0];
                    if (b4 >= 0) {
                        iG0++;
                        cArr[i5] = (char) b4;
                        i5++;
                    }
                }
            } else if (b3 < -32) {
                if (i6 >= i4) {
                    a.d("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i7 = i5 + 1;
                iG0 += 2;
                byte b5 = bArr[i6];
                if (b3 < -62 || uf2.T(b5)) {
                    a.d("Protocol message had invalid UTF-8.");
                    return 0;
                }
                cArr[i5] = (char) ((b5 & 63) | ((b3 & 31) << 6));
                i5 = i7;
            } else {
                if (b3 < -16) {
                    if (i6 >= i4 - 1) {
                        a.d("Protocol message had invalid UTF-8.");
                        return 0;
                    }
                    int i8 = i5 + 1;
                    int i9 = iG0 + 2;
                    byte b6 = bArr[i6];
                    iG0 += 3;
                    byte b7 = bArr[i9];
                    if (!uf2.T(b6)) {
                        if (b3 == -32) {
                            if (b6 >= -96) {
                                b3 = -32;
                            }
                        }
                        if (b3 == -19) {
                            if (b6 < -96) {
                                b3 = -19;
                            }
                        }
                        if (!uf2.T(b7)) {
                            cArr[i5] = (char) (((b6 & 63) << 6) | ((b3 & 15) << 12) | (b7 & 63));
                            i5 = i8;
                        }
                    }
                    a.d("Protocol message had invalid UTF-8.");
                    return 0;
                }
                if (i6 >= i4 - 2) {
                    a.d("Protocol message had invalid UTF-8.");
                    return 0;
                }
                byte b8 = bArr[i6];
                int i10 = iG0 + 3;
                byte b9 = bArr[iG0 + 2];
                iG0 += 4;
                byte b10 = bArr[i10];
                if (uf2.T(b8) || (((b8 + 112) + (b3 << 28)) >> 30) != 0 || uf2.T(b9) || uf2.T(b10)) {
                    a.d("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i11 = ((b8 & 63) << 12) | ((b3 & 7) << 18) | ((b9 & 63) << 6) | (b10 & 63);
                cArr[i5] = (char) ((i11 >>> 10) + 55232);
                cArr[i5 + 1] = (char) ((i11 & 1023) + 56320);
                i5 += 2;
            }
        }
        za5Var.c = new String(cArr, 0, i5);
        return i4;
    }

    public static boolean m(h82 h82Var, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (h82Var != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return h82Var.k(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!d) {
                            try {
                                e = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            d = true;
                        }
                        Method method = e;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (wp4.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!f) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        g = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    f = true;
                }
                Field field = g;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (wp4.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && wp4.c(view, keyEvent)) || h82Var.k(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static int m0(byte[] bArr, int i, za5 za5Var) throws pc5 {
        int iG0 = g0(bArr, i, za5Var);
        int i2 = za5Var.a;
        if (i2 < 0) {
            a.d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i2 > bArr.length - iG0) {
            a.d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i2 == 0) {
            za5Var.c = hb5.z;
            return iG0;
        }
        za5Var.c = hb5.d(iG0, i2, bArr);
        return iG0 + i2;
    }

    public static final zf1 n(zf1 zf1Var) {
        return ((zf1Var instanceof k24) || (zf1Var instanceof dw0)) ? zf1Var : new dw0(zf1Var);
    }

    public static int n0(Object obj, sd5 sd5Var, byte[] bArr, int i, int i2, za5 za5Var) throws pc5 {
        int iH0 = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iH0 = h0(i3, bArr, iH0, za5Var);
            i3 = za5Var.a;
        }
        int i4 = iH0;
        if (i3 < 0 || i3 > i2 - i4) {
            a.d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i5 = za5Var.d + 1;
        za5Var.d = i5;
        if (i5 >= 100) {
            a.d("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i6 = i4 + i3;
        sd5Var.i(obj, bArr, i4, i6, za5Var);
        za5Var.d--;
        za5Var.c = obj;
        return i6;
    }

    public static final Object o(r13 r13Var, String str, ie0 ie0Var) {
        Object objB = r13Var.b(str, new q74(6), ie0Var);
        return objB == mf0.b ? objB : xl4.a;
    }

    public static int o0(Object obj, sd5 sd5Var, byte[] bArr, int i, int i2, int i3, za5 za5Var) throws pc5 {
        id5 id5Var = (id5) sd5Var;
        int i4 = za5Var.d + 1;
        za5Var.d = i4;
        if (i4 >= 100) {
            a.d("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int iT = id5Var.t(obj, bArr, i, i2, i3, za5Var);
        za5Var.d--;
        za5Var.c = obj;
        return iT;
    }

    public static final LinkedList p(int i, String str, boolean z) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (i != 0) {
            for (int i2 = 0; i2 < 64510; i2++) {
                ServerSocket serverSocket = new ServerSocket(0, 1, InetAddress.getByName(str));
                if (z) {
                    try {
                        new DatagramSocket(serverSocket.getLocalPort(), InetAddress.getByName(str)).close();
                    } catch (Exception unused) {
                        serverSocket.close();
                    }
                }
                linkedList.add(Integer.valueOf(serverSocket.getLocalPort()));
                serverSocket.close();
                if (linkedList.size() == i) {
                    break;
                }
            }
        }
        return linkedList;
    }

    public static int p0(int i, byte[] bArr, int i2, int i3, mc5 mc5Var, za5 za5Var) {
        fc5 fc5Var = (fc5) mc5Var;
        int iG0 = g0(bArr, i2, za5Var);
        fc5Var.d(za5Var.a);
        while (iG0 < i3) {
            int iG02 = g0(bArr, iG0, za5Var);
            if (i != za5Var.a) {
                break;
            }
            iG0 = g0(bArr, iG02, za5Var);
            fc5Var.d(za5Var.a);
        }
        return iG0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final eu q(long j, boolean z) {
        int i;
        long j2;
        boolean z2 = j < 0;
        if (z2) {
            j = -j;
        }
        float f2 = j;
        if (f2 > 900.0f) {
            f2 /= 1024.0f;
            i = R.string.kilobyteShort;
            j2 = 1024;
        } else {
            i = R.string.byteShort;
            j2 = 1;
        }
        if (f2 > 900.0f) {
            j2 *= 1024;
            f2 /= 1024.0f;
            i = R.string.megabyteShort;
        }
        if (f2 > 900.0f) {
            j2 *= 1024;
            f2 /= 1024.0f;
            i = R.string.gigabyteShort;
        }
        if (f2 > 900.0f) {
            j2 *= 1024;
            f2 /= 1024.0f;
            i = R.string.terabyteShort;
        }
        if (f2 > 900.0f) {
            j2 *= 1024;
            f2 /= 1024.0f;
            i = R.string.petabyteShort;
        }
        String str = "%.0f";
        if (j2 != 1 && f2 < 100.0f) {
            if (f2 >= 1.0f) {
                if (f2 < 10.0f) {
                    str = z ? "%.1f" : "%.2f";
                } else if (!z) {
                }
            }
        }
        if (z2) {
            f2 = -f2;
        }
        String str2 = String.format(str, Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
        String string = ContextUtilsKt.getContext().getString(i);
        string.getClass();
        return new eu(str2, string);
    }

    public static int q0(byte[] bArr, int i, mc5 mc5Var, za5 za5Var) throws pc5 {
        fc5 fc5Var = (fc5) mc5Var;
        int iG0 = g0(bArr, i, za5Var);
        int i2 = za5Var.a + iG0;
        while (iG0 < i2) {
            iG0 = g0(bArr, iG0, za5Var);
            fc5Var.d(za5Var.a);
        }
        if (iG0 == i2) {
            return iG0;
        }
        a.d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static String r(String str, String str2, byte[] bArr) {
        byte[] bArr2 = ek0.h;
        byte[] bArr3 = ek0.i;
        String str3 = (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return fw.y(new StringBuilder(str), (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static int r0(sd5 sd5Var, int i, byte[] bArr, int i2, int i3, mc5 mc5Var, za5 za5Var) throws pc5 {
        dc5 dc5VarA = sd5Var.a();
        sd5 sd5Var2 = sd5Var;
        byte[] bArr2 = bArr;
        int i4 = i3;
        za5 za5Var2 = za5Var;
        int iN0 = n0(dc5VarA, sd5Var2, bArr2, i2, i4, za5Var2);
        sd5Var2.g(dc5VarA);
        za5Var2.c = dc5VarA;
        mc5Var.add(dc5VarA);
        while (iN0 < i4) {
            za5 za5Var3 = za5Var2;
            int i5 = i4;
            int iG0 = g0(bArr2, iN0, za5Var3);
            if (i != za5Var3.a) {
                break;
            }
            byte[] bArr3 = bArr2;
            sd5 sd5Var3 = sd5Var2;
            dc5 dc5VarA2 = sd5Var3.a();
            iN0 = n0(dc5VarA2, sd5Var3, bArr3, iG0, i5, za5Var3);
            sd5Var2 = sd5Var3;
            bArr2 = bArr3;
            i4 = i5;
            za5Var2 = za5Var3;
            sd5Var2.g(dc5VarA2);
            za5Var2.c = dc5VarA2;
            mc5Var.add(dc5VarA2);
        }
        return iN0;
    }

    public static qt s(Object obj) {
        return new qt(Array.getLength(obj), 4, obj.getClass(), obj);
    }

    public static int s0(int i, byte[] bArr, int i2, int i3, fe5 fe5Var, za5 za5Var) throws pc5 {
        if ((i >>> 3) == 0) {
            a.d("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iI0 = i0(bArr, i2, za5Var);
            fe5Var.d(i, Long.valueOf(za5Var.b));
            return iI0;
        }
        if (i4 == 1) {
            fe5Var.d(i, Long.valueOf(k0(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iG0 = g0(bArr, i2, za5Var);
            int i5 = za5Var.a;
            if (i5 < 0) {
                a.d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i5 > bArr.length - iG0) {
                a.d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i5 == 0) {
                fe5Var.d(i, hb5.z);
            } else {
                fe5Var.d(i, hb5.d(iG0, i5, bArr));
            }
            return iG0 + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                fe5Var.d(i, Integer.valueOf(j0(i2, bArr)));
                return i2 + 4;
            }
            a.d("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i6 = (i & (-8)) | 4;
        fe5 fe5VarA = fe5.a();
        int i7 = za5Var.d + 1;
        za5Var.d = i7;
        if (i7 >= 100) {
            a.d("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iG02 = g0(bArr, i2, za5Var);
            int i9 = za5Var.a;
            if (i9 == i6) {
                i8 = i9;
                i2 = iG02;
                break;
            }
            i2 = s0(i9, bArr, iG02, i3, fe5VarA, za5Var);
            i8 = i9;
        }
        za5Var.d--;
        if (i2 > i3 || i8 != i6) {
            a.d("Failed to parse the message.");
            return 0;
        }
        fe5Var.d(i, fe5VarA);
        return i2;
    }

    public static int t(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        try {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            ColorStateList colorStateListG = resourceId != 0 ? v9.g(context, resourceId) : typedArrayObtainStyledAttributes.getColorStateList(0);
            if (colorStateListG != null) {
                return colorStateListG.getDefaultColor();
            }
            return 0;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int t0(int i, byte[] bArr, int i2, int i3, za5 za5Var) throws pc5 {
        if ((i >>> 3) == 0) {
            a.d("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return i0(bArr, i2, za5Var);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return g0(bArr, i2, za5Var) + za5Var.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            a.d("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = g0(bArr, i2, za5Var);
            i6 = za5Var.a;
            if (i6 == i5) {
                break;
            }
            i2 = t0(i6, bArr, i2, i3, za5Var);
        }
        if (i2 <= i3 && i6 == i5) {
            return i2;
        }
        a.d("Failed to parse the message.");
        return 0;
    }

    public static final CharSequence u(Throwable th, CharSequence charSequence) {
        th.getClass();
        String message = th.getMessage();
        if ((th instanceof ExecutionException) && (th.getCause() instanceof ns4)) {
            Throwable cause = th.getCause();
            cause.getClass();
            th = (ns4) cause;
        }
        if ((th instanceof t63) && message == null) {
            message = ContextUtilsKt.k(R.string.not_a_valid_import_url_format);
        }
        if (!(th instanceof TimeoutException) && !(th instanceof ge4)) {
            if (th instanceof mt3) {
                jr2 jr2Var = ((mt3) th).b;
                message = ContextUtilsKt.l(R.string.http_status_error_template, jr2Var != null ? Integer.valueOf(jr2Var.a) : null, message);
            } else if (th instanceof ns4) {
                jr2 jr2Var2 = ((ns4) th).b;
                message = ContextUtilsKt.l(R.string.http_status_error_template, jr2Var2 != null ? Integer.valueOf(jr2Var2.a) : null, message);
            }
        } else if (message == null) {
            message = ContextUtilsKt.k(R.string.network_timeout);
        }
        return message == null ? charSequence : message;
    }

    public static final Integer v(g03 g03Var) {
        if (g03Var == null) {
            return null;
        }
        int iOrdinal = g03Var.ordinal();
        if (iOrdinal == 0) {
            return Integer.valueOf(R.drawable.ic_round_check_circle_outline_24);
        }
        if (iOrdinal == 1) {
            return Integer.valueOf(R.drawable.ic_round_info_24);
        }
        if (iOrdinal == 2) {
            return Integer.valueOf(R.drawable.ic_round_warning_amber_24);
        }
        if (iOrdinal == 3) {
            return Integer.valueOf(R.drawable.ic_round_report_gmailerrorred_24);
        }
        g.d();
        return null;
    }

    public static final HashMap w(t53 t53Var) {
        LinkedHashMap linkedHashMap = t53Var.H0;
        ua3 ua3VarT = oj0.a.t();
        String str = t53Var.b;
        List<sa3> listB = ua3VarT.b(str);
        if (listB.isEmpty()) {
            HashMap map = new HashMap();
            Collection collectionValues = linkedHashMap.values();
            collectionValues.getClass();
            for (na3 na3Var : d70.y0(collectionValues)) {
                if (na3Var.w().isEmpty()) {
                    g.g(ha0.o("ProxyGroup ", na3Var.getName(), " has no proxies inside"));
                    return null;
                }
                map.put(na3Var.getName(), d70.c0(na3Var.w()));
            }
            if (!t53Var.I0.f.isEmpty()) {
                ka3 ka3Var = t53Var.I0;
                map.put(ka3Var.b, d70.c0(ka3Var.f));
            }
            T(str, map);
            return map;
        }
        HashMap map2 = new HashMap();
        for (sa3 sa3Var : listB) {
            map2.put(sa3Var.b, sa3Var.c);
        }
        boolean z = false;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                map2.put(entry.getKey(), d70.c0(((na3) entry.getValue()).w()));
                z = true;
            }
        }
        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            if (t53Var.l((String) entry2.getValue(), map2) == null) {
                na3 na3Var2 = (na3) linkedHashMap.get(entry2.getKey());
                if (na3Var2 == null) {
                    na3Var2 = n12.c(t53Var.I0.b, entry2.getKey()) ? t53Var.I0 : null;
                }
                if (na3Var2 == null) {
                    it.remove();
                } else if (!na3Var2.w().isEmpty()) {
                    entry2.setValue(d70.c0(na3Var2.w()));
                } else {
                    if (!na3Var2.equals(t53Var.I0)) {
                        throw new IllegalStateException(("ProxyGroup " + na3Var2.getName() + " has no proxies inside").toString());
                    }
                    it.remove();
                }
                z = true;
            }
        }
        if (z) {
            T(str, map2);
        }
        return map2;
    }

    public static final rj2 x(String str) {
        str.getClass();
        rj2 rj2Var = new rj2();
        ua3 ua3VarT = oj0.a.t();
        ua3VarT.getClass();
        rj2Var.m(ua3VarT.a.g().b(new String[]{"proxy_group_selection"}, new ko0(str, 9)), new x3(8, new f0(19, rj2Var)));
        return rj2Var;
    }

    public static boolean y(Activity activity, f4 f4Var) {
        ComponentName componentName = activity.getComponentName();
        componentName.getClass();
        if (a(new f4(componentName), f4Var)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            return z(intent, f4Var);
        }
        return false;
    }

    public static boolean z(Intent intent, f4 f4Var) {
        String str;
        String str2 = f4Var.a;
        ComponentName component = intent.getComponent();
        if (a(component != null ? new f4(component) : null, f4Var)) {
            return true;
        }
        if (intent.getComponent() == null && (str = intent.getPackage()) != null) {
            return (str.equals(str2) || Z(str, str2)) && f4Var.b.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
        }
        return false;
    }

    public abstract void E(int i);

    public abstract void F(Typeface typeface);

    public void c(int i) {
        new Handler(Looper.getMainLooper()).post(new jw(i, 2, this));
    }
}
