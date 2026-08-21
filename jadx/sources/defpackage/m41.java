package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class m41 extends r24 {
    public final int a;
    public int b;
    public int c;
    public es2 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public m41(int i) {
        super(6);
        this.a = i;
        this.e = -1;
    }

    public static m41 a(int i, boolean z) {
        m41 m41Var = new m41(1);
        if (ja0.f) {
            m41Var.c = i;
        }
        if (z) {
            m41Var.state |= 1024;
        }
        return m41Var;
    }

    @Override // defpackage.es2
    public final String getName() {
        return "Enclose";
    }

    @Override // defpackage.es2
    public final void setChild(es2 es2Var) {
        this.d = es2Var;
    }

    @Override // defpackage.r24, defpackage.es2
    public final String toString(int i) {
        StringBuilder sb = new StringBuilder(super.toString(0));
        StringBuilder sb2 = new StringBuilder("\n  type: ");
        StringBuilder sb3 = new StringBuilder();
        int i2 = this.a;
        if ((i2 & 4) != 0) {
            sb3.append("STOP_BACKTRACK ");
        }
        if ((i2 & 1) != 0) {
            sb3.append("MEMORY ");
        }
        if ((i2 & 2) != 0) {
            sb3.append("OPTION ");
        }
        if ((i2 & 8) != 0) {
            sb3.append("CONDITION ");
        }
        if ((i2 & 16) != 0) {
            sb3.append("ABSENT ");
        }
        sb2.append(sb3.toString());
        sb.append(sb2.toString());
        sb.append("\n  regNum: " + this.b);
        StringBuilder sb4 = new StringBuilder(", option: ");
        int i3 = this.c;
        String strConcat = je.M(i3) ? "IGNORECASE" : "";
        if ((i3 & 2) != 0) {
            strConcat = strConcat.concat("EXTEND");
        }
        if (je.N(i3)) {
            strConcat = strConcat.concat("MULTILINE");
        }
        if ((i3 & 8) != 0) {
            strConcat = strConcat.concat("SINGLELINE");
        }
        if ((i3 & 16) != 0) {
            strConcat = strConcat.concat("FIND_LONGEST");
        }
        if ((i3 & 32) != 0) {
            strConcat = strConcat.concat("FIND_NOT_EMPTY");
        }
        if ((i3 & 64) != 0) {
            strConcat = strConcat.concat("NEGATE_SINGLELINE");
        }
        if ((i3 & 128) != 0) {
            strConcat = strConcat.concat("DONT_CAPTURE_GROUP");
        }
        if ((i3 & 256) != 0) {
            strConcat = strConcat.concat("CAPTURE_GROUP");
        }
        if ((i3 & 512) != 0) {
            strConcat = strConcat.concat("NOTBOL");
        }
        if (je.O(i3)) {
            strConcat = strConcat.concat("NOTEOL");
        }
        if ((i3 & 2048) != 0) {
            strConcat = strConcat.concat("POSIX_REGION");
        }
        if ((i3 & 262144) != 0) {
            strConcat = strConcat.concat("CR_7_BIT");
        }
        sb4.append(strConcat);
        sb.append(sb4.toString());
        sb.append(", callAddr: " + this.e);
        sb.append(", minLength: " + this.f);
        sb.append(", maxLength: " + this.g);
        sb.append(", charLength: " + this.h);
        sb.append(", optCount: " + this.i);
        sb.append("\n  target: " + es2.pad(this.d, 1));
        return sb.toString();
    }
}
