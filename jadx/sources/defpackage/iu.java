package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class iu extends es2 {
    public final int a;
    public final boolean b;
    public final boolean c;

    public iu(int i, boolean z, boolean z2) {
        super(2);
        this.a = i;
        this.b = z;
        this.c = z2;
    }

    @Override // defpackage.es2
    public final String getName() {
        return "Character Type";
    }

    @Override // defpackage.es2
    public final String toString(int i) {
        StringBuilder sb = new StringBuilder("\n  ctype: " + this.a);
        sb.append(", not: " + this.b);
        sb.append(", ascii: " + this.c);
        return sb.toString();
    }
}
