package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d75 extends dc5 {
    private static final d75 zzn;
    private int zzb;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private long zzk;
    private ad5 zzl;
    private ad5 zzm;

    static {
        d75 d75Var = new d75();
        zzn = d75Var;
        dc5.k(d75.class, d75Var);
    }

    public d75() {
        ad5 ad5Var = ad5.f;
        this.zzl = ad5Var;
        this.zzm = ad5Var;
        this.zzd = "";
        this.zze = "";
        this.zzf = "";
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
    }

    public static w65 M() {
        return (w65) zzn.f();
    }

    public static d75 N() {
        return zzn;
    }

    public final boolean A() {
        return (this.zzb & 4) != 0;
    }

    public final String B() {
        return this.zzf;
    }

    public final boolean C() {
        return (this.zzb & 8) != 0;
    }

    public final long D() {
        return this.zzg;
    }

    public final boolean E() {
        return (this.zzb & 16) != 0;
    }

    public final String F() {
        return this.zzh;
    }

    public final boolean G() {
        return (this.zzb & 32) != 0;
    }

    public final String H() {
        return this.zzi;
    }

    public final boolean I() {
        return (this.zzb & 64) != 0;
    }

    public final String J() {
        return this.zzj;
    }

    public final boolean K() {
        return (this.zzb & 128) != 0;
    }

    public final long L() {
        return this.zzk;
    }

    public final /* synthetic */ void O(String str) {
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void P() {
        this.zzb &= -2;
        this.zzd = zzn.zzd;
    }

    public final /* synthetic */ void Q(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void R() {
        this.zzb &= -3;
        this.zze = zzn.zze;
    }

    public final /* synthetic */ void S(String str) {
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void T() {
        this.zzb &= -5;
        this.zzf = zzn.zzf;
    }

    public final /* synthetic */ void U(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzn, "\u0004\n\u0000\u0001\u0001\n\n\u0002\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007\t2\n2", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", y65.a, "zzm", a75.a});
        }
        if (i2 == 3) {
            return new d75();
        }
        if (i2 == 4) {
            return new w65(zzn);
        }
        if (i2 == 5) {
            return zzn;
        }
        throw null;
    }

    public final /* synthetic */ void n(String str) {
        this.zzb |= 16;
        this.zzh = str;
    }

    public final /* synthetic */ void o() {
        this.zzb &= -17;
        this.zzh = zzn.zzh;
    }

    public final /* synthetic */ void p(String str) {
        this.zzb |= 32;
        this.zzi = str;
    }

    public final /* synthetic */ void q() {
        this.zzb &= -33;
        this.zzi = zzn.zzi;
    }

    public final /* synthetic */ void r(String str) {
        this.zzb |= 64;
        this.zzj = str;
    }

    public final /* synthetic */ void s() {
        this.zzb &= -65;
        this.zzj = zzn.zzj;
    }

    public final /* synthetic */ void t(long j) {
        this.zzb |= 128;
        this.zzk = j;
    }

    public final ad5 u() {
        ad5 ad5Var = this.zzl;
        if (ad5Var.b) {
            return ad5Var;
        }
        ad5 ad5VarA = ad5Var.a();
        this.zzl = ad5VarA;
        return ad5VarA;
    }

    public final ad5 v() {
        ad5 ad5Var = this.zzm;
        if (ad5Var.b) {
            return ad5Var;
        }
        ad5 ad5VarA = ad5Var.a();
        this.zzm = ad5VarA;
        return ad5VarA;
    }

    public final boolean w() {
        return (this.zzb & 1) != 0;
    }

    public final String x() {
        return this.zzd;
    }

    public final boolean y() {
        return (this.zzb & 2) != 0;
    }

    public final String z() {
        return this.zze;
    }
}
