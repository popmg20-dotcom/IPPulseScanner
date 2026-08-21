package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u65 extends dc5 {
    private static final u65 zzi;
    private int zzb;
    private int zzg;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzh = "";

    static {
        u65 u65Var = new u65();
        zzi = u65Var;
        dc5.k(u65.class, u65Var);
    }

    public static u65 p() {
        return zzi;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new u65();
        }
        if (i2 == 4) {
            return new i55(zzi);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }

    public final int n() {
        return this.zzg;
    }

    public final String o() {
        return this.zzh;
    }
}
