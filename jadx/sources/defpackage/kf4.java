package defpackage;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kf4 extends tj4 {
    public final mf4 l;
    public final Window.Callback m;
    public final wn1 n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final ArrayList r = new ArrayList();
    public final f33 s = new f33(27, this);

    public kf4(Toolbar toolbar, CharSequence charSequence, ua uaVar) {
        ub4 ub4Var = new ub4(this);
        mf4 mf4Var = new mf4(toolbar, false);
        this.l = mf4Var;
        uaVar.getClass();
        this.m = uaVar;
        mf4Var.k = uaVar;
        toolbar.setOnMenuItemClickListener(ub4Var);
        boolean z = mf4Var.g;
        if (!z) {
            mf4Var.h = charSequence;
            if ((mf4Var.b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (z) {
                    wp4.o(toolbar.getRootView(), charSequence);
                }
            }
        }
        this.n = new wn1(26, this);
    }

    @Override // defpackage.tj4
    public final int C() {
        return this.l.b;
    }

    @Override // defpackage.tj4
    public final Context F() {
        return this.l.a.getContext();
    }

    @Override // defpackage.tj4
    public final boolean I() {
        mf4 mf4Var = this.l;
        Toolbar toolbar = mf4Var.a;
        f33 f33Var = this.s;
        toolbar.removeCallbacks(f33Var);
        Toolbar toolbar2 = mf4Var.a;
        WeakHashMap weakHashMap = wp4.a;
        toolbar2.postOnAnimation(f33Var);
        return true;
    }

    @Override // defpackage.tj4
    public final void R() {
        this.l.a.removeCallbacks(this.s);
    }

    @Override // defpackage.tj4
    public final boolean S(int i, KeyEvent keyEvent) {
        Menu menuP0 = p0();
        if (menuP0 == null) {
            return false;
        }
        menuP0.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menuP0.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.tj4
    public final boolean T(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            U();
        }
        return true;
    }

    @Override // defpackage.tj4
    public final boolean U() {
        return this.l.a.x();
    }

    @Override // defpackage.tj4
    public final void c0(CharSequence charSequence) {
        mf4 mf4Var = this.l;
        if (mf4Var.g) {
            return;
        }
        Toolbar toolbar = mf4Var.a;
        mf4Var.h = charSequence;
        if ((mf4Var.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (mf4Var.g) {
                wp4.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // defpackage.tj4
    public final boolean p() {
        q3 q3Var;
        ActionMenuView actionMenuView = this.l.a.b;
        return (actionMenuView == null || (q3Var = actionMenuView.N0) == null || !q3Var.g()) ? false : true;
    }

    public final Menu p0() {
        boolean z = this.p;
        mf4 mf4Var = this.l;
        if (!z) {
            sn snVar = new sn(this);
            jf4 jf4Var = new jf4(0, this);
            Toolbar toolbar = mf4Var.a;
            toolbar.h1 = snVar;
            toolbar.i1 = jf4Var;
            ActionMenuView actionMenuView = toolbar.b;
            if (actionMenuView != null) {
                actionMenuView.O0 = snVar;
                actionMenuView.P0 = jf4Var;
            }
            this.p = true;
        }
        return mf4Var.a.getMenu();
    }

    @Override // defpackage.tj4
    public final boolean q() {
        sk2 sk2Var;
        ff4 ff4Var = this.l.a.g1;
        if (ff4Var == null || (sk2Var = ff4Var.f) == null) {
            return false;
        }
        if (ff4Var == null) {
            sk2Var = null;
        }
        if (sk2Var == null) {
            return true;
        }
        sk2Var.collapseActionView();
        return true;
    }

    @Override // defpackage.tj4
    public final void w(boolean z) {
        if (z == this.q) {
            return;
        }
        this.q = z;
        ArrayList arrayList = this.r;
        if (arrayList.size() > 0) {
            throw qe4.r(arrayList, 0);
        }
    }

    @Override // defpackage.tj4
    public final void Q() {
    }

    @Override // defpackage.tj4
    public final void Z(boolean z) {
    }

    @Override // defpackage.tj4
    public final void b0(boolean z) {
    }
}
