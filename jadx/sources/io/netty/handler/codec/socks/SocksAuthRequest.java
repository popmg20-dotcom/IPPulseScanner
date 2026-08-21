package io.netty.handler.codec.socks;

import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SocksAuthRequest extends SocksRequest {
    private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;
    private final String password;
    private final String username;

    public SocksAuthRequest(String str, String str2) {
        super(SocksRequestType.AUTH);
        ObjectUtil.checkNotNull(str, "username");
        ObjectUtil.checkNotNull(str2, "password");
        CharsetEncoder charsetEncoderEncoder = CharsetUtil.encoder(CharsetUtil.US_ASCII);
        if (!charsetEncoderEncoder.canEncode(str) || !charsetEncoderEncoder.canEncode(str2)) {
            xe.k(ha0.o("username: ", str, " or password: **** values should be in pure ascii"));
            throw null;
        }
        if (str.length() > 255) {
            xe.k(ha0.o("username: ", str, " exceeds 255 char limit"));
            throw null;
        }
        if (str2.length() > 255) {
            xe.k("password: **** exceeds 255 char limit");
            throw null;
        }
        this.username = str;
        this.password = str2;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
        byteBuf.writeByte(this.username.length());
        String str = this.username;
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeCharSequence(str, charset);
        byteBuf.writeByte(this.password.length());
        byteBuf.writeCharSequence(this.password, charset);
    }

    public String password() {
        return this.password;
    }

    public String username() {
        return this.username;
    }
}
