package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.NavigationMenuView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jq2 extends tg3 {
    public final /* synthetic */ mq2 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq2(mq2 mq2Var, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f = mq2Var;
    }

    @Override // defpackage.tg3, defpackage.h2
    public final void d(View view, p2 p2Var) {
        super.d(view, p2Var);
        mq2 mq2Var = this.f.X.g;
        int i = 0;
        for (int i2 = 0; i2 < mq2Var.X.d.size(); i2++) {
            int iD = mq2Var.X.d(i2);
            if (iD == 0 || iD == 1) {
                i++;
            }
        }
        p2Var.a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i, 1, false));
    }
}
