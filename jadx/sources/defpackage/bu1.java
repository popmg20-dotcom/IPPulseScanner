package defpackage;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class bu1 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ fu1 f;
    public final /* synthetic */ int z;

    public /* synthetic */ bu1(fu1 fu1Var, int i, List list, boolean z) {
        this.b = 2;
        this.f = fu1Var;
        this.z = i;
    }

    private final Object c() {
        fu1 fu1Var = this.f;
        int i = this.z;
        fu1Var.B0.getClass();
        try {
            fu1Var.N0.I(i, t51.CANCEL);
            synchronized (fu1Var) {
                fu1Var.P0.remove(Integer.valueOf(i));
            }
        } catch (IOException unused) {
        }
        return xl4.a;
    }

    private final Object d() {
        fu1 fu1Var = this.f;
        int i = this.z;
        fu1Var.B0.getClass();
        synchronized (fu1Var) {
            fu1Var.P0.remove(Integer.valueOf(i));
        }
        return xl4.a;
    }

    @Override // defpackage.pl1
    public final Object a() {
        switch (this.b) {
            case 0:
                return c();
            case 1:
                return d();
            default:
                fu1 fu1Var = this.f;
                int i = this.z;
                fu1Var.B0.getClass();
                try {
                    fu1Var.N0.I(i, t51.CANCEL);
                    synchronized (fu1Var) {
                        fu1Var.P0.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
                return xl4.a;
        }
    }

    public /* synthetic */ bu1(fu1 fu1Var, int i, Object obj, int i2) {
        this.b = i2;
        this.f = fu1Var;
        this.z = i;
    }
}
