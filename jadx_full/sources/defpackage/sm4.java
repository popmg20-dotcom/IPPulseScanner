package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sm4 extends vm4 {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sm4(Unsafe unsafe, int i) {
        super(unsafe, 1);
        this.c = i;
    }

    @Override // defpackage.vm4
    public final boolean a(long j, Object obj) {
        switch (this.c) {
            case 0:
                if (xm4.g) {
                    break;
                } else if (((byte) ((xm4.f(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & DnsRecord.CLASS_ANY)) != 0) {
                }
                break;
            default:
                if (xm4.g) {
                    break;
                } else if (((byte) ((xm4.f(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & DnsRecord.CLASS_ANY)) != 0) {
                }
                break;
        }
        return xm4.e(j, obj);
    }

    @Override // defpackage.vm4
    public final double c(long j, Object obj) {
        switch (this.c) {
        }
        return Double.longBitsToDouble(this.b.getLong(obj, j));
    }

    @Override // defpackage.vm4
    public final float d(long j, Object obj) {
        switch (this.c) {
        }
        return Float.intBitsToFloat(this.b.getInt(obj, j));
    }

    @Override // defpackage.vm4
    public final void e(Object obj, long j, boolean z) {
        switch (this.c) {
            case 0:
                if (!xm4.g) {
                    xm4.l(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    xm4.k(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!xm4.g) {
                    xm4.l(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    xm4.k(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // defpackage.vm4
    public final void f(Object obj, long j, byte b) {
        switch (this.c) {
            case 0:
                if (!xm4.g) {
                    xm4.l(obj, j, b);
                } else {
                    xm4.k(obj, j, b);
                }
                break;
            default:
                if (!xm4.g) {
                    xm4.l(obj, j, b);
                } else {
                    xm4.k(obj, j, b);
                }
                break;
        }
    }

    @Override // defpackage.vm4
    public final void g(Object obj, long j, double d) {
        switch (this.c) {
            case 0:
                this.b.putLong(obj, j, Double.doubleToLongBits(d));
                break;
            default:
                this.b.putLong(obj, j, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // defpackage.vm4
    public final void h(Object obj, long j, float f) {
        switch (this.c) {
            case 0:
                this.b.putInt(obj, j, Float.floatToIntBits(f));
                break;
            default:
                this.b.putInt(obj, j, Float.floatToIntBits(f));
                break;
        }
    }

    @Override // defpackage.vm4
    public final boolean j() {
        switch (this.c) {
        }
        return false;
    }
}
