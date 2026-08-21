package j$.util;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends o implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    private Object writeReplace() {
        return new o(this.b);
    }

    @Override // j$.util.o, java.util.List
    public final java.util.List subList(int i, int i2) {
        return new u(this.b.subList(i, i2));
    }
}
