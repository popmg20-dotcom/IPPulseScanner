package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b85 extends dc5 {
    private static final b85 zzj;
    private int zzb;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private mc5 zzi = pd5.X;

    static {
        b85 b85Var = new b85();
        zzj = b85Var;
        dc5.k(b85.class, b85Var);
    }

    public static z75 z() {
        return (z75) zzj.f();
    }

    public final /* synthetic */ void A(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void B(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void C() {
        this.zzb &= -3;
        this.zze = zzj.zze;
    }

    public final /* synthetic */ void D(long j) {
        this.zzb |= 4;
        this.zzf = j;
    }

    public final /* synthetic */ void E() {
        this.zzb &= -5;
        this.zzf = 0L;
    }

    public final /* synthetic */ void F(double d) {
        this.zzb |= 16;
        this.zzh = d;
    }

    public final /* synthetic */ void G() {
        this.zzb &= -17;
        this.zzh = 0.0d;
    }

    public final void H(b85 b85Var) {
        mc5 mc5VarN = this.zzi;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzi = mc5VarN;
        }
        mc5VarN.add(b85Var);
    }

    public final void I(ArrayList arrayList) {
        mc5 mc5VarN = this.zzi;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzi = mc5VarN;
        }
        zb5.b(mc5VarN, arrayList);
    }

    public final void J() {
        this.zzi = pd5.X;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", b85.class});
        }
        if (i2 == 3) {
            return new b85();
        }
        if (i2 == 4) {
            return new z75(zzj);
        }
        if (i2 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean n() {
        return (this.zzb & 1) != 0;
    }

    public final String o() {
        return this.zzd;
    }

    public final boolean p() {
        return (this.zzb & 2) != 0;
    }

    public final String q() {
        return this.zze;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final long s() {
        return this.zzf;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final float u() {
        return this.zzg;
    }

    public final boolean v() {
        return (this.zzb & 16) != 0;
    }

    public final double w() {
        return this.zzh;
    }

    public final List x() {
        return this.zzi;
    }

    public final int y() {
        return this.zzi.size();
    }
}
