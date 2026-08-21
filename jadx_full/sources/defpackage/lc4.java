package defpackage;

import android.graphics.Canvas;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lc4 implements sc4 {
    public float a = 0.0f;
    public boolean b = true;
    public final /* synthetic */ Canvas c;
    public final /* synthetic */ pc4 d;
    public final /* synthetic */ float e;
    public final /* synthetic */ uc4 f;

    public lc4(uc4 uc4Var, Canvas canvas, pc4 pc4Var, float f) {
        this.f = uc4Var;
        this.c = canvas;
        this.d = pc4Var;
        this.e = f;
    }

    @Override // defpackage.sc4
    public final boolean a(ArrayList arrayList, boolean z, hm2 hm2Var) {
        float fH = this.a + this.f.h(arrayList, z, hm2Var, this.c, this.a, this.d);
        this.a = fH;
        boolean z2 = fH < this.e;
        this.b = z2;
        return z2;
    }
}
