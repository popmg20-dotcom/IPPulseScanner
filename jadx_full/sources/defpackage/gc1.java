package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gc1 extends jc1 {
    public final long b;
    public final long c;
    public final boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc1(List list, long j, long j2, boolean z) {
        super(list);
        list.getClass();
        this.b = j;
        this.c = j2;
        this.d = z;
    }

    @Override // defpackage.jc1
    public final jc1 a(v62 v62Var) {
        ub2 ub2VarI = p95.i();
        List list = this.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ub2VarI.add(((hg0) list.get(i)).e(v62Var));
        }
        return new gc1(p95.c(ub2VarI), yr2.o0(this.b, v62Var), yr2.o0(this.c, v62Var), this.d);
    }

    public final String toString() {
        return "Corner: vertex=" + ((Object) qf1.b(this.b)) + ", center=" + ((Object) qf1.b(this.c)) + ", convex=" + this.d;
    }
}
