package defpackage;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uw4 {
    public final ih4 a;
    public final n53 b;
    public final jx4 c;

    static {
        ue2.i("WMFgUpdater");
    }

    public uw4(WorkDatabase workDatabase, n53 n53Var, ih4 ih4Var) {
        this.b = n53Var;
        this.a = ih4Var;
        this.c = workDatabase.x();
    }
}
