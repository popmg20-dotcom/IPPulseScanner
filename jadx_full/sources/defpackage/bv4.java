package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import j$.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bv4 {
    public static final bv4 b;
    public final yu4 a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            b = wu4.w;
        } else if (i >= 30) {
            b = uu4.v;
        } else {
            b = yu4.b;
        }
    }

    public bv4(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            this.a = new xu4(this, windowInsets);
            return;
        }
        if (i >= 34) {
            this.a = new wu4(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.a = new vu4(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.a = new uu4(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new tu4(this, windowInsets);
        } else if (i >= 28) {
            this.a = new su4(this, windowInsets);
        } else {
            this.a = new ru4(this, windowInsets);
        }
    }

    public static t02 e(t02 t02Var, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, t02Var.a - i);
        int iMax2 = Math.max(0, t02Var.b - i2);
        int iMax3 = Math.max(0, t02Var.c - i3);
        int iMax4 = Math.max(0, t02Var.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? t02Var : t02.c(iMax, iMax2, iMax3, iMax4);
    }

    public static bv4 g(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        bv4 bv4Var = new bv4(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = wp4.a;
            bv4 bv4VarA = np4.a(view);
            yu4 yu4Var = bv4Var.a;
            yu4Var.w(bv4VarA);
            View rootView = view.getRootView();
            yu4Var.d(rootView);
            yu4Var.o(rootView);
            yu4Var.p();
            yu4Var.y(view.getWindowSystemUiVisibility());
        }
        return bv4Var;
    }

    public final int a() {
        return this.a.m().d;
    }

    public final int b() {
        return this.a.m().a;
    }

    public final int c() {
        return this.a.m().c;
    }

    public final int d() {
        return this.a.m().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bv4) {
            return Objects.equals(this.a, ((bv4) obj).a);
        }
        return false;
    }

    public final WindowInsets f() {
        yu4 yu4Var = this.a;
        if (yu4Var instanceof qu4) {
            return ((qu4) yu4Var).c;
        }
        return null;
    }

    public final int hashCode() {
        yu4 yu4Var = this.a;
        if (yu4Var == null) {
            return 0;
        }
        return yu4Var.hashCode();
    }

    public bv4() {
        this.a = new yu4(this);
    }
}
