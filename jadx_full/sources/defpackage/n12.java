package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.getsurfboard.R;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n12 {
    public static ExecutorService b;
    public static final Object a = new Object();
    public static final String[] c = {HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, "text/*"};

    public static int A(View view, int i) {
        Context context = view.getContext();
        Context context2 = view.getContext();
        String canonicalName = view.getClass().getCanonicalName();
        TypedValue typedValueA = ek0.A(context2, i);
        if (typedValueA != null) {
            int i2 = typedValueA.resourceId;
            return i2 != 0 ? context.getColor(i2) : typedValueA.data;
        }
        zo2.p("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{canonicalName, context2.getResources().getResourceName(i)});
        return 0;
    }

    public static float B(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return j01.b(edgeEffect);
        }
        return 0.0f;
    }

    public static Object C(Future future) {
        r25.j("Future was expected to be done, " + future, future.isDone());
        return E(future);
    }

    public static Object E(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static zy1 F(Object obj) {
        return obj == null ? zy1.z : new zy1(0, obj);
    }

    public static boolean G(int i) {
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = u70.a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        if (dArr.length != 3) {
            xe.k("outXyz must have a length of 3.");
            return false;
        }
        double d = ((double) iRed) / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = ((double) iGreen) / 255.0d;
        double dPow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = ((double) iBlue) / 255.0d;
        double dPow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        double d4 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[1] = d4;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
        return d4 / 100.0d > 0.5d;
    }

    public static boolean H(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static int I(int i, float f, int i2) {
        return u70.c(u70.e(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void J(v03[] v03VarArr, Path path) {
        int i;
        float[] fArr;
        int i2;
        v03 v03Var;
        int i3;
        char c2;
        float f;
        float f2;
        v03 v03Var2;
        boolean z;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        v03[] v03VarArr2 = v03VarArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = v03VarArr2.length;
        int i4 = 0;
        int i5 = 0;
        char c3 = 'm';
        while (i5 < length) {
            v03 v03Var3 = v03VarArr2[i5];
            char c4 = v03Var3.a;
            float[] fArr3 = v03Var3.b;
            float f11 = fArr2[i4];
            float f12 = fArr2[1];
            float f13 = fArr2[2];
            float f14 = fArr2[3];
            float f15 = fArr2[4];
            int i6 = i4;
            float f16 = fArr2[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f15, f16);
                    f11 = f15;
                    f13 = f11;
                    f12 = f16;
                    f14 = f12;
                default:
                    i = 2;
                    break;
            }
            float f17 = f15;
            float f18 = f16;
            float f19 = f11;
            float f20 = f12;
            int i7 = i6;
            while (i7 < fArr3.length) {
                if (c4 == 'A') {
                    fArr = fArr3;
                    i2 = i7;
                    v03Var = v03Var3;
                    float f21 = f19;
                    float f22 = f20;
                    i3 = i5;
                    c2 = c4;
                    int i8 = i2 + 5;
                    int i9 = i2 + 6;
                    v03.a(path, f21, f22, fArr[i8], fArr[i9], fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3] != 0.0f ? 1 : i6, fArr[i2 + 4] != 0.0f ? 1 : i6);
                    f13 = fArr[i8];
                    f = fArr[i9];
                    f14 = f;
                    f2 = f13;
                } else if (c4 == 'C') {
                    fArr = fArr3;
                    i2 = i7;
                    i3 = i5;
                    v03Var = v03Var3;
                    c2 = c4;
                    int i10 = i2 + 2;
                    int i11 = i2 + 3;
                    int i12 = i2 + 4;
                    int i13 = i2 + 5;
                    path2.cubicTo(fArr[i2], fArr[i2 + 1], fArr[i10], fArr[i11], fArr[i12], fArr[i13]);
                    float f23 = fArr[i12];
                    float f24 = fArr[i13];
                    f13 = fArr[i10];
                    f14 = fArr[i11];
                    f = f24;
                    f2 = f23;
                } else if (c4 == 'H') {
                    fArr = fArr3;
                    i2 = i7;
                    v03Var = v03Var3;
                    c2 = c4;
                    f = f20;
                    i3 = i5;
                    path2.lineTo(fArr[i2], f);
                    f2 = fArr[i2];
                } else if (c4 == 'Q') {
                    fArr = fArr3;
                    i2 = i7;
                    i3 = i5;
                    v03Var = v03Var3;
                    c2 = c4;
                    int i14 = i2 + 1;
                    int i15 = i2 + 2;
                    int i16 = i2 + 3;
                    path2.quadTo(fArr[i2], fArr[i14], fArr[i15], fArr[i16]);
                    float f25 = fArr[i2];
                    float f26 = fArr[i14];
                    float f27 = fArr[i15];
                    float f28 = fArr[i16];
                    f13 = f25;
                    f14 = f26;
                    f2 = f27;
                    f = f28;
                } else if (c4 == 'V') {
                    fArr = fArr3;
                    i2 = i7;
                    i3 = i5;
                    v03Var = v03Var3;
                    f2 = f19;
                    c2 = c4;
                    path2.lineTo(f2, fArr[i2]);
                    f = fArr[i2];
                } else if (c4 != 'a') {
                    if (c4 == 'c') {
                        fArr = fArr3;
                        i2 = i7;
                        int i17 = i2 + 2;
                        int i18 = i2 + 3;
                        int i19 = i2 + 4;
                        int i20 = i2 + 5;
                        path2.rCubicTo(fArr[i2], fArr[i2 + 1], fArr[i17], fArr[i18], fArr[i19], fArr[i20]);
                        float f29 = fArr[i17] + f19;
                        float f30 = fArr[i18] + f20;
                        f19 += fArr[i19];
                        f20 += fArr[i20];
                        f13 = f29;
                        f14 = f30;
                    } else if (c4 != 'h') {
                        if (c4 != 'q') {
                            if (c4 != 'v') {
                                if (c4 == 'L') {
                                    fArr = fArr3;
                                    i2 = i7;
                                    int i21 = i2 + 1;
                                    path2.lineTo(fArr[i2], fArr[i21]);
                                    f2 = fArr[i2];
                                    f = fArr[i21];
                                } else if (c4 == 'M') {
                                    fArr = fArr3;
                                    i2 = i7;
                                    f2 = fArr[i2];
                                    f = fArr[i2 + 1];
                                    if (i2 > 0) {
                                        path2.lineTo(f2, f);
                                    } else {
                                        path2.moveTo(f2, f);
                                        f17 = f2;
                                        f18 = f;
                                    }
                                } else if (c4 != 'S') {
                                    if (c4 == 'T') {
                                        fArr = fArr3;
                                        i2 = i7;
                                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                            f19 = (f19 * 2.0f) - f13;
                                            f20 = (f20 * 2.0f) - f14;
                                        }
                                        int i22 = i2 + 1;
                                        path2.quadTo(f19, f20, fArr[i2], fArr[i22]);
                                        f2 = fArr[i2];
                                        f = fArr[i22];
                                        v03Var = v03Var3;
                                        f13 = f19;
                                        f14 = f20;
                                    } else if (c4 == 'l') {
                                        fArr = fArr3;
                                        i2 = i7;
                                        int i23 = i2 + 1;
                                        path2.rLineTo(fArr[i2], fArr[i23]);
                                        f19 += fArr[i2];
                                        f6 = fArr[i23];
                                    } else if (c4 == 'm') {
                                        fArr = fArr3;
                                        i2 = i7;
                                        float f31 = fArr[i2];
                                        f19 += f31;
                                        float f32 = fArr[i2 + 1];
                                        f20 += f32;
                                        if (i2 > 0) {
                                            path2.rLineTo(f31, f32);
                                        } else {
                                            path2.rMoveTo(f31, f32);
                                            v03Var = v03Var3;
                                            f2 = f19;
                                            f17 = f2;
                                            f = f20;
                                            f18 = f;
                                        }
                                    } else if (c4 != 's') {
                                        if (c4 != 't') {
                                            fArr = fArr3;
                                            i2 = i7;
                                            v03Var = v03Var3;
                                            f2 = f19;
                                        } else {
                                            if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                                f9 = f19 - f13;
                                                f10 = f20 - f14;
                                            } else {
                                                f10 = 0.0f;
                                                f9 = 0.0f;
                                            }
                                            int i24 = i7 + 1;
                                            path2.rQuadTo(f9, f10, fArr3[i7], fArr3[i24]);
                                            float f33 = f9 + f19;
                                            float f34 = f10 + f20;
                                            float f35 = f19 + fArr3[i7];
                                            f20 += fArr3[i24];
                                            f14 = f34;
                                            fArr = fArr3;
                                            i2 = i7;
                                            v03Var = v03Var3;
                                            f2 = f35;
                                            f13 = f33;
                                        }
                                        f = f20;
                                    } else {
                                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                            f7 = f20 - f14;
                                            f8 = f19 - f13;
                                        } else {
                                            f8 = 0.0f;
                                            f7 = 0.0f;
                                        }
                                        int i25 = i7;
                                        int i26 = i25 + 1;
                                        int i27 = i25 + 2;
                                        int i28 = i25 + 3;
                                        fArr = fArr3;
                                        i2 = i25;
                                        path2.rCubicTo(f8, f7, fArr3[i25], fArr3[i26], fArr3[i27], fArr3[i28]);
                                        f3 = fArr[i2] + f19;
                                        f4 = fArr[i26] + f20;
                                        f19 += fArr[i27];
                                        f5 = fArr[i28];
                                    }
                                    i3 = i5;
                                    c2 = c4;
                                } else {
                                    fArr = fArr3;
                                    i2 = i7;
                                    if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                        f19 = (f19 * 2.0f) - f13;
                                        f20 = (f20 * 2.0f) - f14;
                                    }
                                    float f36 = f19;
                                    float f37 = f20;
                                    int i29 = i2 + 1;
                                    int i30 = i2 + 2;
                                    int i31 = i2 + 3;
                                    path2.cubicTo(f36, f37, fArr[i2], fArr[i29], fArr[i30], fArr[i31]);
                                    f13 = fArr[i2];
                                    f14 = fArr[i29];
                                    f2 = fArr[i30];
                                    f = fArr[i31];
                                }
                                i3 = i5;
                                v03Var = v03Var3;
                                c2 = c4;
                            } else {
                                fArr = fArr3;
                                i2 = i7;
                                path2.rLineTo(0.0f, fArr[i2]);
                                f6 = fArr[i2];
                            }
                            f20 += f6;
                        } else {
                            fArr = fArr3;
                            i2 = i7;
                            int i32 = i2 + 1;
                            int i33 = i2 + 2;
                            int i34 = i2 + 3;
                            path2.rQuadTo(fArr[i2], fArr[i32], fArr[i33], fArr[i34]);
                            f3 = fArr[i2] + f19;
                            f4 = fArr[i32] + f20;
                            f19 += fArr[i33];
                            f5 = fArr[i34];
                        }
                        f20 += f5;
                        f13 = f3;
                        f14 = f4;
                    } else {
                        fArr = fArr3;
                        i2 = i7;
                        path2.rLineTo(fArr[i2], 0.0f);
                        f19 += fArr[i2];
                    }
                    v03Var = v03Var3;
                    f2 = f19;
                    f = f20;
                    i3 = i5;
                    c2 = c4;
                } else {
                    fArr = fArr3;
                    i2 = i7;
                    int i35 = i2 + 5;
                    float f38 = fArr[i35] + f19;
                    int i36 = i2 + 6;
                    float f39 = fArr[i36] + f20;
                    float f40 = fArr[i2];
                    float f41 = fArr[i2 + 1];
                    float f42 = fArr[i2 + 2];
                    if (fArr[i2 + 3] != 0.0f) {
                        v03Var2 = v03Var3;
                        z = 1;
                    } else {
                        v03Var2 = v03Var3;
                        z = i6;
                    }
                    v03Var = v03Var2;
                    float f43 = f19;
                    c2 = c4;
                    float f44 = f20;
                    i3 = i5;
                    v03.a(path, f43, f44, f38, f39, f40, f41, f42, z, fArr[i2 + 4] != 0.0f ? 1 : i6);
                    f2 = f43 + fArr[i35];
                    f = f44 + fArr[i36];
                    f13 = f2;
                    f14 = f;
                }
                i7 = i2 + i;
                path2 = path;
                v03Var3 = v03Var;
                c4 = c2;
                i5 = i3;
                f19 = f2;
                f20 = f;
                c3 = c4;
                fArr3 = fArr;
            }
            fArr2[i6] = f19;
            fArr2[1] = f20;
            fArr2[2] = f13;
            fArr2[3] = f14;
            fArr2[4] = f17;
            fArr2[5] = f18;
            c3 = v03Var3.a;
            i5++;
            v03VarArr2 = v03VarArr;
            path2 = path;
            i4 = i6;
        }
    }

    public static nc2 K(nc2 nc2Var) {
        nc2Var.getClass();
        return nc2Var.isDone() ? nc2Var : fx3.m(new rm1(nc2Var, 0));
    }

    public static float L(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return j01.c(edgeEffect, f, f2);
        }
        edgeEffect.onPull(f, f2);
        return f;
    }

    public static Date M(String str, String... strArr) throws ParseException {
        Locale locale = Locale.US;
        TimeZone timeZone = TimeZone.getDefault();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        calendar.setLenient(true);
        for (String str2 : strArr) {
            qb1 qb1Var = new qb1(str2, timeZone, locale);
            calendar.clear();
            try {
                if (qb1Var.b(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                    return calendar.getTime();
                }
            } catch (IllegalArgumentException unused) {
            }
            parsePosition.setIndex(0);
        }
        throw new ParseException("Unable to parse the date: ".concat(str), -1);
    }

    public static void N(nc2 nc2Var, vv vvVar) {
        O(true, nc2Var, vvVar, yu0.a());
    }

    public static void O(boolean z, nc2 nc2Var, vv vvVar, yu0 yu0Var) {
        nc2Var.getClass();
        vvVar.getClass();
        yu0Var.getClass();
        nc2Var.a(new um1(0, nc2Var, new en0(vvVar, 1)), yu0Var);
        if (z) {
            vvVar.a(new f33(13, nc2Var), yu0.a());
        }
    }

    public static void P(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static final int R(ur3 ur3Var, int i) {
        int i2;
        int[] iArr = ur3Var.Y;
        int i3 = i + 1;
        int length = ur3Var.X.length - 1;
        int i4 = 0;
        while (true) {
            if (i4 <= length) {
                i2 = (i4 + length) >>> 1;
                int i5 = iArr[i2];
                if (i5 >= i3) {
                    if (i5 <= i3) {
                        break;
                    }
                    length = i2 - 1;
                } else {
                    i4 = i2 + 1;
                }
            } else {
                i2 = (-i4) - 1;
                break;
            }
        }
        return i2 >= 0 ? i2 : ~i2;
    }

    public static final void S(Object obj) {
        if (obj instanceof tk3) {
            throw ((tk3) obj).b;
        }
    }

    public static void T(String str) {
        t80 t80Var = new t80(ha0.o("lateinit property ", str, " has not been initialized"));
        P(t80Var, n12.class.getName());
        throw t80Var;
    }

    public static final e03 U(Object obj, Object obj2) {
        return new e03(obj, obj2);
    }

    public static void V(List list, StringBuilder sb) {
        z02 z02VarZ = gb4.Z(2, gb4.d0(0, list.size()));
        int i = z02VarZ.b;
        int i2 = z02VarZ.f;
        int i3 = z02VarZ.z;
        if ((i3 <= 0 || i > i2) && (i3 >= 0 || i2 > i)) {
            return;
        }
        while (true) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
            if (i == i2) {
                return;
            } else {
                i += i3;
            }
        }
    }

    public static r20 W(nc2 nc2Var, gf gfVar, Executor executor) {
        r20 r20Var = new r20(gfVar, nc2Var);
        nc2Var.a(r20Var, executor);
        return r20Var;
    }

    public static Throwable X(Throwable th) {
        return th instanceof InvocationTargetException ? X(((InvocationTargetException) th).getTargetException()) : th;
    }

    public static String Y(Context context, String str) {
        tj4.i(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str)) {
            str = ye.T(context);
        }
        int identifier = resources.getIdentifier("google_app_id", "string", str);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String Z(String str, String[] strArr, String[] strArr2) {
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static void a(StringBuilder sb, Object obj, am1 am1Var) {
        if (am1Var != null) {
            sb.append((CharSequence) am1Var.g(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x06e1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(kc0 kc0Var, gb2 gb2Var, ArrayList arrayList, int i) {
        int i2;
        p20[] p20VarArr;
        int i3;
        int i4;
        lb0[] lb0VarArr;
        boolean z;
        jc0 jc0Var;
        float f;
        boolean z2;
        boolean z3;
        int i5;
        jc0 jc0Var2;
        gb2 gb2Var2;
        jc0 jc0Var3;
        jz3 jz3Var;
        lb0 lb0Var;
        jz3 jz3Var2;
        jc0 jc0Var4;
        int i6;
        lb0[] lb0VarArr2;
        lb0 lb0Var2;
        jz3 jz3Var3;
        jc0 jc0Var5;
        jc0 jc0Var6;
        int i7;
        jz3 jz3Var4;
        int size;
        ArrayList arrayList2;
        int i8;
        jc0 jc0Var7;
        int i9;
        float f2;
        int i10;
        float f3;
        jc0 jc0Var8;
        int i11;
        int i12;
        int i13;
        jc0 jc0Var9;
        kc0 kc0Var2 = kc0Var;
        gb2 gb2Var3 = gb2Var;
        ArrayList arrayList3 = arrayList;
        if (i == 0) {
            i2 = kc0Var2.y0;
            p20VarArr = kc0Var2.B0;
            i3 = 0;
        } else {
            i2 = kc0Var2.z0;
            p20VarArr = kc0Var2.A0;
            i3 = 2;
        }
        int i14 = i2;
        p20[] p20VarArr2 = p20VarArr;
        int i15 = 0;
        while (i15 < i14) {
            p20 p20Var = p20VarArr2[i15];
            boolean z4 = p20Var.q;
            jc0 jc0Var10 = p20Var.a;
            lb0[] lb0VarArr3 = jc0Var10.P;
            int i16 = 3;
            int i17 = 8;
            float f4 = 0.0f;
            if (z4) {
                i4 = i15;
            } else {
                int i18 = p20Var.l;
                int i19 = i18 * 2;
                jc0 jc0Var11 = jc0Var10;
                jc0 jc0Var12 = jc0Var11;
                boolean z5 = false;
                while (!z5) {
                    p20Var.i++;
                    jc0[] jc0VarArr = jc0Var11.l0;
                    lb0[] lb0VarArr4 = jc0Var11.P;
                    jc0VarArr[i18] = null;
                    jc0Var11.k0[i18] = null;
                    if (jc0Var11.f0 != i17) {
                        jc0Var11.h(i18);
                        lb0VarArr4[i19].d();
                        int i20 = i19 + 1;
                        lb0VarArr4[i20].d();
                        lb0VarArr4[i19].d();
                        lb0VarArr4[i20].d();
                        if (p20Var.b == null) {
                            p20Var.b = jc0Var11;
                        }
                        p20Var.d = jc0Var11;
                        int i21 = jc0Var11.o0[i18];
                        if (i21 == i16) {
                            int i22 = jc0Var11.t[i18];
                            if (i22 == 0 || i22 == i16 || i22 == 2) {
                                p20Var.j++;
                                float f5 = jc0Var11.j0[i18];
                                if (f5 > 0.0f) {
                                    i12 = i15;
                                    p20Var.k += f5;
                                } else {
                                    i12 = i15;
                                }
                                i13 = i18;
                                if (jc0Var11.f0 != 8 && i21 == 3 && (i22 == 0 || i22 == 3)) {
                                    if (f5 < 0.0f) {
                                        p20Var.n = true;
                                    } else {
                                        p20Var.o = true;
                                    }
                                    ArrayList arrayList4 = p20Var.h;
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        p20Var.h = arrayList4;
                                    }
                                    arrayList4.add(jc0Var11);
                                }
                                if (p20Var.f == null) {
                                    p20Var.f = jc0Var11;
                                }
                                jc0 jc0Var13 = p20Var.g;
                                if (jc0Var13 != null) {
                                    jc0Var13.k0[i13] = jc0Var11;
                                }
                                p20Var.g = jc0Var11;
                            } else {
                                i12 = i15;
                                i13 = i18;
                            }
                            if (i13 == 0) {
                                if (jc0Var11.r == 0 && jc0Var11.u == 0) {
                                    int i23 = jc0Var11.v;
                                }
                            } else if (jc0Var11.s == 0 && jc0Var11.x == 0) {
                                int i24 = jc0Var11.y;
                            }
                        } else {
                            i12 = i15;
                            i13 = i18;
                        }
                    }
                    jc0 jc0Var14 = jc0Var12;
                    if (jc0Var14 != jc0Var11) {
                        jc0Var14.l0[i13] = jc0Var11;
                    }
                    lb0 lb0Var3 = lb0VarArr4[i19 + 1].f;
                    if (lb0Var3 != null) {
                        jc0Var9 = lb0Var3.d;
                        lb0 lb0Var4 = jc0Var9.P[i19].f;
                        if (lb0Var4 == null || lb0Var4.d != jc0Var11) {
                            jc0Var9 = null;
                        }
                    }
                    if (jc0Var9 == null) {
                        jc0Var9 = jc0Var11;
                        z5 = true;
                    }
                    jc0Var12 = jc0Var11;
                    i18 = i13;
                    i16 = 3;
                    i17 = 8;
                    jc0Var11 = jc0Var9;
                    i15 = i12;
                }
                i4 = i15;
                int i25 = i18;
                jc0 jc0Var15 = p20Var.b;
                if (jc0Var15 != null) {
                    jc0Var15.P[i19].d();
                }
                jc0 jc0Var16 = p20Var.d;
                if (jc0Var16 != null) {
                    jc0Var16.P[i19 + 1].d();
                }
                p20Var.c = jc0Var11;
                if (i25 == 0 && p20Var.m) {
                    p20Var.e = jc0Var11;
                } else {
                    p20Var.e = jc0Var10;
                }
                p20Var.p = p20Var.o && p20Var.n;
            }
            p20Var.q = true;
            if (arrayList3 == null || arrayList3.contains(jc0Var10)) {
                jc0 jc0Var17 = p20Var.c;
                jc0 jc0Var18 = p20Var.b;
                jc0 jc0Var19 = p20Var.d;
                jc0 jc0Var20 = p20Var.e;
                float f6 = p20Var.k;
                int[] iArr = kc0Var2.o0;
                lb0[] lb0VarArr5 = kc0Var2.P;
                boolean z6 = iArr[i] == 2;
                if (i == 0) {
                    int i26 = jc0Var20.h0;
                    boolean z7 = i26 == 0;
                    lb0VarArr = lb0VarArr3;
                    boolean z8 = i26 == 1;
                    z = i26 == 2;
                    jc0Var = jc0Var10;
                    f = f6;
                    z3 = z8;
                    z2 = z7;
                } else {
                    lb0VarArr = lb0VarArr3;
                    int i27 = jc0Var20.i0;
                    boolean z9 = i27 == 0;
                    boolean z10 = i27 == 1;
                    z = i27 == 2;
                    jc0Var = jc0Var10;
                    f = f6;
                    z2 = z9;
                    z3 = z10;
                }
                boolean z11 = false;
                while (!z11) {
                    lb0[] lb0VarArr6 = jc0Var.P;
                    int[] iArr2 = jc0Var.o0;
                    lb0 lb0Var5 = lb0VarArr6[i3];
                    int i28 = z ? 1 : 4;
                    int iD = lb0Var5.d();
                    boolean z12 = z6;
                    boolean z13 = z;
                    boolean z14 = iArr2[i] == 3 && jc0Var.t[i] == 0;
                    lb0 lb0Var6 = lb0Var5.f;
                    if (lb0Var6 != null && jc0Var != jc0Var10) {
                        iD = lb0Var6.d() + iD;
                    }
                    int i29 = iD;
                    if (z13 && jc0Var != jc0Var10 && jc0Var != jc0Var18) {
                        i28 = 8;
                    }
                    jc0 jc0Var21 = jc0Var10;
                    lb0 lb0Var7 = lb0Var5.f;
                    if (lb0Var7 != null) {
                        boolean z15 = z14;
                        jz3 jz3Var5 = lb0Var5.i;
                        jz3 jz3Var6 = lb0Var7.i;
                        if (jc0Var == jc0Var18) {
                            gb2Var3.f(jz3Var5, jz3Var6, i29, 6);
                        } else {
                            gb2Var3.f(jz3Var5, jz3Var6, i29, 8);
                        }
                        if (z15 && !z13) {
                            i28 = 5;
                        }
                        gb2Var3.e(lb0Var5.i, lb0Var5.f.i, i29, (jc0Var == jc0Var18 && z13 && jc0Var.R[i]) ? 5 : i28);
                    }
                    if (z12) {
                        if (jc0Var.f0 == 8 || iArr2[i] != 3) {
                            i11 = 0;
                        } else {
                            i11 = 0;
                            gb2Var3.f(lb0VarArr6[i3 + 1].i, lb0VarArr6[i3].i, 0, 5);
                        }
                        gb2Var3.f(lb0VarArr6[i3].i, lb0VarArr5[i3].i, i11, 8);
                    }
                    lb0 lb0Var8 = lb0VarArr6[i3 + 1].f;
                    if (lb0Var8 != null) {
                        jc0Var8 = lb0Var8.d;
                        lb0 lb0Var9 = jc0Var8.P[i3].f;
                        if (lb0Var9 == null || lb0Var9.d != jc0Var) {
                            jc0Var8 = null;
                        }
                    }
                    if (jc0Var8 != null) {
                        jc0Var = jc0Var8;
                    } else {
                        z11 = true;
                    }
                    jc0Var10 = jc0Var21;
                    z6 = z12;
                    z = z13;
                }
                boolean z16 = z6;
                boolean z17 = z;
                if (jc0Var19 != null) {
                    int i30 = i3 + 1;
                    if (jc0Var17.P[i30].f != null) {
                        lb0 lb0Var10 = jc0Var19.P[i30];
                        if (jc0Var19.o0[i] == 3 && jc0Var19.t[i] == 0 && !z17) {
                            lb0 lb0Var11 = lb0Var10.f;
                            if (lb0Var11.d == kc0Var2) {
                                gb2Var3.e(lb0Var10.i, lb0Var11.i, -lb0Var10.d(), 5);
                            }
                            gb2Var3.g(lb0Var10.i, jc0Var17.P[i30].f.i, -lb0Var10.d(), 6);
                        } else {
                            if (z17) {
                                lb0 lb0Var12 = lb0Var10.f;
                                if (lb0Var12.d == kc0Var2) {
                                    gb2Var3.e(lb0Var10.i, lb0Var12.i, -lb0Var10.d(), 4);
                                }
                            }
                            gb2Var3.g(lb0Var10.i, jc0Var17.P[i30].f.i, -lb0Var10.d(), 6);
                        }
                    }
                }
                if (z16) {
                    int i31 = i3 + 1;
                    jz3 jz3Var7 = lb0VarArr5[i31].i;
                    lb0 lb0Var13 = jc0Var17.P[i31];
                    gb2Var3.f(jz3Var7, lb0Var13.i, lb0Var13.d(), 8);
                }
                ArrayList arrayList5 = p20Var.h;
                if (arrayList5 != null && (size = arrayList5.size()) > 1) {
                    if (p20Var.n && !p20Var.p) {
                        f = p20Var.j;
                    }
                    jc0 jc0Var22 = null;
                    float f7 = 0.0f;
                    int i32 = 0;
                    while (i32 < size) {
                        jc0 jc0Var23 = (jc0) arrayList5.get(i32);
                        float[] fArr = jc0Var23.j0;
                        lb0[] lb0VarArr7 = jc0Var23.P;
                        float f8 = fArr[i];
                        if (f8 >= f4) {
                            arrayList2 = arrayList5;
                            i8 = size;
                            if (f8 != f4) {
                                f3 = f7;
                                gb2Var3.e(lb0VarArr7[i3 + 1].i, lb0VarArr7[i3].i, 0, 8);
                                i9 = i14;
                                f2 = f4;
                                f7 = f3;
                                i10 = i32;
                            } else {
                                float f9 = f7;
                                if (jc0Var22 != null) {
                                    lb0[] lb0VarArr8 = jc0Var22.P;
                                    jz3 jz3Var8 = lb0VarArr8[i3].i;
                                    int i33 = i3 + 1;
                                    jz3 jz3Var9 = lb0VarArr8[i33].i;
                                    jz3 jz3Var10 = lb0VarArr7[i3].i;
                                    jz3 jz3Var11 = lb0VarArr7[i33].i;
                                    ke keVarL = gb2Var3.l();
                                    jc0Var7 = jc0Var23;
                                    float f10 = f4;
                                    keVarL.b = f10;
                                    f2 = f10;
                                    if (f == f10 || f9 == f8) {
                                        i10 = i32;
                                        i9 = i14;
                                        keVarL.d.g(jz3Var8, 1.0f);
                                        keVarL.d.g(jz3Var9, -1.0f);
                                        keVarL.d.g(jz3Var11, 1.0f);
                                        keVarL.d.g(jz3Var10, -1.0f);
                                    } else {
                                        ce ceVar = keVarL.d;
                                        if (f9 == f2) {
                                            i10 = i32;
                                            ceVar.g(jz3Var8, 1.0f);
                                            keVarL.d.g(jz3Var9, -1.0f);
                                            i9 = i14;
                                        } else {
                                            i10 = i32;
                                            i9 = i14;
                                            if (f8 == f4) {
                                                ceVar.g(jz3Var10, 1.0f);
                                                keVarL.d.g(jz3Var11, -1.0f);
                                            } else {
                                                float f11 = (f9 / f) / (f8 / f);
                                                ceVar.g(jz3Var8, 1.0f);
                                                keVarL.d.g(jz3Var9, -1.0f);
                                                keVarL.d.g(jz3Var11, f11);
                                                keVarL.d.g(jz3Var10, -f11);
                                            }
                                        }
                                    }
                                    gb2Var3.c(keVarL);
                                } else {
                                    jc0Var7 = jc0Var23;
                                    i9 = i14;
                                    f2 = f4;
                                    i10 = i32;
                                }
                                f7 = f8;
                                jc0Var22 = jc0Var7;
                            }
                        } else if (p20Var.p) {
                            arrayList2 = arrayList5;
                            i8 = size;
                            gb2Var3.e(lb0VarArr7[i3 + 1].i, lb0VarArr7[i3].i, 0, 4);
                            f3 = f7;
                            i9 = i14;
                            f2 = f4;
                            f7 = f3;
                            i10 = i32;
                        } else {
                            f8 = 1.0f;
                            arrayList2 = arrayList5;
                            i8 = size;
                            if (f8 != f4) {
                            }
                        }
                        i32 = i10 + 1;
                        i14 = i9;
                        arrayList5 = arrayList2;
                        size = i8;
                        f4 = f2;
                    }
                }
                i5 = i14;
                if (jc0Var18 == null || !(jc0Var18 == jc0Var19 || z17)) {
                    jc0Var2 = jc0Var19;
                    if (z2 && jc0Var18 != null) {
                        int i34 = p20Var.j;
                        boolean z18 = i34 > 0 && p20Var.i == i34;
                        jc0 jc0Var24 = jc0Var18;
                        jc0 jc0Var25 = jc0Var24;
                        while (true) {
                            lb0[] lb0VarArr9 = jc0Var25.P;
                            if (jc0Var24 == null) {
                                break;
                            }
                            lb0[] lb0VarArr10 = jc0Var24.P;
                            jc0 jc0Var26 = jc0Var24.l0[i];
                            while (true) {
                                if (jc0Var26 == null) {
                                    i6 = 8;
                                    break;
                                }
                                i6 = 8;
                                if (jc0Var26.f0 != 8) {
                                    break;
                                } else {
                                    jc0Var26 = jc0Var26.l0[i];
                                }
                            }
                            if (jc0Var26 != null || jc0Var24 == jc0Var2) {
                                lb0 lb0Var14 = lb0VarArr10[i3];
                                jz3 jz3Var12 = lb0Var14.i;
                                lb0 lb0Var15 = lb0Var14.f;
                                jz3 jz3Var13 = lb0Var15 != null ? lb0Var15.i : null;
                                if (jc0Var25 != jc0Var24) {
                                    jz3Var13 = lb0VarArr9[i3 + 1].i;
                                } else if (jc0Var24 == jc0Var18) {
                                    lb0 lb0Var16 = lb0VarArr[i3].f;
                                    jz3Var13 = lb0Var16 != null ? lb0Var16.i : null;
                                }
                                int iD2 = lb0Var14.d();
                                int i35 = i3 + 1;
                                int iD3 = lb0VarArr10[i35].d();
                                if (jc0Var26 != null) {
                                    lb0Var2 = jc0Var26.P[i3];
                                    lb0VarArr2 = lb0VarArr9;
                                    jz3Var3 = lb0Var2.i;
                                } else {
                                    lb0VarArr2 = lb0VarArr9;
                                    lb0Var2 = jc0Var17.P[i35].f;
                                    jz3Var3 = lb0Var2 != null ? lb0Var2.i : null;
                                }
                                jz3 jz3Var14 = lb0VarArr10[i35].i;
                                if (lb0Var2 != null) {
                                    iD3 += lb0Var2.d();
                                }
                                int iD4 = lb0VarArr2[i35].d() + iD2;
                                if (jz3Var12 == null || jz3Var13 == null || jz3Var3 == null || jz3Var14 == null) {
                                    jc0Var5 = jc0Var26;
                                    jc0Var6 = jc0Var25;
                                    i7 = 8;
                                } else {
                                    if (jc0Var24 == jc0Var18) {
                                        iD4 = jc0Var18.P[i3].d();
                                    }
                                    int i36 = iD4;
                                    if (jc0Var24 == jc0Var2) {
                                        iD3 = jc0Var2.P[i35].d();
                                    }
                                    jc0Var5 = jc0Var26;
                                    jc0Var6 = jc0Var25;
                                    i7 = 8;
                                    gb2Var.b(jz3Var12, jz3Var13, i36, 0.5f, jz3Var3, jz3Var14, iD3, z18 ? 8 : 5);
                                }
                            } else {
                                jc0Var5 = jc0Var26;
                                jc0Var6 = jc0Var25;
                                i7 = i6;
                            }
                            if (jc0Var24.f0 != i7) {
                                jc0Var6 = jc0Var24;
                            }
                            jc0Var24 = jc0Var5;
                            jc0Var25 = jc0Var6;
                        }
                    } else {
                        int i37 = 8;
                        if (z3 && jc0Var18 != null) {
                            int i38 = p20Var.j;
                            boolean z19 = i38 > 0 && p20Var.i == i38;
                            jc0 jc0Var27 = jc0Var18;
                            jc0 jc0Var28 = jc0Var27;
                            while (true) {
                                lb0[] lb0VarArr11 = jc0Var27.P;
                                if (jc0Var28 == null) {
                                    break;
                                }
                                lb0[] lb0VarArr12 = jc0Var28.P;
                                jc0 jc0Var29 = jc0Var28.l0[i];
                                while (jc0Var29 != null && jc0Var29.f0 == i37) {
                                    jc0Var29 = jc0Var29.l0[i];
                                }
                                if (jc0Var28 == jc0Var18 || jc0Var28 == jc0Var2 || jc0Var29 == null) {
                                    jc0Var3 = jc0Var27;
                                } else {
                                    if (jc0Var29 == jc0Var2) {
                                        jc0Var29 = null;
                                    }
                                    lb0 lb0Var17 = lb0VarArr12[i3];
                                    jz3 jz3Var15 = lb0Var17.i;
                                    int i39 = i3 + 1;
                                    jz3 jz3Var16 = lb0VarArr11[i39].i;
                                    int iD5 = lb0Var17.d();
                                    int iD6 = lb0VarArr12[i39].d();
                                    if (jc0Var29 != null) {
                                        lb0Var = jc0Var29.P[i3];
                                        jz3Var = lb0Var.i;
                                        jc0Var3 = jc0Var27;
                                        lb0 lb0Var18 = lb0Var.f;
                                        jz3Var2 = lb0Var18 != null ? lb0Var18.i : null;
                                    } else {
                                        jc0Var3 = jc0Var27;
                                        lb0 lb0Var19 = jc0Var2.P[i3];
                                        jz3Var = lb0Var19 != null ? lb0Var19.i : null;
                                        jz3 jz3Var17 = lb0VarArr12[i39].i;
                                        lb0Var = lb0Var19;
                                        jz3Var2 = jz3Var17;
                                    }
                                    if (lb0Var != null) {
                                        iD6 += lb0Var.d();
                                    }
                                    int iD7 = lb0VarArr11[i39].d() + iD5;
                                    jc0 jc0Var30 = jc0Var29;
                                    int i40 = iD6;
                                    int i41 = z19 ? 8 : 4;
                                    if (jz3Var15 == null || jz3Var16 == null || jz3Var == null || jz3Var2 == null) {
                                        jc0Var4 = jc0Var30;
                                    } else {
                                        jz3 jz3Var18 = jz3Var;
                                        jc0Var4 = jc0Var30;
                                        gb2Var.b(jz3Var15, jz3Var16, iD7, 0.5f, jz3Var18, jz3Var2, i40, i41);
                                    }
                                    jc0Var29 = jc0Var4;
                                }
                                if (jc0Var28.f0 != 8) {
                                    jc0Var3 = jc0Var28;
                                }
                                jc0Var28 = jc0Var29;
                                i37 = 8;
                                jc0Var27 = jc0Var3;
                            }
                            gb2Var2 = gb2Var;
                            lb0 lb0Var20 = jc0Var18.P[i3];
                            lb0 lb0Var21 = lb0VarArr[i3].f;
                            int i42 = i3 + 1;
                            lb0 lb0Var22 = jc0Var2.P[i42];
                            lb0 lb0Var23 = jc0Var17.P[i42].f;
                            if (lb0Var21 != null) {
                                if (jc0Var18 != jc0Var2) {
                                    gb2Var2.e(lb0Var20.i, lb0Var21.i, lb0Var20.d(), 5);
                                } else if (lb0Var23 != null) {
                                    gb2Var2.b(lb0Var20.i, lb0Var21.i, lb0Var20.d(), 0.5f, lb0Var22.i, lb0Var23.i, lb0Var22.d(), 5);
                                }
                            }
                            if (lb0Var23 != null && jc0Var18 != jc0Var2) {
                                gb2Var2.e(lb0Var22.i, lb0Var23.i, -lb0Var22.d(), 5);
                            }
                        }
                        if ((z2 || z3) && jc0Var18 != null && jc0Var18 != jc0Var2) {
                            lb0[] lb0VarArr13 = jc0Var18.P;
                            lb0 lb0Var24 = lb0VarArr13[i3];
                            if (jc0Var2 == null) {
                                jc0Var2 = jc0Var18;
                            }
                            lb0[] lb0VarArr14 = jc0Var2.P;
                            int i43 = i3 + 1;
                            lb0 lb0Var25 = lb0VarArr14[i43];
                            lb0 lb0Var26 = lb0Var24.f;
                            jz3Var4 = lb0Var26 != null ? lb0Var26.i : null;
                            lb0 lb0Var27 = lb0Var25.f;
                            jz3 jz3Var19 = lb0Var27 != null ? lb0Var27.i : null;
                            if (jc0Var17 != jc0Var2) {
                                lb0 lb0Var28 = jc0Var17.P[i43].f;
                                jz3Var19 = lb0Var28 != null ? lb0Var28.i : null;
                            }
                            if (jc0Var18 == jc0Var2) {
                                lb0Var25 = lb0VarArr13[i43];
                            }
                            if (jz3Var4 != null && jz3Var19 != null) {
                                gb2Var2.b(lb0Var24.i, jz3Var4, lb0Var24.d(), 0.5f, jz3Var19, lb0Var25.i, lb0VarArr14[i43].d(), 5);
                            }
                        }
                    }
                } else {
                    lb0 lb0Var29 = lb0VarArr[i3];
                    int i44 = i3 + 1;
                    lb0 lb0Var30 = jc0Var17.P[i44];
                    lb0 lb0Var31 = lb0Var29.f;
                    jz3 jz3Var20 = lb0Var31 != null ? lb0Var31.i : null;
                    lb0 lb0Var32 = lb0Var30.f;
                    jz3 jz3Var21 = lb0Var32 != null ? lb0Var32.i : null;
                    lb0 lb0Var33 = jc0Var18.P[i3];
                    if (jc0Var19 != null) {
                        lb0Var30 = jc0Var19.P[i44];
                    }
                    if (jz3Var20 == null || jz3Var21 == null) {
                        jc0Var2 = jc0Var19;
                    } else {
                        float f12 = i == 0 ? jc0Var20.c0 : jc0Var20.d0;
                        int iD8 = lb0Var33.d();
                        int iD9 = lb0Var30.d();
                        jz3 jz3Var22 = lb0Var33.i;
                        jz3 jz3Var23 = lb0Var30.i;
                        jz3 jz3Var24 = jz3Var20;
                        jc0Var2 = jc0Var19;
                        gb2Var3.b(jz3Var22, jz3Var24, iD8, f12, jz3Var21, jz3Var23, iD9, 7);
                    }
                }
                gb2Var2 = gb2Var;
                if (z2) {
                    lb0[] lb0VarArr132 = jc0Var18.P;
                    lb0 lb0Var242 = lb0VarArr132[i3];
                    if (jc0Var2 == null) {
                    }
                    lb0[] lb0VarArr142 = jc0Var2.P;
                    int i432 = i3 + 1;
                    lb0 lb0Var252 = lb0VarArr142[i432];
                    lb0 lb0Var262 = lb0Var242.f;
                    if (lb0Var262 != null) {
                    }
                    lb0 lb0Var272 = lb0Var252.f;
                    if (lb0Var272 != null) {
                    }
                    if (jc0Var17 != jc0Var2) {
                    }
                    if (jc0Var18 == jc0Var2) {
                    }
                    if (jz3Var4 != null) {
                    }
                } else {
                    lb0[] lb0VarArr1322 = jc0Var18.P;
                    lb0 lb0Var2422 = lb0VarArr1322[i3];
                    if (jc0Var2 == null) {
                    }
                    lb0[] lb0VarArr1422 = jc0Var2.P;
                    int i4322 = i3 + 1;
                    lb0 lb0Var2522 = lb0VarArr1422[i4322];
                    lb0 lb0Var2622 = lb0Var2422.f;
                    if (lb0Var2622 != null) {
                    }
                    lb0 lb0Var2722 = lb0Var2522.f;
                    if (lb0Var2722 != null) {
                    }
                    if (jc0Var17 != jc0Var2) {
                    }
                    if (jc0Var18 == jc0Var2) {
                    }
                    if (jz3Var4 != null) {
                    }
                }
            } else {
                i5 = i14;
            }
            i15 = i4 + 1;
            kc0Var2 = kc0Var;
            gb2Var3 = gb2Var;
            arrayList3 = arrayList;
            i14 = i5;
        }
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static final void d(iq4 iq4Var, hp3 hp3Var, r92 r92Var) {
        hp3Var.getClass();
        r92Var.getClass();
        bp3 bp3Var = (bp3) iq4Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (bp3Var == null || bp3Var.z) {
            return;
        }
        bp3Var.x(hp3Var, r92Var);
        q92 q92VarB = r92Var.b();
        if (q92VarB == q92.f || q92VarB.compareTo(q92.A) >= 0) {
            hp3Var.d();
        } else {
            r92Var.a(new bm0(3, r92Var, hp3Var));
        }
    }

    public static final Bundle e(e03... e03VarArr) {
        Bundle bundle = new Bundle(e03VarArr.length);
        for (e03 e03Var : e03VarArr) {
            String str = (String) e03Var.b;
            Object obj = e03Var.f;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class<?> componentType = obj.getClass().getComponentType();
                componentType.getClass();
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        xe.m("Illegal value array type ", componentType.getCanonicalName(), " for key \"", str, 34);
                        return null;
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IBinder) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (obj instanceof Size) {
                bundle.putSize(str, (Size) obj);
            } else {
                if (!(obj instanceof SizeF)) {
                    xe.m("Illegal value type ", obj.getClass().getCanonicalName(), " for key \"", str, 34);
                    return null;
                }
                bundle.putSizeF(str, (SizeF) obj);
            }
        }
        return bundle;
    }

    public static boolean f(v03[] v03VarArr, v03[] v03VarArr2) {
        if (v03VarArr != null && v03VarArr2 != null && v03VarArr.length == v03VarArr2.length) {
            for (int i = 0; i < v03VarArr.length; i++) {
                v03 v03Var = v03VarArr[i];
                char c2 = v03Var.a;
                v03 v03Var2 = v03VarArr2[i];
                if (c2 == v03Var2.a && v03Var.b.length == v03Var2.b.length) {
                }
            }
            return true;
        }
        return false;
    }

    public static String g(String str, String str2) {
        i(str2, str != null);
        String strTrim = str.trim();
        i(str2, (strTrim == null ? 0 : strTrim.length()) > 0);
        return strTrim;
    }

    public static void h(Collection collection, String str, Object... objArr) {
        if (collection == null) {
            zo2.p(str, objArr);
        } else {
            if (collection.size() > 0) {
                return;
            }
            zo2.p(str, objArr);
        }
    }

    public static void i(String str, boolean z) {
        if (z) {
            return;
        }
        zo2.p(str, ga5.c);
    }

    public static void j(String str, boolean z, long j) {
        if (z) {
            return;
        }
        zo2.p(str, new Object[]{Long.valueOf(j)});
    }

    public static void k(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        zo2.p(str, new Object[]{obj});
    }

    public static int l(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int m(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static int n(int i, int i2) {
        return u70.e(i, (Color.alpha(i) * i2) / DnsRecord.CLASS_ANY);
    }

    public static float[] o(float[] fArr, int i) {
        if (i < 0) {
            s53.d();
            return null;
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static final void p(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }

    public static final ExecutorService q(boolean z) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new oa0(z));
        executorServiceNewFixedThreadPool.getClass();
        return executorServiceNewFixedThreadPool;
    }

    public static final tk3 r(Throwable th) {
        th.getClass();
        return new tk3(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static v03[] s(String str) {
        int i;
        String strTrim;
        float[] fArrO;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i4 < str.length()) {
            while (i4 < str.length()) {
                char cCharAt = str.charAt(i4);
                if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                    if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                        continue;
                    }
                    i4++;
                }
                if (cCharAt == 'e' || cCharAt == 'E') {
                    i4++;
                } else {
                    strTrim = str.substring(i3, i4).trim();
                    if (!strTrim.isEmpty()) {
                        if (strTrim.charAt(i2) == 'z' || strTrim.charAt(i2) == 'Z') {
                            fArrO = new float[i2];
                        } else {
                            try {
                                float[] fArr = new float[strTrim.length()];
                                int length = strTrim.length();
                                int i5 = i2;
                                int i6 = 1;
                                while (i6 < length) {
                                    int i7 = i2;
                                    int i8 = i7;
                                    int i9 = i8;
                                    int i10 = i9;
                                    for (int i11 = i6; i11 < strTrim.length(); i11++) {
                                        char cCharAt2 = strTrim.charAt(i11);
                                        if (cCharAt2 == ' ') {
                                            i7 = 0;
                                            i9 = 1;
                                            if (i9 != 0) {
                                            }
                                        } else {
                                            if (cCharAt2 != 'E' && cCharAt2 != 'e') {
                                                switch (cCharAt2) {
                                                    case ',':
                                                        break;
                                                    case '-':
                                                        if (i11 != i6 && i7 == 0) {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                        }
                                                        i7 = 0;
                                                        break;
                                                    case '.':
                                                        if (i8 == 0) {
                                                            i7 = 0;
                                                            i8 = 1;
                                                        } else {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                        }
                                                        break;
                                                    default:
                                                        i7 = 0;
                                                        break;
                                                }
                                            } else {
                                                i7 = 1;
                                            }
                                            if (i9 != 0) {
                                            }
                                        }
                                        if (i6 < i11) {
                                            fArr[i5] = Float.parseFloat(strTrim.substring(i6, i11));
                                            i5++;
                                        }
                                        i6 = i10 == 0 ? i11 : i11 + 1;
                                        i2 = 0;
                                    }
                                    if (i6 < i11) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    i2 = 0;
                                }
                                fArrO = o(fArr, i5);
                                i2 = 0;
                            } catch (NumberFormatException e) {
                                zo2.o(ha0.o("error in parsing \"", strTrim, "\""), e);
                                return null;
                            }
                        }
                        arrayList.add(new v03(strTrim.charAt(i2), fArrO));
                    }
                    i3 = i4;
                    i4++;
                    i2 = 0;
                }
            }
            strTrim = str.substring(i3, i4).trim();
            if (!strTrim.isEmpty()) {
            }
            i3 = i4;
            i4++;
            i2 = 0;
        }
        if (i4 - i3 != 1 || i3 >= str.length()) {
            i = 0;
        } else {
            i = 0;
            arrayList.add(new v03(str.charAt(i3), new float[0]));
        }
        return (v03[]) arrayList.toArray(new v03[i]);
    }

    public static Path t(String str) {
        Path path = new Path();
        try {
            J(s(str), path);
            return path;
        } catch (RuntimeException e) {
            zo2.o("Error in parsing ".concat(str), e);
            return null;
        }
    }

    public static final xw4 u(Context context, na0 na0Var) {
        ml3 ml3VarJ;
        context.getClass();
        ih4 ih4Var = new ih4(na0Var.c);
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        la laVar = (la) ih4Var.a;
        laVar.getClass();
        d84 d84Var = na0Var.d;
        int i = 1;
        if (context.getResources().getBoolean(R.bool.workmanager_test_configuration)) {
            ml3VarJ = new ml3(applicationContext, WorkDatabase.class, null);
            ml3VarJ.i = true;
        } else {
            ml3VarJ = l72.j(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            ml3VarJ.h = new o73(15, applicationContext);
        }
        ml3VarJ.f = laVar;
        ml3VarJ.d.add(new r50());
        ml3VarJ.a(gm2.h);
        int i2 = 2;
        ml3VarJ.a(new qj3(applicationContext, 2, 3));
        ml3VarJ.a(gm2.i);
        ml3VarJ.a(gm2.j);
        ml3VarJ.a(new qj3(applicationContext, 5, 6));
        ml3VarJ.a(gm2.k);
        ml3VarJ.a(gm2.l);
        ml3VarJ.a(gm2.m);
        ml3VarJ.a(new qj3(applicationContext));
        ml3VarJ.a(new qj3(applicationContext, 10, 11));
        ml3VarJ.a(gm2.d);
        ml3VarJ.a(gm2.e);
        ml3VarJ.a(gm2.f);
        ml3VarJ.a(gm2.g);
        ml3VarJ.a(new qj3(applicationContext, 21, 22));
        ml3VarJ.n = false;
        ml3VarJ.o = true;
        ml3VarJ.p = true;
        WorkDatabase workDatabase = (WorkDatabase) ml3VarJ.b();
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        Context applicationContext3 = applicationContext2.getApplicationContext();
        applicationContext3.getClass();
        jm jmVar = new jm(applicationContext3, ih4Var, 0);
        Context applicationContext4 = applicationContext2.getApplicationContext();
        applicationContext4.getClass();
        jm jmVar2 = new jm(applicationContext4, ih4Var, i);
        Context applicationContext5 = applicationContext2.getApplicationContext();
        applicationContext5.getClass();
        String str = nr2.a;
        Object mr2Var = Build.VERSION.SDK_INT >= 24 ? new mr2(applicationContext5, ih4Var) : new or2(applicationContext5, ih4Var);
        Context applicationContext6 = applicationContext2.getApplicationContext();
        applicationContext6.getClass();
        jm jmVar3 = new jm(applicationContext6, ih4Var, i2);
        v92 v92Var = new v92();
        v92Var.b = applicationContext2;
        v92Var.f = jmVar;
        v92Var.z = jmVar2;
        v92Var.A = mr2Var;
        v92Var.X = jmVar3;
        n53 n53Var = new n53(context.getApplicationContext(), na0Var, ih4Var, workDatabase);
        String str2 = fq3.a;
        o94 o94Var = new o94(context, workDatabase, na0Var);
        dy2.a(context, SystemJobService.class, true);
        ue2.g().a(fq3.a, "Created SystemJobScheduler and enabled SystemJobService");
        return new xw4(context.getApplicationContext(), na0Var, ih4Var, workDatabase, e70.K(o94Var, new bq1(context, na0Var, v92Var, n53Var, new e24(n53Var, ih4Var), ih4Var)), n53Var, v92Var);
    }

    public static v03[] v(v03[] v03VarArr) {
        v03[] v03VarArr2 = new v03[v03VarArr.length];
        for (int i = 0; i < v03VarArr.length; i++) {
            v03VarArr2[i] = new v03(v03VarArr[i]);
        }
        return v03VarArr2;
    }

    public static String w(au auVar) {
        StringBuilder sb = new StringBuilder(auVar.size());
        for (int i = 0; i < auVar.size(); i++) {
            byte bA = auVar.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static final ef0 x(Executor executor) {
        return new z61(executor);
    }

    public static /* synthetic */ zf1 y(nm1 nm1Var, cf0 cf0Var, int i, jp jpVar, int i2) {
        if ((i2 & 1) != 0) {
            cf0Var = c41.b;
        }
        if ((i2 & 2) != 0) {
            i = -3;
        }
        if ((i2 & 4) != 0) {
            jpVar = jp.b;
        }
        return nm1Var.b(cf0Var, i, jpVar);
    }

    public static int z(Context context, int i, int i2) {
        Integer numValueOf;
        TypedValue typedValueA = ek0.A(context, i);
        if (typedValueA != null) {
            int i3 = typedValueA.resourceId;
            numValueOf = Integer.valueOf(i3 != 0 ? context.getColor(i3) : typedValueA.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i2;
    }

    public abstract String D();

    public abstract int Q(int i, int i2, int i3, mh2 mh2Var, byte[] bArr);
}
