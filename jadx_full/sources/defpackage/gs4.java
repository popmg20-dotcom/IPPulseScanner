package defpackage;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gs4 extends ui1 {
    public final String b;
    public int c;

    public gs4(kz kzVar) {
        super(kzVar);
        this.b = "virtual-" + kzVar.d() + "-" + UUID.randomUUID().toString();
    }

    @Override // defpackage.ui1, defpackage.kz
    public final int c() {
        return k(0);
    }

    @Override // defpackage.ui1, defpackage.kz
    public final String d() {
        return this.b;
    }

    @Override // defpackage.ui1, defpackage.kz
    public final int k(int i) {
        return kg4.i(this.a.k(i) - this.c);
    }
}
