package defpackage;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m6 extends ArrayAdapter {
    public final /* synthetic */ AlertController$RecycleListView b;
    public final /* synthetic */ p6 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m6(p6 p6Var, ContextThemeWrapper contextThemeWrapper, int i, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(contextThemeWrapper, i, R.id.text1, charSequenceArr);
        this.f = p6Var;
        this.b = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f.w;
        if (zArr != null && zArr[i]) {
            this.b.setItemChecked(i, true);
        }
        return view2;
    }
}
