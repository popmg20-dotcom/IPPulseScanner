package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j85 extends dc5 {
    private static final j85 zzh;
    private int zzb;
    private mc5 zzd = pd5.X;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        j85 j85Var = new j85();
        zzh = j85Var;
        dc5.k(j85.class, j85Var);
    }

    public static g85 u() {
        return (g85) zzh.f();
    }

    public static g85 v(j85 j85Var) {
        zb5 zb5VarF = zzh.f();
        zb5VarF.f(j85Var);
        return (g85) zb5VarF;
    }

    public final /* synthetic */ void A(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void B(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    public final void C() {
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
            return new qd5(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", n85.class, "zze", "zzf", "zzg", j55.j});
        }
        if (i2 == 3) {
            return new j85();
        }
        if (i2 == 4) {
            return new g85(zzh);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    public final List n() {
        return this.zzd;
    }

    public final int o() {
        return this.zzd.size();
    }

    public final n85 p(int i) {
        return (n85) this.zzd.get(i);
    }

    public final boolean q() {
        return (this.zzb & 1) != 0;
    }

    public final String r() {
        return this.zze;
    }

    public final boolean s() {
        return (this.zzb & 2) != 0;
    }

    public final String t() {
        return this.zzf;
    }

    public final /* synthetic */ void w(int i, n85 n85Var) {
        C();
        this.zzd.set(i, n85Var);
    }

    public final /* synthetic */ void x(n85 n85Var) {
        C();
        this.zzd.add(n85Var);
    }

    public final void y(ArrayList arrayList) {
        C();
        zb5.b(this.zzd, arrayList);
    }

    public final void z() {
        this.zzd = pd5.X;
    }
}
