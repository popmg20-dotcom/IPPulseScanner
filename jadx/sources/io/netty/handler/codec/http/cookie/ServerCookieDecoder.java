package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.ObjectUtil;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ServerCookieDecoder extends CookieDecoder {
    private static final String RFC2965_DOMAIN = "$Domain";
    private static final String RFC2965_PATH = "$Path";
    private static final String RFC2965_PORT = "$Port";
    private static final String RFC2965_VERSION = "$Version";
    public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);
    public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);

    private ServerCookieDecoder(boolean z) {
        super(z);
    }

    private void decode(Collection<? super Cookie> collection, String str) {
        boolean z;
        int iIndexOf;
        int i;
        int i2;
        int i3;
        int i4;
        ServerCookieDecoder serverCookieDecoder;
        String str2;
        int length = ((String) ObjectUtil.checkNotNull(str, "header")).length();
        if (length == 0) {
            return;
        }
        String str3 = str;
        if (str3.regionMatches(true, 0, RFC2965_VERSION, 0, 8)) {
            iIndexOf = str3.indexOf(59) + 1;
            z = true;
        } else {
            z = false;
            iIndexOf = 0;
        }
        while (iIndexOf != length) {
            char cCharAt = str3.charAt(iIndexOf);
            if (cCharAt == '\t' || cCharAt == '\n' || cCharAt == 11 || cCharAt == '\f' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                iIndexOf++;
                this = this;
                str3 = str3;
            } else {
                int i5 = iIndexOf;
                while (true) {
                    char cCharAt2 = str3.charAt(i5);
                    i = -1;
                    if (cCharAt2 == ';') {
                        i2 = i5;
                        i3 = i2;
                        break;
                    }
                    if (cCharAt2 == '=') {
                        i = i5 + 1;
                        if (i == length) {
                            i2 = i5;
                            i3 = i;
                            i = 0;
                        } else {
                            int iIndexOf2 = str3.indexOf(59, i);
                            if (iIndexOf2 <= 0) {
                                iIndexOf2 = length;
                            }
                            i4 = iIndexOf2;
                            i3 = i4;
                            i2 = i5;
                        }
                    } else {
                        i5++;
                        if (i5 == length) {
                            i2 = length;
                            i3 = i5;
                            break;
                        }
                    }
                }
                i4 = i;
                if (z && (str3.regionMatches(iIndexOf, RFC2965_PATH, 0, 5) || str3.regionMatches(iIndexOf, RFC2965_DOMAIN, 0, 7) || str3.regionMatches(iIndexOf, RFC2965_PORT, 0, 5))) {
                    str2 = str3;
                    serverCookieDecoder = this;
                } else {
                    String str4 = str3;
                    serverCookieDecoder = this;
                    DefaultCookie defaultCookieInitCookie = serverCookieDecoder.initCookie(str4, iIndexOf, i2, i, i4);
                    str2 = str4;
                    if (defaultCookieInitCookie != null) {
                        collection.add(defaultCookieInitCookie);
                    }
                }
                this = serverCookieDecoder;
                str3 = str2;
                iIndexOf = i3;
            }
        }
    }

    public List<Cookie> decodeAll(String str) {
        ArrayList arrayList = new ArrayList();
        decode(arrayList, str);
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public Set<Cookie> decode(String str) {
        TreeSet treeSet = new TreeSet();
        decode(treeSet, str);
        return treeSet;
    }
}
