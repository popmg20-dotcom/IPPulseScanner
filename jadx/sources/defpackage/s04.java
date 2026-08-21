package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s04 extends v04 {
    public final Set j;
    public final u04 k;
    public final u04 l;
    public final boolean m;

    public s04(Set set, n04 n04Var, String str, u04 u04Var, u04 u04Var2, boolean z, int i, int i2, int i3, x21 x21Var, x21 x21Var2) {
        super(str, i, i2, i3, x21Var, x21Var2, n04Var);
        this.j = set;
        this.k = u04Var;
        this.l = u04Var2;
        this.m = z;
    }

    @Override // defpackage.v04, defpackage.d31
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof s04) && super.equals(obj)) {
            s04 s04Var = (s04) obj;
            if (this.j.equals(s04Var.j) && this.k == s04Var.k && this.l == s04Var.l && this.m == s04Var.m) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.v04, defpackage.d31
    public final int hashCode() {
        return ((this.l.hashCode() + ((this.k.hashCode() + ((this.j.hashCode() + (super.hashCode() * 31)) * 31)) * 31)) * 31) + (this.m ? 1231 : 1237);
    }

    public final String toString() {
        return s04.class.getSimpleName() + "{tag=" + a() + ", defaultSplitAttributes=" + this.g + ", minWidthDp=" + this.b + ", minHeightDp=" + this.c + ", minSmallestWidthDp=" + this.d + ", maxAspectRatioInPortrait=" + this.e + ", maxAspectRatioInLandscape=" + this.f + ", clearTop=" + this.m + ", finishPrimaryWithSecondary=" + this.k + ", finishSecondaryWithPrimary=" + this.l + ", filters=" + this.j + '}';
    }
}
