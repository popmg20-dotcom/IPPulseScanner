package defpackage;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gq4 extends sk3 implements Function2 {
    public final /* synthetic */ View A;
    public int f;
    public /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq4(View view, ge0 ge0Var) {
        super(ge0Var);
        this.A = view;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((gq4) n((ge0) obj2, (ts3) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        gq4 gq4Var = new gq4(this.A, ge0Var);
        gq4Var.z = obj;
        return gq4Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        Object obj2;
        int i = this.f;
        View view = this.A;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            ts3 ts3Var = (ts3) this.z;
            this.z = ts3Var;
            this.f = 1;
            ts3Var.b(view, this);
            return mf0Var;
        }
        xl4 xl4Var = xl4.a;
        if (i != 1) {
            if (i == 2) {
                n12.S(obj);
                return xl4Var;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ts3 ts3Var2 = (ts3) this.z;
        n12.S(obj);
        if (view instanceof ViewGroup) {
            this.z = null;
            this.f = 2;
            ts3Var2.getClass();
            mg4 mg4Var = new mg4(new w0(3, (ViewGroup) view));
            if (mg4Var.f.hasNext()) {
                ts3Var2.z = mg4Var;
                ts3Var2.b = 2;
                ts3Var2.A = this;
                obj2 = mf0Var;
            } else {
                obj2 = xl4Var;
            }
            if (obj2 != mf0Var) {
                obj2 = xl4Var;
            }
            if (obj2 == mf0Var) {
                return mf0Var;
            }
        }
        return xl4Var;
    }
}
