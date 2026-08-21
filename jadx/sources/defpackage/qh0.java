package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import com.getsurfboard.ui.widget.MetroLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qh0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ xh0 f;

    public /* synthetic */ qh0(xh0 xh0Var, int i) {
        this.b = i;
        this.f = xh0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = 8;
        xh0 xh0Var = this.f;
        switch (i) {
            case 0:
                j80 j80Var = xh0Var.b;
                if (j80Var == null) {
                    return;
                }
                LinearLayout linearLayout = (LinearLayout) j80Var.f;
                j80Var.getClass();
                MetroLayout metroLayout = (MetroLayout) ((oj1) j80Var.c).f;
                int i3 = 0;
                while (true) {
                    if (i3 < metroLayout.getChildCount()) {
                        int i4 = i3 + 1;
                        View childAt = metroLayout.getChildAt(i3);
                        if (childAt == null) {
                            throw new IndexOutOfBoundsException();
                        }
                        if (childAt.getVisibility() != 0) {
                            i3 = i4;
                        }
                    } else {
                        i2 = 0;
                    }
                }
                linearLayout.setVisibility(i2);
                return;
            default:
                j80 j80Var2 = xh0Var.b;
                j80Var2.getClass();
                LinearLayout linearLayout2 = (LinearLayout) j80Var2.f;
                j80 j80Var3 = xh0Var.b;
                j80Var3.getClass();
                MetroLayout metroLayout2 = (MetroLayout) ((oj1) j80Var3.c).f;
                int i5 = 0;
                while (true) {
                    if (i5 < metroLayout2.getChildCount()) {
                        int i6 = i5 + 1;
                        View childAt2 = metroLayout2.getChildAt(i5);
                        if (childAt2 == null) {
                            throw new IndexOutOfBoundsException();
                        }
                        if (childAt2.getVisibility() != 0) {
                            i5 = i6;
                        }
                    } else {
                        i2 = 0;
                    }
                }
                linearLayout2.setVisibility(i2);
                return;
        }
    }
}
