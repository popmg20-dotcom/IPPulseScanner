package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpConstants;
import io.sentry.android.core.cache.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
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
    */
    public final boolean g(boolean z, kt ktVar) throws Exception {
        int iL;
        t51 t51Var;
        try {
            this.b.X(9L);
            iL = hz4.l(this.b);
        } catch (EOFException unused) {
        }
        if (iL > 16384) {
            vp1.i(dw2.A(iL, "FRAME_SIZE_ERROR: "));
            return false;
        }
        int iS = this.b.s() & 255;
        byte bS = this.b.s();
        int i = bS & 255;
        int iC = this.b.C();
        int i2 = Integer.MAX_VALUE & iC;
        int i3 = 1;
        if (iS != 8) {
            Logger logger = A;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(xt1.b(i2, iL, iS, true, i));
            }
        }
        if (z && iS != 4) {
            a.f(xt1.a(iS), "Expected a SETTINGS frame but was ");
            return false;
        }
        int i4 = 5;
        switch (iS) {
            case 0:
                n(ktVar, iL, i, i2);
                return true;
            case 1:
                C(ktVar, iL, i, i2);
                return true;
            case 2:
                if (iL != 5) {
                    vp1.i(ha0.k("TYPE_PRIORITY length: ", iL, " != 5"));
                    return false;
                }
                if (i2 == 0) {
                    vp1.i("TYPE_PRIORITY streamId == 0");
                    return false;
                }
                he3 he3Var = this.b;
                he3Var.C();
                he3Var.s();
                return true;
            case 3:
                if (iL != 4) {
                    vp1.i(ha0.k("TYPE_RST_STREAM length: ", iL, " != 4"));
                    return false;
                }
                if (i2 == 0) {
                    vp1.i("TYPE_RST_STREAM streamId == 0");
                    return false;
                }
                int iC2 = this.b.C();
                t51.f.getClass();
                t51[] t51VarArrValues = t51.values();
                int length = t51VarArrValues.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        t51Var = t51VarArrValues[i5];
                        if (t51Var.b != iC2) {
                            i5++;
                        }
                    } else {
                        t51Var = null;
                    }
                }
                if (t51Var == null) {
                    vp1.i(dw2.A(iC2, "TYPE_RST_STREAM unexpected error code: "));
                    return false;
                }
                fu1 fu1Var = (fu1) ktVar.z;
                if (i2 == 0 || (iC & 1) != 0) {
                    mu1 mu1VarX = fu1Var.x(i2);
                    if (mu1VarX != null) {
                        mu1VarX.k(t51Var);
                    }
                    return true;
                }
                za4.c(fu1Var.z0, fu1Var.z + '[' + i2 + "] onReset", new bu1(fu1Var, i2, t51Var, i3));
                return true;
            case 4:
                he3 he3Var2 = this.b;
                if (i2 != 0) {
                    vp1.i("TYPE_SETTINGS streamId != 0");
                    return false;
                }
                if ((bS & 1) != 0) {
                    if (iL != 0) {
                        vp1.i("FRAME_SIZE_ERROR ack frame should be empty!");
                        return false;
                    }
                    return true;
                }
                if (iL % 6 != 0) {
                    vp1.i(dw2.A(iL, "TYPE_SETTINGS length % 6 != 0: "));
                    return false;
                }
                gu3 gu3Var = new gu3();
                z02 z02VarZ = gb4.Z(6, gb4.d0(0, iL));
                int i6 = z02VarZ.b;
                int i7 = z02VarZ.f;
                int i8 = z02VarZ.z;
                if ((i8 > 0 && i6 <= i7) || (i8 < 0 && i7 <= i6)) {
                    while (true) {
                        short sM = he3Var2.M();
                        byte[] bArr = hz4.a;
                        int i9 = sM & 65535;
                        int iC3 = he3Var2.C();
                        if (i9 != 2) {
                            if (i9 != 4) {
                                if (i9 == 5 && (iC3 < 16384 || iC3 > 16777215)) {
                                }
                            } else if (iC3 < 0) {
                                vp1.i("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                return false;
                            }
                        } else if (iC3 != 0 && iC3 != 1) {
                            vp1.i("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                            return false;
                        }
                        gu3Var.b(i9, iC3);
                        if (i6 != i7) {
                            i6 += i8;
                        }
                        break;
                    }
                }
                fu1 fu1Var2 = (fu1) ktVar.z;
                za4.c(fu1Var2.y0, fw.y(new StringBuilder(), fu1Var2.z, " applyAndAckSettings"), new qi(i4, ktVar, gu3Var));
                return true;
            case 5:
                I(ktVar, iL, i, i2);
                return true;
            case 6:
                F(ktVar, iL, i, i2);
                return true;
            case 7:
                s(ktVar, iL, i2);
                return true;
            case 8:
                try {
                    if (iL != 4) {
                        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + iL);
                    }
                    long jC = ((long) this.b.C()) & 2147483647L;
                    if (jC == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    Logger logger2 = A;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(xt1.c(i2, iL, jC, true));
                    }
                    fu1 fu1Var3 = (fu1) ktVar.z;
                    if (i2 == 0) {
                        synchronized (fu1Var3) {
                            fu1Var3.L0 += jC;
                            fu1Var3.notifyAll();
                        }
                        return true;
                    }
                    mu1 mu1VarN = fu1Var3.n(i2);
                    if (mu1VarN != null) {
                        synchronized (mu1VarN) {
                            mu1VarN.X += jC;
                            if (jC > 0) {
                                mu1VarN.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    return true;
                } catch (Exception e) {
                    A.fine(xt1.b(i2, iL, 8, true, i));
                    throw e;
                }
            default:
                this.b.Z(iL);
                return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0119, code lost:
    
        if (r6 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011b, code lost:
    
        r9.j(defpackage.lr1.f, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(kt ktVar, int i, int i2, final int i3) throws IOException {
        boolean z;
        int i4;
        boolean z2;
        boolean z3;
        if (i3 == 0) {
            vp1.i("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
            return;
        }
        final boolean z4 = true;
        if ((i2 & 1) != 0) {
            z = true;
        } else {
            z = true;
            z4 = false;
        }
        if ((i2 & 32) != 0) {
            vp1.i("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            return;
        }
        if ((i2 & 8) != 0) {
            byte bS = this.b.s();
            byte[] bArr = hz4.a;
            i4 = bS & 255;
        } else {
            i4 = 0;
        }
        final int iM = ke0.m(i, i2, i4);
        he3 he3Var = this.b;
        final fu1 fu1Var = (fu1) ktVar.z;
        if (!((i3 == 0 || (i3 & 1) != 0) ? false : z)) {
            mu1 mu1VarN = fu1Var.n(i3);
            if (mu1VarN != null) {
                TimeZone timeZone = jz4.a;
                ku1 ku1Var = mu1VarN.y0;
                long j = iM;
                ku1Var.getClass();
                long j2 = j;
                while (true) {
                    mu1 mu1Var = ku1Var.Y;
                    if (j2 <= 0) {
                        TimeZone timeZone2 = jz4.a;
                        mu1Var.f.F(j);
                        ku1Var.Y.f.G0.getClass();
                        break;
                    }
                    synchronized (mu1Var) {
                        z2 = ku1Var.f;
                        z3 = ku1Var.A.f + j2 > ku1Var.b;
                    }
                    if (z3) {
                        he3Var.Z(j2);
                        ku1Var.Y.f(t51.FLOW_CONTROL_ERROR);
                        break;
                    }
                    if (z2) {
                        he3Var.Z(j2);
                        break;
                    }
                    long jT0 = he3Var.t0(ku1Var.z, j2);
                    if (jT0 == -1) {
                        throw new EOFException();
                    }
                    j2 -= jT0;
                    mu1 mu1Var2 = ku1Var.Y;
                    synchronized (mu1Var2) {
                        try {
                            if (ku1Var.X) {
                                hp hpVar = ku1Var.z;
                                hpVar.z0(hpVar.f);
                            } else {
                                hp hpVar2 = ku1Var.A;
                                boolean z5 = hpVar2.f == 0;
                                hpVar2.A(ku1Var.z);
                                if (z5) {
                                    mu1Var2.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } else {
                ((fu1) ktVar.z).M(i3, t51.PROTOCOL_ERROR);
                long j3 = iM;
                ((fu1) ktVar.z).F(j3);
                he3Var.Z(j3);
            }
        } else {
            final hp hpVar3 = new hp();
            long j4 = iM;
            he3Var.X(j4);
            he3Var.t0(hpVar3, j4);
            za4.c(fu1Var.z0, fu1Var.z + '[' + i3 + "] onData", new pl1(i3, hpVar3, iM, z4) { // from class: au1
                public final /* synthetic */ int A;
                public final /* synthetic */ int f;
                public final /* synthetic */ hp z;

                @Override // defpackage.pl1
                public final Object a() {
                    fu1 fu1Var2 = this.b;
                    int i5 = this.f;
                    hp hpVar4 = this.z;
                    int i6 = this.A;
                    try {
                        fu1Var2.B0.getClass();
                        hpVar4.z0(i6);
                        fu1Var2.N0.I(i5, t51.CANCEL);
                        synchronized (fu1Var2) {
                            fu1Var2.P0.remove(Integer.valueOf(i5));
                        }
                    } catch (IOException unused) {
                    }
                    return xl4.a;
                }
            });
        }
        this.b.Z(i4);
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
