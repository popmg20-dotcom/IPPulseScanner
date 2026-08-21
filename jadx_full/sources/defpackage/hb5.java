package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class hb5 implements Iterable, Serializable {
    public static final hb5 z = new hb5(nc5.b);
    public int b = 0;
    public final byte[] f;

    static {
        int i = ya5.a;
    }

    public hb5(byte[] bArr) {
        bArr.getClass();
        this.f = bArr;
    }

    public static hb5 d(int i, int i2, byte[] bArr) {
        e(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new hb5(bArr2);
    }

    public static int e(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length());
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public byte a(int i) {
        return this.f[i];
    }

    public byte b(int i) {
        return this.f[i];
    }

    public int c() {
        return this.f.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof hb5) && c() == ((hb5) obj).c()) {
            if (c() == 0) {
                return true;
            }
            if (!(obj instanceof hb5)) {
                return obj.equals(this);
            }
            hb5 hb5Var = (hb5) obj;
            int i = this.b;
            int i2 = hb5Var.b;
            if (i == 0 || i2 == 0 || i == i2) {
                int iC = c();
                if (iC > hb5Var.c()) {
                    int iC2 = c();
                    StringBuilder sb = new StringBuilder(String.valueOf(iC).length() + 18 + String.valueOf(iC2).length());
                    sb.append("Length too large: ");
                    sb.append(iC);
                    sb.append(iC2);
                    throw new IllegalArgumentException(sb.toString());
                }
                if (iC <= hb5Var.c()) {
                    byte[] bArr = hb5Var.f;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < iC) {
                        if (this.f[i3] == bArr[i4]) {
                            i3++;
                            i4++;
                        }
                    }
                    return true;
                }
                int iC3 = hb5Var.c();
                StringBuilder sb2 = new StringBuilder(String.valueOf(iC).length() + 27 + String.valueOf(iC3).length());
                sb2.append("Ran off end of other: 0, ");
                sb2.append(iC);
                sb2.append(", ");
                sb2.append(iC3);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iC = c();
        int i2 = iC;
        for (int i3 = 0; i3 < iC; i3++) {
            i2 = (i2 * 31) + this.f[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.b = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new ut(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iC = c();
        if (c() <= 50) {
            strConcat = l72.c0(this);
        } else {
            int iE = e(0, 47, c());
            strConcat = l72.c0(iE == 0 ? z : new fb5(this.f, iE)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iC);
        sb.append(" contents=\"");
        return fw.y(sb, strConcat, "\">");
    }
}
