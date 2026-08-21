package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ov extends r24 {
    public final byte[] a;
    public final int b;
    public final int c;
    public int d;
    public m41 e;
    public qt f;

    public ov(int i, int i2, int i3, byte[] bArr) {
        super(10);
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // defpackage.es2
    public final String getName() {
        return "Call";
    }

    @Override // defpackage.es2
    public final void setChild(es2 es2Var) {
        this.e = (m41) es2Var;
    }

    @Override // defpackage.r24, defpackage.es2
    public final String toString(int i) {
        StringBuilder sb = new StringBuilder(super.toString(0));
        int i2 = this.c;
        int i3 = this.b;
        sb.append("\n  name: ".concat(new String(this.a, i3, i2 - i3)));
        sb.append(", groupNum: " + this.d);
        sb.append("\n  unsetAddrList: " + es2.pad(this.f, 1));
        sb.append("\n  target: " + es2.pad(this.e.getAddressName(), 1));
        return sb.toString();
    }
}
