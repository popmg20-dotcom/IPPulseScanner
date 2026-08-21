package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k84 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ m84 f;

    public /* synthetic */ k84(m84 m84Var, int i) {
        this.b = i;
        this.f = m84Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        m84 m84Var = this.f;
        switch (i) {
            case 0:
                m84Var.g(m84Var);
                return;
            default:
                m84Var.k("Session call super.close()");
                r25.i(m84Var.g, "Need to call openCaptureSession before using this API.");
                cm2 cm2Var = m84Var.b;
                synchronized (cm2Var.z) {
                    ((LinkedHashSet) cm2Var.X).add(m84Var);
                    break;
                }
                ((CameraCaptureSession) ((lb) m84Var.g.f).f).close();
                m84Var.d.execute(new k84(m84Var, 0));
                return;
        }
    }
}
