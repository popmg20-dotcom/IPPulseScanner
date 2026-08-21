package defpackage;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hx0 {
    public final String a;
    public final byte[] b;
    public final Uri c;
    public final long d;

    public hx0(String str, byte[] bArr, Uri uri, long j) {
        str.getClass();
        this.a = str;
        this.b = bArr;
        this.c = uri;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!hx0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        hx0 hx0Var = (hx0) obj;
        return n12.c(this.a, hx0Var.a) && Arrays.equals(this.b, hx0Var.b) && this.c.equals(hx0Var.c) && this.d == hx0Var.d;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((Arrays.hashCode(this.b) + (this.a.hashCode() * 31)) * 31)) * 31;
        long j = this.d;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sbE = fw.E("DomainSet(url=", this.a, ", content=", Arrays.toString(this.b), ", uri=");
        sbE.append(this.c);
        sbE.append(", updateTime=");
        sbE.append(this.d);
        sbE.append(")");
        return sbE.toString();
    }
}
