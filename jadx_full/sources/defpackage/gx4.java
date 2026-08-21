package defpackage;

import androidx.work.OverwritingInputMerger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gx4 {
    public static final String z = ue2.i("WorkSpec");
    public final String a;
    public ww4 b;
    public final String c;
    public final String d;
    public di0 e;
    public final di0 f;
    public long g;
    public long h;
    public long i;
    public final mc0 j;
    public final int k;
    public final ei l;
    public final long m;
    public long n;
    public final long o;
    public final long p;
    public boolean q;
    public final ww2 r;
    public final int s;
    public final int t;
    public long u;
    public int v;
    public final int w;
    public String x;
    public final Boolean y;

    public /* synthetic */ gx4(String str, ww4 ww4Var, String str2, String str3, di0 di0Var, di0 di0Var2, long j, long j2, long j3, mc0 mc0Var, int i, ei eiVar, long j4, long j5, long j6, long j7, boolean z2, ww2 ww2Var, int i2, long j8, int i3, int i4, String str4, Boolean bool, int i5) {
        this(str, (i5 & 2) != 0 ? ww4.b : ww4Var, str2, (i5 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3, (i5 & 16) != 0 ? di0.b : di0Var, (i5 & 32) != 0 ? di0.b : di0Var2, (i5 & 64) != 0 ? 0L : j, (i5 & 128) != 0 ? 0L : j2, (i5 & 256) != 0 ? 0L : j3, (i5 & 512) != 0 ? mc0.j : mc0Var, (i5 & 1024) != 0 ? 0 : i, (i5 & 2048) != 0 ? ei.b : eiVar, (i5 & 4096) != 0 ? 30000L : j4, (i5 & 8192) != 0 ? -1L : j5, (i5 & 16384) == 0 ? j6 : 0L, (32768 & i5) != 0 ? -1L : j7, (65536 & i5) != 0 ? false : z2, (131072 & i5) != 0 ? ww2.b : ww2Var, (262144 & i5) != 0 ? 0 : i2, 0, (1048576 & i5) != 0 ? Long.MAX_VALUE : j8, (2097152 & i5) != 0 ? 0 : i3, (4194304 & i5) != 0 ? -256 : i4, (8388608 & i5) != 0 ? null : str4, (i5 & 16777216) != 0 ? Boolean.FALSE : bool);
    }

    public static gx4 b(gx4 gx4Var, String str, ww4 ww4Var, String str2, di0 di0Var, int i, long j, int i2, int i3, long j2, int i4, int i5) {
        String str3 = (i5 & 1) != 0 ? gx4Var.a : str;
        ww4 ww4Var2 = (i5 & 2) != 0 ? gx4Var.b : ww4Var;
        String str4 = (i5 & 4) != 0 ? gx4Var.c : str2;
        String str5 = gx4Var.d;
        di0 di0Var2 = (i5 & 16) != 0 ? gx4Var.e : di0Var;
        di0 di0Var3 = gx4Var.f;
        long j3 = gx4Var.g;
        long j4 = gx4Var.h;
        long j5 = gx4Var.i;
        mc0 mc0Var = gx4Var.j;
        int i6 = (i5 & 1024) != 0 ? gx4Var.k : i;
        ei eiVar = gx4Var.l;
        long j6 = gx4Var.m;
        long j7 = (i5 & 8192) != 0 ? gx4Var.n : j;
        long j8 = gx4Var.o;
        long j9 = gx4Var.p;
        boolean z2 = gx4Var.q;
        ww2 ww2Var = gx4Var.r;
        int i7 = (i5 & 262144) != 0 ? gx4Var.s : i2;
        int i8 = (i5 & 524288) != 0 ? gx4Var.t : i3;
        long j10 = (i5 & 1048576) != 0 ? gx4Var.u : j2;
        int i9 = (i5 & 2097152) != 0 ? gx4Var.v : i4;
        int i10 = gx4Var.w;
        String str6 = gx4Var.x;
        Boolean bool = gx4Var.y;
        str3.getClass();
        ww4Var2.getClass();
        str4.getClass();
        str5.getClass();
        di0Var2.getClass();
        di0Var3.getClass();
        mc0Var.getClass();
        eiVar.getClass();
        ww2Var.getClass();
        return new gx4(str3, ww4Var2, str4, str5, di0Var2, di0Var3, j3, j4, j5, mc0Var, i6, eiVar, j6, j7, j8, j9, z2, ww2Var, i7, i8, j10, i9, i10, str6, bool);
    }

    public final long a() {
        ww4 ww4Var = this.b;
        ww4 ww4Var2 = ww4.b;
        int i = this.k;
        boolean z2 = ww4Var == ww4Var2 && i > 0;
        long j = this.n;
        boolean zC = c();
        long j2 = this.g;
        long j3 = this.i;
        long j4 = this.h;
        long j5 = this.u;
        ei eiVar = this.l;
        eiVar.getClass();
        int i2 = this.s;
        if (j5 != Long.MAX_VALUE && zC) {
            if (i2 != 0) {
                long j6 = j + 900000;
                if (j5 < j6) {
                    return j6;
                }
            }
            return j5;
        }
        if (z2) {
            ei eiVar2 = ei.f;
            long j7 = this.m;
            long jScalb = eiVar == eiVar2 ? j7 * ((long) i) : (long) Math.scalb(j7, i - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j + jScalb;
        }
        if (zC) {
            long j8 = i2 == 0 ? j + j2 : j + j4;
            return (j3 == j4 || i2 != 0) ? j8 : (j4 - j3) + j8;
        }
        if (j == -1) {
            return Long.MAX_VALUE;
        }
        return j + j2;
    }

    public final boolean c() {
        return this.h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gx4)) {
            return false;
        }
        gx4 gx4Var = (gx4) obj;
        return n12.c(this.a, gx4Var.a) && this.b == gx4Var.b && n12.c(this.c, gx4Var.c) && n12.c(this.d, gx4Var.d) && n12.c(this.e, gx4Var.e) && n12.c(this.f, gx4Var.f) && this.g == gx4Var.g && this.h == gx4Var.h && this.i == gx4Var.i && n12.c(this.j, gx4Var.j) && this.k == gx4Var.k && this.l == gx4Var.l && this.m == gx4Var.m && this.n == gx4Var.n && this.o == gx4Var.o && this.p == gx4Var.p && this.q == gx4Var.q && this.r == gx4Var.r && this.s == gx4Var.s && this.t == gx4Var.t && this.u == gx4Var.u && this.v == gx4Var.v && this.w == gx4Var.w && n12.c(this.x, gx4Var.x) && n12.c(this.y, gx4Var.y);
    }

    public final int hashCode() {
        int iHashCode = (this.f.hashCode() + ((this.e.hashCode() + dw2.w(dw2.w((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c), 31, this.d)) * 31)) * 31;
        long j = this.g;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.h;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.i;
        int iHashCode2 = (this.l.hashCode() + ((((this.j.hashCode() + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.k) * 31)) * 31;
        long j4 = this.m;
        int i3 = (iHashCode2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.n;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.o;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.p;
        int iHashCode3 = (((((this.r.hashCode() + ((((i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.q ? 1231 : 1237)) * 31)) * 31) + this.s) * 31) + this.t) * 31;
        long j8 = this.u;
        int i6 = (((((iHashCode3 + ((int) ((j8 >>> 32) ^ j8))) * 31) + this.v) * 31) + this.w) * 31;
        String str = this.x;
        int iHashCode4 = (i6 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.y;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return fw.x(new StringBuilder("{WorkSpec: "), this.a, '}');
    }

    public gx4(String str, ww4 ww4Var, String str2, String str3, di0 di0Var, di0 di0Var2, long j, long j2, long j3, mc0 mc0Var, int i, ei eiVar, long j4, long j5, long j6, long j7, boolean z2, ww2 ww2Var, int i2, int i3, long j8, int i4, int i5, String str4, Boolean bool) {
        str.getClass();
        ww4Var.getClass();
        str2.getClass();
        str3.getClass();
        di0Var.getClass();
        di0Var2.getClass();
        mc0Var.getClass();
        eiVar.getClass();
        ww2Var.getClass();
        this.a = str;
        this.b = ww4Var;
        this.c = str2;
        this.d = str3;
        this.e = di0Var;
        this.f = di0Var2;
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = mc0Var;
        this.k = i;
        this.l = eiVar;
        this.m = j4;
        this.n = j5;
        this.o = j6;
        this.p = j7;
        this.q = z2;
        this.r = ww2Var;
        this.s = i2;
        this.t = i3;
        this.u = j8;
        this.v = i4;
        this.w = i5;
        this.x = str4;
        this.y = bool;
    }
}
