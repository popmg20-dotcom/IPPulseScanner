package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j65 extends dc5 {
    private static final j65 zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private mc5 zzg;
    private mc5 zzh;
    private mc5 zzi;
    private String zzj;
    private boolean zzk;
    private mc5 zzl;
    private mc5 zzm;
    private String zzn;
    private String zzo;
    private a65 zzp;
    private n65 zzq;
    private u65 zzr;
    private p65 zzs;
    private l65 zzt;

    static {
        j65 j65Var = new j65();
        zzu = j65Var;
        dc5.k(j65.class, j65Var);
    }

    public j65() {
        pd5 pd5Var = pd5.X;
        this.zzg = pd5Var;
        this.zzh = pd5Var;
        this.zzi = pd5Var;
        this.zzj = "";
        this.zzl = pd5Var;
        this.zzm = pd5Var;
        this.zzn = "";
        this.zzo = "";
    }

    public static h65 D() {
        return (h65) zzu.f();
    }

    public static j65 E() {
        return zzu;
    }

    public final a65 A() {
        a65 a65Var = this.zzp;
        return a65Var == null ? a65.t() : a65Var;
    }

    public final boolean B() {
        return (this.zzb & 512) != 0;
    }

    public final u65 C() {
        u65 u65Var = this.zzr;
        return u65Var == null ? u65.p() : u65Var;
    }

    public final void F(int i, f65 f65Var) {
        mc5 mc5VarN = this.zzh;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzh = mc5VarN;
        }
        mc5VarN.set(i, f65Var);
    }

    public final void G() {
        this.zzi = pd5.X;
    }

    public final void H() {
        this.zzl = pd5.X;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", s65.class, "zzh", f65.class, "zzi", d55.class, "zzj", "zzk", "zzl", h95.class, "zzm", c65.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i2 == 3) {
            return new j65();
        }
        if (i2 == 4) {
            return new h65(zzu);
        }
        if (i2 == 5) {
            return zzu;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final long o() {
        return this.zzd;
    }

    public final boolean p() {
        return (this.zzb & 2) != 0;
    }

    public final String q() {
        return this.zze;
    }

    public final mc5 r() {
        return this.zzg;
    }

    public final int s() {
        return this.zzh.size();
    }

    public final f65 t(int i) {
        return (f65) this.zzh.get(i);
    }

    public final mc5 u() {
        return this.zzi;
    }

    public final mc5 v() {
        return this.zzl;
    }

    public final int w() {
        return this.zzl.size();
    }

    public final List x() {
        return this.zzm;
    }

    public final String y() {
        return this.zzn;
    }

    public final boolean z() {
        return (this.zzb & 128) != 0;
    }
}
