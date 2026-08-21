package defpackage;

import android.util.Pair;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r70 {
    public final q70 a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final boolean j;
    public final int k;
    public final int l;

    public r70(boolean z, String... strArr) {
        byte b;
        byte[] bArr;
        this.j = z;
        int length = strArr.length;
        byte b2 = 0;
        int i = 0;
        int length2 = 0;
        while (i < length) {
            String str = strArr[i];
            if (this.j) {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                byte[] bArrH = gb4.H((short) str.length());
                byte[] bArrH2 = gb4.H((short) bytes.length);
                byte[][] bArr2 = new byte[4][];
                bArr2[b2] = bArrH;
                bArr2[1] = bArrH2;
                bArr2[2] = bytes;
                byte[] bArr3 = new byte[1];
                bArr3[b2] = b2;
                bArr2[3] = bArr3;
                int i2 = b2;
                int length3 = i2;
                while (i2 < 4) {
                    length3 += bArr2[i2].length;
                    i2++;
                }
                bArr = new byte[length3];
                int i3 = b2;
                int length4 = i3;
                while (i3 < 4) {
                    byte[] bArr4 = bArr2[i3];
                    System.arraycopy(bArr4, b2, bArr, length4, bArr4.length);
                    length4 += bArr4.length;
                    i3++;
                }
                b = b2;
            } else {
                char[] charArray = str.toCharArray();
                int length5 = charArray.length * 2;
                byte[] bArr5 = new byte[length5 + 4];
                byte[] bArrW = gb4.W((short) charArray.length);
                bArr5[b2] = bArrW[b2];
                bArr5[1] = bArrW[1];
                int i4 = b2;
                byte b3 = b2;
                while (i4 < charArray.length) {
                    char c = charArray[i4];
                    byte b4 = (byte) (c & 255);
                    byte b5 = (byte) ((c >> '\b') & DnsRecord.CLASS_ANY);
                    byte b6 = b3;
                    byte[] bArr6 = new byte[2];
                    bArr6[b6 == true ? 1 : 0] = b4;
                    bArr6[1] = b5;
                    int i5 = i4 * 2;
                    bArr5[i5 + 2] = bArr6[b6 == true ? 1 : 0];
                    bArr5[i5 + 3] = bArr6[1];
                    i4++;
                    b3 = b6 == true ? 1 : 0;
                }
                b = b3;
                bArr5[length5 + 2] = b;
                bArr5[length5 + 3] = b;
                bArr = bArr5;
            }
            Pair pair = new Pair(bArr, Collections.EMPTY_LIST);
            this.f.add(Integer.valueOf(length2));
            byte[] bArr7 = (byte[]) pair.first;
            length2 += bArr7.length;
            this.h.add(bArr7);
            this.i.add((List) pair.second);
            i++;
            b2 = b;
        }
        byte b7 = b2;
        int size = b2;
        for (List list : this.i) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    this.f.add(Integer.valueOf(length2));
                    throw null;
                }
                st4.n();
                throw null;
            }
            this.g.add(Integer.valueOf(size == true ? 1 : 0));
            size = (size == true ? 1 : 0) + (list.size() * 12) + 4;
        }
        int i6 = length2 % 4;
        int i7 = i6 == 0 ? b7 == true ? 1 : 0 : 4 - i6;
        this.k = i7;
        int size2 = this.h.size();
        this.b = size2;
        this.c = this.h.size() - strArr.length;
        boolean z2 = this.h.size() - strArr.length > 0 ? true : b7 == true ? 1 : 0;
        if (!z2) {
            this.g.clear();
            this.i.clear();
        }
        int size3 = (this.g.size() * 4) + (size2 * 4) + 28;
        this.d = size3;
        int i8 = length2 + i7;
        this.e = z2 ? size3 + i8 : b7 == true ? 1 : 0;
        int i9 = size3 + i8 + (z2 ? size : b7 == true ? 1 : 0);
        this.l = i9;
        this.a = new q70((short) 1, (short) 28, i9);
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        this.a.a(byteArrayOutputStream);
        byteArrayOutputStream.write(gb4.Q(this.b));
        byteArrayOutputStream.write(gb4.Q(this.c));
        byteArrayOutputStream.write(gb4.Q(this.j ? 256 : 0));
        byteArrayOutputStream.write(gb4.Q(this.d));
        byteArrayOutputStream.write(gb4.Q(this.e));
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            byteArrayOutputStream.write(gb4.Q(((Integer) it.next()).intValue()));
        }
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            byteArrayOutputStream.write(gb4.Q(((Integer) it2.next()).intValue()));
        }
        Iterator it3 = this.h.iterator();
        while (it3.hasNext()) {
            byteArrayOutputStream.write((byte[]) it3.next());
        }
        int i = this.k;
        if (i > 0) {
            byteArrayOutputStream.write(new byte[i]);
        }
        Iterator it4 = this.i.iterator();
        while (it4.hasNext()) {
            Iterator it5 = ((List) it4.next()).iterator();
            if (it5.hasNext()) {
                throw dw2.z(it5);
            }
            byteArrayOutputStream.write(gb4.Q(-1));
        }
    }
}
