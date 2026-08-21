package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bh0 extends v74 implements Function2 {
    public final /* synthetic */ pl3 A0;
    public final /* synthetic */ am1 B0;
    public ig4 X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ boolean y0;
    public final /* synthetic */ boolean z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z, boolean z2) {
        super(2, ge0Var);
        this.y0 = z;
        this.z0 = z2;
        this.A0 = pl3Var;
        this.B0 = am1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((bh0) n((ge0) obj2, (jg4) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        bh0 bh0Var = new bh0(ge0Var, this.B0, this.A0, this.y0, this.z0);
        bh0Var.Z = obj;
        return bh0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[PHI: r0 r12
      0x009d: PHI (r0v11 jg4) = (r0v8 jg4), (r0v16 jg4) binds: [B:34:0x009a, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x009d: PHI (r12v15 java.lang.Object) = (r12v13 java.lang.Object), (r12v0 java.lang.Object) binds: [B:34:0x009a, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[RETURN] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        ig4 ig4Var;
        jg4 jg4Var;
        ig4 ig4Var2;
        jg4 jg4Var2;
        jg4 jg4Var3;
        Object obj2;
        int i = this.Y;
        am1 am1Var = this.B0;
        pl3 pl3Var = this.A0;
        boolean z = this.z0;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            jg4 jg4Var4 = (jg4) this.Z;
            if (!this.y0) {
                jg4Var4.getClass();
                return am1Var.g(((ld3) jg4Var4).c());
            }
            ig4Var = z ? ig4.b : ig4.f;
            if (!z) {
                this.Z = jg4Var4;
                this.X = ig4Var;
                this.Y = 1;
                Object objD = jg4Var4.d(this);
                if (objD != mf0Var) {
                    jg4Var2 = jg4Var4;
                    obj = objD;
                }
                return mf0Var;
            }
            ig4 ig4Var3 = ig4Var;
            jg4Var = jg4Var4;
            ig4Var2 = ig4Var3;
            ah0 ah0Var = new ah0((ge0) null, am1Var, 0);
            this.Z = jg4Var;
            this.X = null;
            this.Y = 3;
            obj = jg4Var.a(ig4Var2, ah0Var, this);
            if (obj != mf0Var) {
            }
            return mf0Var;
        }
        if (i != 1) {
            if (i == 2) {
                ig4Var = this.X;
                jg4Var3 = (jg4) this.Z;
                n12.S(obj);
                ig4Var2 = ig4Var;
                jg4Var = jg4Var3;
                ah0 ah0Var2 = new ah0((ge0) null, am1Var, 0);
                this.Z = jg4Var;
                this.X = null;
                this.Y = 3;
                obj = jg4Var.a(ig4Var2, ah0Var2, this);
                if (obj != mf0Var) {
                    if (!z) {
                    }
                }
                return mf0Var;
            }
            if (i != 3) {
                if (i != 4) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj2 = this.Z;
                n12.S(obj);
                if (!((Boolean) obj).booleanValue()) {
                    y12 y12VarG = pl3Var.g();
                    y12VarG.b.d(y12VarG.e, y12VarG.f);
                }
                return obj2;
            }
            jg4Var = (jg4) this.Z;
            n12.S(obj);
            if (!z) {
                return obj;
            }
            this.Z = obj;
            this.Y = 4;
            Object objD2 = jg4Var.d(this);
            if (objD2 != mf0Var) {
                Object obj3 = obj;
                obj = objD2;
                obj2 = obj3;
                if (!((Boolean) obj).booleanValue()) {
                }
                return obj2;
            }
            return mf0Var;
        }
        ig4Var = this.X;
        jg4Var2 = (jg4) this.Z;
        n12.S(obj);
        if (((Boolean) obj).booleanValue()) {
            ig4Var2 = ig4Var;
            jg4Var = jg4Var2;
            ah0 ah0Var22 = new ah0((ge0) null, am1Var, 0);
            this.Z = jg4Var;
            this.X = null;
            this.Y = 3;
            obj = jg4Var.a(ig4Var2, ah0Var22, this);
            if (obj != mf0Var) {
            }
            return mf0Var;
        }
        y12 y12VarG2 = pl3Var.g();
        this.Z = jg4Var2;
        this.X = ig4Var;
        this.Y = 2;
        if (y12VarG2.c(this) != mf0Var) {
            jg4Var3 = jg4Var2;
            ig4Var2 = ig4Var;
            jg4Var = jg4Var3;
            ah0 ah0Var222 = new ah0((ge0) null, am1Var, 0);
            this.Z = jg4Var;
            this.X = null;
            this.Y = 3;
            obj = jg4Var.a(ig4Var2, ah0Var222, this);
            if (obj != mf0Var) {
            }
        }
        return mf0Var;
    }
}
