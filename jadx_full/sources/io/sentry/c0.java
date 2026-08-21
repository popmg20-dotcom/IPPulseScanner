package io.sentry;

import defpackage.xe;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final Pattern e = Pattern.compile("^o(\\d+)\\.");
    public final String a;
    public final String b;
    public final URI c;
    public final String d;

    public c0(String str) {
        int i;
        io.sentry.util.b.r(str, "The DSN is required.");
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            xe.k("The DSN is empty.");
            throw null;
        }
        try {
            int iIndexOf = strTrim.indexOf("://");
            if (iIndexOf < 0) {
                throw new IllegalArgumentException("Invalid DSN: Missing scheme.");
            }
            String strSubstring = strTrim.substring(0, iIndexOf);
            if (!"http".equalsIgnoreCase(strSubstring) && !"https".equalsIgnoreCase(strSubstring)) {
                throw new IllegalArgumentException("Invalid DSN: Invalid scheme '" + strSubstring + "'.");
            }
            int i2 = iIndexOf + 3;
            int iIndexOf2 = strTrim.indexOf(64, i2);
            if (iIndexOf2 < 0) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String strSubstring2 = strTrim.substring(i2, iIndexOf2);
            int iIndexOf3 = strSubstring2.indexOf(58);
            String strSubstring3 = iIndexOf3 < 0 ? strSubstring2 : strSubstring2.substring(0, iIndexOf3);
            this.b = strSubstring3;
            this.a = iIndexOf3 < 0 ? null : strSubstring2.substring(iIndexOf3 + 1);
            if (strSubstring3.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            int i3 = iIndexOf2 + 1;
            int iIndexOf4 = strTrim.indexOf(63, i3);
            int iIndexOf5 = strTrim.indexOf(35, i3);
            if (iIndexOf5 >= 0 && (iIndexOf4 < 0 || iIndexOf5 < iIndexOf4)) {
                iIndexOf4 = iIndexOf5;
            }
            String strSubstring4 = iIndexOf4 < 0 ? strTrim.substring(i3) : strTrim.substring(i3, iIndexOf4);
            int iIndexOf6 = strSubstring4.indexOf(47);
            if (iIndexOf6 < 0) {
                throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
            }
            String strSubstring5 = strSubstring4.substring(0, iIndexOf6);
            int iIndexOf7 = strSubstring5.startsWith("[") ? strSubstring5.indexOf(58, strSubstring5.indexOf(93)) : strSubstring5.indexOf(58);
            String strSubstring6 = iIndexOf7 < 0 ? strSubstring5 : strSubstring5.substring(0, iIndexOf7);
            if (iIndexOf7 < 0) {
                i = -1;
            } else {
                String strSubstring7 = strSubstring5.substring(iIndexOf7 + 1);
                try {
                    i = Integer.parseInt(strSubstring7);
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException("Invalid DSN: Invalid port '" + strSubstring7 + "'.", e2);
                }
            }
            int i4 = i;
            String strSubstring8 = strSubstring4.substring(iIndexOf6);
            if (strSubstring8.contains("//")) {
                StringBuilder sb = new StringBuilder(strSubstring8.length());
                char c = 0;
                for (int i5 = 0; i5 < strSubstring8.length(); i5++) {
                    char cCharAt = strSubstring8.charAt(i5);
                    if (cCharAt != '/' || c != '/') {
                        sb.append(cCharAt);
                        c = cCharAt;
                    }
                }
                strSubstring8 = sb.toString();
            }
            strSubstring8 = strSubstring8.endsWith("/") ? strSubstring8.substring(0, strSubstring8.length() - 1) : strSubstring8;
            int iLastIndexOf = strSubstring8.lastIndexOf(47) + 1;
            String strSubstring9 = strSubstring8.substring(0, iLastIndexOf);
            if (!strSubstring9.endsWith("/")) {
                strSubstring9 = strSubstring9.concat("/");
            }
            String strSubstring10 = strSubstring8.substring(iLastIndexOf);
            if (strSubstring10.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
            }
            String str2 = strSubstring6;
            this.c = new URI(strSubstring, null, str2, i4, strSubstring9 + "api/" + strSubstring10, null, null);
            Matcher matcher = e.matcher(str2);
            this.d = matcher.find() ? matcher.group(1) : null;
        } catch (URISyntaxException e3) {
            throw new IllegalArgumentException("Invalid DSN: " + e3.getMessage(), e3);
        }
    }
}
