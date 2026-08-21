package io.netty.handler.codec.socksx.v5;

import defpackage.ha0;
import defpackage.xe;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSocks5CommandRequest extends AbstractSocks5Message implements Socks5CommandRequest {
    private final String dstAddr;
    private final Socks5AddressType dstAddrType;
    private final int dstPort;
    private final Socks5CommandType type;

    public DefaultSocks5CommandRequest(Socks5CommandType socks5CommandType, Socks5AddressType socks5AddressType, String str, int i) {
        this.type = (Socks5CommandType) ObjectUtil.checkNotNull(socks5CommandType, "type");
        ObjectUtil.checkNotNull(socks5AddressType, "dstAddrType");
        ObjectUtil.checkNotNull(str, "dstAddr");
        if (socks5AddressType == Socks5AddressType.IPv4) {
            if (!NetUtil.isValidIpV4Address(str)) {
                xe.k(ha0.o("dstAddr: ", str, " (expected: a valid IPv4 address)"));
                throw null;
            }
        } else if (socks5AddressType == Socks5AddressType.DOMAIN) {
            str = IDN.toASCII(str);
            if (str.length() > 255) {
                xe.k(ha0.o("dstAddr: ", str, " (expected: less than 256 chars)"));
                throw null;
            }
        } else if (socks5AddressType == Socks5AddressType.IPv6 && !NetUtil.isValidIpV6Address(str)) {
            xe.k(ha0.o("dstAddr: ", str, " (expected: a valid IPv6 address"));
            throw null;
        }
        if (i < 0 || i > 65535) {
            xe.k(ha0.k("dstPort: ", i, " (expected: 0~65535)"));
            throw null;
        }
        this.dstAddrType = socks5AddressType;
        this.dstAddr = str;
        this.dstPort = i;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public Socks5AddressType dstAddrType() {
        return this.dstAddrType;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public int dstPort() {
        return this.dstPort;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(type: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", type: ");
        }
        sb.append(type());
        sb.append(", dstAddrType: ");
        sb.append(dstAddrType());
        sb.append(", dstAddr: ");
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public Socks5CommandType type() {
        return this.type;
    }
}
