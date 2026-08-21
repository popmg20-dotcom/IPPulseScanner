package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class iw implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ int z;

    public /* synthetic */ iw(Object obj, int i, Object obj2, int i2) {
        this.b = i2;
        this.f = obj;
        this.z = i;
        this.A = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.z;
        Object obj = this.A;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                ((yx) obj2).c(i2, (d7) obj);
                break;
            case 1:
                ((yx) obj2).b(i2, (fy) obj);
                break;
            case 2:
                ((CameraCaptureSession.CaptureCallback) ((lw) obj2).b).onCaptureSequenceAborted((CameraCaptureSession) obj, i2);
                break;
            case 3:
                ((CameraDevice.StateCallback) ((xw) obj2).b).onError((CameraDevice) obj, i2);
                break;
            case 4:
                g90 g90Var = (g90) obj2;
                Object obj3 = ((w7) obj).f;
                String str = (String) g90Var.a.get(Integer.valueOf(i2));
                if (str != null) {
                    u4 u4Var = (u4) g90Var.e.get(str);
                    if ((u4Var != null ? u4Var.a : null) != null) {
                        l4 l4Var = u4Var.a;
                        l4Var.getClass();
                        if (g90Var.d.remove(str)) {
                            l4Var.h(obj3);
                        }
                    } else {
                        g90Var.g.remove(str);
                        g90Var.f.put(str, obj3);
                    }
                    break;
                }
                break;
            case 5:
                ((g90) obj2).a(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj));
                break;
            case 6:
                ((a73) ((tx) obj2).z).k(i2, obj);
                break;
            case 7:
                na2 na2Var = (na2) obj2;
                CodeEditor codeEditor = (CodeEditor) obj;
                if (na2Var.b == codeEditor && i2 == na2Var.A.get()) {
                    codeEditor.setLayoutBusy(false);
                    codeEditor.getEventHandler().k(0.0f, 0.0f, false);
                    break;
                }
                break;
            default:
                xf4 xf4Var = (xf4) obj2;
                vv vvVar = (vv) obj;
                if (!xf4Var.d) {
                    if (vvVar != null) {
                        vvVar.d(new IllegalStateException("No flash unit"));
                    }
                } else if (!xf4Var.f) {
                    xf4Var.a(0);
                    if (vvVar != null) {
                        vvVar.d(new w9("Camera is not active."));
                    }
                } else {
                    nw nwVar = xf4Var.a;
                    xf4Var.i = i2 != 0;
                    nwVar.c(i2);
                    xf4Var.a(i2);
                    vv vvVar2 = xf4Var.h;
                    if (vvVar2 != null) {
                        vvVar2.d(new w9("There is a new enableTorch being set"));
                    }
                    xf4Var.h = vvVar;
                }
                break;
        }
    }

    public /* synthetic */ iw(Object obj, Object obj2, int i, int i2) {
        this.b = i2;
        this.f = obj;
        this.A = obj2;
        this.z = i;
    }
}
