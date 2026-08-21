package defpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qh2 {
    public static final Pattern b = Pattern.compile("([LR]:|[\\w\\.:][\\w\\.:\\-]*|[\\,\\|\\-\\(\\)])");
    public final Matcher a;

    public qh2(CharSequence charSequence) {
        this.a = b.matcher(charSequence);
    }

    public final String a() {
        Matcher matcher = this.a;
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
