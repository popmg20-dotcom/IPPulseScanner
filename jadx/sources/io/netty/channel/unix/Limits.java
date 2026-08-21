package io.netty.channel.unix;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Limits {
    public static final int IOV_MAX = LimitsStaticallyReferencedJniMethods.iovMax();
    public static final int UIO_MAX_IOV = LimitsStaticallyReferencedJniMethods.uioMaxIov();
    public static final long SSIZE_MAX = LimitsStaticallyReferencedJniMethods.ssizeMax();
    public static final int SIZEOF_JLONG = LimitsStaticallyReferencedJniMethods.sizeOfjlong();

    private Limits() {
    }
}
