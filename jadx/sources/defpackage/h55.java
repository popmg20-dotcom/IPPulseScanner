package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h55 extends dc5 {
    private static final h55 zzh;
    private int zzb;
    private n55 zzd;
    private k55 zze;
    private boolean zzf;
    private String zzg = "";

    static {
        h55 h55Var = new h55();
        zzh = h55Var;
        dc5.k(h55.class, h55Var);
    }

    public static h55 v() {
        return zzh;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new h55();
        }
        if (i2 == 4) {
            return new g55(zzh);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final n55 o() {
        n55 n55Var = this.zzd;
        return n55Var == null ? n55.u() : n55Var;
    }

    public final boolean p() {
        return (this.zzb & 2) != 0;
    }

    public final k55 q() {
        k55 k55Var = this.zze;
        return k55Var == null ? k55.w() : k55Var;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final boolean s() {
        return this.zzf;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final String u() {
        return this.zzg;
    }

    public final /* synthetic */ void w(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }
}
