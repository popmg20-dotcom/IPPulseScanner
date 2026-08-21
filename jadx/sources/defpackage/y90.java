package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y90 implements rw1 {
    public final HashMap b = new HashMap();

    public final void a(rw1 rw1Var) {
        if (rw1Var instanceof y90) {
            s53.d();
            return;
        }
        for (String str : rw1Var.m()) {
            this.b.put(str, rw1Var);
        }
    }

    @Override // defpackage.rw1
    public final String[] m() {
        return new String[0];
    }
}
