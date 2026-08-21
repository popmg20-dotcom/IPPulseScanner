package io.netty.handler.codec.http;

import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class HttpConstants {
    public static final byte COLON = 58;
    public static final byte COMMA = 44;
    public static final byte CR = 13;
    public static final Charset DEFAULT_CHARSET = CharsetUtil.UTF_8;
    public static final byte DOUBLE_QUOTE = 34;
    public static final byte EQUALS = 61;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final byte SEMICOLON = 59;
    public static final byte SP = 32;
    public static final char SP_CHAR = ' ';

    private HttpConstants() {
    }
}
