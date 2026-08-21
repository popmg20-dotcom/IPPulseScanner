package org.apache.sshd.common.util.security;

import defpackage.nr3;
import defpackage.z1;
import java.security.Provider;
import java.security.Security;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class SunJCESecurityProviderRegistrar extends z1 {
    @Override // defpackage.z1
    public final boolean X0() {
        if (nr3.g() || !super.X0()) {
            return false;
        }
        return g();
    }

    @Override // defpackage.z1, defpackage.mr3
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return Security.getProvider("SunJCE") != null;
    }

    @Override // defpackage.mr3
    public final Provider i0() {
        return Security.getProvider("SunJCE");
    }

    @Override // defpackage.z1, defpackage.mr3
    public final String x0() {
        return "SunJCE";
    }
}
