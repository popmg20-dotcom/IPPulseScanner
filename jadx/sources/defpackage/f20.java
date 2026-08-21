package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.getsurfboard.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f20 extends yk2 implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public final int A;
    public View E0;
    public View F0;
    public int G0;
    public boolean H0;
    public boolean I0;
    public int J0;
    public int K0;
    public boolean M0;
    public fl2 N0;
    public ViewTreeObserver O0;
    public PopupWindow.OnDismissListener P0;
    public boolean Q0;
    public final boolean X;
    public final Handler Y;
    public final Context f;
    public final int z;
    public final ArrayList Z = new ArrayList();
    public final ArrayList y0 = new ArrayList();
    public final sb z0 = new sb(2, this);
    public final c20 A0 = new c20(0, this);
    public final cp1 B0 = new cp1(15, this);
    public int C0 = 0;
    public int D0 = 0;
    public boolean L0 = false;

    public f20(Context context, View view, int i, boolean z) {
        this.f = context;
        this.E0 = view;
        this.A = i;
        this.X = z;
        this.G0 = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.z = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.Y = new Handler();
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
        ArrayList arrayList = this.y0;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (nk2Var == ((e20) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((e20) arrayList.get(i2)).b.c(false);
        }
        e20 e20Var = (e20) arrayList.remove(i);
        nk2 nk2Var2 = e20Var.b;
        el2 el2Var = e20Var.a;
        kb kbVar = el2Var.Q0;
        nk2Var2.t(this);
        if (this.Q0) {
            bl2.b(kbVar, null);
            kbVar.setAnimationStyle(0);
        }
        el2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.G0 = ((e20) arrayList.get(size2 - 1)).c;
        } else {
            this.G0 = this.E0.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((e20) arrayList.get(0)).b.c(false);
                return;
            }
            return;
        }
        dismiss();
        fl2 fl2Var = this.N0;
        if (fl2Var != null) {
            fl2Var.a(nk2Var, true);
        }
        ViewTreeObserver viewTreeObserver = this.O0;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.O0.removeGlobalOnLayoutListener(this.z0);
            }
            this.O0 = null;
        }
        this.F0.removeOnAttachStateChangeListener(this.A0);
        this.P0.onDismiss();
    }

    @Override // defpackage.wv3
    public final boolean b() {
        ArrayList arrayList = this.y0;
        return arrayList.size() > 0 && ((e20) arrayList.get(0)).a.Q0.isShowing();
    }

    @Override // defpackage.gl2
    public final void c(boolean z) {
        Iterator it = this.y0.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((e20) it.next()).a.z.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((kk2) adapter).notifyDataSetChanged();
        }
    }

    @Override // defpackage.gl2
    public final boolean d(b54 b54Var) {
        for (e20 e20Var : this.y0) {
            if (b54Var == e20Var.b) {
                e20Var.a.z.requestFocus();
                return true;
            }
        }
        if (!b54Var.hasVisibleItems()) {
            return false;
        }
        n(b54Var);
        fl2 fl2Var = this.N0;
        if (fl2Var != null) {
            fl2Var.i0(b54Var);
        }
        return true;
    }

    @Override // defpackage.wv3
    public final void dismiss() {
        ArrayList arrayList = this.y0;
        int size = arrayList.size();
        if (size > 0) {
            e20[] e20VarArr = (e20[]) arrayList.toArray(new e20[size]);
            for (int i = size - 1; i >= 0; i--) {
                e20 e20Var = e20VarArr[i];
                if (e20Var.a.Q0.isShowing()) {
                    e20Var.a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.gl2
    public final boolean e() {
        return false;
    }

    @Override // defpackage.wv3
    public final void g() {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.Z;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            w((nk2) it.next());
        }
        arrayList.clear();
        View view = this.E0;
        this.F0 = view;
        if (view != null) {
            boolean z = this.O0 == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.O0 = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.z0);
            }
            this.F0.addOnAttachStateChangeListener(this.A0);
        }
    }

    @Override // defpackage.gl2
    public final void i(fl2 fl2Var) {
        this.N0 = fl2Var;
    }

    @Override // defpackage.wv3
    public final jy0 k() {
        ArrayList arrayList = this.y0;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((e20) fw.r(arrayList, 1)).a.z;
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        return null;
    }

    @Override // defpackage.yk2
    public final void n(nk2 nk2Var) {
        nk2Var.b(this, this.f);
        if (b()) {
            w(nk2Var);
        } else {
            this.Z.add(nk2Var);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        e20 e20Var;
        ArrayList arrayList = this.y0;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                e20Var = null;
                break;
            }
            e20Var = (e20) arrayList.get(i);
            if (!e20Var.a.Q0.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (e20Var != null) {
            e20Var.b.c(false);
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
        if (this.E0 != view) {
            this.E0 = view;
            this.D0 = Gravity.getAbsoluteGravity(this.C0, view.getLayoutDirection());
        }
    }

    @Override // defpackage.yk2
    public final void q(boolean z) {
        this.L0 = z;
    }

    @Override // defpackage.yk2
    public final void r(int i) {
        if (this.C0 != i) {
            this.C0 = i;
            this.D0 = Gravity.getAbsoluteGravity(i, this.E0.getLayoutDirection());
        }
    }

    @Override // defpackage.yk2
    public final void s(int i) {
        this.H0 = true;
        this.J0 = i;
    }

    @Override // defpackage.yk2
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.P0 = onDismissListener;
    }

    @Override // defpackage.yk2
    public final void u(boolean z) {
        this.M0 = z;
    }

    @Override // defpackage.yk2
    public final void v(int i) {
        this.I0 = true;
        this.K0 = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(defpackage.nk2 r20) {
        /*
            Method dump skipped, instruction units count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f20.w(nk2):void");
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
    }
}
