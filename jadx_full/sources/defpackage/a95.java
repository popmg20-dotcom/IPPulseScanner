package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a95 extends dc5 {
    private static final a95 zzj;
    private int zzb;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    static {
        a95 a95Var = new a95();
        zzj = a95Var;
        dc5.k(a95.class, a95Var);
    }

    public static z85 y() {
        return (z85) zzj.f();
    }

    public final /* synthetic */ void A(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void B(String str) {
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void C() {
        this.zzb &= -5;
        this.zzf = zzj.zzf;
    }

    public final /* synthetic */ void D(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }

    public final /* synthetic */ void E() {
        this.zzb &= -9;
        this.zzg = 0L;
    }

    public final /* synthetic */ void F(double d) {
        this.zzb |= 32;
        this.zzi = d;
    }

    public final /* synthetic */ void G() {
        this.zzb &= -33;
        this.zzi = 0.0d;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new a95();
        }
        if (i2 == 4) {
            return new z85(zzj);
        }
        if (i2 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final long o() {
        return this.zzd;
    }

    public final String p() {
        return this.zze;
    }

    public final boolean q() {
        return (this.zzb & 4) != 0;
    }

    public final String r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzb & 8) != 0;
    }

    public final long t() {
        return this.zzg;
    }

    public final boolean u() {
        return (this.zzb & 16) != 0;
    }

    public final float v() {
        return this.zzh;
    }

    public final boolean w() {
        return (this.zzb & 32) != 0;
    }

    public final double x() {
        return this.zzi;
    }

    public final /* synthetic */ void z(long j) {
        this.zzb |= 1;
        this.zzd = j;
    }
}
