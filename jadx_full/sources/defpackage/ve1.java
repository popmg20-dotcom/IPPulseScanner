package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ve1 {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;

    public ve1(int i, int i2, String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ve1)) {
            return false;
        }
        ve1 ve1Var = (ve1) obj;
        return this.a.equals(ve1Var.a) && this.b.equals(ve1Var.b) && n12.c(this.c, ve1Var.c) && this.d == ve1Var.d && this.e == ve1Var.e;
    }

    public final int hashCode() {
        int iW = dw2.w(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return ((((iW + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("FinishData(profileName=", this.a, ", groupName=", this.b, ", sessionId=");
        sbE.append(this.c);
        sbE.append(", onlineCount=");
        sbE.append(this.d);
        sbE.append(", noResponseCount=");
        return fw.w(")", sbE, this.e);
    }
}
