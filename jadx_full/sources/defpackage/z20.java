package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class z20 extends b30 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater Y = AtomicIntegerFieldUpdater.newUpdater(z20.class, "consumed$volatile");
    public final y20 A;
    public final boolean X;
    private volatile /* synthetic */ int consumed$volatile;

    public /* synthetic */ z20(y20 y20Var, boolean z) {
        this(y20Var, z, c41.b, -3, jp.b);
    }

    @Override // defpackage.b30, defpackage.zf1
    public final Object a(ag1 ag1Var, ge0 ge0Var) {
        int i = this.f;
        mf0 mf0Var = mf0.b;
        if (i == -3) {
            boolean z = this.X;
            if (z && Y.getAndSet(this, 1) == 1) {
                xe.q("ReceiveChannel.consumeAsFlow can be collected just once");
                return null;
            }
            Object objS = ez4.s(ag1Var, this.A, z, ge0Var);
            if (objS == mf0Var) {
                return objS;
            }
        } else {
            Object objA = super.a(ag1Var, ge0Var);
            if (objA == mf0Var) {
                return objA;
            }
        }
        return xl4.a;
    }

    @Override // defpackage.b30
    public final String c() {
        return "channel=" + this.A;
    }

    @Override // defpackage.b30
    public final Object d(q53 q53Var, ge0 ge0Var) throws Throwable {
        Object objS = ez4.s(new rs3(q53Var), this.A, this.X, ge0Var);
        return objS == mf0.b ? objS : xl4.a;
    }

    @Override // defpackage.b30
    public final b30 e(cf0 cf0Var, int i, jp jpVar) {
        return new z20(this.A, this.X, cf0Var, i, jpVar);
    }

    @Override // defpackage.b30
    public final zf1 f() {
        return new z20(this.A, this.X);
    }

    @Override // defpackage.b30
    public final y20 g(lf0 lf0Var) {
        if (!this.X || Y.getAndSet(this, 1) != 1) {
            return this.f == -3 ? this.A : super.g(lf0Var);
        }
        xe.q("ReceiveChannel.consumeAsFlow can be collected just once");
        return null;
    }

    public z20(y20 y20Var, boolean z, cf0 cf0Var, int i, jp jpVar) {
        super(cf0Var, i, jpVar);
        this.A = y20Var;
        this.X = z;
    }
}
