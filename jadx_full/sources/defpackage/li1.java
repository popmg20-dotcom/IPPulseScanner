package defpackage;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class li1 {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public li1(oj1 oj1Var, oj1 oj1Var2) {
        this.a = oj1Var2.y(TextureViewIsClosedQuirk.class);
        this.b = oj1Var.y(PreviewOrientationIncorrectQuirk.class);
        this.c = oj1Var.y(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public final void a(ArrayList arrayList) {
        if ((this.a || this.b || this.c) && arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((dn0) it.next()).a();
            }
            ez4.o("ForceCloseDeferrableSurface", "deferrableSurface closed");
        }
    }
}
