package defpackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.android.core.a1;
import io.sentry.android.core.cache.a;
import io.sentry.p5;
import io.sentry.t5;
import j$.util.Objects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class vf2 implements jm1 {
    public static volatile xq1 f;
    public final /* synthetic */ int b;
    public static final double[][] z = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    public static final char[] A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] X = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Object Y = new Object();

    public /* synthetic */ vf2(int i) {
        this.b = i;
    }

    public static int A(double d) {
        if (Double.isNaN(d)) {
            xe.k("Cannot round NaN value.");
            return 0;
        }
        if (d > 2.147483647E9d) {
            return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static int B(float f2) {
        if (!Float.isNaN(f2)) {
            return Math.round(f2);
        }
        xe.k("Cannot round NaN value.");
        return 0;
    }

    public static boolean C(Object obj, Set set, Set set2) {
        if (set == null && set2 == null) {
            return false;
        }
        return set2 == null ? set.contains(obj) : set == null ? !set2.contains(obj) : !set2.contains(obj) || set.contains(obj);
    }

    public static boolean D(int i, int i2, int i3, int i4) {
        return (i3 == 1 || i3 == 2 || (i3 == 4 && i != 2)) || (i4 == 1 || i4 == 2 || (i4 == 4 && i2 != 2));
    }

    public static final Object E(ie0 ie0Var) {
        Object obj;
        cf0 cf0VarJ = ie0Var.j();
        je.A(cf0VarJ);
        ge0 ge0VarU = p95.u(ie0Var);
        lv0 lv0Var = ge0VarU instanceof lv0 ? (lv0) ge0VarU : null;
        mf0 mf0Var = mf0.b;
        xl4 xl4Var = xl4.a;
        if (lv0Var == null) {
            obj = xl4Var;
        } else {
            ef0 ef0Var = lv0Var.A;
            if (mv0.c(ef0Var, cf0VarJ)) {
                lv0Var.Y = xl4Var;
                lv0Var.z = 1;
                ef0Var.n0(cf0VarJ, lv0Var);
            } else {
                cf0 cf0VarX = cf0VarJ.X(new iy4(iy4.f));
                lv0Var.Y = xl4Var;
                lv0Var.z = 1;
                ef0Var.n0(cf0VarX, lv0Var);
            }
            obj = mf0Var;
        }
        return obj == mf0Var ? obj : xl4Var;
    }

    public static void F(int i, int i2) {
        String strS0;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strS0 = yr2.s0("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    a.b(String.valueOf(i2).length() + 15, i2, "negative size: ");
                    return;
                }
                strS0 = yr2.s0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strS0);
        }
    }

    public static void G(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? H(i, i3, "start index") : (i2 < 0 || i2 > i3) ? H(i2, i3, "end index") : yr2.s0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static String H(int i, int i2, String str) {
        if (i < 0) {
            return yr2.s0("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return yr2.s0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        a.b(String.valueOf(i2).length() + 15, i2, "negative size: ");
        return null;
    }

    public static final dm3 a(int i, float f2, xe0 xe0Var, List list) {
        float[] fArr = new float[i * 2];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long jC0 = yr2.c0(eo4.e(f2, (eo4.b / i) * 2.0f * i3), qf1.a(0.0f, 0.0f));
            int i4 = i2 + 1;
            fArr[i2] = yr2.H(jC0);
            i2 += 2;
            fArr[i4] = yr2.I(jC0);
        }
        return b(fArr, xe0Var, list, 0.0f, 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final dm3 b(float[] fArr, xe0 xe0Var, List list, float f2, float f3) {
        float f4;
        long jA;
        int i;
        ArrayList arrayList;
        List listX;
        hg0 hg0VarA;
        xe0 xe0Var2;
        float f5 = 1.0f;
        Float fValueOf = Float.valueOf(1.0f);
        xe0Var.getClass();
        dm3 dm3Var = null;
        if (fArr.length < 6) {
            xe.k("Polygons must have at least 3 vertices");
            return null;
        }
        int i2 = 2;
        int i3 = 1;
        if (fArr.length % 2 == 1) {
            xe.k("The vertices array should have even size");
            return null;
        }
        if (list != null && list.size() * 2 != fArr.length) {
            xe.k("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int length = fArr.length / 2;
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            xe0 xe0Var3 = (list == null || (xe0Var2 = (xe0) list.get(i5)) == null) ? xe0Var : xe0Var2;
            int i6 = (((i5 + length) - 1) % length) * 2;
            int i7 = i5 + 1;
            int i8 = (i7 % length) * 2;
            int i9 = i5 * 2;
            arrayList3.add(new am3(qf1.a(fArr[i6], fArr[i6 + 1]), qf1.a(fArr[i9], fArr[i9 + 1]), qf1.a(fArr[i8], fArr[i8 + 1]), xe0Var3));
            i5 = i7;
            f5 = f5;
        }
        float f6 = f5;
        b12 b12VarD0 = gb4.d0(0, length);
        ArrayList arrayList4 = new ArrayList(f70.Q(10, b12VarD0));
        Iterator it = b12VarD0.iterator();
        while (true) {
            f4 = 0.0f;
            if (!((a12) it).z) {
                break;
            }
            int iNextInt = ((a12) it).nextInt();
            int i10 = (iNextInt + 1) % length;
            float f7 = ((am3) arrayList3.get(iNextInt)).h + ((am3) arrayList3.get(i10)).h;
            float fC = ((am3) arrayList3.get(i10)).c() + ((am3) arrayList3.get(iNextInt)).c();
            int i11 = iNextInt * 2;
            float f8 = fArr[i11];
            float f9 = fArr[i11 + 1];
            int i12 = i10 * 2;
            float f10 = f8 - fArr[i12];
            float f11 = f9 - fArr[i12 + 1];
            float f12 = eo4.b;
            float fSqrt = (float) Math.sqrt((f11 * f11) + (f10 * f10));
            arrayList4.add(f7 > fSqrt ? new e03(Float.valueOf(fSqrt / f7), Float.valueOf(0.0f)) : fC > fSqrt ? new e03(fValueOf, Float.valueOf((fSqrt - f7) / (fC - f7))) : new e03(fValueOf, fValueOf));
        }
        int i13 = 0;
        while (i13 < length) {
            float[] fArrCopyOf = new float[i2];
            dm3 dm3Var2 = dm3Var;
            int i14 = i4;
            int i15 = i14;
            while (i15 < i2) {
                int i16 = i2;
                e03 e03Var = (e03) arrayList4.get((((i13 + length) - 1) + i15) % length);
                float f13 = f4;
                float fH = ha0.h(((am3) arrayList3.get(i13)).c(), ((am3) arrayList3.get(i13)).h, ((Number) e03Var.f).floatValue(), ((am3) arrayList3.get(i13)).h * ((Number) e03Var.b).floatValue());
                int i17 = i14 + 1;
                if (fArrCopyOf.length < i17) {
                    fArrCopyOf = Arrays.copyOf(fArrCopyOf, Math.max(i17, (fArrCopyOf.length * 3) / 2));
                }
                fArrCopyOf[i14] = fH;
                i15++;
                i14 = i17;
                fArrCopyOf = fArrCopyOf;
                i2 = i16;
                f4 = f13;
            }
            int i18 = i2;
            float f14 = f4;
            am3 am3Var = (am3) arrayList3.get(i13);
            if (i14 <= 0) {
                s53.k("Index must be between 0 and size");
                return dm3Var2;
            }
            float f15 = fArrCopyOf[i15];
            if (i3 >= i14) {
                s53.k("Index must be between 0 and size");
                return dm3Var2;
            }
            float f16 = fArrCopyOf[i3];
            long j = am3Var.e;
            int i19 = i3;
            int i20 = length;
            long j2 = am3Var.d;
            float f17 = am3Var.f;
            ArrayList arrayList5 = arrayList2;
            long j3 = am3Var.b;
            float fMin = Math.min(f15, f16);
            float f18 = am3Var.h;
            if (f18 < 1.0E-4f || fMin < 1.0E-4f || f17 < 1.0E-4f) {
                i = i13;
                arrayList = arrayList4;
                am3Var.i = j3;
                float fH2 = yr2.H(j3);
                float fI = yr2.I(j3);
                float fH3 = yr2.H(j3);
                float fI2 = yr2.I(j3);
                listX = p95.x(je.a(fH2, fI, eo4.c(fH2, fH3, 0.33333334f), eo4.c(fI, fI2, 0.33333334f), eo4.c(fH2, fH3, 0.6666667f), eo4.c(fI, fI2, 0.6666667f), fH3, fI2));
            } else {
                float fMin2 = Math.min(fMin, f18);
                float fA = am3Var.a(f15);
                float fA2 = am3Var.a(f16);
                float f19 = (f17 * fMin2) / f18;
                float f20 = eo4.b;
                i = i13;
                am3Var.i = yr2.c0(j3, yr2.n0(yr2.D(yr2.t(yr2.c0(j2, j), 2.0f)), (float) Math.sqrt((fMin2 * fMin2) + (f19 * f19))));
                long jC0 = yr2.c0(j3, yr2.n0(j2, fMin2));
                long jC02 = yr2.c0(j3, yr2.n0(j, fMin2));
                hg0 hg0VarB = am3.b(fMin2, fA, am3Var.b, am3Var.a, jC0, jC02, am3Var.i, f19);
                hg0 hg0VarB2 = am3.b(fMin2, fA2, am3Var.b, am3Var.c, jC02, jC0, am3Var.i, f19);
                float fA3 = hg0VarB2.a();
                float fB = hg0VarB2.b();
                float[] fArr2 = hg0VarB2.a;
                hg0 hg0VarA2 = je.a(fA3, fB, fArr2[4], fArr2[5], fArr2[i18], fArr2[3], fArr2[i15], fArr2[i19]);
                float fH4 = yr2.H(am3Var.i);
                float fI3 = yr2.I(am3Var.i);
                float fA4 = hg0VarB.a();
                float fB2 = hg0VarB.b();
                float[] fArr3 = hg0VarA2.a;
                float f21 = fArr3[i15];
                float f22 = fArr3[i19];
                long jB = eo4.b(fA4 - fH4, fB2 - fI3);
                float f23 = f21 - fH4;
                float f24 = f22 - fI3;
                arrayList = arrayList4;
                long jB2 = eo4.b(f23, f24);
                long jA2 = qf1.a(-yr2.I(jB), yr2.H(jB));
                long jA3 = qf1.a(-yr2.I(jB2), yr2.H(jB2));
                int i21 = (yr2.I(jA2) * f24) + (yr2.H(jA2) * f23) >= f14 ? i19 : i15;
                float fW = yr2.w(jB, jB2);
                if (fW > 0.999f) {
                    hg0VarA = je.a(fA4, fB2, eo4.c(fA4, f21, 0.33333334f), eo4.c(fB2, f22, 0.33333334f), eo4.c(fA4, f21, 0.6666667f), eo4.c(fB2, f22, 0.6666667f), f21, f22);
                } else {
                    float fSqrt2 = (((((float) Math.sqrt(2.0f * r8)) - ((float) Math.sqrt(f6 - (fW * fW)))) * ((((float) Math.sqrt((r12 * r12) + (r11 * r11))) * 4.0f) / 3.0f)) / (f6 - fW)) * (i21 != 0 ? f6 : -1.0f);
                    hg0VarA = je.a(fA4, fB2, (yr2.H(jA2) * fSqrt2) + fA4, (yr2.I(jA2) * fSqrt2) + fB2, f21 - (yr2.H(jA3) * fSqrt2), f22 - (yr2.I(jA3) * fSqrt2), f21, f22);
                }
                hg0[] hg0VarArr = new hg0[3];
                hg0VarArr[i15] = hg0VarB;
                hg0VarArr[i19] = hg0VarA;
                hg0VarArr[i18] = hg0VarA2;
                listX = e70.K(hg0VarArr);
            }
            arrayList5.add(listX);
            i13 = i + 1;
            f4 = f14;
            arrayList2 = arrayList5;
            arrayList4 = arrayList;
            dm3Var = dm3Var2;
            i4 = i15;
            length = i20;
            i2 = i18;
            i3 = i19;
        }
        ArrayList arrayList6 = arrayList2;
        int i22 = i3;
        int i23 = i4;
        float f25 = f4;
        ArrayList arrayList7 = new ArrayList();
        int i24 = i23;
        while (i24 < length) {
            int i25 = i24 + 1;
            int i26 = i25 % length;
            int i27 = i24 * 2;
            long jA4 = qf1.a(fArr[i27], fArr[i27 + 1]);
            int i28 = (((i24 + length) - 1) % length) * 2;
            long jA5 = qf1.a(fArr[i28], fArr[i28 + 1]);
            int i29 = i26 * 2;
            long jA6 = qf1.a(fArr[i29], fArr[i29 + 1]);
            long jT = yr2.T(jA4, jA5);
            long jT2 = yr2.T(jA6, jA4);
            arrayList7.add(new gc1((List) arrayList6.get(i24), jA4, ((am3) arrayList3.get(i24)).i, (yr2.I(jT2) * yr2.H(jT)) - (yr2.H(jT2) * yr2.I(jT)) > f25 ? i22 : i23));
            float fA5 = ((hg0) d70.k0((List) arrayList6.get(i24))).a();
            float fB3 = ((hg0) d70.k0((List) arrayList6.get(i24))).b();
            float f26 = ((hg0) d70.d0((List) arrayList6.get(i26))).a[i23];
            float f27 = ((hg0) d70.d0((List) arrayList6.get(i26))).a[i22];
            arrayList7.add(new hc1(p95.x(je.a(fA5, fB3, eo4.c(fA5, f26, 0.33333334f), eo4.c(fB3, f27, 0.33333334f), eo4.c(fA5, f26, 0.6666667f), eo4.c(fB3, f27, 0.6666667f), f26, f27))));
            i24 = i25;
        }
        if (f2 == Float.MIN_VALUE || f3 == Float.MIN_VALUE) {
            float f28 = f25;
            float f29 = f28;
            int i30 = i23;
            while (i30 < fArr.length) {
                int i31 = i30 + 1;
                f29 += fArr[i30];
                i30 += 2;
                f28 += fArr[i31];
            }
            jA = qf1.a((f29 / fArr.length) / 2.0f, (f28 / fArr.length) / 2.0f);
        } else {
            jA = qf1.a(f2, f3);
        }
        return new dm3(arrayList7, Float.intBitsToFloat((int) (jA >> 32)), Float.intBitsToFloat((int) (jA & 4294967295L)));
    }

    public static ic3 c(Context context, Bundle bundle) {
        boolean z2 = bundle.getBoolean("androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED", true);
        String[] strArrX = x(context, "androidx.camera.core.quirks.FORCE_ENABLED", bundle);
        String[] strArrX2 = x(context, "androidx.camera.core.quirks.FORCE_DISABLED", bundle);
        ez4.o("QuirkSettingsLoader", "Loaded quirk settings from metadata:");
        ez4.o("QuirkSettingsLoader", "  KEY_DEFAULT_QUIRK_ENABLED = " + z2);
        ez4.o("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_ENABLED = " + Arrays.toString(strArrX));
        ez4.o("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_DISABLED = " + Arrays.toString(strArrX2));
        return new ic3(z2, new HashSet(z(strArrX)), new HashSet(z(strArrX2)));
    }

    public static final void d(int i) {
        if (i >= 1) {
            return;
        }
        e04.f(dw2.A(i, "Expected positive parallelism level, but got "));
    }

    public static final void e(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    qe4.s(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    ek0.b(th, th2);
                    return;
                }
            }
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (autoCloseable instanceof ExecutorService) {
                l0.u((ExecutorService) autoCloseable);
                return;
            }
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            }
            if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
                return;
            }
            if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else if (autoCloseable instanceof ContentProviderClient) {
                ((ContentProviderClient) autoCloseable).release();
            } else {
                s53.d();
            }
        }
    }

    public static final Object f(tz3 tz3Var, int i) {
        Object obj;
        tz3Var.getClass();
        int iB = co4.b(tz3Var.z, i, tz3Var.b);
        if (iB < 0 || (obj = tz3Var.f[iB]) == Y) {
            return null;
        }
        return obj;
    }

    public static boolean g(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
        } catch (Throwable th) {
            th = th;
            inputStreamOpenRawResource = null;
        }
        try {
            boolean zH = h(file, inputStreamOpenRawResource);
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused) {
                }
            }
            return zH;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean h(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            fileOutputStream.close();
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return true;
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            a1.d("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static ci1 i(Context context) {
        ProviderInfo providerInfo;
        ai1 ai1Var;
        ApplicationInfo applicationInfo;
        int i = 15;
        k01 hl0Var = Build.VERSION.SDK_INT >= 28 ? new hl0(i) : new k01(i);
        PackageManager packageManager = context.getPackageManager();
        r25.i(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            ai1Var = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrS = hl0Var.s(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrS) {
                    arrayList.add(signature.toByteArray());
                }
                ai1Var = new ai1(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e) {
                a1.a("emoji2.text.DefaultEmojiConfig", p5.ERROR, null, e);
                a1.b(t5.FATAL, null, e);
                Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                ai1Var = null;
            }
        }
        if (ai1Var == null) {
            return null;
        }
        return new ci1(new bi1(context, ai1Var));
    }

    public static View l(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewFindViewById = viewGroup.getChildAt(i2).findViewById(i);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    public static mt4 m(jc0 jc0Var, int i, ArrayList arrayList, mt4 mt4Var) {
        int i2;
        int i3 = i == 0 ? jc0Var.m0 : jc0Var.n0;
        if (i3 != -1 && (mt4Var == null || i3 != mt4Var.b)) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                mt4 mt4Var2 = (mt4) arrayList.get(i4);
                if (mt4Var2.b == i3) {
                    if (mt4Var != null) {
                        mt4Var.c(i, mt4Var2);
                        arrayList.remove(mt4Var);
                    }
                    mt4Var = mt4Var2;
                } else {
                    i4++;
                }
            }
        } else if (i3 != -1) {
            return mt4Var;
        }
        if (mt4Var == null) {
            if (jc0Var instanceof wj) {
                wj wjVar = (wj) jc0Var;
                int i5 = 0;
                while (true) {
                    if (i5 >= wjVar.q0) {
                        i2 = -1;
                        break;
                    }
                    jc0 jc0Var2 = wjVar.p0[i5];
                    if ((i == 0 && (i2 = jc0Var2.m0) != -1) || (i == 1 && (i2 = jc0Var2.n0) != -1)) {
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= arrayList.size()) {
                            break;
                        }
                        mt4 mt4Var3 = (mt4) arrayList.get(i6);
                        if (mt4Var3.b == i2) {
                            mt4Var = mt4Var3;
                            break;
                        }
                        i6++;
                    }
                }
            }
            if (mt4Var == null) {
                mt4Var = new mt4();
                mt4Var.a = new ArrayList();
                mt4Var.d = null;
                mt4Var.e = -1;
                int i7 = mt4.f;
                mt4.f = i7 + 1;
                mt4Var.b = i7;
                mt4Var.c = i;
            }
            arrayList.add(mt4Var);
        }
        ArrayList arrayList2 = mt4Var.a;
        if (arrayList2.contains(jc0Var)) {
            return mt4Var;
        }
        arrayList2.add(jc0Var);
        if (jc0Var instanceof nq1) {
            nq1 nq1Var = (nq1) jc0Var;
            nq1Var.s0.b(nq1Var.t0 == 0 ? 1 : 0, mt4Var, arrayList);
        }
        int i8 = mt4Var.b;
        if (i == 0) {
            jc0Var.m0 = i8;
            jc0Var.H.b(i, mt4Var, arrayList);
            jc0Var.J.b(i, mt4Var, arrayList);
        } else {
            jc0Var.n0 = i8;
            jc0Var.I.b(i, mt4Var, arrayList);
            jc0Var.L.b(i, mt4Var, arrayList);
            jc0Var.K.b(i, mt4Var, arrayList);
        }
        jc0Var.O.b(i, mt4Var, arrayList);
        return mt4Var;
    }

    public static final ic4 n(q30 q30Var, ld0 ld0Var, boolean z2) {
        if (z2) {
            q30Var.c--;
        }
        if (q30Var.c <= 0 && z2) {
            int i = q30Var.b;
            if (i <= 0) {
                q30 q30Var2 = new q30(0, 0, -1);
                return new ic4(q30Var2, q30Var2);
            }
            int i2 = i - 1;
            q30 q30Var3 = new q30(i2, ld0Var.o(i2).f, -1);
            return new ic4(q30Var3, q30Var3);
        }
        if (ld0Var.o(q30Var.b).f == q30Var.c && q30Var.b < ld0Var.b.size() - 1 && !z2) {
            q30 q30Var4 = new q30(q30Var.b + 1, 0, -1);
            return new ic4(q30Var4, q30Var4);
        }
        ud0 ud0VarO = ld0Var.o(q30Var.b);
        ud0VarO.getClass();
        int i3 = q30Var.c;
        while (true) {
            if ((z2 && i3 < 0) || ((!z2 && i3 == ud0VarO.f) || !yr2.O(ud0VarO.charAt(i3)) || (i3 == 0 && z2))) {
                break;
            }
            i3 += z2 ? -1 : 1;
        }
        return t(ld0Var, q30Var.b, i3, false);
    }

    public static v21 o(int i) {
        if (i == 0) {
            return v21.b;
        }
        if (i == 1) {
            return v21.c;
        }
        xe.k(dw2.A(i, "Undefined value:"));
        return null;
    }

    public static Context p(Context context) {
        int i;
        Context applicationContext = context.getApplicationContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34 && (i = l2.i(context)) != l2.i(applicationContext)) {
            applicationContext = l2.a(applicationContext, i);
        }
        if (i2 >= 30) {
            String strD = j2.d(context);
            if (!Objects.equals(strD, j2.d(applicationContext))) {
                return j2.b(applicationContext, strD);
            }
        }
        return applicationContext;
    }

    public static ScheduledExecutorService q() {
        if (f != null) {
            return f;
        }
        synchronized (vf2.class) {
            try {
                if (f == null) {
                    f = new xq1(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    public static String r(int i, String str) {
        for (int i2 = 0; i2 < i; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return str.substring(0, i2);
            }
        }
        return str.substring(0, i);
    }

    public static File s(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, dw2.A(i, str));
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ic4 t(ld0 ld0Var, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        ld0Var.getClass();
        ud0 ud0VarO = ld0Var.o(i);
        long jQ = ga5.q(ud0VarO, i2, z2);
        int i6 = (int) (jQ >> 32);
        int i7 = (int) (jQ & 4294967295L);
        if (i6 != i7) {
            i3 = i;
            i4 = i7;
            i5 = i6;
        } else {
            if (i7 < ud0VarO.f) {
                i4 = i7 + 1;
                i3 = i;
            } else {
                if (i6 > 0) {
                    i5 = i6 - 1;
                    i3 = i;
                } else if (i > 0) {
                    int i8 = i - 1;
                    i5 = ld0Var.o(i8).f;
                    i3 = i;
                    i = i8;
                } else if (i < ld0Var.b.size() - 1) {
                    i4 = 0;
                    i3 = i + 1;
                }
                i4 = i7;
            }
            i5 = i6;
        }
        return new ic4(new q30(i, i5, i6), new q30(i3, i4, i7));
    }

    public static b31 u(Context context) {
        ClassLoader classLoader;
        int iA = y91.a();
        b31 b31Var = null;
        if (iA >= 1) {
            try {
                if (a31.c() && (classLoader = h91.class.getClassLoader()) != null) {
                    ActivityEmbeddingComponent activityEmbeddingComponentA = a31.a();
                    r21 r21Var = new r21(new s23(classLoader));
                    cp1 cp1Var = new cp1(classLoader);
                    if (iA >= 8) {
                        new qx2(activityEmbeddingComponentA, r21Var);
                    }
                    if (iA >= 6) {
                        new d5(activityEmbeddingComponentA);
                    }
                    b31Var = new b31(activityEmbeddingComponentA, r21Var, cp1Var, context);
                }
            } catch (Throwable th) {
                Log.d("EmbeddingBackend", "Failed to load embedding extension: " + th);
            }
        }
        if (b31Var == null) {
            Log.d("EmbeddingBackend", "No supported embedding extension found");
        }
        return b31Var;
    }

    public static boolean v() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean w(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpHeaders.Names.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.Names.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.Names.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static String[] x(Context context, String str, Bundle bundle) {
        if (!bundle.containsKey(str)) {
            return new String[0];
        }
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            ez4.a0("QuirkSettingsLoader", "Resource ID not found for key: ".concat(str));
            return new String[0];
        }
        try {
            return context.getResources().getStringArray(i);
        } catch (Resources.NotFoundException e) {
            ez4.b0("QuirkSettingsLoader", "Quirk class names resource not found: " + i, e);
            return new String[0];
        }
    }

    public static MappedByteBuffer y(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashSet z(String[] strArr) {
        Class<?> cls;
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e) {
                ez4.b0("QuirkSettingsLoader", "Class not found: " + str, e);
            }
            if (hc3.class.isAssignableFrom(cls)) {
                if (cls == null) {
                    hashSet.add(cls);
                }
            } else {
                ez4.a0("QuirkSettingsLoader", str + " does not implement the Quirk interface.");
                cls = null;
                if (cls == null) {
                }
            }
        }
        return hashSet;
    }

    public abstract b72 j(gt3 gt3Var, nj4 nj4Var);

    public abstract ak4 k(bt3 bt3Var, nj4 nj4Var);

    public String toString() {
        switch (this.b) {
            case 4:
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getName());
                    sb.append(" [ ");
                    xt2 xt2Var = new xt2();
                    ma0 ma0Var = xt2Var.f;
                    s52 s52Var = s52.f;
                    t52 t52Var = t52.X;
                    ma0Var.f = new t52(s52Var, s52Var, null, null);
                    s52 s52Var2 = s52.z;
                    ma0Var.f = new t52(s52Var2, s52Var2, null, null);
                    xt2Var.b(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS);
                    sb.append(xt2Var.d(this));
                    sb.append(" ]");
                    return sb.toString();
                } catch (IOException e) {
                    vp1.p(e);
                    return null;
                }
            default:
                return super.toString();
        }
    }

    public /* synthetic */ vf2(boolean z2, int i) {
        this.b = i;
    }
}
