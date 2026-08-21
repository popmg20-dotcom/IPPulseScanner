package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rm4 extends vm4 {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rm4(Unsafe unsafe, int i) {
        super(unsafe, 0);
        this.c = i;
    }

    @Override // defpackage.vm4
    public final byte b(long j, Object obj) {
        int i;
        int i2;
        switch (this.c) {
            case 0:
                if (wm4.f) {
                    i = wm4.b.b.getInt(obj, (-4) & j);
                    j = ~j;
                } else {
                    i = wm4.b.b.getInt(obj, (-4) & j);
                }
                return (byte) ((i >>> ((int) ((j & 3) << 3))) & DnsRecord.CLASS_ANY);
            default:
                if (wm4.f) {
                    i2 = wm4.b.b.getInt(obj, (-4) & j);
                    j = ~j;
                } else {
                    i2 = wm4.b.b.getInt(obj, (-4) & j);
                }
                return (byte) ((i2 >>> ((int) ((j & 3) << 3))) & DnsRecord.CLASS_ANY);
        }
    }

    @Override // defpackage.vm4
    public final void f(Object obj, long j, byte b) {
        switch (this.c) {
            case 0:
                if (!wm4.f) {
                    wm4.i(obj, j, b);
                } else {
                    wm4.h(obj, j, b);
                }
                break;
            default:
                if (!wm4.f) {
                    wm4.i(obj, j, b);
                } else {
                    wm4.h(obj, j, b);
                }
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
