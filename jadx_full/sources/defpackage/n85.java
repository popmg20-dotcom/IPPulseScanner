package defpackage;

import android.os.Build;
import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n85 extends dc5 {
    private static final n85 zzat;
    private int zzA;
    private String zzB;
    private String zzC;
    private boolean zzD;
    private mc5 zzE;
    private String zzF;
    private int zzG;
    private int zzH;
    private int zzI;
    private String zzJ;
    private long zzK;
    private long zzL;
    private String zzM;
    private String zzN;
    private int zzO;
    private String zzP;
    private r85 zzQ;
    private kc5 zzR;
    private long zzS;
    private long zzT;
    private String zzU;
    private String zzV;
    private int zzW;
    private boolean zzX;
    private String zzY;
    private boolean zzZ;
    private e85 zzaa;
    private String zzab;
    private mc5 zzac;
    private String zzad;
    private long zzae;
    private boolean zzaf;
    private String zzag;
    private boolean zzah;
    private String zzai;
    private int zzaj;
    private String zzak;
    private i75 zzal;
    private int zzam;
    private d75 zzan;
    private String zzao;
    private y85 zzap;
    private long zzaq;
    private String zzar;
    private r75 zzas;
    private int zzb;
    private int zzd;
    private int zze;
    private mc5 zzf;
    private mc5 zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private int zzq;
    private String zzr;
    private String zzs;
    private String zzt;
    private long zzu;
    private long zzv;
    private String zzw;
    private boolean zzx;
    private String zzy;
    private long zzz;

    static {
        n85 n85Var = new n85();
        zzat = n85Var;
        dc5.k(n85.class, n85Var);
    }

    public n85() {
        pd5 pd5Var = pd5.X;
        this.zzf = pd5Var;
        this.zzg = pd5Var;
        this.zzm = "";
        this.zzn = "";
        this.zzo = "";
        this.zzp = "";
        this.zzr = "";
        this.zzs = "";
        this.zzt = "";
        this.zzw = "";
        this.zzy = "";
        this.zzB = "";
        this.zzC = "";
        this.zzE = pd5Var;
        this.zzF = "";
        this.zzJ = "";
        this.zzM = "";
        this.zzN = "";
        this.zzP = "";
        this.zzR = fc5.X;
        this.zzU = "";
        this.zzV = "";
        this.zzY = "";
        this.zzab = "";
        this.zzac = pd5Var;
        this.zzad = "";
        this.zzag = "";
        this.zzai = "";
        this.zzak = "";
        this.zzao = "";
        this.zzar = "";
    }

    public static l85 S() {
        return (l85) zzat.f();
    }

    public static l85 T(n85 n85Var) {
        zb5 zb5VarF = zzat.f();
        zb5VarF.f(n85Var);
        return (l85) zb5VarF;
    }

    public final int A() {
        return this.zzA;
    }

    public final boolean A0() {
        return (this.zzd & 262144) != 0;
    }

    public final /* synthetic */ void A1(String str) {
        this.zzb |= 262144;
        this.zzy = str;
    }

    public final String B() {
        return this.zzB;
    }

    public final boolean B0() {
        return this.zzah;
    }

    public final /* synthetic */ void B1() {
        this.zzb &= -262145;
        this.zzy = zzat.zzy;
    }

    public final String C() {
        return this.zzC;
    }

    public final boolean C0() {
        return (this.zzd & 524288) != 0;
    }

    public final /* synthetic */ void C1(long j) {
        this.zzb |= 524288;
        this.zzz = j;
    }

    public final boolean D() {
        return (this.zzb & 8388608) != 0;
    }

    public final String D0() {
        return this.zzai;
    }

    public final /* synthetic */ void D1(int i) {
        this.zzb |= 1048576;
        this.zzA = i;
    }

    public final boolean E() {
        return this.zzD;
    }

    public final int E0() {
        return this.zzaj;
    }

    public final /* synthetic */ void E1(String str) {
        this.zzb |= 2097152;
        this.zzB = str;
    }

    public final mc5 F() {
        return this.zzE;
    }

    public final boolean F0() {
        return (this.zzd & 4194304) != 0;
    }

    public final /* synthetic */ void F1() {
        this.zzb &= -2097153;
        this.zzB = zzat.zzB;
    }

    public final String G() {
        return this.zzF;
    }

    public final i75 G0() {
        i75 i75Var = this.zzal;
        return i75Var == null ? i75.v() : i75Var;
    }

    public final /* synthetic */ void G1(String str) {
        str.getClass();
        this.zzb |= 4194304;
        this.zzC = str;
    }

    public final boolean H() {
        return (this.zzb & 33554432) != 0;
    }

    public final boolean H0() {
        return (this.zzd & 8388608) != 0;
    }

    public final /* synthetic */ void H1() {
        this.zzb |= 8388608;
        this.zzD = false;
    }

    public final int I() {
        return this.zzG;
    }

    public final int I0() {
        return this.zzam;
    }

    public final void I1(ArrayList arrayList) {
        mc5 mc5VarN = this.zzE;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzE = mc5VarN;
        }
        zb5.b(mc5VarN, arrayList);
    }

    public final boolean J() {
        return (this.zzb & 536870912) != 0;
    }

    public final boolean J0() {
        return (this.zzd & 16777216) != 0;
    }

    public final void J1() {
        this.zzE = pd5.X;
    }

    public final long K() {
        return this.zzK;
    }

    public final d75 K0() {
        d75 d75Var = this.zzan;
        return d75Var == null ? d75.N() : d75Var;
    }

    public final /* synthetic */ void K1(String str) {
        this.zzb |= 16777216;
        this.zzF = str;
    }

    public final boolean L() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final boolean L0() {
        return (this.zzd & 67108864) != 0;
    }

    public final /* synthetic */ void L1(int i) {
        this.zzb |= 33554432;
        this.zzG = i;
    }

    public final String M() {
        return this.zzM;
    }

    public final y85 M0() {
        y85 y85Var = this.zzap;
        return y85Var == null ? y85.p() : y85Var;
    }

    public final /* synthetic */ void M1() {
        this.zzb &= -268435457;
        this.zzJ = zzat.zzJ;
    }

    public final boolean N() {
        return (this.zzb & 1) != 0;
    }

    public final int N0() {
        return this.zze;
    }

    public final List N1() {
        return this.zzf;
    }

    public final boolean O() {
        return (this.zzd & 134217728) != 0;
    }

    public final /* synthetic */ void O0(long j) {
        this.zzb |= 536870912;
        this.zzK = j;
    }

    public final void O1() {
        mc5 mc5Var = this.zzf;
        if (((xa5) mc5Var).b) {
            return;
        }
        int size = mc5Var.size();
        this.zzf = mc5Var.N(size + size);
    }

    public final long P() {
        return this.zzaq;
    }

    public final /* synthetic */ void P0(String str) {
        str.getClass();
        this.zzb |= Integer.MIN_VALUE;
        this.zzM = str;
    }

    public final void P1() {
        mc5 mc5Var = this.zzg;
        if (((xa5) mc5Var).b) {
            return;
        }
        int size = mc5Var.size();
        this.zzg = mc5Var.N(size + size);
    }

    public final boolean Q() {
        return (this.zzd & 536870912) != 0;
    }

    public final /* synthetic */ void Q0() {
        this.zzb &= ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.zzM = zzat.zzM;
    }

    public final int Q1() {
        return this.zzf.size();
    }

    public final r75 R() {
        r75 r75Var = this.zzas;
        return r75Var == null ? r75.p() : r75Var;
    }

    public final /* synthetic */ void R0(int i) {
        this.zzd |= 2;
        this.zzO = i;
    }

    public final w75 R1(int i) {
        return (w75) this.zzf.get(i);
    }

    public final void S0(ArrayList arrayList) {
        List list = this.zzR;
        boolean z = ((xa5) list).b;
        List list2 = list;
        if (!z) {
            fc5 fc5Var = (fc5) list;
            int i = fc5Var.z;
            fc5 fc5VarB = fc5Var.N(i + i);
            this.zzR = fc5VarB;
            list2 = fc5VarB;
        }
        zb5.b(list2, arrayList);
    }

    public final mc5 S1() {
        return this.zzg;
    }

    public final /* synthetic */ void T0(long j) {
        this.zzd |= 16;
        this.zzS = j;
    }

    public final int T1() {
        return this.zzg.size();
    }

    public final /* synthetic */ void U() {
        this.zzb |= 1;
        this.zze = 1;
    }

    public final /* synthetic */ void U0(long j) {
        this.zzd |= 32;
        this.zzT = j;
    }

    public final a95 U1(int i) {
        return (a95) this.zzg.get(i);
    }

    public final /* synthetic */ void V(int i, w75 w75Var) {
        O1();
        this.zzf.set(i, w75Var);
    }

    public final /* synthetic */ void V0(String str) {
        this.zzd |= 128;
        this.zzV = str;
    }

    public final boolean V1() {
        return (this.zzb & 2) != 0;
    }

    public final /* synthetic */ void W(w75 w75Var) {
        O1();
        this.zzf.add(w75Var);
    }

    public final /* synthetic */ void W0(String str) {
        str.getClass();
        this.zzd |= 8192;
        this.zzab = str;
    }

    public final long W1() {
        return this.zzh;
    }

    public final void X(Iterable iterable) {
        O1();
        zb5.b(this.zzf, iterable);
    }

    public final /* synthetic */ void X0() {
        this.zzd &= -8193;
        this.zzab = zzat.zzab;
    }

    public final boolean X1() {
        return (this.zzb & 4) != 0;
    }

    public final void Y() {
        this.zzf = pd5.X;
    }

    public final void Y0(Set set) {
        mc5 mc5VarN = this.zzac;
        if (!((xa5) mc5VarN).b) {
            int size = mc5VarN.size();
            mc5VarN = mc5VarN.N(size + size);
            this.zzac = mc5VarN;
        }
        zb5.b(mc5VarN, set);
    }

    public final long Y1() {
        return this.zzi;
    }

    public final /* synthetic */ void Z(int i) {
        O1();
        this.zzf.remove(i);
    }

    public final /* synthetic */ void Z0(String str) {
        str.getClass();
        this.zzd |= 16384;
        this.zzad = str;
    }

    public final boolean Z1() {
        return (this.zzb & 8) != 0;
    }

    public final /* synthetic */ void a0(int i, a95 a95Var) {
        P1();
        this.zzg.set(i, a95Var);
    }

    public final /* synthetic */ void a1(long j) {
        this.zzd |= 32768;
        this.zzae = j;
    }

    public final long a2() {
        return this.zzj;
    }

    public final /* synthetic */ void b0(a95 a95Var) {
        P1();
        this.zzg.add(a95Var);
    }

    public final /* synthetic */ void b1(boolean z) {
        this.zzd |= 65536;
        this.zzaf = z;
    }

    public final boolean b2() {
        return (this.zzb & 16) != 0;
    }

    public final /* synthetic */ void c0(int i) {
        P1();
        this.zzg.remove(i);
    }

    public final /* synthetic */ void c1(String str) {
        this.zzd |= 131072;
        this.zzag = str;
    }

    public final long c2() {
        return this.zzk;
    }

    public final /* synthetic */ void d0(long j) {
        this.zzb |= 2;
        this.zzh = j;
    }

    public final /* synthetic */ void d1(boolean z) {
        this.zzd |= 262144;
        this.zzah = z;
    }

    public final boolean d2() {
        return (this.zzb & 32) != 0;
    }

    public final /* synthetic */ void e0() {
        this.zzb &= -3;
        this.zzh = 0L;
    }

    public final /* synthetic */ void e1(String str) {
        str.getClass();
        this.zzd |= 524288;
        this.zzai = str;
    }

    public final long e2() {
        return this.zzl;
    }

    public final /* synthetic */ void f0(long j) {
        this.zzb |= 4;
        this.zzi = j;
    }

    public final /* synthetic */ void f1(int i) {
        this.zzd |= 1048576;
        this.zzaj = i;
    }

    public final String f2() {
        return this.zzm;
    }

    public final /* synthetic */ void g0(long j) {
        this.zzb |= 8;
        this.zzj = j;
    }

    public final /* synthetic */ void g1(i75 i75Var) {
        this.zzal = i75Var;
        this.zzd |= 4194304;
    }

    public final String g2() {
        return this.zzn;
    }

    public final /* synthetic */ void h0(long j) {
        this.zzb |= 16;
        this.zzk = j;
    }

    public final /* synthetic */ void h1(int i) {
        this.zzd |= 8388608;
        this.zzam = i;
    }

    public final String h2() {
        return this.zzo;
    }

    public final /* synthetic */ void i0() {
        this.zzb &= -17;
        this.zzk = 0L;
    }

    public final /* synthetic */ void i1(d75 d75Var) {
        this.zzan = d75Var;
        this.zzd |= 16777216;
    }

    public final String i2() {
        return this.zzp;
    }

    public final /* synthetic */ void j0(long j) {
        this.zzb |= 32;
        this.zzl = j;
    }

    public final /* synthetic */ void j1(y85 y85Var) {
        this.zzap = y85Var;
        this.zzd |= 67108864;
    }

    public final boolean j2() {
        return (this.zzb & 1024) != 0;
    }

    public final /* synthetic */ void k0() {
        this.zzb &= -33;
        this.zzl = 0L;
    }

    public final /* synthetic */ void k1(long j) {
        this.zzd |= 134217728;
        this.zzaq = j;
    }

    public final int k2() {
        return this.zzq;
    }

    public final /* synthetic */ void l0() {
        this.zzb |= 64;
        this.zzm = "android";
    }

    public final /* synthetic */ void l1() {
        this.zzd |= 268435456;
        this.zzar = "";
    }

    public final String l2() {
        return this.zzr;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzat, "\u0004C\u0000\u0002\u0001VC\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9Qဉ:Rဂ;Sဈ<Vဉ=", new Object[]{"zzb", "zzd", "zze", "zzf", w75.class, "zzg", a95.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzk", "zzD", "zzE", k75.class, "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", j55.g, "zzX", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas"});
        }
        if (i2 == 3) {
            return new n85();
        }
        if (i2 == 4) {
            return new l85(zzat);
        }
        if (i2 == 5) {
            return zzat;
        }
        throw null;
    }

    public final /* synthetic */ void m0(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzn = str;
    }

    public final /* synthetic */ void m1(r75 r75Var) {
        this.zzas = r75Var;
        this.zzd |= 536870912;
    }

    public final String n() {
        return this.zzs;
    }

    public final boolean n0() {
        return (this.zzd & 2) != 0;
    }

    public final /* synthetic */ void n1() {
        String str = Build.MODEL;
        str.getClass();
        this.zzb |= 256;
        this.zzo = str;
    }

    public final String o() {
        return this.zzt;
    }

    public final int o0() {
        return this.zzO;
    }

    public final /* synthetic */ void o1() {
        this.zzb &= -257;
        this.zzo = zzat.zzo;
    }

    public final boolean p() {
        return (this.zzb & 16384) != 0;
    }

    public final boolean p0() {
        return (this.zzd & 16) != 0;
    }

    public final /* synthetic */ void p1(String str) {
        str.getClass();
        this.zzb |= 512;
        this.zzp = str;
    }

    public final long q() {
        return this.zzu;
    }

    public final long q0() {
        return this.zzS;
    }

    public final /* synthetic */ void q1(int i) {
        this.zzb |= 1024;
        this.zzq = i;
    }

    public final boolean r() {
        return (this.zzb & 32768) != 0;
    }

    public final boolean r0() {
        return (this.zzd & 128) != 0;
    }

    public final /* synthetic */ void r1(String str) {
        str.getClass();
        this.zzb |= 2048;
        this.zzr = str;
    }

    public final long s() {
        return this.zzv;
    }

    public final String s0() {
        return this.zzV;
    }

    public final /* synthetic */ void s1(String str) {
        str.getClass();
        this.zzb |= 4096;
        this.zzs = str;
    }

    public final String t() {
        return this.zzw;
    }

    public final boolean t0() {
        return (this.zzd & 8192) != 0;
    }

    public final /* synthetic */ void t1(String str) {
        str.getClass();
        this.zzb |= 8192;
        this.zzt = str;
    }

    public final boolean u() {
        return (this.zzb & 131072) != 0;
    }

    public final String u0() {
        return this.zzab;
    }

    public final /* synthetic */ void u1(long j) {
        this.zzb |= 16384;
        this.zzu = j;
    }

    public final boolean v() {
        return this.zzx;
    }

    public final boolean v0() {
        return (this.zzd & 32768) != 0;
    }

    public final /* synthetic */ void v1() {
        this.zzb |= 32768;
        this.zzv = 133005L;
    }

    public final String w() {
        return this.zzy;
    }

    public final long w0() {
        return this.zzae;
    }

    public final /* synthetic */ void w1(String str) {
        str.getClass();
        this.zzb |= 65536;
        this.zzw = str;
    }

    public final boolean x() {
        return (this.zzb & 524288) != 0;
    }

    public final boolean x0() {
        return this.zzaf;
    }

    public final /* synthetic */ void x1() {
        this.zzb &= -65537;
        this.zzw = zzat.zzw;
    }

    public final long y() {
        return this.zzz;
    }

    public final boolean y0() {
        return (this.zzd & 131072) != 0;
    }

    public final /* synthetic */ void y1(boolean z) {
        this.zzb |= 131072;
        this.zzx = z;
    }

    public final boolean z() {
        return (this.zzb & 1048576) != 0;
    }

    public final String z0() {
        return this.zzag;
    }

    public final /* synthetic */ void z1() {
        this.zzb &= -131073;
        this.zzx = false;
    }
}
