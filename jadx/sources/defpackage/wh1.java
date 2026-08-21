package defpackage;

import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wh1 {
    public final SparseIntArray a;
    public final SparseIntArray b;

    public wh1(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) throws Exception {
        if (sparseIntArray.size() != sparseIntArray2.size() || sparseIntArray.size() > 65535) {
            throw new Exception("invalid startIndexes or endIndexes size");
        }
        this.a = sparseIntArray;
        this.b = sparseIntArray2;
    }

    public static int a(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        return i3 + 1 > i2 ? i4 + 1 : i4;
    }

    public void b() {
        this.a.clear();
    }

    public wh1() {
        this.a = new SparseIntArray();
        this.b = new SparseIntArray();
    }
}
