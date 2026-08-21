package defpackage;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l31 extends fx3 {
    public final /* synthetic */ fx3 X;
    public final /* synthetic */ ThreadPoolExecutor Y;

    public l31(fx3 fx3Var, ThreadPoolExecutor threadPoolExecutor) {
        this.X = fx3Var;
        this.Y = threadPoolExecutor;
    }

    @Override // defpackage.fx3
    public final void x(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.Y;
        try {
            this.X.x(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // defpackage.fx3
    public final void y(iv1 iv1Var) {
        ThreadPoolExecutor threadPoolExecutor = this.Y;
        try {
            this.X.y(iv1Var);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
