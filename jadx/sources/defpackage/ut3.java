package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ut3 implements wt3 {
    public final SessionConfiguration a;
    public final List b;

    public ut3(int i, ArrayList arrayList, at3 at3Var, py pyVar) {
        SessionConfiguration sessionConfiguration = new SessionConfiguration(i, xt3.a(arrayList), at3Var, pyVar);
        this.a = sessionConfiguration;
        List<OutputConfiguration> outputConfigurations = sessionConfiguration.getOutputConfigurations();
        ArrayList arrayList2 = new ArrayList(outputConfigurations.size());
        for (OutputConfiguration outputConfiguration : outputConfigurations) {
            ax2 ax2Var = null;
            if (outputConfiguration != null) {
                int i2 = Build.VERSION.SDK_INT;
                cx2 hx2Var = i2 >= 33 ? new hx2(outputConfiguration) : i2 >= 28 ? new gx2(new fx2(outputConfiguration)) : i2 >= 26 ? new ex2(new dx2(outputConfiguration)) : i2 >= 24 ? new cx2(new bx2(outputConfiguration)) : null;
                if (hx2Var != null) {
                    ax2Var = new ax2(hx2Var);
                }
            }
            arrayList2.add(ax2Var);
        }
        this.b = DesugarCollections.unmodifiableList(arrayList2);
    }

    @Override // defpackage.wt3
    public final int b() {
        return this.a.getSessionType();
    }

    @Override // defpackage.wt3
    public final Object c() {
        return this.a;
    }

    @Override // defpackage.wt3
    public final j02 d() {
        return j02.a(this.a.getInputConfiguration());
    }

    @Override // defpackage.wt3
    public final Executor e() {
        return this.a.getExecutor();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ut3) {
            return this.a.equals(((ut3) obj).a);
        }
        return false;
    }

    @Override // defpackage.wt3
    public final CameraCaptureSession.StateCallback f() {
        return this.a.getStateCallback();
    }

    @Override // defpackage.wt3
    public final List g() {
        return this.b;
    }

    @Override // defpackage.wt3
    public final void h(CaptureRequest captureRequest) {
        this.a.setSessionParameters(captureRequest);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.wt3
    public final void i(j02 j02Var) {
        this.a.setInputConfiguration(j02Var.a.a);
    }
}
