package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vb1 extends to3 {
    public final HashMap X = new HashMap();

    @Override // defpackage.to3
    public final qo3 a(Object obj) {
        return (qo3) this.X.get(obj);
    }

    @Override // defpackage.to3
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.X.remove(obj);
        return objB;
    }
}
