package defpackage;

import com.getsurfboard.backup.model.SettingValue;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ka4 {
    public final String a;
    public final String b;
    public final boolean c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;

    public ka4(String str, String str2, boolean z, int i, String str3, int i2) {
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = i;
        this.e = str3;
        this.f = i2;
        String upperCase = str2.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        this.g = p44.o0(upperCase, SettingValue.TYPE_INT, false) ? 3 : (p44.o0(upperCase, "CHAR", false) || p44.o0(upperCase, "CLOB", false) || p44.o0(upperCase, "TEXT", false)) ? 2 : p44.o0(upperCase, "BLOB", false) ? 5 : (p44.o0(upperCase, "REAL", false) || p44.o0(upperCase, "FLOA", false) || p44.o0(upperCase, "DOUB", false)) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ka4) {
                boolean z = this.d > 0;
                ka4 ka4Var = (ka4) obj;
                int i = ka4Var.f;
                if (z == (ka4Var.d > 0) && n12.c(this.a, ka4Var.a) && this.c == ka4Var.c) {
                    String str = ka4Var.e;
                    int i2 = this.f;
                    String str2 = this.e;
                    if ((i2 != 1 || i != 2 || str2 == null || r25.r(str2, str)) && ((i2 != 2 || i != 1 || str == null || r25.r(str, str2)) && ((i2 == 0 || i2 != i || (str2 == null ? str == null : r25.r(str2, str))) && this.g == ka4Var.g))) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.g) * 31) + (this.c ? 1231 : 1237)) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(this.a);
        sb.append("',\n            |   type = '");
        sb.append(this.b);
        sb.append("',\n            |   affinity = '");
        sb.append(this.g);
        sb.append("',\n            |   notNull = '");
        sb.append(this.c);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(this.d);
        sb.append("',\n            |   defaultValue = '");
        String str = this.e;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return q44.a0(q44.c0(sb.toString()));
    }
}
