package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class EthernetPacket {
    private static final int V4 = 2048;
    private static final int V6 = 34525;
    private static final byte[] DUMMY_SOURCE_MAC_ADDRESS = {0, 0, 94, 0, 83, 0};
    private static final byte[] DUMMY_DESTINATION_MAC_ADDRESS = {0, 0, 94, 0, 83, -1};

    private EthernetPacket() {
    }

    public static void writeIPv4(ByteBuf byteBuf, ByteBuf byteBuf2) {
        writePacket(byteBuf, byteBuf2, DUMMY_SOURCE_MAC_ADDRESS, DUMMY_DESTINATION_MAC_ADDRESS, V4);
    }

    public static void writeIPv6(ByteBuf byteBuf, ByteBuf byteBuf2) {
        writePacket(byteBuf, byteBuf2, DUMMY_SOURCE_MAC_ADDRESS, DUMMY_DESTINATION_MAC_ADDRESS, V6);
    }

    private static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, byte[] bArr, byte[] bArr2, int i) {
        byteBuf.writeBytes(bArr2);
        byteBuf.writeBytes(bArr);
        byteBuf.writeShort(i);
        byteBuf.writeBytes(byteBuf2);
    }
}
