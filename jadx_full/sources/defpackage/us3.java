package defpackage;

import j$.util.Optional;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class us3 extends w60 {
    public final ArrayList e;

    public us3(oa4 oa4Var, ArrayList arrayList, int i, Optional optional) {
        super(oa4Var, i, optional);
        this.e = arrayList;
    }

    @Override // defpackage.ds2
    public final int a() {
        return 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (ds2 ds2Var : this.e) {
            if (ds2Var instanceof w60) {
                sb.append(System.identityHashCode(ds2Var));
            } else {
                sb.append(ds2Var.toString());
            }
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return "<" + us3.class.getName() + " (tag=" + this.b + ", value=[" + ((Object) sb) + "])>";
    }
}
