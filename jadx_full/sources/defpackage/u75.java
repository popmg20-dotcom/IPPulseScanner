package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u75 extends dc5 {
    private static final u75 zzf;
    private int zzb;
    private int zzd;
    private long zze;

    static {
        u75 u75Var = new u75();
        zzf = u75Var;
        dc5.k(u75.class, u75Var);
    }

    public static t75 r() {
        return (t75) zzf.f();
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new u75();
        }
        if (i2 == 4) {
            return new t75(zzf);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final int o() {
        return this.zzd;
    }

    public final boolean p() {
        return (this.zzb & 2) != 0;
    }

    public final long q() {
        return this.zze;
    }

    public final /* synthetic */ void s(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void t(long j) {
        this.zzb |= 2;
        this.zze = j;
    }
}
