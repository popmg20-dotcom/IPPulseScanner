package defpackage;

import j$.util.Objects;
import j$.util.Optional;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dh2 extends w60 {
    public List e;
    public boolean f;

    public dh2(oa4 oa4Var, List list, int i, Optional optional) {
        super(oa4Var, i, optional);
        this.f = false;
        Objects.requireNonNull(list);
        this.e = list;
    }

    @Override // defpackage.ds2
    public final int a() {
        return 3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (hs2 hs2Var : this.e) {
            sb.append("{ key=");
            sb.append(hs2Var.a);
            sb.append("; value=");
            ds2 ds2Var = hs2Var.b;
            if (ds2Var instanceof w60) {
                sb.append(System.identityHashCode(ds2Var));
            } else {
                sb.append(hs2Var);
            }
            sb.append(" }");
        }
        String string = sb.toString();
        String name = dh2.class.getName();
        StringBuilder sb2 = new StringBuilder("<");
        sb2.append(name);
        sb2.append(" (tag=");
        sb2.append(this.b);
        sb2.append(", values=");
        return fw.y(sb2, string, ")>");
    }
}
