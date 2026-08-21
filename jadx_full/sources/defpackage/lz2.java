package defpackage;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lz2 implements am1 {
    public boolean b = true;
    public final /* synthetic */ mf3 f;

    public lz2(mf3 mf3Var) {
        this.f = mf3Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        am1 am1Var;
        b80 b80Var = (b80) obj;
        b80Var.getClass();
        if (this.b) {
            this.b = false;
        } else if (b80Var.d.a instanceof ed2) {
            mf3 mf3Var = this.f;
            mf3.q(mf3Var);
            vf vfVar = mf3Var.e;
            vfVar.getClass();
            CopyOnWriteArrayList copyOnWriteArrayList = vfVar.i;
            copyOnWriteArrayList.remove(this);
            if (copyOnWriteArrayList.isEmpty() && (am1Var = (am1) vfVar.h.get()) != null) {
                rf rfVar = vfVar.f;
                rfVar.getClass();
                n02 n02Var = rfVar.e;
                n02Var.getClass();
                ((CopyOnWriteArrayList) ((we0) n02Var.f).f).remove(am1Var);
            }
        }
        return xl4.a;
    }
}
