package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class f80 extends re4 {
    public final int c;
    public final String d;

    public f80(int i, String str, Optional optional, Optional optional2) {
        super(optional, optional2);
        if (i == 0) {
            throw null;
        }
        this.c = i;
        Objects.requireNonNull(str);
        this.d = str;
    }

    @Override // defpackage.re4
    public final int a() {
        return 20;
    }
}
