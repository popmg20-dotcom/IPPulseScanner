package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum SocksCmdStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) 1),
    FORBIDDEN((byte) 2),
    NETWORK_UNREACHABLE((byte) 3),
    HOST_UNREACHABLE((byte) 4),
    REFUSED((byte) 5),
    TTL_EXPIRED((byte) 6),
    COMMAND_NOT_SUPPORTED((byte) 7),
    ADDRESS_NOT_SUPPORTED((byte) 8),
    UNASSIGNED((byte) -1);

    private final byte b;

    SocksCmdStatus(byte b) {
        this.b = b;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b) {
        return valueOf(b);
    }

    public static SocksCmdStatus valueOf(byte b) {
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.b == b) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }

    public byte byteValue() {
        return this.b;
    }
}
