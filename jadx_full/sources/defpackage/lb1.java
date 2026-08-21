package defpackage;

import java.text.ParsePosition;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class lb1 extends mb1 {
    public Pattern a;

    @Override // defpackage.mb1
    public final boolean a() {
        return false;
    }

    @Override // defpackage.mb1
    public final boolean b(qb1 qb1Var, Calendar calendar, String str, ParsePosition parsePosition, int i) {
        Matcher matcher = this.a.matcher(str.substring(parsePosition.getIndex()));
        if (!matcher.lookingAt()) {
            parsePosition.setErrorIndex(parsePosition.getIndex());
            return false;
        }
        parsePosition.setIndex(matcher.end(1) + parsePosition.getIndex());
        c(calendar, matcher.group(1));
        return true;
    }

    public abstract void c(Calendar calendar, String str);
}
