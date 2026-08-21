package defpackage;

import android.os.Looper;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ul3 extends v12 {
    public final /* synthetic */ ql3 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ul3(String[] strArr, ql3 ql3Var) {
        super(strArr);
        this.b = ql3Var;
    }

    @Override // defpackage.v12
    public final void a(Set set) {
        set.getClass();
        rd rdVarW0 = rd.w0();
        ga1 ga1Var = new ga1(18, this.b);
        rdVarW0.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            ga1Var.run();
        } else {
            rdVarW0.x0(ga1Var);
        }
    }
}
