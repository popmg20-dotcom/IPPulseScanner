package j$.time.format;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements e {
    public final String a;

    public m(String str) {
        this.a = str;
    }

    @Override // j$.time.format.e
    public final boolean h(r rVar, StringBuilder sb) {
        sb.append(this.a);
        return true;
    }

    @Override // j$.time.format.e
    public final int i(p pVar, CharSequence charSequence, int i) {
        if (i > charSequence.length() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.a;
        return !pVar.g(charSequence, i, str, 0, str.length()) ? ~i : str.length() + i;
    }

    public final String toString() {
        return "'" + this.a.replace("'", "''") + "'";
    }
}
