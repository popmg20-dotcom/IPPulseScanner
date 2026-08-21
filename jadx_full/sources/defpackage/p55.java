package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p55 extends dc5 {
    private static final p55 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        p55 p55Var = new p55();
        zzf = p55Var;
        dc5.k(p55.class, p55Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            j55 j55Var = j55.e;
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", j55Var, "zze", j55Var});
        }
        if (i2 == 3) {
            return new p55();
        }
        if (i2 == 4) {
            return new i55(zzf);
        }
        if (i2 == 5) {
            return zzf;
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
        int iM = xb5.M(this.zze);
        if (iM == 0) {
            return 1;
        }
        return iM;
    }
}
