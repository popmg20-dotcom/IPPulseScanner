package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t85 extends dc5 {
    private static final t85 zzg;
    private lc5 zzb;
    private lc5 zzd;
    private mc5 zze;
    private mc5 zzf;

    static {
        t85 t85Var = new t85();
        zzg = t85Var;
        dc5.k(t85.class, t85Var);
    }

    public t85() {
        wc5 wc5Var = wc5.X;
        this.zzb = wc5Var;
        this.zzd = wc5Var;
        pd5 pd5Var = pd5.X;
        this.zze = pd5Var;
        this.zzf = pd5Var;
    }

    public static s85 v() {
        return (s85) zzg.f();
    }

    public static t85 w() {
        return zzg;
    }

    public final void A() {
        this.zzd = wc5.X;
    }

    public final void B(ArrayList arrayList) {
        mc5 mc5VarN = this.zze;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zze = mc5VarN;
        }
        zb5.b(mc5VarN, arrayList);
    }

    public final void C() {
        this.zze = pd5.X;
    }

    public final void D(Iterable iterable) {
        mc5 mc5VarN = this.zzf;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzf = mc5VarN;
        }
        zb5.b(mc5VarN, iterable);
    }

    public final void E() {
        this.zzf = pd5.X;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", u75.class, "zzf", w85.class});
        }
        if (i2 == 3) {
            return new t85();
        }
        if (i2 == 4) {
            return new s85(zzg);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }

    public final List n() {
        return this.zzb;
    }

    public final int o() {
        return ((wc5) this.zzb).size();
    }

    public final List p() {
        return this.zzd;
    }

    public final int q() {
        return ((wc5) this.zzd).size();
    }

    public final mc5 r() {
        return this.zze;
    }

    public final int s() {
        return this.zze.size();
    }

    public final List t() {
        return this.zzf;
    }

    public final int u() {
        return this.zzf.size();
    }

    public final void x(Iterable iterable) {
        List list = this.zzb;
        boolean z = ((xa5) list).b;
        List list2 = list;
        if (!z) {
            wc5 wc5Var = (wc5) list;
            int i = wc5Var.z;
            wc5 wc5VarN = wc5Var.N(i + i);
            this.zzb = wc5VarN;
            list2 = wc5VarN;
        }
        zb5.b(list2, iterable);
    }

    public final void y() {
        this.zzb = wc5.X;
    }

    public final void z(List list) {
        List list2 = this.zzd;
        boolean z = ((xa5) list2).b;
        List list3 = list2;
        if (!z) {
            wc5 wc5Var = (wc5) list2;
            int i = wc5Var.z;
            wc5 wc5VarN = wc5Var.N(i + i);
            this.zzd = wc5VarN;
            list3 = wc5VarN;
        }
        zb5.b(list3, list);
    }
}
