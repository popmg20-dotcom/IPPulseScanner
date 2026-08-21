package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i92 extends co4 {
    public final /* synthetic */ int k;
    public final SideSheetBehavior l;

    public /* synthetic */ i92(SideSheetBehavior sideSheetBehavior, int i) {
        this.k = i;
        this.l = sideSheetBehavior;
    }

    @Override // defpackage.co4
    public final int A() {
        switch (this.k) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // defpackage.co4
    public final boolean D(float f) {
        switch (this.k) {
            case 0:
                if (f > 0.0f) {
                }
                break;
            default:
                if (f < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // defpackage.co4
    public final boolean F(View view) {
        switch (this.k) {
            case 0:
                if (view.getRight() < (t() - v()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (t() + this.l.D0) / 2) {
                }
                break;
        }
        return true;
    }

    @Override // defpackage.co4
    public final boolean G(float f, float f2) {
        switch (this.k) {
            case 0:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500.0f) {
                }
                break;
            default:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500.0f) {
                }
                break;
        }
        return false;
    }

    @Override // defpackage.co4
    public final boolean X(View view, float f) {
        int i = this.k;
        SideSheetBehavior sideSheetBehavior = this.l;
        switch (i) {
            case 0:
                if (Math.abs((f * sideSheetBehavior.B0) + view.getLeft()) > 0.5f) {
                }
                break;
            default:
                if (Math.abs((f * sideSheetBehavior.B0) + view.getRight()) > 0.5f) {
                }
                break;
        }
        return true;
    }

    @Override // defpackage.co4
    public final void a0(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        switch (this.k) {
            case 0:
                marginLayoutParams.leftMargin = i;
                break;
            default:
                marginLayoutParams.rightMargin = i;
                break;
        }
    }

    @Override // defpackage.co4
    public final void b0(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        int i3 = this.k;
        SideSheetBehavior sideSheetBehavior = this.l;
        switch (i3) {
            case 0:
                if (i <= sideSheetBehavior.D0) {
                    marginLayoutParams.leftMargin = i2;
                }
                break;
            default:
                int i4 = sideSheetBehavior.D0;
                if (i <= i4) {
                    marginLayoutParams.rightMargin = i4 - i;
                }
                break;
        }
    }

    @Override // defpackage.co4
    public final int e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.k) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // defpackage.co4
    public final float f(int i) {
        switch (this.k) {
            case 0:
                float fV = v();
                return (i - fV) / (t() - fV);
            default:
                float f = this.l.D0;
                return (f - i) / (f - t());
        }
    }

    @Override // defpackage.co4
    public final int s(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.k) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // defpackage.co4
    public final int t() {
        int i = this.k;
        SideSheetBehavior sideSheetBehavior = this.l;
        switch (i) {
            case 0:
                return Math.max(0, sideSheetBehavior.E0 + sideSheetBehavior.F0);
            default:
                return Math.max(0, (sideSheetBehavior.D0 - sideSheetBehavior.C0) - sideSheetBehavior.F0);
        }
    }

    @Override // defpackage.co4
    public final int v() {
        int i = this.k;
        SideSheetBehavior sideSheetBehavior = this.l;
        switch (i) {
            case 0:
                return (-sideSheetBehavior.C0) - sideSheetBehavior.F0;
            default:
                return sideSheetBehavior.D0;
        }
    }

    @Override // defpackage.co4
    public final int w() {
        int i = this.k;
        SideSheetBehavior sideSheetBehavior = this.l;
        switch (i) {
            case 0:
                return sideSheetBehavior.F0;
            default:
                return sideSheetBehavior.D0;
        }
    }

    @Override // defpackage.co4
    public final int x() {
        switch (this.k) {
            case 0:
                return -this.l.C0;
            default:
                return t();
        }
    }

    @Override // defpackage.co4
    public final int y(View view) {
        int i = this.k;
        SideSheetBehavior sideSheetBehavior = this.l;
        switch (i) {
            case 0:
                return view.getRight() + sideSheetBehavior.F0;
            default:
                return view.getLeft() - sideSheetBehavior.F0;
        }
    }

    @Override // defpackage.co4
    public final int z(CoordinatorLayout coordinatorLayout) {
        switch (this.k) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }
}
