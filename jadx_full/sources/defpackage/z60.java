package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z60 extends fs2 {
    public final Optional d;
    public final boolean e;
    public final int f;

    public z60(Optional optional, Optional optional2, boolean z, int i, Optional optional3, Optional optional4) {
        super(optional, optional3, optional4);
        Objects.requireNonNull(optional2);
        this.d = optional2;
        this.e = z;
        if (i == 0) {
            throw null;
        }
        this.f = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.c.ifPresent(new y60(0, sb));
        if (!this.e) {
            this.d.ifPresent(new y60(1, sb));
        }
        return sb.toString();
    }
}
