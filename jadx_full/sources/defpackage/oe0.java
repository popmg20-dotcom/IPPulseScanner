package defpackage;

import java.net.HttpCookie;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oe0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final boolean f;
    public final boolean g;

    public oe0(String str, String str2, String str3, String str4, long j, boolean z, boolean z2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = j;
        this.f = z;
        this.g = z2;
    }

    public final HttpCookie a() {
        HttpCookie httpCookie = new HttpCookie(this.a, this.b);
        String str = this.c;
        if (str != null) {
            httpCookie.setDomain(str);
        }
        String str2 = this.d;
        if (str2 != null) {
            httpCookie.setPath(str2);
        }
        httpCookie.setMaxAge(this.e);
        httpCookie.setSecure(this.f);
        try {
            HttpCookie.class.getMethod("setHttpOnly", Boolean.TYPE).invoke(httpCookie, Boolean.valueOf(this.g));
        } catch (Exception unused) {
        }
        return httpCookie;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oe0)) {
            return false;
        }
        oe0 oe0Var = (oe0) obj;
        return this.a.equals(oe0Var.a) && this.b.equals(oe0Var.b) && n12.c(this.c, oe0Var.c) && n12.c(this.d, oe0Var.d) && this.e == oe0Var.e && this.f == oe0Var.f && this.g == oe0Var.g;
    }

    public final int hashCode() {
        int iW = dw2.w(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        int iHashCode = (iW + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        long j = this.e;
        return ((((((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f ? 1231 : 1237)) * 31) + (this.g ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sbE = fw.E("CookieSnapshot(name=", this.a, ", value=", this.b, ", domain=");
        ha0.v(sbE, this.c, ", path=", this.d, ", maxAge=");
        sbE.append(this.e);
        sbE.append(", secure=");
        sbE.append(this.f);
        sbE.append(", httpOnly=");
        sbE.append(this.g);
        sbE.append(")");
        return sbE.toString();
    }
}
