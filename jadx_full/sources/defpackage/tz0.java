package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tz0 implements rz0 {
    public static final sz0 a = new sz0((rz0) new tz0());
    public static final Set b = Collections.singleton(oz0.d);

    @Override // defpackage.rz0
    public final DynamicRangeProfiles a() {
        return null;
    }

    @Override // defpackage.rz0
    public final Set b() {
        return b;
    }

    @Override // defpackage.rz0
    public final Set c(oz0 oz0Var) {
        r25.f(oz0.d.equals(oz0Var), "DynamicRange is not supported: " + oz0Var);
        return b;
    }
}
