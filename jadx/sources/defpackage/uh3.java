package defpackage;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class uh3 implements Serializable {
    public final Pattern b;

    public uh3(String str) {
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this.b = patternCompile;
    }

    public static uh2 a(uh3 uh3Var, CharSequence charSequence) {
        uh3Var.getClass();
        charSequence.getClass();
        Matcher matcher = uh3Var.b.matcher(charSequence);
        matcher.getClass();
        return p95.k(matcher, 0, charSequence);
    }

    public final uh2 b(CharSequence charSequence, int i) {
        Matcher matcherRegion = this.b.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length());
        if (matcherRegion.lookingAt()) {
            return new uh2(matcherRegion, charSequence);
        }
        return null;
    }

    public final uh2 c(CharSequence charSequence) {
        charSequence.getClass();
        Matcher matcher = this.b.matcher(charSequence);
        matcher.getClass();
        if (matcher.matches()) {
            return new uh2(matcher, charSequence);
        }
        return null;
    }

    public final boolean d(CharSequence charSequence) {
        charSequence.getClass();
        return this.b.matcher(charSequence).matches();
    }

    public final String toString() {
        String string = this.b.toString();
        string.getClass();
        return string;
    }
}
