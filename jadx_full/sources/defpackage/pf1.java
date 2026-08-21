package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pf1 {
    public boolean a;
    public int b;
    public int c;
    public final Object d;
    public final Object e;
    public Object f;

    public pf1(int i) {
        switch (i) {
            case 1:
                this.d = new hm2(0);
                this.e = new hm2(5);
                this.f = new byte[24];
                break;
            default:
                this.d = new ae();
                this.e = new n02(10);
                break;
        }
    }

    public void a(jy2 jy2Var) {
        ae aeVar = (ae) this.d;
        n02 n02Var = (n02) this.e;
        jy2Var.getClass();
        this.a = true;
        if (!(jy2Var instanceof hy2)) {
            if (jy2Var instanceof gy2) {
                n02Var.N(null, ed2.c);
                throw null;
            }
            if (!(jy2Var instanceof iy2)) {
                g.d();
                return;
            }
            iy2 iy2Var = (iy2) jy2Var;
            n02Var.L(iy2Var.a);
            this.f = iy2Var.b;
            return;
        }
        hy2 hy2Var = (hy2) jy2Var;
        gd2 gd2Var = hy2Var.e;
        int i = hy2Var.c;
        int i2 = hy2Var.d;
        List list = hy2Var.b;
        n02Var.L(gd2Var);
        this.f = hy2Var.f;
        int iOrdinal = hy2Var.a.ordinal();
        if (iOrdinal == 0) {
            aeVar.clear();
            this.c = i2;
            this.b = i;
            aeVar.addAll(list);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                g.d();
                return;
            } else {
                this.c = i2;
                aeVar.addAll(list);
                return;
            }
        }
        this.b = i;
        int size = list.size() - 1;
        a12 a12Var = new a12(size, ye.z(size, 0, -1), -1);
        while (a12Var.z) {
            aeVar.addFirst(list.get(a12Var.nextInt()));
        }
    }

    public void b(pf1 pf1Var, kw2 kw2Var) {
        hm2 hm2Var = (hm2) this.e;
        byte[] bArr = (byte[]) this.f;
        int i = pf1Var.c;
        byte[] bArr2 = (byte[]) pf1Var.f;
        if (i == 0 || this.c == 0) {
            c();
            return;
        }
        hm2 hm2Var2 = (hm2) this.d;
        hm2 hm2Var3 = (hm2) pf1Var.d;
        if (hm2Var2.b != hm2Var3.b || hm2Var2.c != hm2Var3.c) {
            c();
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = this.c;
            if (i2 >= i3 || i2 >= pf1Var.c || bArr[i2] != bArr2[i2]) {
                break;
            }
            int iR = ((k0) kw2Var.d).r(i2, i3, bArr);
            int i4 = 1;
            while (i4 < iR) {
                int i5 = i2 + i4;
                if (bArr[i5] != bArr2[i5]) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 < iR) {
                break;
            } else {
                i2 += iR;
            }
        }
        if (!pf1Var.a || i2 < pf1Var.c || i2 < this.c) {
            this.a = false;
        }
        this.c = i2;
        int i6 = this.b;
        int i7 = pf1Var.b;
        if (i6 < 0) {
            this.b = i7;
        } else if (i7 >= 0) {
            this.b = i6 | i7;
        }
        hm2Var.b((hm2) pf1Var.e);
        if (this.a) {
            return;
        }
        hm2Var.c = 0;
    }

    public void c() {
        hm2 hm2Var = (hm2) this.d;
        hm2Var.c = 0;
        hm2Var.b = 0;
        hm2 hm2Var2 = (hm2) this.e;
        hm2Var2.c = 0;
        hm2Var2.b = 0;
        this.a = false;
        this.b = -1;
        this.c = 0;
    }

    public void d(pf1 pf1Var, k0 k0Var) {
        hm2 hm2Var = (hm2) this.e;
        int i = this.b;
        int i2 = pf1Var.b;
        if (i < 0) {
            this.b = i2;
        } else if (i != i2) {
            return;
        }
        int i3 = pf1Var.c;
        byte[] bArr = (byte[]) pf1Var.f;
        int i4 = this.c;
        int i5 = 0;
        while (i5 < i3) {
            int iR = k0Var.r(i5, i3, bArr);
            if (i4 + iR > 24) {
                break;
            }
            int i6 = 0;
            while (i6 < iR && i5 < i3) {
                ((byte[]) this.f)[i4] = bArr[i5];
                i6++;
                i4++;
                i5++;
            }
        }
        this.c = i4;
        boolean z = i5 == i3 && pf1Var.a;
        this.a = z;
        hm2 hm2Var2 = (hm2) pf1Var.e;
        int i7 = hm2Var.b;
        int i8 = z ? hm2Var2.c | (hm2Var.c & 2048) : 0;
        hm2Var.b = i7;
        hm2Var.c = i8;
    }

    public void e(int i, int i2, k0 k0Var, byte[] bArr) {
        int i3 = this.c;
        while (i < i2 && i3 < 24) {
            int iR = k0Var.r(i, i2, bArr);
            if (i3 + iR > 24) {
                break;
            }
            int i4 = 0;
            while (i4 < iR && i < i2) {
                ((byte[]) this.f)[i3] = bArr[i];
                i4++;
                i3++;
                i++;
            }
        }
        this.c = i3;
    }

    public void f(pf1 pf1Var) {
        hm2 hm2Var = (hm2) this.d;
        hm2 hm2Var2 = (hm2) pf1Var.d;
        hm2Var.b = hm2Var2.b;
        hm2Var.c = hm2Var2.c;
        hm2 hm2Var3 = (hm2) this.e;
        hm2 hm2Var4 = (hm2) pf1Var.e;
        hm2Var3.b = hm2Var4.b;
        hm2Var3.c = hm2Var4.c;
        this.a = pf1Var.a;
        this.b = pf1Var.b;
        this.c = pf1Var.c;
        System.arraycopy((byte[]) pf1Var.f, 0, (byte[]) this.f, 0, 24);
    }

    public List g() {
        ae aeVar = (ae) this.d;
        if (!this.a) {
            return g41.b;
        }
        ArrayList arrayList = new ArrayList();
        gd2 gd2VarO = ((n02) this.e).O();
        if (aeVar.isEmpty()) {
            arrayList.add(new iy2(gd2VarO, (gd2) this.f));
            return arrayList;
        }
        hy2 hy2Var = hy2.g;
        arrayList.add(new hy2(hd2.b, d70.y0(aeVar), this.b, this.c, gd2VarO, (gd2) this.f));
        return arrayList;
    }

    public void h(pf1 pf1Var, k0 k0Var) {
        int i = this.c;
        int i2 = pf1Var.c;
        if (i2 == 0) {
            return;
        }
        if (i == 0) {
            f(pf1Var);
            return;
        }
        if (i <= 2 && i2 <= 2) {
            int iH = lw2.h(((byte[]) this.f)[0] & 255, k0Var);
            int iH2 = lw2.h(((byte[]) pf1Var.f)[0] & 255, k0Var);
            if (this.c > 1) {
                iH2 += 5;
            }
            i2 = pf1Var.c > 1 ? iH + 5 : iH;
            i = iH2;
        }
        if (this.b <= 0) {
            i *= 2;
        }
        if (pf1Var.b <= 0) {
            i2 *= 2;
        }
        if (((hm2) this.d).d((hm2) pf1Var.d, i, i2) > 0) {
            f(pf1Var);
        }
    }
}
