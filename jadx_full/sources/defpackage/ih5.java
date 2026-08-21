package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ih5 extends s15 {
    public final boolean A;
    public final /* synthetic */ ha5 X;
    public final boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih5(ha5 ha5Var, boolean z, boolean z2) {
        super("log");
        this.X = ha5Var;
        this.z = z;
        this.A = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    @Override // defpackage.s15
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d25 j(ih4 ih4Var, List list) {
        int i;
        int i2;
        je.m0("log", 1, list);
        int size = list.size();
        j25 j25Var = d25.q0;
        ha5 ha5Var = this.X;
        if (size == 1) {
            ((rz4) ha5Var.A).d(3, ((e24) ih4Var.b).K(ih4Var, (d25) list.get(0)).h(), Collections.EMPTY_LIST, this.z, this.A);
            return j25Var;
        }
        d25 d25Var = (d25) list.get(0);
        e24 e24Var = (e24) ih4Var.b;
        e24 e24Var2 = (e24) ih4Var.b;
        int iR0 = je.r0(e24Var.K(ih4Var, d25Var).g().doubleValue());
        if (iR0 != 2) {
            i = 3;
            if (iR0 == 3) {
                i2 = 1;
            } else if (iR0 == 5) {
                i2 = 5;
            } else if (iR0 == 6) {
                i2 = 2;
            }
            String strH = e24Var2.K(ih4Var, (d25) list.get(1)).h();
            if (list.size() != 2) {
                ((rz4) ha5Var.A).d(i2, strH, Collections.EMPTY_LIST, this.z, this.A);
                return j25Var;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 2; i3 < Math.min(list.size(), 5); i3++) {
                arrayList.add(e24Var2.K(ih4Var, (d25) list.get(i3)).h());
            }
            ((rz4) ha5Var.A).d(i2, strH, arrayList, this.z, this.A);
            return j25Var;
        }
        i = 4;
        i2 = i;
        String strH2 = e24Var2.K(ih4Var, (d25) list.get(1)).h();
        if (list.size() != 2) {
        }
    }
}
