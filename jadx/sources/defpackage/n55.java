package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n55 extends dc5 {
    private static final n55 zzh;
    private int zzb;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private mc5 zzg = pd5.X;

    static {
        n55 n55Var = new n55();
        zzh = n55Var;
        dc5.k(n55.class, n55Var);
    }

    public static n55 u() {
        return zzh;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", j55.c, "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new n55();
        }
        if (i2 == 4) {
            return new i55(zzh);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final boolean o() {
        return (this.zzb & 2) != 0;
    }

    public final String p() {
        return this.zze;
    }

    public final boolean q() {
        return (this.zzb & 4) != 0;
    }

    public final boolean r() {
        return this.zzf;
    }

    public final mc5 s() {
        return this.zzg;
    }

    public final int t() {
        return this.zzg.size();
    }

    public final int v() {
        int i;
        switch (this.zzd) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
