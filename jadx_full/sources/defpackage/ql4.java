package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ql4 {
    public static final int[][] a;
    public static final sl4[] b;
    public static final int[][] c;
    public static final sl4[] d;
    public static final du e;

    static {
        Object[] objArrP = tl4.P(2, "CaseUnfold_12");
        int[][] iArr = (int[][]) objArrP[0];
        a = iArr;
        b = (sl4[]) objArrP[1];
        Object[] objArrP2 = tl4.P(2, "CaseUnfold_12_Locale");
        int[][] iArr2 = (int[][]) objArrP2[0];
        c = iArr2;
        d = (sl4[]) objArrP2[1];
        du duVar = new du(iArr.length + iArr2.length, 2);
        for (int i = 0; i < iArr.length; i++) {
            duVar.k(iArr[i], b[i]);
        }
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            duVar.k(iArr2[i2], d[i2]);
        }
        e = duVar;
    }
}
