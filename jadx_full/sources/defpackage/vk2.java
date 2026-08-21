package defpackage;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vk2 extends FrameLayout implements u60 {
    public final CollapsibleActionView b;

    /* JADX WARN: Multi-variable type inference failed */
    public vk2(View view) {
        super(view.getContext());
        this.b = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // defpackage.u60
    public final void onActionViewCollapsed() {
        this.b.onActionViewCollapsed();
    }

    @Override // defpackage.u60
    public final void onActionViewExpanded() {
        this.b.onActionViewExpanded();
    }
}
