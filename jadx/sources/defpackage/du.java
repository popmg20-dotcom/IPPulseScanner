package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class du implements Iterable {
    public static final int[] X;
    public static final int Y;
    public final /* synthetic */ int A;
    public fr1[] b;
    public int f;
    public fr1 z;

    static {
        int[] iArr = {11, 19, 37, 67, 131, 283, 521, 1033, 2053, 4099, 8219, 16427, 32771, 65581, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741909, 0};
        X = iArr;
        Y = iArr[0];
    }

    public du(int i, int i2) {
        this.A = i2;
        int i3 = 0;
        int i4 = 8;
        while (i3 < 29) {
            if (i4 > i) {
                this.b = new fr1[X[i3]];
                g();
                return;
            } else {
                i3++;
                i4 <<= 1;
            }
        }
        throw new r41("run out of polynomials");
    }

    public static int d(int i, int i2, byte[] bArr) {
        int i3 = 0;
        while (i < i2) {
            int i4 = ((i3 << 16) + (i3 << 6)) - i3;
            i3 = bArr[i] + i4;
            i++;
        }
        return i3 + (i3 >> 5);
    }

    public static int e(int[] iArr) {
        int i;
        int i2;
        int length = iArr.length;
        if (length == 1) {
            return iArr[0];
        }
        if (length == 2) {
            i = iArr[0];
            i2 = iArr[1];
        } else if (length == 3) {
            i = iArr[0] + iArr[1];
            i2 = iArr[2];
        } else {
            if (length != 4) {
                int i3 = 0;
                for (int i4 : iArr) {
                    i3 += i4;
                }
                return i3;
            }
            i = iArr[0] + iArr[1] + iArr[2];
            i2 = iArr[3];
        }
        return i + i2;
    }

    public static int f(int i, int i2, byte[] bArr) {
        int i3 = 0;
        while (i < i2) {
            i3 = (((i3 << 16) + (i3 << 6)) - i3) + ek0.b[bArr[i] & 255];
            i++;
        }
        return i3 + (i3 >> 5);
    }

    public final void a() {
        int i = this.f;
        fr1[] fr1VarArr = this.b;
        if (i == fr1VarArr.length) {
            int length = fr1VarArr.length + 1;
            int i2 = 8;
            int i3 = 0;
            while (i3 < 29) {
                if (i2 > length) {
                    int i4 = X[i3];
                    fr1[] fr1VarArr2 = this.b;
                    fr1[] fr1VarArr3 = new fr1[i4];
                    for (int i5 = 0; i5 < fr1VarArr2.length; i5++) {
                        fr1 fr1Var = fr1VarArr2[i5];
                        fr1VarArr2[i5] = null;
                        while (fr1Var != null) {
                            fr1 fr1Var2 = fr1Var.b;
                            int i6 = fr1Var.a % i4;
                            fr1Var.b = fr1VarArr3[i6];
                            fr1VarArr3[i6] = fr1Var;
                            fr1Var = fr1Var2;
                        }
                    }
                    this.b = fr1VarArr3;
                    return;
                }
                i3++;
                i2 <<= 1;
            }
        }
    }

    public Object b(int i, int i2, byte[] bArr) {
        switch (this.A) {
            case 0:
                int iD = d(i, i2, bArr) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                fr1[] fr1VarArr = this.b;
                fr1 fr1Var = fr1VarArr[iD % fr1VarArr.length];
                while (true) {
                    cu cuVar = (cu) fr1Var;
                    if (cuVar == null) {
                        return null;
                    }
                    if (cuVar.a == iD && cuVar.a(i, i2, bArr)) {
                        return cuVar.e;
                    }
                    fr1Var = cuVar.b;
                }
                break;
            default:
                int iF = f(i, i2, bArr) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                fr1[] fr1VarArr2 = this.b;
                fr1 fr1Var2 = fr1VarArr2[iF % fr1VarArr2.length];
                while (true) {
                    i20 i20Var = (i20) fr1Var2;
                    if (i20Var == null) {
                        return null;
                    }
                    if (i20Var.a == iF && i20Var.a(i, i2, bArr)) {
                        return i20Var.e;
                    }
                    fr1Var2 = i20Var.b;
                }
                break;
        }
    }

    public Object c(int... iArr) {
        w02 w02Var;
        int iE = e(iArr) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        fr1[] fr1VarArr = this.b;
        fr1 fr1Var = fr1VarArr[iE % fr1VarArr.length];
        loop0: while (true) {
            w02Var = (w02) fr1Var;
            if (w02Var == null) {
                return null;
            }
            if (w02Var.a == iE) {
                int[] iArr2 = w02Var.f;
                if (iArr2 == iArr) {
                    break;
                }
                if (iArr2.length == iArr.length) {
                    int length = iArr.length;
                    if (length == 1) {
                        if (iArr2[0] == iArr[0]) {
                            break;
                        }
                    } else if (length != 2) {
                        if (length != 3) {
                            if (length != 4) {
                                for (int i = 0; i < iArr.length; i++) {
                                    if (iArr2[i] != iArr[i]) {
                                        break;
                                    }
                                }
                                break loop0;
                            }
                            if (iArr2[0] == iArr[0] && iArr2[1] == iArr[1] && iArr2[2] == iArr[2] && iArr2[3] == iArr[3]) {
                                break;
                            }
                        } else {
                            if (iArr2[0] == iArr[0] && iArr2[1] == iArr[1] && iArr2[2] == iArr[2]) {
                                break;
                            }
                        }
                    } else {
                        if (iArr2[0] == iArr[0] && iArr2[1] == iArr[1]) {
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
            fr1Var = w02Var.b;
        }
        return w02Var.e;
    }

    public final void g() {
        switch (this.A) {
            case 0:
                this.z = new cu();
                break;
            case 1:
                this.z = new i20();
                break;
            case 2:
                this.z = new w02();
                break;
            default:
                this.z = new y02();
                break;
        }
    }

    public Object get(int i) {
        int i2 = i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        fr1[] fr1VarArr = this.b;
        fr1 fr1Var = fr1VarArr[i2 % fr1VarArr.length];
        while (true) {
            y02 y02Var = (y02) fr1Var;
            if (y02Var == null) {
                return null;
            }
            if (y02Var.a == i2) {
                return y02Var.e;
            }
            fr1Var = y02Var.b;
        }
    }

    public void h(byte[] bArr, Integer num) {
        switch (this.A) {
            case 0:
                int length = bArr.length;
                a();
                int iD = Integer.MAX_VALUE & d(0, length, bArr);
                fr1[] fr1VarArr = this.b;
                int length2 = iD % fr1VarArr.length;
                fr1 fr1Var = fr1VarArr[length2];
                while (true) {
                    cu cuVar = (cu) fr1Var;
                    if (cuVar == null) {
                        fr1[] fr1VarArr2 = this.b;
                        fr1VarArr2[length2] = new cu(iD, fr1VarArr2[length2], num, bArr, 0, length, this.z);
                        this.f++;
                    } else if (cuVar.a == iD && cuVar.a(0, length, bArr)) {
                        cuVar.e = num;
                    } else {
                        fr1Var = cuVar.b;
                    }
                    break;
                }
                break;
            default:
                int length3 = bArr.length;
                a();
                int iF = f(0, length3, bArr) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                fr1[] fr1VarArr3 = this.b;
                int length4 = iF % fr1VarArr3.length;
                fr1 fr1Var2 = fr1VarArr3[length4];
                while (true) {
                    i20 i20Var = (i20) fr1Var2;
                    if (i20Var == null) {
                        fr1[] fr1VarArr4 = this.b;
                        fr1VarArr4[length4] = new i20(iF, fr1VarArr4[length4], num, bArr, length3, this.z);
                        this.f++;
                    } else if (i20Var.a == iF && i20Var.a(0, length3, bArr)) {
                        i20Var.e = num;
                    } else {
                        fr1Var2 = i20Var.b;
                    }
                    break;
                }
                break;
        }
    }

    public void i(int i, sl4 sl4Var) {
        a();
        int i2 = i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        fr1[] fr1VarArr = this.b;
        int length = i2 % fr1VarArr.length;
        fr1VarArr[length] = new y02(i2, fr1VarArr[length], sl4Var, this.z);
        this.f++;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new gr1(this);
    }

    public void j(byte[] bArr, Object obj) {
        int length = bArr.length;
        a();
        int iF = Integer.MAX_VALUE & f(0, length, bArr);
        fr1[] fr1VarArr = this.b;
        int length2 = iF % fr1VarArr.length;
        fr1VarArr[length2] = new i20(iF, fr1VarArr[length2], obj, bArr, length, this.z);
        this.f++;
    }

    public void k(int[] iArr, sl4 sl4Var) {
        a();
        int iE = e(iArr) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        fr1[] fr1VarArr = this.b;
        int length = iE % fr1VarArr.length;
        fr1VarArr[length] = new w02(iE, fr1VarArr[length], sl4Var, iArr, this.z);
        this.f++;
    }

    public du(int i) {
        this.A = i;
        this.b = new fr1[Y];
        g();
    }
}
