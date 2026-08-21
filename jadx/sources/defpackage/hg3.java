package defpackage;

import android.util.SparseArray;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hg3 {
    public final SparseArray a = new SparseArray();
    public int b = 0;
    public final Set c = Collections.newSetFromMap(new IdentityHashMap());

    public final gg3 a(int i) {
        SparseArray sparseArray = this.a;
        gg3 gg3Var = (gg3) sparseArray.get(i);
        if (gg3Var != null) {
            return gg3Var;
        }
        gg3 gg3Var2 = new gg3();
        sparseArray.put(i, gg3Var2);
        return gg3Var2;
    }
}
