package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class st1 extends qt1 {
    public long X;
    public boolean Y;
    public final /* synthetic */ wt1 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st1(wt1 wt1Var, ev1 ev1Var) {
        super(wt1Var, ev1Var);
        ev1Var.getClass();
        this.Z = wt1Var;
        this.X = -1L;
        this.Y = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zG;
        if (this.z) {
            return;
        }
        if (this.Y) {
            TimeZone timeZone = jz4.a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zG = jz4.g(this, 100);
            } catch (IOException unused) {
                zG = false;
            }
            if (!zG) {
                this.Z.b.d();
                g(wt1.f);
            }
        }
        this.z = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
    
        if (r18.Y == false) goto L48;
     */
    @Override // defpackage.qt1, defpackage.lz3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long t0(hp hpVar, long j) throws ProtocolException {
        long j2;
        byte bC;
        wt1 wt1Var = this.Z;
        ed4 ed4Var = wt1Var.c;
        hpVar.getClass();
        long j3 = 0;
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.z) {
            xe.q("closed");
            return 0L;
        }
        if (this.Y) {
            long j4 = this.X;
            if (j4 == 0 || j4 == -1) {
                if (j4 != -1) {
                    ((he3) ed4Var.z).U(Long.MAX_VALUE);
                }
                try {
                    he3 he3Var = (he3) ed4Var.z;
                    hp hpVar2 = he3Var.f;
                    he3Var.X(1L);
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        j2 = j3;
                        if (!he3Var.request(i2)) {
                            break;
                        }
                        bC = hpVar2.C(i);
                        if ((bC < 48 || bC > 57) && ((bC < 97 || bC > 102) && (bC < 65 || bC > 70))) {
                            break;
                        }
                        i = i2;
                        j3 = j2;
                    }
                    if (i == 0) {
                        yr2.g(16);
                        String string = Integer.toString(bC, 16);
                        string.getClass();
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
                    }
                    this.X = hpVar2.i0();
                    String string2 = p44.U0(((he3) ed4Var.z).U(Long.MAX_VALUE)).toString();
                    if (this.X < j2 || (string2.length() > 0 && !w44.j0(string2, ";", false))) {
                        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.X + string2 + StringUtil.DOUBLE_QUOTE);
                    }
                    if (this.X == j2) {
                        this.Y = false;
                        g(wt1Var.e.g());
                    }
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long jT0 = super.t0(hpVar, Math.min(j, this.X));
            if (jT0 != -1) {
                this.X -= jT0;
                return jT0;
            }
            wt1Var.b.d();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            g(wt1.f);
            throw protocolException;
        }
        return -1L;
    }
}
