package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lf extends ez4 {
    public final /* synthetic */ mf k;

    public lf(mf mfVar) {
        this.k = mfVar;
    }

    @Override // defpackage.ez4
    public final int A() {
        return ((List) this.k.z).size();
    }

    @Override // defpackage.ez4
    public final boolean b(int i, int i2) {
        mf mfVar = this.k;
        Object obj = ((List) mfVar.z).get(i);
        Object obj2 = ((List) mfVar.A).get(i2);
        if (obj != null && obj2 != null) {
            return ((r25) ((of) mfVar.Y).b.z).a(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // defpackage.ez4
    public final boolean c(int i, int i2) {
        mf mfVar = this.k;
        Object obj = ((List) mfVar.z).get(i);
        Object obj2 = ((List) mfVar.A).get(i2);
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : ((r25) ((of) mfVar.Y).b.z).b(obj, obj2);
    }

    @Override // defpackage.ez4
    public final Object w(int i, int i2) {
        mf mfVar = this.k;
        Object obj = ((List) mfVar.z).get(i);
        Object obj2 = ((List) mfVar.A).get(i2);
        if (obj == null || obj2 == null) {
            throw new AssertionError();
        }
        ((r25) ((of) mfVar.Y).b.z).getClass();
        return null;
    }

    @Override // defpackage.ez4
    public final int z() {
        return ((List) this.k.A).size();
    }
}
