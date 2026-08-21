package io.sentry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u6 {
    public static final Pattern d = Pattern.compile("^[ \\t]*([0-9a-f]{32})-([0-9a-f]{16})(-[01])?[ \\t]*$", 2);
    public final io.sentry.protocol.w a;
    public final d7 b;
    public final Boolean c;

    public u6(String str) throws io.sentry.exception.b {
        Matcher matcher = d.matcher(str);
        if (!matcher.matches()) {
            throw new io.sentry.exception.b("sentry-trace header does not conform to expected format: ".concat(str), null);
        }
        this.a = new io.sentry.protocol.w(matcher.group(1));
        this.b = new d7(matcher.group(2));
        String strGroup = matcher.group(3);
        this.c = strGroup != null ? Boolean.valueOf("1".equals(strGroup.substring(1))) : null;
    }

    public final String a() {
        d7 d7Var = this.b;
        Boolean bool = this.c;
        io.sentry.protocol.w wVar = this.a;
        if (bool == null) {
            return wVar + "-" + d7Var;
        }
        return wVar + "-" + d7Var + "-" + (bool.booleanValue() ? "1" : "0");
    }

    public u6(io.sentry.protocol.w wVar, d7 d7Var, Boolean bool) {
        this.a = wVar;
        this.b = d7Var;
        this.c = bool;
    }
}
