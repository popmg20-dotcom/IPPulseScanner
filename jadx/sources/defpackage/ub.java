package defpackage;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ub implements ac, DialogInterface.OnClickListener {
    public final /* synthetic */ bc A;
    public u6 b;
    public vb f;
    public CharSequence z;

    public ub(bc bcVar) {
        this.A = bcVar;
    }

    @Override // defpackage.ac
    public final boolean b() {
        u6 u6Var = this.b;
        if (u6Var != null) {
            return u6Var.isShowing();
        }
        return false;
    }

    @Override // defpackage.ac
    public final int c() {
        return 0;
    }

    @Override // defpackage.ac
    public final void dismiss() {
        u6 u6Var = this.b;
        if (u6Var != null) {
            u6Var.dismiss();
            this.b = null;
        }
    }

    @Override // defpackage.ac
    public final void e(int i) {
        a1.d("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.ac
    public final CharSequence f() {
        return this.z;
    }

    @Override // defpackage.ac
    public final Drawable h() {
        return null;
    }

    @Override // defpackage.ac
    public final void i(CharSequence charSequence) {
        this.z = charSequence;
    }

    @Override // defpackage.ac
    public final void j(Drawable drawable) {
        a1.d("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.ac
    public final void l(int i) {
        a1.d("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.ac
    public final void m(int i) {
        a1.d("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.ac
    public final void n(int i, int i2) {
        if (this.f == null) {
            return;
        }
        bc bcVar = this.A;
        t6 t6Var = new t6(bcVar.getPopupContext());
        p6 p6Var = (p6) t6Var.z;
        CharSequence charSequence = this.z;
        if (charSequence != null) {
            p6Var.e = charSequence;
        }
        vb vbVar = this.f;
        int selectedItemPosition = bcVar.getSelectedItemPosition();
        p6Var.s = vbVar;
        p6Var.t = this;
        p6Var.z = selectedItemPosition;
        p6Var.y = true;
        u6 u6VarH = t6Var.h();
        this.b = u6VarH;
        AlertController$RecycleListView alertController$RecycleListView = u6VarH.Z.f;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i2);
        this.b.show();
    }

    @Override // defpackage.ac
    public final int o() {
        return 0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        bc bcVar = this.A;
        bcVar.setSelection(i);
        if (bcVar.getOnItemClickListener() != null) {
            bcVar.performItemClick(null, i, this.f.getItemId(i));
        }
        dismiss();
    }

    @Override // defpackage.ac
    public final void p(ListAdapter listAdapter) {
        this.f = (vb) listAdapter;
    }
}
