package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wr implements to2, nw2 {
    public static final rr A;
    public static final er A0;
    public static final fr B0;
    public static final gr C0;
    public static final hr D0;
    public static final ir E0;
    public static final jr F0;
    public static final kr G0;
    public static final lr H0;
    public static final nr I0;
    public static final Set J0;
    public static final /* synthetic */ wr[] K0;
    public static final sr X;
    public static final tr Y;
    public static final vr Z;
    public static final pr f;
    public static final cr y0;
    public static final qr z;
    public static final dr z0;
    public final String b;

    /* JADX INFO: Fake field, exist only in values array */
    wr EF0;

    static {
        mr mrVar = new mr("dhg1", 0, "diffie-hellman-group1-sha1");
        or orVar = new or("dhg14", 1, "diffie-hellman-group14-sha1");
        pr prVar = new pr("dhg14_256", 2, "diffie-hellman-group14-sha256");
        f = prVar;
        qr qrVar = new qr("dhg15_512", 3, "diffie-hellman-group15-sha512");
        z = qrVar;
        rr rrVar = new rr("dhg16_512", 4, "diffie-hellman-group16-sha512");
        A = rrVar;
        sr srVar = new sr("dhg17_512", 5, "diffie-hellman-group17-sha512");
        X = srVar;
        tr trVar = new tr("dhg18_512", 6, "diffie-hellman-group18-sha512");
        Y = trVar;
        ur urVar = new ur("dhgex", 7, "diffie-hellman-group-exchange-sha1");
        vr vrVar = new vr("dhgex256", 8, "diffie-hellman-group-exchange-sha256");
        Z = vrVar;
        cr crVar = new cr("ecdhp256", 9, "ecdh-sha2-nistp256");
        y0 = crVar;
        dr drVar = new dr("ecdhp384", 10, "ecdh-sha2-nistp384");
        z0 = drVar;
        er erVar = new er("ecdhp521", 11, "ecdh-sha2-nistp521");
        A0 = erVar;
        fr frVar = new fr("curve25519", 12, "curve25519-sha256");
        B0 = frVar;
        gr grVar = new gr("curve25519_libssh", 13, "curve25519-sha256@libssh.org");
        C0 = grVar;
        hr hrVar = new hr("curve448", 14, "curve448-sha512");
        D0 = hrVar;
        ir irVar = new ir("mlkem768x25519", 15, "mlkem768x25519-sha256");
        E0 = irVar;
        jr jrVar = new jr("mlkem768nistp256", 16, "mlkem768nistp256-sha256");
        F0 = jrVar;
        kr krVar = new kr("mlkem1024nistp384", 17, "mlkem1024nistp384-sha384");
        G0 = krVar;
        lr lrVar = new lr("sntrup761x25519", 18, "sntrup761x25519-sha512");
        H0 = lrVar;
        nr nrVar = new nr("sntrup761x25519_openssh", 19, "sntrup761x25519-sha512@openssh.com");
        I0 = nrVar;
        K0 = new wr[]{mrVar, orVar, prVar, qrVar, rrVar, srVar, trVar, urVar, vrVar, crVar, drVar, erVar, frVar, grVar, hrVar, irVar, jrVar, krVar, lrVar, nrVar};
        J0 = DesugarCollections.unmodifiableSet(EnumSet.allOf(wr.class));
        new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public wr(String str, int i, String str2) {
        this.b = str2;
    }

    public static wr valueOf(String str) {
        return (wr) Enum.valueOf(wr.class, str);
    }

    public static wr[] values() {
        return (wr[]) K0.clone();
    }

    public boolean a() {
        return this instanceof ur;
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
