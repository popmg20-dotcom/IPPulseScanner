package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wv2 {
    public final int a;
    public final sv2[] b;

    public wv2(uv2 uv2Var, zv2 zv2Var) {
        this.a = uv2Var.b();
        int iCount = uv2Var.count();
        sv2[] sv2VarArr = new sv2[iCount];
        for (int i = 0; i < iCount; i++) {
            int iC = uv2Var.c(i);
            int iB = zv2Var.b(iC);
            int iB2 = zv2Var.b(uv2Var.a(i) + iC);
            sv2VarArr[i] = (iB == 0 && iB2 == 0) ? sv2.c : new sv2(iB, iB2);
        }
        this.b = sv2VarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wv2)) {
            return false;
        }
        wv2 wv2Var = (wv2) obj;
        return this.a == wv2Var.a && Arrays.equals(this.b, wv2Var.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + ((this.a + 31) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{\n  \"index\": ");
        sb.append(this.a);
        sb.append(",\n  \"captureIndices\": [\n");
        int i = 0;
        for (sv2 sv2Var : this.b) {
            if (i > 0) {
                sb.append(",\n");
            }
            sb.append("    ");
            sb.append(sv2Var);
            i++;
        }
        sb.append("\n  ]\n}");
        return sb.toString();
    }
}
