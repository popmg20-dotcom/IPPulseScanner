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
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.e52 d(defpackage.e52 r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L7c
            e52 r0 = defpackage.e52.y0
            if (r10 == r0) goto L7c
            if (r10 != r9) goto La
            goto L7c
        La:
            if (r9 != r0) goto Ld
            return r10
        Ld:
            java.lang.String r0 = r10.b
            if (r0 == 0) goto L1a
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L18
            goto L1a
        L18:
            r2 = r0
            goto L1d
        L1a:
            java.lang.String r0 = r9.b
            goto L18
        L1d:
            d52 r0 = r10.f
            d52 r1 = defpackage.d52.b
            if (r0 != r1) goto L25
            d52 r0 = r9.f
        L25:
            r3 = r0
            java.util.Locale r0 = r10.z
            if (r0 != 0) goto L2c
            java.util.Locale r0 = r9.z
        L2c:
            r4 = r0
            c52 r0 = r10.Y
            c52 r1 = r9.Y
            if (r1 != 0) goto L35
        L33:
            r7 = r0
            goto L5c
        L35:
            int r5 = r1.b
            if (r0 != 0) goto L3a
            goto L54
        L3a:
            int r6 = r0.b
            int r7 = r0.a
            if (r6 != 0) goto L43
            if (r7 != 0) goto L43
            goto L54
        L43:
            int r8 = r1.a
            if (r8 != 0) goto L4a
            if (r5 != 0) goto L4a
            goto L33
        L4a:
            int r0 = ~r6
            r0 = r0 & r8
            r0 = r0 | r7
            int r7 = ~r7
            r7 = r7 & r5
            r6 = r6 | r7
            if (r0 != r8) goto L56
            if (r6 != r5) goto L56
        L54:
            r0 = r1
            goto L33
        L56:
            c52 r1 = new c52
            r1.<init>(r0, r6)
            goto L54
        L5c:
            java.lang.Boolean r0 = r10.X
            if (r0 != 0) goto L62
            java.lang.Boolean r0 = r9.X
        L62:
            r8 = r0
            java.lang.String r0 = r10.A
            if (r0 == 0) goto L71
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L6e
            goto L71
        L6e:
            r9 = r10
        L6f:
            r5 = r0
            goto L74
        L71:
            java.lang.String r0 = r9.A
            goto L6f
        L74:
            java.util.TimeZone r6 = r9.Z
            e52 r1 = new e52
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r1
        L7c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e52.d(e52):e52");
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
