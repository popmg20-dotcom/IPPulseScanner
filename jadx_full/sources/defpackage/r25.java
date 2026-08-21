package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Range;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.InputEvent;
import android.view.animation.AnimationUtils;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class r25 {
    public static ClassLoader a;
    public static Thread b;
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};
    public static final int[][] d = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] e = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] f = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    public static final int[][] g = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    public static final ic1 h;
    public static final ic1[] i;
    public static iv1 j;

    static {
        ic1 ic1Var = new ic1();
        h = ic1Var;
        i = new ic1[]{ic1Var};
    }

    public static Object A(Intent intent, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return k2.g(intent, str, cls);
        }
        Parcelable parcelableExtra = intent.getParcelableExtra(str);
        if (cls.isInstance(parcelableExtra)) {
            return parcelableExtra;
        }
        return null;
    }

    public static int B(int i2, int i3, boolean z) {
        int i4 = z ? ((i3 - i2) + 360) % 360 : (i3 + i2) % 360;
        if (ez4.G(2, ez4.Z("CameraOrientationUtil"))) {
            StringBuilder sbA = fw.A(i2, i3, "getRelativeImageRotation: destRotationDegrees=", ", sourceRotationDegrees=", ", isOppositeFacing=");
            sbA.append(z);
            sbA.append(", result=");
            sbA.append(i4);
            ez4.o("CameraOrientationUtil", sbA.toString());
        }
        return i4;
    }

    public static final int C(go3 go3Var) {
        go3Var.getClass();
        io3 io3VarD0 = go3Var.D0("SELECT changes()");
        try {
            io3VarD0.C0();
            int i2 = (int) io3VarD0.getLong(0);
            vf2.e(io3VarD0, null);
            return i2;
        } finally {
        }
    }

    public static final String D(Throwable th) {
        if (th.getClass().getName().equals("android.app.BackgroundServiceStartNotAllowedException")) {
            return ContextUtilsKt.k(R.string.background_service_start_not_allowed);
        }
        String message = th.getMessage();
        return message == null ? ContextUtilsKt.k(R.string.unknown_error) : message;
    }

    public static final void E(cf0 cf0Var, Throwable th) {
        if (th instanceof kv0) {
            th = ((kv0) th).b;
        }
        try {
            ff0 ff0Var = (ff0) cf0Var.Z(vd3.z);
            if (ff0Var != null) {
                ff0Var.Q(th);
            } else {
                ez4.C(cf0Var, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ek0.b(runtimeException, th);
                th = runtimeException;
            }
            ez4.C(cf0Var, th);
        }
    }

    public static boolean F(byte b2, int i2) {
        return ((1 << i2) & ((long) b2)) != 0;
    }

    public static boolean G(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static boolean H(int i2) {
        return i2 == -1;
    }

    public static boolean I(int i2, int i3, int[] iArr) {
        int i4 = iArr[i2];
        int i5 = i4;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = (i6 + i5) >> 1;
            if (i3 > iArr[(i7 << 1) + 2 + i2]) {
                i6 = i7 + 1;
            } else {
                i5 = i7;
            }
        }
        return i6 < i4 && i3 >= iArr[((i6 << 1) + 1) + i2];
    }

    public static ValueAnimator J(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator;
        int i2;
        ValueAnimator valueAnimator2;
        TypedArray typedArrayO = l72.O(resources, theme, attributeSet, vo.Z);
        TypedArray typedArrayO2 = l72.O(resources, theme, attributeSet, vo.B0);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long j2 = l72.G(xmlPullParser, "duration") ? typedArrayO.getInt(1, 300) : 300;
        long j3 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startOffset") != null ? typedArrayO.getInt(2, 0) : 0;
        int i3 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? typedArrayO.getInt(7, 4) : 4;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueFrom") != null && xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueTo") != null) {
            if (i3 == 4) {
                TypedValue typedValuePeekValue = typedArrayO.peekValue(5);
                boolean z = typedValuePeekValue != null;
                int i4 = z ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayO.peekValue(6);
                boolean z2 = typedValuePeekValue2 != null;
                i3 = ((z && G(i4)) || (z2 && G(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder propertyValuesHolderZ = z(typedArrayO, i3, 5, 6, "");
            if (propertyValuesHolderZ != null) {
                valueAnimator3.setValues(propertyValuesHolderZ);
            }
        }
        valueAnimator3.setDuration(j2);
        valueAnimator3.setStartDelay(j3);
        valueAnimator3.setRepeatCount(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatCount") != null ? typedArrayO.getInt(3, 0) : 0);
        valueAnimator3.setRepeatMode(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatMode") != null ? typedArrayO.getInt(4, 1) : 1);
        if (typedArrayO2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String strY = l72.y(typedArrayO2, xmlPullParser, "pathData", 1);
            if (strY != null) {
                String strY2 = l72.y(typedArrayO2, xmlPullParser, "propertyXName", 2);
                String strY3 = l72.y(typedArrayO2, xmlPullParser, "propertyYName", 3);
                if (i3 != 2) {
                }
                if (strY2 == null && strY3 == null) {
                    throw new InflateException(typedArrayO2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path pathT = n12.t(strY);
                PathMeasure pathMeasure = new PathMeasure(pathT, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float length = 0.0f;
                do {
                    length += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(length));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(pathT, false);
                int iMin = Math.min(100, ((int) (length / 0.5f)) + 1);
                float[] fArr = new float[iMin];
                float[] fArr2 = new float[iMin];
                float[] fArr3 = new float[2];
                float f2 = length / (iMin - 1);
                int i5 = 0;
                valueAnimator = valueAnimator3;
                float f3 = 0.0f;
                int i6 = 0;
                while (true) {
                    if (i5 >= iMin) {
                        break;
                    }
                    int i7 = iMin;
                    pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i6)).floatValue(), fArr3, null);
                    fArr[i5] = fArr3[0];
                    fArr2[i5] = fArr3[1];
                    int i8 = i6 + 1;
                    f3 += f2;
                    if (i8 < arrayList.size() && f3 > ((Float) arrayList.get(i8)).floatValue()) {
                        pathMeasure2.nextContour();
                        i6 = i8;
                    }
                    i5++;
                    iMin = i7;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = strY2 != null ? PropertyValuesHolder.ofFloat(strY2, fArr) : null;
                PropertyValuesHolder propertyValuesHolderOfFloat2 = strY3 != null ? PropertyValuesHolder.ofFloat(strY3, fArr2) : null;
                if (propertyValuesHolderOfFloat == null) {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                } else if (propertyValuesHolderOfFloat2 == null) {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat);
                } else {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                }
                i2 = 0;
            } else {
                valueAnimator = valueAnimator3;
                i2 = 0;
                objectAnimator2.setPropertyName(l72.y(typedArrayO2, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
            i2 = 0;
        }
        int resourceId = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayO.getResourceId(i2, i2) : i2;
        if (resourceId > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator2 = valueAnimator;
        }
        typedArrayO.recycle();
        if (typedArrayO2 != null) {
            typedArrayO2.recycle();
        }
        return valueAnimator2;
    }

    public static final String K(String str) throws NoSuchAlgorithmException {
        str.getClass();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(y30.a);
        bytes.getClass();
        String string = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        string.getClass();
        return p44.D0(string, 32, '0');
    }

    public static byte N(byte b2, int i2) {
        return (byte) (b2 | (1 << i2));
    }

    public static final void O(kz kzVar, r90 r90Var, cp1 cp1Var) {
        ev evVarT;
        iv1 iv1Var = j;
        if (iv1Var == null) {
            xe.q("mCameraUseCaseAdapterProvider must be initialized first!");
            return;
        }
        String strD = kzVar.d();
        strD.getClass();
        mz mzVarB = ((a00) iv1Var.f).b(strD);
        h5 h5Var = new h5(mzVarB.r(), wy.a);
        lb lbVar = lb.X;
        j00 j00Var = new j00(mzVarB, null, h5Var, null, lbVar, lbVar, (ow) iv1Var.z, (e24) iv1Var.X, (pn4) iv1Var.A);
        j00Var.N();
        j00Var.J((List) r90Var.a);
        j00Var.M();
        j00Var.L((Range) r90Var.b);
        List list = (List) r90Var.e;
        ez4.o("CameraUseCaseAdapter", "simulateAddUseCases: appUseCasesToAdd = " + list + ", featureGroup = " + cp1Var);
        synchronized (j00Var.B0) {
            i5 i5Var = j00Var.b;
            uy uyVar = j00Var.A0;
            i5Var.c(uyVar);
            i5 i5Var2 = j00Var.f;
            if (i5Var2 != null) {
                i5Var2.c(uyVar);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(j00Var.X);
            linkedHashSet.addAll(list);
            HashMap mapJ = j00.j(linkedHashSet, cp1Var);
            try {
                try {
                    evVarT = j00Var.t(linkedHashSet, j00Var.f != null);
                    j00.H(mapJ);
                } catch (IllegalArgumentException e2) {
                    throw new h00(e2);
                }
            } catch (Throwable th) {
                j00.H(mapJ);
                throw th;
            }
        }
        evVarT.getClass();
    }

    public static int P(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * (-862048943)), 15)) * 461845907);
    }

    public static final void Q(CoordinatorLayout coordinatorLayout, int i2, int i3) {
        coordinatorLayout.getClass();
        String quantityString = ContextUtilsKt.getContext().getResources().getQuantityString(i2, i3, Integer.valueOf(i3));
        quantityString.getClass();
        S(coordinatorLayout, quantityString);
    }

    public static final void R(CoordinatorLayout coordinatorLayout, int i2, Object... objArr) {
        coordinatorLayout.getClass();
        String string = ContextUtilsKt.getContext().getString(i2, Arrays.copyOf(objArr, objArr.length));
        string.getClass();
        S(coordinatorLayout, string);
    }

    public static final void S(CoordinatorLayout coordinatorLayout, String str) {
        coordinatorLayout.getClass();
        oy3.h(coordinatorLayout, str, -1).j();
    }

    public static int T(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 90;
        }
        if (i2 == 2) {
            return 180;
        }
        if (i2 == 3) {
            return 270;
        }
        xe.k(dw2.A(i2, "Unsupported surface rotation: "));
        return 0;
    }

    public static char U(int i2) throws qi1 {
        if (i2 < 45) {
            return c[i2];
        }
        throw qi1.a();
    }

    public static byte V(byte b2, int i2) {
        return (byte) (b2 & (~(1 << i2)));
    }

    public static final boolean W(String str, pl1 pl1Var) {
        try {
            boolean zBooleanValue = ((Boolean) pl1Var.a()).booleanValue();
            if (!zBooleanValue) {
                a1.d("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public static final Object X(long j2, Function2 function2, ie0 ie0Var) {
        if (j2 <= 0) {
            throw new ee4("Timed out immediately", null);
        }
        fe4 fe4Var = new fe4(j2, ie0Var);
        je.K(fe4Var, true, new aw0(gb4.J(fe4Var.A.j()).I(fe4Var.X, fe4Var, fe4Var.z)));
        return fx3.J(fe4Var, false, fe4Var, function2);
    }

    public static final Object Y(long j2, uf ufVar, p13 p13Var) {
        long jA;
        vd3 vd3Var = cz0.b;
        long jB = 0;
        boolean z = j2 > 0;
        if (z) {
            long J = ek0.J(999999L, ez0.NANOSECONDS);
            int i2 = ((int) j2) & 1;
            if (i2 != (((int) J) & 1)) {
                jA = i2 == 1 ? cz0.a(j2 >> 1, J >> 1) : cz0.a(J >> 1, j2 >> 1);
            } else if (i2 == 0) {
                long j3 = (j2 >> 1) + (J >> 1);
                if (-4611686018426999999L > j3 || j3 >= 4611686018427000000L) {
                    jA = ek0.f(j3 / 1000000);
                } else {
                    jA = j3 << 1;
                    int i3 = dz0.a;
                }
            } else {
                long jA2 = ek0.a(j2 >> 1, J >> 1);
                if (jA2 == 9223372036854759646L) {
                    xe.k("Summing infinite durations of different signs yields an undefined result.");
                    return null;
                }
                if (jA2 == 4611686018427387903L || jA2 == -4611686018427387903L) {
                    jA = ek0.f(jA2);
                } else if (-4611686018426L > jA2 || jA2 >= 4611686018427L) {
                    jA = ek0.f(gb4.w(jA2, -4611686018427387903L, 4611686018427387903L));
                } else {
                    jA = (jA2 * 1000000) << 1;
                    int i4 = dz0.a;
                }
            }
            jB = ((((int) jA) & 1) != 1 || jA == cz0.f || jA == cz0.z) ? cz0.b(jA, ez0.MILLISECONDS) : jA >> 1;
        } else if (z) {
            g.d();
            return null;
        }
        return X(jB, ufVar, p13Var);
    }

    public static int Z(int i2) {
        int[] iArr = {1, 2, 3};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr[i3];
            int i5 = i4 - 1;
            if (i4 == 0) {
                throw null;
            }
            if (i5 == i2) {
                return i4;
            }
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b8 A[Catch: all -> 0x00b4, PHI: r2
      0x00b8: PHI (r2v1 java.lang.Thread) = (r2v0 java.lang.Thread), (r2v11 java.lang.Thread) binds: [B:7:0x000c, B:47:0x00b0] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:46:0x00ae, B:62:0x00e7, B:12:0x0023, B:52:0x00b7, B:53:0x00b8, B:65:0x00eb, B:54:0x00b9, B:60:0x00e5, B:59:0x00c3, B:13:0x0024, B:15:0x0031, B:25:0x004b, B:26:0x0052, B:28:0x005d, B:34:0x0072, B:35:0x0079, B:43:0x008a, B:44:0x00ac, B:18:0x0040), top: B:77:0x0003, inners: #0, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ClassLoader a0() {
        ClassLoader classLoader;
        SecurityException e2;
        Thread thread;
        ThreadGroup threadGroup;
        classLoader = a;
        if (classLoader == null) {
            Thread thread2 = b;
            ClassLoader contextClassLoader = null;
            if (thread2 != null) {
                synchronized (thread2) {
                    try {
                        contextClassLoader = b.getContextClassLoader();
                    } catch (SecurityException e3) {
                        String message = e3.getMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 41);
                        sb.append("Failed to get thread context classloader ");
                        sb.append(message);
                        a1.n("DynamiteLoaderV2CL", sb.toString());
                    }
                }
                classLoader = contextClassLoader;
                a = classLoader;
            } else {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    thread2 = null;
                } else {
                    synchronized (Void.class) {
                        try {
                            try {
                                int iActiveGroupCount = threadGroup2.activeGroupCount();
                                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                                threadGroup2.enumerate(threadGroupArr);
                                int i2 = 0;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= iActiveGroupCount) {
                                        threadGroup = null;
                                        break;
                                    }
                                    threadGroup = threadGroupArr[i3];
                                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                                        break;
                                    }
                                    i3++;
                                }
                                if (threadGroup == null) {
                                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                }
                                int iActiveCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[iActiveCount];
                                threadGroup.enumerate(threadArr);
                                while (true) {
                                    if (i2 >= iActiveCount) {
                                        thread = null;
                                        break;
                                    }
                                    thread = threadArr[i2];
                                    if ("GmsDynamite".equals(thread.getName())) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (thread == null) {
                                    try {
                                        wf wfVar = new wf(threadGroup, "GmsDynamite");
                                        try {
                                            wfVar.setContextClassLoader(null);
                                            wfVar.start();
                                            thread = wfVar;
                                        } catch (SecurityException e4) {
                                            e2 = e4;
                                            thread = wfVar;
                                            String message2 = e2.getMessage();
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(message2).length() + 39);
                                            sb2.append("Failed to enumerate thread/threadgroup ");
                                            sb2.append(message2);
                                            a1.n("DynamiteLoaderV2CL", sb2.toString());
                                        }
                                    } catch (SecurityException e5) {
                                        e2 = e5;
                                    }
                                }
                            } finally {
                            }
                        } catch (SecurityException e6) {
                            e2 = e6;
                            thread = null;
                        }
                    }
                    thread2 = thread;
                }
                b = thread2;
                if (thread2 != null) {
                }
                classLoader = contextClassLoader;
                a = classLoader;
            }
        }
        return classLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(bn bnVar, int i2, wo4 wo4Var, int i3, tt ttVar) throws ey4 {
        int i4;
        char c2;
        byte[][] bArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        byte[][] bArr2 = (byte[][]) ttVar.d;
        int i13 = ttVar.b;
        int i14 = ttVar.c;
        for (byte[] bArr3 : bArr2) {
            Arrays.fill(bArr3, (byte) -1);
        }
        int length = d[0].length;
        t(0, 0, ttVar);
        int i15 = i13 - length;
        t(i15, 0, ttVar);
        t(0, i15, ttVar);
        s(0, 7, ttVar);
        int i16 = i13 - 8;
        s(i16, 7, ttVar);
        s(0, i16, ttVar);
        u(7, 0, ttVar);
        int i17 = i14 - 8;
        u(i17, 0, ttVar);
        int i18 = i14 - 7;
        u(7, i18, ttVar);
        if (ttVar.c(8, i17) == 0) {
            throw new ey4();
        }
        ttVar.d(8, i17, 1);
        int i19 = wo4Var.a;
        if (i19 < 2) {
            i4 = 0;
            c2 = 1;
        } else {
            i4 = 0;
            int[] iArr = f[i19 - 1];
            c2 = 1;
            int length2 = iArr.length;
            int i20 = 0;
            while (i20 < length2) {
                int i21 = iArr[i20];
                if (i21 >= 0) {
                    int length3 = iArr.length;
                    int i22 = 0;
                    while (i22 < length3) {
                        int i23 = iArr[i22];
                        if (i23 >= 0 && H(ttVar.c(i23, i21))) {
                            int i24 = i23 - 2;
                            int i25 = i21 - 2;
                            bArr = bArr2;
                            i5 = i13;
                            int i26 = 0;
                            while (true) {
                                if (i26 >= 5) {
                                    break;
                                }
                                int[] iArr2 = e[i26];
                                int i27 = i26;
                                int i28 = 0;
                                for (int i29 = 5; i28 < i29; i29 = 5) {
                                    int i30 = i28;
                                    ttVar.d(i24 + i28, i25 + i27, iArr2[i30]);
                                    i28 = i30 + 1;
                                    length3 = length3;
                                }
                                i26 = i27 + 1;
                            }
                        } else {
                            bArr = bArr2;
                            i5 = i13;
                        }
                        i22++;
                        bArr2 = bArr;
                        i13 = i5;
                        length3 = length3;
                    }
                }
                i20++;
                bArr2 = bArr2;
                i13 = i13;
            }
        }
        byte[][] bArr4 = bArr2;
        int i31 = i13;
        int i32 = 8;
        while (i32 < i16) {
            int i33 = i32 + 1;
            int i34 = i33 % 2;
            if (H(ttVar.c(i32, 6))) {
                ttVar.d(i32, 6, i34);
            }
            if (H(ttVar.c(6, i32))) {
                ttVar.d(6, i32, i34);
            }
            i32 = i33;
        }
        bn bnVar2 = new bn();
        if (i3 < 0 || i3 >= 8) {
            throw new ey4("Invalid mask pattern");
        }
        int iG = (fw.g(i2) << 3) | i3;
        bnVar2.b(iG, 5);
        bnVar2.b(d(iG, 1335), 10);
        bn bnVar3 = new bn();
        bnVar3.b(21522, 15);
        if (bnVar2.f != bnVar3.f) {
            xe.k("Sizes don't match");
            return;
        }
        int i35 = i4;
        while (true) {
            int[] iArr3 = bnVar2.b;
            if (i35 >= iArr3.length) {
                break;
            }
            iArr3[i35] = iArr3[i35] ^ bnVar3.b[i35];
            i35++;
        }
        if (bnVar2.f != 15) {
            throw new ey4("should not happen but we got: " + bnVar2.f);
        }
        int i36 = i4;
        while (true) {
            int i37 = bnVar2.f;
            if (i36 >= i37) {
                break;
            }
            boolean zD = bnVar2.d((i37 - 1) - i36);
            int[] iArr4 = g[i36];
            int i38 = iArr4[i4];
            byte[] bArr5 = bArr4[iArr4[c2]];
            byte b2 = zD ? (byte) 1 : (byte) 0;
            bArr5[i38] = b2;
            if (i36 < 8) {
                i12 = (i31 - i36) - 1;
                i11 = 8;
            } else {
                i11 = (i36 - 8) + i18;
                i12 = 8;
            }
            bArr4[i11][i12] = b2;
            i36++;
        }
        if (i19 >= 7) {
            bn bnVar4 = new bn();
            bnVar4.b(i19, 6);
            bnVar4.b(d(i19, 7973), 12);
            if (bnVar4.f != 18) {
                throw new ey4("should not happen but we got: " + bnVar4.f);
            }
            int i39 = 17;
            for (int i40 = i4; i40 < 6; i40++) {
                for (int i41 = i4; i41 < 3; i41++) {
                    boolean zD2 = bnVar4.d(i39);
                    i39--;
                    int i42 = (i14 - 11) + i41;
                    byte[] bArr6 = bArr4[i42];
                    byte b3 = zD2 ? (byte) 1 : (byte) 0;
                    bArr6[i40] = b3;
                    bArr4[i40][i42] = b3;
                }
            }
        }
        int i43 = i31 - 1;
        int i44 = i14 - 1;
        int i45 = i4;
        int i46 = -1;
        while (i43 > 0) {
            if (i43 == 6) {
                i43--;
            }
            while (i44 >= 0 && i44 < i14) {
                for (int i47 = i4; i47 < 2; i47++) {
                    int i48 = i43 - i47;
                    if (H(ttVar.c(i48, i44))) {
                        if (i45 < bnVar.f) {
                            boolean zD3 = bnVar.d(i45);
                            i45++;
                            i6 = zD3;
                        } else {
                            i6 = i4;
                        }
                        if (i3 != -1) {
                            switch (i3) {
                                case 0:
                                    i7 = i44 + i48;
                                    i8 = i7 & 1;
                                    if (i8 == 0) {
                                        i6 = ~i6;
                                    }
                                    break;
                                case 1:
                                    i8 = i44 & 1;
                                    if (i8 == 0) {
                                    }
                                    break;
                                case 2:
                                    i8 = i48 % 3;
                                    if (i8 == 0) {
                                    }
                                    break;
                                case 3:
                                    i8 = (i44 + i48) % 3;
                                    if (i8 == 0) {
                                    }
                                    break;
                                case 4:
                                    i8 = ((i48 / 3) + (i44 / 2)) & 1;
                                    if (i8 == 0) {
                                    }
                                    break;
                                case 5:
                                    int i49 = i44 * i48;
                                    i8 = (i49 % 3) + (i49 & 1);
                                    if (i8 == 0) {
                                    }
                                    break;
                                case 6:
                                    int i50 = i44 * i48;
                                    i9 = i50 & 1;
                                    i10 = i50 % 3;
                                    i7 = i10 + i9;
                                    i8 = i7 & 1;
                                    if (i8 == 0) {
                                    }
                                    break;
                                case 7:
                                    i10 = (i44 * i48) % 3;
                                    i9 = (i44 + i48) & 1;
                                    i7 = i10 + i9;
                                    i8 = i7 & 1;
                                    if (i8 == 0) {
                                    }
                                    break;
                                default:
                                    xe.k(dw2.A(i3, "Invalid mask pattern: "));
                                    return;
                            }
                        }
                        bArr4[i44][i48] = (byte) i6;
                    }
                }
                i44 += i46;
            }
            i46 = -i46;
            i44 += i46;
            i43 -= 2;
        }
        if (i45 == bnVar.f) {
            return;
        }
        throw new ey4("Not all bits consumed: " + i45 + '/' + bnVar.f);
    }

    public static int d(int i2, int i3) {
        if (i3 == 0) {
            xe.k("0 polynomial");
            return 0;
        }
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i3);
        int i4 = 32 - iNumberOfLeadingZeros;
        int iNumberOfLeadingZeros2 = i2 << (31 - iNumberOfLeadingZeros);
        while (32 - Integer.numberOfLeadingZeros(iNumberOfLeadingZeros2) >= i4) {
            iNumberOfLeadingZeros2 ^= i3 << ((32 - Integer.numberOfLeadingZeros(iNumberOfLeadingZeros2)) - i4);
        }
        return iNumberOfLeadingZeros2;
    }

    public static void e(boolean z) {
        if (z) {
            return;
        }
        s53.d();
    }

    public static void f(boolean z, String str) {
        if (z) {
            return;
        }
        xe.k(str);
    }

    public static void g(int i2, int i3, int i4, String str) {
        if (i2 < i3) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i3 + ", " + i4 + "] (too low)");
        }
        if (i2 <= i4) {
            return;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i3 + ", " + i4 + "] (too high)");
    }

    public static void h(int i2, String str) {
        if (i2 >= 0) {
            return;
        }
        xe.k(str);
    }

    public static void i(Object obj, String str) {
        if (obj != null) {
            return;
        }
        zo2.n(str);
    }

    public static void j(String str, boolean z) {
        if (z) {
            return;
        }
        xe.q(str);
    }

    public static final Object k(zf1 zf1Var, Function2 function2, v74 v74Var) {
        int i2 = bh1.a;
        Object objA = p95.b(new h30(new bv(function2, (ge0) null, 1), zf1Var, c41.b, -2, jp.b), 0).a(os2.b, v74Var);
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        if (objA != mf0Var) {
            objA = xl4Var;
        }
        return objA == mf0Var ? objA : xl4Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:207:0x03bf, code lost:
    
        if (r32 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03c1, code lost:
    
        if (r18 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03c3, code lost:
    
        r1 = new android.animation.Animator[r18.size()];
        r2 = r18.iterator();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03d2, code lost:
    
        if (r2.hasNext() == false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x03d4, code lost:
    
        r1[r11] = (android.animation.Animator) r2.next();
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03e0, code lost:
    
        if (r33 != 0) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03e2, code lost:
    
        r32.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03e5, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03e6, code lost:
    
        r32.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03e9, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0391 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Animator l(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2) throws XmlPullParserException, IOException {
        int i3;
        ArrayList arrayList;
        PropertyValuesHolder[] propertyValuesHolderArr;
        AttributeSet attributeSet2;
        int i4;
        int i5;
        int i6;
        int i7;
        ArrayList arrayList2;
        int i8;
        PropertyValuesHolder propertyValuesHolderZ;
        int size;
        int i9;
        int[] iArr;
        Keyframe keyframeOfFloat;
        Resources.Theme theme2;
        int i10;
        AttributeSet attributeSet3;
        Resources resources2;
        XmlPullParser xmlPullParser2;
        Animator animator;
        Animator animatorJ;
        int depth = xmlPullParser.getDepth();
        Animator animator2 = null;
        ArrayList arrayList3 = null;
        while (true) {
            int next = xmlPullParser.next();
            int i11 = 3;
            int i12 = 0;
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                break;
            }
            int i13 = 1;
            if (next == 1) {
                break;
            }
            int i14 = 2;
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    J(context, resources, theme, attributeSet, objectAnimator, xmlPullParser);
                    animatorJ = objectAnimator;
                } else if (name.equals("animator")) {
                    animatorJ = J(context, resources, theme, attributeSet, null, xmlPullParser);
                } else {
                    Resources resources3 = resources;
                    Resources.Theme theme3 = theme;
                    if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayO = l72.O(resources3, theme3, attributeSet, vo.y0);
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "ordering") != null) {
                            theme2 = theme3;
                            i10 = typedArrayO.getInt(0, 0);
                            attributeSet3 = attributeSet;
                            xmlPullParser2 = xmlPullParser;
                            resources2 = resources3;
                        } else {
                            theme2 = theme3;
                            i10 = 0;
                            attributeSet3 = attributeSet;
                            resources2 = resources3;
                            xmlPullParser2 = xmlPullParser;
                        }
                        l(context, resources2, theme2, xmlPullParser2, attributeSet3, animatorSet2, i10);
                        animator = animatorSet2;
                        typedArrayO.recycle();
                        i3 = depth;
                        arrayList = arrayList3;
                        animator2 = animator;
                        if (animatorSet == null || i12 != 0) {
                            arrayList3 = arrayList;
                        } else {
                            arrayList3 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList3.add(animator2);
                        }
                        depth = i3;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
                        ArrayList arrayList4 = null;
                        while (true) {
                            int eventType = xmlPullParser.getEventType();
                            if (eventType == i11 || eventType == i13) {
                                break;
                            }
                            if (eventType != i14) {
                                xmlPullParser.next();
                            } else {
                                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                                    TypedArray typedArrayO2 = l72.O(resources3, theme3, attributeSetAsAttributeSet, vo.z0);
                                    String strY = l72.y(typedArrayO2, xmlPullParser, "propertyName", i11);
                                    int i15 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? typedArrayO2.getInt(i14, 4) : 4;
                                    i6 = i14;
                                    int[] iArr2 = vo.A0;
                                    attributeSet2 = attributeSetAsAttributeSet;
                                    int i16 = i15;
                                    ArrayList arrayList5 = null;
                                    while (true) {
                                        int next2 = xmlPullParser.next();
                                        i7 = depth;
                                        if (next2 == 3 || next2 == 1) {
                                            break;
                                        }
                                        if (xmlPullParser.getName().equals("keyframe")) {
                                            if (i16 == 4) {
                                                TypedArray typedArrayO3 = l72.O(resources3, theme3, Xml.asAttributeSet(xmlPullParser), iArr2);
                                                TypedValue typedValuePeekValue = !l72.G(xmlPullParser, "value") ? null : typedArrayO3.peekValue(0);
                                                int i17 = (typedValuePeekValue == null || !G(typedValuePeekValue.type)) ? 0 : 3;
                                                typedArrayO3.recycle();
                                                i16 = i17;
                                            }
                                            TypedArray typedArrayO4 = l72.O(resources3, theme3, Xml.asAttributeSet(xmlPullParser), iArr2);
                                            iArr = iArr2;
                                            float f2 = l72.G(xmlPullParser, "fraction") ? typedArrayO4.getFloat(3, -1.0f) : -1.0f;
                                            TypedValue typedValuePeekValue2 = !l72.G(xmlPullParser, "value") ? null : typedArrayO4.peekValue(0);
                                            boolean z = typedValuePeekValue2 != null;
                                            int i18 = i16 == 4 ? (z && G(typedValuePeekValue2.type)) ? 3 : 0 : i16;
                                            if (!z) {
                                                keyframeOfFloat = i18 == 0 ? Keyframe.ofFloat(f2) : Keyframe.ofInt(f2);
                                            } else if (i18 == 0) {
                                                keyframeOfFloat = Keyframe.ofFloat(f2, xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "value") != null ? typedArrayO4.getFloat(0, 0.0f) : 0.0f);
                                            } else if (i18 == 1 || i18 == 3) {
                                                keyframeOfFloat = Keyframe.ofInt(f2, xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "value") != null ? typedArrayO4.getInt(0, 0) : 0);
                                            } else {
                                                keyframeOfFloat = null;
                                            }
                                            int resourceId = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayO4.getResourceId(1, 0) : 0;
                                            if (resourceId > 0) {
                                                keyframeOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                            }
                                            typedArrayO4.recycle();
                                            ArrayList arrayList6 = arrayList5;
                                            if (keyframeOfFloat != null) {
                                                if (arrayList6 == null) {
                                                    arrayList6 = new ArrayList();
                                                }
                                                arrayList6.add(keyframeOfFloat);
                                                arrayList5 = arrayList6;
                                            }
                                            xmlPullParser.next();
                                        } else {
                                            iArr = iArr2;
                                        }
                                        resources3 = resources;
                                        theme3 = theme;
                                        depth = i7;
                                        iArr2 = iArr;
                                    }
                                    ArrayList arrayList7 = arrayList5;
                                    if (arrayList7 == null || (size = arrayList7.size()) <= 0) {
                                        arrayList2 = arrayList3;
                                        i4 = 3;
                                        propertyValuesHolderZ = null;
                                    } else {
                                        Keyframe keyframe = (Keyframe) arrayList7.get(0);
                                        Keyframe keyframe2 = (Keyframe) arrayList7.get(size - 1);
                                        float fraction = keyframe2.getFraction();
                                        int i19 = size;
                                        Class cls = Integer.TYPE;
                                        Class cls2 = Float.TYPE;
                                        if (fraction >= 1.0f) {
                                            arrayList2 = arrayList3;
                                        } else if (fraction < 0.0f) {
                                            arrayList2 = arrayList3;
                                            keyframe2.setFraction(1.0f);
                                        } else {
                                            arrayList2 = arrayList3;
                                            arrayList7.add(arrayList7.size(), keyframe2.getType() == cls2 ? Keyframe.ofFloat(1.0f) : keyframe2.getType() == cls ? Keyframe.ofInt(1.0f) : Keyframe.ofObject(1.0f));
                                            i19++;
                                        }
                                        float fraction2 = keyframe.getFraction();
                                        if (fraction2 != 0.0f) {
                                            if (fraction2 < 0.0f) {
                                                keyframe.setFraction(0.0f);
                                            } else {
                                                arrayList7.add(0, keyframe.getType() == cls2 ? Keyframe.ofFloat(0.0f) : keyframe.getType() == cls ? Keyframe.ofInt(0.0f) : Keyframe.ofObject(0.0f));
                                                i19++;
                                            }
                                        }
                                        int i20 = i19;
                                        Keyframe[] keyframeArr = new Keyframe[i20];
                                        arrayList7.toArray(keyframeArr);
                                        int i21 = 0;
                                        while (i21 < i20) {
                                            Keyframe keyframe3 = keyframeArr[i21];
                                            if (keyframe3.getFraction() >= 0.0f) {
                                                i9 = i20;
                                            } else if (i21 == 0) {
                                                keyframe3.setFraction(0.0f);
                                                i9 = i20;
                                            } else {
                                                int i22 = i20 - 1;
                                                if (i21 == i22) {
                                                    keyframe3.setFraction(1.0f);
                                                    i9 = i20;
                                                } else {
                                                    int i23 = i21;
                                                    for (int i24 = i21 + 1; i24 < i22 && keyframeArr[i24].getFraction() < 0.0f; i24++) {
                                                        i23 = i24;
                                                    }
                                                    float fraction3 = (keyframeArr[i23 + 1].getFraction() - keyframeArr[i21 - 1].getFraction()) / ((i23 - i21) + 2);
                                                    int i25 = i21;
                                                    while (i25 <= i23) {
                                                        float f3 = fraction3;
                                                        keyframeArr[i25].setFraction(keyframeArr[i25 - 1].getFraction() + f3);
                                                        i25++;
                                                        i20 = i20;
                                                        fraction3 = f3;
                                                    }
                                                    i9 = i20;
                                                }
                                            }
                                            i21++;
                                            i20 = i9;
                                        }
                                        propertyValuesHolderZ = PropertyValuesHolder.ofKeyframe(strY, keyframeArr);
                                        i4 = 3;
                                        if (i16 == 3) {
                                            propertyValuesHolderZ.setEvaluator(td.a);
                                        }
                                    }
                                    i5 = 1;
                                    i8 = 0;
                                    if (propertyValuesHolderZ == null) {
                                        propertyValuesHolderZ = z(typedArrayO2, i15, 0, 1, strY);
                                    }
                                    if (propertyValuesHolderZ != null) {
                                        if (arrayList4 == null) {
                                            arrayList4 = new ArrayList();
                                        }
                                        arrayList4.add(propertyValuesHolderZ);
                                    }
                                    typedArrayO2.recycle();
                                } else {
                                    attributeSet2 = attributeSetAsAttributeSet;
                                    i4 = i11;
                                    i5 = i13;
                                    i6 = i14;
                                    i7 = depth;
                                    arrayList2 = arrayList3;
                                    i8 = i12;
                                }
                                xmlPullParser.next();
                                i11 = i4;
                                i13 = i5;
                                i12 = i8;
                                i14 = i6;
                                arrayList3 = arrayList2;
                                attributeSetAsAttributeSet = attributeSet2;
                                depth = i7;
                                resources3 = resources;
                                theme3 = theme;
                            }
                        }
                        int i26 = i13;
                        i3 = depth;
                        arrayList = arrayList3;
                        int i27 = i12;
                        if (arrayList4 != null) {
                            int size2 = arrayList4.size();
                            propertyValuesHolderArr = new PropertyValuesHolder[size2];
                            for (int i28 = i27; i28 < size2; i28++) {
                                propertyValuesHolderArr[i28] = (PropertyValuesHolder) arrayList4.get(i28);
                            }
                        } else {
                            propertyValuesHolderArr = null;
                        }
                        if (propertyValuesHolderArr != null && (animator2 instanceof ValueAnimator)) {
                            ((ValueAnimator) animator2).setValues(propertyValuesHolderArr);
                        }
                        i12 = i26;
                        animator2 = animator2;
                        if (animatorSet == null) {
                            arrayList3 = arrayList;
                            depth = i3;
                        }
                    }
                }
                animator = animatorJ;
                i3 = depth;
                arrayList = arrayList3;
                animator2 = animator;
                if (animatorSet == null) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(en enVar, StringBuilder sb, int i2, boolean z) throws qi1 {
        while (i2 > 1) {
            if (enVar.a() < 11) {
                throw qi1.a();
            }
            int iC = enVar.c(11);
            sb.append(U(iC / 45));
            sb.append(U(iC % 45));
            i2 -= 2;
        }
        if (i2 == 1) {
            if (enVar.a() < 6) {
                throw qi1.a();
            }
            sb.append(U(enVar.c(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(en enVar, StringBuilder sb, int i2, x30 x30Var, ArrayList arrayList) throws qi1 {
        Charset charsetForName;
        boolean z;
        byte b2;
        if (i2 * 8 > enVar.a()) {
            throw qi1.a();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) enVar.c(8);
        }
        if (x30Var == null) {
            Charset charset = n44.b;
            boolean z2 = true;
            if (i2 <= 2 || !(((b2 = bArr[0]) == -2 && bArr[1] == -1) || (b2 == -1 && bArr[1] == -2))) {
                boolean z3 = charset != null;
                boolean z4 = i2 > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                boolean z5 = z3;
                boolean z6 = true;
                while (i7 < i2 && (z2 || z5 || z6)) {
                    Charset charset2 = charset;
                    byte b3 = bArr[i7];
                    boolean z7 = z2;
                    int i16 = b3 & 255;
                    if (z6) {
                        if (i8 > 0) {
                            if ((b3 & 128) != 0) {
                                i8--;
                            }
                            if (z7) {
                                if (i16 > 127 && i16 < 160) {
                                    z7 = false;
                                } else if (i16 > 159 && (i16 < 192 || i16 == 215 || i16 == 247)) {
                                    i13++;
                                }
                            }
                            if (z5) {
                                if (i9 > 0) {
                                    if (i16 < 64 || i16 == 127 || i16 > 252) {
                                        z5 = false;
                                    } else {
                                        i9--;
                                    }
                                } else if (i16 != 128 && i16 != 160 && i16 <= 239) {
                                    if (i16 <= 160 || i16 >= 224) {
                                        if (i16 > 127) {
                                            i9++;
                                            int i17 = i14 + 1;
                                            if (i17 > i5) {
                                                i5 = i17;
                                                i14 = i5;
                                            } else {
                                                i14 = i17;
                                            }
                                        } else {
                                            i14 = 0;
                                        }
                                        i15 = 0;
                                    } else {
                                        i6++;
                                        int i18 = i15 + 1;
                                        if (i18 > i3) {
                                            i3 = i18;
                                            i15 = i3;
                                        } else {
                                            i15 = i18;
                                        }
                                        i14 = 0;
                                    }
                                }
                            }
                            i7++;
                            charset = charset2;
                            z2 = z7;
                        } else {
                            z = z6;
                            if ((b3 & 128) != 0) {
                                if ((b3 & 64) != 0) {
                                    int i19 = i8 + 1;
                                    if ((b3 & HttpConstants.SP) == 0) {
                                        i10++;
                                    } else {
                                        i19 = i8 + 2;
                                        if ((b3 & 16) == 0) {
                                            i11++;
                                        } else {
                                            i8 += 3;
                                            if ((b3 & 8) == 0) {
                                                i12++;
                                            }
                                        }
                                    }
                                    i8 = i19;
                                }
                            }
                        }
                        z6 = false;
                        if (z7) {
                        }
                        if (z5) {
                        }
                        i7++;
                        charset = charset2;
                        z2 = z7;
                    } else {
                        z = z6;
                    }
                    z6 = z;
                    if (z7) {
                    }
                    if (z5) {
                    }
                    i7++;
                    charset = charset2;
                    z2 = z7;
                }
                Charset charset3 = charset;
                boolean z8 = z2;
                boolean z9 = z6;
                boolean z10 = (!z9 || i8 <= 0) ? z9 : false;
                boolean z11 = (!z5 || i9 <= 0) ? z5 : false;
                if (z10 && (z4 || i10 + i11 + i12 > 0)) {
                    charsetForName = StandardCharsets.UTF_8;
                } else if (!z11 || (!n44.d && i3 < 3 && i5 < 3)) {
                    if (!z8 || !z11) {
                        charsetForName = z8 ? StandardCharsets.ISO_8859_1 : z11 ? charset3 : z10 ? StandardCharsets.UTF_8 : n44.a;
                    } else if ((i3 != 2 || i6 != 2) && i13 * 10 < i2) {
                        charsetForName = StandardCharsets.ISO_8859_1;
                    }
                }
            } else {
                charsetForName = StandardCharsets.UTF_16;
            }
        } else {
            charsetForName = Charset.forName(x30Var.name());
        }
        sb.append(new String(bArr, charsetForName));
        arrayList.add(bArr);
    }

    public static void o(en enVar, StringBuilder sb, int i2) throws qi1 {
        if (n44.c == null) {
            throw qi1.a();
        }
        if (i2 * 13 > enVar.a()) {
            throw qi1.a();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iC = enVar.c(13);
            int i4 = (iC % 96) | ((iC / 96) << 8);
            int i5 = i4 + (i4 < 2560 ? 41377 : 42657);
            bArr[i3] = (byte) ((i5 >> 8) & DnsRecord.CLASS_ANY);
            bArr[i3 + 1] = (byte) (i5 & DnsRecord.CLASS_ANY);
            i3 += 2;
            i2--;
        }
        sb.append(new String(bArr, n44.c));
    }

    public static void p(en enVar, StringBuilder sb, int i2) throws qi1 {
        if (n44.b == null) {
            throw qi1.a();
        }
        if (i2 * 13 > enVar.a()) {
            throw qi1.a();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iC = enVar.c(13);
            int i4 = (iC % 192) | ((iC / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        sb.append(new String(bArr, n44.b));
    }

    public static void q(en enVar, StringBuilder sb, int i2) throws qi1 {
        while (i2 >= 3) {
            if (enVar.a() < 10) {
                throw qi1.a();
            }
            int iC = enVar.c(10);
            if (iC >= 1000) {
                throw qi1.a();
            }
            sb.append(U(iC / 100));
            sb.append(U((iC / 10) % 10));
            sb.append(U(iC % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (enVar.a() < 7) {
                throw qi1.a();
            }
            int iC2 = enVar.c(7);
            if (iC2 >= 100) {
                throw qi1.a();
            }
            sb.append(U(iC2 / 10));
            sb.append(U(iC2 % 10));
            return;
        }
        if (i2 == 1) {
            if (enVar.a() < 4) {
                throw qi1.a();
            }
            int iC3 = enVar.c(4);
            if (iC3 >= 10) {
                throw qi1.a();
            }
            sb.append(U(iC3));
        }
    }

    public static final boolean r(String str, String str2) {
        str.getClass();
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    int i5 = i4 + 1;
                    if (i4 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt == '(') {
                        i3++;
                    } else if (cCharAt == ')' && i3 - 1 == 0 && i4 != str.length() - 1) {
                        break;
                    }
                    i2++;
                    i4 = i5;
                } else if (i3 == 0) {
                    return n12.c(p44.U0(str.substring(1, str.length() - 1)).toString(), str2);
                }
            }
        }
        return false;
    }

    public static void s(int i2, int i3, tt ttVar) throws ey4 {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!H(ttVar.c(i5, i3))) {
                throw new ey4();
            }
            ttVar.d(i5, i3, 0);
        }
    }

    public static void t(int i2, int i3, tt ttVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = d[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                ttVar.d(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    public static void u(int i2, int i3, tt ttVar) throws ey4 {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!H(ttVar.c(i2, i5))) {
                throw new ey4();
            }
            ttVar.d(i2, i5, 0);
        }
    }

    public static final Object v(ag1 ag1Var, zf1 zf1Var, v74 v74Var) throws Throwable {
        if (ag1Var instanceof zd4) {
            throw ((zd4) ag1Var).b;
        }
        Object objA = zf1Var.a(ag1Var, v74Var);
        return objA == mf0.b ? objA : xl4.a;
    }

    public static final String w(Collection collection) {
        return !collection.isEmpty() ? q44.a0(d70.j0(collection, ",\n", "\n", "\n", null, 56)).concat("},") : " }";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static k0 x(String str) {
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1420886789:
                if (str.equals("ISO8859_1")) {
                    b2 = 0;
                }
                break;
            case -1420886788:
                if (str.equals("ISO8859_2")) {
                    b2 = 1;
                }
                break;
            case -1420886787:
                if (str.equals("ISO8859_3")) {
                    b2 = 2;
                }
                break;
            case -1420886786:
                if (str.equals("ISO8859_4")) {
                    b2 = 3;
                }
                break;
            case -1420886785:
                if (str.equals("ISO8859_5")) {
                    b2 = 4;
                }
                break;
            case -1420886784:
                if (str.equals("ISO8859_6")) {
                    b2 = 5;
                }
                break;
            case -1420886783:
                if (str.equals("ISO8859_7")) {
                    b2 = 6;
                }
                break;
            case -1420886782:
                if (str.equals("ISO8859_8")) {
                    b2 = 7;
                }
                break;
            case -1420886781:
                if (str.equals("ISO8859_9")) {
                    b2 = 8;
                }
                break;
            case -1097817451:
                if (str.equals("ISO8859_10")) {
                    b2 = 9;
                }
                break;
            case -1097817450:
                if (str.equals("ISO8859_11")) {
                    b2 = 10;
                }
                break;
            case -1097817448:
                if (str.equals("ISO8859_13")) {
                    b2 = 11;
                }
                break;
            case -1097817447:
                if (str.equals("ISO8859_14")) {
                    b2 = 12;
                }
                break;
            case -1097817446:
                if (str.equals("ISO8859_15")) {
                    b2 = HttpConstants.CR;
                }
                break;
            case -1097817445:
                if (str.equals("ISO8859_16")) {
                    b2 = 14;
                }
                break;
            case -694532656:
                if (str.equals("Windows_31J")) {
                    b2 = 15;
                }
                break;
            case -336096374:
                if (str.equals("EmacsMule")) {
                    b2 = 16;
                }
                break;
            case -55735080:
                if (str.equals("Windows_1250")) {
                    b2 = 17;
                }
                break;
            case -55735079:
                if (str.equals("Windows_1251")) {
                    b2 = 18;
                }
                break;
            case -55735078:
                if (str.equals("Windows_1252")) {
                    b2 = 19;
                }
                break;
            case -55735077:
                if (str.equals("Windows_1253")) {
                    b2 = 20;
                }
                break;
            case -55735076:
                if (str.equals("Windows_1254")) {
                    b2 = 21;
                }
                break;
            case -55735073:
                if (str.equals("Windows_1257")) {
                    b2 = 22;
                }
                break;
            case 70352:
                if (str.equals("GBK")) {
                    b2 = 23;
                }
                break;
            case 2038613:
                if (str.equals("BIG5")) {
                    b2 = 24;
                }
                break;
            case 2546113:
                if (str.equals("SJIS")) {
                    b2 = 25;
                }
                break;
            case 2615185:
                if (str.equals("UTF8")) {
                    b2 = 26;
                }
                break;
            case 62568241:
                if (str.equals("ASCII")) {
                    b2 = 27;
                }
                break;
            case 64013940:
                if (str.equals("CESU8")) {
                    b2 = 28;
                }
                break;
            case 64315633:
                if (str.equals("CP949")) {
                    b2 = 29;
                }
                break;
            case 66321945:
                if (str.equals("EUCJP")) {
                    b2 = 30;
                }
                break;
            case 66321978:
                if (str.equals("EUCKR")) {
                    b2 = 31;
                }
                break;
            case 66322262:
                if (str.equals("EUCTW")) {
                    b2 = HttpConstants.SP;
                }
                break;
            case 71689535:
                if (str.equals("KOI8R")) {
                    b2 = 33;
                }
                break;
            case 71689538:
                if (str.equals("KOI8U")) {
                    b2 = HttpConstants.DOUBLE_QUOTE;
                }
                break;
            case 524744459:
                if (str.equals("GB18030")) {
                    b2 = 35;
                }
                break;
            case 567189331:
                if (str.equals("USASCII")) {
                    b2 = 36;
                }
                break;
            case 599410479:
                if (str.equals("UTF16BE")) {
                    b2 = 37;
                }
                break;
            case 599410789:
                if (str.equals("UTF16LE")) {
                    b2 = 38;
                }
                break;
            case 599466217:
                if (str.equals("UTF32BE")) {
                    b2 = 39;
                }
                break;
            case 599466527:
                if (str.equals("UTF32LE")) {
                    b2 = 40;
                }
                break;
            case 1548547022:
                if (str.equals("Big5UAO")) {
                    b2 = 41;
                }
                break;
            case 2083301867:
                if (str.equals("Big5HKSCS")) {
                    b2 = 42;
                }
                break;
        }
        switch (b2) {
            case 0:
                return hw1.C0;
            case 1:
                return iw1.C0;
            case 2:
                return jw1.C0;
            case 3:
                return kw1.C0;
            case 4:
                return lw1.C0;
            case 5:
                return mw1.C0;
            case 6:
                return nw1.C0;
            case 7:
                return ow1.C0;
            case 8:
                return pw1.C0;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return bw1.C0;
            case 10:
                return cw1.C0;
            case 11:
                return dw1.C0;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ew1.C0;
            case 13:
                return fw1.C0;
            case 14:
                return gw1.C0;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return rv4.G0;
            case 16:
                return g21.D0;
            case 17:
                return lv4.C0;
            case 18:
                return mv4.C0;
            case 19:
                return nv4.C0;
            case 20:
                return ov4.C0;
            case 21:
                return pv4.C0;
            case 22:
                return qv4.C0;
            case 23:
                return ym1.C0;
            case 24:
                return xh.F0;
            case 25:
                return co3.H0;
            case 26:
                return tk4.F0;
            case 27:
                return t.z0;
            case 28:
                return gu.F0;
            case 29:
                return hu.C0;
            case 30:
                return d01.G0;
            case 31:
                return e01.D0;
            case 32:
                return f01.D0;
            case 33:
                return b82.C0;
            case 34:
                return c82.C0;
            case 35:
                return xm1.C0;
            case 36:
                return ok4.z0;
            case 37:
                return pk4.E0;
            case 38:
                return qk4.D0;
            case 39:
                return rk4.E0;
            case 40:
                return sk4.E0;
            case 41:
                return zm.F0;
            case 42:
                return ym.F0;
            default:
                String strO = ha0.o("org.jcodings.specific.", str, "Encoding");
                try {
                    Class<?> cls = Class.forName(strO);
                    try {
                        return (k0) cls.getField("INSTANCE").get(cls);
                    } catch (Exception unused) {
                        throw new r41("problem loading encoding <%n>".replaceAll("%n", strO));
                    }
                } catch (ClassNotFoundException unused2) {
                    throw new r41("encoding class <%n> not found".replaceAll("%n", strO));
                }
        }
    }

    public static PropertyValuesHolder z(TypedArray typedArray, int i2, int i3, int i4, String str) {
        PropertyValuesHolder propertyValuesHolderOfFloat;
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        boolean z = typedValuePeekValue != null;
        int i5 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i4);
        boolean z2 = typedValuePeekValue2 != null;
        int i6 = z2 ? typedValuePeekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && G(i5)) || (z2 && G(i6))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            v03[] v03VarArrS = n12.s(string);
            v03[] v03VarArrS2 = n12.s(string2);
            if (v03VarArrS != null || v03VarArrS2 != null) {
                if (v03VarArrS != null) {
                    v8 v8Var = new v8(0);
                    if (v03VarArrS2 == null) {
                        return PropertyValuesHolder.ofObject(str, v8Var, v03VarArrS);
                    }
                    if (n12.f(v03VarArrS, v03VarArrS2)) {
                        return PropertyValuesHolder.ofObject(str, v8Var, v03VarArrS, v03VarArrS2);
                    }
                    throw new InflateException(fw.u(" Can't morph from ", string, " to ", string2));
                }
                if (v03VarArrS2 != null) {
                    return PropertyValuesHolder.ofObject(str, new v8(0), v03VarArrS2);
                }
            }
            return null;
        }
        td tdVar = i2 == 3 ? td.a : null;
        if (z3) {
            if (z) {
                float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            int dimension2 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : G(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            if (z2) {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : G(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2);
            }
        } else if (z2) {
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : G(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
        }
        if (propertyValuesHolderOfInt != null && tdVar != null) {
            propertyValuesHolderOfInt.setEvaluator(tdVar);
        }
        return propertyValuesHolderOfInt;
    }

    public abstract Object L(Uri uri, InputEvent inputEvent, ge0 ge0Var);

    public abstract Object M(Uri uri, ge0 ge0Var);

    public abstract boolean a(Object obj, Object obj2);

    public abstract boolean b(Object obj, Object obj2);

    public abstract Object y(ge0 ge0Var);
}
