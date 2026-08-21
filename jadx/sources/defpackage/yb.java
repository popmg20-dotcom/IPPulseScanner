package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yb extends hc2 implements ac {
    public CharSequence U0;
    public vb V0;
    public final Rect W0;
    public int X0;
    public final /* synthetic */ bc Y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb(bc bcVar, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.Y0 = bcVar;
        this.W0 = new Rect();
        this.F0 = bcVar;
        this.P0 = true;
        this.Q0.setFocusable(true);
        this.G0 = new wb(0, this);
    }

    @Override // defpackage.ac
    public final CharSequence f() {
        return this.U0;
    }

    @Override // defpackage.ac
    public final void i(CharSequence charSequence) {
        this.U0 = charSequence;
    }

    @Override // defpackage.ac
    public final void m(int i) {
        this.X0 = i;
    }

    @Override // defpackage.ac
    public final void n(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        kb kbVar = this.Q0;
        boolean zIsShowing = kbVar.isShowing();
        r();
        kbVar.setInputMethodMode(2);
        g();
        jy0 jy0Var = this.z;
        jy0Var.setChoiceMode(1);
        jy0Var.setTextDirection(i);
        jy0Var.setTextAlignment(i2);
        bc bcVar = this.Y0;
        int selectedItemPosition = bcVar.getSelectedItemPosition();
        jy0 jy0Var2 = this.z;
        if (kbVar.isShowing() && jy0Var2 != null) {
            jy0Var2.setListSelectionHidden(false);
            jy0Var2.setSelection(selectedItemPosition);
            if (jy0Var2.getChoiceMode() != 0) {
                jy0Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = bcVar.getViewTreeObserver()) == null) {
            return;
        }
        sb sbVar = new sb(1, this);
        viewTreeObserver.addOnGlobalLayoutListener(sbVar);
        kbVar.setOnDismissListener(new xb(this, sbVar));
    }

    @Override // defpackage.hc2, defpackage.ac
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.V0 = (vb) listAdapter;
    }

    public final void r() {
        int i;
        kb kbVar = this.Q0;
        Drawable background = kbVar.getBackground();
        bc bcVar = this.Y0;
        Rect rect = bcVar.B0;
        if (background != null) {
            background.getPadding(rect);
            boolean z = pr4.a;
            i = bcVar.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = bcVar.getPaddingLeft();
        int paddingRight = bcVar.getPaddingRight();
        int width = bcVar.getWidth();
        int i2 = bcVar.A0;
        if (i2 == -2) {
            int iA = bcVar.a(this.V0, kbVar.getBackground());
            int i3 = (bcVar.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (iA > i3) {
                iA = i3;
            }
            q(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            q((width - paddingLeft) - paddingRight);
        } else {
            q(i2);
        }
        boolean z2 = pr4.a;
        this.Y = bcVar.getLayoutDirection() == 1 ? (((width - paddingRight) - this.X) - this.X0) + i : paddingLeft + this.X0 + i;
    }
}
