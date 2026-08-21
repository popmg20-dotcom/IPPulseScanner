package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nx3 {
    public final yn2 a = new yn2();
    public final cp1 b = new cp1(7);
    public final av c = new av(7, new lt(2, null, 9));

    public nx3(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.b.f).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (r8 == r5) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [nx3] */
    /* JADX WARN: Type inference failed for: r6v1, types: [wn2] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4, types: [wn2] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(am1 am1Var, ie0 ie0Var) {
        lx3 lx3Var;
        yn2 yn2Var;
        if (ie0Var instanceof lx3) {
            lx3Var = (lx3) ie0Var;
            int i = lx3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                lx3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                lx3Var = new lx3(this, ie0Var);
            }
        }
        Object objG = lx3Var.Y;
        int i2 = lx3Var.y0;
        mf0 mf0Var = mf0.b;
        try {
            if (i2 == 0) {
                n12.S(objG);
                lx3Var.A = am1Var;
                yn2 yn2Var2 = this.a;
                lx3Var.X = yn2Var2;
                lx3Var.y0 = 1;
                Object objG2 = yn2Var2.g(lx3Var);
                yn2Var = yn2Var2;
                if (objG2 != mf0Var) {
                }
                return mf0Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                wn2 wn2Var = (wn2) lx3Var.A;
                n12.S(objG);
                this = wn2Var;
                return objG;
            }
            yn2 yn2Var3 = lx3Var.X;
            am1Var = (am1) lx3Var.A;
            n12.S(objG);
            yn2Var = yn2Var3;
            lx3Var.A = yn2Var;
            lx3Var.X = null;
            lx3Var.y0 = 2;
            objG = am1Var.g(lx3Var);
            this = yn2Var;
        } finally {
            this.n(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Function2 function2, ie0 ie0Var) throws Throwable {
        mx3 mx3Var;
        yn2 yn2Var;
        boolean z;
        Throwable th;
        if (ie0Var instanceof mx3) {
            mx3Var = (mx3) ie0Var;
            int i = mx3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                mx3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                mx3Var = new mx3(this, ie0Var);
            }
        }
        Object obj = mx3Var.Y;
        int i2 = mx3Var.y0;
        if (i2 != 0) {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = mx3Var.X;
            yn2Var = mx3Var.A;
            try {
                n12.S(obj);
                if (z) {
                    yn2Var.n(null);
                }
                return obj;
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                }
                throw th;
            }
        }
        n12.S(obj);
        yn2 yn2Var2 = this.a;
        boolean zD = yn2Var2.d();
        try {
            Object objValueOf = Boolean.valueOf(zD);
            mx3Var.A = yn2Var2;
            mx3Var.X = zD;
            mx3Var.y0 = 1;
            Object objK = function2.k(objValueOf, mx3Var);
            Object obj2 = mf0.b;
            if (objK == obj2) {
                return obj2;
            }
            yn2Var = yn2Var2;
            z = zD;
            obj = objK;
            if (z) {
            }
            return obj;
        } catch (Throwable th3) {
            yn2Var = yn2Var2;
            z = zD;
            th = th3;
            if (z) {
                yn2Var.n(null);
            }
            throw th;
        }
    }
}
