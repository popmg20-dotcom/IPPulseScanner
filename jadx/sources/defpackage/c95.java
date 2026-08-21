package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c95 extends dc5 {
    private static final c95 zzd;
    private mc5 zzb = pd5.X;

    static {
        c95 c95Var = new c95();
        zzd = c95Var;
        dc5.k(c95.class, c95Var);
    }

    public static c95 p() {
        return zzd;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", d95.class});
        }
        if (i2 == 3) {
            return new c95();
        }
        if (i2 == 4) {
            return new i55(zzd);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List n() {
        return this.zzb;
    }

    public final int o() {
        return this.zzb.size();
    }
}
