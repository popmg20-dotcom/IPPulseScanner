package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.getsurfboard.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ii2 {
    public final MaterialButton a;
    public nu3 b;
    public x04 c;
    public jd d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public PorterDuff.Mode k;
    public ColorStateList l;
    public ColorStateList m;
    public ColorStateList n;
    public yi2 o;
    public boolean s;
    public RippleDrawable u;
    public int v;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean t = true;

    public ii2(MaterialButton materialButton, nu3 nu3Var) {
        this.a = materialButton;
        this.b = nu3Var;
    }

    public final yi2 a(boolean z) {
        RippleDrawable rippleDrawable = this.u;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (yi2) ((LayerDrawable) ((InsetDrawable) this.u.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void b(int i, int i2) {
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.g;
        int i4 = this.h;
        this.h = i2;
        this.g = i;
        if (!this.q) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void c() {
        yi2 yi2Var = new yi2(this.b);
        x04 x04Var = this.c;
        if (x04Var != null) {
            yi2Var.n(x04Var);
        }
        jd jdVar = this.d;
        if (jdVar != null) {
            yi2Var.V0 = jdVar;
        }
        MaterialButton materialButton = this.a;
        yi2Var.l(materialButton.getContext());
        yi2Var.setTintList(this.l);
        PorterDuff.Mode mode = this.k;
        if (mode != null) {
            yi2Var.setTintMode(mode);
        }
        float f = this.j;
        ColorStateList colorStateList = this.m;
        yi2Var.f.j = f;
        yi2Var.invalidateSelf();
        wi2 wi2Var = yi2Var.f;
        if (wi2Var.d != colorStateList) {
            wi2Var.d = colorStateList;
            yi2Var.onStateChange(yi2Var.getState());
        }
        yi2 yi2Var2 = new yi2(this.b);
        x04 x04Var2 = this.c;
        if (x04Var2 != null) {
            yi2Var2.n(x04Var2);
        }
        yi2Var2.setTint(0);
        float f2 = this.j;
        int iA = this.p ? n12.A(materialButton, R.attr.colorSurface) : 0;
        yi2Var2.f.j = f2;
        yi2Var2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iA);
        wi2 wi2Var2 = yi2Var2.f;
        if (wi2Var2.d != colorStateListValueOf) {
            wi2Var2.d = colorStateListValueOf;
            yi2Var2.onStateChange(yi2Var2.getState());
        }
        yi2 yi2Var3 = new yi2(this.b);
        this.o = yi2Var3;
        x04 x04Var3 = this.c;
        if (x04Var3 != null) {
            yi2Var3.n(x04Var3);
        }
        this.o.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(jl3.c(this.n), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{yi2Var2, yi2Var}), this.e, this.g, this.f, this.h), this.o);
        this.u = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        yi2 yi2VarA = a(false);
        if (yi2VarA != null) {
            yi2VarA.o(this.v);
            yi2VarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        yu3 yu3Var;
        yi2 yi2VarA = a(false);
        if (yi2VarA != null) {
            yi2VarA.u(this.b);
            x04 x04Var = this.c;
            if (x04Var != null) {
                yi2VarA.n(x04Var);
            }
        }
        yi2 yi2VarA2 = a(true);
        if (yi2VarA2 != null) {
            yi2VarA2.u(this.b);
            x04 x04Var2 = this.c;
            if (x04Var2 != null) {
                yi2VarA2.n(x04Var2);
            }
        }
        RippleDrawable rippleDrawable = this.u;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            yu3Var = null;
        } else {
            int numberOfLayers = this.u.getNumberOfLayers();
            RippleDrawable rippleDrawable2 = this.u;
            yu3Var = numberOfLayers > 2 ? (yu3) rippleDrawable2.getDrawable(2) : (yu3) rippleDrawable2.getDrawable(1);
        }
        if (yu3Var != null) {
            boolean z = yu3Var instanceof yi2;
            nu3 nu3Var = this.b;
            if (!z) {
                yu3Var.setShapeAppearanceModel(nu3Var.d());
                return;
            }
            yi2 yi2Var = (yi2) yu3Var;
            yi2Var.u(nu3Var);
            x04 x04Var3 = this.c;
            if (x04Var3 != null) {
                yi2Var.n(x04Var3);
            }
        }
    }

    public final void e() {
        yi2 yi2VarA = a(false);
        yi2 yi2VarA2 = a(true);
        if (yi2VarA != null) {
            float f = this.j;
            ColorStateList colorStateList = this.m;
            yi2VarA.f.j = f;
            yi2VarA.invalidateSelf();
            wi2 wi2Var = yi2VarA.f;
            if (wi2Var.d != colorStateList) {
                wi2Var.d = colorStateList;
                yi2VarA.onStateChange(yi2VarA.getState());
            }
            if (yi2VarA2 != null) {
                float f2 = this.j;
                int iA = this.p ? n12.A(this.a, R.attr.colorSurface) : 0;
                yi2VarA2.f.j = f2;
                yi2VarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iA);
                wi2 wi2Var2 = yi2VarA2.f;
                if (wi2Var2.d != colorStateListValueOf) {
                    wi2Var2.d = colorStateListValueOf;
                    yi2VarA2.onStateChange(yi2VarA2.getState());
                }
            }
        }
    }
}
