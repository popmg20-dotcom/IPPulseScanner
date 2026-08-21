package defpackage;

import android.view.View;
import android.widget.ImageButton;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.widget.MetroLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wh0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public wh0(ga4 ga4Var, View view) {
        this.a = 3;
        this.c = ga4Var;
        this.b = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.a;
        View childAt = null;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i9) {
            case 0:
                view.removeOnLayoutChangeListener(this);
                xh0 xh0Var = (xh0) obj2;
                boolean z = xh0Var.getResources().getBoolean(R.bool.bottom_bar_displayed);
                j80 j80Var = xh0Var.b;
                if (z) {
                    j80Var.getClass();
                    MetroLayout metroLayout = (MetroLayout) ((oj1) j80Var.c).f;
                    j80 j80Var2 = xh0Var.b;
                    j80Var2.getClass();
                    metroLayout.setPadding(metroLayout.getPaddingLeft(), metroLayout.getPaddingTop(), metroLayout.getPaddingRight(), (ContextUtilsKt.e(R.dimen.fab_margin) * 2) + ((ExtendedFloatingActionButton) j80Var2.b).getHeight());
                    return;
                }
                j80Var.getClass();
                MetroLayout metroLayout2 = (MetroLayout) ((oj1) j80Var.c).f;
                j80 j80Var3 = xh0Var.b;
                j80Var3.getClass();
                metroLayout2.setPadding(metroLayout2.getPaddingLeft(), metroLayout2.getPaddingTop(), metroLayout2.getPaddingRight(), (ContextUtilsKt.e(R.dimen.fab_margin) * 2) + ((ExtendedFloatingActionButton) j80Var3.b).getHeight() + ((bv4) obj).a.h(519).d);
                return;
            case 1:
                view.removeOnLayoutChangeListener(this);
                cb3 cb3Var = (cb3) obj2;
                uf4 uf4Var = cb3Var.b;
                uf4Var.getClass();
                TabLayout tabLayout = (TabLayout) uf4Var.d;
                if ((tabLayout.getChildCount() > 0) && (childAt = tabLayout.getChildAt(0)) == null) {
                    throw new IndexOutOfBoundsException();
                }
                if (childAt != null) {
                    int width = childAt.getWidth();
                    uf4 uf4Var2 = cb3Var.b;
                    uf4Var2.getClass();
                    int paddingStart = ((TabLayout) uf4Var2.d).getPaddingStart() + width;
                    uf4 uf4Var3 = cb3Var.b;
                    uf4Var3.getClass();
                    int paddingEnd = ((TabLayout) uf4Var3.d).getPaddingEnd() + paddingStart;
                    uf4 uf4Var4 = cb3Var.b;
                    uf4Var4.getClass();
                    boolean z2 = paddingEnd > ((TabLayout) uf4Var4.d).getWidth();
                    uf4 uf4Var5 = cb3Var.b;
                    uf4Var5.getClass();
                    ((ImageButton) uf4Var5.g).setVisibility(z2 ? 0 : 8);
                    uf4 uf4Var6 = cb3Var.b;
                    uf4Var6.getClass();
                    ((ImageButton) uf4Var6.g).setOnClickListener(new bb3(cb3Var, (List) obj));
                    return;
                }
                return;
            case 2:
                x8 x8Var = (x8) obj2;
                view.getClass();
                if (view.isAttachedToWindow()) {
                    view.removeOnLayoutChangeListener(this);
                    wn1 wn1Var = (wn1) obj;
                    of2 of2Var = (of2) x8Var.Y;
                    if (of2Var == null) {
                        return;
                    }
                    x8Var.Y = null;
                    ((v62) wn1Var.f).C().postOnAnimation(new xy0(20, wn1Var, of2Var));
                    return;
                }
                return;
            default:
                View view2 = (View) obj2;
                if (view2.getVisibility() == 0) {
                    ((ga4) obj).c(view2);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ wh0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }
}
