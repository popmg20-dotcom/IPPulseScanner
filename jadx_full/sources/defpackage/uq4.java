package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uq4 extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq4(ViewPager2 viewPager2, Context context) {
        super(context);
        this.F = viewPager2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void J0(ng3 ng3Var, int[] iArr) {
        ViewPager2 viewPager2 = this.F;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.J0(ng3Var, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final void Z(ig3 ig3Var, ng3 ng3Var, p2 p2Var) {
        super.Z(ig3Var, ng3Var, p2Var);
        this.F.N0.getClass();
    }

    @Override // defpackage.ag3
    public final void a0(ig3 ig3Var, ng3 ng3Var, View view, p2 p2Var) {
        int iK;
        ViewPager2 viewPager2 = (ViewPager2) this.F.N0.d;
        int iK2 = 0;
        if (viewPager2.getOrientation() == 1) {
            viewPager2.A0.getClass();
            iK = ag3.K(view);
        } else {
            iK = 0;
        }
        if (viewPager2.getOrientation() == 0) {
            viewPager2.A0.getClass();
            iK2 = ag3.K(view);
        }
        p2Var.k(o2.a(iK, 1, iK2, false, 1, false));
    }

    @Override // defpackage.ag3
    public final boolean o0(ig3 ig3Var, ng3 ng3Var, int i, Bundle bundle) {
        this.F.N0.getClass();
        return super.o0(ig3Var, ng3Var, i, bundle);
    }

    @Override // defpackage.ag3
    public final boolean t0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }
}
