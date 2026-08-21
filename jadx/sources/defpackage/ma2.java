package defpackage;

import android.util.SparseArray;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ma2 implements km3 {
    public final ld0 a;
    public final im3 b;
    public final int c;
    public final SparseArray d;
    public int e;
    public final v0 f;

    public ma2(v0 v0Var, ld0 ld0Var, int i, SparseArray sparseArray) {
        this.e = i;
        this.c = i;
        im3 im3Var = new im3();
        this.b = im3Var;
        this.a = ld0Var;
        this.f = v0Var;
        im3Var.b = true;
        im3Var.c = true;
        im3Var.d = 0;
        this.d = sparseArray;
    }

    @Override // defpackage.km3
    public final boolean hasNext() {
        int i = this.e;
        return i >= 0 && i < this.a.b.size();
    }

    @Override // defpackage.km3
    public final im3 next() {
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        int i = this.e;
        im3 im3Var = this.b;
        im3Var.a = i;
        SparseArray sparseArray = this.d;
        ud0 ud0VarO = sparseArray != null ? (ud0) sparseArray.get(i) : null;
        if (ud0VarO == null) {
            ud0VarO = this.a.o(this.e);
        }
        im3Var.e = ud0VarO.f;
        this.f.c();
        im3Var.f = Collections.EMPTY_LIST;
        this.e++;
        return im3Var;
    }

    @Override // defpackage.km3
    public final void reset() {
        this.e = this.c;
    }
}
