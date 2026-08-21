package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.UserHandle;
import android.util.SparseArray;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class vk implements AutoCloseable {
    public static final boolean B0;
    public static final int C0;
    public final PackageManager A;
    public final boolean A0;
    public final iv1 X;
    public boolean Y;
    public final int Z;
    public final Rect b = new Rect();
    public final Context f;
    public ax1 y0;
    public final Canvas z;
    public lw2 z0;

    static {
        B0 = Build.VERSION.SDK_INT >= 26;
        C0 = Color.rgb(245, 245, 245);
    }

    public vk(Context context, int i) {
        Paint paint = new Paint(3);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.A0 = true;
        this.Z = i;
        this.A = applicationContext.getPackageManager();
        this.X = new iv1(5);
        Canvas canvas = new Canvas();
        this.z = canvas;
        canvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(C0);
        paint.setTextSize(context.getResources().getDisplayMetrics().density * 20.0f);
        this.Y = false;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.Y = false;
    }

    public final w7 g(Drawable drawable, UserHandle userHandle, float[] fArr) {
        Drawable drawable2 = drawable;
        char c = 1;
        float[] fArr2 = fArr == null ? new float[1] : fArr;
        int i = 0;
        if (drawable2 == null) {
            drawable2 = null;
        } else {
            ax1 ax1Var = this.y0;
            if (ax1Var == null) {
                ax1Var = new ax1(this.f, this.Z, this.A0);
                this.y0 = ax1Var;
            }
            fArr2[0] = ax1Var.c(drawable2, null, null);
        }
        Bitmap bitmapN = n(drawable2, fArr2[0]);
        if (B0 && (drawable2 instanceof AdaptiveIconDrawable)) {
            this.z.setBitmap(bitmapN);
            lw2 lw2Var = this.z0;
            if (lw2Var == null) {
                lw2Var = new lw2(this.Z);
                this.z0 = lw2Var;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapN);
            Canvas canvas = this.z;
            synchronized (lw2Var) {
                lw2Var.i(bitmapCreateBitmap, (BlurMaskFilter) lw2Var.e, canvas);
            }
            this.z.setBitmap(null);
        }
        if (userHandle != null) {
            Drawable userBadgedIcon = this.A.getUserBadgedIcon(new uk(null, bitmapN), userHandle);
            bitmapN = userBadgedIcon instanceof BitmapDrawable ? ((BitmapDrawable) userBadgedIcon).getBitmap() : n(userBadgedIcon, 1.0f);
        }
        if (!this.Y) {
            iv1 iv1Var = this.X;
            iv1Var.getClass();
            int height = bitmapN.getHeight();
            int width = bitmapN.getWidth();
            int iSqrt = (int) Math.sqrt((height * width) / 20);
            if (iSqrt < 1) {
                iSqrt = 1;
            }
            float[] fArr3 = (float[]) iv1Var.f;
            Arrays.fill(fArr3, 0.0f);
            float[] fArr4 = (float[]) iv1Var.z;
            Arrays.fill(fArr4, 0.0f);
            int[] iArr = (int[]) iv1Var.A;
            Arrays.fill(iArr, 0);
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            float f = -1.0f;
            while (i3 < height) {
                char c2 = c;
                int i5 = i;
                while (i5 < width) {
                    int pixel = bitmapN.getPixel(i5, i3);
                    int i6 = i;
                    if (((pixel >> 24) & DnsRecord.CLASS_ANY) >= 128) {
                        int i7 = pixel | (-16777216);
                        Color.colorToHSV(i7, fArr3);
                        int i8 = (int) fArr3[i6];
                        if (i8 >= 0 && i8 < fArr4.length) {
                            if (i4 < 20) {
                                iArr[i4] = i7;
                                i4++;
                            }
                            float f2 = fArr4[i8] + (fArr3[c2] * fArr3[2]);
                            fArr4[i8] = f2;
                            if (f2 > f) {
                                i2 = i8;
                                f = f2;
                            }
                        }
                    }
                    i5 += iSqrt;
                    i = i6;
                }
                i3 += iSqrt;
                c = c2;
            }
            char c3 = c;
            int i9 = i;
            SparseArray sparseArray = (SparseArray) iv1Var.X;
            sparseArray.clear();
            float f3 = -1.0f;
            for (int i10 = i9; i10 < i4; i10++) {
                Color.colorToHSV(iArr[i10], fArr3);
                if (((int) fArr3[i9]) == i2) {
                    float f4 = fArr3[c3];
                    float f5 = fArr3[2];
                    int i11 = ((int) (100.0f * f4)) + ((int) (10000.0f * f5));
                    float fFloatValue = f4 * f5;
                    Float f6 = (Float) sparseArray.get(i11);
                    if (f6 != null) {
                        fFloatValue += f6.floatValue();
                    }
                    sparseArray.put(i11, Float.valueOf(fFloatValue));
                    if (fFloatValue > f3) {
                        f3 = fFloatValue;
                    }
                }
            }
        }
        return new w7(12, bitmapN);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap n(android.graphics.drawable.Drawable r8, float r9) {
        /*
            r7 = this;
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            int r1 = r7.Z
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r1, r0)
            if (r8 != 0) goto Lb
            return r0
        Lb:
            android.graphics.Canvas r2 = r7.z
            r2.setBitmap(r0)
            android.graphics.Rect r3 = r8.getBounds()
            android.graphics.Rect r4 = r7.b
            r4.set(r3)
            boolean r3 = defpackage.vk.B0
            if (r3 == 0) goto L4f
            boolean r3 = r8 instanceof android.graphics.drawable.AdaptiveIconDrawable
            if (r3 == 0) goto L4f
            float r7 = (float) r1
            r3 = 1009429163(0x3c2aaaab, float:0.010416667)
            float r3 = r3 * r7
            double r5 = (double) r3
            double r5 = java.lang.Math.ceil(r5)
            int r3 = (int) r5
            r5 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 - r9
            float r5 = r5 * r7
            r7 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r7
            int r7 = java.lang.Math.round(r5)
            int r7 = java.lang.Math.max(r3, r7)
            int r9 = r7 * 2
            int r1 = r1 - r9
            r9 = 0
            r8.setBounds(r9, r9, r1, r1)
            float r9 = (float) r7
            r2.translate(r9, r9)
            r8.draw(r2)
            int r7 = -r7
            float r7 = (float) r7
            r2.translate(r7, r7)
            goto Lab
        L4f:
            boolean r3 = r8 instanceof android.graphics.drawable.BitmapDrawable
            if (r3 == 0) goto L6f
            r3 = r8
            android.graphics.drawable.BitmapDrawable r3 = (android.graphics.drawable.BitmapDrawable) r3
            android.graphics.Bitmap r5 = r3.getBitmap()
            if (r0 == 0) goto L6f
            int r5 = r5.getDensity()
            if (r5 != 0) goto L6f
            android.content.Context r7 = r7.f
            android.content.res.Resources r7 = r7.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            r3.setTargetDensity(r7)
        L6f:
            int r7 = r8.getIntrinsicWidth()
            int r3 = r8.getIntrinsicHeight()
            if (r7 <= 0) goto L8d
            if (r3 <= 0) goto L8d
            float r5 = (float) r7
            float r6 = (float) r3
            float r5 = r5 / r6
            if (r7 <= r3) goto L86
            float r7 = (float) r1
            float r7 = r7 / r5
            int r7 = (int) r7
            r3 = r7
            r7 = r1
            goto L8f
        L86:
            if (r3 <= r7) goto L8d
            float r7 = (float) r1
            float r7 = r7 * r5
            int r7 = (int) r7
            r3 = r1
            goto L8f
        L8d:
            r7 = r1
            r3 = r7
        L8f:
            int r5 = r1 - r7
            int r5 = r5 / 2
            int r6 = r1 - r3
            int r6 = r6 / 2
            int r7 = r7 + r5
            int r3 = r3 + r6
            r8.setBounds(r5, r6, r7, r3)
            r2.save()
            int r1 = r1 / 2
            float r7 = (float) r1
            r2.scale(r9, r9, r7, r7)
            r8.draw(r2)
            r2.restore()
        Lab:
            r8.setBounds(r4)
            r7 = 0
            r2.setBitmap(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vk.n(android.graphics.drawable.Drawable, float):android.graphics.Bitmap");
    }
}
