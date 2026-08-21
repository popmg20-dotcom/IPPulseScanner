package io.netty.handler.codec.socksx;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);

    private final byte b;

    SocksVersion(byte b) {
        this.b = b;
    }

    public static SocksVersion valueOf(byte b) {
        SocksVersion socksVersion = SOCKS4a;
        if (b == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        return b == socksVersion2.byteValue() ? socksVersion2 : UNKNOWN;
    }

    public byte byteValue() {
        return this.b;
    }
}
