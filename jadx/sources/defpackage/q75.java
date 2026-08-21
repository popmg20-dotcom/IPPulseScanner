package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q75 extends dc5 {
    private static final q75 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        q75 q75Var = new q75();
        zzf = q75Var;
        dc5.k(q75.class, q75Var);
    }

    public static p75 n() {
        return (p75) zzf.f();
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", j55.h, "zze", j55.i});
        }
        if (i2 == 3) {
            return new q75();
        }
        if (i2 == 4) {
            return new p75(zzf);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }

    public final int o() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = 4;
                    if (i2 != 3) {
                        i = i2 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final int p() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                i = i2 != 2 ? 0 : 3;
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final /* synthetic */ void q(int i) {
        this.zzd = i - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void r(int i) {
        this.zze = i - 1;
        this.zzb |= 2;
    }
}
