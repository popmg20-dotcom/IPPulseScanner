package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l65 extends dc5 {
    private static final l65 zzd;
    private mc5 zzb = pd5.X;

    static {
        l65 l65Var = new l65();
        zzd = l65Var;
        dc5.k(l65.class, l65Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new l65();
        }
        if (i2 == 4) {
            return new i55(zzd);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
