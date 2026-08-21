package defpackage;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j74 {
    public final Object a = new Object();
    public final Size b;
    public final oz0 c;
    public final mz d;
    public final boolean e;
    public final yv f;
    public final vv g;
    public final yv h;
    public final vv i;
    public final vv j;
    public final az1 k;
    public oh l;
    public i74 m;
    public Executor n;

    static {
        Range range = ih.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j74(Size size, mz mzVar, boolean z, oz0 oz0Var, x64 x64Var) {
        this.b = size;
        this.d = mzVar;
        this.e = z;
        r25.f(oz0Var.b(), "SurfaceRequest's DynamicRange must always be fully specified.");
        this.c = oz0Var;
        String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        AtomicReference atomicReference = new AtomicReference(null);
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            atomicReference.set(vvVar);
            vvVar.a = str.concat("-cancellation");
        } catch (Exception e) {
            yvVar.b(e);
        }
        vv vvVar2 = (vv) atomicReference.get();
        vvVar2.getClass();
        this.j = vvVar2;
        AtomicReference atomicReference2 = new AtomicReference(null);
        vv vvVar3 = new vv();
        vvVar3.c = new wj3();
        yv yvVar2 = new yv(vvVar3);
        vvVar3.b = yvVar2;
        vvVar3.a = fw.class;
        try {
            atomicReference2.set(vvVar3);
            vvVar3.a = str.concat("-status");
        } catch (Exception e2) {
            yvVar2.b(e2);
        }
        this.h = yvVar2;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        yvVar2.a(new um1((int) (0 == true ? 1 : 0), (Object) yvVar2, (Object) new e24(5, vvVar2, yvVar, false)), yu0.a());
        vv vvVar4 = (vv) atomicReference2.get();
        vvVar4.getClass();
        AtomicReference atomicReference3 = new AtomicReference(null);
        vv vvVar5 = new vv();
        vvVar5.c = new wj3();
        yv yvVar3 = new yv(vvVar5);
        vvVar5.b = yvVar3;
        vvVar5.a = fw.class;
        try {
            atomicReference3.set(vvVar5);
            vvVar5.a = str.concat("-Surface");
        } catch (Exception e3) {
            yvVar3.b(e3);
        }
        this.f = yvVar3;
        vv vvVar6 = (vv) atomicReference3.get();
        vvVar6.getClass();
        this.g = vvVar6;
        az1 az1Var = new az1(this, size);
        this.k = az1Var;
        nc2 nc2VarK = n12.K(az1Var.e);
        yvVar3.a(new um1((int) (objArr2 == true ? 1 : 0), (Object) yvVar3, (Object) new n02(23, nc2VarK, vvVar4, str)), yu0.a());
        nc2VarK.a(new wm0(this, 1), yu0.a());
        yu0 yu0VarA = yu0.a();
        AtomicReference atomicReference4 = new AtomicReference(null);
        yv yvVarM = fx3.m(new ed(16, this, atomicReference4));
        yvVarM.a(new um1((int) (objArr == true ? 1 : 0), (Object) yvVarM, (Object) new ha1(26, x64Var)), yu0VarA);
        vv vvVar7 = (vv) atomicReference4.get();
        vvVar7.getClass();
        this.i = vvVar7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final Surface surface, Executor executor, final dd0 dd0Var) {
        final int i = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (!surface.isValid()) {
            executor.execute(new Runnable() { // from class: g74
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    Surface surface2 = surface;
                    dd0 dd0Var2 = dd0Var;
                    switch (i2) {
                        case 0:
                            dd0Var2.accept(new nh(2, surface2));
                            break;
                        case 1:
                            dd0Var2.accept(new nh(3, surface2));
                            break;
                        default:
                            dd0Var2.accept(new nh(4, surface2));
                            break;
                    }
                }
            });
            return;
        }
        if (!this.g.b(surface)) {
            yv yvVar = this.f;
            if (!yvVar.isCancelled()) {
                r25.j(null, yvVar.f.isDone());
                try {
                    yvVar.get();
                    final int i2 = 1;
                    executor.execute(new Runnable() { // from class: g74
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i22 = i2;
                            Surface surface2 = surface;
                            dd0 dd0Var2 = dd0Var;
                            switch (i22) {
                                case 0:
                                    dd0Var2.accept(new nh(2, surface2));
                                    break;
                                case 1:
                                    dd0Var2.accept(new nh(3, surface2));
                                    break;
                                default:
                                    dd0Var2.accept(new nh(4, surface2));
                                    break;
                            }
                        }
                    });
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    final int i3 = 2;
                    executor.execute(new Runnable() { // from class: g74
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i22 = i3;
                            Surface surface2 = surface;
                            dd0 dd0Var2 = dd0Var;
                            switch (i22) {
                                case 0:
                                    dd0Var2.accept(new nh(2, surface2));
                                    break;
                                case 1:
                                    dd0Var2.accept(new nh(3, surface2));
                                    break;
                                default:
                                    dd0Var2.accept(new nh(4, surface2));
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
        }
        e24 e24Var = new e24(6, dd0Var, surface, objArr2 == true ? 1 : 0);
        yv yvVar2 = this.h;
        yvVar2.a(new um1((int) (objArr == true ? 1 : 0), (Object) yvVar2, (Object) e24Var), executor);
    }

    public final void b(Executor executor, i74 i74Var) {
        oh ohVar;
        synchronized (this.a) {
            this.m = i74Var;
            this.n = executor;
            ohVar = this.l;
        }
        if (ohVar != null) {
            executor.execute(new f74(i74Var, ohVar, 1));
        }
    }

    public final boolean c() {
        return this.g.d(new w9("Surface request will not complete."));
    }
}
