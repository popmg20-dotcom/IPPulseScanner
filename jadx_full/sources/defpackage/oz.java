package defpackage;

import android.hardware.camera2.CameraManager;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oz extends CameraManager.AvailabilityCallback {
    public final Executor a;
    public final CameraManager.AvailabilityCallback b;
    public final Object c = new Object();
    public boolean d = false;

    public oz(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.a = executor;
        this.b = availabilityCallback;
    }

    public final void a() {
        synchronized (this.c) {
            this.d = true;
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAccessPrioritiesChanged() {
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.a.execute(new d4(6, this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String str) {
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.a.execute(new nz(this, str, 0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String str) {
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.a.execute(new nz(this, str, 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
