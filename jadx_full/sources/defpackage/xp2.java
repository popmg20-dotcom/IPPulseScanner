package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xp2 {
    public iv1 a;
    public boolean b;

    public final void a() {
        iv1 iv1Var = this.a;
        if (iv1Var == null) {
            xe.q("This input is not added to any dispatcher.");
            return;
        }
        if (!this.b) {
            iv1Var.i(this, null);
        }
        yp2 yp2Var = (yp2) iv1Var.z;
        jd jdVar = (jd) iv1Var.f;
        if (equals(yp2Var.h) && -1 == yp2Var.g) {
            qu2 qu2VarC = yp2Var.f;
            if (qu2VarC == null) {
                qu2VarC = yp2Var.c(-1);
            }
            yp2Var.f = null;
            yp2Var.g = 0;
            yp2Var.h = null;
            if (qu2VarC == null) {
                ((wu2) jdVar.f).a.run();
            } else {
                qu2VarC.d.b();
            }
            yp2Var.a.j(null, zp2.Z);
        }
        this.b = false;
    }

    public void b(boolean z) {
    }
}
