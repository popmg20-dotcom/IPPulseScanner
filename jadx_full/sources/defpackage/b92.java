package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b92 implements Map.Entry {
    public Map.Entry b;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        d92 d92Var = (d92) this.b.getValue();
        if (d92Var == null) {
            return null;
        }
        return d92Var.b();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof nl2)) {
            xe.k("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            return null;
        }
        d92 d92Var = (d92) this.b.getValue();
        nl2 nl2Var = d92Var.c;
        d92Var.a = null;
        d92Var.d = null;
        d92Var.c = (nl2) obj;
        return nl2Var;
    }
}
