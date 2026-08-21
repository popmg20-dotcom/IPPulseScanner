package defpackage;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends z0 implements RandomAccess {
    public final z0 b;
    public final int f;
    public final int z;

    public y0(z0 z0Var, int i, int i2) {
        this.b = z0Var;
        this.f = i;
        uf2.g(i, i2, z0Var.a());
        this.z = i2 - i;
    }

    @Override // defpackage.g0
    public final int a() {
        return this.z;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.z;
        if (i < 0 || i >= i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return null;
        }
        return this.b.get(this.f + i);
    }

    @Override // defpackage.z0, java.util.List
    public final List subList(int i, int i2) {
        uf2.g(i, i2, this.z);
        int i3 = this.f;
        return new y0(this.b, i + i3, i3 + i2);
    }
}
