package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m22 extends hm4 {
    public final Object f;
    public boolean z;

    public m22(Object obj) {
        super(0);
        this.f = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.z;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.z) {
            vp1.g();
            return null;
        }
        this.z = true;
        return this.f;
    }
}
