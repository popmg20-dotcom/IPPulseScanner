package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum uv1 {
    SENSITIVE(true, 0),
    /* JADX INFO: Fake field, exist only in values array */
    INSENSITIVE(false, 1),
    /* JADX INFO: Fake field, exist only in values array */
    SYSTEM(fe1.f.b, 2);

    public final String b;
    public final transient boolean f;

    uv1(boolean z, int i) {
        this.b = str;
        this.f = z;
    }

    public final int a(String str, int i, String str2) {
        int length;
        if (str == null || str2 == null || (length = str.length() - str2.length()) < i) {
            return -1;
        }
        int i2 = i;
        while (i2 <= length) {
            String str3 = str;
            String str4 = str2;
            if (str3.regionMatches(!this.f, i2, str4, 0, str2.length())) {
                return i2;
            }
            i2++;
            str = str3;
            str2 = str4;
        }
        return -1;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
