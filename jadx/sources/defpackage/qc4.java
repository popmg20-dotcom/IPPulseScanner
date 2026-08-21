package defpackage;

import android.graphics.Canvas;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qc4 implements sc4 {
    public float a = 0.0f;
    public final pc4 b;
    public Canvas c;
    public final /* synthetic */ uc4 d;

    public qc4(uc4 uc4Var, pc4 pc4Var) {
        this.d = uc4Var;
        this.b = pc4Var;
    }

    @Override // defpackage.sc4
    public final boolean a(ArrayList arrayList, boolean z, hm2 hm2Var) {
        float f = this.a;
        float fH = f + this.d.h(arrayList, z, hm2Var, this.c, f, this.b);
        this.a = fH;
        return fH < this.b.c;
    }
}
