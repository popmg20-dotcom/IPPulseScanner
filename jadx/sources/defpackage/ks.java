package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum ks extends ws {
    @Override // defpackage.va1
    public final Object a() {
        Optional optionalB = nr3.b();
        if (optionalB.isPresent()) {
            return ((h01) optionalB.get()).a();
        }
        vp1.n("EdDSA Signer not available");
        return null;
    }

    @Override // defpackage.ws, defpackage.nw2
    public final boolean g() {
        return nr3.b().isPresent();
    }
}
