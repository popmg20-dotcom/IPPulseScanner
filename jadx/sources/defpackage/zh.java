package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zh extends r24 {
    public final int[] a;
    public int b;
    public final int c;

    public zh(int i, int[] iArr, boolean z, boolean z2, int i2, up3 up3Var) {
        super(4);
        this.b = i;
        if (z) {
            setNameRef();
        }
        int i3 = 0;
        while (true) {
            if (i3 < i) {
                int i4 = iArr[i3];
                if (i4 <= up3Var.j && up3Var.l[i4] == null) {
                    setRecursion();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.a = iArr;
        if (ja0.h && z2) {
            this.state |= 8192;
            this.c = i2;
        }
    }

    @Override // defpackage.es2
    public final String getName() {
        return "Back Ref";
    }

    @Override // defpackage.r24, defpackage.es2
    public final String toString(int i) {
        int i2 = 0;
        StringBuilder sb = new StringBuilder(super.toString(0));
        sb.append("\n  backNum: " + this.b);
        String strW = "";
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                sb.append("\n  back: ".concat(strW));
                sb.append("\n  nextLevel: " + this.c);
                return sb.toString();
            }
            strW = fw.w(", ", new StringBuilder(strW), iArr[i2]);
            i2++;
        }
    }
}
