package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ut4 extends u3 implements lk2 {
    public final nk2 A;
    public lb X;
    public WeakReference Y;
    public final /* synthetic */ vt4 Z;
    public final Context z;

    public ut4(vt4 vt4Var, Context context, lb lbVar) {
        this.Z = vt4Var;
        this.z = context;
        this.X = lbVar;
        nk2 nk2Var = new nk2(context);
        nk2Var.l = 1;
        this.A = nk2Var;
        nk2Var.e = this;
    }

    @Override // defpackage.lk2
    public final boolean V(nk2 nk2Var, sk2 sk2Var) {
        lb lbVar = this.X;
        if (lbVar != null) {
            return ((iv1) lbVar.f).u(this, sk2Var);
        }
        return false;
    }

    @Override // defpackage.u3
    public final void a() {
        vt4 vt4Var = this.Z;
        if (vt4Var.t != this) {
            return;
        }
        if (vt4Var.A) {
            vt4Var.u = this;
            vt4Var.v = this.X;
        } else {
            this.X.C(this);
        }
        this.X = null;
        vt4Var.p0(false);
        ActionBarContextView actionBarContextView = vt4Var.q;
        if (actionBarContextView.E0 == null) {
            actionBarContextView.e();
        }
        vt4Var.n.setHideOnContentScrollEnabled(vt4Var.F);
        vt4Var.t = null;
    }

    @Override // defpackage.lk2
    public final void a0(nk2 nk2Var) {
        if (this.X == null) {
            return;
        }
        g();
        q3 q3Var = this.Z.q.A;
        if (q3Var != null) {
            q3Var.n();
        }
    }

    @Override // defpackage.u3
    public final View b() {
        WeakReference weakReference = this.Y;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.u3
    public final nk2 c() {
        return this.A;
    }

    @Override // defpackage.u3
    public final MenuInflater d() {
        return new a64(this.z);
    }

    @Override // defpackage.u3
    public final CharSequence e() {
        return this.Z.q.getSubtitle();
    }

    @Override // defpackage.u3
    public final CharSequence f() {
        return this.Z.q.getTitle();
    }

    @Override // defpackage.u3
    public final void g() {
        if (this.Z.t != this) {
            return;
        }
        nk2 nk2Var = this.A;
        nk2Var.y();
        try {
            this.X.D(this, nk2Var);
        } finally {
            nk2Var.x();
        }
    }

    @Override // defpackage.u3
    public final boolean h() {
        return this.Z.q.M0;
    }

    @Override // defpackage.u3
    public final void i(View view) {
        this.Z.q.setCustomView(view);
        this.Y = new WeakReference(view);
    }

    @Override // defpackage.u3
    public final void j(int i) {
        k(this.Z.l.getResources().getString(i));
    }

    @Override // defpackage.u3
    public final void k(CharSequence charSequence) {
        this.Z.q.setSubtitle(charSequence);
    }

    @Override // defpackage.u3
    public final void l(int i) {
        m(this.Z.l.getResources().getString(i));
    }

    @Override // defpackage.u3
    public final void m(CharSequence charSequence) {
        this.Z.q.setTitle(charSequence);
    }

    @Override // defpackage.u3
    public final void n(boolean z) {
        this.f = z;
        this.Z.q.setTitleOptional(z);
    }
}
