package defpackage;

import android.util.Pair;
import java.util.List;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.CompleteEnterAction;
import org.eclipse.tm4e.languageconfiguration.internal.model.IndentationRules;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;
import org.eclipse.tm4e.languageconfiguration.internal.model.OnEnterRule;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gc4 implements sr2 {
    public final cv2 a;
    public final ha1 b;
    public CompleteEnterAction c;
    public Pair d;

    public gc4(dc4 dc4Var) {
        this.a = null;
        this.b = null;
        LanguageConfiguration languageConfiguration = dc4Var.c;
        if (languageConfiguration == null) {
            return;
        }
        List<OnEnterRule> onEnterRules = languageConfiguration.getOnEnterRules();
        List<CharacterPair> brackets = languageConfiguration.getBrackets();
        IndentationRules indentationRules = languageConfiguration.getIndentationRules();
        if (onEnterRules != null) {
            this.a = new cv2(brackets, onEnterRules);
        }
        if (indentationRules != null) {
            this.b = new ha1(10, indentationRules);
        }
    }

    public final u04 a() {
        Pair pair = this.d;
        if (pair != null) {
            return new u04("\n".concat(b((String) pair.second)), 0, 1);
        }
        int i = ec4.a[this.c.indentAction.ordinal()];
        if (i == 1 || i == 2) {
            return new u04("\n".concat(b(this.c.indentation + this.c.appendText)), 0, 1);
        }
        if (i == 3) {
            String strB = b(this.c.indentation);
            return new u04(fw.u("\n", b(this.c.indentation + this.c.appendText), "\n", strB), strB.length() + 1, 1);
        }
        if (i != 4) {
            return new u04("", 0, 1);
        }
        String str = this.c.indentation;
        boolean zStartsWith = true;
        boolean z = true;
        int i2 = 0;
        while (true) {
            if (!zStartsWith && !z) {
                break;
            }
            zStartsWith = str.startsWith("\t", i2);
            if (zStartsWith) {
                i2++;
            }
            z = false;
        }
        String strB2 = b(str.substring(0, i2) + this.c.appendText);
        if (strB2.startsWith("\t")) {
            strB2 = strB2.substring(1);
        }
        return new u04(strB2, strB2.length() + 1, 1);
    }

    public final String b(String str) {
        int length = str.length();
        int length2 = 0;
        while (true) {
            if (length2 >= length) {
                length2 = -1;
                break;
            }
            char cCharAt = str.charAt(length2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                break;
            }
            length2++;
        }
        if (length2 == -1) {
            length2 = str.length();
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, length2);
        int i = 0;
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            i = strSubstring.charAt(i2) == '\t' ? i + 4 : i + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < i; i3++) {
            sb2.append(' ');
        }
        sb.append(sb2.toString());
        sb.append(str.substring(length2));
        return sb.toString();
    }
}
