package defpackage;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class li0 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ List y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ li0(List list, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((li0) n((ge0) obj2, (ti0) obj)).p(xl4Var);
            default:
                return ((li0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        List list = this.y0;
        switch (i) {
            case 0:
                li0 li0Var = new li0(list, ge0Var, 0);
                li0Var.Z = obj;
                return li0Var;
            default:
                li0 li0Var2 = new li0(list, ge0Var, 1);
                li0Var2.Z = obj;
                return li0Var2;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        List list = this.y0;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    ti0 ti0Var = (ti0) this.Z;
                    this.Y = 1;
                    if (oi0.a.q(list, ti0Var, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            default:
                lf0 lf0Var = (lf0) this.Z;
                int i3 = this.Y;
                if (i3 != 0) {
                    if (i3 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                ArrayList arrayList = new ArrayList(f70.Q(10, list));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(ji0.b(lf0Var, null, new w53((Uri) it.next(), null, 3), 3));
                }
                this.Z = null;
                this.Y = 1;
                Object objA = yr2.a(arrayList, this);
                return objA == mf0Var ? mf0Var : objA;
        }
    }
}
