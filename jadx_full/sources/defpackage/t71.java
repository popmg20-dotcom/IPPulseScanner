package defpackage;

import com.getsurfboard.base.ContextUtilsKt;
import java.text.SimpleDateFormat;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t71 extends v74 implements Function2 {
    public final /* synthetic */ long X;
    public final /* synthetic */ int Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t71(long j, int i, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = j;
        this.Y = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((t71) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new t71(this.X, this.Y, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        n12.S(obj);
        SimpleDateFormat simpleDateFormat = g81.a;
        return g81.a(ContextUtilsKt.a(), this.X, this.Y);
    }
}
