package defpackage;

import java.io.Closeable;
import java.io.File;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qj0 implements Closeable {
    public final ae3 b;
    public final List f;
    public final int z;

    public qj0(eg0 eg0Var) {
        File file = (File) eg0Var.f;
        if (file == null) {
            xe.k("Unsupported Builder configuration: expected either File or URL");
            throw null;
        }
        ae3 ae3Var = new ae3(new ip(file), file.getName());
        this.b = ae3Var;
        this.f = (List) eg0Var.z;
        String str = ae3Var.f.d;
        int i = str.contains("GeoIP2-Anonymous-IP") ? pj0.ANONYMOUS_IP.b : 0;
        i = str.contains("GeoLite2-ASN") ? i | pj0.ASN.b : i;
        i = str.contains("City") ? i | pj0.CITY.b | pj0.COUNTRY.b : i;
        i = str.contains("GeoIP2-Connection-Type") ? i | pj0.CONNECTION_TYPE.b : i;
        i = str.contains("Country") ? i | pj0.COUNTRY.b : i;
        i = str.contains("GeoIP2-Domain") ? i | pj0.DOMAIN.b : i;
        i = str.contains("Enterprise") ? i | pj0.ENTERPRISE.b | pj0.CITY.b | pj0.COUNTRY.b : i;
        i = str.contains("GeoIP2-ISP") ? i | pj0.ISP.b : i;
        if (i != 0) {
            this.z = i;
        } else {
            vp1.n("Invalid attempt to open an unknown database type: ".concat(str));
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    public final vf0 g(InetAddress inetAddress) throws c6, a60 {
        pj0 pj0Var = pj0.COUNTRY;
        ae3 ae3Var = this.b;
        ul2 ul2Var = ae3Var.f;
        if ((pj0Var.b & this.z) == 0) {
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            throw new UnsupportedOperationException("Invalid attempt to open a " + ul2Var.d + " database using the " + methodName + " method");
        }
        ip ipVar = (ip) ae3Var.z.get();
        if (ipVar == null) {
            throw new a60("The MaxMind DB has been closed.");
        }
        ByteBuffer byteBufferDuplicate = ipVar.a.duplicate();
        byte[] address = inetAddress.getAddress();
        int length = address.length * 8;
        int i = ul2Var.f;
        int i2 = ul2Var.h;
        int iG = (i == 6 && length == 32) ? ae3Var.b : 0;
        for (int i3 = 0; i3 < length && iG < i2; i3++) {
            iG = ae3Var.g(byteBufferDuplicate, iG, ((address[i3 / 8] & 255) >> (7 - (i3 % 8))) & 1);
        }
        Object objCast = null;
        if (iG > i2) {
            int i4 = (iG - i2) + ul2Var.j;
            if (i4 >= byteBufferDuplicate.capacity()) {
                throw new a60("The MaxMind DB file's search tree is corrupt: contains pointer larger than the database.");
            }
            mk0 mk0Var = new mk0(ae3Var.A, byteBufferDuplicate, r2 + 16, ae3Var.X);
            ByteBuffer byteBuffer = mk0Var.d;
            if (i4 >= byteBuffer.capacity()) {
                throw new a60("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
            }
            byteBuffer.position(i4);
            objCast = vf0.class.cast(mk0Var.a(vf0.class, null).a);
        }
        inetAddress.getHostAddress();
        vf0 vf0Var = (vf0) objCast;
        mw2 f43Var = vf0Var == null ? z.b : new f43(new vf0(vf0Var, this.f));
        if (f43Var.b()) {
            return (vf0) f43Var.a();
        }
        throw new c6("The address " + inetAddress.getHostAddress() + " is not in the database.");
    }
}
