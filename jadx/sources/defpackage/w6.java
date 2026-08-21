package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w6 extends fs2 {
    public final f7 d;

    public w6(Optional optional, Optional optional2, Optional optional3) {
        super(optional, optional2, optional3);
        this.d = (f7) optional.orElseThrow(new v6(0));
    }

    @Override // defpackage.x51
    public final int a() {
        return 1;
    }

    public final String toString() {
        return "=ALI *" + this.d;
    }
}
