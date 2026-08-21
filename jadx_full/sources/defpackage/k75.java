package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k75 extends dc5 {
    private static final k75 zzh;
    private int zzb;
    private int zzd;
    private t85 zze;
    private t85 zzf;
    private boolean zzg;

    static {
        k75 k75Var = new k75();
        zzh = k75Var;
        dc5.k(k75.class, k75Var);
    }

    public static j75 u() {
        return (j75) zzh.f();
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new k75();
        }
        if (i2 == 4) {
            return new j75(zzh);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final int o() {
        return this.zzd;
    }

    public final t85 p() {
        t85 t85Var = this.zze;
        return t85Var == null ? t85.w() : t85Var;
    }

    public final boolean q() {
        return (this.zzb & 4) != 0;
    }

    public final t85 r() {
        t85 t85Var = this.zzf;
        return t85Var == null ? t85.w() : t85Var;
    }

    public final boolean s() {
        return (this.zzb & 8) != 0;
    }

    public final boolean t() {
        return this.zzg;
    }

    public final /* synthetic */ void v(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void w(t85 t85Var) {
        this.zze = t85Var;
        this.zzb |= 2;
    }

    public final /* synthetic */ void x(t85 t85Var) {
        this.zzf = t85Var;
        this.zzb |= 4;
    }

    public final /* synthetic */ void y(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }
}
