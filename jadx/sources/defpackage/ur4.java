package defpackage;

import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ur4 extends co4 {
    public static boolean k = true;
    public static boolean l = true;
    public static boolean m = true;
    public static boolean n = true;

    public void h0(View view, int i, int i2, int i3, int i4) {
        if (m) {
            try {
                sr4.a(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                m = false;
            }
        }
    }

    public void i0(View view, int i) {
        if (Build.VERSION.SDK_INT != 28) {
            if (n) {
                try {
                    tr4.a(view, i);
                    return;
                } catch (NoSuchMethodError unused) {
                    n = false;
                    return;
                }
            }
            return;
        }
        if (!co4.j) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                co4.i = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            co4.j = true;
        }
        Field field = co4.i;
        if (field != null) {
            try {
                co4.i.setInt(view, (field.getInt(view) & (-13)) | i);
            } catch (IllegalAccessException unused3) {
            }
        }
    }

    public void j0(View view, Matrix matrix) {
        if (k) {
            try {
                rr4.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                k = false;
            }
        }
    }

    public void k0(ViewGroup viewGroup, Matrix matrix) {
        if (l) {
            try {
                rr4.c(viewGroup, matrix);
            } catch (NoSuchMethodError unused) {
                l = false;
            }
        }
    }
}
