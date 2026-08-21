package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l00 {
    public static final b00 a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new k92(2));
        a = new b00(linkedHashSet);
    }

    public static void a(Context context, a00 a00Var, b00 b00Var) throws k00 {
        Integer numB;
        if (Build.VERSION.SDK_INT >= 34 && l2.h(context) != 0) {
            ez4.o("CameraValidator", "Virtual device with ID: " + l2.h(context) + " has " + a00Var.c().size() + " cameras. Skipping validation.");
            return;
        }
        IllegalArgumentException e = null;
        if (b00Var != null) {
            try {
                numB = b00Var.b();
                if (numB == null) {
                    ez4.a0("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e2) {
                ez4.r("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e2);
                return;
            }
        } else {
            numB = null;
        }
        ez4.o("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + numB);
        PackageManager packageManager = context.getPackageManager();
        int i = 0;
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (b00Var == null || numB.intValue() == 1)) {
                b00.c.c(a00Var.c());
                i = 1;
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            ez4.b0("CameraValidator", "Camera LENS_FACING_BACK verification failed", e);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (b00Var == null || numB.intValue() == 0)) {
                b00.b.c(a00Var.c());
                i++;
            }
        } catch (IllegalArgumentException e4) {
            e = e4;
            ez4.b0("CameraValidator", "Camera LENS_FACING_FRONT verification failed", e);
        }
        try {
            a.c(a00Var.c());
            ez4.o("CameraValidator", "Found a LENS_FACING_EXTERNAL camera");
            i++;
        } catch (IllegalArgumentException unused) {
        }
        if (e == null) {
            return;
        }
        ez4.q("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + a00Var.c());
        throw new k00(i, e);
    }
}
