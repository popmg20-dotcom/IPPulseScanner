package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ho2 {
    public final byte[] a;
    public final int b;
    public final int c;
    public int d;
    public int e;
    public int[] f;

    public ho2(int i, int i2, byte[] bArr) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
    }

    public final String toString() {
        int i = this.c;
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(new String(this.a, i2, i - i2).concat(" "));
        int i3 = this.d;
        if (i3 == 0) {
            sb.append("-");
        } else if (i3 == 1) {
            sb.append(this.e);
        } else {
            for (int i4 = 0; i4 < this.d; i4++) {
                if (i4 > 0) {
                    sb.append(", ");
                }
                sb.append(this.f[i4]);
            }
        }
        return sb.toString();
    }
}
