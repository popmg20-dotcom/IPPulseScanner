package defpackage;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n6 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ s6 b;
    public final /* synthetic */ p6 f;

    public n6(p6 p6Var, s6 s6Var) {
        this.f = p6Var;
        this.b = s6Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        p6 p6Var = this.f;
        DialogInterface.OnClickListener onClickListener = p6Var.t;
        s6 s6Var = this.b;
        onClickListener.onClick(s6Var.b, i);
        if (p6Var.y) {
            return;
        }
        s6Var.b.dismiss();
    }
}
