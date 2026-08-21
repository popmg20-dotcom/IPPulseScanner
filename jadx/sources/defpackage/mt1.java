package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class mt1 {
    public final hp a;
    public boolean c;
    public int g;
    public int h;
    public int b = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    public int d = 4096;
    public hr1[] e = new hr1[8];
    public int f = 7;

    public mt1(hp hpVar) {
        this.a = hpVar;
    }

    public final void a(int i) {
        int i2;
        if (i > 0) {
            int length = this.e.length - 1;
            int i3 = 0;
            while (true) {
                i2 = this.f;
                if (length < i2 || i <= 0) {
                    break;
                }
                hr1 hr1Var = this.e[length];
                hr1Var.getClass();
                i -= hr1Var.c;
                int i4 = this.h;
                hr1 hr1Var2 = this.e[length];
                hr1Var2.getClass();
                this.h = i4 - hr1Var2.c;
                this.g--;
                i3++;
                length--;
            }
            hr1[] hr1VarArr = this.e;
            int i5 = i2 + 1;
            System.arraycopy(hr1VarArr, i5, hr1VarArr, i5 + i3, this.g);
            hr1[] hr1VarArr2 = this.e;
            int i6 = this.f + 1;
            Arrays.fill(hr1VarArr2, i6, i6 + i3, (Object) null);
            this.f += i3;
        }
    }

    public final void b(hr1 hr1Var) {
        int i = hr1Var.c;
        int i2 = this.d;
        if (i > i2) {
            hr1[] hr1VarArr = this.e;
            Arrays.fill(hr1VarArr, 0, hr1VarArr.length, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i) - i2);
        int i3 = this.g + 1;
        hr1[] hr1VarArr2 = this.e;
        if (i3 > hr1VarArr2.length) {
            hr1[] hr1VarArr3 = new hr1[hr1VarArr2.length * 2];
            System.arraycopy(hr1VarArr2, 0, hr1VarArr3, hr1VarArr2.length, hr1VarArr2.length);
            this.f = this.e.length - 1;
            this.e = hr1VarArr3;
            hr1VarArr2 = hr1VarArr3;
        }
        int i4 = this.f;
        this.f = i4 - 1;
        hr1VarArr2[i4] = hr1Var;
        this.g++;
        this.h += i;
    }

    public final void c(bu buVar) {
        buVar.getClass();
        int[] iArr = hv1.a;
        int iD = buVar.d();
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < iD; i++) {
            byte bI = buVar.i(i);
            byte[] bArr = hz4.a;
            j2 += (long) hv1.b[bI & 255];
        }
        int i2 = (int) ((j2 + 7) >> 3);
        int iD2 = buVar.d();
        hp hpVar = this.a;
        if (i2 >= iD2) {
            e(buVar.d(), 127, 0);
            hpVar.I0(buVar);
            return;
        }
        hp hpVar2 = new hp();
        int[] iArr2 = hv1.a;
        int iD3 = buVar.d();
        int i3 = 0;
        for (int i4 = 0; i4 < iD3; i4++) {
            byte bI2 = buVar.i(i4);
            byte[] bArr2 = hz4.a;
            int i5 = bI2 & 255;
            int i6 = hv1.a[i5];
            byte b = hv1.b[i5];
            j = (j << b) | ((long) i6);
            i3 += b;
            while (i3 >= 8) {
                i3 -= 8;
                hpVar2.J0((int) (j >> i3));
            }
        }
        if (i3 > 0) {
            hpVar2.J0((int) ((j << (8 - i3)) | (255 >>> i3)));
        }
        bu buVarZ = hpVar2.Z(hpVar2.f);
        e(buVarZ.d(), 127, 128);
        hpVar.I0(buVarZ);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.util.ArrayList r14) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt1.d(java.util.ArrayList):void");
    }

    public final void e(int i, int i2, int i3) {
        hp hpVar = this.a;
        if (i < i2) {
            hpVar.J0(i | i3);
            return;
        }
        hpVar.J0(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            hpVar.J0(128 | (i4 & 127));
            i4 >>>= 7;
        }
        hpVar.J0(i4);
    }
}
