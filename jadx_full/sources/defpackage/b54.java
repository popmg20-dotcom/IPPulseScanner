package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class b54 extends nk2 implements SubMenu {
    public final nk2 A;
    public final sk2 B;

    public b54(Context context, nk2 nk2Var, sk2 sk2Var) {
        super(context);
        this.A = nk2Var;
        this.B = sk2Var;
    }

    @Override // defpackage.nk2
    public final boolean d(sk2 sk2Var) {
        return this.A.d(sk2Var);
    }

    @Override // defpackage.nk2
    public final boolean e(nk2 nk2Var, sk2 sk2Var) {
        return super.e(nk2Var, sk2Var) || this.A.e(nk2Var, sk2Var);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.B;
    }

    @Override // defpackage.nk2
    public final boolean h(sk2 sk2Var) {
        return this.A.h(sk2Var);
    }

    @Override // defpackage.nk2
    public final String l() {
        sk2 sk2Var = this.B;
        int i = sk2Var != null ? sk2Var.a : 0;
        if (i == 0) {
            return null;
        }
        return dw2.A(i, "android:menu:actionviewstates:");
    }

    @Override // defpackage.nk2
    public final nk2 m() {
        return this.A.m();
    }

    @Override // defpackage.nk2
    public final boolean o() {
        return this.A.o();
    }

    @Override // defpackage.nk2
    public final boolean p() {
        return this.A.p();
    }

    @Override // defpackage.nk2
    public final boolean q() {
        return this.A.q();
    }

    @Override // defpackage.nk2, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.A.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        w(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        w(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        w(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.B.setIcon(drawable);
        return this;
    }

    @Override // defpackage.nk2, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.A.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.B.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        w(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        w(i, null, 0, null, null);
        return this;
    }
}
