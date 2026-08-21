package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qj2 implements hu2 {
    public final yc2 b;
    public final hu2 f;
    public int z = -1;

    public qj2(yc2 yc2Var, hu2 hu2Var) {
        this.b = yc2Var;
        this.f = hu2Var;
    }

    public final void a() {
        this.b.j(this);
    }

    @Override // defpackage.hu2
    public final void b(Object obj) {
        int i = this.z;
        int i2 = this.b.g;
        if (i != i2) {
            this.z = i2;
            this.f.b(obj);
        }
    }
}
