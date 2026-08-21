package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d95 extends dc5 {
    private static final d95 zzf;
    private int zzb;
    private String zzd = "";
    private mc5 zze = pd5.X;

    static {
        d95 d95Var = new d95();
        zzf = d95Var;
        dc5.k(d95.class, d95Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", j95.class});
        }
        if (i2 == 3) {
            return new d95();
        }
        if (i2 == 4) {
            return new i55(zzf);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }

    public final String n() {
        return this.zzd;
    }

    public final List o() {
        return this.zze;
    }
}
