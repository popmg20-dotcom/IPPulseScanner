package defpackage;

import j$.util.Objects;
import j$.util.Optional;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cv0 extends re4 {
    public final String c;
    public final Optional d;

    public cv0(String str, Optional optional, Optional optional2, Optional optional3) {
        super(optional2, optional3);
        this.c = str;
        Objects.requireNonNull(optional);
        if (optional.isPresent() && ((List) optional.get()).size() != 2) {
            throw new hy4(dw2.A(((List) optional.get()).size(), "Two strings/integers must be provided instead of "));
        }
        this.d = optional;
    }

    @Override // defpackage.re4
    public final int a() {
        return 7;
    }
}
