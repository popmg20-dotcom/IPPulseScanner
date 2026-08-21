package defpackage;

import j$.util.Base64;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vc0 extends tc0 {
    @Override // defpackage.rc0
    public final Object b(ds2 ds2Var) {
        return Base64.getDecoder().decode(((pp3) ds2Var).e.replaceAll("\\s", ""));
    }
}
