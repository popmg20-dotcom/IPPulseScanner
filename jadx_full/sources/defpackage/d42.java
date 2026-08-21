package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class d42 extends sk3 implements Function2 {
    public int A;
    public /* synthetic */ Object X;
    public final /* synthetic */ e42 Y;
    public gs2 f;
    public h40 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d42(e42 e42Var, ge0 ge0Var) {
        super(ge0Var);
        this.Y = e42Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((d42) n((ge0) obj2, (ts3) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        d42 d42Var = new d42(this.Y, ge0Var);
        d42Var.X = obj;
        return d42Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005f -> B:25:0x0071). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        gs2 gs2VarB;
        gs2 gs2Var;
        xd2 xd2VarH;
        ts3 ts3Var;
        int i = this.A;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            ts3 ts3Var2 = (ts3) this.X;
            Object objH = this.Y.H();
            if (objH instanceof h40) {
                e42 e42Var = ((h40) objH).X;
                this.A = 1;
                ts3Var2.b(e42Var, this);
                return mf0Var;
            }
            if ((objH instanceof oz1) && (gs2VarB = ((oz1) objH).b()) != null) {
                Object objG = gs2VarB.g();
                objG.getClass();
                xd2 xd2Var = (xd2) objG;
                gs2Var = gs2VarB;
                xd2VarH = xd2Var;
                ts3Var = ts3Var2;
                if (!xd2VarH.equals(gs2Var)) {
                }
            }
        } else if (i == 1) {
            n12.S(obj);
        } else {
            if (i != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            xd2VarH = this.z;
            gs2Var = this.f;
            ts3Var = (ts3) this.X;
            n12.S(obj);
            xd2VarH = xd2VarH.h();
            if (!xd2VarH.equals(gs2Var)) {
                if (xd2VarH instanceof h40) {
                    h40 h40Var = (h40) xd2VarH;
                    e42 e42Var2 = h40Var.X;
                    this.X = ts3Var;
                    this.f = gs2Var;
                    this.z = h40Var;
                    this.A = 2;
                    ts3Var.b(e42Var2, this);
                    return mf0Var;
                }
                xd2VarH = xd2VarH.h();
                if (!xd2VarH.equals(gs2Var)) {
                }
            }
        }
        return xl4.a;
    }
}
