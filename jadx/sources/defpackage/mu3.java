package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Base64;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mu3 implements ea3 {
    public static final Parcelable.Creator<mu3> CREATOR = new ym3(16);
    public static final Set E0;
    public static final Set F0;
    public static final LinkedHashSet G0;
    public final String A;
    public final tn A0;
    public final String B0;
    public final n84 C0;
    public final n84 D0;
    public final String X;
    public final lu3 Y;
    public final String Z;
    public String b;
    public final String f;
    public final String y0;
    public final int z;
    public final boolean z0;

    static {
        Set setT0 = qe.t0(new String[]{"aes-128-gcm", "aes-192-gcm", "aes-256-gcm", "chacha20-ietf-poly1305", "xchacha20-ietf-poly1305", "2022-blake3-aes-128-gcm", "2022-blake3-aes-256-gcm"});
        E0 = setT0;
        Set setT02 = qe.t0(new String[]{"rc4", "rc4-md5", "aes-128-cfb", "aes-192-cfb", "aes-256-cfb", "aes-128-ctr", "aes-192-ctr", "aes-256-ctr", "bf-cfb", "camellia-128-cfb", "camellia-192-cfb", "camellia-256-cfb", "salsa20", "chacha20", "chacha20-ietf"});
        F0 = setT02;
        LinkedHashSet linkedHashSetB0 = yr2.b0(setT0, setT02);
        LinkedHashSet linkedHashSet = new LinkedHashSet(fh2.U(linkedHashSetB0.size() + 1));
        linkedHashSet.addAll(linkedHashSetB0);
        linkedHashSet.add("none");
        G0 = linkedHashSet;
    }

    public mu3(String str, String str2, int i, String str3, String str4, lu3 lu3Var, String str5, String str6, boolean z, tn tnVar, String str7) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        lu3Var.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = i;
        this.A = str3;
        this.X = str4;
        this.Y = lu3Var;
        this.Z = str5;
        this.y0 = str6;
        this.z0 = z;
        this.A0 = tnVar;
        this.B0 = str7;
        final int i2 = 0;
        this.C0 = new n84(new pl1(this) { // from class: ku3
            public final /* synthetic */ mu3 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                String str8;
                int i3 = i2;
                lu3 lu3Var2 = lu3.NONE;
                mu3 mu3Var = this.f;
                switch (i3) {
                    case 0:
                        lu3 lu3Var3 = mu3Var.Y;
                        String str9 = mu3Var.Z;
                        if (lu3Var3 == lu3Var2 || str9 != null) {
                        }
                        break;
                    default:
                        lu3 lu3Var4 = mu3Var.Y;
                        str8 = mu3Var.y0;
                        if (lu3Var4 == lu3Var2 || str8 != null) {
                        }
                        break;
                }
                return str8;
            }
        });
        final int i3 = 1;
        this.D0 = new n84(new pl1(this) { // from class: ku3
            public final /* synthetic */ mu3 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                String str8;
                int i32 = i3;
                lu3 lu3Var2 = lu3.NONE;
                mu3 mu3Var = this.f;
                switch (i32) {
                    case 0:
                        lu3 lu3Var3 = mu3Var.Y;
                        String str9 = mu3Var.Z;
                        if (lu3Var3 == lu3Var2 || str9 != null) {
                        }
                        break;
                    default:
                        lu3 lu3Var4 = mu3Var.Y;
                        str8 = mu3Var.y0;
                        if (lu3Var4 == lu3Var2 || str8 != null) {
                        }
                        break;
                }
                return str8;
            }
        });
        if (F0.contains(str3)) {
            String strV = fw.v("proxy ", this.b, ": Stream ciphers ", str3, " are insecure, therefore deprecated, and should be almost always avoided.");
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "Shadowsocks", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strV);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("Shadowsocks", strV, null);
            }
        } else if (!G0.contains(str3)) {
            e04.f("unsupported method: ".concat(str3));
            throw null;
        }
        if (str3.equals("2022-blake3-aes-128-gcm")) {
            a(16);
        } else if (str3.equals("2022-blake3-aes-256-gcm")) {
            a(32);
        }
        if (lb3.c(i)) {
            return;
        }
        e04.f(dw2.A(i, "not a valid port: "));
        throw null;
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean A(t53 t53Var, Map map, boolean z) {
        return dw2.q(this, t53Var, map, z);
    }

    @Override // defpackage.ea3
    public final String C() {
        return this.b;
    }

    @Override // defpackage.ea3
    public final void K(String str) {
        str.getClass();
        this.b = str;
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean U(boolean z) {
        return dw2.p(this, z);
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.A0;
    }

    public final void a(int i) {
        byte[] bArrDecode;
        String strQ0 = p44.Q0(this.X, ':');
        if (!xj.c(strQ0)) {
            e04.f(ha0.o("proxy ", this.b, ": Shadowsocks 2022 password must be Base64 encoded"));
            return;
        }
        try {
            bArrDecode = Base64.decode(strQ0, 0);
        } catch (IllegalArgumentException unused) {
            bArrDecode = null;
        }
        if (bArrDecode == null || bArrDecode.length != i) {
            e04.f(fw.t(i, "proxy ", this.b, ": Shadowsocks 2022 password must be ", " bytes after Base64 decoding"));
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.z0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mu3)) {
            return false;
        }
        mu3 mu3Var = (mu3) obj;
        return n12.c(this.b, mu3Var.b) && n12.c(this.f, mu3Var.f) && this.z == mu3Var.z && n12.c(this.A, mu3Var.A) && n12.c(this.X, mu3Var.X) && this.Y == mu3Var.Y && n12.c(this.Z, mu3Var.Z) && n12.c(this.y0, mu3Var.y0) && this.z0 == mu3Var.z0 && this.A0 == mu3Var.A0 && n12.c(this.B0, mu3Var.B0);
    }

    @Override // defpackage.ea3
    public final String getName() {
        return this.b;
    }

    @Override // defpackage.ea3
    public final /* bridge */ String getType() {
        return dw2.g(this);
    }

    public final int hashCode() {
        int iHashCode = (this.Y.hashCode() + dw2.w(dw2.w((dw2.w(this.b.hashCode() * 31, 31, this.f) + this.z) * 31, 31, this.A), 31, this.X)) * 31;
        String str = this.Z;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.y0;
        int iHashCode3 = (this.A0.hashCode() + ((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.z0 ? 1231 : 1237)) * 31)) * 31;
        String str3 = this.B0;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.B0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Shadowsocks(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", method=");
        sbE.append(this.A);
        sbE.append(", password=");
        sbE.append(this.X);
        sbE.append(", obfs=");
        sbE.append(this.Y);
        sbE.append(", obfsHost=");
        ha0.v(sbE, this.Z, ", obfsUri=", this.y0, ", udpRelay=");
        sbE.append(this.z0);
        sbE.append(", blockQuic=");
        sbE.append(this.A0);
        sbE.append(", underlyingProxy=");
        return fw.y(sbE, this.B0, ")");
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean v() {
        return dw2.h(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeInt(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.X);
        parcel.writeString(this.Y.name());
        parcel.writeString(this.Z);
        parcel.writeString(this.y0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeString(this.A0.name());
        parcel.writeString(this.B0);
    }

    public /* synthetic */ mu3(String str, String str2, int i, String str3, String str4, lu3 lu3Var, String str5, String str6) {
        this(str, str2, i, str3, str4, lu3Var, str5, str6, false, tn.b, null);
    }
}
