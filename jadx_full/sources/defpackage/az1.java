package defpackage;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class az1 extends dn0 {
    public final /* synthetic */ int o = 0;
    public final Object p;

    public az1(Surface surface) {
        super(dn0.k, 0);
        this.p = surface;
    }

    @Override // defpackage.dn0
    public final nc2 f() {
        int i = this.o;
        Object obj = this.p;
        switch (i) {
            case 0:
                return n12.F((Surface) obj);
            default:
                return ((j74) obj).f;
        }
    }

    public az1(Surface surface, Size size, int i) {
        super(size, i);
        this.p = surface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az1(j74 j74Var, Size size) {
        super(size, 34);
        this.p = j74Var;
    }
}
