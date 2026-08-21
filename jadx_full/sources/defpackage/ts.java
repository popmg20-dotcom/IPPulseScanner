package defpackage;

import java.security.Signature;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum ts extends ws {
    public final AtomicReference J0;

    public ts() {
        super("rsaSHA512", 6, "rsa-sha2-512");
        this.J0 = new AtomicReference();
    }

    @Override // defpackage.va1
    public final Object a() {
        return new vw3();
    }

    @Override // defpackage.ws, defpackage.nw2
    public final boolean g() {
        AtomicReference atomicReference = this.J0;
        Boolean boolValueOf = (Boolean) atomicReference.get();
        if (boolValueOf == null) {
            try {
                boolValueOf = Boolean.valueOf(((Signature) nr3.k(Signature.class, "SHA512withRSA", new sm(15)).a("SHA512withRSA")) != null);
            } catch (Exception unused) {
                boolValueOf = Boolean.FALSE;
            }
            atomicReference.set(boolValueOf);
        }
        return boolValueOf.booleanValue();
    }
}
