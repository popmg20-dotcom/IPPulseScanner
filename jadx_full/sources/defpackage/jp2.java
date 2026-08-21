package defpackage;

import android.content.Context;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jp2 extends nk2 {
    public final Class A;
    public final int B;
    public final boolean C;

    public jp2(Context context, Class cls, int i, boolean z) {
        super(context);
        this.A = cls;
        this.B = i;
        this.C = z;
    }

    @Override // defpackage.nk2
    public final sk2 a(int i, int i2, int i3, CharSequence charSequence) {
        int size = this.f.size() + 1;
        int i4 = this.B;
        if (size <= i4) {
            y();
            sk2 sk2VarA = super.a(i, i2, i3, charSequence);
            x();
            return sk2VarA;
        }
        String simpleName = this.A.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i4);
        sb.append(". Limit can be checked with ");
        xe.k(fw.y(sb, simpleName, "#getMaxItemCount()"));
        return null;
    }

    @Override // defpackage.nk2, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        if (!this.C) {
            vp1.n(this.A.getSimpleName().concat(" does not support submenus"));
            return null;
        }
        sk2 sk2VarA = a(i, i2, i3, charSequence);
        pp2 pp2Var = new pp2(this.a, this, sk2VarA, 0);
        sk2VarA.o = pp2Var;
        pp2Var.setHeaderTitle(sk2VarA.e);
        return pp2Var;
    }
}
