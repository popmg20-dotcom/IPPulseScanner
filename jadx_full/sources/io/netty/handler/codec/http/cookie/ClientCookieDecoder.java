package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.ObjectUtil;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ClientCookieDecoder extends CookieDecoder {
    public static final ClientCookieDecoder STRICT = new ClientCookieDecoder(true);
    public static final ClientCookieDecoder LAX = new ClientCookieDecoder(false);

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class CookieBuilder {
        private final DefaultCookie cookie;
        private String domain;
        private int expiresEnd;
        private int expiresStart;
        private final String header;
        private boolean httpOnly;
        private long maxAge = Long.MIN_VALUE;
        private String path;
        private CookieHeaderNames.SameSite sameSite;
        private boolean secure;

        public CookieBuilder(DefaultCookie defaultCookie, String str) {
            this.cookie = defaultCookie;
            this.header = str;
        }

        private String computeValue(int i, int i2) {
            if (isValueDefined(i, i2)) {
                return this.header.substring(i, i2);
            }
            return null;
        }

        private static boolean isValueDefined(int i, int i2) {
            return (i == -1 || i == i2) ? false : true;
        }

        private long mergeMaxAgeAndExpires() {
            Date httpDate;
            long j = this.maxAge;
            if (j != Long.MIN_VALUE) {
                return j;
            }
            if (!isValueDefined(this.expiresStart, this.expiresEnd) || (httpDate = DateFormatter.parseHttpDate(this.header, this.expiresStart, this.expiresEnd)) == null) {
                return Long.MIN_VALUE;
            }
            long time = httpDate.getTime() - System.currentTimeMillis();
            return (time / 1000) + ((long) (time % 1000 != 0 ? 1 : 0));
        }

        private void parse4(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, CookieHeaderNames.PATH, 0, 4)) {
                this.path = computeValue(i2, i3);
            }
        }

        private void parse6(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, CookieHeaderNames.DOMAIN, 0, 5)) {
                this.domain = computeValue(i2, i3);
            } else if (this.header.regionMatches(true, i, CookieHeaderNames.SECURE, 0, 5)) {
                this.secure = true;
            }
        }

        private void parse7(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, "Expires", 0, 7)) {
                this.expiresStart = i2;
                this.expiresEnd = i3;
            } else if (this.header.regionMatches(true, i, CookieHeaderNames.MAX_AGE, 0, 7)) {
                setMaxAge(computeValue(i2, i3));
            }
        }

        private void parse8(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, CookieHeaderNames.HTTPONLY, 0, 8)) {
                this.httpOnly = true;
            } else if (this.header.regionMatches(true, i, CookieHeaderNames.SAMESITE, 0, 8)) {
                this.sameSite = CookieHeaderNames.SameSite.of(computeValue(i2, i3));
            }
        }

        private void setMaxAge(String str) {
            try {
                this.maxAge = Math.max(Long.parseLong(str), 0L);
            } catch (NumberFormatException unused) {
            }
        }

        public void appendAttribute(int i, int i2, int i3, int i4) {
            int i5 = i2 - i;
            if (i5 == 4) {
                parse4(i, i3, i4);
                return;
            }
            if (i5 == 6) {
                parse6(i, i3, i4);
            } else if (i5 == 7) {
                parse7(i, i3, i4);
            } else if (i5 == 8) {
                parse8(i, i3, i4);
            }
        }

        public Cookie cookie() {
            this.cookie.setDomain(this.domain);
            this.cookie.setPath(this.path);
            this.cookie.setMaxAge(mergeMaxAgeAndExpires());
            this.cookie.setSecure(this.secure);
            this.cookie.setHttpOnly(this.httpOnly);
            this.cookie.setSameSite(this.sameSite);
            return this.cookie;
        }
    }

    private ClientCookieDecoder(boolean z) {
        super(z);
    }

    public Cookie decode(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        ClientCookieDecoder clientCookieDecoder;
        String str2;
        int length = ((String) ObjectUtil.checkNotNull(str, "header")).length();
        if (length == 0) {
            return null;
        }
        CookieBuilder cookieBuilder = null;
        int i5 = 0;
        while (i5 != length) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == ',') {
                break;
            }
            if (cCharAt == '\t' || cCharAt == '\n' || cCharAt == 11 || cCharAt == '\f' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == ';') {
                i5++;
                this = this;
                str = str;
            } else {
                int i6 = i5;
                while (true) {
                    char cCharAt2 = str.charAt(i6);
                    i = -1;
                    if (cCharAt2 == ';') {
                        i2 = i6;
                        i3 = i2;
                        break;
                    }
                    if (cCharAt2 == '=') {
                        int i7 = i6 + 1;
                        if (i7 == length) {
                            i4 = 0;
                            i2 = i6;
                            i3 = i7;
                            i = 0;
                        } else {
                            int iIndexOf = str.indexOf(59, i7);
                            if (iIndexOf <= 0) {
                                iIndexOf = length;
                            }
                            i3 = iIndexOf;
                            i4 = i7;
                            i2 = i6;
                            i = i3;
                        }
                    } else {
                        i6++;
                        if (i6 == length) {
                            i2 = length;
                            i3 = i6;
                            break;
                        }
                        i5 = i5;
                        this = this;
                        str = str;
                    }
                }
                i4 = -1;
                if (i > 0 && str.charAt(i - 1) == ',') {
                    i--;
                }
                if (cookieBuilder == null) {
                    ClientCookieDecoder clientCookieDecoder2 = this;
                    String str3 = str;
                    DefaultCookie defaultCookieInitCookie = clientCookieDecoder2.initCookie(str3, i5, i2, i4, i);
                    clientCookieDecoder = clientCookieDecoder2;
                    str2 = str3;
                    if (defaultCookieInitCookie == null) {
                        return null;
                    }
                    cookieBuilder = new CookieBuilder(defaultCookieInitCookie, str2);
                } else {
                    String str4 = str;
                    clientCookieDecoder = this;
                    int i8 = i5;
                    str2 = str4;
                    cookieBuilder.appendAttribute(i8, i2, i4, i);
                }
                this = clientCookieDecoder;
                str = str2;
                i5 = i3;
            }
        }
        if (cookieBuilder != null) {
            return cookieBuilder.cookie();
        }
        return null;
    }
}
