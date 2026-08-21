package io.netty.handler.codec.dns;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface DnsRecord {
    public static final int CLASS_ANY = 255;
    public static final int CLASS_CHAOS = 3;
    public static final int CLASS_CSNET = 2;
    public static final int CLASS_HESIOD = 4;
    public static final int CLASS_IN = 1;
    public static final int CLASS_NONE = 254;

    int dnsClass();

    String name();

    long timeToLive();

    DnsRecordType type();
}
