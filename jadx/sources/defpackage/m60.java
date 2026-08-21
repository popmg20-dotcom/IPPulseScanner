package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.Serializable;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m60 {
    public int a;
    public int b;
    public final byte[] d;
    public int e;
    public int f;
    public int g;
    public final int h;
    public int i;
    public final int c = 100;
    public int j = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;

    public m60(byte[] bArr, int i, int i2, boolean z) {
        this.d = bArr;
        this.e = i2 + i;
        this.g = i;
        this.h = i;
    }

    public static m60 d(byte[] bArr, int i, int i2, boolean z) {
        m60 m60Var = new m60(bArr, i, i2, z);
        try {
            m60Var.f(i2);
            return m60Var;
        } catch (s12 e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final void a(int i) {
        if (this.i != i) {
            throw new s12("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void b() throws s12 {
        if (this.a + this.b >= this.c) {
            throw new s12("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final int c() {
        int i = this.j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.g - this.h);
    }

    public final void e(int i) {
        this.j = i;
        t();
    }

    public final int f(int i) {
        if (i < 0) {
            throw new s12("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = (this.g - this.h) + i;
        if (i2 < 0) {
            throw new s12("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i3 = this.j;
        if (i2 > i3) {
            throw s12.b();
        }
        this.j = i2;
        t();
        return i3;
    }

    public final boolean g() {
        return p() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.zt h() {
        /*
            r4 = this;
            int r0 = r4.o()
            byte[] r1 = r4.d
            if (r0 <= 0) goto L19
            int r2 = r4.e
            int r3 = r4.g
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            zt r1 = defpackage.zt.c(r3, r0, r1)
            int r2 = r4.g
            int r2 = r2 + r0
            r4.g = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            zt r4 = defpackage.zt.z
            return r4
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.e
            int r3 = r4.g
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.g = r0
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L45
            if (r0 != 0) goto L3d
            byte[] r4 = defpackage.i12.c
        L35:
            zt r0 = defpackage.zt.z
            zt r0 = new zt
            r0.<init>(r4)
            return r0
        L3d:
            s12 r4 = new s12
            java.lang.String r0 = "CodedInputStream encountered an embedded string or message which claimed to have negative size."
            r4.<init>(r0)
            throw r4
        L45:
            s12 r4 = defpackage.s12.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m60.h():zt");
    }

    public final void i(int i, ml2 ml2Var, o91 o91Var) {
        b();
        this.b++;
        ml2Var.M(this, o91Var);
        a((i << 3) | 4);
        this.b--;
    }

    public final nl2 j(m03 m03Var, o91 o91Var) throws s12 {
        int iO = o();
        b();
        int iF = f(iO);
        this.a++;
        nl2 nl2Var = (nl2) m03Var.a(this, o91Var);
        a(0);
        this.a--;
        if (c() != 0) {
            throw s12.b();
        }
        e(iF);
        return nl2Var;
    }

    public final void k(ml2 ml2Var, o91 o91Var) {
        int iO = o();
        b();
        int iF = f(iO);
        this.a++;
        ml2Var.M(this, o91Var);
        a(0);
        this.a--;
        if (c() != 0) {
            throw s12.b();
        }
        e(iF);
    }

    public final Serializable l(aw4 aw4Var, int i) {
        switch (aw4Var.ordinal()) {
            case 0:
                return Double.valueOf(Double.longBitsToDouble(n()));
            case 1:
                return Float.valueOf(Float.intBitsToFloat(m()));
            case 2:
                return Long.valueOf(p());
            case 3:
                return Long.valueOf(p());
            case 4:
                return Integer.valueOf(o());
            case 5:
                return Long.valueOf(n());
            case 6:
                return Integer.valueOf(m());
            case 7:
                return Boolean.valueOf(g());
            case 8:
                int iG = fw.G(i);
                if (iG != 0) {
                    if (iG == 1) {
                        return r();
                    }
                    if (iG == 2) {
                        return h();
                    }
                    xe.q("Unknown UTF8 validation: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "LAZY" : "STRICT" : "LOOSE"));
                    return null;
                }
                int iO = o();
                if (iO > 0) {
                    int i2 = this.e;
                    int i3 = this.g;
                    if (iO <= i2 - i3) {
                        String str = new String(this.d, i3, iO, i12.a);
                        this.g += iO;
                        return str;
                    }
                }
                if (iO == 0) {
                    return "";
                }
                if (iO < 0) {
                    throw new s12("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                throw s12.b();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                xe.k("readPrimitiveField() cannot handle nested groups.");
                return null;
            case 10:
                xe.k("readPrimitiveField() cannot handle embedded messages.");
                return null;
            case 11:
                return h();
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return Integer.valueOf(o());
            case 13:
                xe.k("readPrimitiveField() cannot handle enums.");
                return null;
            case 14:
                return Integer.valueOf(m());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return Long.valueOf(n());
            case 16:
                int iO2 = o();
                return Integer.valueOf((-(iO2 & 1)) ^ (iO2 >>> 1));
            case 17:
                long jP = p();
                return Long.valueOf((-(jP & 1)) ^ (jP >>> 1));
            default:
                s53.j(aw4Var, "Unknown field type: ");
                return null;
        }
    }

    public final int m() throws s12 {
        int i = this.g;
        if (this.e - i < 4) {
            throw s12.b();
        }
        this.g = i + 4;
        byte[] bArr = this.d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long n() throws s12 {
        int i = this.g;
        if (this.e - i < 8) {
            throw s12.b();
        }
        this.g = i + 8;
        byte[] bArr = this.d;
        return ((((long) bArr[i + 1]) & 255) << 8) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final int o() {
        int i;
        int i2 = this.g;
        int i3 = this.e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.d;
            byte b = bArr[i2];
            if (b >= 0) {
                this.g = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.g = i5;
                return i;
            }
        }
        return (int) q();
    }

    public final long p() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.g;
        int i2 = this.e;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.d;
            byte b = bArr[i];
            if (b >= 0) {
                this.g = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            j4 = (-2080896) ^ i9;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                i8 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i8]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i10 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i10;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j4 = j2 ^ j7;
                            }
                            j = j3 ^ j6;
                        }
                        i4 = i8;
                        j = j4;
                    }
                }
                this.g = i4;
                return j;
            }
        }
        return q();
    }

    public final long q() throws s12 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.g;
            if (i2 == this.e) {
                throw s12.b();
            }
            this.g = i2 + 1;
            byte b = this.d[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new s12("CodedInputStream encountered a malformed varint.");
    }

    public final String r() throws s12 {
        int iO = o();
        if (iO > 0) {
            int i = this.e;
            int i2 = this.g;
            if (iO <= i - i2) {
                String strH = zn4.a.h(i2, iO, this.d);
                this.g += iO;
                return strH;
            }
        }
        if (iO == 0) {
            return "";
        }
        if (iO <= 0) {
            throw new s12("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw s12.b();
    }

    public final int s() {
        if (this.g == this.e) {
            this.i = 0;
            return 0;
        }
        int iO = o();
        this.i = iO;
        if ((iO >>> 3) != 0) {
            return iO;
        }
        throw new s12("Protocol message contained an invalid tag (zero).");
    }

    public final void t() {
        int i = this.e + this.f;
        this.e = i;
        int i2 = i - this.h;
        int i3 = this.j;
        if (i2 <= i3) {
            this.f = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f = i4;
        this.e = i - i4;
    }

    public final boolean u(int i) throws s12 {
        boolean zU;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            int i4 = this.e - this.g;
            byte[] bArr = this.d;
            if (i4 >= 10) {
                while (i3 < 10) {
                    int i5 = this.g;
                    this.g = i5 + 1;
                    if (bArr[i5] < 0) {
                        i3++;
                    }
                }
                throw new s12("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                int i6 = this.g;
                if (i6 == this.e) {
                    throw s12.b();
                }
                this.g = i6 + 1;
                if (bArr[i6] < 0) {
                    i3++;
                }
            }
            throw new s12("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            v(8);
            return true;
        }
        if (i2 == 2) {
            v(o());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                if (this.b == 0) {
                    a(0);
                }
                return false;
            }
            if (i2 != 5) {
                throw new q12("Protocol message tag had invalid wire type.");
            }
            v(4);
            return true;
        }
        do {
            int iS = s();
            if (iS == 0) {
                break;
            }
            b();
            this.b++;
            zU = u(iS);
            this.b--;
        } while (zU);
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final void v(int i) throws s12 {
        if (i >= 0) {
            int i2 = this.e;
            int i3 = this.g;
            if (i <= i2 - i3) {
                this.g = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw s12.b();
        }
        throw new s12("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
