package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xq3 {
    public static final vq3 a = new vq3(4);
    public static final wq3 b = new wq3(2);
    public static final vq3 c = new vq3(5);
    public static final wq3 d = new wq3(3);
    public static final vq3 e = new vq3(6);
    public static final wq3 f = new wq3(4);
    public static final vq3 g = new vq3(7);
    public static final wq3 h = new wq3(5);
    public static final vq3 i = new vq3(8);
    public static final vq3 j = new vq3(0);
    public static final vq3 k = new vq3(1);
    public static final vq3 l = new vq3(2);
    public static final wq3 m = new wq3(0);
    public static final vq3 n = new vq3(3);
    public static final wq3 o = new wq3(1);

    public static boolean a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, k0 k0Var, byte[] bArr3, int i5) {
        ue2 ue2Var = new ue2();
        ue2Var.b = i3;
        int i6 = 0;
        while (i6 < i2) {
            int iT = k0Var.t(i5, bArr2, ue2Var, i4, bArr3);
            if (iT == 1) {
                int i7 = i6 + 1;
                if (bArr[i6] != bArr3[0]) {
                    return false;
                }
                i6 = i7;
            } else {
                int i8 = 0;
                while (iT > 0) {
                    int i9 = i6 + 1;
                    int i10 = i8 + 1;
                    if (bArr[i6] != bArr3[i8]) {
                        return false;
                    }
                    iT--;
                    i6 = i9;
                    i8 = i10;
                }
            }
        }
        return true;
    }
}
