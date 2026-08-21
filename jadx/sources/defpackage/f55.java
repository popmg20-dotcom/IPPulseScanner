package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f55 extends dc5 {
    private static final f55 zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private mc5 zzf = pd5.X;
    private boolean zzg;
    private k55 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        f55 f55Var = new f55();
        zzl = f55Var;
        dc5.k(f55.class, f55Var);
    }

    public static e55 z() {
        return (e55) zzl.f();
    }

    public final /* synthetic */ void A(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final void B(int i, h55 h55Var) {
        mc5 mc5VarN = this.zzf;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzf = mc5VarN;
        }
        mc5VarN.set(i, h55Var);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", h55.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new f55();
        }
        if (i2 == 4) {
            return new e55(zzl);
        }
        if (i2 == 5) {
            return zzl;
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

    public final List q() {
        return this.zzf;
    }

    public final int r() {
        return this.zzf.size();
    }

    public final h55 s(int i) {
        return (h55) this.zzf.get(i);
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final k55 u() {
        k55 k55Var = this.zzh;
        return k55Var == null ? k55.w() : k55Var;
    }

    public final boolean v() {
        return this.zzi;
    }

    public final boolean w() {
        return this.zzj;
    }

    public final boolean x() {
        return (this.zzb & 64) != 0;
    }

    public final boolean y() {
        return this.zzk;
    }
}
