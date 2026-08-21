package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.getsurfboard.R;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ck3 {
    public static ck3 i;
    public WeakHashMap a;
    public xw3 b;
    public tz3 c;
    public final WeakHashMap d = new WeakHashMap(0);
    public TypedValue e;
    public boolean f;
    public cm2 g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final ak3 j = new ak3(6);

    public static synchronized ck3 d() {
        try {
            if (i == null) {
                ck3 ck3Var = new ck3();
                i = ck3Var;
                j(ck3Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        ak3 ak3Var = j;
        ak3Var.getClass();
        int i3 = (31 + i2) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) ak3Var.h(Integer.valueOf(mode.hashCode() + i3));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
        }
        return porterDuffColorFilter;
    }

    public static void j(ck3 ck3Var) {
        if (Build.VERSION.SDK_INT < 24) {
            ck3Var.a("vector", new bk3(3));
            ck3Var.a("animated-vector", new bk3(2));
            ck3Var.a("animated-selector", new bk3(1));
            ck3Var.a("drawable", new bk3(0));
        }
    }

    public static void o(Drawable drawable, cb0 cb0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = cb0Var.b;
        if (z || cb0Var.a) {
            PorterDuffColorFilter porterDuffColorFilterH = null;
            ColorStateList colorStateList = z ? (ColorStateList) cb0Var.c : null;
            PorterDuff.Mode mode = cb0Var.a ? (PorterDuff.Mode) cb0Var.d : h;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilterH = h(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilterH);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final void a(String str, bk3 bk3Var) {
        xw3 xw3Var = this.b;
        if (xw3Var == null) {
            xw3Var = new xw3(0);
            this.b = xw3Var;
        }
        xw3Var.put(str, bk3Var);
    }

    public final synchronized void b(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                ff2 ff2Var = (ff2) this.d.get(context);
                if (ff2Var == null) {
                    ff2Var = new ff2();
                    this.d.put(context, ff2Var);
                }
                ff2Var.h(j2, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable c(Context context, int i2) {
        TypedValue typedValue = this.e;
        if (typedValue == null) {
            typedValue = new TypedValue();
            this.e = typedValue;
        }
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j2);
        if (drawableE != null) {
            return drawableE;
        }
        LayerDrawable layerDrawableR = null;
        if (this.g != null) {
            if (i2 == R.drawable.abc_cab_background_top_material) {
                layerDrawableR = new LayerDrawable(new Drawable[]{f(context, R.drawable.abc_cab_background_internal_bg), f(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i2 == R.drawable.abc_ratingbar_material) {
                layerDrawableR = cm2.r(this, context, R.dimen.abc_star_big);
            } else if (i2 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableR = cm2.r(this, context, R.dimen.abc_star_medium);
            } else if (i2 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableR = cm2.r(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableR != null) {
            layerDrawableR.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j2, layerDrawableR);
        }
        return layerDrawableR;
    }

    public final synchronized Drawable e(Context context, long j2) {
        ff2 ff2Var = (ff2) this.d.get(context);
        if (ff2Var == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) ff2Var.d(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            ff2Var.i(j2);
        }
        return null;
    }

    public final synchronized Drawable f(Context context, int i2) {
        return g(context, i2, false);
    }

    public final synchronized Drawable g(Context context, int i2, boolean z) {
        Drawable drawableK;
        try {
            if (!this.f) {
                this.f = true;
                Drawable drawableF = f(context, R.drawable.abc_vector_test);
                if (drawableF == null || (!(drawableF instanceof qo4) && !"android.graphics.drawable.VectorDrawable".equals(drawableF.getClass().getName()))) {
                    this.f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableK = k(context, i2);
            if (drawableK == null) {
                drawableK = c(context, i2);
            }
            if (drawableK == null) {
                drawableK = context.getDrawable(i2);
            }
            if (drawableK != null) {
                drawableK = n(context, i2, z, drawableK);
            }
            if (drawableK != null) {
                tx0.a(drawableK);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableK;
    }

    public final synchronized ColorStateList i(Context context, int i2) {
        ColorStateList colorStateList;
        tz3 tz3Var;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateListT = null;
        colorStateList = (weakHashMap == null || (tz3Var = (tz3) weakHashMap.get(context)) == null) ? null : (ColorStateList) vf2.f(tz3Var, i2);
        if (colorStateList == null) {
            cm2 cm2Var = this.g;
            if (cm2Var != null) {
                colorStateListT = cm2Var.t(context, i2);
            }
            if (colorStateListT != null) {
                WeakHashMap weakHashMap2 = this.a;
                if (weakHashMap2 == null) {
                    weakHashMap2 = new WeakHashMap();
                    this.a = weakHashMap2;
                }
                tz3 tz3Var2 = (tz3) weakHashMap2.get(context);
                if (tz3Var2 == null) {
                    tz3Var2 = new tz3();
                    this.a.put(context, tz3Var2);
                }
                tz3Var2.a(i2, colorStateListT);
            }
            colorStateList = colorStateListT;
        }
        return colorStateList;
    }

    public final Drawable k(Context context, int i2) {
        int next;
        xw3 xw3Var = this.b;
        if (xw3Var == null || xw3Var.isEmpty()) {
            return null;
        }
        tz3 tz3Var = this.c;
        if (tz3Var != null) {
            String str = (String) vf2.f(tz3Var, i2);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.b.get(str) == null) {
                return null;
            }
        } else {
            this.c = new tz3();
        }
        TypedValue typedValue = this.e;
        if (typedValue == null) {
            typedValue = new TypedValue();
            this.e = typedValue;
        }
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j2);
        if (drawableE != null) {
            return drawableE;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.c.a(i2, name);
                bk3 bk3Var = (bk3) this.b.get(name);
                if (bk3Var != null) {
                    drawableE = bk3Var.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableE != null) {
                    drawableE.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j2, drawableE);
                }
            } catch (Exception e) {
                a1.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableE == null) {
            this.c.a(i2, "appcompat_skip_skip");
        }
        return drawableE;
    }

    public final synchronized void l(Context context) {
        ff2 ff2Var = (ff2) this.d.get(context);
        if (ff2Var != null) {
            ff2Var.b();
        }
    }

    public final synchronized void m(cm2 cm2Var) {
        this.g = cm2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable n(android.content.Context r9, int r10, boolean r11, android.graphics.drawable.Drawable r12) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ck3.n(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
