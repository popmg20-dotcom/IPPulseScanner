package defpackage;

import java.text.ParsePosition;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class kb1 extends mb1 {
    public final int a;

    public kb1(int i) {
        this.a = i;
    }

    @Override // defpackage.mb1
    public final boolean a() {
        return true;
    }

    @Override // defpackage.mb1
    public final boolean b(qb1 qb1Var, Calendar calendar, String str, ParsePosition parsePosition, int i) {
        int index = parsePosition.getIndex();
        int length = str.length();
        if (i == 0) {
            while (index < length && Character.isWhitespace(str.charAt(index))) {
                index++;
            }
            parsePosition.setIndex(index);
        } else {
            int i2 = i + index;
            if (length > i2) {
                length = i2;
            }
        }
        while (index < length && Character.isDigit(str.charAt(index))) {
            index++;
        }
        if (parsePosition.getIndex() == index) {
            parsePosition.setErrorIndex(index);
            return false;
        }
        int i3 = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
        parsePosition.setIndex(index);
        calendar.set(this.a, c(qb1Var, i3));
        return true;
    }

    public int c(qb1 qb1Var, int i) {
        return i;
    }
}
