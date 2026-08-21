package defpackage;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gn4 implements Serializable {
    public final Set b;
    public final kx0 f;
    public static final Pattern z = Pattern.compile("^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*");
    public static final Pattern A = Pattern.compile("(?:\\[(::FFFF:(?:\\d{1,3}\\.){3}\\d{1,3}|[0-9a-fA-F:]+)\\]|(?:(?:[a-zA-Z0-9%-._~!$&'()*+,;=]+(?::[a-zA-Z0-9%-._~!$&'()*+,;=]*)?@)?([\\p{Alnum}\\-\\.]*)))(?::(\\d*))?(.*)?");
    public static final Pattern X = Pattern.compile("^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$");
    public static final Pattern Y = Pattern.compile("^(\\S*)$");
    public static final String[] Z = {"http", "https", "ftp"};

    static {
        new gn4(null);
    }

    public gn4(String[] strArr) {
        kx0 kx0VarD = kx0.d(false);
        if (kx0VarD == null) {
            xe.k("DomainValidator must not be null");
            throw null;
        }
        if (kx0VarD.b) {
            xe.k("DomainValidator disagrees with ALLOW_LOCAL_URLS setting");
            throw null;
        }
        this.f = kx0VarD;
        strArr = strArr == null ? Z : strArr;
        this.b = new HashSet(strArr.length);
        for (String str : strArr) {
            this.b.add(str.toLowerCase(Locale.ENGLISH));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String str) {
        int i;
        String rawPath;
        if (str != null) {
            try {
                URI uri = new URI(str);
                String scheme = uri.getScheme();
                if (scheme != null && z.matcher(scheme).matches()) {
                    if (this.b.contains(scheme.toLowerCase(Locale.ENGLISH))) {
                        String rawAuthority = uri.getRawAuthority();
                        if ("file".equals(scheme) && q83.a(rawAuthority)) {
                            return true;
                        }
                        if ((!"file".equals(scheme) || rawAuthority == null || !rawAuthority.contains(":")) && rawAuthority != null) {
                            Matcher matcher = A.matcher(kx0.f(rawAuthority));
                            if (matcher.matches()) {
                                String strGroup = matcher.group(1);
                                if (strGroup == null) {
                                    String strGroup2 = matcher.group(2);
                                    if (this.f.e(strGroup2) || xz1.b(strGroup2)) {
                                        String strGroup3 = matcher.group(3);
                                        if (q83.a(strGroup3) || ((i = Integer.parseInt(strGroup3)) >= 0 && i <= 65535)) {
                                        }
                                    }
                                } else if (xz1.c(strGroup)) {
                                    String strGroup4 = matcher.group(4);
                                    if ((strGroup4 == null || strGroup4.trim().isEmpty()) && (rawPath = uri.getRawPath()) != null && X.matcher(rawPath).matches()) {
                                        String path = new URI(null, "localhost", rawPath, null).normalize().getPath();
                                        if (!path.startsWith("/../")) {
                                            if (!path.equals("/..")) {
                                                int iIndexOf = 0;
                                                int i2 = 0;
                                                while (iIndexOf != -1) {
                                                    iIndexOf = rawPath.indexOf("//", iIndexOf);
                                                    if (iIndexOf > -1) {
                                                        iIndexOf++;
                                                        i2++;
                                                    }
                                                }
                                                if (i2 <= 0) {
                                                    String rawQuery = uri.getRawQuery();
                                                    if (rawQuery == null ? true : Y.matcher(rawQuery).matches()) {
                                                        uri.getRawFragment();
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (NumberFormatException | URISyntaxException unused) {
            }
        }
        return false;
    }
}
