package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jq3 {
    public final int[] a;
    public final int[] b;
    public final int[][] c;
    public final int[][] d;
    public final int[][] e;

    public jq3() {
        int[] iArr = new int[64];
        int[] iArr2 = new int[64];
        int[][] iArr3 = new int[32][];
        for (int i = 0; i < 32; i++) {
            iArr3[i] = new int[32];
        }
        int[][] iArr4 = new int[32][];
        for (int i2 = 0; i2 < 32; i2++) {
            iArr4[i2] = new int[32];
        }
        int[][] iArr5 = new int[32][];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr5[i3] = new int[32];
        }
        this.a = iArr;
        this.b = iArr2;
        this.c = iArr3;
        this.d = iArr4;
        this.e = iArr5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!jq3.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        jq3 jq3Var = (jq3) obj;
        return Arrays.equals(this.a, jq3Var.a) && Arrays.equals(this.b, jq3Var.b) && qe.b0(this.c, jq3Var.c) && qe.b0(this.d, jq3Var.d) && qe.b0(this.e, jq3Var.e);
    }

    public final int hashCode() {
        return Arrays.deepHashCode(this.e) + ((Arrays.deepHashCode(this.d) + ((Arrays.deepHashCode(this.c) + ((Arrays.hashCode(this.b) + (Arrays.hashCode(this.a) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String string = Arrays.toString(this.a);
        String string2 = Arrays.toString(this.b);
        String string3 = Arrays.toString(this.c);
        String string4 = Arrays.toString(this.d);
        String string5 = Arrays.toString(this.e);
        StringBuilder sbE = fw.E("Scratch(minWordMatchPosArray=", string, ", maxWordMatchPosArray=", string2, ", diag=");
        ha0.v(sbE, string3, ", table=", string4, ", arrows=");
        return fw.y(sbE, string5, ")");
    }
}
