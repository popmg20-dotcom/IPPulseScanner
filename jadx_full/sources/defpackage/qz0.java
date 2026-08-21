package defpackage;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qz0 extends eq1 {
    public static final /* synthetic */ int c = 0;
    public final oz0 a = oz0.e;
    public final xc1 b = xc1.b;

    @Override // defpackage.eq1
    public final xc1 a() {
        return this.b;
    }

    @Override // defpackage.eq1
    public final boolean b(kz kzVar, r90 r90Var) {
        Set setB = kzVar.b();
        setB.getClass();
        ez4.o("DynamicRangeFeature", "isSupportedIndividually: cameraInfoSupportedDynamicRanges = " + setB + ", this = " + this);
        oz0 oz0Var = this.a;
        if (!setB.contains(oz0Var)) {
            return false;
        }
        for (in4 in4Var : (List) r90Var.e) {
            Set setJ = in4Var.j(kzVar);
            ez4.o("DynamicRangeFeature", "isSupportedIndividually: useCaseSupportedDynamicRanges = " + setJ + ", this = " + this + ", useCases = " + in4Var);
            if (setJ != null && !setJ.contains(oz0Var)) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return "DynamicRangeFeature(dynamicRange=" + this.a + ')';
    }
}
