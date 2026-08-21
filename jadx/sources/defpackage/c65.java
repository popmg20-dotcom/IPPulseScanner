package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c65 extends dc5 {
    private static final c65 zzg;
    private int zzb;
    private String zzd = "";
    private mc5 zze = pd5.X;
    private boolean zzf;

    static {
        c65 c65Var = new c65();
        zzg = c65Var;
        dc5.k(c65.class, c65Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", p65.class, "zzf"});
        }
        if (i2 == 3) {
            return new c65();
        }
        if (i2 == 4) {
            return new i55(zzg);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }

    public final String n() {
        return this.zzd;
    }
}
