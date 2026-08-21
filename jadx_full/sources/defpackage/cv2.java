package defpackage;

import j$.util.Collection;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction;
import org.eclipse.tm4e.languageconfiguration.internal.model.OnEnterRule;
import org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cv2 {
    public static final List c;
    public final List a;
    public final List b;

    static {
        Object[] objArr = {new CharacterPair("(", ")"), new CharacterPair("{", "}"), new CharacterPair("[", "]")};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        c = DesugarCollections.unmodifiableList(arrayList);
    }

    public cv2(List list, List list2) {
        this.a = (List) Collection.EL.stream(list == null ? c : list).filter(new sm(9)).map(new hl(10)).collect(Collectors.toList());
        this.b = list2;
    }

    public final EnterAction a(String str, String str2, String str3) {
        Pattern pattern;
        RegExPattern regExPattern;
        for (OnEnterRule onEnterRule : this.b) {
            if (onEnterRule.beforeText.matchesPartially(str2) && ((regExPattern = onEnterRule.afterText) == null || regExPattern.matchesPartially(str3))) {
                RegExPattern regExPattern2 = onEnterRule.previousLineText;
                if (regExPattern2 == null || regExPattern2.matchesPartially(str)) {
                    return onEnterRule.action;
                }
            }
        }
        boolean zIsEmpty = str2.isEmpty();
        List<bv2> list = this.a;
        if (!zIsEmpty && !str3.isEmpty()) {
            for (bv2 bv2Var : list) {
                Pattern pattern2 = bv2.c;
                Pattern pattern3 = bv2Var.a;
                if (pattern3 != null && pattern3.matcher(str2).find() && (pattern = bv2Var.b) != null && pattern.matcher(str3).find()) {
                    return new EnterAction(EnterAction.IndentAction.IndentOutdent);
                }
            }
        }
        if (str2.isEmpty()) {
            return null;
        }
        for (bv2 bv2Var2 : list) {
            Pattern pattern4 = bv2.c;
            Pattern pattern5 = bv2Var2.a;
            if (pattern5 != null && pattern5.matcher(str2).find()) {
                return new EnterAction(EnterAction.IndentAction.Indent);
            }
        }
        return null;
    }
}
