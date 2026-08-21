package defpackage;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y12 {
    public final pl3 a;
    public final vh4 b;
    public final LinkedHashMap c;
    public final ReentrantLock d;
    public final t4 e;
    public final t4 f;
    public final eg0 g;
    public final Object h;

    public y12(pl3 pl3Var, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, String... strArr) {
        this.a = pl3Var;
        vh4 vh4Var = new vh4(pl3Var, linkedHashMap, linkedHashMap2, strArr, pl3Var.j, new x12(1, this, y12.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0, 0));
        this.b = vh4Var;
        this.c = new LinkedHashMap();
        this.d = new ReentrantLock();
        this.e = new t4(this, 10);
        this.f = new t4(this, 11);
        this.g = new eg0(pl3Var);
        this.h = new Object();
        vh4Var.k = new fn(8, this);
    }

    public final zf1 a(boolean z, String[] strArr) {
        vh4 vh4Var = this.b;
        e03 e03VarH = vh4Var.h(strArr);
        String[] strArr2 = (String[]) e03VarH.b;
        int[] iArr = (int[]) e03VarH.f;
        strArr2.getClass();
        iArr.getClass();
        return new av(7, new fh0(vh4Var, iArr, z, strArr2, null));
    }

    public final ql3 b(String[] strArr, am1 am1Var) {
        this.b.h(strArr);
        eg0 eg0Var = this.g;
        eg0Var.getClass();
        return new ql3((pl3) eg0Var.f, eg0Var, strArr, am1Var);
    }

    public final Object c(v74 v74Var) {
        Object objG;
        pl3 pl3Var = this.a;
        return ((!pl3Var.k() || pl3Var.o()) && (objG = this.b.g(v74Var)) == mf0.b) ? objG : xl4.a;
    }
}
