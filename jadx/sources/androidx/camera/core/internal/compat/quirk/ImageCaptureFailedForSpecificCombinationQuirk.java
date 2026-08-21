package androidx.camera.core.internal.compat.quirk;

import defpackage.hc3;
import defpackage.in4;
import defpackage.j43;
import defpackage.mn4;
import defpackage.on4;
import defpackage.xx1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCaptureFailedForSpecificCombinationQuirk implements hc3 {
    public static final HashSet a = new HashSet(Arrays.asList("pixel 4a", "pixel 4a (5g)", "pixel 5", "pixel 5a"));

    public static boolean b(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() == 3) {
            Iterator it = linkedHashSet.iterator();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            while (it.hasNext()) {
                in4 in4Var = (in4) it.next();
                if (in4Var instanceof j43) {
                    z = true;
                } else if (in4Var instanceof xx1) {
                    z3 = true;
                } else if (in4Var.g.K(mn4.k0)) {
                    z2 = in4Var.g.M() == on4.A;
                }
            }
            if (z && z2 && z3) {
                return true;
            }
        }
        return false;
    }
}
