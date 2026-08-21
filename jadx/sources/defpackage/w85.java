package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w85 extends dc5 {
    private static final w85 zzf;
    private int zzb;
    private int zzd;
    private lc5 zze = wc5.X;

    static {
        w85 w85Var = new w85();
        zzf = w85Var;
        dc5.k(w85.class, w85Var);
    }

    public static v85 s() {
        return (v85) zzf.f();
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new w85();
        }
        if (i2 == 4) {
            return new v85(zzf);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final int o() {
        return this.zzd;
    }

    public final List p() {
        return this.zze;
    }

    public final int q() {
        return ((wc5) this.zze).size();
    }

    public final long r(int i) {
        return ((wc5) this.zze).b(i);
    }

    public final /* synthetic */ void t(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final void u(List list) {
        List list2 = this.zze;
        boolean z = ((xa5) list2).b;
        List list3 = list2;
        if (!z) {
            wc5 wc5Var = (wc5) list2;
            int i = wc5Var.z;
            wc5 wc5VarN = wc5Var.N(i + i);
            this.zze = wc5VarN;
            list3 = wc5VarN;
        }
        zb5.b(list3, list);
    }
}
