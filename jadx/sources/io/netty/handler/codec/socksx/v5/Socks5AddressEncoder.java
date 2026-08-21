package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.EncoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface Socks5AddressEncoder {
    public static final Socks5AddressEncoder DEFAULT = new Socks5AddressEncoder() { // from class: io.netty.handler.codec.socksx.v5.Socks5AddressEncoder.1
        @Override // io.netty.handler.codec.socksx.v5.Socks5AddressEncoder
        public void encodeAddress(Socks5AddressType socks5AddressType, String str, ByteBuf byteBuf) {
            byte bByteValue = socks5AddressType.byteValue();
            if (bByteValue == Socks5AddressType.IPv4.byteValue()) {
                if (str != null) {
                    byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(str));
                    return;
                } else {
                    byteBuf.writeInt(0);
                    return;
                }
            }
            if (bByteValue == Socks5AddressType.DOMAIN.byteValue()) {
                if (str == null) {
                    byteBuf.writeByte(0);
                    return;
                } else {
                    byteBuf.writeByte(str.length());
                    byteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
                    return;
                }
            }
            if (bByteValue != Socks5AddressType.IPv6.byteValue()) {
                throw new EncoderException("unsupported addrType: " + (socks5AddressType.byteValue() & 255));
            }
            if (str != null) {
                byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(str));
            } else {
                byteBuf.writeLong(0L);
                byteBuf.writeLong(0L);
            }
        }
    };

    void encodeAddress(Socks5AddressType socks5AddressType, String str, ByteBuf byteBuf);
}
