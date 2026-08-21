package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i41 implements sz3 {
    public static final i41 f = new i41();
    public final ArrayList b;

    public i41() {
        ArrayList arrayList = new ArrayList(1);
        this.b = arrayList;
        arrayList.add(as2.a(0, 5L));
    }

    @Override // defpackage.sz3
    public final List g(int i) {
        return new ArrayList(this.b);
    }

    @Override // defpackage.sz3
    public final int l() {
        return 1;
    }

    @Override // defpackage.sz3
    public final void d(int i) {
    }
}
