package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q extends s {
    public final String c;
    public final String d;

    public q(bn bnVar, String str, String str2) {
        super(bnVar);
        this.c = str2;
        this.d = str;
    }

    @Override // defpackage.s
    public final void C(int i, StringBuilder sb) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // defpackage.s
    public final int D(int i) {
        return i % 100000;
    }

    @Override // defpackage.m0
    public final String p() throws qs2 {
        if (((bn) this.a).f != 84) {
            throw qs2.a();
        }
        StringBuilder sb = new StringBuilder();
        A(8, sb);
        E(sb, 48, 20);
        int iY = ed4.y(68, 16, (bn) ((ed4) this.b).f);
        if (iY != 38400) {
            sb.append('(');
            sb.append(this.c);
            sb.append(')');
            int i = iY % 32;
            int i2 = iY / 32;
            int i3 = (i2 % 12) + 1;
            int i4 = i2 / 12;
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i3);
            if (i / 10 == 0) {
                sb.append('0');
            }
            sb.append(i);
        }
        return sb.toString();
    }
}
