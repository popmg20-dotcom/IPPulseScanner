package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class b13 extends ul4 {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final boolean[] b;

    public b13() {
        if ("-_.!~*'()@:$&,;=[]/".matches(".*[0-9A-Za-z].*")) {
            xe.k("Alphanumeric characters are always 'safe' and should not be explicitly specified");
            throw null;
        }
        char[] charArray = "-_.!~*'()@:$&,;=[]/".toCharArray();
        int iMax = 122;
        for (char c2 : charArray) {
            iMax = Math.max((int) c2, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            zArr[i2] = true;
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            zArr[i3] = true;
        }
        for (char c3 : charArray) {
            zArr[c3] = true;
        }
        this.b = zArr;
    }
}
