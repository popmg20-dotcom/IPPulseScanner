package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.bk4;
import defpackage.g62;
import defpackage.jq1;
import defpackage.k62;
import defpackage.q42;
import defpackage.sm;
import defpackage.t82;
import defpackage.ve2;
import defpackage.w42;
import defpackage.y42;
import io.sentry.android.core.a1;
import j$.io.BufferedReaderRetargetClass;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class LanguageConfiguration {
    private static final ve2 log = ve2.a(LanguageConfiguration.class.getName());
    private String autoCloseBefore;
    private CommentRule comments;
    private FoldingRules folding;
    private IndentationRules indentationRules;
    private String wordPattern;
    private List<CharacterPair> brackets = null;
    private List<OnEnterRule> onEnterRules = null;
    private List<AutoClosingPairConditional> autoClosingPairs = null;
    private List<AutoClosingPair> surroundingPairs = null;
    private List<CharacterPair> colorizedBracketPairs = null;

    private static boolean getAsBoolean(y42 y42Var, boolean z) {
        if (y42Var != null) {
            try {
                return y42Var.a();
            } catch (Exception e) {
                a1.e(log.a, "Failed to convert JSON element [" + y42Var + "] to boolean.", e);
            }
        }
        return z;
    }

    private static Integer getAsInteger(y42 y42Var) {
        if (y42Var == null) {
            return null;
        }
        try {
            return Integer.valueOf(y42Var.b());
        } catch (Exception e) {
            a1.e(log.a, "Failed to convert JSON element [" + y42Var + "] to Integer.", e);
            return null;
        }
    }

    private static RegExPattern getAsPattern(y42 y42Var) {
        if (y42Var == null) {
            return null;
        }
        if (!(y42Var instanceof g62)) {
            return RegExPattern.ofNullable(getAsString(y42Var), null);
        }
        g62 g62Var = (g62) y42Var;
        String asString = getAsString(g62Var.h("pattern"));
        if (asString == null) {
            return null;
        }
        return RegExPattern.of(asString, getAsString(g62Var.h("flags")));
    }

    private static String getAsString(y42 y42Var) {
        if (y42Var == null) {
            return null;
        }
        try {
            return y42Var.d();
        } catch (Exception e) {
            a1.e(log.a, "Failed to convert JSON element [" + y42Var + "] to String.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String lambda$load$0(y42 y42Var, Type type, w42 w42Var) {
        y42Var.getClass();
        if (!(y42Var instanceof g62)) {
            return y42Var.d();
        }
        g62 g62VarC = y42Var.c();
        if (!g62VarC.b.containsKey("pattern")) {
            return null;
        }
        y42 y42VarH = g62VarC.h("pattern");
        y42VarH.getClass();
        if (y42VarH instanceof k62) {
            return g62VarC.h("pattern").d();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OnEnterRule lambda$load$1(y42 y42Var, Type type, w42 w42Var) {
        y42 y42VarH;
        y42Var.getClass();
        if (!(y42Var instanceof g62)) {
            return null;
        }
        g62 g62VarC = y42Var.c();
        RegExPattern asPattern = getAsPattern(g62VarC.h("beforeText"));
        if (asPattern != null && (y42VarH = g62VarC.h("action")) != null && (y42VarH instanceof g62)) {
            g62 g62VarC2 = y42VarH.c();
            String asString = getAsString(g62VarC2.h("indent"));
            if (asString != null) {
                return new OnEnterRule(asPattern, getAsPattern(g62VarC.h("afterText")), getAsPattern(g62VarC.h("previousLineText")), new EnterAction(EnterAction.IndentAction.get(asString), getAsString(g62VarC2.h("appendText")), getAsInteger(g62VarC2.h("removeText"))));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$load$10(OnEnterRule onEnterRule) {
        return onEnterRule == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$load$11(AutoClosingPair autoClosingPair) {
        return autoClosingPair == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$load$12(CharacterPair characterPair) {
        return characterPair == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CommentRule lambda$load$2(y42 y42Var, Type type, w42 w42Var) {
        CharacterPair characterPair;
        y42Var.getClass();
        if (y42Var instanceof g62) {
            g62 g62VarC = y42Var.c();
            String asString = getAsString(g62VarC.h("lineComment"));
            y42 y42VarH = g62VarC.h("blockComment");
            if (y42VarH == null || !(y42VarH instanceof q42)) {
                characterPair = null;
                if (asString == null || characterPair != null) {
                    return new CommentRule(asString, characterPair);
                }
            } else {
                q42 q42Var = (q42) y42VarH;
                if (q42Var.b.size() == 2) {
                    String asString2 = getAsString(q42Var.e(0));
                    String asString3 = getAsString(q42Var.e(1));
                    if (asString2 != null && asString3 != null) {
                        characterPair = new CharacterPair(asString2, asString3);
                    }
                    if (asString == null) {
                    }
                    return new CommentRule(asString, characterPair);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CharacterPair lambda$load$3(y42 y42Var, Type type, w42 w42Var) {
        y42Var.getClass();
        if (!(y42Var instanceof q42)) {
            return null;
        }
        q42 q42Var = (q42) y42Var;
        if (q42Var.b.size() != 2) {
            return null;
        }
        String asString = getAsString(q42Var.e(0));
        String asString2 = getAsString(q42Var.e(1));
        if (asString == null || asString2 == null) {
            return null;
        }
        return new CharacterPair(asString, asString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoClosingPair lambda$load$4(y42 y42Var, Type type, w42 w42Var) {
        String asString;
        String asString2;
        y42Var.getClass();
        if (y42Var instanceof q42) {
            q42 q42Var = (q42) y42Var;
            if (q42Var.b.size() != 2) {
                return null;
            }
            asString2 = getAsString(q42Var.e(0));
            asString = getAsString(q42Var.e(1));
        } else if (y42Var instanceof g62) {
            g62 g62VarC = y42Var.c();
            asString2 = getAsString(g62VarC.h("open"));
            asString = getAsString(g62VarC.h("close"));
        } else {
            asString = null;
            asString2 = null;
        }
        if (asString2 == null || asString == null) {
            return null;
        }
        return new AutoClosingPair(asString2, asString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoClosingPairConditional lambda$load$5(y42 y42Var, Type type, w42 w42Var) {
        String asString;
        String asString2;
        ArrayList arrayList = new ArrayList(2);
        y42Var.getClass();
        if (y42Var instanceof q42) {
            q42 q42Var = (q42) y42Var;
            if (q42Var.b.size() == 2) {
                asString2 = getAsString(q42Var.e(0));
                asString = getAsString(q42Var.e(1));
            }
            return null;
        }
        if (y42Var instanceof g62) {
            g62 g62VarC = y42Var.c();
            asString2 = getAsString(g62VarC.h("open"));
            String asString3 = getAsString(g62VarC.h("close"));
            y42 y42VarH = g62VarC.h("notIn");
            if (y42VarH != null && (y42VarH instanceof q42)) {
                Iterator it = ((q42) y42VarH).b.iterator();
                while (it.hasNext()) {
                    String asString4 = getAsString((y42) it.next());
                    if (asString4 != null) {
                        arrayList.add(asString4);
                    }
                }
            }
            asString = asString3;
        } else {
            asString = null;
            asString2 = null;
        }
        if (asString2 != null && asString != null) {
            return new AutoClosingPairConditional(asString2, asString, arrayList);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FoldingRules lambda$load$6(y42 y42Var, Type type, w42 w42Var) {
        g62 g62VarC;
        y42 y42VarH;
        y42Var.getClass();
        if (!(y42Var instanceof g62) || (y42VarH = (g62VarC = y42Var.c()).h("markers")) == null || !(y42VarH instanceof g62)) {
            return null;
        }
        g62 g62VarC2 = y42VarH.c();
        RegExPattern asPattern = getAsPattern(g62VarC2.h("start"));
        RegExPattern asPattern2 = getAsPattern(g62VarC2.h("end"));
        if (asPattern == null || asPattern2 == null) {
            return null;
        }
        return new FoldingRules(getAsBoolean(g62VarC.h("offSide"), false), asPattern, asPattern2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IndentationRules lambda$load$7(y42 y42Var, Type type, w42 w42Var) {
        RegExPattern asPattern;
        y42Var.getClass();
        if (!(y42Var instanceof g62)) {
            return null;
        }
        g62 g62VarC = y42Var.c();
        RegExPattern asPattern2 = getAsPattern(g62VarC.h("decreaseIndentPattern"));
        if (asPattern2 == null || (asPattern = getAsPattern(g62VarC.h("increaseIndentPattern"))) == null) {
            return null;
        }
        return new IndentationRules(asPattern2, asPattern, getAsPattern(g62VarC.h("indentNextLinePattern")), getAsPattern(g62VarC.h("unIndentedLinePattern")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$load$8(AutoClosingPairConditional autoClosingPairConditional) {
        return autoClosingPairConditional == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$load$9(CharacterPair characterPair) {
        return characterPair == null;
    }

    public static LanguageConfiguration load(Reader reader) {
        String strRemoveTrailingCommas = removeTrailingCommas((String) BufferedReaderRetargetClass.lines(new BufferedReader(reader)).collect(Collectors.joining("\n")));
        jq1 jq1Var = new jq1();
        jq1Var.b(String.class, new t82(0));
        int i = 2;
        jq1Var.b(OnEnterRule.class, new t82(2));
        int i2 = 3;
        jq1Var.b(CommentRule.class, new t82(3));
        int i3 = 4;
        jq1Var.b(CharacterPair.class, new t82(4));
        int i4 = 5;
        jq1Var.b(AutoClosingPair.class, new t82(5));
        int i5 = 6;
        jq1Var.b(AutoClosingPairConditional.class, new t82(6));
        jq1Var.b(FoldingRules.class, new t82(7));
        jq1Var.b(IndentationRules.class, new t82(1));
        LanguageConfiguration languageConfiguration = (LanguageConfiguration) jq1Var.a().c(strRemoveTrailingCommas, new bk4(LanguageConfiguration.class));
        List<AutoClosingPairConditional> list = languageConfiguration.autoClosingPairs;
        if (list == null) {
            languageConfiguration.autoClosingPairs = Collections.EMPTY_LIST;
        } else {
            Collection.EL.removeIf(list, new sm(i));
        }
        List<CharacterPair> list2 = languageConfiguration.brackets;
        if (list2 == null) {
            languageConfiguration.brackets = Collections.EMPTY_LIST;
        } else {
            Collection.EL.removeIf(list2, new sm(i2));
        }
        List<OnEnterRule> list3 = languageConfiguration.onEnterRules;
        if (list3 == null) {
            languageConfiguration.onEnterRules = Collections.EMPTY_LIST;
        } else {
            Collection.EL.removeIf(list3, new sm(i3));
        }
        List<AutoClosingPair> list4 = languageConfiguration.surroundingPairs;
        if (list4 == null) {
            languageConfiguration.surroundingPairs = Collections.EMPTY_LIST;
        } else {
            Collection.EL.removeIf(list4, new sm(i4));
        }
        List<CharacterPair> list5 = languageConfiguration.colorizedBracketPairs;
        if (list5 == null) {
            languageConfiguration.colorizedBracketPairs = Collections.EMPTY_LIST;
            return languageConfiguration;
        }
        Collection.EL.removeIf(list5, new sm(i5));
        return languageConfiguration;
    }

    private static String removeTrailingCommas(String str) {
        return str.replaceAll("(,)(\\s*\\n(\\s*\\/\\/.*\\n)*\\s*[\\]}])", "$2");
    }

    public String getAutoCloseBefore() {
        return this.autoCloseBefore;
    }

    public List<AutoClosingPairConditional> getAutoClosingPairs() {
        return this.autoClosingPairs;
    }

    public List<CharacterPair> getBrackets() {
        return this.brackets;
    }

    public List<CharacterPair> getColorizedBracketPairs() {
        return this.colorizedBracketPairs;
    }

    public CommentRule getComments() {
        return this.comments;
    }

    public FoldingRules getFolding() {
        return this.folding;
    }

    public IndentationRules getIndentationRules() {
        return this.indentationRules;
    }

    public List<OnEnterRule> getOnEnterRules() {
        return this.onEnterRules;
    }

    public List<AutoClosingPair> getSurroundingPairs() {
        return this.surroundingPairs;
    }

    public String getWordPattern() {
        return this.wordPattern;
    }
}
