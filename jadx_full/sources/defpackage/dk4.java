package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dk4 {
    public static final uf2 a;
    public static final if2 b;
    public static Paint c;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    static {
        Trace.beginSection(vo.O("TypefaceCompat static init"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            a = new jk4(23);
        } else if (i >= 29) {
            a = new ik4(23);
        } else if (i >= 28) {
            a = new hk4();
        } else if (i >= 26) {
            a = new gk4();
        } else if (i < 24) {
            a = new ek4(23);
        } else {
            Method method = fk4.C0;
            if (method == null) {
                a1.n("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                a = new fk4(23);
            }
        }
        b = new if2(16);
        c = null;
        Trace.endSection();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e7, code lost:
    
        r7 = r12.build();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface a(Context context, gi1 gi1Var, Resources resources, int i, String str, int i2, int i3, ji0 ji0Var, boolean z) {
        Typeface typefaceL;
        Typeface typefaceBuild;
        FontFamily fontFamilyBuild;
        int i4 = 18;
        int i5 = -3;
        if (gi1Var instanceof ji1) {
            ji1 ji1Var = (ji1) gi1Var;
            String str2 = ji1Var.d;
            typefaceL = null;
            int i6 = 0;
            if (TextUtils.isEmpty(str2) || (typefaceBuild = c(str2)) == null) {
                ArrayList arrayList = ji1Var.a;
                if (arrayList.size() == 1) {
                    typefaceBuild = c(((ai1) arrayList.get(0)).e);
                } else if (Build.VERSION.SDK_INT < 31) {
                    typefaceBuild = null;
                } else {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            Typeface.CustomFallbackBuilder customFallbackBuilder = null;
                            int i8 = 0;
                            while (true) {
                                if (i8 >= arrayList.size()) {
                                    break;
                                }
                                ai1 ai1Var = (ai1) arrayList.get(i8);
                                if (i8 == arrayList.size() - 1 && TextUtils.isEmpty(ai1Var.f)) {
                                    customFallbackBuilder.setSystemFallback(ai1Var.e);
                                    break;
                                }
                                String str3 = ai1Var.e;
                                String str4 = ai1Var.f;
                                Font fontD = d(c(str3));
                                if (fontD == null) {
                                    a1.n("TypefaceCompat", "Unable identify the primary font for " + ai1Var.e + ". Falling back to provider font.");
                                    break;
                                }
                                if (TextUtils.isEmpty(str4)) {
                                    fontFamilyBuild = new FontFamily.Builder(fontD).build();
                                } else {
                                    try {
                                        fontFamilyBuild = new FontFamily.Builder(k10.a(fontD).setFontVariationSettings(str4).build()).build();
                                    } catch (IOException unused) {
                                        a1.d("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                    }
                                }
                                if (customFallbackBuilder == null) {
                                    customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyBuild);
                                } else {
                                    customFallbackBuilder.addCustomFallback(fontFamilyBuild);
                                }
                                i8++;
                            }
                        } else {
                            if (c(((ai1) arrayList.get(i7)).e) == null) {
                                break;
                            }
                            i7++;
                        }
                    }
                    typefaceBuild = null;
                }
            }
            if (typefaceBuild != null) {
                if (ji0Var != null) {
                    new Handler(Looper.getMainLooper()).post(new xy0(i4, ji0Var, typefaceBuild));
                }
                b.l(b(resources, i, str, i2, i3), typefaceBuild);
                return typefaceBuild;
            }
            boolean z2 = !z ? ji0Var != null : ji1Var.c != 0;
            int i9 = z ? ji1Var.b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            ub4 ub4Var = new ub4();
            ub4Var.b = ji0Var;
            ArrayList arrayList2 = ji1Var.a;
            x61 x61Var = new x61(handler, 1);
            lb lbVar = new lb(i4, ub4Var, x61Var);
            int i10 = 4;
            if (!z2) {
                String strA = fi1.a(i3, arrayList2);
                Typeface typeface = (Typeface) fi1.a.h(strA);
                if (typeface != null) {
                    x61Var.execute(new um1(i10, ub4Var, typeface));
                    typefaceL = typeface;
                } else {
                    i01 i01Var = new i01(1, lbVar);
                    synchronized (fi1.c) {
                        try {
                            xw3 xw3Var = fi1.d;
                            ArrayList arrayList3 = (ArrayList) xw3Var.get(strA);
                            if (arrayList3 != null) {
                                arrayList3.add(i01Var);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(i01Var);
                                xw3Var.put(strA, arrayList4);
                                di1 di1Var = new di1(strA, context, arrayList2, i3, 1);
                                ThreadPoolExecutor threadPoolExecutor = fi1.b;
                                i01 i01Var2 = new i01(2, strA);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                g33 g33Var = new g33();
                                g33Var.f = di1Var;
                                g33Var.z = i01Var2;
                                g33Var.A = handler2;
                                threadPoolExecutor.execute(g33Var);
                            }
                        } finally {
                        }
                    }
                }
            } else {
                if (arrayList2.size() > 1) {
                    xe.k("Fallbacks with blocking fetches are not supported for performance reasons");
                    return null;
                }
                ai1 ai1Var2 = (ai1) arrayList2.get(0);
                if2 if2Var = fi1.a;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj = new Object[]{ai1Var2}[0];
                Objects.requireNonNull(obj);
                arrayList5.add(obj);
                String strA2 = fi1.a(i3, DesugarCollections.unmodifiableList(arrayList5));
                Typeface typeface2 = (Typeface) fi1.a.h(strA2);
                if (typeface2 != null) {
                    x61Var.execute(new um1(i10, ub4Var, typeface2));
                    typefaceL = typeface2;
                } else if (i9 == -1) {
                    Object[] objArr = {ai1Var2};
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    arrayList6.add(obj2);
                    ei1 ei1VarB = fi1.b(strA2, context, DesugarCollections.unmodifiableList(arrayList6), i3);
                    lbVar.E(ei1VarB);
                    typefaceL = ei1VarB.a;
                } else {
                    try {
                        try {
                            try {
                                ei1 ei1Var = (ei1) fi1.b.submit(new di1(strA2, context, ai1Var2, i3, 0)).get(i9, TimeUnit.MILLISECONDS);
                                lbVar.E(ei1Var);
                                typefaceL = ei1Var.a;
                            } catch (InterruptedException e) {
                                throw e;
                            }
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        } catch (TimeoutException unused2) {
                            throw new InterruptedException(RtspHeaders.Values.TIMEOUT);
                        }
                    } catch (InterruptedException unused3) {
                        ((x61) lbVar.z).execute(new zv(i5, i6, (ub4) lbVar.f));
                    }
                }
            }
        } else {
            typefaceL = a.l(context, (hi1) gi1Var, resources, i3);
            if (ji0Var != null) {
                if (typefaceL != null) {
                    new Handler(Looper.getMainLooper()).post(new xy0(i4, ji0Var, typefaceL));
                } else {
                    ji0Var.c(-3);
                }
            }
        }
        if (typefaceL != null) {
            b.l(b(resources, i, str, i2, i3), typefaceL);
        }
        return typefaceL;
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        Paint paint = c;
        if (paint == null) {
            paint = new Paint();
            c = paint;
        }
        paint.setTextSize(10.0f);
        c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
