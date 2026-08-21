package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class or4 {
    public static final ur4 a;
    public static final xk b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new vr4();
        } else {
            a = new ur4();
        }
        b = new xk(19, Float.class, "translationAlpha");
        new xk(20, Rect.class, "clipBounds");
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.h0(view, i, i2, i3, i4);
    }

    public static void b(View view, int i) {
        a.i0(view, i);
    }
}
