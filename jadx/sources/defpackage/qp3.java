package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum qp3 {
    f(Optional.of(Character.valueOf(StringUtil.DOUBLE_QUOTE))),
    z(Optional.of('\'')),
    A(Optional.of('|')),
    X(Optional.of('>')),
    /* JADX INFO: Fake field, exist only in values array */
    EF7(Optional.of('J')),
    Y(Optional.empty());

    public final Optional b;

    qp3(Optional optional) {
        this.b = optional;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return String.valueOf(this.b.orElse(':'));
    }
}
