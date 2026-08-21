package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pp3 extends ds2 {
    public final String e;

    public pp3(oa4 oa4Var, String str, qp3 qp3Var, Optional optional) {
        super(oa4Var, optional);
        this.e = str;
        Objects.requireNonNull(qp3Var, "Scalar style must be provided.");
    }

    @Override // defpackage.ds2
    public final int a() {
        return 1;
    }

    public final String toString() {
        String name = pp3.class.getName();
        StringBuilder sb = new StringBuilder("<");
        sb.append(name);
        sb.append(" (tag=");
        sb.append(this.b);
        sb.append(", value=");
        return fw.y(sb, this.e, ")>");
    }
}
