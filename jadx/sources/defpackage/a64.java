package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import io.sentry.android.core.a1;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a64 extends MenuInflater {
    public static final Class[] e;
    public static final Class[] f;
    public final Object[] a;
    public final Object[] b;
    public final Context c;
    public Object d;

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public a64(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        int resourceId;
        z54 z54Var = new z54(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    zo2.w("Expecting menu, got ".concat(name));
                    return;
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                zo2.w("Unexpected end of document");
                return;
            }
            Menu menu2 = z54Var.a;
            if (eventType != i) {
                if (eventType != 3) {
                    xmlPullParser2 = xmlPullParser;
                    z = z;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z2 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            z54Var.b = 0;
                            z54Var.c = 0;
                            z54Var.d = 0;
                            z54Var.e = 0;
                            z54Var.f = true;
                            z54Var.g = true;
                        } else if (name2.equals("item")) {
                            if (!z54Var.h) {
                                uk2 uk2Var = z54Var.z;
                                if (uk2Var == null || !uk2Var.b.hasSubMenu()) {
                                    z54Var.h = true;
                                    z54Var.b(menu2.add(z54Var.b, z54Var.i, z54Var.j, z54Var.k));
                                } else {
                                    z54Var.h = true;
                                    z54Var.b(menu2.addSubMenu(z54Var.b, z54Var.i, z54Var.j, z54Var.k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z = true;
                        }
                        xmlPullParser2 = xmlPullParser;
                        z = z;
                    }
                }
                eventType = xmlPullParser2.next();
                i = 2;
                z = z;
                z2 = z2;
            } else {
                if (!z2) {
                    String name3 = xmlPullParser.getName();
                    boolean zEquals = name3.equals("group");
                    Context context = this.c;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cd3.p);
                        z54Var.b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        z54Var.c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        z54Var.d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        z54Var.e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        z54Var.f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        z54Var.g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cd3.q);
                            z54Var.i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            z54Var.j = (typedArrayObtainStyledAttributes2.getInt(5, z54Var.c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, z54Var.d) & 65535);
                            z54Var.k = typedArrayObtainStyledAttributes2.getText(7);
                            z54Var.l = typedArrayObtainStyledAttributes2.getText(8);
                            z54Var.m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            z54Var.n = string == null ? (char) 0 : string.charAt(0);
                            z54Var.o = typedArrayObtainStyledAttributes2.getInt(16, 4096);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            z54Var.p = string2 == null ? (char) 0 : string2.charAt(0);
                            z54Var.q = typedArrayObtainStyledAttributes2.getInt(20, 4096);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                z54Var.r = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                z54Var.r = z54Var.e;
                            }
                            z54Var.s = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            z54Var.t = typedArrayObtainStyledAttributes2.getBoolean(4, z54Var.f);
                            z54Var.u = typedArrayObtainStyledAttributes2.getBoolean(1, z54Var.g);
                            z54Var.v = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            z54Var.y = typedArrayObtainStyledAttributes2.getString(12);
                            z54Var.w = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            z54Var.x = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z3 = string3 != null;
                            if (z3 && z54Var.w == 0 && z54Var.x == null) {
                                z54Var.z = (uk2) z54Var.a(string3, f, this.b);
                            } else {
                                if (z3) {
                                    a1.n("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                z54Var.z = null;
                            }
                            z54Var.A = typedArrayObtainStyledAttributes2.getText(17);
                            z54Var.B = typedArrayObtainStyledAttributes2.getText(22);
                            if (typedArrayObtainStyledAttributes2.hasValue(19)) {
                                z54Var.D = tx0.c(typedArrayObtainStyledAttributes2.getInt(19, -1), z54Var.D);
                            } else {
                                z54Var.D = null;
                            }
                            if (typedArrayObtainStyledAttributes2.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes2.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = v9.g(context, resourceId)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(18);
                                }
                                z54Var.C = colorStateList;
                            } else {
                                z54Var.C = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            z54Var.h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            z54Var.h = true;
                            SubMenu subMenuAddSubMenu = menu2.addSubMenu(z54Var.b, z54Var.i, z54Var.j, z54Var.k);
                            z54Var.b(subMenuAddSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            b(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z2 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i = 2;
                        z = z;
                        z2 = z2;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z = z;
            }
            eventType = xmlPullParser2.next();
            i = 2;
            z = z;
            z2 = z2;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof nk2)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.c.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof nk2) {
                    nk2 nk2Var = (nk2) menu;
                    if (!nk2Var.p) {
                        nk2Var.y();
                        z = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((nk2) menu).x();
                }
                layout.close();
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z) {
                ((nk2) menu).x();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
