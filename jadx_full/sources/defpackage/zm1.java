package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zm1 implements Parcelable {
    public static final Parcelable.Creator<zm1> CREATOR = new o3(13);
    public final bf b;
    public final qj0 f;

    public zm1(bf bfVar) {
        String str;
        bfVar.getClass();
        this.b = bfVar;
        qj0 qj0VarA = a();
        if (qj0VarA == null) {
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "GEOIP", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "geoip database file corrupted, reset and retry");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("GEOIP", "geoip database file corrupted, reset and retry", null);
            }
            File fileA = bf.a();
            synchronized (ko1.a) {
                try {
                    File absoluteFile = fileA.getAbsoluteFile();
                    if (n12.c(absoluteFile, ko1.e.getAbsoluteFile()) || n12.c(absoluteFile, ko1.f.getAbsoluteFile())) {
                        String str2 = "delete corrupted geoip database file: " + fileA;
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 3, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                            str = str2;
                        } else {
                            str = str2;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.o("GeoIPConfig", str, null);
                        }
                        absoluteFile.delete();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            qj0VarA = a();
        }
        this.f = qj0VarA;
    }

    public final qj0 a() {
        try {
            this.b.getClass();
            return new qj0(new eg0(bf.a()));
        } catch (Exception e) {
            String strN = ha0.n("failed to build geoip database reader: ", e.getMessage());
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "GEOIP", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("GEOIP", strN, null);
            }
            return null;
        }
    }

    public final String d(InetAddress inetAddress) {
        uf0 uf0Var;
        inetAddress.getClass();
        qj0 qj0Var = this.f;
        if (qj0Var == null) {
            return null;
        }
        try {
            vf0 vf0VarG = qj0Var.g(inetAddress);
            if (vf0VarG == null || (uf0Var = vf0VarG.b) == null) {
                return null;
            }
            return uf0Var.B0;
        } catch (c6 | IOException | UnsupportedOperationException unused) {
            return null;
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
        return (obj instanceof zm1) && n12.c(this.b, ((zm1) obj).b);
    }

    public final int hashCode() {
        this.b.getClass();
        return bf.class.hashCode();
    }

    public final String toString() {
        return "GEOIP(source=" + this.b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.b, i);
    }
}
