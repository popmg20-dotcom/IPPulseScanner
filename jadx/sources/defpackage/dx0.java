package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dx0 extends x51 {
    public final boolean c;

    public dx0(boolean z, Optional optional, Optional optional2) {
        super(optional, optional2);
        this.c = z;
    }

    @Override // defpackage.x51
    public final int a() {
        return 3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("-DOC");
        if (this.c) {
            sb.append(" ...");
        }
        return sb.toString();
    }
}
