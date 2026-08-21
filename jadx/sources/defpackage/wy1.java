package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wy1 extends uy1 {
    public final Field a;
    public final Field b;
    public final Field c;

    public wy1(Field field, Field field2, Field field3) {
        this.a = field;
        this.b = field2;
        this.c = field3;
    }

    @Override // defpackage.uy1
    public final boolean a(InputMethodManager inputMethodManager) {
        try {
            this.c.set(inputMethodManager, null);
            return true;
        } catch (IllegalAccessException unused) {
            return false;
        }
    }

    @Override // defpackage.uy1
    public final Object b(InputMethodManager inputMethodManager) {
        try {
            return this.a.get(inputMethodManager);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    @Override // defpackage.uy1
    public final View c(InputMethodManager inputMethodManager) {
        try {
            return (View) this.b.get(inputMethodManager);
        } catch (ClassCastException | IllegalAccessException unused) {
            return null;
        }
    }
}
