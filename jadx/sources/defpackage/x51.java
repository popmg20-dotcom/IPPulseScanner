package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x51 {
    public final Optional a;
    public final Optional b;

    public x51(Optional optional, Optional optional2) {
        if ((optional.isPresent() && !optional2.isPresent()) || (!optional.isPresent() && optional2.isPresent())) {
            zo2.n("Both marks must be either present or absent.");
            throw null;
        }
        this.a = optional;
        this.b = optional2;
    }

    public abstract int a();
}
