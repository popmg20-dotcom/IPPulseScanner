package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hc4 extends n02 {
    public static final List z0;
    public final dc4 Z;
    public final boolean y0;

    static {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"surroundingPair"}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        z0 = DesugarCollections.unmodifiableList(arrayList);
    }

    public hc4(dc4 dc4Var) {
        e84 e84Var = new e84(null);
        e84Var.E('{', new g84("{", "}"));
        e84Var.E('(', new g84("(", ")"));
        e84Var.E('[', new g84("[", "]"));
        e84Var.E(StringUtil.DOUBLE_QUOTE, new g84("\"", "\"", new c84(0)));
        e84Var.E('\'', new g84("'", "'", new d84(0)));
        super(e84Var);
        this.y0 = true;
        this.Z = dc4Var;
        X();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3 A[EDGE_INSN: B:53:0x00c3->B:42:0x00c3 BREAK  A[LOOP:2: B:32:0x0091->B:41:0x00ba], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X() {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hc4.X():void");
    }
}
