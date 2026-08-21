package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class up3 {
    public int a;
    public final int b;
    public final k0 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public qt i;
    public int j;
    public int k;
    public m41[] l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;

    public up3(th3 th3Var) {
        this.a = th3Var.q;
        this.b = th3Var.r;
        this.c = th3Var.p;
    }

    public final int a() {
        int i = this.j;
        if (i >= ja0.v) {
            throw new l12("too many capture groups are specified");
        }
        int i2 = i + 1;
        this.j = i2;
        if (i == 0) {
            this.l = new m41[ja0.d];
        } else {
            m41[] m41VarArr = this.l;
            if (i2 >= m41VarArr.length) {
                m41[] m41VarArr2 = new m41[m41VarArr.length << 1];
                System.arraycopy(m41VarArr, 0, m41VarArr2, 0, m41VarArr.length);
                this.l = m41VarArr2;
            }
        }
        return this.j;
    }

    public final void b() {
        if (((-2019556389) & 67108864) != 0) {
            int i = this.q;
            if ((i & 67108864) == 0) {
                this.q = i | 67108864;
            }
        }
    }
}
