package defpackage;

import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dt0 {
    public static final dt0 d;
    public static final dt0 e;
    public static final dt0 f;
    public static final dt0 g;
    public final /* synthetic */ int a;
    public final boolean b;
    public final boolean c;

    static {
        int i = 0;
        boolean z = false;
        d = new dt0(z, z, i);
        boolean z2 = true;
        e = new dt0(z, z2, i);
        f = new dt0(z2, z, i);
        g = new dt0(z2, z2, i);
    }

    public dt0(oj1 oj1Var, int i) {
        this.a = i;
        switch (i) {
            case 3:
                Iterator it = oj1Var.A(CaptureIntentPreviewQuirk.class).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                    } else if (((CaptureIntentPreviewQuirk) it.next()).a()) {
                    }
                }
                this.b = z;
                this.c = oj1Var.y(ImageCaptureFailedForVideoSnapshotQuirk.class);
                break;
            default:
                this.b = oj1Var.y(ImageCaptureFailWithAutoFlashQuirk.class);
                this.c = xt0.a.z(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
                break;
        }
    }

    public static dt0 a(boolean z, boolean z2) {
        return z ? z2 ? g : f : z2 ? e : d;
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "implicit=[" + this.b + ", " + this.c + "]";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ dt0(boolean z, boolean z2, int i) {
        this.a = i;
        this.b = z;
        this.c = z2;
    }
}
