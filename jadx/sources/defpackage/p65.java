package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p65 extends dc5 {
    private static final p65 zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        p65 p65Var = new p65();
        zzf = p65Var;
        dc5.k(p65.class, p65Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new p65();
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
