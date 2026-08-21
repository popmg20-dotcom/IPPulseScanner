package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class gy1 {
    public static final /* synthetic */ int a = 0;

    static {
        pg pgVar = hy1.v;
    }

    public static int a(hy1 hy1Var) {
        return ((Integer) hy1Var.p(hy1.x, -1)).intValue();
    }

    public static ArrayList b(hy1 hy1Var) {
        List list = (List) hy1Var.p(hy1.G, null);
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    public static int c(hy1 hy1Var) {
        return ((Integer) hy1Var.p(hy1.y, -1)).intValue();
    }

    public static int d(hy1 hy1Var, int i) {
        return ((Integer) hy1Var.p(hy1.w, Integer.valueOf(i))).intValue();
    }

    public static void e(hy1 hy1Var) {
        boolean zR = hy1Var.R();
        boolean z = hy1Var.L() != null;
        if (zR && z) {
            xe.k("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        } else if (hy1Var.B() != null) {
            if (zR || z) {
                xe.k("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }
}
