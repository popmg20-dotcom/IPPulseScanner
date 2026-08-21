package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qe1 extends j24 {
    public final Throwable b;

    public qe1(Throwable th) {
        super(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
        this.b = th;
    }
}
