package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sz0 implements rz0 {
    public final Object a;

    public sz0(Object obj) {
        this.a = (DynamicRangeProfiles) obj;
    }

    public static sz0 d(sy syVar) {
        DynamicRangeProfiles dynamicRangeProfilesB;
        int i = Build.VERSION.SDK_INT;
        sz0 sz0Var = null;
        if (i >= 33 && (dynamicRangeProfilesB = a71.b(syVar.a(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES))) != null) {
            r25.j("DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.", i >= 33);
            sz0Var = new sz0((rz0) new sz0(dynamicRangeProfilesB));
        }
        return sz0Var == null ? tz0.a : sz0Var;
    }

    public static Set e(Set set) {
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            long jLongValue = l.longValue();
            oz0 oz0Var = (oz0) pz0.a.get(l);
            if (oz0Var == null) {
                ez4.a0("DynamicRangesCompatApi33Impl", "Dynamic range profile cannot be converted to a DynamicRange object: " + jLongValue);
            }
            if (oz0Var != null) {
                hashSet.add(oz0Var);
            }
        }
        return DesugarCollections.unmodifiableSet(hashSet);
    }

    @Override // defpackage.rz0
    public DynamicRangeProfiles a() {
        return (DynamicRangeProfiles) this.a;
    }

    @Override // defpackage.rz0
    public Set b() {
        return e(((DynamicRangeProfiles) this.a).getSupportedProfiles());
    }

    @Override // defpackage.rz0
    public Set c(oz0 oz0Var) {
        Object obj = this.a;
        Long lA = pz0.a(oz0Var, (DynamicRangeProfiles) obj);
        r25.f(lA != null, "DynamicRange is not supported: " + oz0Var);
        return e(((DynamicRangeProfiles) obj).getProfileCaptureRequestConstraints(lA.longValue()));
    }

    public sz0(rz0 rz0Var) {
        this.a = rz0Var;
    }
}
