package defpackage;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vf {
    public final zf2 a;
    public final cf0 b;
    public int d;
    public final rf f;
    public final AtomicInteger g;
    public final AtomicReference h;
    public final CopyOnWriteArrayList i;
    public final f0 j;
    public final n84 k;
    public final um1 l;
    public final m24 c = n24.a(Boolean.FALSE);
    public final AtomicReference e = new AtomicReference(null);

    public vf(zf2 zf2Var, cf0 cf0Var, cf0 cf0Var2) {
        this.a = zf2Var;
        this.b = cf0Var2;
        rf rfVar = new rf(this, cf0Var);
        this.f = rfVar;
        this.g = new AtomicInteger(0);
        av avVar = new av(7, new uf(p95.b(new av(6, rfVar.k), -1), (ge0) null, this));
        gm0 gm0Var = qv0.a;
        p95.l(avVar, qf2.a);
        new ee3(rfVar.l);
        this.h = new AtomicReference(null);
        this.i = new CopyOnWriteArrayList();
        this.j = new f0(2, this);
        this.k = new n84(new t4(2));
        this.l = new um1(this);
    }
}
