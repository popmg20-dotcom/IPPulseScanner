package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class la2 extends s0 {
    public final /* synthetic */ jr2 A;
    public final /* synthetic */ c03 X;
    public final /* synthetic */ qn Y;
    public final /* synthetic */ int Z;
    public final /* synthetic */ na2 y0;
    public final /* synthetic */ qn z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public la2(na2 na2Var, u0 u0Var, qn qnVar, jr2 jr2Var, c03 c03Var, qn qnVar2, int i) {
        super(na2Var, u0Var);
        this.y0 = na2Var;
        this.z = qnVar;
        this.A = jr2Var;
        this.X = c03Var;
        this.Y = qnVar2;
        this.Z = i;
    }

    @Override // defpackage.s0
    public final Object a() {
        ReentrantLock reentrantLock = this.z.a;
        reentrantLock.lock();
        try {
            this.y0.f.y(0, r0.b.size() - 1, new ka2(this, this.A, this.X, this.z, this.Y));
            reentrantLock.unlock();
            return null;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.s0
    public final boolean b() {
        return super.b() && this.y0.A.get() == this.Z;
    }
}
