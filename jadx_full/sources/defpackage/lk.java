package defpackage;

import android.view.View;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lk implements v23, mu2 {
    public final /* synthetic */ nk b;

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        view.getClass();
        RecyclerView listView = this.b.getListView();
        listView.getClass();
        listView.setPadding(listView.getPaddingLeft(), listView.getPaddingTop(), listView.getPaddingRight(), bv4Var.a.h(519).d);
        return bv4Var;
    }

    @Override // defpackage.v23
    public boolean i(Preference preference, Object obj) {
        this.b.promptRestartVPN();
        return true;
    }
}
