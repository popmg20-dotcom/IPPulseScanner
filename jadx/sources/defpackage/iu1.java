package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class iu1 implements Closeable {
    public static final Logger A;
    public final he3 b;
    public final hu1 f;
    public final lt1 z;

    static {
        Logger logger = Logger.getLogger(xt1.class.getName());
        logger.getClass();
        A = logger;
    }

    public iu1(he3 he3Var) {
        this.b = he3Var;
        hu1 hu1Var = new hu1(he3Var);
        this.f = hu1Var;
        this.z = new lt1(hu1Var);
    }

    public final void C(kt ktVar, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            vp1.i("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        }
        boolean z = false;
        boolean z2 = (i2 & 1) != 0;
        if ((i2 & 8) != 0) {
            byte bS = this.b.s();
            byte[] bArr = hz4.a;
            i4 = bS & 255;
        } else {
            i4 = 0;
        }
        if ((i2 & 32) != 0) {
            he3 he3Var = this.b;
            he3Var.C();
            he3Var.s();
            byte[] bArr2 = hz4.a;
            i -= 5;
        }
        List listX = x(ke0.m(i, i2, i4), i4, i2, i3);
        fu1 fu1Var = (fu1) ktVar.z;
        if (i3 != 0 && (i3 & 1) == 0) {
            z = true;
        }
        if (z) {
            za4.c(fu1Var.z0, fu1Var.z + '[' + i3 + "] onHeaders", new bu1(fu1Var, i3, listX, z2));
            return;
        }
        synchronized (fu1Var) {
            mu1 mu1VarN = fu1Var.n(i3);
            if (mu1VarN != null) {
                mu1VarN.j(jz4.h(listX), z2);
                return;
            }
            if (fu1Var.Y) {
                return;
            }
            if (i3 <= fu1Var.A) {
                return;
            }
            if (i3 % 2 == fu1Var.X % 2) {
                return;
            }
            mu1 mu1Var = new mu1(i3, fu1Var, false, z2, jz4.h(listX));
            fu1Var.A = i3;
            fu1Var.f.put(Integer.valueOf(i3), mu1Var);
            za4.c(fu1Var.Z.d(), fu1Var.z + '[' + i3 + "] onStream", new qi(4, fu1Var, mu1Var));
        }
    }

    public final void F(kt ktVar, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            vp1.i(dw2.A(i, "TYPE_PING length != 8: "));
            return;
        }
        if (i3 != 0) {
            vp1.i("TYPE_PING streamId != 0");
            return;
        }
        final int iC = this.b.C();
        final int iC2 = this.b.C();
        boolean z = (i2 & 1) != 0;
        fu1 fu1Var = (fu1) ktVar.z;
        if (!z) {
            za4 za4Var = fu1Var.y0;
            String strY = fw.y(new StringBuilder(), ((fu1) ktVar.z).z, " ping");
            final fu1 fu1Var2 = (fu1) ktVar.z;
            za4.c(za4Var, strY, new pl1() { // from class: eu1
                @Override // defpackage.pl1
                public final Object a() {
                    fu1 fu1Var3 = fu1Var2;
                    try {
                        fu1Var3.N0.F(iC, iC2, true);
                    } catch (IOException e) {
                        t51 t51Var = t51.PROTOCOL_ERROR;
                        fu1Var3.g(t51Var, t51Var, e);
                    }
                    return xl4.a;
                }
            });
            return;
        }
        synchronized (fu1Var) {
            try {
                if (iC == 1) {
                    fu1Var.C0++;
                } else if (iC == 2) {
                    fu1Var.E0++;
                } else if (iC == 3) {
                    fu1Var.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void I(kt ktVar, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            vp1.i("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
            return;
        }
        int i5 = 0;
        if ((i2 & 8) != 0) {
            byte bS = this.b.s();
            byte[] bArr = hz4.a;
            i4 = bS & 255;
        } else {
            i4 = 0;
        }
        int iC = this.b.C() & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        List listX = x(ke0.m(i - 4, i2, i4), i4, i2, i3);
        fu1 fu1Var = (fu1) ktVar.z;
        synchronized (fu1Var) {
            if (fu1Var.P0.contains(Integer.valueOf(iC))) {
                fu1Var.M(iC, t51.PROTOCOL_ERROR);
                return;
            }
            fu1Var.P0.add(Integer.valueOf(iC));
            za4.c(fu1Var.z0, fu1Var.z + '[' + iC + "] onRequest", new bu1(fu1Var, iC, listX, i5));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x012f, code lost:
    
        defpackage.vp1.i(defpackage.dw2.A(r7, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0138, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(boolean r13, defpackage.kt r14) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iu1.g(boolean, kt):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0119, code lost:
    
        if (r6 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011b, code lost:
    
        r9.j(defpackage.lr1.f, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(defpackage.kt r17, int r18, int r19, final int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iu1.n(kt, int, int, int):void");
    }

    public final void s(kt ktVar, int i, int i2) throws IOException {
        t51 t51Var;
        Object[] array;
        if (i < 8) {
            vp1.i(dw2.A(i, "TYPE_GOAWAY length < 8: "));
            return;
        }
        if (i2 != 0) {
            vp1.i("TYPE_GOAWAY streamId != 0");
            return;
        }
        int iC = this.b.C();
        int iC2 = this.b.C();
        int i3 = i - 8;
        t51.f.getClass();
        t51[] t51VarArrValues = t51.values();
        int length = t51VarArrValues.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                t51Var = null;
                break;
            }
            t51Var = t51VarArrValues[i4];
            if (t51Var.b == iC2) {
                break;
            } else {
                i4++;
            }
        }
        if (t51Var == null) {
            vp1.i(dw2.A(iC2, "TYPE_GOAWAY unexpected error code: "));
            return;
        }
        bu buVarX = bu.A;
        if (i3 > 0) {
            buVarX = this.b.x(i3);
        }
        buVarX.getClass();
        buVarX.d();
        fu1 fu1Var = (fu1) ktVar.z;
        synchronized (fu1Var) {
            array = fu1Var.f.values().toArray(new mu1[0]);
            fu1Var.Y = true;
        }
        for (mu1 mu1Var : (mu1[]) array) {
            if (mu1Var.b > iC && mu1Var.h()) {
                mu1Var.k(t51.REFUSED_STREAM);
                ((fu1) ktVar.z).x(mu1Var.b);
            }
        }
    }

    public final List x(int i, int i2, int i3, int i4) throws IOException {
        hu1 hu1Var = this.f;
        hu1Var.X = i;
        hu1Var.f = i;
        hu1Var.Y = i2;
        hu1Var.z = i3;
        hu1Var.A = i4;
        lt1 lt1Var = this.z;
        he3 he3Var = lt1Var.c;
        ArrayList arrayList = lt1Var.b;
        while (!he3Var.g()) {
            byte bS = he3Var.s();
            byte[] bArr = hz4.a;
            int i5 = bS & 255;
            if (i5 == 128) {
                vp1.i("index == 0");
                return null;
            }
            if ((bS & 128) == 128) {
                int iE = lt1Var.e(i5, 127);
                int i6 = iE - 1;
                if (i6 >= 0) {
                    hr1[] hr1VarArr = nt1.a;
                    if (i6 <= hr1VarArr.length - 1) {
                        arrayList.add(hr1VarArr[i6]);
                    }
                }
                int length = lt1Var.e + 1 + (i6 - nt1.a.length);
                if (length >= 0) {
                    hr1[] hr1VarArr2 = lt1Var.d;
                    if (length < hr1VarArr2.length) {
                        hr1 hr1Var = hr1VarArr2[length];
                        hr1Var.getClass();
                        arrayList.add(hr1Var);
                    }
                }
                vp1.i(dw2.A(iE, "Header index too large "));
                return null;
            }
            if (i5 == 64) {
                hr1[] hr1VarArr3 = nt1.a;
                bu buVarD = lt1Var.d();
                nt1.a(buVarD);
                lt1Var.c(new hr1(buVarD, lt1Var.d()));
            } else if ((bS & 64) == 64) {
                lt1Var.c(new hr1(lt1Var.b(lt1Var.e(i5, 63) - 1), lt1Var.d()));
            } else if ((bS & HttpConstants.SP) == 32) {
                int iE2 = lt1Var.e(i5, 31);
                lt1Var.a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + lt1Var.a);
                }
                int i7 = lt1Var.g;
                if (iE2 < i7) {
                    if (iE2 == 0) {
                        hr1[] hr1VarArr4 = lt1Var.d;
                        Arrays.fill(hr1VarArr4, 0, hr1VarArr4.length, (Object) null);
                        lt1Var.e = lt1Var.d.length - 1;
                        lt1Var.f = 0;
                        lt1Var.g = 0;
                    } else {
                        lt1Var.a(i7 - iE2);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                hr1[] hr1VarArr5 = nt1.a;
                bu buVarD2 = lt1Var.d();
                nt1.a(buVarD2);
                arrayList.add(new hr1(buVarD2, lt1Var.d()));
            } else {
                arrayList.add(new hr1(lt1Var.b(lt1Var.e(i5, 15) - 1), lt1Var.d()));
            }
        }
        List listY0 = d70.y0(arrayList);
        arrayList.clear();
        return listY0;
    }
}
