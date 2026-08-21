package defpackage;

import java.io.IOException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ty4 implements Function2 {
    public final /* synthetic */ bh3 A;
    public final /* synthetic */ bh3 X;
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ bh3 f;
    public final /* synthetic */ he3 z;

    public /* synthetic */ ty4(he3 he3Var, bh3 bh3Var, bh3 bh3Var2, bh3 bh3Var3) {
        this.z = he3Var;
        this.f = bh3Var;
        this.A = bh3Var2;
        this.X = bh3Var3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws IOException {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        bh3 bh3Var = this.X;
        bh3 bh3Var2 = this.A;
        he3 he3Var = this.z;
        bh3 bh3Var3 = this.f;
        switch (i) {
            case 0:
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                if (iIntValue == 21589) {
                    if (jLongValue >= 1) {
                        byte bS = he3Var.s();
                        boolean z = (bS & 1) == 1;
                        boolean z2 = (bS & 2) == 2;
                        boolean z3 = (bS & 4) == 4;
                        long j = z ? 5L : 1L;
                        if (z2) {
                            j += 4;
                        }
                        if (z3) {
                            j += 4;
                        }
                        if (jLongValue >= j) {
                            if (z) {
                                bh3Var3.b = Integer.valueOf(he3Var.F());
                            }
                            if (z2) {
                                bh3Var2.b = Integer.valueOf(he3Var.F());
                            }
                            if (z3) {
                                bh3Var.b = Integer.valueOf(he3Var.F());
                            }
                        } else {
                            vp1.i("bad zip: extended timestamp extra too short");
                        }
                    } else {
                        vp1.i("bad zip: extended timestamp extra too short");
                    }
                }
                break;
            default:
                int iIntValue2 = ((Integer) obj).intValue();
                long jLongValue2 = ((Long) obj2).longValue();
                if (iIntValue2 == 1) {
                    if (bh3Var3.b != null) {
                        vp1.i("bad zip: NTFS extra attribute tag 0x0001 repeated");
                    } else if (jLongValue2 == 24) {
                        bh3Var3.b = Long.valueOf(he3Var.I());
                        bh3Var2.b = Long.valueOf(he3Var.I());
                        bh3Var.b = Long.valueOf(he3Var.I());
                    } else {
                        vp1.i("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                    }
                }
                break;
        }
        return xl4Var;
    }

    public /* synthetic */ ty4(bh3 bh3Var, he3 he3Var, bh3 bh3Var2, bh3 bh3Var3) {
        this.f = bh3Var;
        this.z = he3Var;
        this.A = bh3Var2;
        this.X = bh3Var3;
    }
}
