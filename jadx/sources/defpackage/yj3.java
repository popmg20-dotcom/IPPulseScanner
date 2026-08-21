package defpackage;

import j$.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yj3 {
    public final oa4 a;
    public final Pattern b;

    public yj3(oa4 oa4Var, Pattern pattern) {
        Objects.requireNonNull(oa4Var);
        Objects.requireNonNull(pattern);
        this.a = oa4Var;
        this.b = pattern;
    }

    public final String toString() {
        return "Tuple tag=" + this.a + " regexp=" + this.b;
    }
}
