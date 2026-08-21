package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class po4 extends Drawable.ConstantState {
    public final Drawable.ConstantState a;

    public po4(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        qo4 qo4Var = new qo4();
        qo4Var.b = (VectorDrawable) this.a.newDrawable();
        return qo4Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        qo4 qo4Var = new qo4();
        qo4Var.b = (VectorDrawable) this.a.newDrawable(resources);
        return qo4Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        qo4 qo4Var = new qo4();
        qo4Var.b = (VectorDrawable) this.a.newDrawable(resources, theme);
        return qo4Var;
    }
}
