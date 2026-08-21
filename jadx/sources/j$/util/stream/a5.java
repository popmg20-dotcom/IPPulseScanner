package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a5 extends b5 {
    @Override // j$.util.stream.a
    public final boolean I() {
        return false;
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream unordered() {
        return !w6.ORDERED.k(this.f) ? this : new x4(this, w6.r);
    }
}
