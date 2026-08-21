package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ws implements yr {
    public static final ss A;
    public static final gs A0;
    public static final hs B0;
    public static final is C0;
    public static final js D0;
    public static final ks E0;
    public static final ls F0;
    public static final ms G0;
    public static final Set H0;
    public static final /* synthetic */ ws[] I0;
    public static final ts X;
    public static final us Y;
    public static final vs Z;
    public static final ps f;
    public static final es y0;
    public static final rs z;
    public static final fs z0;
    public final String b;

    /* JADX INFO: Fake field, exist only in values array */
    ws EF0;

    static {
        ns nsVar = new ns("dsa", 0, "ssh-dss");
        os osVar = new os("dsa_cert", 1, "ssh-dss-cert-v01@openssh.com");
        ps psVar = new ps("rsa", 2, "ssh-rsa");
        f = psVar;
        qs qsVar = new qs("rsa_cert", 3, "ssh-rsa-cert-v01@openssh.com");
        rs rsVar = new rs("rsaSHA256", 4, "rsa-sha2-256");
        z = rsVar;
        ss ssVar = new ss("rsaSHA256_cert", 5, "rsa-sha2-256-cert-v01@openssh.com");
        A = ssVar;
        ts tsVar = new ts();
        X = tsVar;
        us usVar = new us();
        Y = usVar;
        vs vsVar = new vs("nistp256", 8, k82.J);
        Z = vsVar;
        es esVar = new es("nistp256_cert", 9, "ecdsa-sha2-nistp256-cert-v01@openssh.com");
        y0 = esVar;
        fs fsVar = new fs("nistp384", 10, k82.K);
        z0 = fsVar;
        gs gsVar = new gs("nistp384_cert", 11, "ecdsa-sha2-nistp384-cert-v01@openssh.com");
        A0 = gsVar;
        hs hsVar = new hs("nistp521", 12, k82.L);
        B0 = hsVar;
        is isVar = new is("nistp521_cert", 13, "ecdsa-sha2-nistp521-cert-v01@openssh.com");
        C0 = isVar;
        js jsVar = new js("sk_ecdsa_sha2_nistp256", 14, "sk-ecdsa-sha2-nistp256@openssh.com");
        D0 = jsVar;
        ks ksVar = new ks("ed25519", 15, "ssh-ed25519");
        E0 = ksVar;
        ls lsVar = new ls("ed25519_cert", 16, "ssh-ed25519-cert-v01@openssh.com");
        F0 = lsVar;
        ms msVar = new ms("sk_ssh_ed25519", 17, "sk-ssh-ed25519@openssh.com");
        G0 = msVar;
        I0 = new ws[]{nsVar, osVar, psVar, qsVar, rsVar, ssVar, tsVar, usVar, vsVar, esVar, fsVar, gsVar, hsVar, isVar, jsVar, ksVar, lsVar, msVar};
        H0 = DesugarCollections.unmodifiableSet(EnumSet.allOf(ws.class));
        new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public ws(String str, int i, String str2) {
        this.b = str2;
    }

    public static ws valueOf(String str) {
        return (ws) Enum.valueOf(ws.class, str);
    }

    public static ws[] values() {
        return (ws[]) I0.clone();
    }

    public boolean g() {
        return true;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
