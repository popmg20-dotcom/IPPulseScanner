package io.netty.util.internal.shaded.org.jctools.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int CPUs;
    public static final int RECOMENDED_OFFER_BATCH;
    public static final int RECOMENDED_POLL_BATCH;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPUs = iAvailableProcessors;
        RECOMENDED_OFFER_BATCH = iAvailableProcessors * 4;
        RECOMENDED_POLL_BATCH = iAvailableProcessors * 4;
    }
}
