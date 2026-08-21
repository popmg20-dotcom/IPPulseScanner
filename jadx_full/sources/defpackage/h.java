package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final em0 a = new em0();

    public static final boolean a(ry1 ry1Var) {
        ImageView imageView;
        m23 m23Var = ry1Var.e;
        ty1 ty1Var = ry1Var.c;
        xx3 xx3Var = ry1Var.s;
        int iOrdinal = m23Var.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    g.d();
                    return false;
                }
                if (!(xx3Var instanceof wv0) && (!(ty1Var instanceof ty1) || !(xx3Var instanceof cf3) || (imageView = ty1Var.f) == null || imageView != ((cf3) xx3Var).a)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final Drawable b(ry1 ry1Var, Integer num) {
        if (num == null || num.intValue() == 0) {
            return null;
        }
        Context context = ry1Var.a;
        int iIntValue = num.intValue();
        Drawable drawableR = vo.r(context, iIntValue);
        if (drawableR != null) {
            return drawableR;
        }
        g.g(dw2.A(iIntValue, "Invalid resource ID: "));
        return null;
    }
}
