package j$.util.stream;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends i0 {
    public static final d0 c;
    public static final d0 d;

    static {
        x6 x6Var = x6.REFERENCE;
        c = new d0(true, x6Var, Optional.empty(), new o(18), new o(19));
        d = new d0(false, x6Var, Optional.empty(), new o(18), new o(19));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return Optional.of(this.b);
        }
        return null;
    }
}
