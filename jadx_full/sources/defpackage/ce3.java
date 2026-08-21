package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ce3 extends hy4 {
    public final int b;
    public final int f;

    public ce3(int i, int i2, String str) {
        super(str);
        this.b = i2;
        this.f = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        int i = this.b;
        String str = new String(Character.toChars(i));
        String upperCase = Integer.toHexString(i).toUpperCase();
        String message = getMessage();
        StringBuilder sbE = fw.E("unacceptable code point '", str, "' (0x", upperCase, ") ");
        sbE.append(message);
        sbE.append("\nin \"reader\", position ");
        sbE.append(this.f);
        return sbE.toString();
    }
}
