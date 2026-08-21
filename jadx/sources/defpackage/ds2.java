package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ds2 {
    public final Optional a;
    public final oa4 b;
    public boolean c;
    public Optional d;

    public ds2(oa4 oa4Var, Optional optional) {
        Objects.requireNonNull(oa4Var, "tag in a Node is required.");
        this.b = oa4Var;
        this.a = optional;
        this.c = false;
        this.d = Optional.empty();
    }

    public abstract int a();

    public final boolean equals(Object obj) {
        return this == obj;
    }
}
