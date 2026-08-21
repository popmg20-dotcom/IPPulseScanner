package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o1 implements yr {
    public final String b;

    public o1(String str) {
        this.b = n12.g(str, "No name");
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    public final String toString() {
        return this.b;
    }
}
