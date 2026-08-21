package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class av implements zf1 {
    public final /* synthetic */ int b;
    public final Object f;

    public /* synthetic */ av(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00f9 -> B:62:0x00fc). Please report as a decompilation issue!!! */
    @Override // defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) {
        hg1 hg1Var;
        av avVar;
        int length;
        int i;
        ag1 ag1Var2;
        p0 p0Var;
        mo3 mo3Var;
        int i2 = this.b;
        int i3 = 0;
        int i4 = 3;
        ge0 ge0Var2 = null;
        int i5 = 1;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        Object obj = this.f;
        switch (i2) {
            case 0:
                Object objA = ((av) obj).a(new zu(ag1Var, i3), ge0Var);
                return objA == mf0Var ? objA : xl4Var;
            case 1:
                ((m24) obj).a(new zu(ag1Var, i5), ge0Var);
                return mf0Var;
            case 2:
                Object objA2 = ((pg1) obj).a(new zu(ag1Var, 2), ge0Var);
                return objA2 == mf0Var ? objA2 : xl4Var;
            case 3:
                Object objA3 = ((tg1) obj).a(new zu(ag1Var, i4), ge0Var);
                return objA3 == mf0Var ? objA3 : xl4Var;
            case 4:
                uf ufVar = new uf((kg1) obj, ag1Var, ge0Var2, 9);
                cg1 cg1Var = new cg1(ge0Var, ge0Var.j());
                Object objJ = fx3.J(cg1Var, true, cg1Var, ufVar);
                return objJ == mf0Var ? objJ : xl4Var;
            case 5:
                if (ge0Var instanceof hg1) {
                    hg1Var = (hg1) ge0Var;
                    int i6 = hg1Var.X;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        hg1Var.X = i6 - Integer.MIN_VALUE;
                    } else {
                        hg1Var = new hg1(this, ge0Var);
                    }
                }
                Object obj2 = hg1Var.A;
                int i7 = hg1Var.X;
                if (i7 == 0) {
                    n12.S(obj2);
                    avVar = this;
                    length = ((Object[]) obj).length;
                    i = 0;
                    ag1Var2 = ag1Var;
                    if (i < length) {
                    }
                } else {
                    if (i7 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    length = hg1Var.A0;
                    int i8 = hg1Var.z0;
                    ag1Var2 = hg1Var.y0;
                    av avVar2 = hg1Var.Z;
                    n12.S(obj2);
                    av avVar3 = avVar2;
                    i = i8 + 1;
                    avVar = avVar3;
                    if (i < length) {
                        Object obj3 = ((Object[]) avVar.f)[i];
                        hg1Var.Z = avVar;
                        hg1Var.y0 = ag1Var2;
                        hg1Var.z0 = i;
                        hg1Var.A0 = length;
                        hg1Var.X = 1;
                        if (ag1Var2.h(obj3, hg1Var) == mf0Var) {
                            return mf0Var;
                        }
                        int i9 = i;
                        avVar2 = avVar;
                        i8 = i9;
                        av avVar32 = avVar2;
                        i = i8 + 1;
                        avVar = avVar32;
                        if (i < length) {
                            return xl4Var;
                        }
                    }
                }
                break;
            case 6:
                Object objA4 = ((zf1) obj).a(new zu(ag1Var, 4), ge0Var);
                return objA4 == mf0Var ? objA4 : xl4Var;
            case 7:
                if (ge0Var instanceof p0) {
                    p0Var = (p0) ge0Var;
                    int i10 = p0Var.Z;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        p0Var.Z = i10 - Integer.MIN_VALUE;
                    } else {
                        p0Var = new p0(this, ge0Var);
                    }
                }
                Object obj4 = p0Var.X;
                int i11 = p0Var.Z;
                if (i11 != 0) {
                    if (i11 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mo3Var = p0Var.A;
                    try {
                        n12.S(obj4);
                        mo3Var.q();
                        return xl4Var;
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        mo3Var.q();
                        throw th2;
                    }
                }
                n12.S(obj4);
                cf0 cf0Var = p0Var.f;
                cf0Var.getClass();
                mo3 mo3Var2 = new mo3(ag1Var, cf0Var);
                try {
                    p0Var.A = mo3Var2;
                    p0Var.Z = 1;
                    Object objK = ((Function2) obj).k(mo3Var2, p0Var);
                    if (objK != mf0Var) {
                        objK = xl4Var;
                    }
                    if (objK == mf0Var) {
                        return mf0Var;
                    }
                    mo3Var = mo3Var2;
                    mo3Var.q();
                    return xl4Var;
                } catch (Throwable th3) {
                    th = th3;
                    mo3Var = mo3Var2;
                    Throwable th22 = th;
                    mo3Var.q();
                    throw th22;
                }
            default:
                zf1[] zf1VarArr = (zf1[]) obj;
                z70 z70Var = new z70(zf1VarArr, new cj(6, zf1VarArr), new cv(i4, ge0Var2, i5), ag1Var, null);
                cg1 cg1Var2 = new cg1(ge0Var, ge0Var.j());
                Object objJ2 = fx3.J(cg1Var2, true, cg1Var2, z70Var);
                if (objJ2 != mf0Var) {
                    objJ2 = xl4Var;
                }
                return objJ2 == mf0Var ? objJ2 : xl4Var;
        }
    }
}
