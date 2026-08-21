package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f65 extends dc5 {
    private static final f65 zzh;
    private int zzb;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        f65 f65Var = new f65();
        zzh = f65Var;
        dc5.k(f65.class, f65Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new f65();
        }
        if (i2 == 4) {
            return new e65(zzh);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    public final String n() {
        return this.zzd;
    }

    public final boolean o() {
        return (this.zzb & 2) != 0;
    }

    public final boolean p() {
        return this.zze;
    }

    public final boolean q() {
        return (this.zzb & 4) != 0;
    }

    public final boolean r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzb & 8) != 0;
    }

    public final int t() {
        return this.zzg;
    }

    public final /* synthetic */ void u(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }
}
