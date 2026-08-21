package defpackage;

import android.content.Intent;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t04 extends v04 {
    public final Set j;
    public final Intent k;
    public final boolean l;
    public final u04 m;

    public t04(String str, Set set, Intent intent, boolean z, u04 u04Var, int i, int i2, int i3, x21 x21Var, x21 x21Var2, n04 n04Var) {
        super(str, i, i2, i3, x21Var, x21Var2, n04Var);
        if (u04Var == u04.d) {
            xe.k("NEVER is not a valid configuration for SplitPlaceholderRule. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API.");
            throw null;
        }
        this.j = d70.C0(set);
        this.k = intent;
        this.l = z;
        this.m = u04Var;
    }

    @Override // defpackage.v04, defpackage.d31
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof t04) && super.equals(obj)) {
            t04 t04Var = (t04) obj;
            if (this.k.filterEquals(t04Var.k) && this.l == t04Var.l && this.m == t04Var.m && this.j.equals(t04Var.j)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.v04, defpackage.d31
    public final int hashCode() {
        return this.j.hashCode() + ((this.m.hashCode() + ((((this.k.filterHashCode() + (super.hashCode() * 31)) * 31) + (this.l ? 1231 : 1237)) * 31)) * 31);
    }

    public final String toString() {
        return "SplitPlaceholderRule{tag=" + a() + ", defaultSplitAttributes=" + this.g + ", minWidthDp=" + this.b + ", minHeightDp=" + this.c + ", minSmallestWidthDp=" + this.d + ", maxAspectRatioInPortrait=" + this.e + ", maxAspectRatioInLandscape=" + this.f + ", placeholderIntent=" + this.k + ", isSticky=" + this.l + ", finishPrimaryWithPlaceholder=" + this.m + ", filters=" + this.j + '}';
    }
}
