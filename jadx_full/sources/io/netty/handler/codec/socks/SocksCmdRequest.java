package io.netty.handler.codec.socks;

import defpackage.a71;
import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.IDN;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SocksCmdRequest extends SocksRequest {
    private final SocksAddressType addressType;
    private final SocksCmdType cmdType;
    private final String host;
    private final int port;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        static {
            int[] iArr = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr;
            try {
                iArr[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SocksCmdRequest(SocksCmdType socksCmdType, SocksAddressType socksAddressType, String str, int i) {
        super(SocksRequestType.CMD);
        ObjectUtil.checkNotNull(socksCmdType, "cmdType");
        ObjectUtil.checkNotNull(socksAddressType, "addressType");
        ObjectUtil.checkNotNull(str, "host");
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                String ascii = IDN.toASCII(str);
                if (ascii.length() > 255) {
                    throw new IllegalArgumentException(str + " IDN: " + ascii + " exceeds 255 char limit");
                }
                str = ascii;
            } else if (i2 == 3 && !NetUtil.isValidIpV6Address(str)) {
                xe.k(ha0.x(str, " is not a valid IPv6 address"));
                throw null;
            }
        } else if (!NetUtil.isValidIpV4Address(str)) {
            xe.k(ha0.x(str, " is not a valid IPv4 address"));
            throw null;
        }
        if (i <= 0 || i >= 65536) {
            a71.d(i, " is not in bounds 0 < x < 65536");
            throw null;
        }
        this.cmdType = socksCmdType;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdType cmdType() {
        return this.cmdType;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdType.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i == 1) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        } else if (i == 2) {
            byteBuf.writeByte(this.host.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
            byteBuf.writeShort(this.port);
        } else {
            if (i != 3) {
                return;
            }
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        }
    }

    public String host() {
        SocksAddressType socksAddressType = this.addressType;
        SocksAddressType socksAddressType2 = SocksAddressType.DOMAIN;
        String str = this.host;
        return socksAddressType == socksAddressType2 ? IDN.toUnicode(str) : str;
    }

    public int port() {
        return this.port;
    }
}
