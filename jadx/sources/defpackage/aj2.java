package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class aj2 {
    public static final dm3 a;
    public static final dm3 b;
    public static final dm3 c;
    public static final dm3 d;
    public static final dm3 e;
    public static final dm3 f;
    public static final dm3 g;

    static {
        xe0 xe0Var = new xe0(0.15f, 0.0f);
        xe0 xe0Var2 = new xe0(0.2f, 0.0f);
        xe0 xe0Var3 = new xe0(0.3f, 0.0f);
        xe0 xe0Var4 = new xe0(0.5f, 0.0f);
        xe0 xe0Var5 = new xe0(1.0f, 0.0f);
        c(gb4.r(14));
        c(vf2.b(new float[]{0.5f, 0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, -0.5f}, xe0Var3, null, 0.0f, 0.0f));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zi2(new PointF(0.926f, 0.97f), new xe0(0.189f, 0.811f)));
        arrayList.add(new zi2(new PointF(-0.021f, 0.967f), new xe0(0.187f, 0.057f)));
        c(b(2, arrayList, false));
        xe0 xe0Var6 = xe0.c;
        c(tj4.k0(vf2.a(4, 1.0f, xe0Var6, Arrays.asList(xe0Var5, xe0Var5, xe0Var2, xe0Var2)), a(-135.0f)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new zi2(new PointF(1.0f, 1.0f), new xe0(0.148f, 0.417f)));
        arrayList2.add(new zi2(new PointF(0.0f, 1.0f), new xe0(0.151f, 0.0f)));
        arrayList2.add(new zi2(new PointF(0.0f, 0.0f), new xe0(0.148f, 0.0f)));
        arrayList2.add(new zi2(new PointF(0.978f, 0.02f), new xe0(0.803f, 0.0f)));
        c(b(1, arrayList2, false));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new zi2(new PointF(0.5f, 0.892f), new xe0(0.313f, 0.0f)));
        arrayList3.add(new zi2(new PointF(-0.216f, 1.05f), new xe0(0.207f, 0.0f)));
        arrayList3.add(new zi2(new PointF(0.499f, -0.16f), new xe0(0.215f, 1.0f)));
        arrayList3.add(new zi2(new PointF(1.225f, 1.06f), new xe0(0.211f, 0.0f)));
        c(b(1, arrayList3, false));
        c(vf2.b(new float[]{0.8f, 0.5f, -0.8f, 0.5f, -0.8f, -0.5f, 0.8f, -0.5f}, xe0Var6, Arrays.asList(xe0Var2, xe0Var2, xe0Var5, xe0Var5), 0.0f, 0.0f));
        dm3 dm3VarR = gb4.r(15);
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, 0.64f);
        a = c(tj4.k0(tj4.k0(dm3VarR, matrix), a(-45.0f)));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new zi2(new PointF(0.961f, 0.039f), new xe0(0.426f, 0.0f)));
        arrayList4.add(new zi2(new PointF(1.001f, 0.428f)));
        arrayList4.add(new zi2(new PointF(1.0f, 0.609f), xe0Var5));
        b = c(b(2, arrayList4, true));
        c(tj4.k0(vf2.a(3, 1.0f, xe0Var2, null), a(-90.0f)));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new zi2(new PointF(0.5f, 1.096f), new xe0(0.151f, 0.524f)));
        arrayList5.add(new zi2(new PointF(0.04f, 0.5f), new xe0(0.159f, 0.0f)));
        c(b(2, arrayList5, false));
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new zi2(new PointF(0.171f, 0.841f), new xe0(0.159f, 0.0f)));
        arrayList6.add(new zi2(new PointF(-0.02f, 0.5f), new xe0(0.14f, 0.0f)));
        arrayList6.add(new zi2(new PointF(0.17f, 0.159f), new xe0(0.159f, 0.0f)));
        c(b(2, arrayList6, false));
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(new zi2(new PointF(0.5f, -0.009f), new xe0(0.172f, 0.0f)));
        c = c(b(5, arrayList7, false));
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(new zi2(new PointF(0.499f, 1.023f), new xe0(0.241f, 0.778f)));
        arrayList8.add(new zi2(new PointF(-0.005f, 0.792f), new xe0(0.208f, 0.0f)));
        arrayList8.add(new zi2(new PointF(0.073f, 0.258f), new xe0(0.228f, 0.0f)));
        arrayList8.add(new zi2(new PointF(0.433f, -0.0f), new xe0(0.491f, 0.0f)));
        c(tj4.k0(b(1, arrayList8, true), a(-90.0f)));
        d = c(gb4.Y(8, 0.8f, xe0Var));
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(new zi2(new PointF(0.5f, 1.08f), new xe0(0.085f, 0.0f)));
        arrayList9.add(new zi2(new PointF(0.358f, 0.843f), new xe0(0.085f, 0.0f)));
        c(b(8, arrayList9, false));
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(new zi2(new PointF(1.237f, 1.236f), new xe0(0.258f, 0.0f)));
        arrayList10.add(new zi2(new PointF(0.5f, 0.918f), new xe0(0.233f, 0.0f)));
        e = c(b(4, arrayList10, false));
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(new zi2(new PointF(0.723f, 0.884f), new xe0(0.394f, 0.0f)));
        arrayList11.add(new zi2(new PointF(0.5f, 1.099f), new xe0(0.398f, 0.0f)));
        c(b(6, arrayList11, false));
        c(tj4.k0(gb4.Y(7, 0.75f, xe0Var4), a(-90.0f)));
        f = c(tj4.k0(gb4.Y(9, 0.8f, xe0Var4), a(-90.0f)));
        c(tj4.k0(gb4.Y(12, 0.8f, xe0Var4), a(-90.0f)));
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(new zi2(new PointF(0.5f, 0.0f), xe0Var5));
        arrayList12.add(new zi2(new PointF(1.0f, 0.0f), xe0Var5));
        arrayList12.add(new zi2(new PointF(1.0f, 1.14f), new xe0(0.254f, 0.106f)));
        arrayList12.add(new zi2(new PointF(0.575f, 0.906f), new xe0(0.253f, 0.0f)));
        c(b(1, arrayList12, true));
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(new zi2(new PointF(0.5f, 0.074f)));
        arrayList13.add(new zi2(new PointF(0.725f, -0.099f), new xe0(0.476f, 0.0f)));
        c(b(4, arrayList13, true));
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(new zi2(new PointF(0.5f, 0.036f)));
        arrayList14.add(new zi2(new PointF(0.758f, -0.101f), new xe0(0.209f, 0.0f)));
        c(b(8, arrayList14, false));
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(new zi2(new PointF(0.5f, -0.006f), new xe0(0.006f, 0.0f)));
        arrayList15.add(new zi2(new PointF(0.592f, 0.158f), new xe0(0.006f, 0.0f)));
        c(b(12, arrayList15, false));
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(new zi2(new PointF(0.193f, 0.277f), new xe0(0.053f, 0.0f)));
        arrayList16.add(new zi2(new PointF(0.176f, 0.055f), new xe0(0.053f, 0.0f)));
        g = c(b(10, arrayList16, false));
        ArrayList arrayList17 = new ArrayList();
        arrayList17.add(new zi2(new PointF(0.457f, 0.296f), new xe0(0.007f, 0.0f)));
        arrayList17.add(new zi2(new PointF(0.5f, -0.051f), new xe0(0.007f, 0.0f)));
        c(b(15, arrayList17, false));
        ArrayList arrayList18 = new ArrayList();
        arrayList18.add(new zi2(new PointF(0.733f, 0.454f)));
        arrayList18.add(new zi2(new PointF(0.839f, 0.437f), new xe0(0.532f, 0.0f)));
        arrayList18.add(new zi2(new PointF(0.949f, 0.449f), new xe0(0.439f, 1.0f)));
        arrayList18.add(new zi2(new PointF(0.998f, 0.478f), new xe0(0.174f, 0.0f)));
        c(b(16, arrayList18, true));
        ArrayList arrayList19 = new ArrayList();
        arrayList19.add(new zi2(new PointF(0.37f, 0.187f)));
        arrayList19.add(new zi2(new PointF(0.416f, 0.049f), new xe0(0.381f, 0.0f)));
        arrayList19.add(new zi2(new PointF(0.479f, 0.0f), new xe0(0.095f, 0.0f)));
        c(b(8, arrayList19, true));
        ArrayList arrayList20 = new ArrayList();
        arrayList20.add(new zi2(new PointF(0.5f, 0.053f)));
        arrayList20.add(new zi2(new PointF(0.545f, -0.04f), new xe0(0.405f, 0.0f)));
        arrayList20.add(new zi2(new PointF(0.67f, -0.035f), new xe0(0.426f, 0.0f)));
        arrayList20.add(new zi2(new PointF(0.717f, 0.066f), new xe0(0.574f, 0.0f)));
        arrayList20.add(new zi2(new PointF(0.722f, 0.128f)));
        arrayList20.add(new zi2(new PointF(0.777f, 0.002f), new xe0(0.36f, 0.0f)));
        arrayList20.add(new zi2(new PointF(0.914f, 0.149f), new xe0(0.66f, 0.0f)));
        arrayList20.add(new zi2(new PointF(0.926f, 0.289f), new xe0(0.66f, 0.0f)));
        arrayList20.add(new zi2(new PointF(0.881f, 0.346f)));
        arrayList20.add(new zi2(new PointF(0.94f, 0.344f), new xe0(0.126f, 0.0f)));
        arrayList20.add(new zi2(new PointF(1.003f, 0.437f), new xe0(0.255f, 0.0f)));
        dm3 dm3VarB = b(2, arrayList20, true);
        Matrix matrix2 = new Matrix();
        matrix2.setScale(1.0f, 0.742f);
        c(tj4.k0(dm3VarB, matrix2));
        ArrayList arrayList21 = new ArrayList();
        arrayList21.add(new zi2(new PointF(0.87f, 0.13f), new xe0(0.146f, 0.0f)));
        arrayList21.add(new zi2(new PointF(0.818f, 0.357f)));
        arrayList21.add(new zi2(new PointF(1.0f, 0.332f), new xe0(0.853f, 0.0f)));
        c(b(4, arrayList21, true));
        ArrayList arrayList22 = new ArrayList();
        arrayList22.add(new zi2(new PointF(0.5f, 0.0f)));
        arrayList22.add(new zi2(new PointF(0.704f, 0.0f)));
        arrayList22.add(new zi2(new PointF(0.704f, 0.065f)));
        arrayList22.add(new zi2(new PointF(0.843f, 0.065f)));
        arrayList22.add(new zi2(new PointF(0.843f, 0.148f)));
        arrayList22.add(new zi2(new PointF(0.926f, 0.148f)));
        arrayList22.add(new zi2(new PointF(0.926f, 0.296f)));
        arrayList22.add(new zi2(new PointF(1.0f, 0.296f)));
        c(b(2, arrayList22, true));
        ArrayList arrayList23 = new ArrayList();
        arrayList23.add(new zi2(new PointF(0.11f, 0.5f)));
        arrayList23.add(new zi2(new PointF(0.113f, 0.0f)));
        arrayList23.add(new zi2(new PointF(0.287f, 0.0f)));
        arrayList23.add(new zi2(new PointF(0.287f, 0.087f)));
        arrayList23.add(new zi2(new PointF(0.421f, 0.087f)));
        arrayList23.add(new zi2(new PointF(0.421f, 0.17f)));
        arrayList23.add(new zi2(new PointF(0.56f, 0.17f)));
        arrayList23.add(new zi2(new PointF(0.56f, 0.265f)));
        arrayList23.add(new zi2(new PointF(0.674f, 0.265f)));
        arrayList23.add(new zi2(new PointF(0.675f, 0.344f)));
        arrayList23.add(new zi2(new PointF(0.789f, 0.344f)));
        arrayList23.add(new zi2(new PointF(0.789f, 0.439f)));
        arrayList23.add(new zi2(new PointF(0.888f, 0.439f)));
        c(b(1, arrayList23, true));
        ArrayList arrayList24 = new ArrayList();
        arrayList24.add(new zi2(new PointF(0.796f, 0.5f)));
        arrayList24.add(new zi2(new PointF(0.853f, 0.518f), xe0Var5));
        arrayList24.add(new zi2(new PointF(0.992f, 0.631f), xe0Var5));
        arrayList24.add(new zi2(new PointF(0.968f, 1.0f), xe0Var5));
        c(b(2, arrayList24, true));
        ArrayList arrayList25 = new ArrayList();
        arrayList25.add(new zi2(new PointF(0.5f, 0.268f), new xe0(0.016f, 0.0f)));
        arrayList25.add(new zi2(new PointF(0.792f, -0.066f), new xe0(0.958f, 0.0f)));
        arrayList25.add(new zi2(new PointF(1.064f, 0.276f), xe0Var5));
        arrayList25.add(new zi2(new PointF(0.501f, 0.946f), new xe0(0.129f, 0.0f)));
        c(b(1, arrayList25, true));
    }

    public static Matrix a(float f2) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f2);
        return matrix;
    }

    public static dm3 b(int i, ArrayList arrayList, boolean z) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PointF pointF = ((zi2) it.next()).a;
            pointF.offset(-0.5f, -0.5f);
            float fAtan2 = (float) Math.atan2(pointF.y, pointF.x);
            float fHypot = (float) Math.hypot(pointF.x, pointF.y);
            pointF.x = fAtan2;
            pointF.y = fHypot;
        }
        float f2 = (float) (6.283185307179586d / ((double) i));
        if (z) {
            int i2 = i * 2;
            float f3 = f2 / 2.0f;
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    boolean z2 = i3 % 2 != 0;
                    int size = z2 ? (arrayList.size() - 1) - i4 : i4;
                    zi2 zi2Var = (zi2) arrayList.get(size);
                    if (size > 0 || !z2) {
                        arrayList2.add(new zi2(new PointF((i3 * f3) + (z2 ? (((zi2) arrayList.get(0)).a.x * 2.0f) + (f3 - zi2Var.a.x) : zi2Var.a.x), zi2Var.a.y), zi2Var.b));
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < i; i5++) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    zi2 zi2Var2 = (zi2) it2.next();
                    arrayList2.add(new zi2(new PointF((i5 * f2) + zi2Var2.a.x, zi2Var2.a.y), zi2Var2.b));
                }
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            PointF pointF2 = ((zi2) it3.next()).a;
            float fCos = (float) ((Math.cos(pointF2.x) * ((double) pointF2.y)) + 0.5d);
            float fSin = (float) ((Math.sin(pointF2.x) * ((double) pointF2.y)) + 0.5d);
            pointF2.x = fCos;
            pointF2.y = fSin;
        }
        float[] fArr = new float[arrayList2.size() * 2];
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            int i7 = i6 * 2;
            fArr[i7] = ((zi2) arrayList2.get(i6)).a.x;
            fArr[i7 + 1] = ((zi2) arrayList2.get(i6)).a.y;
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            arrayList3.add(((zi2) arrayList2.get(i8)).b);
        }
        return vf2.b(fArr, xe0.c, arrayList3, 0.5f, 0.5f);
    }

    public static dm3 c(dm3 dm3Var) {
        return d(dm3Var, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
    }

    public static dm3 d(dm3 dm3Var, RectF rectF) {
        float[] fArr = new float[4];
        ub2 ub2Var = dm3Var.d;
        float f2 = dm3Var.c;
        float f3 = dm3Var.b;
        int iA = ub2Var.a();
        float fMax = 0.0f;
        for (int i = 0; i < iA; i++) {
            hg0 hg0Var = (hg0) ub2Var.get(i);
            float[] fArr2 = hg0Var.a;
            float f4 = fArr2[0] - f3;
            float f5 = fArr2[1] - f2;
            float f6 = eo4.b;
            float f7 = (f5 * f5) + (f4 * f4);
            long jC = hg0Var.c(0.5f);
            float fH = yr2.H(jC) - f3;
            float fI = yr2.I(jC) - f2;
            fMax = Math.max(fMax, Math.max(f7, (fI * fI) + (fH * fH)));
        }
        float fSqrt = (float) Math.sqrt(fMax);
        fArr[0] = f3 - fSqrt;
        fArr[1] = f2 - fSqrt;
        fArr[2] = f3 + fSqrt;
        fArr[3] = f2 + fSqrt;
        RectF rectF2 = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
        float fMin = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        matrix.preTranslate(-rectF2.centerX(), -rectF2.centerY());
        matrix.postTranslate(rectF.centerX(), rectF.centerY());
        return tj4.k0(dm3Var, matrix);
    }
}
