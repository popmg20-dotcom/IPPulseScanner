package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class no2 extends po2 implements Serializable {
    public final po2 f;
    public final po2 z;

    public no2(po2 po2Var, po2 po2Var2) {
        this.f = po2Var;
        this.z = po2Var2;
    }

    @Override // defpackage.po2
    public final String a(String str) {
        return this.f.a(this.z.a(str));
    }

    public final String toString() {
        return "[ChainedTransformer(" + this.f + ", " + this.z + ")]";
    }
}
