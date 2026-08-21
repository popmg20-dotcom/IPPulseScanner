package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y1 implements a2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ i2 f;

    public /* synthetic */ y1(g2 g2Var, i2 i2Var) {
        this.b = 1;
        this.f = i2Var;
    }

    @Override // io.sentry.a2
    public final Object a() {
        int i = this.b;
        i2 i2Var = this.f;
        switch (i) {
            case 0:
                return i2Var.q();
            case 1:
                double dNextDouble = i2Var.nextDouble();
                int i2 = (int) dNextDouble;
                return ((double) i2) == dNextDouble ? Integer.valueOf(i2) : Double.valueOf(dNextDouble);
            default:
                return Boolean.valueOf(i2Var.s());
        }
    }

    public /* synthetic */ y1(i2 i2Var, int i) {
        this.b = i;
        this.f = i2Var;
    }
}
