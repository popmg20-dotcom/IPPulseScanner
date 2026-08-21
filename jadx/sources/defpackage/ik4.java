package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ik4 extends uf2 {
    public static Font U(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iX = X(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iX2 = X(fontStyle, font2.getStyle());
            if (iX2 < iX) {
                font = font2;
                iX = iX2;
            }
        }
        return font;
    }

    public static int X(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public final FontFamily V(ki1[] ki1VarArr, ContentResolver contentResolver) {
        Font fontBuild;
        String str;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (ki1 ki1Var : ki1VarArr) {
            if (Objects.equals(ki1Var.a.getScheme(), "systemfont")) {
                fontBuild = W(ki1Var);
            } else {
                try {
                    Uri uri = ki1Var.a;
                    str = ki1Var.e;
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e) {
                    a1.o("TypefaceCompatApi29Impl", "Font load failed", e);
                    fontBuild = null;
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    fontBuild = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(ki1Var.c).setSlant(ki1Var.d ? 1 : 0).setTtcIndex(ki1Var.b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        fontBuild = ttcIndex.build();
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font W(ki1 ki1Var) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // defpackage.uf2
    public final Typeface l(Context context, hi1 hi1Var, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (ii1 ii1Var : hi1Var.a) {
                try {
                    Font fontBuild = new Font.Builder(resources, ii1Var.f).setWeight(ii1Var.b).setSlant(ii1Var.c ? 1 : 0).setTtcIndex(ii1Var.e).setFontVariationSettings(ii1Var.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(U(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception e) {
            a1.o("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.uf2
    public final Typeface m(Context context, ki1[] ki1VarArr, int i) {
        try {
            FontFamily fontFamilyV = V(ki1VarArr, context.getContentResolver());
            if (fontFamilyV == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyV).setStyle(U(fontFamilyV, i).getStyle()).build();
        } catch (Exception e) {
            a1.o("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.uf2
    public final Typeface n(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyV = V((ki1[]) list.get(0), contentResolver);
            if (fontFamilyV == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyV);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily fontFamilyV2 = V((ki1[]) list.get(i2), contentResolver);
                if (fontFamilyV2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyV2);
                }
            }
            return customFallbackBuilder.setStyle(U(fontFamilyV, i).getStyle()).build();
        } catch (Exception e) {
            a1.o("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.uf2
    public final Typeface o(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e) {
            a1.o("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }
}
