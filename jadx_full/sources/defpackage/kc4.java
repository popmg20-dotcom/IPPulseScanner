package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kc4 implements sc4 {
    public float a = 0.0f;
    public final /* synthetic */ pc4 b;
    public final /* synthetic */ uc4 c;

    public kc4(uc4 uc4Var, pc4 pc4Var) {
        this.c = uc4Var;
        this.b = pc4Var;
    }

    @Override // defpackage.sc4
    public final boolean a(ArrayList arrayList, boolean z, hm2 hm2Var) {
        float f = this.a;
        uc4 uc4Var = this.c;
        pc4 pc4Var = this.b;
        this.a += uc4Var.h(arrayList, z, hm2Var, null, f, pc4Var);
        return pc4Var.c != 0.0f;
    }
}
