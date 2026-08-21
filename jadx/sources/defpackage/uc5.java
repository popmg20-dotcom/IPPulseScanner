package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uc5 extends s15 {
    public final /* synthetic */ int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uc5(String str, int i) {
        super(str);
        this.z = i;
    }

    @Override // defpackage.s15
    public final d25 j(ih4 ih4Var, List list) {
        int i = this.z;
        j25 j25Var = d25.q0;
        switch (i) {
            case 0:
                return j25Var;
            case 1:
            case 2:
                return this;
            case 3:
                return new p15(Double.valueOf(0.0d));
            default:
                return j25Var;
        }
    }
}
