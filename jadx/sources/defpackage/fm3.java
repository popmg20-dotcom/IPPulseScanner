package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fm3 implements Parcelable {
    public static final Parcelable.Creator<fm3> CREATOR = new ic2(20);
    public static final List z;
    public final InetAddress b;
    public final int f;

    static {
        InetAddress byName = InetAddress.getByName("0.0.0.0");
        byName.getClass();
        fm3 fm3Var = new fm3(byName, 8);
        InetAddress byName2 = InetAddress.getByName("10.0.0.0");
        byName2.getClass();
        fm3 fm3Var2 = new fm3(byName2, 8);
        InetAddress byName3 = InetAddress.getByName("100.64.0.0");
        byName3.getClass();
        fm3 fm3Var3 = new fm3(byName3, 10);
        InetAddress byName4 = InetAddress.getByName("127.0.0.0");
        byName4.getClass();
        fm3 fm3Var4 = new fm3(byName4, 8);
        InetAddress byName5 = InetAddress.getByName("169.254.0.0");
        byName5.getClass();
        fm3 fm3Var5 = new fm3(byName5, 16);
        InetAddress byName6 = InetAddress.getByName("172.16.0.0");
        byName6.getClass();
        fm3 fm3Var6 = new fm3(byName6, 12);
        InetAddress byName7 = InetAddress.getByName("192.0.0.0");
        byName7.getClass();
        fm3 fm3Var7 = new fm3(byName7, 24);
        InetAddress byName8 = InetAddress.getByName("192.88.99.0");
        byName8.getClass();
        fm3 fm3Var8 = new fm3(byName8, 24);
        InetAddress byName9 = InetAddress.getByName("192.168.0.0");
        byName9.getClass();
        fm3 fm3Var9 = new fm3(byName9, 16);
        InetAddress byName10 = InetAddress.getByName("198.18.0.0");
        byName10.getClass();
        fm3 fm3Var10 = new fm3(byName10, 15);
        InetAddress byName11 = InetAddress.getByName("198.51.100.0");
        byName11.getClass();
        fm3 fm3Var11 = new fm3(byName11, 24);
        InetAddress byName12 = InetAddress.getByName("203.0.113.0");
        byName12.getClass();
        fm3 fm3Var12 = new fm3(byName12, 24);
        InetAddress byName13 = InetAddress.getByName("224.0.0.0");
        byName13.getClass();
        fm3 fm3Var13 = new fm3(byName13, 4);
        InetAddress byName14 = InetAddress.getByName("233.252.0.0");
        byName14.getClass();
        fm3 fm3Var14 = new fm3(byName14, 24);
        InetAddress byName15 = InetAddress.getByName("240.0.0.0");
        byName15.getClass();
        fm3 fm3Var15 = new fm3(byName15, 4);
        InetAddress byName16 = InetAddress.getByName("255.255.255.255");
        byName16.getClass();
        fm3 fm3Var16 = new fm3(byName16, 32);
        InetAddress byName17 = InetAddress.getByName("::");
        byName17.getClass();
        fm3 fm3Var17 = new fm3(byName17, 128);
        InetAddress byName18 = InetAddress.getByName("::1");
        byName18.getClass();
        fm3 fm3Var18 = new fm3(byName18, 128);
        InetAddress byName19 = InetAddress.getByName("::ffff:0:0");
        byName19.getClass();
        fm3 fm3Var19 = new fm3(byName19, 96);
        InetAddress byName20 = InetAddress.getByName("100::");
        byName20.getClass();
        fm3 fm3Var20 = new fm3(byName20, 64);
        InetAddress byName21 = InetAddress.getByName("64:ff9b::");
        byName21.getClass();
        fm3 fm3Var21 = new fm3(byName21, 96);
        InetAddress byName22 = InetAddress.getByName("2001::");
        byName22.getClass();
        fm3 fm3Var22 = new fm3(byName22, 32);
        InetAddress byName23 = InetAddress.getByName("2001:10::");
        byName23.getClass();
        fm3 fm3Var23 = new fm3(byName23, 28);
        InetAddress byName24 = InetAddress.getByName("2001:20::");
        byName24.getClass();
        fm3 fm3Var24 = new fm3(byName24, 28);
        InetAddress byName25 = InetAddress.getByName("2001:db8::");
        byName25.getClass();
        fm3 fm3Var25 = new fm3(byName25, 32);
        InetAddress byName26 = InetAddress.getByName("2002::");
        byName26.getClass();
        fm3 fm3Var26 = new fm3(byName26, 16);
        InetAddress byName27 = InetAddress.getByName("fc00::");
        byName27.getClass();
        fm3 fm3Var27 = new fm3(byName27, 7);
        InetAddress byName28 = InetAddress.getByName("fe80::");
        byName28.getClass();
        fm3 fm3Var28 = new fm3(byName28, 10);
        InetAddress byName29 = InetAddress.getByName("ff00::");
        byName29.getClass();
        z = e70.K(fm3Var, fm3Var2, fm3Var3, fm3Var4, fm3Var5, fm3Var6, fm3Var7, fm3Var8, fm3Var9, fm3Var10, fm3Var11, fm3Var12, fm3Var13, fm3Var14, fm3Var15, fm3Var16, fm3Var17, fm3Var18, fm3Var19, fm3Var20, fm3Var21, fm3Var22, fm3Var23, fm3Var24, fm3Var25, fm3Var26, fm3Var27, fm3Var28, new fm3(byName29, 8));
    }

    public fm3(InetAddress inetAddress, int i) throws UnknownHostException {
        inetAddress.getClass();
        this.b = inetAddress;
        this.f = i;
        if (inetAddress.getAddress().length != 4 || i <= 32) {
            return;
        }
        byte[] address = inetAddress.getAddress();
        address.getClass();
        int length = address.length;
        byte[] bArrCopyOf = Arrays.copyOf(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1}, 12 + length);
        System.arraycopy(address, 0, bArrCopyOf, 12, length);
        InetAddress byAddress = InetAddress.getByAddress(bArrCopyOf);
        byAddress.getClass();
        this.b = byAddress;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length * 8;
        int i = this.f;
        if (i < 0 || i > length) {
            StringBuilder sbA = fw.A(bArr.length, i, "IP address with ", " bytes has invalid prefix length ", ": ");
            sbA.append(this);
            throw new IllegalStateException(sbA.toString().toString());
        }
        int i2 = i / 8;
        byte b = (byte) (DnsRecord.CLASS_ANY << (8 - (i % 8)));
        if (i2 < bArr.length) {
            bArr[i2] = (byte) (b & bArr[i2]);
        }
        while (true) {
            i2++;
            if (i2 >= bArr.length) {
                return;
            } else {
                bArr[i2] = 0;
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fm3)) {
            return false;
        }
        fm3 fm3Var = (fm3) obj;
        return n12.c(this.b, fm3Var.b) && this.f == fm3Var.f;
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.f;
    }

    public final boolean m(InetAddress inetAddress) {
        inetAddress.getClass();
        byte[] address = inetAddress.getAddress();
        if (address == null) {
            return false;
        }
        int length = address.length;
        InetAddress inetAddress2 = this.b;
        if (length != inetAddress2.getAddress().length) {
            return false;
        }
        a(address);
        byte[] address2 = inetAddress2.getAddress();
        address2.getClass();
        a(address2);
        return Arrays.equals(address, address2);
    }

    public final String toString() {
        return this.b.getHostAddress() + "/" + this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeSerializable(this.b);
        parcel.writeInt(this.f);
    }
}
