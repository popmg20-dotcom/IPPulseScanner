package defpackage;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oo extends ko {
    public final Boolean a;
    public final bv4 b;
    public Window c;
    public boolean d;

    public oo(View view, bv4 bv4Var) {
        this.b = bv4Var;
        yi2 yi2Var = BottomSheetBehavior.D(view).A0;
        ColorStateList backgroundTintList = yi2Var != null ? yi2Var.f.c : view.getBackgroundTintList();
        if (backgroundTintList != null) {
            this.a = Boolean.valueOf(n12.G(backgroundTintList.getDefaultColor()));
            return;
        }
        ColorStateList colorStateListH = v9.h(view.getBackground());
        Integer numValueOf = colorStateListH != null ? Integer.valueOf(colorStateListH.getDefaultColor()) : null;
        if (numValueOf != null) {
            this.a = Boolean.valueOf(n12.G(numValueOf.intValue()));
        } else {
            this.a = null;
        }
    }

    @Override // defpackage.ko
    public final void a(View view) {
        d(view);
    }

    @Override // defpackage.ko
    public final void b(View view) {
        d(view);
    }

    @Override // defpackage.ko
    public final void c(View view, int i) {
        d(view);
    }

    public final void d(View view) {
        int top = view.getTop();
        bv4 bv4Var = this.b;
        if (top < bv4Var.d()) {
            Window window = this.c;
            if (window != null) {
                Boolean bool = this.a;
                boolean zBooleanValue = bool == null ? this.d : bool.booleanValue();
                window.getDecorView();
                int i = Build.VERSION.SDK_INT;
                (i >= 35 ? new hv4(window) : i >= 30 ? new fv4(window) : i >= 26 ? new dv4(window) : new cv4(window)).K(zBooleanValue);
            }
            view.setPadding(view.getPaddingLeft(), bv4Var.d() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            return;
        }
        if (view.getTop() != 0) {
            Window window2 = this.c;
            if (window2 != null) {
                boolean z = this.d;
                window2.getDecorView();
                int i2 = Build.VERSION.SDK_INT;
                (i2 >= 35 ? new hv4(window2) : i2 >= 30 ? new fv4(window2) : i2 >= 26 ? new dv4(window2) : new cv4(window2)).K(z);
            }
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public final void e(Window window) {
        if (this.c == window) {
            return;
        }
        this.c = window;
        if (window != null) {
            window.getDecorView();
            int i = Build.VERSION.SDK_INT;
            this.d = (i >= 35 ? new hv4(window) : i >= 30 ? new fv4(window) : i >= 26 ? new dv4(window) : new cv4(window)).y();
        }
    }
}
