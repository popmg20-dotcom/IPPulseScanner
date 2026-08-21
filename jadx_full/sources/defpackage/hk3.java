package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hk3 {
    public static final ThreadLocal a = new ThreadLocal();
    public static final WeakHashMap b = new WeakHashMap(0);
    public static final Object c = new Object();

    public static void a(gk3 gk3Var, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (c) {
            try {
                WeakHashMap weakHashMap = b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(gk3Var);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(gk3Var, sparseArray);
                }
                sparseArray.append(i, new fk3(colorStateList, gk3Var.a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface b(Context context, int i, TypedValue typedValue, int i2, ji0 ji0Var, boolean z, boolean z2) throws Exception {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        Typeface typefaceA = null;
        if (string.startsWith("res/")) {
            int i3 = typedValue.assetCookie;
            if2 if2Var = dk4.b;
            Typeface typeface = (Typeface) if2Var.h(dk4.b(resources, i, string, i3, i2));
            int i4 = 18;
            if (typeface != null) {
                if (ji0Var != null) {
                    new Handler(Looper.getMainLooper()).post(new xy0(i4, ji0Var, typeface));
                }
                typefaceA = typeface;
            } else if (!z2) {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        gi1 gi1VarQ = ke0.q(resources.getXml(i), resources);
                        if (gi1VarQ == null) {
                            a1.d("ResourcesCompat", "Failed to find font-family tag");
                            if (ji0Var != null) {
                                ji0Var.c(-3);
                            }
                        } else {
                            typefaceA = dk4.a(context, gi1VarQ, resources, i, string, typedValue.assetCookie, i2, ji0Var, z);
                        }
                    } else {
                        int i5 = typedValue.assetCookie;
                        Typeface typefaceO = dk4.a.o(context, resources, i, string, i2);
                        if (typefaceO != null) {
                            if2Var.l(dk4.b(resources, i, string, i5, i2), typefaceO);
                        }
                        if (ji0Var != null) {
                            if (typefaceO != null) {
                                new Handler(Looper.getMainLooper()).post(new xy0(i4, ji0Var, typefaceO));
                            } else {
                                ji0Var.c(-3);
                            }
                        }
                        typefaceA = typefaceO;
                    }
                } catch (IOException e) {
                    a1.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e);
                    if (ji0Var != null) {
                        ji0Var.c(-3);
                    }
                } catch (XmlPullParserException e2) {
                    a1.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e2);
                    if (ji0Var != null) {
                    }
                }
            }
        } else if (ji0Var != null) {
            ji0Var.c(-3);
        }
        if (typefaceA != null || ji0Var != null || z2) {
            return typefaceA;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }
}
