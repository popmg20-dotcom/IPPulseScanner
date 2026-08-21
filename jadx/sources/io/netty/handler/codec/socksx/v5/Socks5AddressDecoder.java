package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface Socks5AddressDecoder {
    public static final Socks5AddressDecoder DEFAULT = new Socks5AddressDecoder() { // from class: io.netty.handler.codec.socksx.v5.Socks5AddressDecoder.1
        private static final int IPv6_LEN = 16;

        @Override // io.netty.handler.codec.socksx.v5.Socks5AddressDecoder
        public String decodeAddress(Socks5AddressType socks5AddressType, ByteBuf byteBuf) {
            if (socks5AddressType == Socks5AddressType.IPv4) {
                return NetUtil.intToIpAddress(byteBuf.readInt());
            }
            if (socks5AddressType == Socks5AddressType.DOMAIN) {
                short unsignedByte = byteBuf.readUnsignedByte();
                String string = byteBuf.toString(byteBuf.readerIndex(), unsignedByte, CharsetUtil.US_ASCII);
                byteBuf.skipBytes(unsignedByte);
                return string;
            }
            if (socks5AddressType != Socks5AddressType.IPv6) {
                throw new DecoderException("unsupported address type: " + (socks5AddressType.byteValue() & 255));
            }
            if (byteBuf.hasArray()) {
                int i = byteBuf.readerIndex();
                byteBuf.readerIndex(i + 16);
                return NetUtil.bytesToIpAddress(byteBuf.array(), byteBuf.arrayOffset() + i, 16);
            }
            byte[] bArr = new byte[16];
            byteBuf.readBytes(bArr);
            return NetUtil.bytesToIpAddress(bArr);
        }
    };

    String decodeAddress(Socks5AddressType socks5AddressType, ByteBuf byteBuf);
}
