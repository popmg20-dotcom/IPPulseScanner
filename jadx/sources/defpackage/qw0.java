package defpackage;

import java.io.EOFException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qw0 {
    public static final /* synthetic */ int a = 0;

    static {
        Charset charset = y30.a;
    }

    public static ArrayList a(bu buVar, String str) throws EOFException, UnknownHostException {
        str.getClass();
        buVar.getClass();
        ArrayList arrayList = new ArrayList();
        hp hpVar = new hp();
        hpVar.I0(buVar);
        hpVar.n0();
        short sN0 = hpVar.n0();
        if (((sN0 & 65535) >> 15) == 0) {
            xe.k("not a response");
            return null;
        }
        int i = sN0 & 15;
        if (i == 2) {
            throw new UnknownHostException(str.concat(": SERVFAIL"));
        }
        if (i == 3) {
            throw new UnknownHostException(str.concat(": NXDOMAIN"));
        }
        int iN0 = hpVar.n0() & 65535;
        int iN02 = hpVar.n0() & 65535;
        hpVar.n0();
        hpVar.n0();
        for (int i2 = 0; i2 < iN0; i2++) {
            byte bU = hpVar.U();
            if (bU < 0) {
                hpVar.z0(1L);
            } else {
                while (bU > 0) {
                    hpVar.z0(bU);
                    bU = hpVar.U();
                }
            }
            hpVar.n0();
            hpVar.n0();
        }
        for (int i3 = 0; i3 < iN02; i3++) {
            byte bU2 = hpVar.U();
            if (bU2 < 0) {
                hpVar.z0(1L);
            } else {
                while (bU2 > 0) {
                    hpVar.z0(bU2);
                    bU2 = hpVar.U();
                }
            }
            int iN03 = hpVar.n0() & 65535;
            hpVar.n0();
            hpVar.j0();
            int iN04 = hpVar.n0() & 65535;
            if (iN03 == 1 || iN03 == 28) {
                byte[] bArr = new byte[iN04];
                hpVar.read(bArr, 0, iN04);
                InetAddress byAddress = InetAddress.getByAddress(bArr);
                byAddress.getClass();
                arrayList.add(byAddress);
            } else {
                hpVar.z0(iN04);
            }
        }
        return arrayList;
    }
}
