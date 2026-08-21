package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import defpackage.il2;
import defpackage.mk2;
import defpackage.n02;
import defpackage.nk2;
import defpackage.sk2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements mk2, il2, AdapterView.OnItemClickListener {
    public static final int[] f = {R.attr.background, R.attr.divider};
    public nk2 b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        n02 n02VarY = n02.y(context, attributeSet, f, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(n02VarY.o(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(n02VarY.o(1));
        }
        n02VarY.K();
    }

    @Override // defpackage.mk2
    public final boolean a(sk2 sk2Var) {
        return this.b.s(sk2Var, null, 0);
    }

    @Override // defpackage.il2
    public final void b(nk2 nk2Var) {
        this.b = nk2Var;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((sk2) getAdapter().getItem(i));
    }
}
