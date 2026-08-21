package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class qz extends lb {
    public static boolean T(RuntimeException runtimeException) {
        StackTraceElement[] stackTrace;
        if (Build.VERSION.SDK_INT == 28) {
            if ((!runtimeException.getClass().equals(RuntimeException.class) || (stackTrace = runtimeException.getStackTrace()) == null || stackTrace.length < 0) ? false : "_enableShutterSound".equals(stackTrace[0].getMethodName())) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.lb
    public void F(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws xx {
        try {
            try {
                ((CameraManager) this.f).openCamera(str, executor, stateCallback);
            } catch (SecurityException e) {
                throw e;
            }
        } catch (CameraAccessException e2) {
            throw new xx(e2);
        } catch (IllegalArgumentException | SecurityException e3) {
        } catch (RuntimeException e4) {
            if (!T(e4)) {
                throw e4;
            }
            throw new xx(e4);
        }
    }

    @Override // defpackage.lb
    public final void I(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        ((CameraManager) this.f).registerAvailabilityCallback(executor, availabilityCallback);
    }

    @Override // defpackage.lb
    public final void R(CameraManager.AvailabilityCallback availabilityCallback) {
        ((CameraManager) this.f).unregisterAvailabilityCallback(availabilityCallback);
    }

    @Override // defpackage.lb
    public CameraCharacteristics w(String str) throws xx {
        try {
            return super.w(str);
        } catch (RuntimeException e) {
            if (T(e)) {
                throw new xx(e);
            }
            throw e;
        }
    }
}
