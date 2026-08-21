package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h95 extends dc5 {
    private static final h95 zzf;
    private int zzb;
    private mc5 zzd = pd5.X;
    private c95 zze;

    static {
        h95 h95Var = new h95();
        zzf = h95Var;
        dc5.k(h95.class, h95Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", j95.class, "zze"});
        }
        if (i2 == 3) {
            return new h95();
        }
        if (i2 == 4) {
            return new i55(zzf);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }

    public final List n() {
        return this.zzd;
    }

    public final c95 o() {
        c95 c95Var = this.zze;
        return c95Var == null ? c95.p() : c95Var;
    }
}
