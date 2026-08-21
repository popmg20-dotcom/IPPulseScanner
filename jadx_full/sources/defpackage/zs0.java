package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zs0 extends it0 {
    public final it0 A;
    public final bt0[] X;
    public final bt0[] Y;
    public final int Z;
    public final fp0 f;
    public final String z;
    public HashMap y0 = null;
    public ReferenceQueue z0 = null;

    public zs0(fp0 fp0Var, gt0 gt0Var, ws0 ws0Var) throws xs0 {
        bt0[] bt0VarArr;
        if (ws0Var == null) {
            this.A = gt0Var;
        } else {
            this.A = ws0Var;
        }
        this.f = fp0Var;
        this.z = mt0.b(gt0Var, ws0Var, fp0Var.H());
        if (fp0Var.Z.size() == 0) {
            throw new xs0(this, "Enums must contain at least one value.");
        }
        this.X = new bt0[fp0Var.Z.size()];
        int i = 0;
        int i2 = 0;
        while (true) {
            int size = fp0Var.Z.size();
            bt0VarArr = this.X;
            if (i2 >= size) {
                break;
            }
            bt0VarArr[i2] = new bt0((lp0) fp0Var.Z.get(i2), this, i2);
            i2++;
        }
        bt0[] bt0VarArr2 = (bt0[]) bt0VarArr.clone();
        this.Y = bt0VarArr2;
        Arrays.sort(bt0VarArr2, bt0.Z);
        for (int i3 = 1; i3 < fp0Var.Z.size(); i3++) {
            bt0[] bt0VarArr3 = this.Y;
            bt0 bt0Var = bt0VarArr3[i];
            bt0 bt0Var2 = bt0VarArr3[i3];
            if (bt0Var.z.Z != bt0Var2.z.Z) {
                i++;
                bt0VarArr3[i] = bt0Var2;
            }
        }
        int i4 = i + 1;
        this.Z = i4;
        Arrays.fill(this.Y, i4, fp0Var.Z.size(), (Object) null);
        gt0Var.z0.e(this);
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.A.c();
    }

    @Override // defpackage.it0
    public final String d() {
        return this.z;
    }

    @Override // defpackage.it0
    public final it0 e() {
        return this.A;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.f.H();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.f;
    }

    public final bt0 j(int i) {
        bt0 bt0Var;
        bt0 bt0Var2 = (bt0) mt0.a(this.Y, this.Z, bt0.y0, i);
        if (bt0Var2 != null) {
            return bt0Var2;
        }
        synchronized (this) {
            try {
                if (this.z0 == null) {
                    this.z0 = new ReferenceQueue();
                    this.y0 = new HashMap();
                } else {
                    while (true) {
                        ys0 ys0Var = (ys0) this.z0.poll();
                        if (ys0Var == null) {
                            break;
                        }
                        this.y0.remove(Integer.valueOf(ys0Var.a));
                    }
                }
                WeakReference weakReference = (WeakReference) this.y0.get(Integer.valueOf(i));
                bt0Var = weakReference == null ? null : (bt0) weakReference.get();
                if (bt0Var == null) {
                    bt0Var = new bt0(this, Integer.valueOf(i));
                    this.y0.put(Integer.valueOf(i), new ys0(i, bt0Var));
                }
            } finally {
            }
        }
        return bt0Var;
    }

    public final void k() {
        g(this.f.J().K());
        for (bt0 bt0Var : this.X) {
            bt0Var.g(bt0Var.z.J().L());
        }
    }
}
