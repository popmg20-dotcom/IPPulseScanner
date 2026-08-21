package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bk3 {
    public final /* synthetic */ int a;

    public /* synthetic */ bk3(int i) {
        this.a = i;
    }

    public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        switch (this.a) {
            case 0:
                String classAttribute = attributeSet.getClassAttribute();
                if (classAttribute != null) {
                    try {
                        Drawable drawable = (Drawable) bk3.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                        m80.c(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                    } catch (Exception e) {
                        a1.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                        return null;
                    }
                }
                break;
            case 1:
                try {
                } catch (Exception e2) {
                    a1.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                    return null;
                }
                break;
            case 2:
                try {
                    Resources resources = context.getResources();
                    o8 o8Var = new o8(context, 0);
                    o8Var.inflate(resources, xmlResourceParser, attributeSet, theme);
                } catch (Exception e3) {
                    a1.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e3);
                    return null;
                }
                break;
            default:
                try {
                    Resources resources2 = context.getResources();
                    qo4 qo4Var = new qo4();
                    qo4Var.inflate(resources2, xmlResourceParser, attributeSet, theme);
                } catch (Exception e4) {
                    a1.e("VdcInflateDelegate", "Exception while inflating <vector>", e4);
                    return null;
                }
                break;
        }
        return null;
    }
}
