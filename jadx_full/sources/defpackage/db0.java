package defpackage;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class db0 {
    public static final db0 e;
    public static final db0 f;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        w40 w40Var = w40.r;
        w40 w40Var2 = w40.s;
        w40 w40Var3 = w40.t;
        w40 w40Var4 = w40.l;
        w40 w40Var5 = w40.n;
        w40 w40Var6 = w40.m;
        w40 w40Var7 = w40.o;
        w40 w40Var8 = w40.q;
        w40 w40Var9 = w40.p;
        List listK = e70.K(w40Var, w40Var2, w40Var3, w40Var4, w40Var5, w40Var6, w40Var7, w40Var8, w40Var9);
        List listK2 = e70.K(w40Var, w40Var2, w40Var3, w40Var4, w40Var5, w40Var6, w40Var7, w40Var8, w40Var9, w40.j, w40.k, w40.h, w40.i, w40.f, w40.g, w40.e);
        cb0 cb0Var = new cb0();
        w40[] w40VarArr = (w40[]) listK.toArray(new w40[0]);
        cb0Var.b((w40[]) Arrays.copyOf(w40VarArr, w40VarArr.length));
        ne4 ne4Var = ne4.TLS_1_3;
        ne4 ne4Var2 = ne4.TLS_1_2;
        cb0Var.g(ne4Var, ne4Var2);
        cb0Var.b = true;
        cb0Var.a();
        cb0 cb0Var2 = new cb0();
        w40[] w40VarArr2 = (w40[]) listK2.toArray(new w40[0]);
        cb0Var2.b((w40[]) Arrays.copyOf(w40VarArr2, w40VarArr2.length));
        cb0Var2.g(ne4Var, ne4Var2);
        cb0Var2.b = true;
        e = cb0Var2.a();
        cb0 cb0Var3 = new cb0();
        w40[] w40VarArr3 = (w40[]) listK2.toArray(new w40[0]);
        cb0Var3.b((w40[]) Arrays.copyOf(w40VarArr3, w40VarArr3.length));
        cb0Var3.g(ne4Var, ne4Var2, ne4.TLS_1_1, ne4.TLS_1_0);
        cb0Var3.b = true;
        cb0Var3.a();
        f = new db0(false, false, null, null);
    }

    public db0(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.a = z;
        this.b = z2;
        this.c = strArr;
        this.d = strArr2;
    }

    public final void a(SSLSocket sSLSocket, boolean z) {
        String[] enabledProtocols;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        enabledCipherSuites.getClass();
        String[] strArr = this.c;
        if (strArr != null) {
            enabledCipherSuites = hz4.i(strArr, enabledCipherSuites, w40.c);
        }
        String[] strArr2 = this.d;
        if (strArr2 != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            enabledProtocols2.getClass();
            enabledProtocols = hz4.i(enabledProtocols2, strArr2, ep2.f);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        supportedCipherSuites.getClass();
        e1 e1Var = w40.c;
        byte[] bArr = hz4.a;
        int length = supportedCipherSuites.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (e1Var.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i++;
            }
        }
        if (z && i != -1) {
            String str = supportedCipherSuites[i];
            str.getClass();
            enabledCipherSuites.getClass();
            enabledCipherSuites = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        String[] strArr3 = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length);
        boolean z2 = this.a;
        if (!z2) {
            xe.k("no cipher suites for cleartext connections");
            return;
        }
        if (strArr3.length == 0) {
            xe.k("At least one cipher suite is required");
            return;
        }
        String[] strArr4 = (String[]) Arrays.copyOf(strArr3, strArr3.length);
        String[] strArr5 = (String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length);
        if (!z2) {
            xe.k("no TLS versions for cleartext connections");
            return;
        }
        if (strArr5.length == 0) {
            xe.k("At least one TLS version is required");
            return;
        }
        db0 db0Var = new db0(z2, this.b, strArr4, (String[]) Arrays.copyOf(strArr5, strArr5.length));
        if (db0Var.c() != null) {
            sSLSocket.setEnabledProtocols(db0Var.d);
        }
        if (db0Var.b() != null) {
            sSLSocket.setEnabledCipherSuites(db0Var.c);
        }
    }

    public final ArrayList b() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(w40.b.j(str));
        }
        return arrayList;
    }

    public final ArrayList c() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            ne4.f.getClass();
            arrayList.add(c84.b(str));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof db0)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        db0 db0Var = (db0) obj;
        boolean z = db0Var.a;
        boolean z2 = this.a;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.c, db0Var.c) && Arrays.equals(this.d, db0Var.d) && this.b == db0Var.b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.a) {
            return 17;
        }
        String[] strArr = this.c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.b ? 1 : 0);
    }

    public final String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ')';
    }
}
