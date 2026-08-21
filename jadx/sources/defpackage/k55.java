package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k55 extends dc5 {
    private static final k55 zzi;
    private int zzb;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        k55 k55Var = new k55();
        zzi = k55Var;
        dc5.k(k55.class, k55Var);
    }

    public static k55 w() {
        return zzi;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", j55.b, "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new k55();
        }
        if (i2 == 4) {
            return new i55(zzi);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
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

    public final String r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzb & 8) != 0;
    }

    public final String t() {
        return this.zzg;
    }

    public final boolean u() {
        return (this.zzb & 16) != 0;
    }

    public final String v() {
        return this.zzh;
    }

    public final int x() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = 4;
                    if (i2 != 3) {
                        i = i2 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
