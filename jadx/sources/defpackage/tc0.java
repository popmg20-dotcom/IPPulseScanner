package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tc0 implements rc0 {
    public static final HashMap a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("true", Boolean.TRUE);
        map.put("false", Boolean.FALSE);
    }

    @Override // defpackage.rc0
    public final void a(ds2 ds2Var, Object obj) {
        if (ds2Var.c) {
            throw new IllegalStateException("Not implemented in ".concat(getClass().getName()));
        }
        throw new hy4("Unexpected recursive structure for Node: " + ds2Var);
    }
}
