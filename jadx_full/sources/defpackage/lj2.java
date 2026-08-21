package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lj2 extends z0 {
    public final d8 b;
    public final ArrayList f;
    public final List z;

    public lj2(d8 d8Var, ub2 ub2Var, ArrayList arrayList, kn2 kn2Var) {
        if (kn2Var.b != arrayList.size() + 1) {
            xe.k("Outline progress size is expected to be the cubics size + 1");
            throw null;
        }
        int i = kn2Var.b;
        if (i == 0) {
            e04.h("FloatList is empty.");
            throw null;
        }
        float[] fArr = kn2Var.a;
        int i2 = 0;
        float fB = 0.0f;
        if (fArr[0] != 0.0f) {
            xe.k("First outline progress value is expected to be zero");
            throw null;
        }
        if (i == 0) {
            e04.h("FloatList is empty.");
            throw null;
        }
        if (fArr[i - 1] != 1.0f) {
            xe.k("Last outline progress value is expected to be one");
            throw null;
        }
        this.b = d8Var;
        this.z = ub2Var;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i2 < size) {
            int i3 = i2 + 1;
            if (kn2Var.b(i3) - kn2Var.b(i2) > 1.0E-4f) {
                arrayList2.add(new kj2(this, (hg0) arrayList.get(i2), fB, kn2Var.b(i3)));
                fB = kn2Var.b(i3);
            }
            i2 = i3;
        }
        kj2 kj2Var = (kj2) fw.r(arrayList2, 1);
        float f = kj2Var.c;
        if (1.0f < f) {
            xe.k("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            throw null;
        }
        kj2Var.c = f;
        kj2Var.d = 1.0f;
        this.f = arrayList2;
    }

    @Override // defpackage.g0
    public final int a() {
        return this.f.size();
    }

    @Override // defpackage.g0, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof kj2) {
            return super.contains((kj2) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return (kj2) this.f.get(i);
    }

    @Override // defpackage.z0, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof kj2) {
            return super.indexOf((kj2) obj);
        }
        return -1;
    }

    @Override // defpackage.z0, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof kj2) {
            return super.lastIndexOf((kj2) obj);
        }
        return -1;
    }
}
