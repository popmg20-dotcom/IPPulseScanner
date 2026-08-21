package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n8 extends Drawable.ConstantState {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public n8(bo boVar) {
        this.b = boVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).getChangingConfigurations();
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.a) {
            case 0:
                o8 o8Var = new o8(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources);
                o8Var.b = drawableNewDrawable;
                drawableNewDrawable.setCallback(o8Var.Y);
                return o8Var;
            default:
                return super.newDrawable(resources);
        }
    }

    public n8(Drawable.ConstantState constantState) {
        this.b = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                o8 o8Var = new o8(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) obj).newDrawable();
                o8Var.b = drawableNewDrawable;
                drawableNewDrawable.setCallback(o8Var.Y);
                return o8Var;
            default:
                return (bo) obj;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.a) {
            case 0:
                o8 o8Var = new o8(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources, theme);
                o8Var.b = drawableNewDrawable;
                drawableNewDrawable.setCallback(o8Var.Y);
                return o8Var;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
