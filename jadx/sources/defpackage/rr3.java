package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rr3 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public rr3 f;
    public rr3 g;

    public rr3(byte[] bArr, int i, int i2, boolean z) {
        bArr.getClass();
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = false;
    }

    public final rr3 a() {
        rr3 rr3Var = this.f;
        if (rr3Var == this) {
            rr3Var = null;
        }
        rr3 rr3Var2 = this.g;
        rr3Var2.getClass();
        rr3Var2.f = this.f;
        rr3 rr3Var3 = this.f;
        rr3Var3.getClass();
        rr3Var3.g = this.g;
        this.f = null;
        this.g = null;
        return rr3Var;
    }

    public final void b(rr3 rr3Var) {
        rr3Var.getClass();
        rr3Var.g = this;
        rr3Var.f = this.f;
        rr3 rr3Var2 = this.f;
        rr3Var2.getClass();
        rr3Var2.g = rr3Var;
        this.f = rr3Var;
    }

    public final rr3 c() {
        this.d = true;
        return new rr3(this.a, this.b, this.c, true);
    }

    public final void d(rr3 rr3Var, int i) {
        rr3Var.getClass();
        byte[] bArr = rr3Var.a;
        if (!rr3Var.e) {
            xe.q("only owner can write");
            return;
        }
        int i2 = rr3Var.c;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (rr3Var.d) {
                s53.d();
                return;
            }
            int i4 = rr3Var.b;
            if (i3 - i4 > 8192) {
                s53.d();
                return;
            }
            qe.d0(bArr, 0, i4, bArr, i2);
            i2 = rr3Var.c - rr3Var.b;
            rr3Var.c = i2;
            rr3Var.b = 0;
        }
        int i5 = this.b;
        qe.d0(this.a, i2, i5, bArr, i5 + i);
        rr3Var.c += i;
        this.b += i;
    }

    public rr3() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }
}
