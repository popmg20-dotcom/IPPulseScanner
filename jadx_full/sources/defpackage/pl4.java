package defpackage;

import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pl4 {
    public static final int[] a;
    public static final sl4[] b;
    public static final int[] c;
    public static final sl4[] d;
    public static final du e;

    static {
        Object[] objArrA = a("CaseUnfold_11");
        int[] iArr = (int[]) objArrA[0];
        a = iArr;
        b = (sl4[]) objArrA[1];
        Object[] objArrA2 = a("CaseUnfold_11_Locale");
        int[] iArr2 = (int[]) objArrA2[0];
        c = iArr2;
        d = (sl4[]) objArrA2[1];
        du duVar = new du(iArr.length + iArr2.length, 3);
        for (int i = 0; i < iArr.length; i++) {
            duVar.i(iArr[i], b[i]);
        }
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            duVar.i(iArr2[i2], d[i2]);
        }
        e = duVar;
    }

    public static Object[] a(String str) {
        try {
            DataInputStream dataInputStreamQ = je.Q(str);
            int i = dataInputStreamQ.readInt();
            int[] iArr = new int[i];
            sl4[] sl4VarArr = new sl4[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = dataInputStreamQ.readInt();
                sl4VarArr[i2] = new sl4(dataInputStreamQ);
            }
            dataInputStreamQ.close();
            return new Object[]{iArr, sl4VarArr};
        } catch (IOException e2) {
            vp1.p(e2);
            return null;
        }
    }
}
