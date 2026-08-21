package defpackage;

import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class oh3 {
    public static final Pattern e = Pattern.compile("\\\\(\\d+)");
    public static final Pattern f = Pattern.compile("\\\\(\\d+)");
    public String a;
    public final wn3 b;
    public final boolean c;
    public String[][] d;

    public oh3(String str, wn3 wn3Var) {
        int i;
        if (str.isEmpty()) {
            this.a = str;
        } else {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            while (i2 < length) {
                if (str.charAt(i2) == '\\' && (i = i2 + 1) < length) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == 'z') {
                        sb.append(str.substring(i3, i2));
                        sb.append("$(?!\\n)(?<!\\n)");
                        i3 = i2 + 2;
                    } else if (cCharAt == 'A' || cCharAt == 'G') {
                        z = true;
                    }
                    i2 = i;
                }
                i2++;
            }
            if (i3 == 0) {
                this.a = str;
            } else {
                sb.append(str.substring(i3, length));
                this.a = sb.toString();
            }
            if (z) {
                this.d = a();
            }
        }
        this.b = wn3Var;
        this.c = e.matcher(this.a).find();
    }

    public final String[][] a() {
        int i;
        String str = this.a;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        StringBuilder sb2 = new StringBuilder(length);
        StringBuilder sb3 = new StringBuilder(length);
        StringBuilder sb4 = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            sb.append(cCharAt);
            sb2.append(cCharAt);
            sb3.append(cCharAt);
            sb4.append(cCharAt);
            if (cCharAt == '\\' && (i = i2 + 1) < length) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == 'A') {
                    sb.append((char) 65535);
                    sb2.append((char) 65535);
                    sb3.append('A');
                    sb4.append('A');
                } else if (cCharAt2 == 'G') {
                    sb.append((char) 65535);
                    sb2.append('G');
                    sb3.append((char) 65535);
                    sb4.append('G');
                } else {
                    sb.append(cCharAt2);
                    sb2.append(cCharAt2);
                    sb3.append(cCharAt2);
                    sb4.append(cCharAt2);
                }
                i2 = i;
            }
            i2++;
        }
        return new String[][]{new String[]{sb.toString(), sb2.toString()}, new String[]{sb3.toString(), sb4.toString()}};
    }

    public final String b(CharSequence charSequence, sv2[] sv2VarArr) {
        int i;
        ArrayList arrayList = new ArrayList(sv2VarArr.length);
        int iEnd = 0;
        for (sv2 sv2Var : sv2VarArr) {
            arrayList.add(charSequence.subSequence(sv2Var.a, sv2Var.b).toString());
        }
        String str = this.a;
        Matcher matcher = f.matcher(str);
        matcher.reset();
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            try {
                i = Integer.parseInt(matchResult.group(1));
            } catch (NumberFormatException unused) {
            }
            String strQuoteReplacement = i < sv2VarArr.length ? Matcher.quoteReplacement(vh3.a((CharSequence) arrayList.get(i))) : "";
            sb.append((CharSequence) str, iEnd, matchResult.start());
            sb.append(strQuoteReplacement);
            iEnd = matchResult.end();
        }
        if (sb.length() == 0) {
            return str.toString();
        }
        sb.append((CharSequence) str, iEnd, str.length());
        return sb.toString();
    }

    public final Object clone() {
        return new oh3(this.a, this.b);
    }
}
