package defpackage;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ah0 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ am1 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ah0(ge0 ge0Var, am1 am1Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = am1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((ah0) n((ge0) obj2, (t13) obj)).p(xl4Var);
            case 1:
                return ((ah0) n((ge0) obj2, (t13) obj)).p(xl4Var);
            case 2:
                ((ah0) n((ge0) obj2, (rn2) obj)).p(xl4Var);
                return xl4Var;
            default:
                return ((ah0) n((ge0) obj2, (List) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        am1 am1Var = this.Z;
        switch (i) {
            case 0:
                ah0 ah0Var = new ah0(ge0Var, am1Var, 0);
                ah0Var.Y = obj;
                return ah0Var;
            case 1:
                ah0 ah0Var2 = new ah0(ge0Var, am1Var, 1);
                ah0Var2.Y = obj;
                return ah0Var2;
            case 2:
                ah0 ah0Var3 = new ah0(am1Var, ge0Var, 2);
                ah0Var3.Y = obj;
                return ah0Var3;
            default:
                ah0 ah0Var4 = new ah0(am1Var, ge0Var, 3);
                ah0Var4.Y = obj;
                return ah0Var4;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        am1 am1Var = this.Z;
        switch (i) {
            case 0:
                n12.S(obj);
                t13 t13Var = (t13) this.Y;
                t13Var.getClass();
                return am1Var.g(t13Var.c());
            case 1:
                n12.S(obj);
                t13 t13Var2 = (t13) this.Y;
                t13Var2.getClass();
                return am1Var.g(t13Var2.c());
            case 2:
                n12.S(obj);
                am1Var.g((rn2) this.Y);
                return xl4.a;
            default:
                List list = (List) this.Y;
                n12.S(obj);
                list.getClass();
                return am1Var.g(list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ah0(am1 am1Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = am1Var;
    }
}
