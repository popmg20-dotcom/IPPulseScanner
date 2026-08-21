package defpackage;

import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bq2 extends nk2 {
    @Override // defpackage.nk2, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        sk2 sk2VarA = a(i, i2, i3, charSequence);
        pp2 pp2Var = new pp2(this.a, this, sk2VarA, 1);
        sk2VarA.o = pp2Var;
        pp2Var.setHeaderTitle(sk2VarA.e);
        return pp2Var;
    }
}
