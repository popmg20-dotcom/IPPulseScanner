package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class in0 implements xy3 {
    public final hn0 a;
    public xy3 b;

    public in0(hn0 hn0Var) {
        this.a = hn0Var;
    }

    @Override // defpackage.xy3
    public final String a(SSLSocket sSLSocket) {
        xy3 xy3VarD = d(sSLSocket);
        if (xy3VarD != null) {
            return xy3VarD.a(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.xy3
    public final boolean b(SSLSocket sSLSocket) {
        return this.a.b(sSLSocket);
    }

    @Override // defpackage.xy3
    public final void c(SSLSocket sSLSocket, String str, List list) {
        xy3 xy3VarD = d(sSLSocket);
        if (xy3VarD != null) {
            xy3VarD.c(sSLSocket, str, list);
        }
    }

    public final synchronized xy3 d(SSLSocket sSLSocket) {
        try {
            if (this.b == null && this.a.b(sSLSocket)) {
                this.b = this.a.o(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // defpackage.xy3
    public final boolean g() {
        return true;
    }
}
