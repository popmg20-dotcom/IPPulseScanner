package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w75 extends dc5 {
    private static final w75 zzj;
    private int zzb;
    private mc5 zzd = pd5.X;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        w75 w75Var = new w75();
        zzj = w75Var;
        dc5.k(w75.class, w75Var);
    }

    public static v75 x() {
        return (v75) zzj.f();
    }

    public final void A(Iterable iterable) {
        H();
        zb5.b(this.zzd, iterable);
    }

    public final void B() {
        this.zzd = pd5.X;
    }

    public final /* synthetic */ void C(int i) {
        H();
        this.zzd.remove(i);
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void E(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    public final /* synthetic */ void F(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }

    public final /* synthetic */ void G(long j) {
        this.zzb |= 16;
        this.zzi = j;
    }

    public final void H() {
        mc5 mc5Var = this.zzd;
        if (((xa5) mc5Var).b) {
            return;
        }
        int size = mc5Var.size();
        this.zzd = mc5Var.N(size + size);
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", b85.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new w75();
        }
        if (i2 == 4) {
            return new v75(zzj);
        }
        if (i2 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List n() {
        return this.zzd;
    }

    public final int o() {
        return this.zzd.size();
    }

    public final b85 p(int i) {
        return (b85) this.zzd.get(i);
    }

    public final String q() {
        return this.zze;
    }

    public final boolean r() {
        return (this.zzb & 2) != 0;
    }

    public final long s() {
        return this.zzf;
    }

    public final boolean t() {
        return (this.zzb & 4) != 0;
    }

    public final long u() {
        return this.zzg;
    }

    public final boolean v() {
        return (this.zzb & 8) != 0;
    }

    public final int w() {
        return this.zzh;
    }

    public final /* synthetic */ void y(int i, b85 b85Var) {
        H();
        this.zzd.set(i, b85Var);
    }

    public final /* synthetic */ void z(b85 b85Var) {
        b85Var.getClass();
        H();
        this.zzd.add(b85Var);
    }
}
