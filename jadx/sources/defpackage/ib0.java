package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ib0 implements xy3 {
    public static final k01 a = new k01(14);
    public static final boolean b;

    static {
        Conscrypt.Version version;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, hb0.class.getClassLoader());
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        if (Conscrypt.isAvailable() && (version = Conscrypt.version()) != null) {
            if (version.major() != 2) {
                if (version.major() > 2) {
                    z = true;
                }
            } else if (version.minor() != 1) {
                if (version.minor() > 1) {
                    z = true;
                }
            } else if (version.patch() >= 0) {
                z = true;
            }
            b = z;
        }
        b = z;
    }

    @Override // defpackage.xy3
    public final String a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.xy3
    public final boolean b(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.xy3
    public final void c(SSLSocket sSLSocket, String str, List list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            k13 k13Var = k13.a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) wl3.k(list).toArray(new String[0]));
        }
    }

    @Override // defpackage.xy3
    public final boolean g() {
        return b;
    }
}
