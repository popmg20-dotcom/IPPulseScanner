package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f24 extends yk2 implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public final kk2 A;
    public PopupWindow.OnDismissListener B0;
    public View C0;
    public View D0;
    public fl2 E0;
    public ViewTreeObserver F0;
    public boolean G0;
    public boolean H0;
    public int I0;
    public boolean K0;
    public final boolean X;
    public final int Y;
    public final int Z;
    public final Context f;
    public final el2 y0;
    public final nk2 z;
    public final sb z0 = new sb(4, this);
    public final c20 A0 = new c20(5, this);
    public int J0 = 0;

    public f24(Context context, nk2 nk2Var, View view, int i, boolean z) {
        this.f = context;
        this.z = nk2Var;
        this.X = z;
        this.A = new kk2(nk2Var, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.Z = i;
        Resources resources = context.getResources();
        this.Y = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.C0 = view;
        this.y0 = new el2(context, null, i, 0);
        nk2Var.b(this, context);
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
        if (nk2Var != this.z) {
            return;
        }
        dismiss();
        fl2 fl2Var = this.E0;
        if (fl2Var != null) {
            fl2Var.a(nk2Var, z);
        }
    }

    @Override // defpackage.wv3
    public final boolean b() {
        return !this.G0 && this.y0.Q0.isShowing();
    }

    @Override // defpackage.gl2
    public final void c(boolean z) {
        this.H0 = false;
        kk2 kk2Var = this.A;
        if (kk2Var != null) {
            kk2Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.gl2
    public final boolean d(b54 b54Var) {
        boolean z;
        if (b54Var.hasVisibleItems()) {
            al2 al2Var = new al2(this.f, b54Var, this.D0, this.X, this.Z, 0);
            fl2 fl2Var = this.E0;
            al2Var.h = fl2Var;
            yk2 yk2Var = al2Var.i;
            if (yk2Var != null) {
                yk2Var.i(fl2Var);
            }
            int size = b54Var.f.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = b54Var.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            al2Var.g = z;
            yk2 yk2Var2 = al2Var.i;
            if (yk2Var2 != null) {
                yk2Var2.q(z);
            }
            al2Var.j = this.B0;
            this.B0 = null;
            this.z.c(false);
            el2 el2Var = this.y0;
            int width = el2Var.Y;
            int iO = el2Var.o();
            if ((Gravity.getAbsoluteGravity(this.J0, this.C0.getLayoutDirection()) & 7) == 5) {
                width += this.C0.getWidth();
            }
            if (!al2Var.b()) {
                if (al2Var.e != null) {
                    al2Var.d(width, iO, true, true);
                }
            }
            fl2 fl2Var2 = this.E0;
            if (fl2Var2 != null) {
                fl2Var2.i0(b54Var);
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.wv3
    public final void dismiss() {
        if (b()) {
            this.y0.dismiss();
        }
    }

    @Override // defpackage.gl2
    public final boolean e() {
        return false;
    }

    @Override // defpackage.wv3
    public final void g() {
        View view;
        if (b()) {
            return;
        }
        if (this.G0 || (view = this.C0) == null) {
            xe.q("StandardMenuPopup cannot be used without an anchor");
            return;
        }
        this.D0 = view;
        el2 el2Var = this.y0;
        kb kbVar = el2Var.Q0;
        kb kbVar2 = el2Var.Q0;
        kbVar.setOnDismissListener(this);
        el2Var.G0 = this;
        el2Var.P0 = true;
        kbVar2.setFocusable(true);
        View view2 = this.D0;
        boolean z = this.F0 == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.F0 = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.z0);
        }
        view2.addOnAttachStateChangeListener(this.A0);
        el2Var.F0 = view2;
        el2Var.C0 = this.J0;
        boolean z2 = this.H0;
        Context context = this.f;
        kk2 kk2Var = this.A;
        if (!z2) {
            this.I0 = yk2.o(kk2Var, context, this.Y);
            this.H0 = true;
        }
        el2Var.q(this.I0);
        kbVar2.setInputMethodMode(2);
        Rect rect = this.b;
        el2Var.O0 = rect != null ? new Rect(rect) : null;
        el2Var.g();
        jy0 jy0Var = el2Var.z;
        jy0Var.setOnKeyListener(this);
        if (this.K0) {
            nk2 nk2Var = this.z;
            if (nk2Var.m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) jy0Var, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(nk2Var.m);
                }
                frameLayout.setEnabled(false);
                jy0Var.addHeaderView(frameLayout, null, false);
            }
        }
        el2Var.p(kk2Var);
        el2Var.g();
    }

    @Override // defpackage.gl2
    public final void i(fl2 fl2Var) {
        this.E0 = fl2Var;
    }

    @Override // defpackage.wv3
    public final jy0 k() {
        return this.y0.z;
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        return null;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.G0 = true;
        this.z.c(true);
        ViewTreeObserver viewTreeObserver = this.F0;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.F0 = this.D0.getViewTreeObserver();
            }
            this.F0.removeGlobalOnLayoutListener(this.z0);
            this.F0 = null;
        }
        this.D0.removeOnAttachStateChangeListener(this.A0);
        PopupWindow.OnDismissListener onDismissListener = this.B0;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.yk2
    public final void p(View view) {
        this.C0 = view;
    }

    @Override // defpackage.yk2
    public final void q(boolean z) {
        this.A.z = z;
    }

    @Override // defpackage.yk2
    public final void r(int i) {
        this.J0 = i;
    }

    @Override // defpackage.yk2
    public final void s(int i) {
        this.y0.Y = i;
    }

    @Override // defpackage.yk2
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.B0 = onDismissListener;
    }

    @Override // defpackage.yk2
    public final void u(boolean z) {
        this.K0 = z;
    }

    @Override // defpackage.yk2
    public final void v(int i) {
        this.y0.l(i);
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
    }

    @Override // defpackage.yk2
    public final void n(nk2 nk2Var) {
    }
}
