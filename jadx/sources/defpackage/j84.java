package defpackage;

import j$.util.Objects;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j84 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ m84 f;
    public final /* synthetic */ m84 z;

    public /* synthetic */ j84(m84 m84Var, m84 m84Var2, int i) {
        this.b = i;
        this.f = m84Var;
        this.z = m84Var2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                m84 m84Var = this.f;
                m84 m84Var2 = this.z;
                cm2 cm2Var = m84Var.b;
                synchronized (cm2Var.z) {
                    ((LinkedHashSet) cm2Var.A).remove(m84Var);
                    ((LinkedHashSet) cm2Var.X).remove(m84Var);
                    break;
                }
                m84Var.g(m84Var2);
                if (m84Var.g != null) {
                    Objects.requireNonNull(m84Var.f);
                    m84Var.f.c(m84Var2);
                    return;
                } else {
                    ez4.a0("SyncCaptureSessionBase", "[" + m84Var + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
                    return;
                }
            default:
                m84 m84Var3 = this.f;
                m84 m84Var4 = this.z;
                Objects.requireNonNull(m84Var3.f);
                m84Var3.f.g(m84Var4);
                return;
        }
    }
}
