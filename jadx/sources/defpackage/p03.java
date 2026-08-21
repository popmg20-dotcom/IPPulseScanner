package defpackage;

import j$.util.Optional;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class p03 implements r53 {
    public final /* synthetic */ int a;
    public final /* synthetic */ s03 b;
    public final List c;

    public p03(s03 s03Var) {
        this.a = 0;
        this.b = s03Var;
        this.c = new LinkedList();
    }

    @Override // defpackage.r53
    public final x51 a() {
        int i = this.a;
        s03 s03Var = this.b;
        List list = this.c;
        switch (i) {
            case 0:
                LinkedList linkedList = (LinkedList) list;
                aq3 aq3Var = s03Var.b;
                if (aq3Var.c(20)) {
                    linkedList.add((f80) aq3Var.next());
                    return a();
                }
                if (aq3Var.d(15, 21, 3)) {
                    s03Var.Y = Optional.of(new p03(s03Var, linkedList));
                    return s03.f(aq3Var.o().a);
                }
                if (!linkedList.isEmpty()) {
                    return s03.g((f80) linkedList.remove(0));
                }
                s03Var.z.c(new o03(s03Var, 1));
                return s03Var.d(true, true);
            default:
                return !list.isEmpty() ? s03.g((f80) list.remove(0)) : new o03(s03Var, 1).a();
        }
    }

    public p03(s03 s03Var, LinkedList linkedList) {
        this.a = 1;
        this.b = s03Var;
        this.c = linkedList;
    }
}
