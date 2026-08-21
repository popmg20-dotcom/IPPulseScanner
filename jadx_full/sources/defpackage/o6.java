package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o6 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController$RecycleListView b;
    public final /* synthetic */ s6 f;
    public final /* synthetic */ p6 z;

    public o6(p6 p6Var, AlertController$RecycleListView alertController$RecycleListView, s6 s6Var) {
        this.z = p6Var;
        this.b = alertController$RecycleListView;
        this.f = s6Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        p6 p6Var = this.z;
        boolean[] zArr = p6Var.w;
        AlertController$RecycleListView alertController$RecycleListView = this.b;
        if (zArr != null) {
            zArr[i] = alertController$RecycleListView.isItemChecked(i);
        }
        p6Var.A.onClick(this.f.b, i, alertController$RecycleListView.isItemChecked(i));
    }
}
