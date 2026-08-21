package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o55 extends dc5 {
    private static final o55 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        o55 o55Var = new o55();
        zzg = o55Var;
        dc5.k(o55.class, o55Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", j55.e, "zze", j55.d, "zzf", j55.f});
        }
        if (i2 == 3) {
            return new o55();
        }
        if (i2 == 4) {
            return new i55(zzg);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }

    public final int n() {
        int iM = xb5.M(this.zzd);
        if (iM == 0) {
            return 1;
        }
        return iM;
    }

    public final int o() {
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

    public final int p() {
        int i;
        int i2 = this.zzf;
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
}
