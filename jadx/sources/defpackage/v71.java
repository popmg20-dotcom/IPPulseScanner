package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textview.MaterialTextView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v71 extends o {
    public h4 b;
    public v32 f;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        if (r12 == r8) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(android.app.ApplicationExitInfo r11, defpackage.ie0 r12) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v71.j(android.app.ApplicationExitInfo, ie0):java.lang.Object");
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_exit_detail, viewGroup, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.divider;
            MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.divider);
            if (materialDivider != null) {
                i = R.id.fields;
                MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.fields);
                if (materialTextView != null) {
                    i = R.id.placeholder_hint;
                    MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.placeholder_hint);
                    if (materialTextView2 != null) {
                        i = R.id.scroll_view;
                        NestedScrollView nestedScrollView = (NestedScrollView) vf2.l(viewInflate, R.id.scroll_view);
                        if (nestedScrollView != null) {
                            i = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                            if (toolbar != null) {
                                i = R.id.toolbar_divider;
                                MaterialDivider materialDivider2 = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                                if (materialDivider2 != null) {
                                    i = R.id.trace;
                                    MaterialTextView materialTextView3 = (MaterialTextView) vf2.l(viewInflate, R.id.trace);
                                    if (materialTextView3 != null) {
                                        i = R.id.trace_header;
                                        MaterialTextView materialTextView4 = (MaterialTextView) vf2.l(viewInflate, R.id.trace_header);
                                        if (materialTextView4 != null) {
                                            i = R.id.trace_loading;
                                            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) vf2.l(viewInflate, R.id.trace_loading);
                                            if (circularProgressIndicator != null) {
                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                                this.b = new h4(coordinatorLayout, materialDivider, materialTextView, materialTextView2, nestedScrollView, toolbar, materialDivider2, materialTextView3, materialTextView4, circularProgressIndicator);
                                                coordinatorLayout.getClass();
                                                return coordinatorLayout;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        if (getArguments() == null || !requireArguments().getBoolean("show_nav_icon", true)) {
            h4 h4Var = this.b;
            h4Var.getClass();
            ((Toolbar) h4Var.i).setNavigationIcon((Drawable) null);
        } else {
            h4 h4Var2 = this.b;
            h4Var2.getClass();
            ((Toolbar) h4Var2.i).setNavigationOnClickListener(new mk(6, this));
        }
        h4 h4Var3 = this.b;
        h4Var3.getClass();
        ((Toolbar) h4Var3.i).o(R.menu.exit_detail);
        h4 h4Var4 = this.b;
        h4Var4.getClass();
        ((Toolbar) h4Var4.i).setOnMenuItemClickListener(new p71(this));
        h4 h4Var5 = this.b;
        h4Var5.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) h4Var5.b;
        p71 p71Var = new p71(this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(coordinatorLayout, p71Var);
        h4 h4Var6 = this.b;
        h4Var6.getClass();
        ((MaterialDivider) h4Var6.a).animate().alpha(0.0f).setDuration(0L).start();
        h4 h4Var7 = this.b;
        h4Var7.getClass();
        ((NestedScrollView) h4Var7.g).setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: q71
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i, int i2, int i3, int i4) {
                v71 v71Var = this.a;
                if (i2 == 0) {
                    h4 h4Var8 = v71Var.b;
                    h4Var8.getClass();
                    ((MaterialDivider) h4Var8.a).animate().alpha(0.0f).setDuration(100L).start();
                } else if (i4 == 0) {
                    h4 h4Var9 = v71Var.b;
                    h4Var9.getClass();
                    ((MaterialDivider) h4Var9.a).animate().alpha(1.0f).setDuration(100L).start();
                }
            }
        });
        Bundle arguments = getArguments();
        h4 h4Var8 = this.b;
        if (arguments != null) {
            h4Var8.getClass();
            ((NestedScrollView) h4Var8.g).setVisibility(0);
            h4 h4Var9 = this.b;
            h4Var9.getClass();
            ((MaterialTextView) h4Var9.d).setVisibility(8);
            long j = requireArguments().getLong("timestamp");
            int i = requireArguments().getInt("pid");
            da2 viewLifecycleOwner = getViewLifecycleOwner();
            viewLifecycleOwner.getClass();
            ji0.B(uf2.t(viewLifecycleOwner), null, null, new u71(this, j, i, null), 3);
            return;
        }
        h4Var8.getClass();
        ((NestedScrollView) h4Var8.g).setVisibility(8);
        h4 h4Var10 = this.b;
        h4Var10.getClass();
        ((MaterialTextView) h4Var10.d).setVisibility(0);
        h4 h4Var11 = this.b;
        h4Var11.getClass();
        ((MaterialTextView) h4Var11.d).setText(getString(R.string.exit_detail_placeholder));
        h4 h4Var12 = this.b;
        h4Var12.getClass();
        ((Toolbar) h4Var12.i).setTitle((CharSequence) null);
        h4 h4Var13 = this.b;
        h4Var13.getClass();
        MenuItem menuItemFindItem = ((Toolbar) h4Var13.i).getMenu().findItem(R.id.share);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(false);
        }
    }
}
