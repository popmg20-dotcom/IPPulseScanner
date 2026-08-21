package defpackage;

import android.database.SQLException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ph4 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ vh4 y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ph4(vh4 vh4Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = vh4Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((ph4) n((ge0) obj2, (t13) obj)).p(xl4Var);
            case 1:
                return ((ph4) n((ge0) obj2, (jg4) obj)).p(xl4Var);
            default:
                return ((ph4) n((ge0) obj2, (jg4) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        vh4 vh4Var = this.y0;
        switch (i) {
            case 0:
                ph4 ph4Var = new ph4(vh4Var, ge0Var, 0);
                ph4Var.Z = obj;
                return ph4Var;
            case 1:
                ph4 ph4Var2 = new ph4(vh4Var, ge0Var, 1);
                ph4Var2.Z = obj;
                return ph4Var2;
            default:
                ph4 ph4Var3 = new ph4(vh4Var, ge0Var, 2);
                ph4Var3.Z = obj;
                return ph4Var3;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        jg4 jg4Var;
        Object objD;
        Object objA;
        jg4 jg4Var2;
        Object objD2;
        fu2[] fu2VarArr;
        fu2 fu2Var;
        int i = this.X;
        ig4 ig4Var = ig4.f;
        boolean z = false;
        mf0 mf0Var = mf0.b;
        boolean z2 = true;
        vh4 vh4Var = this.y0;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 != 0) {
                    if (i2 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                t13 t13Var = (t13) this.Z;
                this.Y = 1;
                Object objA2 = vh4Var.a(t13Var, this);
                return objA2 == mf0Var ? mf0Var : objA2;
            case 1:
                int i3 = this.Y;
                try {
                    if (i3 == 0) {
                        n12.S(obj);
                        jg4Var = (jg4) this.Z;
                        this.Z = jg4Var;
                        this.Y = 1;
                        objD = jg4Var.d(this);
                        if (objD == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                xe.q("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            n12.S(obj);
                            objA = obj;
                            return (Set) objA;
                        }
                        jg4Var = (jg4) this.Z;
                        n12.S(obj);
                        objD = obj;
                    }
                    if (!((Boolean) objD).booleanValue()) {
                        ph4 ph4Var = new ph4(vh4Var, ge0Var, 0);
                        this.Z = null;
                        this.Y = 2;
                        objA = jg4Var.a(ig4Var, ph4Var, this);
                        if (objA == mf0Var) {
                            return mf0Var;
                        }
                        return (Set) objA;
                    }
                } catch (SQLException unused) {
                }
                return k41.b;
            default:
                int i4 = this.Y;
                xl4 xl4Var = xl4.a;
                if (i4 == 0) {
                    n12.S(obj);
                    jg4Var2 = (jg4) this.Z;
                    this.Z = jg4Var2;
                    this.Y = 1;
                    objD2 = jg4Var2.d(this);
                    if (objD2 == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i4 != 1) {
                        if (i4 == 2) {
                            n12.S(obj);
                            return xl4Var;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    jg4Var2 = (jg4) this.Z;
                    n12.S(obj);
                    objD2 = obj;
                }
                if (!((Boolean) objD2).booleanValue()) {
                    ue1 ue1Var = vh4Var.h;
                    long[] jArr = (long[]) ue1Var.z;
                    ReentrantLock reentrantLock = (ReentrantLock) ue1Var.b;
                    reentrantLock.lock();
                    try {
                        if (ue1Var.f) {
                            ue1Var.f = false;
                            int length = jArr.length;
                            fu2VarArr = new fu2[length];
                            int i5 = 0;
                            boolean z3 = false;
                            while (i5 < length) {
                                if (jArr[i5] > 0) {
                                    z = z2;
                                }
                                boolean[] zArr = (boolean[]) ue1Var.A;
                                if (z != zArr[i5]) {
                                    zArr[i5] = z;
                                    fu2Var = z ? fu2.f : fu2.z;
                                    z3 = true;
                                } else {
                                    fu2Var = fu2.b;
                                }
                                fu2VarArr[i5] = fu2Var;
                                i5++;
                                z = false;
                                z2 = true;
                            }
                            if (!z3) {
                                fu2VarArr = null;
                            }
                            reentrantLock.unlock();
                        } else {
                            reentrantLock.unlock();
                            fu2VarArr = null;
                        }
                        if (fu2VarArr != null) {
                            uh4 uh4Var = new uh4(fu2VarArr, vh4Var, jg4Var2, null);
                            this.Z = null;
                            this.Y = 2;
                            if (jg4Var2.a(ig4Var, uh4Var, this) == mf0Var) {
                                return mf0Var;
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                return xl4Var;
        }
    }
}
