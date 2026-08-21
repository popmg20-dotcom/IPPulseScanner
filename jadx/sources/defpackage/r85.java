package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r85 extends dc5 {
    private static final r85 zzf;
    private int zzb;
    private int zzd = 1;
    private mc5 zze = pd5.X;

    static {
        r85 r85Var = new r85();
        zzf = r85Var;
        dc5.k(r85.class, r85Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", j55.k, "zze", y75.class});
        }
        if (i2 == 3) {
            return new r85();
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
