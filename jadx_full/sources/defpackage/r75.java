package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r75 extends dc5 {
    private static final r75 zzd;
    private mc5 zzb = pd5.X;

    static {
        r75 r75Var = new r75();
        zzd = r75Var;
        dc5.k(r75.class, r75Var);
    }

    public static m75 o() {
        return (m75) zzd.f();
    }

    public static r75 p() {
        return zzd;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", q75.class});
        }
        if (i2 == 3) {
            return new r75();
        }
        if (i2 == 4) {
            return new m75(zzd);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List n() {
        return this.zzb;
    }

    public final void q(ArrayList arrayList) {
        mc5 mc5VarN = this.zzb;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzb = mc5VarN;
        }
        zb5.b(mc5VarN, arrayList);
    }
}
