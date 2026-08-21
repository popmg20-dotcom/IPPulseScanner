package defpackage;

import j$.util.Optional;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class q03 implements r53 {
    public final /* synthetic */ int a;
    public final nn b;
    public final /* synthetic */ s03 c;

    public /* synthetic */ q03(s03 s03Var, nn nnVar, int i) {
        this.a = i;
        this.c = s03Var;
        this.b = nnVar;
    }

    @Override // defpackage.r53
    public final x51 a() {
        int i = this.a;
        s03 s03Var = this.c;
        nn nnVar = this.b;
        int i2 = 0;
        int i3 = 1;
        int i4 = 4;
        switch (i) {
            case 0:
                aq3 aq3Var = s03Var.b;
                if (aq3Var.c(20)) {
                    s03Var.Y = Optional.of(new q03(s03Var, nnVar, i2));
                } else if (!aq3Var.d(4, 3)) {
                    s03Var.z.c(new o03(s03Var, i4));
                    HashMap map = s03.y0;
                } else {
                    s03Var.Y = Optional.of(new o03(s03Var, i4));
                }
                break;
            default:
                aq3 aq3Var2 = s03Var.b;
                if (!aq3Var2.c(20)) {
                    int i5 = 18;
                    if (!aq3Var2.d(4, 15, 21, 3)) {
                        s03Var.z.c(new o03(s03Var, i5));
                        HashMap map2 = s03.y0;
                    } else {
                        s03Var.Y = Optional.of(new o03(s03Var, i5));
                    }
                } else {
                    s03Var.Y = Optional.of(new q03(s03Var, nnVar, i3));
                }
                break;
        }
        return s03.f(nnVar.b);
    }
}
