package defpackage;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lx4 {
    public final pl3 a;
    public final lo0 b = new lo0(8);

    public lx4(pl3 pl3Var) {
        this.a = pl3Var;
    }

    public final void a(String str, Set set) {
        str.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ke0.r(this.a, false, true, new gj(26, this, new kx4((String) it.next(), str)));
        }
    }
}
