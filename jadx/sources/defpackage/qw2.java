package defpackage;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qw2 extends z0 implements RandomAccess {
    public final bu[] b;
    public final int[] f;

    public qw2(bu[] buVarArr, int[] iArr) {
        this.b = buVarArr;
        this.f = iArr;
    }

    @Override // defpackage.g0
    public final int a() {
        return this.b.length;
    }

    @Override // defpackage.g0, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof bu) {
            return super.contains((bu) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.b[i];
    }

    @Override // defpackage.z0, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof bu) {
            return super.indexOf((bu) obj);
        }
        return -1;
    }

    @Override // defpackage.z0, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof bu) {
            return super.lastIndexOf((bu) obj);
        }
        return -1;
    }
}
