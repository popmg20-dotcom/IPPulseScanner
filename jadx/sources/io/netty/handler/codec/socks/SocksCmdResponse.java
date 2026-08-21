package io.netty.handler.codec.socks;

import defpackage.a71;
import defpackage.fw;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.IDN;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SocksCmdResponse extends SocksResponse {
    private static final byte[] DOMAIN_ZEROED = {0};
    private static final byte[] IPv4_HOSTNAME_ZEROED = {0, 0, 0, 0};
    private static final byte[] IPv6_HOSTNAME_ZEROED = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final SocksAddressType addressType;
    private final SocksCmdStatus cmdStatus;
    private final String host;
    private final int port;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdResponse$1, reason: invalid class name */
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

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType, String str, int i) {
        super(SocksResponseType.CMD);
        ObjectUtil.checkNotNull(socksCmdStatus, "cmdStatus");
        ObjectUtil.checkNotNull(socksAddressType, "addressType");
        if (str != null) {
            int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    String ascii = IDN.toASCII(str);
                    if (ascii.length() > 255) {
                        xe.k(fw.u(str, " IDN: ", ascii, " exceeds 255 char limit"));
                        throw null;
                    }
                    str = ascii;
                } else if (i2 == 3 && !NetUtil.isValidIpV6Address(str)) {
                    xe.k(str.concat(" is not a valid IPv6 address"));
                    throw null;
                }
            } else if (!NetUtil.isValidIpV4Address(str)) {
                xe.k(str.concat(" is not a valid IPv4 address"));
                throw null;
            }
        }
        if (i < 0 || i > 65535) {
            a71.d(i, " is not in bounds 0 <= x <= 65535");
            throw null;
        }
        this.cmdStatus = socksCmdStatus;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdStatus cmdStatus() {
        return this.cmdStatus;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdStatus.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i == 1) {
            String str = this.host;
            byteBuf.writeBytes(str == null ? IPv4_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(str));
            byteBuf.writeShort(this.port);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            String str2 = this.host;
            byteBuf.writeBytes(str2 == null ? IPv6_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(str2));
            byteBuf.writeShort(this.port);
            return;
        }
        String str3 = this.host;
        if (str3 != null) {
            byteBuf.writeByte(str3.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
        } else {
            byte[] bArr = DOMAIN_ZEROED;
            byteBuf.writeByte(bArr.length);
            byteBuf.writeBytes(bArr);
        }
        byteBuf.writeShort(this.port);
    }

    public String host() {
        String str = this.host;
        return (str == null || this.addressType != SocksAddressType.DOMAIN) ? str : IDN.toUnicode(str);
    }

    public int port() {
        return this.port;
    }

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType) {
        this(socksCmdStatus, socksAddressType, null, 0);
    }
}
