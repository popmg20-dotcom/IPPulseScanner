package defpackage;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class uh2 {
    public final Matcher a;
    public final CharSequence b;
    public final th2 c;
    public sh2 d;

    public uh2(Matcher matcher, CharSequence charSequence) {
        charSequence.getClass();
        this.a = matcher;
        this.b = charSequence;
        this.c = new th2(this);
    }

    public final List a() {
        sh2 sh2Var = this.d;
        if (sh2Var != null) {
            return sh2Var;
        }
        sh2 sh2Var2 = new sh2(0, this);
        this.d = sh2Var2;
        return sh2Var2;
    }

    public final b12 b() {
        Matcher matcher = this.a;
        return gb4.d0(matcher.start(), matcher.end());
    }

    public final uh2 c() {
        Matcher matcher = this.a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        matcher2.getClass();
        return p95.k(matcher2, iEnd, charSequence);
    }
}
