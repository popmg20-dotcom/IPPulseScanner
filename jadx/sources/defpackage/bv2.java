package defpackage;

import io.sentry.android.core.a1;
import java.util.regex.Pattern;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bv2 {
    public static final Pattern c = Pattern.compile("\\B");
    public final Pattern a;
    public final Pattern b;

    public bv2(CharacterPair characterPair) {
        Pattern patternCompile;
        String str = characterPair.open;
        ve2 ve2Var = rh3.a;
        StringBuilder sb = new StringBuilder(str.replaceAll("[\\-\\\\\\{\\}\\*\\+\\?\\|\\^\\$\\.\\[\\]\\(\\)\\#]", "\\\\$0"));
        String strValueOf = String.valueOf(sb.charAt(0));
        Pattern pattern = c;
        if (!pattern.matcher(strValueOf).find()) {
            sb.insert(0, "\\b");
        }
        sb.append("\\s*$");
        String string = sb.toString();
        Pattern patternCompile2 = null;
        try {
            patternCompile = Pattern.compile(string);
        } catch (Exception e) {
            a1.e(rh3.a.a, "Failed to parse pattern: ".concat(string), e);
            patternCompile = null;
        }
        this.a = patternCompile;
        StringBuilder sb2 = new StringBuilder(characterPair.close.replaceAll("[\\-\\\\\\{\\}\\*\\+\\?\\|\\^\\$\\.\\[\\]\\(\\)\\#]", "\\\\$0"));
        if (!pattern.matcher(String.valueOf(sb2.charAt(sb2.length() - 1))).find()) {
            sb2.append("\\b");
        }
        sb2.insert(0, "^\\s*");
        String string2 = sb2.toString();
        try {
            patternCompile2 = Pattern.compile(string2);
        } catch (Exception e2) {
            a1.e(rh3.a.a, "Failed to parse pattern: ".concat(string2), e2);
        }
        this.b = patternCompile2;
    }
}
