package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lt1 {
    public final he3 c;
    public int f;
    public int g;
    public int a = 4096;
    public final ArrayList b = new ArrayList();
    public hr1[] d = new hr1[8];
    public int e = 7;

    public lt1(hu1 hu1Var) {
        this.c = new he3(hu1Var);
    }

    public final int a(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.d.length;
            while (true) {
                length--;
                i2 = this.e;
                if (length < i2 || i <= 0) {
                    break;
                }
                hr1 hr1Var = this.d[length];
                hr1Var.getClass();
                int i4 = hr1Var.c;
                i -= i4;
                this.g -= i4;
                this.f--;
                i3++;
            }
            hr1[] hr1VarArr = this.d;
            int i5 = i2 + 1;
            System.arraycopy(hr1VarArr, i5, hr1VarArr, i5 + i3, this.f);
            this.e += i3;
        }
        return i3;
    }

    public final bu b(int i) throws IOException {
        if (i >= 0) {
            hr1[] hr1VarArr = nt1.a;
            if (i <= hr1VarArr.length - 1) {
                return hr1VarArr[i].a;
            }
        }
        int length = this.e + 1 + (i - nt1.a.length);
        if (length >= 0) {
            hr1[] hr1VarArr2 = this.d;
            if (length < hr1VarArr2.length) {
                hr1 hr1Var = hr1VarArr2[length];
                hr1Var.getClass();
                return hr1Var.a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(hr1 hr1Var) {
        this.b.add(hr1Var);
        int i = hr1Var.c;
        int i2 = this.a;
        if (i > i2) {
            hr1[] hr1VarArr = this.d;
            Arrays.fill(hr1VarArr, 0, hr1VarArr.length, (Object) null);
            this.e = this.d.length - 1;
            this.f = 0;
            this.g = 0;
            return;
        }
        a((this.g + i) - i2);
        int i3 = this.f + 1;
        hr1[] hr1VarArr2 = this.d;
        if (i3 > hr1VarArr2.length) {
            hr1[] hr1VarArr3 = new hr1[hr1VarArr2.length * 2];
            System.arraycopy(hr1VarArr2, 0, hr1VarArr3, hr1VarArr2.length, hr1VarArr2.length);
            this.e = this.d.length - 1;
            this.d = hr1VarArr3;
            hr1VarArr2 = hr1VarArr3;
        }
        int i4 = this.e;
        this.e = i4 - 1;
        hr1VarArr2[i4] = hr1Var;
        this.f++;
        this.g += i;
    }

    public final bu d() {
        he3 he3Var = this.c;
        byte bS = he3Var.s();
        byte[] bArr = hz4.a;
        int i = bS & 255;
        int i2 = 0;
        boolean z = (bS & 128) == 128;
        long jE = e(i, 127);
        if (!z) {
            return he3Var.x(jE);
        }
        hp hpVar = new hp();
        tt ttVar = hv1.c;
        tt ttVar2 = ttVar;
        int i3 = 0;
        for (long j = 0; j < jE; j++) {
            byte bS2 = he3Var.s();
            byte[] bArr2 = hz4.a;
            i2 = (i2 << 8) | (bS2 & 255);
            i3 += 8;
            while (i3 >= 8) {
                int i4 = (i2 >>> (i3 - 8)) & DnsRecord.CLASS_ANY;
                tt[] ttVarArr = (tt[]) ttVar2.d;
                ttVarArr.getClass();
                ttVar2 = ttVarArr[i4];
                ttVar2.getClass();
                if (((tt[]) ttVar2.d) == null) {
                    hpVar.J0(ttVar2.b);
                    i3 -= ttVar2.c;
                    ttVar2 = ttVar;
                } else {
                    i3 -= 8;
                }
            }
        }
        while (i3 > 0) {
            int i5 = (i2 << (8 - i3)) & DnsRecord.CLASS_ANY;
            tt[] ttVarArr2 = (tt[]) ttVar2.d;
            ttVarArr2.getClass();
            tt ttVar3 = ttVarArr2[i5];
            ttVar3.getClass();
            int i6 = ttVar3.c;
            if (((tt[]) ttVar3.d) != null || i6 > i3) {
                break;
            }
            hpVar.J0(ttVar3.b);
            i3 -= i6;
            ttVar2 = ttVar;
        }
        return hpVar.Z(hpVar.f);
    }

    public final int e(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            byte bS = this.c.s();
            byte[] bArr = hz4.a;
            int i5 = bS & 255;
            if ((bS & 128) == 0) {
                return i2 + (i5 << i4);
            }
            i2 += (bS & 127) << i4;
            i4 += 7;
        }
    }
}
