package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uh4 extends v74 implements Function2 {
    public int A0;
    public int B0;
    public final /* synthetic */ fu2[] C0;
    public final /* synthetic */ vh4 D0;
    public final /* synthetic */ jg4 E0;
    public fu2[] X;
    public vh4 Y;
    public jg4 Z;
    public int y0;
    public int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uh4(fu2[] fu2VarArr, vh4 vh4Var, jg4 jg4Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.C0 = fu2VarArr;
        this.D0 = vh4Var;
        this.E0 = jg4Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((uh4) n((ge0) obj2, (t13) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new uh4(this.C0, this.D0, this.E0, ge0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r7.e(r6, r12, r11) == r10) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0072 -> B:27:0x0073). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        int length;
        int i;
        jg4 jg4Var;
        fu2[] fu2VarArr;
        int i2;
        vh4 vh4Var;
        int i3 = this.B0;
        if (i3 == 0) {
            n12.S(obj);
            fu2[] fu2VarArr2 = this.C0;
            length = fu2VarArr2.length;
            i = 0;
            vh4 vh4Var2 = this.D0;
            jg4Var = this.E0;
            fu2VarArr = fu2VarArr2;
            i2 = 0;
            vh4Var = vh4Var2;
            if (i >= length) {
            }
        } else {
            if (i3 != 1 && i3 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            length = this.A0;
            i = this.z0;
            int i4 = this.y0;
            jg4Var = this.Z;
            vh4Var = this.Y;
            fu2VarArr = this.X;
            n12.S(obj);
            i2 = i4;
            i++;
            if (i >= length) {
                int i5 = i2 + 1;
                int iOrdinal = fu2VarArr[i].ordinal();
                if (iOrdinal != 0) {
                    mf0 mf0Var = mf0.b;
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            g.d();
                            return null;
                        }
                        this.X = fu2VarArr;
                        this.Y = vh4Var;
                        this.Z = jg4Var;
                        this.y0 = i5;
                        this.z0 = i;
                        this.A0 = length;
                        this.B0 = 2;
                        if (vh4Var.f(jg4Var, i2, this) != mf0Var) {
                            i4 = i5;
                            i2 = i4;
                        }
                        return mf0Var;
                    }
                    this.X = fu2VarArr;
                    this.Y = vh4Var;
                    this.Z = jg4Var;
                    this.y0 = i5;
                    this.z0 = i;
                    this.A0 = length;
                    this.B0 = 1;
                    i++;
                    if (i >= length) {
                        return xl4.a;
                    }
                } else {
                    i2 = i5;
                    i++;
                    if (i >= length) {
                    }
                }
            }
        }
    }
}
