package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hc1 extends jc1 {
    @Override // defpackage.jc1
    public final jc1 a(v62 v62Var) {
        ub2 ub2VarI = p95.i();
        List list = this.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ub2VarI.add(((hg0) list.get(i)).e(v62Var));
        }
        ub2 ub2VarC = p95.c(ub2VarI);
        ub2VarC.getClass();
        return new hc1(ub2VarC);
    }

    public final String toString() {
        return "Edge";
    }
}
