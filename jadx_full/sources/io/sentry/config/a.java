package io.sentry.config;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Process;
import android.text.Layout;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ScrollingView;
import com.getsurfboard.R;
import com.tencent.mars.xlog.Xlog;
import defpackage.e03;
import defpackage.ha0;
import defpackage.m0;
import defpackage.n12;
import defpackage.p44;
import defpackage.xe;
import defpackage.z82;
import io.netty.handler.codec.http.HttpConstants;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.gestures.i;
import io.sentry.android.replay.util.o;
import io.sentry.android.replay.viewhierarchy.g;
import io.sentry.android.replay.viewhierarchy.h;
import io.sentry.m3;
import io.sentry.n2;
import io.sentry.protocol.d0;
import io.sentry.protocol.f;
import io.sentry.protocol.j0;
import io.sentry.protocol.r;
import io.sentry.protocol.u;
import io.sentry.protocol.w;
import io.sentry.t4;
import io.sentry.util.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import org.conscrypt.BuildConfig;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static String a(String str) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new BigInteger("10".concat(str), 16).toByteArray());
            byteBufferWrap.get();
            return String.format("%08x-%04x-%04x-%04x-%04x%08x", Integer.valueOf(byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN).getInt()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.order(ByteOrder.BIG_ENDIAN).getShort()), Short.valueOf(byteBufferWrap.getShort()), Integer.valueOf(byteBufferWrap.getInt()));
        } catch (NumberFormatException | BufferUnderflowException unused) {
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean b(t4 t4Var, String str, m3 m3Var, ILogger iLogger) {
        int i = 8;
        int i2 = 2;
        int i3 = 0;
        byte b = -1;
        switch (str.hashCode()) {
            case -1840434063:
                if (str.equals("debug_meta")) {
                    b = 0;
                }
                break;
            case -758770169:
                if (str.equals("server_name")) {
                    b = 1;
                }
                break;
            case -567312220:
                if (str.equals("contexts")) {
                    b = 2;
                }
                break;
            case -85904877:
                if (str.equals("environment")) {
                    b = 3;
                }
                break;
            case -51457840:
                if (str.equals("breadcrumbs")) {
                    b = 4;
                }
                break;
            case 113722:
                if (str.equals("sdk")) {
                    b = 5;
                }
                break;
            case 3083686:
                if (str.equals("dist")) {
                    b = 6;
                }
                break;
            case 3552281:
                if (str.equals("tags")) {
                    b = 7;
                }
                break;
            case 3599307:
                if (str.equals("user")) {
                    b = 8;
                }
                break;
            case 96965648:
                if (str.equals("extra")) {
                    b = 9;
                }
                break;
            case 278118624:
                if (str.equals("event_id")) {
                    b = 10;
                }
                break;
            case 1090594823:
                if (str.equals(BuildConfig.BUILD_TYPE)) {
                    b = 11;
                }
                break;
            case 1095692943:
                if (str.equals("request")) {
                    b = 12;
                }
                break;
            case 1874684019:
                if (str.equals("platform")) {
                    b = HttpConstants.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                t4Var.E0 = (f) m3Var.m0(iLogger, new io.sentry.clientreport.a(i));
                return true;
            case 1:
                t4Var.B0 = m3Var.G();
                return true;
            case 2:
                t4Var.f.l(io.sentry.clientreport.a.c(m3Var, iLogger));
                return true;
            case 3:
                t4Var.Z = m3Var.G();
                return true;
            case 4:
                t4Var.D0 = m3Var.y0(iLogger, new io.sentry.f(i3));
                return true;
            case 5:
                t4Var.z = (u) m3Var.m0(iLogger, new io.sentry.clientreport.a(21));
                return true;
            case 6:
                t4Var.C0 = m3Var.G();
                return true;
            case 7:
                t4Var.X = io.sentry.util.b.o((Map) m3Var.o0());
                return true;
            case 8:
                t4Var.z0 = (j0) m3Var.m0(iLogger, new d0(i2));
                return true;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                t4Var.F0 = io.sentry.util.b.o((Map) m3Var.o0());
                return true;
            case 10:
                t4Var.b = (w) m3Var.m0(iLogger, new io.sentry.clientreport.a(23));
                return true;
            case 11:
                t4Var.Y = m3Var.G();
                return true;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                t4Var.A = (r) m3Var.m0(iLogger, new io.sentry.clientreport.a(19));
                return true;
            case 13:
                t4Var.y0 = m3Var.G();
                return true;
            default:
                return false;
        }
    }

    public static BigDecimal c(double d) {
        return BigDecimal.valueOf(d).setScale(6, RoundingMode.DOWN);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static io.sentry.internal.gestures.b d(SentryAndroidOptions sentryAndroidOptions, View view, float f, float f2, io.sentry.internal.gestures.a aVar) {
        String strK;
        io.sentry.internal.gestures.b bVar;
        List<io.sentry.android.core.internal.gestures.a> gestureTargetLocators = sentryAndroidOptions.getGestureTargetLocators();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new i(view, f, f2));
        io.sentry.internal.gestures.b bVar2 = null;
        while (!arrayDeque.isEmpty()) {
            i iVar = (i) arrayDeque.poll();
            View view2 = iVar.a;
            float f3 = iVar.c;
            float f4 = iVar.b;
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (f4 >= 0.0f && f4 <= width && f3 >= 0.0f && f3 <= height) {
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int scrollX = viewGroup.getScrollX();
                    int scrollY = viewGroup.getScrollY();
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt != null) {
                            float left = (scrollX + f4) - childAt.getLeft();
                            float top = (scrollY + f3) - childAt.getTop();
                            Matrix matrix = childAt.getMatrix();
                            if (matrix != null && !matrix.isIdentity()) {
                                Matrix matrix2 = new Matrix();
                                if (matrix.invert(matrix2)) {
                                    float[] fArr = {left, top};
                                    matrix2.mapPoints(fArr);
                                    float f5 = fArr[0];
                                    top = fArr[1];
                                    left = f5;
                                }
                            }
                            arrayDeque.add(new i(childAt, left, top));
                        }
                    }
                }
                for (int i2 = 0; i2 < gestureTargetLocators.size(); i2++) {
                    io.sentry.android.core.internal.gestures.a aVar2 = gestureTargetLocators.get(i2);
                    aVar2.getClass();
                    io.sentry.internal.gestures.a aVar3 = io.sentry.internal.gestures.a.CLICKABLE;
                    if (aVar == aVar3 && view2.isClickable() && view2.getVisibility() == 0) {
                        String strK2 = k(view2);
                        if (strK2 != null) {
                            bVar = new io.sentry.internal.gestures.b(view2, g(view2), strK2);
                        }
                    } else if (aVar != io.sentry.internal.gestures.a.SCROLLABLE) {
                        bVar = null;
                    } else if (((!((Boolean) aVar2.a.a()).booleanValue() ? false : ScrollingView.class.isAssignableFrom(view2.getClass())) || AbsListView.class.isAssignableFrom(view2.getClass()) || ScrollView.class.isAssignableFrom(view2.getClass())) && view2.getVisibility() == 0 && (strK = k(view2)) != null) {
                        bVar = new io.sentry.internal.gestures.b(view2, g(view2), strK);
                    }
                    if (bVar != null) {
                        if (aVar == aVar3) {
                            bVar2 = bVar;
                        } else if (aVar == io.sentry.internal.gestures.a.SCROLLABLE) {
                            return bVar;
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h e(View view, h hVar, m0 m0Var) {
        boolean z;
        Drawable drawable;
        Bitmap bitmap;
        int extendedPaddingTop;
        m0Var.getClass();
        e03 e03VarA = o.a(view);
        boolean zBooleanValue = ((Boolean) e03VarA.b).booleanValue();
        Rect rect = (Rect) e03VarA.f;
        boolean z2 = true;
        if (zBooleanValue) {
            Object tag = view.getTag();
            String str = tag instanceof String ? (String) tag : null;
            if (str != null) {
                String lowerCase = str.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                if (p44.o0(lowerCase, "sentry-unmask", false)) {
                    m0Var.y();
                    z = false;
                } else {
                    if (!n12.c(view.getTag(R.id.sentry_privacy), "unmask")) {
                        Object tag2 = view.getTag();
                        String str2 = tag2 instanceof String ? (String) tag2 : null;
                        if (str2 != null) {
                            String lowerCase2 = str2.toLowerCase(Locale.ROOT);
                            lowerCase2.getClass();
                            if (p44.o0(lowerCase2, "sentry-mask", false)) {
                                m0Var.y();
                                z = true;
                                break;
                            }
                            if (!n12.c(view.getTag(R.id.sentry_privacy), "mask")) {
                                if (view.getParent() != null) {
                                    view.getParent().getClass();
                                }
                                Class<?> superclass = view.getClass();
                                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) m0Var.b;
                                while (true) {
                                    if (superclass == null) {
                                        CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) m0Var.a;
                                        for (Class<?> superclass2 = view.getClass(); superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                                            if (!copyOnWriteArraySet2.contains(superclass2.getName())) {
                                            }
                                        }
                                    } else {
                                        if (copyOnWriteArraySet.contains(superclass.getName())) {
                                            break;
                                        }
                                        superclass = superclass.getSuperclass();
                                    }
                                }
                            }
                            z = true;
                            break;
                        }
                    }
                    z = false;
                }
            }
        } else {
            z = false;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Layout layout = textView.getLayout();
            n2 n2Var = layout != null ? new n2(3, layout) : null;
            int currentTextColor = textView.getCurrentTextColor() | (-16777216);
            int totalPaddingLeft = textView.getTotalPaddingLeft();
            try {
                extendedPaddingTop = textView.getTotalPaddingTop();
            } catch (NullPointerException unused) {
                extendedPaddingTop = textView.getExtendedPaddingTop();
            }
            textView.getX();
            textView.getY();
            return new g(n2Var, Integer.valueOf(currentTextColor), totalPaddingLeft, extendedPaddingTop, textView.getWidth(), textView.getHeight(), textView.getElevation() + (hVar != null ? hVar.c : 0.0f), hVar, z, zBooleanValue, rect);
        }
        if (!(view instanceof ImageView)) {
            if (!(view instanceof SurfaceView)) {
                view.getX();
                view.getY();
                return new io.sentry.android.replay.viewhierarchy.d(view.getWidth(), view.getHeight(), view.getElevation() + (hVar != null ? hVar.c : 0.0f), hVar, z, zBooleanValue, rect);
            }
            WeakReference weakReference = new WeakReference(view);
            SurfaceView surfaceView = (SurfaceView) view;
            surfaceView.getX();
            surfaceView.getY();
            return new io.sentry.android.replay.viewhierarchy.f(weakReference, surfaceView.getWidth(), surfaceView.getHeight(), surfaceView.getElevation() + (hVar != null ? hVar.c : 0.0f), hVar, z, zBooleanValue, rect);
        }
        ImageView imageView = (ImageView) view;
        imageView.getX();
        imageView.getY();
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        float elevation = imageView.getElevation() + (hVar != null ? hVar.c : 0.0f);
        if (!z || (drawable = imageView.getDrawable()) == null) {
            z2 = false;
        } else if ((drawable instanceof InsetDrawable ? true : drawable instanceof ColorDrawable ? true : drawable instanceof VectorDrawable ? true : drawable instanceof GradientDrawable) || ((drawable instanceof BitmapDrawable) && ((bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled() || bitmap.getHeight() <= 10 || bitmap.getWidth() <= 10))) {
        }
        return new io.sentry.android.replay.viewhierarchy.e(width, height, elevation, hVar, z2, zBooleanValue, rect);
    }

    public static String f() {
        byte[] bArr = new byte[16];
        n.a().b(bArr);
        byte b = (byte) (bArr[6] & 15);
        bArr[6] = b;
        bArr[6] = (byte) (b | 64);
        byte b2 = (byte) (bArr[8] & 63);
        bArr[8] = b2;
        bArr[8] = (byte) (b2 | 128);
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 << 8) | ((long) (bArr[i] & 255));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return io.sentry.util.r.b(new UUID(j2, j));
    }

    public static String g(Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName != null ? canonicalName : obj.getClass().getSimpleName();
    }

    public static Date h(String str) {
        try {
            return new Date(io.sentry.vendor.a.i(str));
        } catch (IllegalArgumentException unused) {
            xe.k(ha0.n("timestamp is not ISO format ", str));
            return null;
        }
    }

    public static Date i(String str) {
        try {
            return new Date(new BigDecimal(str).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        } catch (NumberFormatException unused) {
            xe.k(ha0.n("timestamp is not millis format ", str));
            return null;
        }
    }

    public static final Window j(View view) throws IllegalAccessException {
        Field field;
        view.getClass();
        z82 z82Var = io.sentry.android.replay.d0.a;
        View rootView = view.getRootView();
        rootView.getClass();
        Class cls = (Class) io.sentry.android.replay.d0.a.getValue();
        if (cls == null || !cls.isInstance(rootView) || (field = (Field) io.sentry.android.replay.d0.b.getValue()) == null) {
            return null;
        }
        Object obj = field.get(rootView);
        obj.getClass();
        return (Window) obj;
    }

    public static String k(View view) {
        int id = view.getId();
        if (id != -1 && (((-16777216) & id) != 0 || (16777215 & id) == 0)) {
            Resources resources = view.getContext().getResources();
            if (resources == null) {
                return "";
            }
            try {
                return resources.getResourceEntryName(id);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean m(Context context) {
        io.sentry.util.b.r(context, "The application context is required.");
        return context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0;
    }

    public static byte[] o(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void p(t4 t4Var, io.sentry.internal.debugmeta.c cVar, ILogger iLogger) {
        if (t4Var.b != null) {
            cVar.p("event_id");
            cVar.v(iLogger, t4Var.b);
        }
        cVar.p("contexts");
        cVar.v(iLogger, t4Var.f);
        if (t4Var.z != null) {
            cVar.p("sdk");
            cVar.v(iLogger, t4Var.z);
        }
        if (t4Var.A != null) {
            cVar.p("request");
            cVar.v(iLogger, t4Var.A);
        }
        AbstractMap abstractMap = t4Var.X;
        if (abstractMap != null && !abstractMap.isEmpty()) {
            cVar.p("tags");
            cVar.v(iLogger, t4Var.X);
        }
        if (t4Var.Y != null) {
            cVar.p(BuildConfig.BUILD_TYPE);
            cVar.y(t4Var.Y);
        }
        if (t4Var.Z != null) {
            cVar.p("environment");
            cVar.y(t4Var.Z);
        }
        if (t4Var.y0 != null) {
            cVar.p("platform");
            cVar.y(t4Var.y0);
        }
        if (t4Var.z0 != null) {
            cVar.p("user");
            cVar.v(iLogger, t4Var.z0);
        }
        if (t4Var.B0 != null) {
            cVar.p("server_name");
            cVar.y(t4Var.B0);
        }
        if (t4Var.C0 != null) {
            cVar.p("dist");
            cVar.y(t4Var.C0);
        }
        List list = t4Var.D0;
        if (list != null && !list.isEmpty()) {
            cVar.p("breadcrumbs");
            cVar.v(iLogger, t4Var.D0);
        }
        if (t4Var.E0 != null) {
            cVar.p("debug_meta");
            cVar.v(iLogger, t4Var.E0);
        }
        AbstractMap abstractMap2 = t4Var.F0;
        if (abstractMap2 == null || abstractMap2.isEmpty()) {
            return;
        }
        cVar.p("extra");
        cVar.v(iLogger, t4Var.F0);
    }

    public abstract int l();

    public abstract boolean n();
}
