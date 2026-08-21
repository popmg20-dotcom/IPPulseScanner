package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class iv3 {
    public static final br1 a = new br1("NO_VALUE", 3);

    public static final hv3 a(int i, int i2, jp jpVar) {
        if (i < 0) {
            e04.f(dw2.A(i, "replay cannot be negative, but was "));
            return null;
        }
        if (i2 < 0) {
            e04.f(dw2.A(i2, "extraBufferCapacity cannot be negative, but was "));
            return null;
        }
        if (i <= 0 && i2 <= 0 && jpVar != jp.b) {
            st4.o(jpVar, "replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ");
            return null;
        }
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        return new hv3(i, i3, jpVar);
    }

    public static final zf1 c(ev3 ev3Var, cf0 cf0Var, int i, jp jpVar) {
        return ((i == 0 || i == -3) && jpVar == jp.b) ? ev3Var : new d30(i, jpVar, cf0Var, ev3Var);
    }

    public static final void d(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }
}
