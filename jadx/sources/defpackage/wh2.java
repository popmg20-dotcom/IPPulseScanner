package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wh2 extends t6 {
    public final yi2 A;
    public final Rect X;

    /* JADX WARN: Illegal instructions before constructor call */
    public wh2(Context context) {
        TypedValue typedValueA = ek0.A(context, R.attr.materialAlertDialogTheme);
        int i = typedValueA == null ? 0 : typedValueA.data;
        Context contextD0 = co4.d0(context, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        contextD0 = i != 0 ? new de0(contextD0, i) : contextD0;
        TypedValue typedValueA2 = ek0.A(context, R.attr.materialAlertDialogTheme);
        super(contextD0, typedValueA2 == null ? 0 : typedValueA2.data);
        ContextThemeWrapper contextThemeWrapper = ((p6) this.z).a;
        Resources.Theme theme = contextThemeWrapper.getTheme();
        fx3.c(contextThemeWrapper, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int[] iArr = rc3.s;
        fx3.e(contextThemeWrapper, null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        int layoutDirection = contextThemeWrapper.getResources().getConfiguration().getLayoutDirection();
        this.X = new Rect(layoutDirection == 1 ? dimensionPixelSize3 : dimensionPixelSize, dimensionPixelSize2, layoutDirection != 1 ? dimensionPixelSize3 : dimensionPixelSize, dimensionPixelSize4);
        String canonicalName = wh2.class.getCanonicalName();
        TypedValue typedValueA3 = ek0.A(contextThemeWrapper, R.attr.colorSurface);
        if (typedValueA3 == null) {
            zo2.p("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{canonicalName, contextThemeWrapper.getResources().getResourceName(R.attr.colorSurface)});
            throw null;
        }
        int i2 = typedValueA3.resourceId;
        int color = i2 != 0 ? contextThemeWrapper.getColor(i2) : typedValueA3.data;
        TypedArray typedArrayObtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int color2 = typedArrayObtainStyledAttributes2.getColor(4, color);
        typedArrayObtainStyledAttributes2.recycle();
        yi2 yi2Var = new yi2(contextThemeWrapper, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        yi2Var.l(contextThemeWrapper);
        yi2Var.p(ColorStateList.valueOf(color2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(((p6) this.z).a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                yi2Var.setShapeAppearanceModel(yi2Var.f.a.a(dimension));
            }
        }
        this.A = yi2Var;
    }

    @Override // defpackage.t6
    public final u6 h() {
        u6 u6VarH = super.h();
        Window window = u6VarH.getWindow();
        View decorView = window.getDecorView();
        yi2 yi2Var = this.A;
        if (yi2Var != null) {
            yi2Var.o(decorView.getElevation());
        }
        Rect rect = this.X;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) yi2Var, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new s02(u6VarH, rect));
        return u6VarH;
    }

    @Override // defpackage.t6
    public final void q(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.q(null, null);
    }

    public final void t(int i) {
        p6 p6Var = (p6) this.z;
        p6Var.g = p6Var.a.getText(i);
    }

    public final void u(int i, DialogInterface.OnClickListener onClickListener) {
        p6 p6Var = (p6) this.z;
        p6Var.j = p6Var.a.getText(i);
        p6Var.k = onClickListener;
    }

    public final void v(int i, DialogInterface.OnClickListener onClickListener) {
        p6 p6Var = (p6) this.z;
        p6Var.l = p6Var.a.getText(i);
        p6Var.m = onClickListener;
    }

    public final void w(int i, DialogInterface.OnClickListener onClickListener) {
        p6 p6Var = (p6) this.z;
        p6Var.h = p6Var.a.getText(i);
        p6Var.i = onClickListener;
    }

    public final void x(int i) {
        p6 p6Var = (p6) this.z;
        p6Var.e = p6Var.a.getText(i);
    }

    public final void y(View view) {
        p6 p6Var = (p6) this.z;
        p6Var.v = view;
        p6Var.u = 0;
    }
}
