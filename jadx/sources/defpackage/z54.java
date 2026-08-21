package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import io.sentry.android.core.a1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z54 {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ a64 E;
    public final Menu a;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public uk2 z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public boolean f = true;
    public boolean g = true;

    public z54(a64 a64Var, Menu menu) {
        this.E = a64Var;
        this.a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            a1.o("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        a64 a64Var = this.E;
        Context context = a64Var.c;
        boolean z = false;
        menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
        int i = this.v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.y != null) {
            if (context.isRestricted()) {
                xe.q("The android:onClick attribute cannot be used within a restricted context");
                return;
            }
            Object objA = a64Var.d;
            if (objA == null) {
                objA = a64.a(context);
                a64Var.d = objA;
            }
            String str = this.y;
            y54 y54Var = new y54();
            y54Var.f = objA;
            Class<?> cls = objA.getClass();
            try {
                y54Var.z = cls.getMethod(str, y54.A);
                menuItem.setOnMenuItemClickListener(y54Var);
            } catch (Exception e) {
                StringBuilder sbD = fw.D("Couldn't resolve menu item onClick handler ", str, " in class ");
                sbD.append(cls.getName());
                InflateException inflateException = new InflateException(sbD.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.r >= 2) {
            if (menuItem instanceof sk2) {
                ((sk2) menuItem).g(true);
            } else if (menuItem instanceof xk2) {
                xk2 xk2Var = (xk2) menuItem;
                b64 b64Var = xk2Var.c;
                try {
                    Method declaredMethod = xk2Var.d;
                    if (declaredMethod == null) {
                        declaredMethod = b64Var.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        xk2Var.d = declaredMethod;
                    }
                    declaredMethod.invoke(b64Var, Boolean.TRUE);
                } catch (Exception e2) {
                    a1.o("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                }
            }
        }
        String str2 = this.x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, a64.e, a64Var.a));
            z = true;
        }
        int i2 = this.w;
        if (i2 > 0) {
            if (z) {
                a1.n("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        uk2 uk2Var = this.z;
        if (uk2Var != null) {
            if (menuItem instanceof b64) {
                ((b64) menuItem).a(uk2Var);
            } else {
                a1.n("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z2 = menuItem instanceof b64;
        if (z2) {
            ((b64) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            v02.E(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z2) {
            ((b64) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            v02.N(menuItem, charSequence2);
        }
        char c = this.n;
        int i3 = this.o;
        if (z2) {
            ((b64) menuItem).setAlphabeticShortcut(c, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            v02.B(menuItem, c, i3);
        }
        char c2 = this.p;
        int i4 = this.q;
        if (z2) {
            ((b64) menuItem).setNumericShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            v02.J(menuItem, c2, i4);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z2) {
                ((b64) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                v02.I(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z2) {
                ((b64) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                v02.H(menuItem, colorStateList);
            }
        }
    }
}
