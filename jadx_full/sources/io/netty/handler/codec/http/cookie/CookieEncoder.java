package io.netty.handler.codec.http.cookie;

import defpackage.ha0;
import defpackage.xe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CookieEncoder {
    protected final boolean strict;

    public CookieEncoder(boolean z) {
        this.strict = z;
    }

    public void validateCookie(String str, String str2) {
        if (this.strict) {
            int iFirstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (iFirstInvalidCookieNameOctet >= 0) {
                throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(iFirstInvalidCookieNameOctet));
            }
            CharSequence charSequenceUnwrapValue = CookieUtil.unwrapValue(str2);
            if (charSequenceUnwrapValue == null) {
                xe.k(ha0.n("Cookie value wrapping quotes are not balanced: ", str2));
                return;
            }
            int iFirstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(charSequenceUnwrapValue);
            if (iFirstInvalidCookieValueOctet < 0) {
                return;
            }
            throw new IllegalArgumentException("Cookie value contains an invalid char: " + charSequenceUnwrapValue.charAt(iFirstInvalidCookieValueOctet));
        }
    }
}
