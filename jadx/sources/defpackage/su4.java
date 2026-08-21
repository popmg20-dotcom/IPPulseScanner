package defpackage;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class su4 extends ru4 {
    public su4(bv4 bv4Var, WindowInsets windowInsets) {
        super(bv4Var, windowInsets);
    }

    @Override // defpackage.yu4
    public bv4 a() {
        return bv4.g(this.c.consumeDisplayCutout(), null);
    }

    @Override // defpackage.qu4, defpackage.yu4
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof su4)) {
            return false;
        }
        su4 su4Var = (su4) obj;
        return Objects.equals(this.c, su4Var.c) && Objects.equals(this.g, su4Var.g) && qu4.L(this.h, su4Var.h);
    }

    @Override // defpackage.yu4
    public rv0 g() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new rv0(displayCutout);
    }

    @Override // defpackage.yu4
    public int hashCode() {
        return this.c.hashCode();
    }
}
