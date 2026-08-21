package defpackage;

import android.content.res.TypedArray;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w41 implements km3 {
    public final int a;
    public int b;
    public final Object c;
    public final Object d;

    public w41(x41 x41Var, n02 n02Var) {
        this.c = new SparseArray();
        this.d = x41Var;
        TypedArray typedArray = (TypedArray) n02Var.z;
        this.a = typedArray.getResourceId(28, 0);
        this.b = typedArray.getResourceId(53, 0);
    }

    @Override // defpackage.km3
    public boolean hasNext() {
        int i = this.b;
        return i >= 0 && i < ((lw4) this.d).Z.size();
    }

    @Override // defpackage.km3
    public im3 next() {
        im3 im3Var = (im3) this.c;
        lw4 lw4Var = (lw4) this.d;
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        iw4 iw4Var = (iw4) lw4Var.Z.get(this.b);
        im3Var.a = iw4Var.d;
        im3Var.d = iw4Var.a;
        im3Var.e = iw4Var.b;
        List list = iw4Var.c;
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        im3Var.f = list;
        int i = this.b;
        im3Var.b = i <= 0 || ((iw4) lw4Var.Z.get(i - 1)).d != iw4Var.d;
        im3Var.c = this.b + 1 >= lw4Var.Z.size() || ((iw4) lw4Var.Z.get(this.b + 1)).d != iw4Var.d;
        im3Var.g = iw4Var.a(lw4Var.A);
        this.b++;
        return im3Var;
    }

    @Override // defpackage.km3
    public void reset() {
        this.b = this.a;
    }

    public w41(lw4 lw4Var, int i) {
        this.d = lw4Var;
        this.b = i;
        this.a = i;
        this.c = new im3();
    }

    public /* synthetic */ w41(int i, int i2, Serializable serializable, Object obj) {
        this.a = i;
        this.c = serializable;
        this.b = i2;
        this.d = obj;
    }
}
