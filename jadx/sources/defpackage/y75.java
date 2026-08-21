package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y75 extends dc5 {
    private static final y75 zzf;
    private int zzb;
    private String zzd = "";
    private long zze;

    static {
        y75 y75Var = new y75();
        zzf = y75Var;
        dc5.k(y75.class, y75Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new y75();
        }
        if (i2 == 4) {
            return new i55(zzf);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
