package j$.time.format;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends k {
    @Override // j$.time.format.k
    public final boolean b(char c, char c2) {
        return p.b(c, c2);
    }

    @Override // j$.time.format.k
    public final k d(String str, String str2, k kVar) {
        return new j(str, str2, kVar);
    }

    @Override // j$.time.format.k
    public final boolean e(CharSequence charSequence, int i, int i2) {
        int length = this.a.length();
        if (length > i2 - i) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i5 = i3 + 1;
            int i6 = i + 1;
            if (!p.b(this.a.charAt(i3), charSequence.charAt(i))) {
                return false;
            }
            i = i6;
            length = i4;
            i3 = i5;
        }
    }
}
