package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e85 extends dc5 {
    private static final e85 zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private g75 zzf;

    static {
        e85 e85Var = new e85();
        zzg = e85Var;
        dc5.k(e85.class, e85Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new e85();
        }
        if (i2 == 4) {
            return new i55(zzg);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
