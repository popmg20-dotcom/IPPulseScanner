package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m55 extends dc5 {
    private static final m55 zzj;
    private int zzb;
    private int zzd;
    private String zze = "";
    private h55 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        m55 m55Var = new m55();
        zzj = m55Var;
        dc5.k(m55.class, m55Var);
    }

    public static l55 v() {
        return (l55) zzj.f();
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new m55();
        }
        if (i2 == 4) {
            return new l55(zzj);
        }
        if (i2 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final int o() {
        return this.zzd;
    }

    public final String p() {
        return this.zze;
    }

    public final h55 q() {
        h55 h55Var = this.zzf;
        return h55Var == null ? h55.v() : h55Var;
    }

    public final boolean r() {
        return this.zzg;
    }

    public final boolean s() {
        return this.zzh;
    }

    public final boolean t() {
        return (this.zzb & 32) != 0;
    }

    public final boolean u() {
        return this.zzi;
    }

    public final /* synthetic */ void w(String str) {
        this.zzb |= 2;
        this.zze = str;
    }
}
