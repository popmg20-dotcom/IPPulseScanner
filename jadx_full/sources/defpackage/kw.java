package defpackage;

import android.util.ArrayMap;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kw extends yx {
    public final /* synthetic */ int a = 0;
    public Object b;
    public Object c;

    public kw(vv vvVar, kz kzVar) {
        this.b = vvVar;
        this.c = kzVar;
    }

    @Override // defpackage.yx
    public void a(int i) {
        switch (this.a) {
            case 0:
                for (yx yxVar : (HashSet) this.b) {
                    try {
                        ((Executor) ((ArrayMap) this.c).get(yxVar)).execute(new jw(i, 0, yxVar));
                    } catch (RejectedExecutionException e) {
                        ez4.r("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e);
                    }
                }
                break;
        }
    }

    @Override // defpackage.yx
    public final void b(int i, fy fyVar) {
        switch (this.a) {
            case 0:
                for (yx yxVar : (HashSet) this.b) {
                    try {
                        ((Executor) ((ArrayMap) this.c).get(yxVar)).execute(new iw(yxVar, i, fyVar, 1));
                    } catch (RejectedExecutionException e) {
                        ez4.r("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e);
                    }
                }
                break;
            default:
                ((vv) this.b).b(null);
                ((kz) this.c).r(this);
                break;
        }
    }

    @Override // defpackage.yx
    public void c(int i, d7 d7Var) {
        switch (this.a) {
            case 0:
                for (yx yxVar : (HashSet) this.b) {
                    try {
                        ((Executor) ((ArrayMap) this.c).get(yxVar)).execute(new iw(yxVar, i, d7Var, 0));
                    } catch (RejectedExecutionException e) {
                        ez4.r("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e);
                    }
                }
                break;
        }
    }

    public /* synthetic */ kw() {
    }
}
