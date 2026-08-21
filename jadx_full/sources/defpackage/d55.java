package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d55 extends dc5 {
    private static final d55 zzi;
    private int zzb;
    private int zzd;
    private mc5 zze;
    private mc5 zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        d55 d55Var = new d55();
        zzi = d55Var;
        dc5.k(d55.class, d55Var);
    }

    public d55() {
        pd5 pd5Var = pd5.X;
        this.zze = pd5Var;
        this.zzf = pd5Var;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", m55.class, "zzf", f55.class, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new d55();
        }
        if (i2 == 4) {
            return new c55(zzi);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final int o() {
        return this.zzd;
    }

    public final List p() {
        return this.zze;
    }

    public final int q() {
        return this.zze.size();
    }

    public final m55 r(int i) {
        return (m55) this.zze.get(i);
    }

    public final mc5 s() {
        return this.zzf;
    }

    public final int t() {
        return this.zzf.size();
    }

    public final f55 u(int i) {
        return (f55) this.zzf.get(i);
    }

    public final void v(int i, m55 m55Var) {
        mc5 mc5VarN = this.zze;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zze = mc5VarN;
        }
        mc5VarN.set(i, m55Var);
    }

    public final void w(int i, f55 f55Var) {
        mc5 mc5VarN = this.zzf;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzf = mc5VarN;
        }
        mc5VarN.set(i, f55Var);
    }
}
