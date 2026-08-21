package defpackage;

import android.hardware.camera2.params.SessionConfiguration;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l6 implements dz {
    public final ArrayList a;

    public l6(ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // defpackage.dz
    public final ue2 a(SessionConfiguration sessionConfiguration) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ue2 ue2VarA = ((dz) it.next()).a(sessionConfiguration);
            if (ue2VarA.b != 0) {
                return ue2VarA;
            }
        }
        return new ue2(0, false);
    }
}
