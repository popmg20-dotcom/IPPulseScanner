package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class au implements Iterable, Serializable {
    public static final yt A;
    public static final au z = new au(j12.b);
    public int b = 0;
    public final byte[] f;

    static {
        A = m7.a() ? new k01(11) : new wl3(10);
    }

    public au(byte[] bArr) {
        bArr.getClass();
        this.f = bArr;
    }

    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            s53.k(ha0.k("Beginning index: ", i, " < 0"));
            return 0;
        }
        if (i2 < i) {
            s53.k(fw.s(i, i2, "Beginning index larger than ending index: ", ", "));
            return 0;
        }
        s53.k(fw.s(i2, i3, "End index: ", " >= "));
        return 0;
    }

    public static au c(int i, int i2, byte[] bArr) {
        b(i, i + i2, bArr.length);
        return new au(A.a(i, i2, bArr));
    }

    public byte a(int i) {
        return this.f[i];
    }

    public void d(int i, byte[] bArr) {
        System.arraycopy(this.f, 0, bArr, 0, i);
    }

    public int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof au) || size() != ((au) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof au)) {
            return obj.equals(this);
        }
        au auVar = (au) obj;
        int i = this.b;
        int i2 = auVar.b;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > auVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > auVar.size()) {
            StringBuilder sbD = dw2.D("Ran off end of other: 0, ", size, ", ");
            sbD.append(auVar.size());
            throw new IllegalArgumentException(sbD.toString());
        }
        byte[] bArr = auVar.f;
        int iE = e() + size;
        int iE2 = e();
        int iE3 = auVar.e();
        while (iE2 < iE) {
            if (this.f[iE2] != bArr[iE3]) {
                return false;
            }
            iE2++;
            iE3++;
        }
        return true;
    }

    public byte f(int i) {
        return this.f[i];
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iE = e();
        int i2 = size;
        for (int i3 = iE; i3 < iE + size; i3++) {
            i2 = (i2 * 31) + this.f[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.b = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new ut(this);
    }

    public int size() {
        return this.f.length;
    }

    public final String toString() {
        au wtVar;
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strConcat = n12.w(this);
        } else {
            int iB = b(0, 47, size());
            if (iB == 0) {
                wtVar = z;
            } else {
                wtVar = new wt(e(), iB, this.f);
            }
            strConcat = n12.w(wtVar).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return fw.y(sb, strConcat, "\">");
    }
}
