package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xk1 extends xg4 {
    public final /* synthetic */ Object a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ zk1 e;

    public xk1(zk1 zk1Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.e = zk1Var;
        this.a = obj;
        this.b = arrayList;
        this.c = obj2;
        this.d = arrayList2;
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void a(vg4 vg4Var) {
        zk1 zk1Var = this.e;
        Object obj = this.a;
        if (obj != null) {
            zk1Var.z(obj, this.b, null);
        }
        Object obj2 = this.c;
        if (obj2 != null) {
            zk1Var.z(obj2, this.d, null);
        }
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void c(vg4 vg4Var) {
        vg4Var.E(this);
    }
}
