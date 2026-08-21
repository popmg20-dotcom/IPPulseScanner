package defpackage;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.common.UpdateProfileWorker;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Function;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tj4 {
    public static final double[][] a = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    public static final double[] b = {95.047d, 100.0d, 108.883d};
    public static final i60 c = new i60(6);
    public static final String[] d = {"https://doh.pub/dns-query", "https://dns.alidns.com/dns-query", "https://223.5.5.5/dns-query", "https://223.6.6.6/dns-query"};
    public static final String[] e = {"https://dns.adguard.com/dns-query", "https://cloudflare-dns.com/dns-query", "https://1.1.1.1/dns-query", "https://1.0.0.1/dns-query", "https://dns.google/dns-query", "https://doh.opendns.com/dns-query"};
    public static final String[] f = {"system", "syslib", "8.8.8.8", "8.8.4.4", "1.1.1.1", "1.0.0.1", "223.5.5.5", "223.6.6.6", "119.29.29.29", "114.114.114.114", "208.67.222.222", "208.67.220.220"};
    public static final String[] g = {"freestun.net:3478", "stun.sipnet.net:3478", "stun.smartvoip.com:3478", "jstun.javawi.de:3478", "stun.syncthing.net:3478", "stun.l.google.com:19302", "stun.cloudflare.com:3478"};
    public static Boolean h;
    public static Boolean i;
    public static Boolean j;
    public static Boolean k;

    public static af0 A(af0 af0Var, bf0 bf0Var) {
        bf0Var.getClass();
        if (n12.c(af0Var.getKey(), bf0Var)) {
            return af0Var;
        }
        return null;
    }

    public static Object B(nj4 nj4Var) {
        Class cls = nj4Var.L0;
        Class clsU = n50.u(cls);
        if (clsU == null) {
            if (nj4Var.h0() || nj4Var.B()) {
                return s52.z;
            }
            if (cls == String.class) {
                return "";
            }
            if (nj4Var.k0(Date.class)) {
                return new Date(0L);
            }
            if (!nj4Var.k0(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsU == Integer.TYPE) {
            return 0;
        }
        if (clsU == Long.TYPE) {
            return 0L;
        }
        if (clsU == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsU == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsU == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsU == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsU == Short.TYPE) {
            return (short) 0;
        }
        if (clsU == Character.TYPE) {
            return (char) 0;
        }
        xe.r("Class ", clsU.getName(), " is not a primitive type");
        return null;
    }

    public static final xn3 E(String str) throws IOException {
        str.getClass();
        File file = new File(new File(ContextUtilsKt.getContext().getFilesDir(), "rule_set"), ha0.x(r25.K(str), ".conf"));
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArrS = l72.S(fileInputStream);
            Uri uriFromFile = Uri.fromFile(file);
            uriFromFile.getClass();
            xn3 xn3Var = new xn3(str, bArrS, uriFromFile, file.lastModified());
            fileInputStream.close();
            return xn3Var;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ez4.l(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final boolean G() {
        Integer numM0;
        String strR = xb5.r();
        return ((strR == null || (numM0 = w44.m0(strR)) == null) ? 0 : numM0.intValue()) / 100 == 432 || n12.c(Locale.getDefault().getLanguage(), "fa");
    }

    public static final boolean H() {
        Integer numM0;
        String strR = xb5.r();
        return ((strR == null || (numM0 = w44.m0(strR)) == null) ? 0 : numM0.intValue()) / 100 == 460 || n12.c(Locale.getDefault().getLanguage(), "zh");
    }

    public static boolean K(int i2, Object obj) {
        if (obj instanceof Function) {
            if ((obj instanceof lm1 ? ((lm1) obj).b() : obj instanceof pl1 ? 0 : obj instanceof am1 ? 1 : obj instanceof Function2 ? 2 : obj instanceof em1 ? 3 : obj instanceof fm1 ? 4 : obj instanceof yw4 ? 6 : obj instanceof l60 ? 7 : -1) == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean L(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Boolean boolValueOf = h;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
            h = boolValueOf;
        }
        if (boolValueOf.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        Boolean boolValueOf2 = i;
        if (boolValueOf2 == null) {
            boolValueOf2 = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
            i = boolValueOf2;
        }
        if (boolValueOf2.booleanValue()) {
            return !vf2.v() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static double M(double d2) {
        return d2 > 0.008856451679035631d ? Math.pow(d2, 0.3333333333333333d) : ((d2 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float N(defpackage.kn2 r8, defpackage.kn2 r9, float r10) {
        /*
            r8.getClass()
            r9.getClass()
            r0 = 0
            int r1 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r1 > 0) goto L8e
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 > 0) goto L8e
            r2 = 0
            int r3 = r8.b
            b12 r2 = defpackage.gb4.d0(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L1c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L88
            r3 = r2
            a12 r3 = (defpackage.a12) r3
            int r3 = r3.nextInt()
            float r4 = r8.b(r3)
            int r5 = r3 + 1
            int r6 = r8.b
            int r6 = r5 % r6
            float r6 = r8.b(r6)
            int r7 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r7 < 0) goto L44
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 > 0) goto L1c
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 > 0) goto L1c
            goto L4c
        L44:
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 >= 0) goto L4c
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 > 0) goto L1c
        L4c:
            int r0 = r8.b
            int r5 = r5 % r0
            float r0 = r8.b(r5)
            float r2 = r8.b(r3)
            float r0 = r0 - r2
            float r0 = defpackage.eo4.d(r0, r1)
            float r2 = r9.b(r5)
            float r4 = r9.b(r3)
            float r2 = r2 - r4
            float r2 = defpackage.eo4.d(r2, r1)
            r4 = 981668463(0x3a83126f, float:0.001)
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 >= 0) goto L73
            r8 = 1056964608(0x3f000000, float:0.5)
            goto L7d
        L73:
            float r8 = r8.b(r3)
            float r10 = r10 - r8
            float r8 = defpackage.eo4.d(r10, r1)
            float r8 = r8 / r0
        L7d:
            float r9 = r9.b(r3)
            float r2 = r2 * r8
            float r2 = r2 + r9
            float r8 = defpackage.eo4.d(r2, r1)
            return r8
        L88:
            java.lang.String r8 = "Collection contains no element matching the predicate."
            defpackage.e04.h(r8)
            return r0
        L8e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Invalid progress: "
            r8.<init>(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tj4.N(kn2, kn2, float):float");
    }

    public static double O(int i2) {
        double d2 = ((double) i2) / 255.0d;
        return (d2 <= 0.040449936d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d)) * 100.0d;
    }

    public static cf0 P(af0 af0Var, bf0 bf0Var) {
        bf0Var.getClass();
        return n12.c(af0Var.getKey(), bf0Var) ? c41.b : af0Var;
    }

    public static PorterDuff.Mode V(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static cf0 W(af0 af0Var, cf0 cf0Var) {
        cf0Var.getClass();
        return cf0Var == c41.b ? af0Var : (cf0) cf0Var.c0(af0Var, new dt(2));
    }

    public static final long X(String str, byte[] bArr) throws IOException {
        str.getClass();
        File file = new File(new File(ContextUtilsKt.getContext().getFilesDir(), "rule_set"), ha0.x(r25.K(str), ".conf"));
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return file.lastModified();
        } finally {
        }
    }

    public static boolean a(RectF rectF, float f2, float f3, float f4) {
        return f2 >= rectF.left - f4 && f2 <= rectF.right + f4 && f3 >= rectF.top - f4 && f3 <= rectF.bottom + f4;
    }

    public static Map b(LinkedHashMap linkedHashMap) {
        if (!(linkedHashMap instanceof z72)) {
            return linkedHashMap;
        }
        h0(linkedHashMap, "kotlin.collections.MutableMap");
        throw null;
    }

    public static void c(int i2, Object obj) {
        if (obj == null || K(i2, obj)) {
            return;
        }
        h0(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static void d(boolean z) {
        if (z) {
            return;
        }
        s53.d();
    }

    public static final q02 d0(InputStream inputStream) {
        inputStream.getClass();
        return new q02(inputStream, new de4());
    }

    public static void e(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 35 + 1);
            ha0.v(sb, "Must be called on ", name2, " thread, but got ", name);
            st4.m(sb, ".");
        }
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            xe.k("Given String is empty or null");
        }
    }

    public static final String f0(InetAddress inetAddress) {
        inetAddress.getClass();
        String string = inetAddress.toString();
        string.getClass();
        return p44.G0(":0", p44.F0(string, "/"));
    }

    public static void g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            xe.k(str2);
        }
    }

    public static final String g0(SocketAddress socketAddress) {
        String strO;
        socketAddress.getClass();
        if (!(socketAddress instanceof InetSocketAddress)) {
            return p44.G0(":0", p44.F0(socketAddress.toString(), "/"));
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        if (inetSocketAddress.isUnresolved()) {
            strO = ke0.J(inetSocketAddress.getHostString()).concat("/<unresolved>");
        } else {
            boolean zC = n12.c(inetSocketAddress.getHostString(), inetSocketAddress.getAddress().getHostAddress());
            boolean z = inetSocketAddress.getAddress() instanceof Inet6Address;
            if (zC) {
                strO = z ? ha0.o("[", inetSocketAddress.getAddress().getHostAddress(), "]") : ke0.J(inetSocketAddress.getHostString());
            } else {
                String hostAddress = inetSocketAddress.getAddress().getHostAddress();
                if (z) {
                    hostAddress = ha0.o("[", hostAddress, "]");
                }
                strO = ha0.o(ke0.J(inetSocketAddress.getHostString()), "/", hostAddress);
            }
        }
        return p44.G0(":0", p44.F0(strO + ":" + inetSocketAddress.getPort(), "/"));
    }

    public static void h(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        xe.q(str);
    }

    public static void h0(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(ha0.o(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        n12.P(classCastException, tj4.class.getName());
        throw classCastException;
    }

    public static void i(Object obj) {
        if (obj != null) {
            return;
        }
        zo2.n("null reference");
    }

    public static final int i0(InetAddress inetAddress) {
        return (inetAddress.getAddress()[3] & 255) | ((inetAddress.getAddress()[0] & 255) << 24) | ((inetAddress.getAddress()[1] & 255) << 16) | ((inetAddress.getAddress()[2] & 255) << 8);
    }

    public static void j(Object obj, String str) {
        if (obj != null) {
            return;
        }
        zo2.n(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.w64 j0(int r5, android.util.Size r6, defpackage.ph r7, int r8, defpackage.u64 r9, defpackage.d44 r10) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tj4.j0(int, android.util.Size, ph, int, u64, d44):w64");
    }

    public static void k(String str, boolean z) {
        if (z) {
            return;
        }
        xe.q(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final dm3 k0(dm3 dm3Var, Matrix matrix) {
        dm3Var.getClass();
        v62 v62Var = new v62(26, new float[2], matrix, 0 == true ? 1 : 0);
        long jO0 = yr2.o0(qf1.a(dm3Var.b, dm3Var.c), v62Var);
        ub2 ub2VarI = p95.i();
        List list = dm3Var.a;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ub2VarI.add(((jc1) list.get(i2)).a(v62Var));
        }
        return new dm3(p95.c(ub2VarI), yr2.H(jO0), yr2.I(jO0));
    }

    public static float l(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static final void l0(kn2 kn2Var) {
        kn2Var.getClass();
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = kn2Var.a;
        int i2 = kn2Var.b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= i2) {
                break;
            }
            float f2 = fArr[i4];
            if (!boolValueOf.booleanValue() || 0.0f > f2 || f2 > 1.0f) {
                z = false;
            }
            boolValueOf = Boolean.valueOf(z);
            i4++;
        }
        if (!boolValueOf.booleanValue()) {
            e04.f("FloatMapping - Progress outside of range: ".concat(kn2.c(kn2Var, 31)));
            return;
        }
        Iterable iterableD0 = gb4.d0(1, kn2Var.b);
        if (!(iterableD0 instanceof Collection) || !((Collection) iterableD0).isEmpty()) {
            Iterator it = iterableD0.iterator();
            while (((a12) it).z) {
                int iNextInt = ((a12) it).nextInt();
                if (kn2Var.b(iNextInt) < kn2Var.b(iNextInt - 1) && (i3 = i3 + 1) < 0) {
                    e70.O();
                    throw null;
                }
            }
        }
        if (i3 <= 1) {
            return;
        }
        e04.f("FloatMapping - Progress wraps more than once: ".concat(kn2.c(kn2Var, 31)));
    }

    public static int m(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static final void n() {
        try {
            InetAddress.class.getMethod("clearDnsCache", null).invoke(null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static double n0(double d2) {
        double d3 = (d2 + 16.0d) / 116.0d;
        double d4 = d3 * d3 * d3;
        if (d4 <= 0.008856451679035631d) {
            d4 = ((d3 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        return d4 * 100.0d;
    }

    public static String o(ClipData clipData) {
        if (clipData == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
            if (i2 > 0) {
                sb.append('\n');
            }
            ClipData.Item itemAt = clipData.getItemAt(i2);
            if (itemAt.getText() != null) {
                sb.append(itemAt.getText());
            } else if (itemAt.getUri() != null) {
                sb.append(itemAt.getUri().toString());
            } else if (itemAt.getIntent() != null) {
                sb.append(itemAt.getIntent().toUri(1));
            }
        }
        return sb.toString();
    }

    public static void o0(int i2, Object[] objArr) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (objArr[i3] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 9);
                sb.append("at index ");
                sb.append(i3);
                throw new NullPointerException(sb.toString());
            }
        }
    }

    public static w64 r(v64 v64Var, t64 t64Var, d44 d44Var) {
        t64Var.getClass();
        d44Var.getClass();
        return new w64(v64Var, t64Var, d44Var);
    }

    public static Handler s(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return u9.b(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException e2) {
            e = e2;
            a1.o("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InstantiationException e3) {
            e = e3;
            a1.o("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (NoSuchMethodException e4) {
            e = e4;
            a1.o("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            vp1.p(cause);
            return null;
        }
    }

    public static yx t(yx... yxVarArr) {
        List listAsList = Arrays.asList(yxVarArr);
        return listAsList.isEmpty() ? new ay() : listAsList.size() == 1 ? (yx) listAsList.get(0) : new zx(listAsList);
    }

    public static final long u() {
        return Thread.currentThread().getId();
    }

    public static int v(double d2) {
        double d3 = d2 / 100.0d;
        int iRound = (int) Math.round((d3 <= 0.0031308d ? d3 * 12.92d : (Math.pow(d3, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d);
        if (iRound < 0) {
            return 0;
        }
        return iRound > 255 ? DnsRecord.CLASS_ANY : iRound;
    }

    public static void x(View view, mr4 mr4Var) {
        int paddingStart = view.getPaddingStart();
        int paddingTop = view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        nr4 nr4Var = new nr4();
        nr4Var.a = paddingStart;
        nr4Var.b = paddingTop;
        nr4Var.c = paddingEnd;
        nr4Var.d = paddingBottom;
        e24 e24Var = new e24(17, mr4Var, nr4Var, false);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(view, e24Var);
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new kr4());
        }
    }

    public static float y(Context context, int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static final void z(zk zkVar, xw4 xw4Var, boolean z) {
        ih4 ih4Var = xw4Var.d;
        na0 na0Var = xw4Var.b;
        zkVar.getClass();
        xf2 xf2VarJ = zkVar.j();
        int i2 = 3;
        if (xf2VarJ != null) {
            long j2 = xf2VarJ.f;
            if (!xf2VarJ.a()) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                timeUnit.getClass();
                qv2 qv2Var = new qv2(UpdateProfileWorker.class, 1);
                gx4 gx4Var = qv2Var.b;
                long millis = timeUnit.toMillis(j2);
                String str = gx4.z;
                if (millis < 900000) {
                    ue2.g().j(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
                }
                long j3 = millis < 900000 ? 900000L : millis;
                long j4 = millis < 900000 ? 900000L : millis;
                if (j3 < 900000) {
                    ue2.g().j(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
                }
                gx4Var.h = j3 < 900000 ? 900000L : j3;
                if (j4 < 300000) {
                    ue2.g().j(str, "Flex duration lesser than minimum allowed value; Changed to 300000");
                }
                if (j4 > gx4Var.h) {
                    ue2.g().j(str, "Flex duration greater than interval duration; Changed to " + j3);
                }
                gx4Var.i = gb4.w(j4, 300000L, gx4Var.h);
                String name = zkVar.getName();
                name.getClass();
                Set set = qv2Var.c;
                set.add(name);
                set.add("UpdateProfileWorker");
                e03[] e03VarArr = {new e03("name", zkVar.getName())};
                cp1 cp1Var = new cp1(19);
                e03 e03Var = e03VarArr[0];
                cp1Var.d0(e03Var.f, (String) e03Var.b);
                qv2Var.b.e = cp1Var.f();
                if (!z) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - zkVar.W();
                    if (0 <= jCurrentTimeMillis && jCurrentTimeMillis <= j2 * 1000) {
                        TimeUnit.MILLISECONDS.getClass();
                        qv2Var.b.g = jCurrentTimeMillis;
                        if (Long.MAX_VALUE - System.currentTimeMillis() <= qv2Var.b.g) {
                            xe.k("The given initial delay is too large and will cause an overflow!");
                            return;
                        }
                    }
                }
                c13 c13Var = (c13) qv2Var.a();
                String name2 = zkVar.getName();
                n71 n71Var = n71.b;
                n71 n71Var2 = n71.f;
                n71 n71Var3 = z ? n71Var2 : n71Var;
                if (n71Var3 != n71Var2) {
                    new nw4(xw4Var, name2, n71Var3 == n71Var ? o71.f : o71.b, Collections.singletonList(c13Var), 0).a();
                    return;
                }
                name2.getClass();
                t60 t60Var = na0Var.g;
                String strConcat = "enqueueUniquePeriodic_".concat(name2);
                la laVar = (la) ih4Var.a;
                laVar.getClass();
                p95.w(t60Var, strConcat, laVar, new b4(i2, xw4Var, name2, c13Var));
                return;
            }
        }
        String name3 = zkVar.getName();
        name3.getClass();
        t60 t60Var2 = na0Var.g;
        String strConcat2 = "CancelWorkByName_".concat(name3);
        la laVar2 = (la) ih4Var.a;
        laVar2.getClass();
        p95.w(t60Var2, strConcat2, laVar2, new qi(i2, name3, xw4Var));
    }

    public abstract int C();

    public abstract InputFilter[] D(InputFilter[] inputFilterArr);

    public abstract Context F();

    public boolean I() {
        return false;
    }

    public abstract boolean J();

    public abstract void Q();

    public abstract boolean S(int i2, KeyEvent keyEvent);

    public boolean T(KeyEvent keyEvent) {
        return false;
    }

    public boolean U() {
        return false;
    }

    public abstract void Y(boolean z);

    public abstract void Z(boolean z);

    public abstract void a0(boolean z);

    public abstract void b0(boolean z);

    public abstract void c0(CharSequence charSequence);

    public u3 e0(lb lbVar) {
        return null;
    }

    public abstract TransformationMethod m0(TransformationMethod transformationMethod);

    public boolean p() {
        return false;
    }

    public abstract boolean q();

    public abstract void w(boolean z);

    public void R() {
    }
}
