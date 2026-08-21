package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j23 {
    public static final byte[][] a = {"alnum".getBytes(), "alpha".getBytes(), "blank".getBytes(), "cntrl".getBytes(), "digit".getBytes(), "graph".getBytes(), "lower".getBytes(), "print".getBytes(), "punct".getBytes(), "space".getBytes(), "upper".getBytes(), "xdigit".getBytes(), "ascii".getBytes(), "word".getBytes()};
    public static final int[] b = {13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 12};
    public static final du c = new du(19, 1);

    static {
        int i = 0;
        while (true) {
            int[] iArr = b;
            if (i >= iArr.length) {
                return;
            }
            c.h(a[i], Integer.valueOf(iArr[i]));
            i++;
        }
    }
}
