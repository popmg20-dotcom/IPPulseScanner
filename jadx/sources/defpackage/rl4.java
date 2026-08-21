package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class rl4 {
    public static final int[][] a;
    public static final sl4[] b;
    public static final du c;

    static {
        Object[] objArrP = tl4.P(3, "CaseUnfold_13");
        int[][] iArr = (int[][]) objArrP[0];
        a = iArr;
        b = (sl4[]) objArrP[1];
        du duVar = new du(iArr.length, 2);
        for (int i = 0; i < iArr.length; i++) {
            duVar.k(iArr[i], b[i]);
        }
        c = duVar;
    }
}
