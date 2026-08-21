package io.sentry;

import j$.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {
    public final String a;
    public final Pattern b;

    public j0(String str) {
        Pattern patternCompile;
        this.a = str;
        try {
            patternCompile = Pattern.compile(str);
        } catch (Throwable unused) {
            p4.c().getOptions().getLogger().h(p5.DEBUG, "Only using filter string for String comparison as it could not be parsed as regex: %s", str);
            patternCompile = null;
        }
        this.b = patternCompile;
    }

    public final boolean equals(Object obj) {
        if (obj == null || j0.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.a, ((j0) obj).a);
    }

    public final int hashCode() {
        return Objects.hash(this.a);
    }
}
