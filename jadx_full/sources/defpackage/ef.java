package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.webkit.MimeTypeMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ef implements gd1 {
    public final /* synthetic */ int a;
    public final Uri b;
    public final rw2 c;

    public /* synthetic */ ef(Uri uri, rw2 rw2Var, int i) {
        this.a = i;
        this.b = uri;
        this.c = rw2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x011d  */
    @Override // defpackage.gd1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ge0 ge0Var) throws Throwable {
        Integer numM0;
        Drawable drawable;
        Drawable o8Var;
        int i = this.a;
        Uri uri = this.b;
        rw2 rw2Var = this.c;
        pi0 pi0Var = pi0.z;
        switch (i) {
            case 0:
                String strJ0 = d70.j0(d70.Y(uri.getPathSegments()), "/", null, null, null, 62);
                return new pz3(new nz3(new he3(tj4.d0(rw2Var.a.getAssets().open(strJ0))), new cf()), j.b(MimeTypeMap.getSingleton(), strJ0), pi0Var);
            default:
                String authority = uri.getAuthority();
                if (authority != null) {
                    if (p44.x0(authority)) {
                        authority = null;
                    }
                    if (authority != null) {
                        String str = (String) d70.l0(uri.getPathSegments());
                        if (str == null || (numM0 = w44.m0(str)) == null) {
                            s53.j(uri, "Invalid android.resource URI: ");
                            return null;
                        }
                        int iIntValue = numM0.intValue();
                        Context context = rw2Var.a;
                        Resources resources = authority.equals(context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
                        TypedValue typedValue = new TypedValue();
                        boolean z = true;
                        resources.getValue(iIntValue, typedValue, true);
                        CharSequence charSequence = typedValue.string;
                        String strB = j.b(MimeTypeMap.getSingleton(), charSequence.subSequence(p44.z0(charSequence, '/', 0, 6), charSequence.length()).toString());
                        if (!n12.c(strB, "text/xml")) {
                            TypedValue typedValue2 = new TypedValue();
                            return new pz3(new nz3(new he3(tj4.d0(resources.openRawResource(iIntValue, typedValue2))), new dk3(typedValue2.density)), strB, pi0Var);
                        }
                        if (authority.equals(context.getPackageName())) {
                            drawable = vo.r(context, iIntValue);
                            if (drawable == null) {
                                g.g(dw2.A(iIntValue, "Invalid resource ID: "));
                                return null;
                            }
                        } else {
                            XmlResourceParser xml = resources.getXml(iIntValue);
                            int next = xml.next();
                            while (next != 2 && next != 1) {
                                next = xml.next();
                            }
                            if (next != 2) {
                                throw new XmlPullParserException("No start tag found.");
                            }
                            if (Build.VERSION.SDK_INT < 24) {
                                String name = xml.getName();
                                if (n12.c(name, "vector")) {
                                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                                    Resources.Theme theme = context.getTheme();
                                    o8Var = new qo4();
                                    o8Var.inflate(resources, xml, attributeSetAsAttributeSet, theme);
                                } else {
                                    if (n12.c(name, "animated-vector")) {
                                        AttributeSet attributeSetAsAttributeSet2 = Xml.asAttributeSet(xml);
                                        Resources.Theme theme2 = context.getTheme();
                                        o8Var = new o8(context, 0);
                                        o8Var.inflate(resources, xml, attributeSetAsAttributeSet2, theme2);
                                    }
                                    Resources.Theme theme3 = context.getTheme();
                                    ThreadLocal threadLocal = hk3.a;
                                    drawable = resources.getDrawable(iIntValue, theme3);
                                    if (drawable == null) {
                                        g.g(dw2.A(iIntValue, "Invalid resource ID: "));
                                        return null;
                                    }
                                }
                                drawable = o8Var;
                            } else {
                                Resources.Theme theme32 = context.getTheme();
                                ThreadLocal threadLocal2 = hk3.a;
                                drawable = resources.getDrawable(iIntValue, theme32);
                                if (drawable == null) {
                                }
                            }
                        }
                        if (!(drawable instanceof VectorDrawable) && !(drawable instanceof qo4)) {
                            z = false;
                        }
                        if (z) {
                            drawable = new BitmapDrawable(context.getResources(), ji0.h(drawable, rw2Var.b, rw2Var.d, rw2Var.e, rw2Var.f));
                        }
                        return new ox0(drawable, z, pi0Var);
                    }
                }
                s53.j(uri, "Invalid android.resource URI: ");
                return null;
        }
    }
}
