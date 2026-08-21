package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.media.ImageWriter;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class py extends CameraCaptureSession.StateCallback {
    public final /* synthetic */ int a;
    public final Object b;

    public py(List list) {
        this.a = 0;
        this.b = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback) it.next();
            if (!(stateCallback instanceof qy)) {
                ((ArrayList) this.b).add(stateCallback);
            }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onActive(CameraCaptureSession cameraCaptureSession) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.StateCallback) it.next()).onActive(cameraCaptureSession);
                }
                break;
            case 1:
                m84 m84Var = (m84) obj;
                m84Var.j(cameraCaptureSession);
                m84Var.a(m84Var);
                break;
            default:
                super.onActive(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    v02.v((CameraCaptureSession.StateCallback) it.next(), cameraCaptureSession);
                }
                break;
            case 1:
                m84 m84Var = (m84) obj;
                m84Var.j(cameraCaptureSession);
                m84Var.b(m84Var);
                break;
            default:
                super.onCaptureQueueEmpty(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.StateCallback) it.next()).onClosed(cameraCaptureSession);
                }
                break;
            case 1:
                m84 m84Var = (m84) obj;
                m84Var.j(cameraCaptureSession);
                m84Var.c(m84Var);
                break;
            default:
                super.onClosed(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        vv vvVar;
        switch (this.a) {
            case 0:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.StateCallback) it.next()).onConfigureFailed(cameraCaptureSession);
                }
                return;
            case 1:
                try {
                    ((m84) this.b).j(cameraCaptureSession);
                    m84 m84Var = (m84) this.b;
                    m84Var.d(m84Var);
                    synchronized (((m84) this.b).a) {
                        r25.i(((m84) this.b).i, "OpenCaptureSession completer should not null");
                        m84 m84Var2 = (m84) this.b;
                        vvVar = m84Var2.i;
                        m84Var2.i = null;
                        break;
                    }
                    vvVar.d(new IllegalStateException("onConfigureFailed"));
                    return;
                } catch (Throwable th) {
                    synchronized (((m84) this.b).a) {
                        r25.i(((m84) this.b).i, "OpenCaptureSession completer should not null");
                        m84 m84Var3 = (m84) this.b;
                        vv vvVar2 = m84Var3.i;
                        m84Var3.i = null;
                        vvVar2.d(new IllegalStateException("onConfigureFailed"));
                        throw th;
                    }
                }
            default:
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        vv vvVar;
        switch (this.a) {
            case 0:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.StateCallback) it.next()).onConfigured(cameraCaptureSession);
                }
                return;
            case 1:
                try {
                    ((m84) this.b).j(cameraCaptureSession);
                    m84 m84Var = (m84) this.b;
                    m84Var.e(m84Var);
                    synchronized (((m84) this.b).a) {
                        r25.i(((m84) this.b).i, "OpenCaptureSession completer should not null");
                        m84 m84Var2 = (m84) this.b;
                        vvVar = m84Var2.i;
                        m84Var2.i = null;
                        break;
                    }
                    vvVar.b(null);
                    return;
                } catch (Throwable th) {
                    synchronized (((m84) this.b).a) {
                        r25.i(((m84) this.b).i, "OpenCaptureSession completer should not null");
                        m84 m84Var3 = (m84) this.b;
                        vv vvVar2 = m84Var3.i;
                        m84Var3.i = null;
                        vvVar2.b(null);
                        throw th;
                    }
                }
            default:
                Surface inputSurface = cameraCaptureSession.getInputSurface();
                if (inputSurface != null) {
                    e24 e24Var = (e24) this.b;
                    ImageWriter imageWriterNewInstance = ImageWriter.newInstance(inputSurface, 1);
                    if (((AtomicBoolean) e24Var.z).get()) {
                        if (((ImageWriter) e24Var.f) != null) {
                            ez4.a0("ZslControlImpl", "ImageWriter already existed in the ImageWriter holder. Closing the previous one.");
                            ((ImageWriter) e24Var.f).close();
                        }
                        e24Var.f = imageWriterNewInstance;
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onReady(CameraCaptureSession cameraCaptureSession) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.StateCallback) it.next()).onReady(cameraCaptureSession);
                }
                break;
            case 1:
                m84 m84Var = (m84) obj;
                m84Var.j(cameraCaptureSession);
                m84Var.f(m84Var);
                break;
            default:
                super.onReady(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.StateCallback) it.next()).onSurfacePrepared(cameraCaptureSession, surface);
                }
                break;
            case 1:
                m84 m84Var = (m84) obj;
                m84Var.j(cameraCaptureSession);
                m84Var.h(m84Var, surface);
                break;
            default:
                super.onSurfacePrepared(cameraCaptureSession, surface);
                break;
        }
    }

    private final void a(CameraCaptureSession cameraCaptureSession) {
    }

    public /* synthetic */ py(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
