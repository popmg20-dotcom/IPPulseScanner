package defpackage;

import j$.util.Objects;
import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ci3 extends ez1 {
    public final /* synthetic */ di3 X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci3(di3 di3Var) {
        super(0);
        this.X = di3Var;
    }

    @Override // java.util.List
    public final Object get(int i) {
        di3 di3Var = this.X;
        co4.g(i, di3Var.y0);
        Object[] objArr = di3Var.Z;
        int i2 = i * 2;
        Object obj = objArr[i2];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.X.y0;
    }
}
