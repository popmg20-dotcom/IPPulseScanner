package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ti0 {
    public final /* synthetic */ wn2 a;
    public final /* synthetic */ xg3 b;
    public final /* synthetic */ bh3 c;
    public final /* synthetic */ lj0 d;

    public ti0(wn2 wn2Var, xg3 xg3Var, bh3 bh3Var, lj0 lj0Var) {
        this.a = wn2Var;
        this.b = xg3Var;
        this.c = bh3Var;
        this.d = lj0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x004e, B:35:0x00a8, B:37:0x00b0), top: B:52:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(aj ajVar, ie0 ie0Var) throws Throwable {
        si0 si0Var;
        wn2 wn2Var;
        xg3 xg3Var;
        bh3 bh3Var;
        lj0 lj0Var;
        Function2 function2;
        wn2 wn2Var2;
        wn2 wn2Var3;
        bh3 bh3Var2;
        Object obj;
        if (ie0Var instanceof si0) {
            si0Var = (si0) ie0Var;
            int i = si0Var.B0;
            if ((i & Integer.MIN_VALUE) != 0) {
                si0Var.B0 = i - Integer.MIN_VALUE;
            } else {
                si0Var = new si0(this, ie0Var);
            }
        }
        Object obj2 = si0Var.z0;
        int i2 = si0Var.B0;
        mf0 mf0Var = mf0.b;
        try {
            if (i2 == 0) {
                n12.S(obj2);
                si0Var.A = ajVar;
                wn2Var = this.a;
                si0Var.X = wn2Var;
                xg3Var = this.b;
                si0Var.Y = xg3Var;
                bh3Var = this.c;
                si0Var.Z = bh3Var;
                lj0Var = this.d;
                si0Var.y0 = lj0Var;
                si0Var.B0 = 1;
                function2 = ajVar;
                if (wn2Var.g(si0Var) != mf0Var) {
                }
                return mf0Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = si0Var.Y;
                    bh3Var2 = (bh3) si0Var.X;
                    wn2Var2 = (wn2) si0Var.A;
                    try {
                        n12.S(obj2);
                        bh3Var2.b = obj;
                        Object obj3 = bh3Var2.b;
                        wn2Var2.n(null);
                        return obj3;
                    } catch (Throwable th) {
                        th = th;
                        wn2Var2.n(null);
                        throw th;
                    }
                }
                lj0Var = (lj0) si0Var.Y;
                bh3Var2 = (bh3) si0Var.X;
                wn2Var3 = (wn2) si0Var.A;
                try {
                    n12.S(obj2);
                    if (!n12.c(obj2, bh3Var2.b)) {
                        wn2Var2 = wn2Var3;
                        Object obj32 = bh3Var2.b;
                        wn2Var2.n(null);
                        return obj32;
                    }
                    si0Var.A = wn2Var3;
                    si0Var.X = bh3Var2;
                    si0Var.Y = obj2;
                    si0Var.B0 = 3;
                    if (lj0Var.i(obj2, false, si0Var) != mf0Var) {
                        obj = obj2;
                        wn2Var2 = wn2Var3;
                        bh3Var2.b = obj;
                        Object obj322 = bh3Var2.b;
                        wn2Var2.n(null);
                        return obj322;
                    }
                    return mf0Var;
                } catch (Throwable th2) {
                    th = th2;
                    wn2Var2 = wn2Var3;
                    wn2Var2.n(null);
                    throw th;
                }
            }
            lj0Var = si0Var.y0;
            bh3 bh3Var3 = si0Var.Z;
            xg3Var = (xg3) si0Var.Y;
            wn2 wn2Var4 = (wn2) si0Var.X;
            Function2 function22 = (Function2) si0Var.A;
            n12.S(obj2);
            bh3Var = bh3Var3;
            function2 = function22;
            wn2Var = wn2Var4;
            if (xg3Var.b) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            Object obj4 = bh3Var.b;
            si0Var.A = wn2Var;
            si0Var.X = bh3Var;
            si0Var.Y = lj0Var;
            si0Var.Z = null;
            si0Var.y0 = null;
            si0Var.B0 = 2;
            Object objK = function2.k(obj4, si0Var);
            if (objK != mf0Var) {
                wn2Var3 = wn2Var;
                obj2 = objK;
                bh3Var2 = bh3Var;
                if (!n12.c(obj2, bh3Var2.b)) {
                }
            }
            return mf0Var;
        } catch (Throwable th3) {
            th = th3;
            wn2Var2 = wn2Var;
            wn2Var2.n(null);
            throw th;
        }
    }
}
