package org.apache.sshd.common.util.security.eddsa;

import defpackage.n61;
import defpackage.nr3;
import defpackage.we2;
import defpackage.x83;
import defpackage.z1;
import j$.util.Optional;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSASecurityProviderRegistrar extends z1 {
    @Override // defpackage.z1
    public final Optional W0() {
        throw null;
    }

    @Override // defpackage.z1
    public final boolean X0() {
        if (nr3.g() || !super.X0()) {
            return false;
        }
        return x83.a(this, "org.apache.sshd.eddsaSupport");
    }

    @Override // defpackage.z1
    public final boolean Y0() {
        throw null;
    }

    @Override // defpackage.nw2
    public final boolean g() {
        throw null;
    }

    @Override // defpackage.mr3
    public final Provider i0() {
        try {
            g();
            throw null;
        } catch (ReflectiveOperationException e) {
            Throwable thA = n61.a(e);
            ((we2) this.f).error("getSecurityProvider({}) failed ({}) to instantiate {}: {}", null, thA.getClass().getSimpleName(), "net.i2p.crypto.eddsa.EdDSASecurityProvider", thA.getMessage());
            if (thA instanceof RuntimeException) {
                throw ((RuntimeException) thA);
            }
            throw new IllegalStateException(thA);
        }
    }
}
