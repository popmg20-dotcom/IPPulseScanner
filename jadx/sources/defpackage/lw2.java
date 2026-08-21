package defpackage;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lw2 {
    public static final short[] f = {5, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 12, 4, 7, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 5, 5, 5, 5, 6, 6, 6, 6, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 1};
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0277  */
    /* JADX WARN: Type inference failed for: r17v1, types: [android.graphics.Bitmap, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public lw2(defpackage.us2 r28) {
        /*
            Method dump skipped, instruction units count: 1400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lw2.<init>(us2):void");
    }

    public static void f(StringBuilder sb, int i, int i2, byte[] bArr, int i3) {
        int i4 = i2 * i;
        sb.append(":T:");
        sb.append(i);
        sb.append(':');
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return;
            }
            sb.append(new String(bArr, i3, 1));
            i4 = i5;
            i3++;
        }
    }

    public static int h(int i, k0 k0Var) {
        if (i >= 128) {
            return 4;
        }
        if (i != 0 || k0Var.b <= 1) {
            return f[i];
        }
        return 20;
    }

    public static void j(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public void a(byte b, k0 k0Var) {
        int i = b & 255;
        byte[] bArr = (byte[]) this.e;
        if (bArr[i] == 0) {
            bArr[i] = 1;
            this.b = h(i, k0Var) + this.b;
        }
    }

    public void b(eg0 eg0Var) {
        if (eg0Var != null) {
            pt0 pt0Var = (pt0) eg0Var;
            tj tjVar = (tj) this.c;
            tj[] tjVarArr = (tj[]) pt0Var.z;
            for (tj tjVar2 : tjVarArr) {
                if (tjVar2 != null) {
                    tjVar2.c();
                }
            }
            pt0Var.Z(tjVarArr, tjVar);
            xo xoVar = (xo) pt0Var.f;
            boolean z = pt0Var.A;
            xk3 xk3Var = z ? xoVar.b : xoVar.d;
            xk3 xk3Var2 = z ? xoVar.c : xoVar.e;
            int iL = pt0Var.L((int) xk3Var.b);
            int iL2 = pt0Var.L((int) xk3Var2.b);
            int i = -1;
            int iMax = 1;
            int i2 = 0;
            while (iL < iL2) {
                tj tjVar3 = tjVarArr[iL];
                if (tjVar3 != null) {
                    int i3 = tjVar3.f;
                    int i4 = i3 - i;
                    if (i4 == 0) {
                        i2++;
                    } else {
                        if (i4 == 1) {
                            iMax = Math.max(iMax, i2);
                            i = tjVar3.f;
                        } else if (i4 < 0 || i3 >= tjVar.f || i4 > iL) {
                            tjVarArr[iL] = null;
                        } else {
                            if (iMax > 2) {
                                i4 *= iMax - 2;
                            }
                            boolean z2 = i4 >= iL;
                            for (int i5 = 1; i5 <= i4 && !z2; i5++) {
                                z2 = tjVarArr[iL - i5] != null;
                            }
                            if (z2) {
                                tjVarArr[iL] = null;
                            } else {
                                i = tjVar3.f;
                            }
                        }
                        i2 = 1;
                    }
                }
                iL++;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c(int r17, java.lang.StringBuilder r18) {
        /*
            Method dump skipped, instruction units count: 928
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lw2.c(int, java.lang.StringBuilder):int");
    }

    public void d(lw2 lw2Var) {
        hm2 hm2Var = (hm2) this.c;
        hm2 hm2Var2 = (hm2) lw2Var.c;
        hm2Var.b = hm2Var2.b;
        hm2Var.c = hm2Var2.c;
        hm2 hm2Var3 = (hm2) this.d;
        hm2 hm2Var4 = (hm2) lw2Var.d;
        hm2Var3.b = hm2Var4.b;
        hm2Var3.c = hm2Var4.c;
        this.b = lw2Var.b;
        byte[] bArr = (byte[]) lw2Var.e;
        System.arraycopy(bArr, 0, (byte[]) this.e, 0, bArr.length);
    }

    public void e(StringBuilder sb, int i, int i2, int i3) {
        int i4 = i2 * i;
        sb.append(':');
        sb.append(i);
        sb.append(':');
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return;
            }
            sb.append(new String(new byte[]{(byte) ((int[]) this.c)[i3]}));
            i4 = i5;
            i3++;
        }
    }

    public void g(StringBuilder sb, int i, int i2) {
        sb.append(':');
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append(new String(new byte[]{(byte) ((int[]) this.c)[i2]}));
            i = i3;
            i2++;
        }
    }

    public synchronized void i(Bitmap bitmap, BlurMaskFilter blurMaskFilter, Canvas canvas) {
        ((Paint) this.c).setMaskFilter(blurMaskFilter);
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha((Paint) this.c, new int[2]);
        ((Paint) this.d).setAlpha(30);
        canvas.drawBitmap(bitmapExtractAlpha, r0[0], r0[1], (Paint) this.d);
        ((Paint) this.d).setAlpha(61);
        canvas.drawBitmap(bitmapExtractAlpha, r0[0], (this.b * 0.020833334f) + r0[1], (Paint) this.d);
        ((Paint) this.d).setAlpha(DnsRecord.CLASS_ANY);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) this.d);
    }

    public String toString() {
        switch (this.a) {
            case 3:
                int i = this.b;
                eg0[] eg0VarArr = (eg0[]) this.d;
                eg0 eg0Var = eg0VarArr[0];
                if (eg0Var == null) {
                    eg0Var = eg0VarArr[i + 1];
                }
                Formatter formatter = new Formatter();
                for (int i2 = 0; i2 < ((tj[]) eg0Var.z).length; i2++) {
                    try {
                        formatter.format("CW %3d:", Integer.valueOf(i2));
                        for (int i3 = 0; i3 < i + 2; i3++) {
                            eg0 eg0Var2 = eg0VarArr[i3];
                            if (eg0Var2 == null) {
                                formatter.format("    |   ", new Object[0]);
                            } else {
                                tj tjVar = ((tj[]) eg0Var2.z)[i2];
                                if (tjVar == null) {
                                    formatter.format("    |   ", new Object[0]);
                                } else {
                                    formatter.format(" %3d|%3d", Integer.valueOf(tjVar.f), Integer.valueOf(tjVar.e));
                                }
                            }
                        }
                        formatter.format("%n", new Object[0]);
                    } catch (Throwable th) {
                        try {
                            formatter.close();
                            break;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                String string = formatter.toString();
                formatter.close();
                return string;
            default:
                return super.toString();
        }
    }

    public lw2(th3 th3Var) {
        this.a = 1;
        this.c = th3Var.a;
        this.b = th3Var.b;
        this.d = th3Var.G;
        this.e = th3Var.p;
    }

    public lw2(tj tjVar, xo xoVar) {
        this.a = 3;
        this.c = tjVar;
        int i = tjVar.b;
        this.b = i;
        this.e = xoVar;
        this.d = new eg0[i + 2];
    }

    public lw2(int i) {
        this.a = 5;
        this.b = i;
        this.c = new Paint(3);
        this.d = new Paint(3);
        this.e = new BlurMaskFilter(i * 0.010416667f, BlurMaskFilter.Blur.NORMAL);
    }

    public lw2(byte b, int i) {
        this.a = i;
        switch (i) {
            case 7:
                break;
            default:
                this.c = new hm2(0);
                this.d = new hm2(5);
                this.e = new byte[ja0.b];
                break;
        }
    }

    public lw2(int i, jp jpVar, cf0 cf0Var, zf1 zf1Var) {
        this.a = 6;
        this.c = zf1Var;
        this.b = i;
        this.d = jpVar;
        this.e = cf0Var;
    }

    public lw2(List list) {
        this.a = 2;
        this.b = ((n70) list.get(list.size() - 1)).c + 1;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Short.valueOf(((n70) it.next()).c));
        }
        this.d = new int[this.b];
        short s = 0;
        while (true) {
            int i = this.b;
            if (s < i) {
                if (hashSet.contains(Short.valueOf(s))) {
                    ((int[]) this.d)[s] = 1073741824;
                }
                s = (short) (s + 1);
            } else {
                this.c = new q70((short) 514, (short) 16, (i * 4) + 16);
                this.e = new j40(list, hashSet, i);
                return;
            }
        }
    }
}
