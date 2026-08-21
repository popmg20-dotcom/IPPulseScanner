package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bh2 extends x51 {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bh2(Optional optional, Optional optional2, int i) {
        super(optional, optional2);
        this.c = i;
    }

    @Override // defpackage.x51
    public final int a() {
        switch (this.c) {
            case 0:
                return 5;
            default:
                return 8;
        }
    }

    public final String toString() {
        switch (this.c) {
            case 0:
                return "-MAP";
            default:
                return "-SEQ";
        }
    }
}
