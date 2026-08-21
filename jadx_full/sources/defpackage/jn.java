package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import io.netty.channel.internal.ChannelUtils;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jn implements nk0 {
    public final j62 a;
    public final rw2 b;
    public final ns3 c;

    public jn(j62 j62Var, rw2 rw2Var, ns3 ns3Var) {
        this.a = j62Var;
        this.b = rw2Var;
        this.c = ns3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final gk0 b(jn jnVar) throws Exception {
        b71 b71Var;
        Context context;
        boolean z;
        int i;
        boolean z2;
        int iMin;
        double dMax;
        Exception exc;
        Bitmap bitmapCreateBitmap;
        ColorSpace colorSpace;
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        rw2 rw2Var = jnVar.b;
        j62 j62Var = jnVar.a;
        gn gnVar = new gn(j62Var.n());
        he3 he3Var = new he3(gnVar);
        options.inJustDecodeBounds = true;
        int i3 = 2;
        BitmapFactory.decodeStream(new gp(he3Var.peek(), i3), null, options);
        Exception exc2 = gnVar.f;
        if (exc2 != null) {
            throw exc2;
        }
        options.inJustDecodeBounds = false;
        Paint paint = l71.a;
        String str = options.outMimeType;
        Set set = m71.a;
        if (str == null || !m71.a.contains(str)) {
            b71Var = b71.c;
        } else {
            i71 i71Var = new i71(new j71(new gp(he3Var.peek(), i3)));
            int iC = i71Var.c(1, "Orientation");
            boolean z3 = iC == 2 || iC == 7 || iC == 4 || iC == 5;
            switch (i71Var.c(1, "Orientation")) {
                case 3:
                case 4:
                    i2 = 180;
                    break;
                case 5:
                case 8:
                    i2 = 270;
                    break;
                case 6:
                case 7:
                    i2 = 90;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            b71Var = new b71(z3, i2);
        }
        int i4 = b71Var.a;
        boolean z4 = b71Var.b;
        Exception exc3 = gnVar.f;
        if (exc3 != null) {
            throw exc3;
        }
        options.inMutable = false;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26 && (colorSpace = rw2Var.c) != null) {
            options.inPreferredColorSpace = colorSpace;
        }
        boolean z5 = rw2Var.h;
        Context context2 = rw2Var.a;
        wx3 wx3Var = rw2Var.d;
        options.inPremultiplied = z5;
        Bitmap.Config config = rw2Var.b;
        if ((z4 || i4 > 0) && (config == null || v02.q(config))) {
            config = Bitmap.Config.ARGB_8888;
        }
        if (rw2Var.g && config == Bitmap.Config.ARGB_8888 && n12.c(options.outMimeType, "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        if (i5 >= 26) {
            Bitmap.Config config2 = options.outConfig;
            Bitmap.Config config3 = Bitmap.Config.RGBA_F16;
            if (config2 == config3 && config != Bitmap.Config.HARDWARE) {
                config = config3;
            }
        }
        options.inPreferredConfig = config;
        fx3 fx3VarG = j62Var.g();
        try {
            if (!(fx3VarG instanceof dk3) || !n12.c(wx3Var, wx3.c)) {
                int i6 = options.outWidth;
                if (i6 > 0) {
                    int i7 = options.outHeight;
                    if (i7 <= 0) {
                        i = 1;
                        context = context2;
                        z = z4;
                    } else {
                        int i8 = (i4 == 90 || i4 == 270) ? i7 : i6;
                        if (i4 != 90 && i4 != 270) {
                            i6 = i7;
                        }
                        sp3 sp3Var = rw2Var.e;
                        wx3 wx3Var2 = wx3.c;
                        int iE = n12.c(wx3Var, wx3Var2) ? i8 : j.e(wx3Var.a, sp3Var);
                        int iE2 = n12.c(wx3Var, wx3Var2) ? i6 : j.e(wx3Var.b, sp3Var);
                        int iHighestOneBit = Integer.highestOneBit(i8 / iE);
                        int iHighestOneBit2 = Integer.highestOneBit(i6 / iE2);
                        int iOrdinal = sp3Var.ordinal();
                        if (iOrdinal == 0) {
                            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
                        } else {
                            if (iOrdinal != 1) {
                                g.d();
                                return null;
                            }
                            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
                        }
                        if (iMin < 1) {
                            iMin = 1;
                        }
                        options.inSampleSize = iMin;
                        context = context2;
                        z = z4;
                        double d = iMin;
                        double d2 = ((double) iE) / (((double) i8) / d);
                        double d3 = ((double) iE2) / (((double) i6) / d);
                        int iOrdinal2 = sp3Var.ordinal();
                        if (iOrdinal2 == 0) {
                            dMax = Math.max(d2, d3);
                        } else {
                            if (iOrdinal2 != 1) {
                                g.d();
                                return null;
                            }
                            dMax = Math.min(d2, d3);
                        }
                        if (rw2Var.f && dMax > 1.0d) {
                            dMax = 1.0d;
                        }
                        boolean z6 = dMax == 1.0d;
                        options.inScaled = !z6;
                        if (!z6) {
                            if (dMax > 1.0d) {
                                options.inDensity = vf2.A(2.147483647E9d / dMax);
                                options.inTargetDensity = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                            } else {
                                options.inDensity = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                                options.inTargetDensity = vf2.A(2.147483647E9d * dMax);
                            }
                        }
                    }
                } else {
                    context = context2;
                    z = z4;
                    i = 1;
                }
                options.inSampleSize = i;
                z2 = false;
                options.inScaled = false;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new gp(he3Var, 2), null, options);
                he3Var.close();
                exc = gnVar.f;
                if (exc == null) {
                    throw exc;
                }
                if (bitmapDecodeStream == null) {
                    xe.q("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                    return null;
                }
                bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                if (z || i4 > 0) {
                    Matrix matrix = new Matrix();
                    float width = bitmapDecodeStream.getWidth() / 2.0f;
                    float height = bitmapDecodeStream.getHeight() / 2.0f;
                    if (z) {
                        matrix.postScale(-1.0f, 1.0f, width, height);
                    }
                    if (i4 > 0) {
                        matrix.postRotate(i4, width, height);
                    }
                    RectF rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                    matrix.mapRect(rectF);
                    float f = rectF.left;
                    if (f != 0.0f || rectF.top != 0.0f) {
                        matrix.postTranslate(-f, -rectF.top);
                    }
                    if (i4 == 90 || i4 == 270) {
                        int height2 = bitmapDecodeStream.getHeight();
                        int width2 = bitmapDecodeStream.getWidth();
                        Bitmap.Config config4 = bitmapDecodeStream.getConfig();
                        if (config4 == null) {
                            config4 = Bitmap.Config.ARGB_8888;
                        }
                        bitmapCreateBitmap = Bitmap.createBitmap(height2, width2, config4);
                    } else {
                        int width3 = bitmapDecodeStream.getWidth();
                        int height3 = bitmapDecodeStream.getHeight();
                        Bitmap.Config config5 = bitmapDecodeStream.getConfig();
                        if (config5 == null) {
                            config5 = Bitmap.Config.ARGB_8888;
                        }
                        bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, config5);
                    }
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, l71.a);
                    bitmapDecodeStream.recycle();
                    bitmapDecodeStream = bitmapCreateBitmap;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                if (options.inSampleSize > 1 || options.inScaled) {
                    z2 = true;
                }
                return new gk0(bitmapDrawable, z2);
            }
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((dk3) fx3VarG).X;
            options.inTargetDensity = context2.getResources().getDisplayMetrics().densityDpi;
            context = context2;
            z = z4;
            Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(new gp(he3Var, 2), null, options);
            he3Var.close();
            exc = gnVar.f;
            if (exc == null) {
            }
        } finally {
        }
        z2 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ie0 ie0Var) {
        in inVar;
        ns3 ns3Var;
        Throwable th;
        ns3 ns3Var2;
        if (ie0Var instanceof in) {
            inVar = (in) ie0Var;
            int i = inVar.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                inVar.y0 = i - Integer.MIN_VALUE;
            } else {
                inVar = new in(this, ie0Var);
            }
        }
        Object obj = inVar.Y;
        int i2 = inVar.y0;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        try {
            if (i2 == 0) {
                n12.S(obj);
                inVar.A = this;
                ns3Var = this.c;
                inVar.X = ns3Var;
                inVar.y0 = 1;
                if (ns3Var.a(inVar) != mf0Var) {
                }
                return mf0Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ns3Var2 = (ns3) inVar.A;
                try {
                    n12.S(obj);
                    gk0 gk0Var = (gk0) obj;
                    ns3Var2.c();
                    return gk0Var;
                } catch (Throwable th2) {
                    th = th2;
                    ns3Var2.c();
                    throw th;
                }
            }
            ns3 ns3Var3 = inVar.X;
            jn jnVar = (jn) inVar.A;
            n12.S(obj);
            ns3Var = ns3Var3;
            this = jnVar;
            fn fnVar = new fn(0, this);
            inVar.A = ns3Var;
            inVar.X = null;
            inVar.y0 = 2;
            Object objB0 = ji0.b0(c41.b, new gd(fnVar, ge0Var, 8), inVar);
            if (objB0 != mf0Var) {
                ns3 ns3Var4 = ns3Var;
                obj = objB0;
                ns3Var2 = ns3Var4;
                gk0 gk0Var2 = (gk0) obj;
                ns3Var2.c();
                return gk0Var2;
            }
            return mf0Var;
        } catch (Throwable th3) {
            ns3 ns3Var5 = ns3Var;
            th = th3;
            ns3Var2 = ns3Var5;
            ns3Var2.c();
            throw th;
        }
    }
}
