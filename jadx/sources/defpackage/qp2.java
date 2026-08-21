package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qp2 extends FrameLayout implements lp2 {
    public sk2 A;
    public final TextView b;
    public boolean f;
    public ColorStateList y0;
    public boolean z;

    public qp2(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.m3_navigation_menu_subheader, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.navigation_menu_subheader_label);
    }

    public final void a() {
        sk2 sk2Var = this.A;
        if (sk2Var != null) {
            setVisibility((!sk2Var.isVisible() || (!this.f && this.z)) ? 8 : 0);
        }
    }

    @Override // defpackage.hl2
    public final void c(sk2 sk2Var) {
        this.A = sk2Var;
        sk2Var.setCheckable(false);
        this.b.setText(sk2Var.e);
        a();
    }

    @Override // defpackage.hl2
    public sk2 getItemData() {
        return this.A;
    }

    @Override // defpackage.lp2
    public void setExpanded(boolean z) {
        this.f = z;
        a();
    }

    @Override // defpackage.lp2
    public void setOnlyShowWhenExpanded(boolean z) {
        this.z = z;
        a();
    }

    public void setTextAppearance(int i) {
        TextView textView = this.b;
        textView.setTextAppearance(i);
        ColorStateList colorStateList = this.y0;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.y0 = colorStateList;
        if (colorStateList != null) {
            this.b.setTextColor(colorStateList);
        }
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
    }

    public void setIcon(Drawable drawable) {
    }

    public void setTitle(CharSequence charSequence) {
    }
}
