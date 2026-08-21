package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class UDPPacket {
    private static final short UDP_HEADER_SIZE = 8;

    private UDPPacket() {
    }

    public static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2) {
        byteBuf.writeShort(i);
        byteBuf.writeShort(i2);
        byteBuf.writeShort(byteBuf2.readableBytes() + 8);
        byteBuf.writeShort(1);
        byteBuf.writeBytes(byteBuf2);
    }
}
