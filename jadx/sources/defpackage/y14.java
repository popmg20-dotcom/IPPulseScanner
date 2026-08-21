package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y14 extends u3 implements lk2 {
    public ActionBarContextView A;
    public lb X;
    public WeakReference Y;
    public boolean Z;
    public nk2 y0;
    public Context z;

    @Override // defpackage.lk2
    public final boolean V(nk2 nk2Var, sk2 sk2Var) {
        return ((iv1) this.X.f).u(this, sk2Var);
    }

    @Override // defpackage.u3
    public final void a() {
        if (this.Z) {
            return;
        }
        this.Z = true;
        this.X.C(this);
    }

    @Override // defpackage.lk2
    public final void a0(nk2 nk2Var) {
        g();
        q3 q3Var = this.A.A;
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
        return this.y0;
    }

    @Override // defpackage.u3
    public final MenuInflater d() {
        return new a64(this.A.getContext());
    }

    @Override // defpackage.u3
    public final CharSequence e() {
        return this.A.getSubtitle();
    }

    @Override // defpackage.u3
    public final CharSequence f() {
        return this.A.getTitle();
    }

    @Override // defpackage.u3
    public final void g() {
        this.X.D(this, this.y0);
    }

    @Override // defpackage.u3
    public final boolean h() {
        return this.A.M0;
    }

    @Override // defpackage.u3
    public final void i(View view) {
        this.A.setCustomView(view);
        this.Y = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.u3
    public final void j(int i) {
        k(this.z.getString(i));
    }

    @Override // defpackage.u3
    public final void k(CharSequence charSequence) {
        this.A.setSubtitle(charSequence);
    }

    @Override // defpackage.u3
    public final void l(int i) {
        m(this.z.getString(i));
    }

    @Override // defpackage.u3
    public final void m(CharSequence charSequence) {
        this.A.setTitle(charSequence);
    }

    @Override // defpackage.u3
    public final void n(boolean z) {
        this.f = z;
        this.A.setTitleOptional(z);
    }
}
