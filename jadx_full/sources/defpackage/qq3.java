package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qq3 extends fg3 {
    public x90 a;
    public final ViewPager2 b;
    public final yq4 c;
    public final LinearLayoutManager d;
    public int e;
    public int f;
    public final pq3 g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public qq3(ViewPager2 viewPager2) {
        this.b = viewPager2;
        yq4 yq4Var = viewPager2.D0;
        this.c = yq4Var;
        this.d = (LinearLayoutManager) yq4Var.getLayoutManager();
        this.g = new pq3();
        e();
    }

    @Override // defpackage.fg3
    public final void a(RecyclerView recyclerView, int i) {
        x90 x90Var;
        int i2 = this.e;
        if (!(i2 == 1 && this.f == 1) && i == 1) {
            this.e = 1;
            int i3 = this.i;
            if (i3 != -1) {
                this.h = i3;
                this.i = -1;
            } else if (this.h == -1) {
                LinearLayoutManager linearLayoutManager = this.d;
                View viewU0 = linearLayoutManager.U0(0, linearLayoutManager.v(), false, true);
                this.h = viewU0 != null ? ag3.K(viewU0) : -1;
            }
            d(1);
            return;
        }
        if ((i2 == 1 || i2 == 4) && i == 2) {
            if (this.k) {
                d(2);
                this.j = true;
                return;
            }
            return;
        }
        pq3 pq3Var = this.g;
        if ((i2 == 1 || i2 == 4) && i == 0) {
            f();
            if (!this.k) {
                int i4 = pq3Var.a;
                if (i4 != -1 && (x90Var = this.a) != null) {
                    x90Var.b(i4, 0.0f, 0);
                }
            } else if (pq3Var.c == 0) {
                int i5 = this.h;
                int i6 = pq3Var.a;
                if (i5 != i6) {
                    c(i6);
                }
            }
            d(0);
            e();
        }
        if (this.e == 2 && i == 0 && this.l) {
            f();
            if (pq3Var.c == 0) {
                int i7 = this.i;
                int i8 = pq3Var.a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    c(i8);
                }
                d(0);
                e();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    @Override // defpackage.fg3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int i3;
        this.k = true;
        f();
        boolean z = this.j;
        pq3 pq3Var = this.g;
        if (z) {
            this.j = false;
            if (i2 > 0) {
                i3 = pq3Var.c != 0 ? pq3Var.a + 1 : pq3Var.a;
                this.i = i3;
                if (this.h != i3) {
                    c(i3);
                }
            } else {
                if (i2 == 0) {
                    if ((i < 0) == (this.b.A0.b.getLayoutDirection() == 1)) {
                    }
                }
                this.i = i3;
                if (this.h != i3) {
                }
            }
        } else if (this.e == 0) {
            int i4 = pq3Var.a;
            if (i4 == -1) {
                i4 = 0;
            }
            c(i4);
        }
        int i5 = pq3Var.a;
        if (i5 == -1) {
            i5 = 0;
        }
        float f = pq3Var.b;
        int i6 = pq3Var.c;
        x90 x90Var = this.a;
        if (x90Var != null) {
            x90Var.b(i5, f, i6);
        }
        int i7 = pq3Var.a;
        int i8 = this.i;
        if ((i7 == i8 || i8 == -1) && pq3Var.c == 0 && this.f != 1) {
            d(0);
            e();
        }
    }

    public final void c(int i) {
        x90 x90Var = this.a;
        if (x90Var != null) {
            x90Var.c(i);
        }
    }

    public final void d(int i) {
        if ((this.e == 3 && this.f == 0) || this.f == i) {
            return;
        }
        this.f = i;
        x90 x90Var = this.a;
        if (x90Var != null) {
            x90Var.a(i);
        }
    }

    public final void e() {
        this.e = 0;
        this.f = 0;
        pq3 pq3Var = this.g;
        pq3Var.a = -1;
        pq3Var.b = 0.0f;
        pq3Var.c = 0;
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        int top;
        int iV;
        int top2;
        int i;
        int bottom;
        int i2;
        LinearLayoutManager linearLayoutManager = this.d;
        View viewU0 = linearLayoutManager.U0(0, linearLayoutManager.v(), false, true);
        int iK = viewU0 == null ? -1 : ag3.K(viewU0);
        pq3 pq3Var = this.g;
        pq3Var.a = iK;
        if (iK == -1) {
            pq3Var.a = -1;
            pq3Var.b = 0.0f;
            pq3Var.c = 0;
            return;
        }
        View viewQ = linearLayoutManager.q(iK);
        if (viewQ == null) {
            pq3Var.a = -1;
            pq3Var.b = 0.0f;
            pq3Var.c = 0;
            return;
        }
        int i3 = ((bg3) viewQ.getLayoutParams()).b.left;
        int i4 = ((bg3) viewQ.getLayoutParams()).b.right;
        int i5 = ((bg3) viewQ.getLayoutParams()).b.top;
        int i6 = ((bg3) viewQ.getLayoutParams()).b.bottom;
        ViewGroup.LayoutParams layoutParams = viewQ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i3 += marginLayoutParams.leftMargin;
            i4 += marginLayoutParams.rightMargin;
            i5 += marginLayoutParams.topMargin;
            i6 += marginLayoutParams.bottomMargin;
        }
        int height = viewQ.getHeight() + i5 + i6;
        int width = viewQ.getWidth() + i3 + i4;
        int i7 = linearLayoutManager.p;
        yq4 yq4Var = this.c;
        if (i7 == 0) {
            top = (viewQ.getLeft() - i3) - yq4Var.getPaddingLeft();
            if (this.b.A0.b.getLayoutDirection() == 1) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewQ.getTop() - i5) - yq4Var.getPaddingTop();
        }
        int i8 = -top;
        pq3Var.c = i8;
        if (i8 >= 0) {
            pq3Var.b = height != 0 ? i8 / height : 0.0f;
            return;
        }
        int iV2 = linearLayoutManager.v();
        if (iV2 != 0) {
            boolean z = linearLayoutManager.p == 0;
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iV2, 2);
            for (int i9 = 0; i9 < iV2; i9++) {
                View viewU = linearLayoutManager.u(i9);
                if (viewU == null) {
                    xe.q("null view contained in the view hierarchy");
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = viewU.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : f8.a;
                int[] iArr2 = iArr[i9];
                if (z) {
                    top2 = viewU.getLeft();
                    i = marginLayoutParams2.leftMargin;
                } else {
                    top2 = viewU.getTop();
                    i = marginLayoutParams2.topMargin;
                }
                iArr2[0] = top2 - i;
                int[] iArr3 = iArr[i9];
                if (z) {
                    bottom = viewU.getRight();
                    i2 = marginLayoutParams2.rightMargin;
                } else {
                    bottom = viewU.getBottom();
                    i2 = marginLayoutParams2.bottomMargin;
                }
                iArr3[1] = bottom + i2;
            }
            Arrays.sort(iArr, new e1(1));
            int i10 = 1;
            while (true) {
                if (i10 >= iV2) {
                    int[] iArr4 = iArr[0];
                    int i11 = iArr4[1];
                    int i12 = iArr4[0];
                    int i13 = i11 - i12;
                    if (i12 > 0 || iArr[iV2 - 1][1] < i13) {
                        break;
                    }
                } else if (iArr[i10 - 1][1] != iArr[i10][0]) {
                    break;
                } else {
                    i10++;
                }
            }
            iV = linearLayoutManager.v();
            for (int i14 = 0; i14 < iV; i14++) {
                if (f8.a(linearLayoutManager.u(i14))) {
                    xe.q("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                    return;
                }
            }
        } else if (linearLayoutManager.v() <= 1) {
            iV = linearLayoutManager.v();
            while (i14 < iV) {
            }
        }
        Locale locale = Locale.US;
        xe.q(dw2.A(pq3Var.c, "Page can only be offset by a positive amount, not by "));
    }
}
