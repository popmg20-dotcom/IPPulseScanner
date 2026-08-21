package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class al2 {
    public final Context a;
    public final nk2 b;
    public final boolean c;
    public final int d;
    public View e;
    public boolean g;
    public fl2 h;
    public yk2 i;
    public PopupWindow.OnDismissListener j;
    public int f = 8388611;
    public final zk2 k = new zk2(this);

    public al2(Context context, nk2 nk2Var, View view, boolean z, int i, int i2) {
        this.a = context;
        this.b = nk2Var;
        this.e = view;
        this.c = z;
        this.d = i;
    }

    public final yk2 a() {
        yk2 f24Var = this.i;
        if (f24Var == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int iMin = Math.min(point.x, point.y);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width);
            Context context2 = this.a;
            if (iMin >= dimensionPixelSize) {
                f24Var = new f20(context2, this.e, this.d, this.c);
            } else {
                f24Var = new f24(context2, this.b, this.e, this.d, this.c);
            }
            f24Var.n(this.b);
            f24Var.t(this.k);
            f24Var.p(this.e);
            f24Var.i(this.h);
            f24Var.q(this.g);
            f24Var.r(this.f);
            this.i = f24Var;
        }
        return f24Var;
    }

    public final boolean b() {
        yk2 yk2Var = this.i;
        return yk2Var != null && yk2Var.b();
    }

    public void c() {
        this.i = null;
        PopupWindow.OnDismissListener onDismissListener = this.j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        yk2 yk2VarA = a();
        yk2VarA.u(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f, this.e.getLayoutDirection()) & 7) == 5) {
                i -= this.e.getWidth();
            }
            yk2VarA.s(i);
            yk2VarA.v(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            yk2VarA.b = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        yk2VarA.g();
    }
}
