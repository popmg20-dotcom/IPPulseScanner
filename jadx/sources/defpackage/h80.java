package defpackage;

import java.util.Arrays;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h80 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ j80 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h80(j80 j80Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = j80Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((h80) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        j80 j80Var = this.Z;
        switch (i) {
            case 0:
                return new h80(j80Var, ge0Var, 0);
            default:
                return new h80(j80Var, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        j80 j80Var = this.Z;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 != 0) {
                    if (i2 == 1) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                y12 y12VarG = ((pl3) j80Var.d).g();
                String[] strArr = (String[]) j80Var.a;
                zf1 zf1VarA = y12VarG.a(false, (String[]) Arrays.copyOf(strArr, strArr.length));
                xu xuVar = new xu(2, j80Var);
                this.Y = 1;
                return ((av) zf1VarA).a(xuVar, this) == mf0Var ? mf0Var : xl4Var;
            default:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    y12 y12VarG2 = ((pl3) j80Var.d).g();
                    String[] strArr2 = (String[]) j80Var.a;
                    String[] strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length);
                    this.Y = 1;
                    obj = y12VarG2.b.c(strArr3, y12VarG2.e, y12VarG2.f, this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    return xl4Var;
                }
                ((hj3) j80Var.b).a();
                return xl4Var;
        }
    }
}
