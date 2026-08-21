package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ev1 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final ArrayList f;
    public final List g;
    public final String h;
    public final String i;

    public ev1(String str, String str2, String str3, String str4, int i, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = arrayList;
        this.g = arrayList2;
        this.h = str5;
        this.i = str6;
    }

    public final String a() {
        if (this.c.length() == 0) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return str.substring(p44.u0(str, ':', length, 4) + 1, p44.u0(str, '@', 0, 6));
    }

    public final String b() {
        int length = this.a.length() + 3;
        String str = this.i;
        int iU0 = p44.u0(str, '/', length, 4);
        return str.substring(iU0, hz4.c(iU0, str.length(), str, "?#"));
    }

    public final ArrayList c() {
        int length = this.a.length() + 3;
        String str = this.i;
        int iU0 = p44.u0(str, '/', length, 4);
        int iC = hz4.c(iU0, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iU0 < iC) {
            int i = iU0 + 1;
            int iD = hz4.d(str, '/', i, iC);
            arrayList.add(str.substring(i, iD));
            iU0 = iD;
        }
        return arrayList;
    }

    public final String d() {
        if (this.g == null) {
            return null;
        }
        String str = this.i;
        int iU0 = p44.u0(str, '?', 0, 6) + 1;
        return str.substring(iU0, hz4.d(str, '#', iU0, str.length()));
    }

    public final String e() {
        if (this.b.length() == 0) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return str.substring(length, hz4.c(length, str.length(), str, ":@"));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ev1) && ((ev1) obj).i.equals(this.i);
    }

    public final boolean f() {
        return n12.c(this.a, "https");
    }

    public final dv1 g() {
        dv1 dv1Var = new dv1();
        String str = this.a;
        dv1Var.a = str;
        dv1Var.b = e();
        dv1Var.c = a();
        dv1Var.d = this.d;
        str.getClass();
        int i = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i2 = this.e;
        dv1Var.e = i2 != i ? i2 : -1;
        ArrayList arrayList = dv1Var.f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        String strSubstring = null;
        dv1Var.g = strD != null ? dv1.e(ez4.j(0, 0, 83, strD, " \"'<>#", true)) : null;
        if (this.h != null) {
            String str2 = this.i;
            strSubstring = str2.substring(p44.u0(str2, '#', 0, 6) + 1);
        }
        dv1Var.h = strSubstring;
        return dv1Var;
    }

    public final String h() {
        dv1 dv1Var;
        try {
            dv1Var = new dv1();
            dv1Var.c(this, "/...");
        } catch (IllegalArgumentException unused) {
            dv1Var = null;
        }
        dv1Var.getClass();
        dv1Var.b = ez4.j(0, 0, 123, "", " \"':;<=>@[]^`{}|/\\?#", false);
        dv1Var.c = ez4.j(0, 0, 123, "", " \"':;<=>@[]^`{}|/\\?#", false);
        return dv1Var.a().i;
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    public final URI i() {
        String strReplaceAll;
        dv1 dv1VarG = g();
        ArrayList arrayList = dv1VarG.f;
        String str = dv1VarG.d;
        if (str != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str).replaceAll("");
            strReplaceAll.getClass();
        } else {
            strReplaceAll = null;
        }
        dv1VarG.d = strReplaceAll;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, ez4.j(0, 0, 99, (String) arrayList.get(i), "[]", true));
        }
        ArrayList arrayList2 = dv1VarG.g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = (String) arrayList2.get(i2);
                arrayList2.set(i2, str2 != null ? ez4.j(0, 0, 67, str2, "\\^`{|}", true) : null);
            }
        }
        String str3 = dv1VarG.h;
        dv1VarG.h = str3 != null ? ez4.j(0, 0, 35, str3, " \"#<>\\^`{|}", true) : null;
        String string = dv1VarG.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                patternCompile2.getClass();
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                strReplaceAll2.getClass();
                URI uriCreate = URI.create(strReplaceAll2);
                uriCreate.getClass();
                return uriCreate;
            } catch (Exception unused) {
                vp1.p(e);
                return null;
            }
        }
    }

    public final String toString() {
        return this.i;
    }
}
