package io.netty.handler.codec.socksx.v5;

import defpackage.xe;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultSocks5PasswordAuthRequest extends AbstractSocks5Message implements Socks5PasswordAuthRequest {
    private final String password;
    private final String username;

    public DefaultSocks5PasswordAuthRequest(String str, String str2) {
        ObjectUtil.checkNotNull(str, "username");
        ObjectUtil.checkNotNull(str2, "password");
        if (str.length() > 255) {
            xe.k("username: **** (expected: less than 256 chars)");
            throw null;
        }
        if (str2.length() > 255) {
            xe.k("password: **** (expected: less than 256 chars)");
            throw null;
        }
        this.username = str;
        this.password = str2;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequest
    public String password() {
        return this.password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(username: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", username: ");
        }
        sb.append(username());
        sb.append(", password: ****)");
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequest
    public String username() {
        return this.username;
    }
}
