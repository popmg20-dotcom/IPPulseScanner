package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {
    public final int a;
    public final Object[] b;
    public final t0 c;
    public int d = 0;
    public int e = 0;

    public u0(int i, t0 t0Var) {
        this.a = i;
        this.b = new Object[i];
        this.c = t0Var;
    }

    public final synchronized void a(Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        objArr[i] = obj;
        if (i2 == this.a) {
            this.c.f(this.e, objArr);
        }
    }
}
