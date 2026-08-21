package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a65 extends dc5 {
    private static final a65 zzi;
    private int zzb;
    private mc5 zzd;
    private mc5 zze;
    private mc5 zzf;
    private boolean zzg;
    private mc5 zzh;

    static {
        a65 a65Var = new a65();
        zzi = a65Var;
        dc5.k(a65.class, a65Var);
    }

    public a65() {
        pd5 pd5Var = pd5.X;
        this.zzd = pd5Var;
        this.zze = pd5Var;
        this.zzf = pd5Var;
        this.zzh = pd5Var;
    }

    public static a65 t() {
        return zzi;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", o55.class, "zze", p55.class, "zzf", x55.class, "zzg", "zzh", o55.class});
        }
        if (i2 == 3) {
            return new a65();
        }
        if (i2 == 4) {
            return new i55(zzi);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }

    public final List n() {
        return this.zzd;
    }

    public final List o() {
        return this.zze;
    }

    public final List p() {
        return this.zzf;
    }

    public final boolean q() {
        return (this.zzb & 1) != 0;
    }

    public final boolean r() {
        return this.zzg;
    }

    public final mc5 s() {
        return this.zzh;
    }
}
