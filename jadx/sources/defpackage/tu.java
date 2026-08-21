package defpackage;

import android.os.Build;
import android.util.Log;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tu extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public /* synthetic */ Object Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tu(int i, ge0 ge0Var, int i2) {
        super(i, ge0Var);
        this.X = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((tu) n((ge0) obj2, (tz1) obj)).p(xl4Var);
            case 1:
                return ((tu) n((ge0) obj2, (j24) obj)).p(xl4Var);
            default:
                ((tu) n((ge0) obj2, (jy2) obj)).p(xl4Var);
                return xl4Var;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        switch (this.X) {
            case 0:
                tu tuVar = new tu(2, ge0Var, 0);
                tuVar.Y = obj;
                return tuVar;
            case 1:
                tu tuVar2 = new tu(2, ge0Var, 1);
                tuVar2.Y = obj;
                return tuVar2;
            default:
                tu tuVar3 = new tu(2, ge0Var, 2);
                tuVar3.Y = obj;
                return tuVar3;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        switch (this.X) {
            case 0:
                n12.S(obj);
                return Boolean.valueOf(((tz1) this.Y) != null);
            case 1:
                n12.S(obj);
                return Boolean.valueOf(!(((j24) this.Y) instanceof qe1));
            default:
                n12.S(obj);
                jy2 jy2Var = (jy2) this.Y;
                if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                    z = true;
                }
                if (z) {
                    Log.v("Paging", "Sent " + jy2Var, null);
                }
                return xl4.a;
        }
    }
}
