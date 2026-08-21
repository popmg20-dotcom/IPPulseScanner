package defpackage;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RemoteViews;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.receiver.appwidget.PrivateIPProvider;
import com.getsurfboard.ui.receiver.appwidget.WidgetRetryReceiver;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.p4;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xb5 {
    public static final int[] b = {0, 4, 1, 5};
    public static final int[] f = {6, 2, 7, 3};
    public static final int[] z = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] A = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    public static final int[] X = {0, 180, 270, 90};
    public static final int[] Y = {13, 15, 14};
    public static final String[] Z = {"ad_activeview", "ad_click", "ad_exposure", "ad_query", "ad_reward", "adunit_exposure", "app_clear_data", "app_exception", "app_remove", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "app_upgrade", "app_update", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "session_start_with_rollout", "user_engagement", "ad_impression", "screen_view", "ga_extra_parameter", "app_background", "firebase_campaign"};
    public static final String[] y0 = {"ad_impression"};
    public static final String[] z0 = {"_aa", "_ac", "_xa", "_aq", "_ar", "_xu", "_cd", "_ae", "_ui", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "_ug", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_ssr", "_e", "_ai", "_vs", "_ep", "_ab", "_cmp"};
    public static final String[] A0 = {"purchase", "refund", "add_payment_info", "add_shipping_info", "add_to_cart", "add_to_wishlist", "begin_checkout", "remove_from_cart", "select_item", "select_promotion", "view_cart", "view_item", "view_item_list", "view_promotion", "ecommerce_purchase", "purchase_refund", "set_checkout_option", "checkout_progress", "select_content", "view_search_results"};

    /* JADX WARN: Removed duplicated region for block: B:141:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0956  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int B(int r90, int r91) {
        /*
            Method dump skipped, instruction units count: 2580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xb5.B(int, int):int");
    }

    public static final boolean C(ComponentName componentName) {
        int[] appWidgetIds;
        componentName.getClass();
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(ContextUtilsKt.getContext());
            if (appWidgetManager == null || (appWidgetIds = appWidgetManager.getAppWidgetIds(componentName)) == null) {
                return false;
            }
            return !(appWidgetIds.length == 0);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object D(defpackage.zd4 r4, defpackage.em1 r5, java.lang.Throwable r6, defpackage.ie0 r7) {
        /*
            boolean r0 = r7 instanceof defpackage.lg1
            if (r0 == 0) goto L13
            r0 = r7
            lg1 r0 = (defpackage.lg1) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            lg1 r0 = new lg1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.X
            int r1 = r0.Y
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Throwable r6 = r0.A
            defpackage.n12.S(r7)     // Catch: java.lang.Throwable -> L27
            goto L40
        L27:
            r4 = move-exception
            goto L43
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L30:
            defpackage.n12.S(r7)
            r0.A = r6     // Catch: java.lang.Throwable -> L27
            r0.Y = r2     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r5.e(r4, r6, r0)     // Catch: java.lang.Throwable -> L27
            mf0 r5 = defpackage.mf0.b
            if (r4 != r5) goto L40
            return r5
        L40:
            xl4 r4 = defpackage.xl4.a
            return r4
        L43:
            if (r6 == 0) goto L4a
            if (r6 == r4) goto L4a
            defpackage.ek0.b(r4, r6)
        L4a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xb5.D(zd4, em1, java.lang.Throwable, ie0):java.lang.Object");
    }

    public static boolean E(byte b2) {
        return b2 > -65;
    }

    public static int F(String str) {
        if (str.charAt(0) != '#') {
            return Color.parseColor(str);
        }
        long j = Long.parseLong(str.substring(1), 16);
        if (str.length() == 7) {
            return (int) (4278190080L | j);
        }
        if (str.length() != 9) {
            xe.k("Unknown color");
            return 0;
        }
        int i = ((int) (j >> 24)) & DnsRecord.CLASS_ANY;
        int i2 = ((int) (j >> 16)) & DnsRecord.CLASS_ANY;
        return (((int) (j & 255)) << 24) | (i << 16) | (i2 << 8) | (((int) (j >> 8)) & DnsRecord.CLASS_ANY);
    }

    public static float G(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = 0.8f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static m04 H(final float f2) {
        Object objG = new fo4(Float.valueOf(f2), "n04", uo4.b, d7.z).B("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new am1() { // from class: l04
            @Override // defpackage.am1
            public final Object g(Object obj) {
                ((Float) obj).floatValue();
                float f3 = f2;
                double d = f3;
                boolean z2 = false;
                if (0.0d <= d && d <= 1.0d && !qe.a0(Float.valueOf(f3), new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)})) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        }).g();
        objG.getClass();
        float fFloatValue = ((Number) objG).floatValue();
        return new m04(fFloatValue, "ratio:" + fFloatValue);
    }

    public static final void I() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "PrivateIPProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "refreshWidgets() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("PrivateIPProvider", "refreshWidgets() called", null);
        }
        ei0 ei0Var = (ei0) cr2.b.d();
        if (ei0Var == null) {
            return;
        }
        ComponentName componentName = PrivateIPProvider.a;
        if (C(componentName)) {
            RemoteViews remoteViews = new RemoteViews(ContextUtilsKt.getContext().getPackageName(), R.layout.widget_private_ip);
            String str = "refreshWidgets() start update layout: " + ei0Var;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "PrivateIPProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("PrivateIPProvider", str, null);
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
            Intent action = new Intent(ContextUtilsKt.getContext(), (Class<?>) WidgetRetryReceiver.class).putExtra("type", "private_ip").setAction("com.getsurfboard.ACTION_WIDGET_RETRY");
            action.getClass();
            remoteViews.setOnClickPendingIntent(R.id.retry, PendingIntent.getBroadcast(ContextUtilsKt.getContext(), fj3.h, action, l72.a(134217728, true)));
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long J(io.github.rosemoe.sora.widget.CodeEditor r10, android.view.MotionEvent r11, int r12) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xb5.J(io.github.rosemoe.sora.widget.CodeEditor, android.view.MotionEvent, int):long");
    }

    public static final void K(z00 z00Var, ge0 ge0Var, boolean z2) {
        Object objV = z00Var.v();
        Throwable thG = z00Var.g(objV);
        Object tk3Var = thG != null ? new tk3(thG) : z00Var.h(objV);
        if (!z2) {
            ge0Var.d(tk3Var);
            return;
        }
        ge0Var.getClass();
        lv0 lv0Var = (lv0) ge0Var;
        ie0 ie0Var = lv0Var.X;
        Object obj = lv0Var.Z;
        cf0 cf0VarJ = ie0Var.j();
        Object objC = nd4.c(cf0VarJ, obj);
        bl4 bl4VarC0 = objC != nd4.a ? co4.c0(ie0Var, cf0VarJ, objC) : null;
        try {
            ie0Var.d(tk3Var);
            if (bl4VarC0 == null || bl4VarC0.n0()) {
                nd4.a(cf0VarJ, objC);
            }
        } catch (Throwable th) {
            if (bl4VarC0 == null || bl4VarC0.n0()) {
                nd4.a(cf0VarJ, objC);
            }
            throw th;
        }
    }

    public static final void L(Throwable th) {
        try {
            p4.c().x(th).getClass();
        } catch (Throwable unused) {
        }
    }

    public static int M(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 3) {
            return i != 4 ? 0 : 5;
        }
        return 4;
    }

    public static pb5 N() {
        String str;
        ClassLoader classLoader = xb5.class.getClassLoader();
        if (pb5.class.equals(pb5.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!pb5.class.getPackage().equals(xb5.class.getPackage())) {
                xe.k(pb5.class.getName());
                return null;
            }
            str = pb5.class.getPackage().getName() + ".BlazeGenerated" + pb5.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    try {
                        dw2.I(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InvocationTargetException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (InstantiationException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new xb5[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e5) {
                        Logger.getLogger(kb5.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(pb5.class.getSimpleName()), (Throwable) e5);
                    }
                }
                if (arrayList.size() == 1) {
                    return (pb5) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (pb5) pb5.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e6) {
                    zo2.q(e6);
                    return null;
                } catch (NoSuchMethodException e7) {
                    zo2.q(e7);
                    return null;
                } catch (InvocationTargetException e8) {
                    zo2.q(e8);
                    return null;
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static final void c(String str) {
        String str2;
        if (fy4.b) {
            str2 = str;
            Xlog.logWrite2(0L, 1, "CrashUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
        } else {
            str2 = str;
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("CrashUtils", str2, null);
        }
        try {
            p4.c().v(str2);
        } catch (Throwable unused) {
        }
    }

    public static final int d(io3 io3Var, String str) {
        io3Var.getClass();
        int columnCount = io3Var.getColumnCount();
        int i = 0;
        while (true) {
            if (i >= columnCount) {
                i = -1;
                break;
            }
            if (str.equals(io3Var.getColumnName(i))) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return i;
        }
        String str2 = "`" + str + '`';
        int columnCount2 = io3Var.getColumnCount();
        int i2 = 0;
        while (true) {
            if (i2 >= columnCount2) {
                i2 = -1;
                break;
            }
            if (str2.equals(io3Var.getColumnName(i2))) {
                break;
            }
            i2++;
        }
        if (i2 >= 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            int columnCount3 = io3Var.getColumnCount();
            String strConcat = ".".concat(str);
            String str3 = "." + str + '`';
            for (int i3 = 0; i3 < columnCount3; i3++) {
                String columnName = io3Var.getColumnName(i3);
                if (columnName.length() >= str.length() + 2 && (w44.d0(columnName, strConcat, false) || (columnName.charAt(0) == '`' && w44.d0(columnName, str3, false)))) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static String f(pz pzVar, Integer num, ArrayList arrayList) {
        if (num == null || !arrayList.contains("0") || !arrayList.contains("1")) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) pzVar.b("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return "1";
            }
            return null;
        }
        if (num.intValue() == 0 && ((Integer) pzVar.b("1").a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return "0";
        }
        return null;
    }

    public static ii g(en enVar) {
        long jI = 0;
        String strG = "";
        String strG2 = "";
        while (true) {
            int iH = enVar.h();
            if (iH == 0) {
                return new ii(strG, strG2, jI);
            }
            int i = iH >>> 3;
            int i2 = iH & 7;
            switch (i) {
                case 1:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 2:
                    en.b(i, 0, i2);
                    jI = enVar.i();
                    break;
                case 3:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 4:
                    en.b(i, 2, i2);
                    strG = enVar.g();
                    break;
                case 5:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 6:
                    en.b(i, 2, i2);
                    strG2 = enVar.g();
                    break;
                case 7:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 8:
                    en.b(i, 2, i2);
                    enVar.g();
                    break;
                default:
                    enVar.j(i2);
                    break;
            }
        }
    }

    public static final xf2 h(String str) {
        if (str != null) {
            if (w44.j0(str, "#!MANAGED-CONFIG ", false)) {
                List<String> listK0 = p44.K0(str, new char[]{' '}, 6);
                if (!listK0.isEmpty() && listK0.size() > 1) {
                    String str2 = null;
                    Long lValueOf = null;
                    Boolean boolValueOf = null;
                    for (String str3 : listK0) {
                        if (w44.j0(p44.U0(str3).toString(), "http", false)) {
                            str2 = str3;
                        }
                        if (w44.j0(p44.U0(str3).toString(), "interval", false)) {
                            List listL0 = p44.L0(str3, new String[]{"="}, 6);
                            if (listL0.size() > 1) {
                                lValueOf = Long.valueOf(Long.parseLong(p44.U0((String) listL0.get(1)).toString()));
                            }
                        }
                        if (w44.j0(p44.U0(str3).toString(), "strict", false)) {
                            List listL02 = p44.L0(str3, new String[]{"="}, 6);
                            if (listL02.size() > 1) {
                                boolValueOf = Boolean.valueOf(ji0.W(p44.U0((String) listL02.get(1)).toString()));
                            }
                        }
                    }
                    if (str2 != null) {
                        return new xf2(str2, boolValueOf != null ? boolValueOf.booleanValue() : false, lValueOf != null ? lValueOf.longValue() : 86400L);
                    }
                }
            }
        }
        return null;
    }

    public static wl3 i(en enVar) {
        while (true) {
            int iH = enVar.h();
            if (iH == 0) {
                return new wl3(23);
            }
            int i = iH >>> 3;
            int i2 = iH & 7;
            if (i == 1) {
                en.b(i, 2, i2);
                enVar.g();
            } else if (i == 2) {
                en.b(i, 2, i2);
                enVar.g();
            } else if (i == 3) {
                en.b(i, 0, i2);
                enVar.i();
            } else if (i == 4) {
                en.b(i, 2, i2);
                enVar.e();
            } else if (i != 6) {
                enVar.j(i2);
            } else {
                en.b(i, 2, i2);
                en enVarF = enVar.f();
                while (true) {
                    int iH2 = enVarF.h();
                    if (iH2 != 0) {
                        int i3 = iH2 >>> 3;
                        int i4 = iH2 & 7;
                        if (i3 != 1) {
                            enVarF.j(i4);
                        } else {
                            en.b(i3, 2, i4);
                            enVarF.e();
                        }
                    }
                }
            }
        }
    }

    public static void j(en enVar, HashMap map) {
        int i;
        int i2;
        en enVar2;
        int i3 = 0;
        cf4 cf4Var = null;
        int i4 = 0;
        while (true) {
            int iH = enVar.h();
            if (iH == 0) {
                if (cf4Var != null) {
                    map.put(Integer.valueOf(i4), cf4Var);
                    return;
                }
                return;
            }
            int i5 = iH >>> 3;
            int i6 = iH & 7;
            int i7 = 1;
            if (i5 == 1) {
                i = i3;
                en.b(i5, i, i6);
                i4 = (int) enVar.i();
            } else if (i5 != 2) {
                enVar.j(i6);
                i = i3;
            } else {
                en.b(i5, 2, i6);
                en enVarF = enVar.f();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                int i8 = i3;
                String strG = "";
                while (true) {
                    int iH2 = enVarF.h();
                    if (iH2 != 0) {
                        int i9 = iH2 >>> 3;
                        int i10 = iH2 & 7;
                        switch (i9) {
                            case 1:
                                i2 = i3;
                                enVar2 = enVarF;
                                en.b(i9, i2, i10);
                                i8 = (int) enVar2.i();
                                break;
                            case 2:
                                enVar2 = enVarF;
                                en.b(i9, 2, i10);
                                strG = enVar2.g();
                                i2 = 0;
                                break;
                            case 3:
                                en.b(i9, 2, i10);
                                en enVarF2 = enVarF.f();
                                String strG2 = "";
                                long jI = 0;
                                while (true) {
                                    int iH3 = enVarF2.h();
                                    if (iH3 == 0) {
                                        enVar2 = enVarF;
                                        arrayList.add(new zh3(strG2, jI));
                                        i2 = 0;
                                    } else {
                                        int i11 = iH3 >>> 3;
                                        en enVar3 = enVarF;
                                        int i12 = iH3 & 7;
                                        if (i11 == i7) {
                                            en.b(i11, 2, i12);
                                            strG2 = enVarF2.g();
                                        } else if (i11 != 2) {
                                            enVarF2.j(i12);
                                        } else {
                                            en.b(i11, 0, i12);
                                            jI = enVarF2.i();
                                        }
                                        enVarF = enVar3;
                                        i7 = 1;
                                    }
                                    break;
                                }
                                break;
                            case 4:
                                en.b(i9, 2, i10);
                                arrayList4.add(g(enVarF.f()));
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            case 5:
                                en.b(i9, 2, i10);
                                arrayList5.add(i(enVarF.f()));
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            case 6:
                                en.b(i9, i3, i10);
                                enVarF.i();
                                i2 = i3;
                                enVar2 = enVarF;
                                break;
                            case 7:
                                en.b(i9, 2, i10);
                                arrayList2.add(enVarF.g());
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            case 8:
                                en.b(i9, i3, i10);
                                enVarF.i();
                                i2 = i3;
                                enVar2 = enVarF;
                                break;
                            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                en.b(i9, 2, i10);
                                arrayList3.add(enVarF.g());
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            default:
                                enVarF.j(i10);
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                        }
                        i3 = i2;
                        enVarF = enVar2;
                        i7 = 1;
                    } else {
                        i = i3;
                        cf4Var = new cf4(i8, strG, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
                    }
                }
            }
            i3 = i;
        }
    }

    public static int[] k(cn cnVar, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (cnVar.b(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z2 = false;
        while (i < i3) {
            if (cnVar.b(i, i2) != z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (G(iArr2, iArr) < 0.42f) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i7 != length - 1 || G(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    public static xk3[] l(cn cnVar, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        boolean z2;
        int[] iArrK;
        xk3[] xk3VarArr = new xk3[4];
        int[] iArr2 = iArr;
        int[] iArr3 = new int[iArr2.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                i6 = i7;
                z2 = false;
                break;
            }
            int[] iArrK2 = k(cnVar, i4, i7, i2, iArr2, iArr3);
            if (iArrK2 != null) {
                int[] iArr4 = iArrK2;
                while (true) {
                    i6 = i7;
                    if (i6 <= 0 || (iArrK = k(cnVar, i4, i6 - 1, i2, iArr, iArr3)) == null) {
                        break;
                    }
                    iArr4 = iArrK;
                }
                float f2 = i6;
                xk3VarArr[0] = new xk3(iArr4[0], f2);
                xk3VarArr[1] = new xk3(iArr4[1], f2);
                z2 = true;
            } else {
                i7 += 5;
                iArr2 = iArr;
            }
        }
        int i8 = i6 + 1;
        if (z2) {
            int[] iArr5 = {(int) xk3VarArr[0].a, (int) xk3VarArr[1].a};
            int i9 = i8;
            int i10 = 0;
            while (i9 < i) {
                int[] iArrK3 = k(cnVar, iArr5[0], i9, i2, iArr, iArr3);
                if (iArrK3 != null && Math.abs(iArr5[0] - iArrK3[0]) < 5 && Math.abs(iArr5[1] - iArrK3[1]) < 5) {
                    iArr5 = iArrK3;
                    i10 = 0;
                } else {
                    if (i10 > 25) {
                        break;
                    }
                    i10++;
                }
                i9++;
            }
            i8 = i9 - (i10 + 1);
            float f3 = i8;
            xk3VarArr[2] = new xk3(iArr5[0], f3);
            xk3VarArr[3] = new xk3(iArr5[1], f3);
        }
        if (i8 - i6 < i5) {
            Arrays.fill(xk3VarArr, (Object) null);
        }
        return xk3VarArr;
    }

    public static final File n(Context context) {
        try {
            File file = new File(context.getExternalCacheDir(), "hprof");
            file.mkdirs();
            return file;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String o(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) "|");
            }
        }
        return sb.toString();
    }

    public static final String r() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtilsKt.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperator();
        }
        return null;
    }

    public static final e03 s() {
        Integer numM0;
        String strR = r();
        int iIntValue = (strR == null || (numM0 = w44.m0(strR)) == null) ? 0 : numM0.intValue();
        return new e03(Integer.valueOf(iIntValue / 100), Integer.valueOf(iIntValue % 100));
    }

    public static final Object t(rn2 rn2Var, u33 u33Var, Serializable serializable) {
        rn2Var.getClass();
        u33Var.getClass();
        Object objCopyOf = rn2Var.a.get(u33Var);
        if (objCopyOf instanceof byte[]) {
            byte[] bArr = (byte[]) objCopyOf;
            objCopyOf = Arrays.copyOf(bArr, bArr.length);
        }
        return objCopyOf == null ? serializable : objCopyOf;
    }

    public static ArrayList v(rw rwVar, b00 b00Var, ArrayList arrayList) throws c02 {
        String strF;
        try {
            ArrayList arrayList2 = new ArrayList();
            if (b00Var == null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add((String) it.next());
                }
            } else {
                try {
                    strF = f(rwVar.e, b00Var.b(), arrayList);
                } catch (IllegalStateException unused) {
                    strF = null;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!str.equals(strF)) {
                        arrayList3.add(rwVar.d(str));
                    }
                }
                Iterator it3 = b00Var.a(arrayList3).iterator();
                while (it3.hasNext()) {
                    arrayList2.add(((kz) it3.next()).d());
                }
            }
            return arrayList2;
        } catch (e00 e) {
            throw new c02(e);
        } catch (xx e2) {
            throw new c02(new e00(e2));
        }
    }

    public void A(go3 go3Var, Object obj) {
        if (obj == null) {
            return;
        }
        io3 io3VarD0 = go3Var.D0(e());
        try {
            b(io3VarD0, obj);
            io3VarD0.C0();
            vf2.e(io3VarD0, null);
            r25.C(go3Var);
        } finally {
        }
    }

    public abstract void b(io3 io3Var, Object obj);

    public abstract String e();

    public abstract Annotation m(Class cls);

    public abstract int p();

    public abstract String q();

    public abstract Class u();

    public abstract int w(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract nj4 x();

    public abstract int y();

    public abstract ViewPropertyAnimator z(View view, int i);
}
