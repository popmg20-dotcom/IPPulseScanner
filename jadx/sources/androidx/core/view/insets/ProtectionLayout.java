package androidx.core.view.insets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import defpackage.ga1;
import defpackage.h93;
import defpackage.qe4;
import defpackage.st4;
import defpackage.w84;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ProtectionLayout extends FrameLayout {
    public static final Object z = new Object();
    public final ArrayList b;
    public h93 f;

    public ProtectionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        this.b = new ArrayList();
    }

    private w84 getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof w84) {
            return (w84) tag;
        }
        w84 w84Var = new w84(viewGroup);
        viewGroup.setTag(R.id.tag_system_bar_state_monitor, w84Var);
        return w84Var;
    }

    public final void a() {
        ArrayList arrayList = this.b;
        if (arrayList.isEmpty()) {
            b();
            return;
        }
        w84 orInstallSystemBarStateMonitor = getOrInstallSystemBarStateMonitor();
        b();
        this.f = new h93(orInstallSystemBarStateMonitor, arrayList);
        getChildCount();
        if (this.f.a.size() <= 0) {
            return;
        }
        if (this.f.a.get(0) != null) {
            st4.n();
        } else {
            getContext();
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != z) {
            h93 h93Var = this.f;
            int childCount = getChildCount() - (h93Var != null ? h93Var.a.size() : 0);
            if (i > childCount || i < 0) {
                i = childCount;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b() {
        if (this.f != null) {
            removeViews(getChildCount() - this.f.a.size(), this.f.a.size());
            int size = this.f.a.size();
            h93 h93Var = this.f;
            if (size > 0) {
                throw qe4.r(h93Var.a, 0);
            }
            ArrayList arrayList = h93Var.a;
            if (!h93Var.d) {
                h93Var.d = true;
                h93Var.b.b.remove(h93Var);
                int size2 = arrayList.size() - 1;
                if (size2 >= 0) {
                    throw qe4.r(arrayList, size2);
                }
                arrayList.clear();
            }
            this.f = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof w84) {
            w84 w84Var = (w84) tag;
            if (w84Var.b.isEmpty()) {
                w84Var.a.post(new ga1(23, w84Var));
                viewGroup.setTag(R.id.tag_system_bar_state_monitor, null);
            }
        }
    }

    public void setProtections(List<Object> list) {
        ArrayList arrayList = this.b;
        arrayList.clear();
        arrayList.addAll(list);
        if (isAttachedToWindow()) {
            a();
            requestApplyInsets();
        }
    }

    public ProtectionLayout(Context context) {
        super(context);
        this.b = new ArrayList();
    }
}
