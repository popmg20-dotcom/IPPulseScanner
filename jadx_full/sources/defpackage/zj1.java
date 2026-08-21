package defpackage;

import androidx.fragment.app.o;
import androidx.fragment.app.u;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zj1 implements yj1 {
    public final int a;
    public final int b;
    public final /* synthetic */ u c;

    public zj1(u uVar, int i, int i2) {
        this.c = uVar;
        this.a = i;
        this.b = i2;
    }

    @Override // defpackage.yj1
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        u uVar = this.c;
        o oVar = uVar.A;
        int i = this.a;
        if (oVar == null || i >= 0 || !oVar.getChildFragmentManager().V(-1, 0)) {
            return uVar.W(arrayList, arrayList2, i, this.b);
        }
        return false;
    }
}
