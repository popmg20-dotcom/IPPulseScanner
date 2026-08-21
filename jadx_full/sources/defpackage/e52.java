package defpackage;

import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e52 implements Serializable {
    public static final e52 y0 = new e52();
    public final String A;
    public final Boolean X;
    public final c52 Y;
    public transient TimeZone Z;
    public final String b;
    public final d52 f;
    public final Locale z;

    public e52(String str, d52 d52Var, String str2, String str3, c52 c52Var, Boolean bool) {
        this(str, d52Var, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, c52Var, bool);
    }

    public static boolean a(Object obj, Serializable serializable) {
        if (obj == null) {
            return serializable == null;
        }
        if (serializable == null) {
            return false;
        }
        return obj.equals(serializable);
    }

    public final Boolean b(b52 b52Var) {
        c52 c52Var = this.Y;
        c52Var.getClass();
        int iOrdinal = 1 << b52Var.ordinal();
        if ((c52Var.b & iOrdinal) != 0) {
            return Boolean.FALSE;
        }
        if ((c52Var.a & iOrdinal) != 0) {
            return Boolean.TRUE;
        }
        return null;
    }

    public final boolean c() {
        if (this.Z != null) {
            return true;
        }
        String str = this.A;
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0054 A[PHI: r1
      0x0054: PHI (r1v2 c52) = (r1v1 c52), (r1v3 c52), (r1v1 c52), (r1v1 c52) binds: [B:26:0x0037, B:40:0x0056, B:38:0x0052, B:30:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e52 d(e52 e52Var) {
        e52 e52Var2;
        if (e52Var == null || e52Var == (e52Var2 = y0) || e52Var == this) {
            return this;
        }
        if (this == e52Var2) {
            return e52Var;
        }
        String str = e52Var.b;
        if (str == null || str.isEmpty()) {
            str = this.b;
        }
        String str2 = str;
        d52 d52Var = e52Var.f;
        if (d52Var == d52.b) {
            d52Var = this.f;
        }
        d52 d52Var2 = d52Var;
        Locale locale = e52Var.z;
        if (locale == null) {
            locale = this.z;
        }
        Locale locale2 = locale;
        c52 c52Var = e52Var.Y;
        c52 c52Var2 = this.Y;
        if (c52Var2 != null) {
            int i = c52Var2.b;
            if (c52Var == null) {
                c52Var = c52Var2;
            } else {
                int i2 = c52Var.b;
                int i3 = c52Var.a;
                if (i2 != 0 || i3 != 0) {
                    int i4 = c52Var2.a;
                    if (i4 != 0 || i != 0) {
                        int i5 = ((~i2) & i4) | i3;
                        int i6 = i2 | ((~i3) & i);
                        if (i5 != i4 || i6 != i) {
                            c52Var2 = new c52(i5, i6);
                        }
                        c52Var = c52Var2;
                    }
                }
            }
        }
        c52 c52Var3 = c52Var;
        Boolean bool = e52Var.X;
        if (bool == null) {
            bool = this.X;
        }
        Boolean bool2 = bool;
        String str3 = e52Var.A;
        if (str3 == null || str3.isEmpty()) {
            str3 = this.A;
        } else {
            this = e52Var;
        }
        return new e52(str2, d52Var2, locale2, str3, this.Z, c52Var3, bool2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != e52.class) {
            return false;
        }
        e52 e52Var = (e52) obj;
        return this.f == e52Var.f && this.Y.equals(e52Var.Y) && a(this.X, e52Var.X) && a(this.A, e52Var.A) && a(this.b, e52Var.b) && a(this.Z, e52Var.Z) && a(this.z, e52Var.z);
    }

    public final int hashCode() {
        String str = this.A;
        int iHashCode = str == null ? 1 : str.hashCode();
        String str2 = this.b;
        if (str2 != null) {
            iHashCode ^= str2.hashCode();
        }
        int iHashCode2 = this.f.hashCode() + iHashCode;
        Boolean bool = this.X;
        if (bool != null) {
            iHashCode2 ^= bool.hashCode();
        }
        Locale locale = this.z;
        if (locale != null) {
            iHashCode2 += locale.hashCode();
        }
        return this.Y.hashCode() ^ iHashCode2;
    }

    public final String toString() {
        return "JsonFormat.Value(pattern=" + this.b + ",shape=" + this.f + ",lenient=" + this.X + ",locale=" + this.z + ",timezone=" + this.A + ",features=" + this.Y + ")";
    }

    public e52() {
        this("", d52.b, "", "", c52.c, null);
    }

    public e52(String str, d52 d52Var, Locale locale, String str2, TimeZone timeZone, c52 c52Var, Boolean bool) {
        this.b = str == null ? "" : str;
        this.f = d52Var == null ? d52.b : d52Var;
        this.z = locale;
        this.Z = timeZone;
        this.A = str2;
        this.Y = c52Var == null ? c52.c : c52Var;
        this.X = bool;
    }
}
