package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.aw2;
import defpackage.bp2;
import defpackage.g42;
import defpackage.tv2;
import defpackage.uv2;
import defpackage.zv2;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RegExPattern {

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class JavaRegExPattern extends RegExPattern {
        final Pattern pattern;

        public JavaRegExPattern(String str, String str2) {
            if (str2 != null) {
                str = str + "(?" + str2 + ")";
            }
            this.pattern = Pattern.compile(str);
        }

        @Override // org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern
        public boolean matchesFully(String str) {
            return this.pattern.matcher(str).matches();
        }

        @Override // org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern
        public boolean matchesPartially(String str) {
            return this.pattern.matcher(str).find();
        }

        @Override // org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern
        public String pattern() {
            return this.pattern.pattern();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class OnigRegExPattern extends RegExPattern {
        final tv2 regex;

        public OnigRegExPattern(String str, String str2) {
            boolean z = str2 != null && str2.contains("i");
            this.regex = aw2.a ? new g42(str, z) : new bp2(str, z);
        }

        @Override // org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern
        public boolean matchesFully(String str) {
            uv2 uv2VarA = this.regex.a(zv2.c(str));
            return uv2VarA != null && uv2VarA.count() == 1 && uv2VarA.a(0) == str.length();
        }

        @Override // org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern
        public boolean matchesPartially(String str) {
            return this.regex.a(zv2.c(str)) != null;
        }

        @Override // org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern
        public String pattern() {
            return this.regex.pattern();
        }
    }

    public static RegExPattern of(String str, String str2) {
        try {
            return new JavaRegExPattern(str, str2);
        } catch (Exception unused) {
            return new OnigRegExPattern(str, str2);
        }
    }

    public static RegExPattern ofNullable(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return new JavaRegExPattern(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return new OnigRegExPattern(str, str2);
        }
    }

    public abstract boolean matchesFully(String str);

    public abstract boolean matchesPartially(String str);

    public abstract String pattern();

    public String toString() {
        return pattern();
    }

    public static RegExPattern of(String str) {
        return of(str, null);
    }

    public static RegExPattern ofNullable(String str) {
        return ofNullable(str, null);
    }
}
