package defpackage;

import android.hardware.camera2.CameraAccessException;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xx extends Exception {
    public static final Set f = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(4, 5, 1, 2, 3)));
    public static final Set z = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(10001, 10002)));
    public final int b;

    public xx(String str, AssertionError assertionError) {
        super(String.format("%s (%d): %s", "CAMERA_CHARACTERISTICS_CREATION_ERROR", 10002, str), assertionError);
        this.b = 10002;
        if (f.contains(10002)) {
            new CameraAccessException(10002, str, assertionError);
        }
    }

    public xx(RuntimeException runtimeException) {
        super("Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.", runtimeException);
        this.b = 10001;
        if (f.contains(10001)) {
            new CameraAccessException(10001, null, runtimeException);
        }
    }

    public xx(CameraAccessException cameraAccessException) {
        super(cameraAccessException.getMessage(), cameraAccessException.getCause());
        this.b = cameraAccessException.getReason();
    }
}
