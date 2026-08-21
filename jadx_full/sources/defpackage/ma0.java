package defpackage;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ma0 implements Serializable {
    public final /* synthetic */ int b;
    public Serializable f;

    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Serializable, java.util.regex.Pattern[]] */
    public ma0(String str) {
        this.b = 1;
        String[] strArr = {str};
        this.f = new Pattern[1];
        for (int i = 0; i < 1; i++) {
            String str2 = strArr[i];
            if (str2 == null || str2.isEmpty()) {
                xe.k(ha0.k("Regular expression[", i, "] is missing"));
                throw null;
            }
            ((Pattern[]) this.f)[i] = Pattern.compile(str2, 0);
        }
    }

    public String[] a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        for (Pattern pattern : (Pattern[]) this.f) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                int iGroupCount = matcher.groupCount();
                String[] strArr = new String[iGroupCount];
                while (i < iGroupCount) {
                    int i2 = i + 1;
                    strArr[i] = matcher.group(i2);
                    i = i2;
                }
                return strArr;
            }
        }
        return null;
    }

    public String toString() {
        switch (this.b) {
            case 1:
                Pattern[] patternArr = (Pattern[]) this.f;
                StringBuilder sb = new StringBuilder("RegexValidator{");
                for (int i = 0; i < patternArr.length; i++) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(patternArr[i].pattern());
                }
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }
}
