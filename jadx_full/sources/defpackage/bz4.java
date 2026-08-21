package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bz4 {
    public final nw a;
    public final cz4 b;
    public final on2 c;
    public final az4 d;
    public boolean e = false;
    public final zy4 f = new zy4(this);

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public bz4(nw nwVar, sy syVar, at3 at3Var) {
        Range range;
        az4 z7Var;
        this.a = nwVar;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                range = (Range) syVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
            } catch (AssertionError e) {
                ez4.b0("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
                range = null;
            }
            z7Var = range != null ? new z7(syVar) : new zf2(16, syVar);
        }
        this.d = z7Var;
        cz4 cz4Var = new cz4(z7Var.o(), z7Var.G());
        this.b = cz4Var;
        cz4Var.e();
        this.c = new on2(new xg(cz4Var.d(), cz4Var.b(), cz4Var.c(), cz4Var.a()));
        nwVar.a(this.f);
    }
}
