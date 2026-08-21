package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class s extends r {
    public abstract void C(int i, StringBuilder sb);

    public abstract int D(int i);

    public final void E(StringBuilder sb, int i, int i2) {
        int iY = ed4.y(i, i2, (bn) ((ed4) this.b).f);
        C(iY, sb);
        int iD = D(iY);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iD / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iD);
    }
}
