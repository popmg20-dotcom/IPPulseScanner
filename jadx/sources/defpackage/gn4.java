package defpackage;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gn4.a(java.lang.String):boolean");
    }
}
