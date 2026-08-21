package defpackage;

import android.app.Application;
import android.app.Notification;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Icon;
import android.icu.text.DecimalFormatSymbols;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.PrecomputedText;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.Menu;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import io.sentry.android.core.a1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class u9 {
    public static String a;
    public static int b;
    public static Boolean c;

    public static int A(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int B(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static void C(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }

    public static void D(Menu menu) {
        menu.setGroupDividerEnabled(true);
    }

    public static void E(Notification.Action.Builder builder) {
        builder.setSemanticAction(0);
    }

    public static boolean F(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }

    public static boolean G() {
        Boolean boolValueOf = c;
        if (boolValueOf == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objInvoke = Process.class.getDeclaredMethod("isIsolated", new Class[0]).invoke(null, new Object[0]);
                    Object[] objArr = new Object[0];
                    if (objInvoke == null) {
                        throw new t80(yr2.s0("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objInvoke;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static Handler b(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static Handler c(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static hr2 d(int[] iArr, int[] iArr2) {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i : iArr) {
            try {
                builder.addCapability(i);
            } catch (IllegalArgumentException e) {
                ue2 ue2VarG = ue2.g();
                String str = hr2.b;
                String str2 = hr2.b;
                String str3 = "Ignoring adding capability '" + i + '\'';
                if (ue2VarG.b <= 5) {
                    a1.o(str2, str3, e);
                }
            }
        }
        int[] iArr3 = xb5.Y;
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = iArr3[i2];
            if (qe.n0(iArr, i3) < 0) {
                try {
                    builder.removeCapability(i3);
                } catch (IllegalArgumentException e2) {
                    ue2 ue2VarG2 = ue2.g();
                    String str4 = hr2.b;
                    String str5 = hr2.b;
                    String str6 = "Ignoring removing default capability '" + i3 + '\'';
                    if (ue2VarG2.b <= 5) {
                        a1.o(str5, str6, e2);
                    }
                }
            }
        }
        for (int i4 : iArr2) {
            builder.addTransportType(i4);
        }
        NetworkRequest networkRequestBuild = builder.build();
        networkRequestBuild.getClass();
        return new hr2(networkRequestBuild);
    }

    public static final DisplayCutout e(Display display) throws Exception {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
            return null;
        } catch (Exception e) {
            if (!(e instanceof ClassNotFoundException) && !(e instanceof NoSuchMethodException) && !(e instanceof NoSuchFieldException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException) && !(e instanceof InstantiationException)) {
                throw e;
            }
            ap.d.getClass();
            a1.m(zo.b, e);
            return null;
        }
    }

    public static String[] f(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static long g(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public static Executor h(Context context) {
        return context.getMainExecutor();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(5:45|14|39|15|16)|(2:46|17)|41|18) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String i() throws java.lang.Throwable {
        /*
            java.lang.String r0 = defpackage.u9.a
            if (r0 != 0) goto L76
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L11
            java.lang.String r0 = android.app.Application.getProcessName()
            defpackage.u9.a = r0
            return r0
        L11:
            int r0 = defpackage.u9.b
            if (r0 != 0) goto L1b
            int r0 = android.os.Process.myPid()
            defpackage.u9.b = r0
        L1b:
            java.lang.String r1 = "/cmdline"
            java.lang.String r2 = "/proc/"
            r3 = 0
            if (r0 > 0) goto L23
            goto L73
        L23:
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4 + 14
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r2)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L64
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L64
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            defpackage.tj4.i(r0)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            java.lang.String r3 = r0.trim()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
        L5b:
            r2.close()     // Catch: java.io.IOException -> L73
            goto L73
        L5f:
            r0 = move-exception
            r3 = r2
            goto L69
        L62:
            r0 = move-exception
            goto L69
        L64:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            throw r0     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
        L69:
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6e
        L6e:
            throw r0
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L73
            goto L5b
        L73:
            defpackage.u9.a = r3
            return r3
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u9.i():java.lang.String");
    }

    public static void j(JobParameters jobParameters) {
        jobParameters.getNetwork();
    }

    public static String k() {
        String processName = Application.getProcessName();
        processName.getClass();
        return processName;
    }

    public static int l(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String m(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static int n(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int o(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int p(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int q(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int r(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static PrecomputedText.Params s(AppCompatTextView appCompatTextView) {
        return appCompatTextView.getTextMetricsParams();
    }

    public static int t(Object obj) {
        return ((Icon) obj).getType();
    }

    public static Uri u(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static boolean v(NetworkRequest networkRequest, int i) {
        networkRequest.getClass();
        return networkRequest.hasCapability(i);
    }

    public static boolean w(NetworkRequest networkRequest, int i) {
        networkRequest.getClass();
        return networkRequest.hasTransport(i);
    }

    public static boolean x(Handler handler, m00 m00Var, long j) {
        return handler.postDelayed(m00Var, "retry_token", j);
    }

    public static int y(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int z(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }
}
