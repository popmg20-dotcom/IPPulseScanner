package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i75 extends dc5 {
    private static final i75 zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        i75 i75Var = new i75();
        zzk = i75Var;
        dc5.k(i75.class, i75Var);
    }

    public static h75 u() {
        return (h75) zzk.f();
    }

    public static i75 v() {
        return zzk;
    }

    public final /* synthetic */ void A(boolean z) {
        this.zzb |= 16;
        this.zzh = z;
    }

    public final /* synthetic */ void B(boolean z) {
        this.zzb |= 32;
        this.zzi = z;
    }

    public final /* synthetic */ void C(boolean z) {
        this.zzb |= 64;
        this.zzj = z;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new i75();
        }
        if (i2 == 4) {
            return new h75(zzk);
        }
        if (i2 == 5) {
            return zzk;
        }
        throw null;
    }

    public final boolean n() {
        return this.zzd;
    }

    public final boolean o() {
        return this.zze;
    }

    public final boolean p() {
        return this.zzf;
    }

    public final boolean q() {
        return this.zzg;
    }

    public final boolean r() {
        return this.zzh;
    }

    public final boolean s() {
        return this.zzi;
    }

    public final boolean t() {
        return this.zzj;
    }

    public final /* synthetic */ void w(boolean z) {
        this.zzb |= 1;
        this.zzd = z;
    }

    public final /* synthetic */ void x(boolean z) {
        this.zzb |= 2;
        this.zze = z;
    }

    public final /* synthetic */ void y(boolean z) {
        this.zzb |= 4;
        this.zzf = z;
    }

    public final /* synthetic */ void z(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }
}
