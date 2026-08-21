package defpackage;

import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h53 extends AbstractMap.SimpleEntry {
    public final /* synthetic */ i53 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h53(i53 i53Var, e53 e53Var) {
        super(e53Var.b, e53Var.a());
        this.b = i53Var;
    }

    @Override // java.util.AbstractMap.SimpleEntry, java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.b.f(getKey(), obj, false);
        return super.setValue(obj);
    }
}
