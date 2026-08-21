package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kn2 {
    public float[] a;
    public int b;

    public kn2(int i) {
        this.a = i == 0 ? rf1.a : new float[i];
    }

    public static String c(kn2 kn2Var, int i) {
        String str = (i & 2) != 0 ? "" : "[";
        String str2 = (i & 4) == 0 ? "]" : "";
        kn2Var.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        float[] fArr = kn2Var.a;
        int i2 = kn2Var.b;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append((CharSequence) str2);
                break;
            }
            float f = fArr[i3];
            if (i3 == -1) {
                sb.append((CharSequence) "...");
                break;
            }
            if (i3 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append(f);
            i3++;
        }
        return sb.toString();
    }

    public final void a(float f) {
        int i = this.b + 1;
        float[] fArrCopyOf = this.a;
        if (fArrCopyOf.length < i) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, Math.max(i, (fArrCopyOf.length * 3) / 2));
            this.a = fArrCopyOf;
        }
        int i2 = this.b;
        fArrCopyOf[i2] = f;
        this.b = i2 + 1;
    }

    public final float b(int i) {
        if (i >= 0 && i < this.b) {
            return this.a[i];
        }
        s53.k("Index must be between 0 and size");
        return 0.0f;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof kn2) {
            kn2 kn2Var = (kn2) obj;
            int i = kn2Var.b;
            int i2 = this.b;
            if (i == i2) {
                float[] fArr = this.a;
                float[] fArr2 = kn2Var.a;
                b12 b12VarD0 = gb4.d0(0, i2);
                int i3 = b12VarD0.b;
                int i4 = b12VarD0.f;
                if (i3 > i4) {
                    return true;
                }
                while (fArr[i3] == fArr2[i3]) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        float[] fArr = this.a;
        int i = this.b;
        int iFloatToIntBits = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iFloatToIntBits += Float.floatToIntBits(fArr[i2]) * 31;
        }
        return iFloatToIntBits;
    }

    public final String toString() {
        return c(this, 25);
    }
}
