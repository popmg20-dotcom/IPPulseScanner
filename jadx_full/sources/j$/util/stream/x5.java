package j$.util.stream;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x5 extends f5 {
    public final Comparator b;
    public boolean c;

    public x5(j5 j5Var, Comparator comparator) {
        super(j5Var);
        this.b = comparator;
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final boolean e() {
        this.c = true;
        return false;
    }
}
