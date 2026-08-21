package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yi3 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ long f;
    public final /* synthetic */ Object z;

    public yi3(yb5 yb5Var, rb5 rb5Var, long j) {
        this.z = rb5Var;
        this.f = j;
        Objects.requireNonNull(yb5Var);
        this.A = yb5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        long j = this.f;
        Object obj = this.z;
        Object obj2 = this.A;
        switch (i) {
            case 0:
                aj3 aj3Var = (aj3) obj2;
                ps4 ps4Var = aj3Var.b;
                ps4Var.a(j, (String) obj);
                ps4Var.b(aj3Var.toString());
                break;
            default:
                yb5 yb5Var = (yb5) obj2;
                yb5Var.Z0((rb5) obj, false, j);
                yb5Var.y0 = null;
                dd5 dd5VarJ = ((k85) yb5Var.f).j();
                dd5VarJ.V0();
                dd5VarJ.W0();
                dd5VarJ.j1(new um1(dd5VarJ, (rb5) null));
                break;
        }
    }

    public yi3(aj3 aj3Var, String str, long j) {
        this.A = aj3Var;
        this.z = str;
        this.f = j;
    }
}
