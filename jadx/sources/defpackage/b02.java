package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b02 {
    public final String a;
    public final String[] b;

    public b02(String str, String... strArr) {
        this.a = str.trim();
        this.b = strArr;
        int i = 0;
        while (true) {
            String[] strArr2 = this.b;
            if (i >= strArr2.length) {
                return;
            }
            strArr2[i] = strArr2[i].trim();
            i++;
        }
    }

    public final String a() {
        String[] strArr = this.b;
        if (strArr.length > 0) {
            return strArr[0];
        }
        xe.q(fw.y(new StringBuilder("IniRecord with key "), this.a, " has no value"));
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b02.class == obj.getClass()) {
            b02 b02Var = (b02) obj;
            if (this.a.equals(b02Var.a) && Arrays.equals(this.b, b02Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + Arrays.hashCode(this.b);
    }
}
