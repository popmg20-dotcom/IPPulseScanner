package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iu2 {
    public final v12 a;
    public final int[] b;
    public final String[] c;
    public final Set d;

    public iu2(v12 v12Var, int[] iArr, String[] strArr) {
        v12Var.getClass();
        iArr.getClass();
        strArr.getClass();
        this.a = v12Var;
        this.b = iArr;
        this.c = strArr;
        if (iArr.length == strArr.length) {
            this.d = !(strArr.length == 0) ? yr2.k0(strArr[0]) : k41.b;
        } else {
            xe.q("Check failed.");
            throw null;
        }
    }
}
