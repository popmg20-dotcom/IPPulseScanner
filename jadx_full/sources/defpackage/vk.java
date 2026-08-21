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
    */
    public final Bitmap n(Drawable drawable, float f) {
        int i;
        int i2;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        int i3 = this.Z;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i3, config);
        if (drawable == null) {
            return bitmapCreateBitmap;
        }
        Canvas canvas = this.z;
        canvas.setBitmap(bitmapCreateBitmap);
        Rect bounds = drawable.getBounds();
        Rect rect = this.b;
        rect.set(bounds);
        if (B0 && (drawable instanceof AdaptiveIconDrawable)) {
            int iMax = Math.max((int) Math.ceil(0.010416667f * r7), Math.round(((1.0f - f) * i3) / 2.0f));
            int i4 = i3 - (iMax * 2);
            drawable.setBounds(0, 0, i4, i4);
            float f2 = iMax;
            canvas.translate(f2, f2);
            drawable.draw(canvas);
            float f3 = -iMax;
            canvas.translate(f3, f3);
        } else {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (bitmapCreateBitmap != null && bitmap.getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(this.f.getResources().getDisplayMetrics());
                }
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                i = i3;
                i2 = i;
                int i5 = (i3 - i) / 2;
                int i6 = (i3 - i2) / 2;
                drawable.setBounds(i5, i6, i + i5, i2 + i6);
                canvas.save();
                float f4 = i3 / 2;
                canvas.scale(f, f, f4, f4);
                drawable.draw(canvas);
                canvas.restore();
            } else {
                float f5 = intrinsicWidth / intrinsicHeight;
                if (intrinsicWidth > intrinsicHeight) {
                    i2 = (int) (i3 / f5);
                    i = i3;
                } else if (intrinsicHeight > intrinsicWidth) {
                    i = (int) (i3 * f5);
                    i2 = i3;
                }
                int i52 = (i3 - i) / 2;
                int i62 = (i3 - i2) / 2;
                drawable.setBounds(i52, i62, i + i52, i2 + i62);
                canvas.save();
                float f42 = i3 / 2;
                canvas.scale(f, f, f42, f42);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
        drawable.setBounds(rect);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }
}
