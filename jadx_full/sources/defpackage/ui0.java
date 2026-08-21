package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ui0 extends v74 implements am1 {
    public int A0;
    public int B0;
    public final /* synthetic */ lj0 C0;
    public final /* synthetic */ iv1 D0;
    public Object X;
    public Serializable Y;
    public Object Z;
    public Object y0;
    public Iterator z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ui0(lj0 lj0Var, iv1 iv1Var, ge0 ge0Var) {
        super(1, ge0Var);
        this.C0 = lj0Var;
        this.D0 = iv1Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        return new ui0(this.C0, this.D0, (ge0) obj).p(xl4.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        wn2 yn2Var;
        xg3 xg3Var;
        bh3 bh3Var;
        bh3 bh3Var2;
        wn2 wn2Var;
        Iterator it;
        wn2 wn2Var2;
        xg3 xg3Var2;
        bh3 bh3Var3;
        ti0 ti0Var;
        bh3 bh3Var4;
        xg3 xg3Var3;
        int iHashCode;
        Integer numA;
        Object obj2;
        int i = this.B0;
        iv1 iv1Var = this.D0;
        lj0 lj0Var = this.C0;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            yn2Var = new yn2();
            xg3Var = new xg3();
            bh3Var = new bh3();
            this.X = yn2Var;
            this.Y = xg3Var;
            this.Z = bh3Var;
            this.y0 = bh3Var;
            this.B0 = 1;
            obj = lj0Var.h(true, this);
            if (obj != mf0Var) {
                bh3Var2 = bh3Var;
            }
            return mf0Var;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    iHashCode = this.A0;
                    obj2 = this.X;
                    n12.S(obj);
                    return new fi0(iHashCode, ((Number) obj).intValue(), obj2);
                }
                wn2Var = (wn2) this.Z;
                bh3Var4 = (bh3) this.Y;
                xg3Var3 = (xg3) this.X;
                n12.S(obj);
                try {
                    xg3Var3.b = true;
                    wn2Var.n(null);
                    Object obj3 = bh3Var4.b;
                    iHashCode = obj3 == null ? obj3.hashCode() : 0;
                    nx3 nx3VarC = lj0Var.c();
                    this.X = obj3;
                    this.Y = null;
                    this.Z = null;
                    this.A0 = iHashCode;
                    this.B0 = 4;
                    numA = nx3VarC.a();
                    if (numA != mf0Var) {
                        obj = numA;
                        obj2 = obj3;
                        return new fi0(iHashCode, ((Number) obj).intValue(), obj2);
                    }
                    return mf0Var;
                } catch (Throwable th) {
                    wn2Var.n(null);
                    throw th;
                }
            }
            it = this.z0;
            ti0Var = (ti0) this.y0;
            bh3Var3 = (bh3) this.Z;
            xg3Var2 = (xg3) this.Y;
            wn2Var2 = (wn2) this.X;
            n12.S(obj);
            while (it.hasNext()) {
                Function2 function2 = (Function2) it.next();
                this.X = wn2Var2;
                this.Y = xg3Var2;
                this.Z = bh3Var3;
                this.y0 = ti0Var;
                this.z0 = it;
                this.B0 = 2;
                if (function2.k(ti0Var, this) == mf0Var) {
                    break;
                }
            }
            bh3Var2 = bh3Var3;
            xg3Var = xg3Var2;
            wn2Var = wn2Var2;
            iv1Var.A = null;
            this.X = xg3Var;
            this.Y = bh3Var2;
            this.Z = wn2Var;
            this.y0 = null;
            this.z0 = null;
            this.B0 = 3;
            if (wn2Var.g(this) != mf0Var) {
                bh3Var4 = bh3Var2;
                xg3Var3 = xg3Var;
                xg3Var3.b = true;
                wn2Var.n(null);
                Object obj32 = bh3Var4.b;
                if (obj32 == null) {
                }
                nx3 nx3VarC2 = lj0Var.c();
                this.X = obj32;
                this.Y = null;
                this.Z = null;
                this.A0 = iHashCode;
                this.B0 = 4;
                numA = nx3VarC2.a();
                if (numA != mf0Var) {
                }
            }
            return mf0Var;
        }
        bh3Var = (bh3) this.y0;
        bh3Var2 = (bh3) this.Z;
        xg3Var = (xg3) this.Y;
        yn2Var = (wn2) this.X;
        n12.S(obj);
        bh3Var.b = ((fi0) obj).b;
        ti0 ti0Var2 = new ti0(yn2Var, xg3Var, bh3Var2, lj0Var);
        List list = (List) iv1Var.A;
        if (list == null) {
            wn2Var = yn2Var;
            iv1Var.A = null;
            this.X = xg3Var;
            this.Y = bh3Var2;
            this.Z = wn2Var;
            this.y0 = null;
            this.z0 = null;
            this.B0 = 3;
            if (wn2Var.g(this) != mf0Var) {
            }
            return mf0Var;
        }
        it = list.iterator();
        wn2Var2 = yn2Var;
        xg3Var2 = xg3Var;
        bh3Var3 = bh3Var2;
        ti0Var = ti0Var2;
        while (it.hasNext()) {
        }
        bh3Var2 = bh3Var3;
        xg3Var = xg3Var2;
        wn2Var = wn2Var2;
        iv1Var.A = null;
        this.X = xg3Var;
        this.Y = bh3Var2;
        this.Z = wn2Var;
        this.y0 = null;
        this.z0 = null;
        this.B0 = 3;
        if (wn2Var.g(this) != mf0Var) {
        }
        return mf0Var;
    }
}
