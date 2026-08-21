package j$.util.stream;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l1 implements Supplier {
    public final /* synthetic */ int a;
    public final /* synthetic */ r1 b;

    public /* synthetic */ l1(r1 r1Var, int i) {
        this.a = i;
        this.b = r1Var;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.a) {
            case 0:
                return new o1(this.b);
            default:
                return new p1(this.b);
        }
    }
}
