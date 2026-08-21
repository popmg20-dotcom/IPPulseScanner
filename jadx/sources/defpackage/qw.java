package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qw {
    public final CameraManager a;

    public qw(Context context) {
        this.a = (CameraManager) context.getSystemService(CameraManager.class);
    }
}
