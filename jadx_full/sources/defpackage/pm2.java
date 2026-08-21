package defpackage;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum pm2 implements nw2 {
    x25519("X25519"),
    x448("X448");

    public final boolean b;

    pm2(String str) {
        boolean z;
        try {
            z = true;
        } catch (GeneralSecurityException unused) {
            z = false;
        }
        this.b = z;
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return this.b && !nr3.g();
    }
}
