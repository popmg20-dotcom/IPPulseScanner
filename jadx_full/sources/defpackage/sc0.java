package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sc0 extends tc0 {
    public final u62 b;

    public sc0(u62 u62Var) {
        this.b = u62Var;
    }

    @Override // defpackage.rc0
    public final Object b(ds2 ds2Var) {
        if (ds2Var.a() != 1) {
            throw new v90("while constructing Optional", Optional.empty(), "found non scalar node", ds2Var.a, null);
        }
        String str = ((pp3) ds2Var).e;
        return this.b.b(str, Boolean.TRUE).equals(oa4.h) ? Optional.empty() : Optional.of(str);
    }
}
