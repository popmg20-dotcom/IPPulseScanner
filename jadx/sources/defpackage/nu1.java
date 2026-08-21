package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class nu1 implements Closeable {
    public static final Logger Y = Logger.getLogger(xt1.class.getName());
    public boolean A;
    public final mt1 X;
    public final ge3 b;
    public final hp f;
    public int z;

    public nu1(ge3 ge3Var) {
        this.b = ge3Var;
        hp hpVar = new hp();
        this.f = hpVar;
        this.z = 16384;
        this.X = new mt1(hpVar);
    }

    public final void C(int i, ArrayList arrayList, boolean z) {
        synchronized (this) {
            if (this.A) {
                throw new IOException("closed");
            }
            this.X.d(arrayList);
            long j = this.f.f;
            long jMin = Math.min(this.z, j);
            int i2 = j == jMin ? 4 : 0;
            if (z) {
                i2 |= 1;
            }
            s(i, (int) jMin, 1, i2);
            this.b.a0(this.f, jMin);
            if (j > jMin) {
                long j2 = j - jMin;
                while (j2 > 0) {
                    long jMin2 = Math.min(this.z, j2);
                    j2 -= jMin2;
                    s(i, (int) jMin2, 9, j2 == 0 ? 4 : 0);
                    this.b.a0(this.f, jMin2);
                }
            }
        }
    }

    public final void F(int i, int i2, boolean z) {
        synchronized (this) {
            if (this.A) {
                throw new IOException("closed");
            }
            s(0, 8, 6, z ? 1 : 0);
            this.b.s(i);
            this.b.s(i2);
            this.b.flush();
        }
    }

    public final void I(int i, t51 t51Var) {
        synchronized (this) {
            if (this.A) {
                throw new IOException("closed");
            }
            if (t51Var.b == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            s(i, 4, 3, 0);
            this.b.s(t51Var.b);
            this.b.flush();
        }
    }

    public final void M(gu3 gu3Var) {
        gu3Var.getClass();
        synchronized (this) {
            try {
                if (this.A) {
                    throw new IOException("closed");
                }
                s(0, Integer.bitCount(gu3Var.a) * 6, 4, 0);
                for (int i = 0; i < 10; i++) {
                    boolean z = true;
                    if (((1 << i) & gu3Var.a) == 0) {
                        z = false;
                    }
                    if (z) {
                        ge3 ge3Var = this.b;
                        if (ge3Var.z) {
                            throw new IllegalStateException("closed");
                        }
                        ge3Var.f.N0(i);
                        ge3Var.g();
                        this.b.s(gu3Var.b[i]);
                    }
                }
                this.b.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void N(int i, long j) {
        synchronized (this) {
            try {
                if (this.A) {
                    throw new IOException("closed");
                }
                if (j == 0 || j > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
                }
                Logger logger = Y;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(xt1.c(i, 4, j, false));
                }
                s(i, 4, 8, 0);
                this.b.s((int) j);
                this.b.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            this.A = true;
            this.b.close();
        }
    }

    public final void flush() {
        synchronized (this) {
            if (this.A) {
                throw new IOException("closed");
            }
            this.b.flush();
        }
    }

    public final void g(gu3 gu3Var) {
        gu3Var.getClass();
        synchronized (this) {
            try {
                if (this.A) {
                    throw new IOException("closed");
                }
                int i = this.z;
                int i2 = gu3Var.a;
                if ((i2 & 32) != 0) {
                    i = gu3Var.b[5];
                }
                this.z = i;
                if (((i2 & 2) != 0 ? gu3Var.b[1] : -1) != -1) {
                    mt1 mt1Var = this.X;
                    int iMin = Math.min((i2 & 2) != 0 ? gu3Var.b[1] : -1, 16384);
                    int i3 = mt1Var.d;
                    if (i3 != iMin) {
                        if (iMin < i3) {
                            mt1Var.b = Math.min(mt1Var.b, iMin);
                        }
                        mt1Var.c = true;
                        mt1Var.d = iMin;
                        int i4 = mt1Var.h;
                        if (iMin < i4) {
                            if (iMin == 0) {
                                hr1[] hr1VarArr = mt1Var.e;
                                Arrays.fill(hr1VarArr, 0, hr1VarArr.length, (Object) null);
                                mt1Var.f = mt1Var.e.length - 1;
                                mt1Var.g = 0;
                                mt1Var.h = 0;
                            } else {
                                mt1Var.a(i4 - iMin);
                            }
                        }
                    }
                }
                s(0, 0, 4, 1);
                this.b.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(boolean z, int i, hp hpVar, int i2) {
        synchronized (this) {
            if (this.A) {
                throw new IOException("closed");
            }
            s(i, i2, 0, z ? 1 : 0);
            if (i2 > 0) {
                ge3 ge3Var = this.b;
                hpVar.getClass();
                ge3Var.a0(hpVar, i2);
            }
        }
    }

    public final void s(int i, int i2, int i3, int i4) {
        if (i3 != 8) {
            Level level = Level.FINE;
            Logger logger = Y;
            if (logger.isLoggable(level)) {
                logger.fine(xt1.b(i, i2, i3, false, i4));
            }
        }
        if (i2 > this.z) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.z + ": " + i2).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            e04.f(dw2.A(i, "reserved bit set: "));
            return;
        }
        byte[] bArr = hz4.a;
        int i5 = (i2 >>> 16) & DnsRecord.CLASS_ANY;
        ge3 ge3Var = this.b;
        ge3Var.writeByte(i5);
        ge3Var.writeByte((i2 >>> 8) & DnsRecord.CLASS_ANY);
        ge3Var.writeByte(i2 & DnsRecord.CLASS_ANY);
        ge3Var.writeByte(i3 & DnsRecord.CLASS_ANY);
        ge3Var.writeByte(i4 & DnsRecord.CLASS_ANY);
        ge3Var.s(i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
    }

    public final void x(int i, t51 t51Var, byte[] bArr) {
        synchronized (this) {
            if (this.A) {
                throw new IOException("closed");
            }
            if (t51Var.b == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            s(0, bArr.length + 8, 7, 0);
            this.b.s(i);
            this.b.s(t51Var.b);
            if (bArr.length != 0) {
                ge3 ge3Var = this.b;
                if (ge3Var.z) {
                    throw new IllegalStateException("closed");
                }
                ge3Var.f.H0(bArr.length, bArr);
                ge3Var.g();
            }
            this.b.flush();
        }
    }
}
