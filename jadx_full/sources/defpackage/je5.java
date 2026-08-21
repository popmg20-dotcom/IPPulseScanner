package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class je5 extends vm4 {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ je5(Unsafe unsafe, int i) {
        super(unsafe, 2);
        this.c = i;
    }

    @Override // defpackage.vm4
    public final void k(Object obj, long j, byte b) {
        switch (this.c) {
            case 0:
                if (!me5.g) {
                    me5.d(obj, j, b);
                } else {
                    me5.c(obj, j, b);
                }
                break;
            default:
                if (!me5.g) {
                    me5.d(obj, j, b);
                } else {
                    me5.c(obj, j, b);
                }
                break;
        }
    }

    @Override // defpackage.vm4
    public final boolean l(long j, Object obj) {
        switch (this.c) {
            case 0:
                if (!me5.g) {
                }
                break;
            default:
                if (!me5.g) {
                }
                break;
        }
        return me5.l(j, obj);
    }

    @Override // defpackage.vm4
    public final void m(Object obj, long j, boolean z) {
        switch (this.c) {
            case 0:
                if (!me5.g) {
                    me5.d(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    me5.c(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!me5.g) {
                    me5.d(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    me5.c(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // defpackage.vm4
    public final float n(long j, Object obj) {
        int i = this.c;
        Unsafe unsafe = this.b;
        switch (i) {
        }
        return Float.intBitsToFloat(unsafe.getInt(obj, j));
    }

    @Override // defpackage.vm4
    public final void o(Object obj, long j, float f) {
        int i = this.c;
        Unsafe unsafe = this.b;
        switch (i) {
            case 0:
                unsafe.putInt(obj, j, Float.floatToIntBits(f));
                break;
            default:
                unsafe.putInt(obj, j, Float.floatToIntBits(f));
                break;
        }
    }

    @Override // defpackage.vm4
    public final double p(long j, Object obj) {
        int i = this.c;
        Unsafe unsafe = this.b;
        switch (i) {
        }
        return Double.longBitsToDouble(unsafe.getLong(obj, j));
    }

    @Override // defpackage.vm4
    public final void q(Object obj, long j, double d) {
        switch (this.c) {
            case 0:
                this.b.putLong(obj, j, Double.doubleToLongBits(d));
                break;
            default:
                this.b.putLong(obj, j, Double.doubleToLongBits(d));
                break;
        }
    }
}
