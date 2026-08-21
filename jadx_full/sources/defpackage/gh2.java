package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gh2 implements Serializable {
    public final int A;
    public final int b;
    public final int f;
    public final int[] z;

    public gh2(int i, int i2, int[] iArr, int i3) {
        this.b = i;
        this.f = i2;
        this.z = iArr;
        this.A = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r6 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        String str;
        int[] iArr;
        String str2;
        int i = this.A;
        int i2 = i;
        while (true) {
            str = " ... ";
            iArr = this.z;
            if (i2 <= 0) {
                break;
            }
            if (p30.c.b(iArr[i2 - 1])) {
                break;
            }
            int i3 = i2 - 1;
            if (i - i3 > 36.5f) {
                i2 += 4;
                str2 = " ... ";
                break;
            }
            i2 = i3;
        }
        int i4 = i;
        while (i4 < iArr.length) {
            if (p30.c.b(iArr[i4])) {
                break;
            }
            int i5 = i4 + 1;
            if (i5 - i > 36.5f) {
                i4 -= 4;
                break;
            }
            i4 = i5;
        }
        str = "";
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 4; i6++) {
            sb.append(" ");
        }
        sb.append(str2);
        for (int i7 = i2; i7 < i4; i7++) {
            sb.appendCodePoint(iArr[i7]);
        }
        sb.append(str);
        sb.append("\n");
        for (int i8 = 0; i8 < str2.length() + ((4 + i) - i2); i8++) {
            sb.append(" ");
        }
        sb.append("^");
        String string = sb.toString();
        StringBuilder sbA = fw.A(this.b + 1, this.f + 1, " in reader, line ", ", column ", ":\n");
        sbA.append(string);
        return sbA.toString();
    }
}
