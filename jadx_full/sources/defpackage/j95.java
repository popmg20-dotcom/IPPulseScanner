package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j95 extends dc5 {
    private static final j95 zzj;
    private int zzb;
    private int zzd;
    private mc5 zze = pd5.X;
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private double zzi;

    static {
        j95 j95Var = new j95();
        zzj = j95Var;
        dc5.k(j95.class, j95Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzd", j55.o, "zze", j95.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new j95();
        }
        if (i2 == 4) {
            return new i55(zzj);
        }
        if (i2 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List n() {
        return this.zze;
    }

    public final String o() {
        return this.zzf;
    }

    public final boolean p() {
        return (this.zzb & 4) != 0;
    }

    public final String q() {
        return this.zzg;
    }

    public final boolean r() {
        return (this.zzb & 8) != 0;
    }

    public final boolean s() {
        return this.zzh;
    }

    public final boolean t() {
        return (this.zzb & 16) != 0;
    }

    public final double u() {
        return this.zzi;
    }

    public final int v() {
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
