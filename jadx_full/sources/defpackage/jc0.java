package defpackage;

import android.view.View;
import io.netty.channel.internal.ChannelUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jc0 {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public int F;
    public int G;
    public final lb0 H;
    public final lb0 I;
    public final lb0 J;
    public final lb0 K;
    public final lb0 L;
    public final lb0 M;
    public final lb0 N;
    public final lb0 O;
    public final lb0[] P;
    public final ArrayList Q;
    public final boolean[] R;
    public kc0 S;
    public int T;
    public int U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public q20 b;
    public int b0;
    public q20 c;
    public float c0;
    public float d0;
    public View e0;
    public int f0;
    public String g0;
    public int h0;
    public int i0;
    public String j;
    public final float[] j0;
    public boolean k;
    public final jc0[] k0;
    public boolean l;
    public final jc0[] l0;
    public boolean m;
    public int m0;
    public boolean n;
    public int n0;
    public int o;
    public final int[] o0;
    public int p;
    public int q;
    public int r;
    public int s;
    public final int[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public float z;
    public boolean a = false;
    public ks1 d = null;
    public dp4 e = null;
    public final boolean[] f = {true, true};
    public boolean g = true;
    public int h = -1;
    public int i = -1;

    public jc0() {
        new HashMap();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = new int[2];
        this.u = 0;
        this.v = 0;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{ChannelUtils.WRITE_STATUS_SNDBUF_FULL, ChannelUtils.WRITE_STATUS_SNDBUF_FULL};
        this.D = Float.NaN;
        this.E = false;
        this.F = 0;
        this.G = 0;
        lb0 lb0Var = new lb0(this, 2);
        this.H = lb0Var;
        lb0 lb0Var2 = new lb0(this, 3);
        this.I = lb0Var2;
        lb0 lb0Var3 = new lb0(this, 4);
        this.J = lb0Var3;
        lb0 lb0Var4 = new lb0(this, 5);
        this.K = lb0Var4;
        lb0 lb0Var5 = new lb0(this, 6);
        this.L = lb0Var5;
        lb0 lb0Var6 = new lb0(this, 8);
        this.M = lb0Var6;
        lb0 lb0Var7 = new lb0(this, 9);
        this.N = lb0Var7;
        lb0 lb0Var8 = new lb0(this, 7);
        this.O = lb0Var8;
        this.P = new lb0[]{lb0Var, lb0Var3, lb0Var2, lb0Var4, lb0Var5, lb0Var8};
        ArrayList arrayList = new ArrayList();
        this.Q = arrayList;
        this.R = new boolean[2];
        this.o0 = new int[]{1, 1};
        this.S = null;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.c0 = 0.5f;
        this.d0 = 0.5f;
        this.f0 = 0;
        this.g0 = null;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = new float[]{-1.0f, -1.0f};
        this.k0 = new jc0[]{null, null};
        this.l0 = new jc0[]{null, null};
        this.m0 = -1;
        this.n0 = -1;
        arrayList.add(lb0Var);
        arrayList.add(lb0Var2);
        arrayList.add(lb0Var3);
        arrayList.add(lb0Var4);
        arrayList.add(lb0Var6);
        arrayList.add(lb0Var7);
        arrayList.add(lb0Var8);
        arrayList.add(lb0Var5);
    }

    public static void D(int i, int i2, String str, StringBuilder sb) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void E(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    public static void m(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        String str2;
        sb.append(str);
        sb.append(" :  {\n");
        if (i6 == 1) {
            str2 = "FIXED";
        } else if (i6 == 2) {
            str2 = "WRAP_CONTENT";
        } else if (i6 == 3) {
            str2 = "MATCH_CONSTRAINT";
        } else {
            if (i6 != 4) {
                throw null;
            }
            str2 = "MATCH_PARENT";
        }
        if (!"FIXED".equals(str2)) {
            ha0.v(sb, "      behavior", " :   ", str2, ",\n");
        }
        D(i, 0, "      size", sb);
        D(i2, 0, "      min", sb);
        D(i3, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, "      max", sb);
        D(i4, 0, "      matchMin", sb);
        D(i5, 0, "      matchDef", sb);
        E(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void n(StringBuilder sb, String str, lb0 lb0Var) {
        if (lb0Var.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(lb0Var.f);
        sb.append("'");
        if (lb0Var.h != Integer.MIN_VALUE || lb0Var.g != 0) {
            sb.append(",");
            sb.append(lb0Var.g);
            if (lb0Var.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(lb0Var.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public void A() {
        this.H.g();
        this.I.g();
        this.J.g();
        this.K.g();
        this.L.g();
        this.M.g();
        this.N.g();
        this.O.g();
        this.S = null;
        this.D = Float.NaN;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0.5f;
        this.d0 = 0.5f;
        int[] iArr = this.o0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.e0 = null;
        this.f0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        float[] fArr = this.j0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.r = 0;
        this.s = 0;
        this.w = 1.0f;
        this.z = 1.0f;
        this.v = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.y = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.u = 0;
        this.x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.R;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr3 = this.t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.h = -1;
        this.i = -1;
    }

    public final void B() {
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            lb0 lb0Var = (lb0) arrayList.get(i);
            lb0Var.c = false;
            lb0Var.b = 0;
        }
    }

    public void C(ed4 ed4Var) {
        this.H.h();
        this.I.h();
        this.J.h();
        this.K.h();
        this.L.h();
        this.O.h();
        this.M.h();
        this.N.h();
    }

    public final void F(int i, int i2) {
        if (this.k) {
            return;
        }
        this.H.i(i);
        this.J.i(i2);
        this.X = i;
        this.T = i2 - i;
        this.k = true;
    }

    public final void G(int i, int i2) {
        if (this.l) {
            return;
        }
        this.I.i(i);
        this.K.i(i2);
        this.Y = i;
        this.U = i2 - i;
        if (this.E) {
            this.L.i(i + this.Z);
        }
        this.l = true;
    }

    public final void H(int i) {
        this.U = i;
        int i2 = this.b0;
        if (i < i2) {
            this.U = i2;
        }
    }

    public final void I(int i) {
        this.o0[0] = i;
    }

    public final void J(int i) {
        this.o0[1] = i;
    }

    public final void K(int i) {
        this.T = i;
        int i2 = this.a0;
        if (i < i2) {
            this.T = i2;
        }
    }

    public void L(boolean z, boolean z2) {
        int i;
        int i2;
        ks1 ks1Var = this.d;
        boolean z3 = z & ks1Var.g;
        dp4 dp4Var = this.e;
        boolean z4 = z2 & dp4Var.g;
        int i3 = ks1Var.h.g;
        int i4 = dp4Var.h.g;
        int i5 = ks1Var.i.g;
        int i6 = dp4Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.X = i3;
        }
        if (z4) {
            this.Y = i4;
        }
        if (this.f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.o0;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.T)) {
                i8 = i2;
            }
            this.T = i8;
            int i10 = this.a0;
            if (i8 < i10) {
                this.T = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.U)) {
                i9 = i;
            }
            this.U = i9;
            int i11 = this.b0;
            if (i9 < i11) {
                this.U = i11;
            }
        }
    }

    public void M(gb2 gb2Var, boolean z) {
        int i;
        int i2;
        dp4 dp4Var;
        ks1 ks1Var;
        gb2Var.getClass();
        int iN = gb2.n(this.H);
        int iN2 = gb2.n(this.I);
        int iN3 = gb2.n(this.J);
        int iN4 = gb2.n(this.K);
        if (z && (ks1Var = this.d) != null) {
            oo0 oo0Var = ks1Var.h;
            if (oo0Var.j) {
                oo0 oo0Var2 = ks1Var.i;
                if (oo0Var2.j) {
                    iN = oo0Var.g;
                    iN3 = oo0Var2.g;
                }
            }
        }
        if (z && (dp4Var = this.e) != null) {
            oo0 oo0Var3 = dp4Var.h;
            if (oo0Var3.j) {
                oo0 oo0Var4 = dp4Var.i;
                if (oo0Var4.j) {
                    iN2 = oo0Var3.g;
                    iN4 = oo0Var4.g;
                }
            }
        }
        int i3 = iN4 - iN2;
        if (iN3 - iN < 0 || i3 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i4 = iN3 - iN;
        int i5 = iN4 - iN2;
        this.X = iN;
        this.Y = iN2;
        if (this.f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.o0;
        int i6 = iArr[0];
        if (i6 == 1 && i4 < (i2 = this.T)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.U)) {
            i5 = i;
        }
        this.T = i4;
        this.U = i5;
        int i7 = this.b0;
        if (i5 < i7) {
            this.U = i7;
        }
        int i8 = this.a0;
        if (i4 < i8) {
            this.T = i8;
        } else {
            i8 = i4;
        }
        int i9 = this.v;
        if (i9 > 0 && i6 == 3) {
            this.T = Math.min(i8, i9);
        }
        int i10 = this.y;
        if (i10 > 0 && iArr[1] == 3) {
            this.U = Math.min(this.U, i10);
        }
        int i11 = this.T;
        if (i4 != i11) {
            this.h = i11;
        }
        int i12 = this.U;
        if (i5 != i12) {
            this.i = i12;
        }
    }

    public final void a(kc0 kc0Var, gb2 gb2Var, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            ye.e(kc0Var, gb2Var, this);
            hashSet.remove(this);
            b(gb2Var, kc0Var.S(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.H.a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((lb0) it.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.J.a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((lb0) it2.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.I.a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((lb0) it3.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.K.a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((lb0) it4.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.L.a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((lb0) it5.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0413 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x041c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v27, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r58v0, types: [jc0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(gb2 gb2Var, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        kc0 kc0Var;
        kc0 kc0Var2;
        boolean[] zArr;
        lb0 lb0Var;
        boolean[] zArr2;
        lb0 lb0Var2;
        lb0 lb0Var3;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        int i8;
        int[] iArr;
        int i9;
        float f;
        lb0 lb0Var4;
        jz3 jz3Var;
        lb0 lb0Var5;
        int i10;
        int i11;
        int i12;
        boolean z5;
        boolean z6;
        lb0 lb0Var6;
        int i13;
        int[] iArr2;
        lb0 lb0Var7;
        ?? r4;
        int[] iArr3;
        lb0 lb0Var8;
        jz3 jz3Var2;
        jz3 jz3Var3;
        int[] iArr4;
        jz3 jz3Var4;
        boolean z7;
        ?? r3;
        jz3 jz3Var5;
        lb0 lb0Var9;
        jz3 jz3Var6;
        int i14;
        boolean[] zArr3;
        jz3 jz3Var7;
        jz3 jz3Var8;
        jz3 jz3Var9;
        int i15;
        int i16;
        boolean z8;
        int i17;
        jz3 jz3Var10;
        jz3 jz3Var11;
        dp4 dp4Var;
        boolean z9;
        ks1 ks1Var;
        int i18;
        boolean zV;
        int i19;
        boolean zW;
        ks1 ks1Var2;
        dp4 dp4Var2;
        boolean z10;
        gb2 gb2Var2 = gb2Var;
        lb0 lb0Var10 = this.H;
        jz3 jz3VarK = gb2Var2.k(lb0Var10);
        lb0 lb0Var11 = this.J;
        jz3 jz3VarK2 = gb2Var2.k(lb0Var11);
        lb0 lb0Var12 = this.I;
        jz3 jz3VarK3 = gb2Var2.k(lb0Var12);
        lb0 lb0Var13 = this.K;
        jz3 jz3VarK4 = gb2Var2.k(lb0Var13);
        lb0 lb0Var14 = this.L;
        jz3 jz3VarK5 = gb2Var2.k(lb0Var14);
        kc0 kc0Var3 = this.S;
        if (kc0Var3 != null) {
            int[] iArr5 = kc0Var3.o0;
            i = 0;
            i3 = iArr5[0] == 2 ? 1 : 0;
            int i20 = iArr5[1] == 2 ? 1 : 0;
            int i21 = this.q;
            if (i21 != 1) {
                if (i21 == 2) {
                    i3 = 0;
                } else if (i21 != 3) {
                }
                i2 = i20;
            } else {
                i2 = 0;
            }
            i4 = this.f0;
            boolean[] zArr4 = this.R;
            int i22 = i2;
            if (i4 != 8) {
                ArrayList arrayList = this.Q;
                int size = arrayList.size();
                i5 = i3;
                int i23 = i;
                while (true) {
                    if (i23 < size) {
                        int i24 = size;
                        HashSet hashSet = ((lb0) arrayList.get(i23)).a;
                        if (hashSet != null && hashSet.size() > 0) {
                            break;
                        }
                        i23++;
                        size = i24;
                    } else if (!zArr4[i] && !zArr4[1]) {
                        return;
                    }
                }
            } else {
                i5 = i3;
            }
            z2 = this.k;
            if (!z2 || this.l) {
                if (z2) {
                    gb2Var2.d(jz3VarK, this.X);
                    gb2Var2.d(jz3VarK2, this.X + this.T);
                    if (i5 != 0 && (kc0Var2 = this.S) != null) {
                        WeakReference weakReference = kc0Var2.G0;
                        if (weakReference == null || weakReference.get() == null || lb0Var10.c() > ((lb0) kc0Var2.G0.get()).c()) {
                            kc0Var2.G0 = new WeakReference(lb0Var10);
                        }
                        WeakReference weakReference2 = kc0Var2.I0;
                        if (weakReference2 == null || weakReference2.get() == null || lb0Var11.c() > ((lb0) kc0Var2.I0.get()).c()) {
                            kc0Var2.I0 = new WeakReference(lb0Var11);
                        }
                    }
                }
                if (this.l) {
                    gb2Var2.d(jz3VarK3, this.Y);
                    gb2Var2.d(jz3VarK4, this.Y + this.U);
                    HashSet hashSet2 = lb0Var14.a;
                    if (hashSet2 != null && hashSet2.size() > 0) {
                        gb2Var2.d(jz3VarK5, this.Y + this.Z);
                    }
                    if (i22 != 0 && (kc0Var = this.S) != null) {
                        WeakReference weakReference3 = kc0Var.F0;
                        if (weakReference3 == null || weakReference3.get() == null || lb0Var12.c() > ((lb0) kc0Var.F0.get()).c()) {
                            kc0Var.F0 = new WeakReference(lb0Var12);
                        }
                        WeakReference weakReference4 = kc0Var.H0;
                        if (weakReference4 == null || weakReference4.get() == null || lb0Var13.c() > ((lb0) kc0Var.H0.get()).c()) {
                            kc0Var.H0 = new WeakReference(lb0Var13);
                        }
                    }
                }
                if (this.k && this.l) {
                    ?? r12 = i;
                    this.k = r12;
                    this.l = r12;
                    return;
                }
            }
            zArr = this.f;
            if (z || (ks1Var2 = this.d) == null || (dp4Var2 = this.e) == null) {
                lb0Var = lb0Var14;
                zArr2 = zArr;
            } else {
                lb0Var = lb0Var14;
                oo0 oo0Var = ks1Var2.h;
                zArr2 = zArr;
                if (oo0Var.j && ks1Var2.i.j && dp4Var2.h.j && dp4Var2.i.j) {
                    gb2Var2.d(jz3VarK, oo0Var.g);
                    gb2Var2.d(jz3VarK2, this.d.i.g);
                    gb2Var2.d(jz3VarK3, this.e.h.g);
                    gb2Var2.d(jz3VarK4, this.e.i.g);
                    gb2Var2.d(jz3VarK5, this.e.k.g);
                    if (this.S == null) {
                        z10 = false;
                    } else {
                        if (i5 != 0 && zArr2[0] && !v()) {
                            gb2Var2.f(gb2Var2.k(this.S.J), jz3VarK2, 0, 8);
                        }
                        if (i22 != 0 && zArr2[1] && !w()) {
                            z10 = false;
                            gb2Var2.f(gb2Var2.k(this.S.K), jz3VarK4, 0, 8);
                        }
                    }
                    this.k = z10;
                    this.l = z10;
                    return;
                }
            }
            if (this.S == null) {
                if (u(0)) {
                    this.S.N(this, 0);
                    zV = true;
                    i19 = 1;
                } else {
                    zV = v();
                    i19 = 1;
                }
                if (u(i19)) {
                    this.S.N(this, i19);
                    zW = true;
                } else {
                    zW = w();
                }
                if (zV || i5 == 0 || this.f0 == 8 || lb0Var10.f != null || lb0Var11.f != null) {
                    lb0Var2 = lb0Var10;
                } else {
                    lb0Var2 = lb0Var10;
                    gb2Var2.f(gb2Var2.k(this.S.J), jz3VarK2, 0, 1);
                }
                if (!zW && i22 != 0 && this.f0 != 8 && lb0Var12.f == null && lb0Var13.f == null && lb0Var == null) {
                    gb2Var2.f(gb2Var2.k(this.S.K), jz3VarK4, 0, 1);
                }
                lb0Var3 = lb0Var11;
                i6 = i22;
                z4 = zW;
                z3 = zV;
            } else {
                lb0Var2 = lb0Var10;
                lb0Var3 = lb0Var11;
                i6 = i22;
                z3 = false;
                z4 = false;
            }
            i7 = this.T;
            i8 = this.a0;
            if (i7 >= i8) {
                i8 = i7;
            }
            int i25 = this.U;
            lb0 lb0Var15 = lb0Var3;
            int i26 = this.b0;
            int i27 = i25 >= i26 ? i26 : i25;
            iArr = this.o0;
            int i28 = iArr[0];
            int i29 = i6;
            boolean z11 = i28 == 3;
            int i30 = iArr[1];
            boolean z12 = i30 == 3;
            i9 = this.W;
            this.A = i9;
            float f2 = this.V;
            this.B = f2;
            f = f2;
            int i31 = this.r;
            int i32 = this.s;
            if (f <= 0.0f) {
                lb0Var4 = lb0Var13;
                if (this.f0 != 8) {
                    int i33 = (i28 == 3 && i31 == 0) ? 3 : i31;
                    if (i30 == 3 && i32 == 0) {
                        jz3Var = jz3VarK4;
                        i18 = 3;
                    } else {
                        jz3Var = jz3VarK4;
                        i18 = i32;
                    }
                    if (i28 != 3 || i30 != 3 || i33 != 3 || i18 != 3) {
                        if (i28 == 3 && i33 == 3) {
                            this.A = 0;
                            i8 = (int) (f * i25);
                            if (i30 != 3) {
                                lb0Var5 = lb0Var;
                                i10 = i27;
                                i9 = 0;
                                i11 = 4;
                                z5 = false;
                                i12 = i18;
                                int[] iArr6 = this.t;
                                iArr6[0] = i11;
                                iArr6[1] = i12;
                                boolean z13 = !z5 && (i9 == 0 || i9 == -1);
                                boolean z14 = !z5 && (i9 == 1 || i9 == -1);
                                z6 = iArr[0] != 2 && (this instanceof kc0);
                                if (z6) {
                                    i8 = 0;
                                }
                                lb0Var6 = this.O;
                                boolean z15 = !lb0Var6.f();
                                char c = '\b';
                                boolean z16 = zArr4[0];
                                boolean z17 = zArr4[1];
                                i13 = this.o;
                                iArr2 = this.C;
                                if (i13 != 2 || this.k) {
                                    lb0Var7 = lb0Var6;
                                    r4 = i29;
                                    iArr3 = iArr;
                                    lb0Var8 = lb0Var5;
                                    jz3Var2 = jz3VarK;
                                    jz3Var3 = jz3VarK2;
                                    iArr4 = iArr2;
                                    jz3Var4 = jz3VarK5;
                                    z7 = z3;
                                    r3 = i5;
                                    jz3Var5 = jz3VarK3;
                                    lb0Var9 = lb0Var4;
                                    jz3Var6 = jz3Var;
                                    i14 = i11;
                                    zArr3 = zArr2;
                                } else {
                                    if (z && (ks1Var = this.d) != null) {
                                        oo0 oo0Var2 = ks1Var.h;
                                        if (oo0Var2.j && ks1Var.i.j) {
                                            if (z) {
                                                gb2Var2.d(jz3VarK, oo0Var2.g);
                                                gb2Var2.d(jz3VarK2, this.d.i.g);
                                                if (this.S != null && i5 != 0 && zArr2[0] && !v()) {
                                                    gb2Var2.f(gb2Var2.k(this.S.J), jz3VarK2, 0, 8);
                                                }
                                            }
                                            lb0Var7 = lb0Var6;
                                            r4 = i29;
                                            iArr3 = iArr;
                                            lb0Var8 = lb0Var5;
                                            jz3Var2 = jz3VarK;
                                            jz3Var3 = jz3VarK2;
                                            iArr4 = iArr2;
                                            jz3Var4 = jz3VarK5;
                                            z7 = z3;
                                            r3 = i5;
                                            jz3Var5 = jz3VarK3;
                                            lb0Var9 = lb0Var4;
                                            jz3Var6 = jz3Var;
                                            i14 = i11;
                                            zArr3 = zArr2;
                                        } else {
                                            c = '\b';
                                        }
                                    }
                                    kc0 kc0Var4 = this.S;
                                    jz3 jz3VarK6 = kc0Var4 != null ? gb2Var2.k(kc0Var4.J) : null;
                                    kc0 kc0Var5 = this.S;
                                    jz3 jz3VarK7 = kc0Var5 != null ? gb2Var2.k(kc0Var5.H) : null;
                                    z7 = z3;
                                    ?? r32 = i5;
                                    i14 = i11;
                                    iArr4 = iArr2;
                                    lb0Var7 = lb0Var6;
                                    ?? r42 = i29;
                                    iArr3 = iArr;
                                    jz3Var5 = jz3VarK3;
                                    jz3Var3 = jz3VarK2;
                                    lb0Var9 = lb0Var4;
                                    jz3Var6 = jz3Var;
                                    jz3Var2 = jz3VarK;
                                    lb0Var8 = lb0Var5;
                                    jz3Var4 = jz3VarK5;
                                    gb2Var2 = gb2Var;
                                    zArr3 = zArr2;
                                    d(gb2Var2, true, r32, r42, zArr2[0], jz3VarK7, jz3VarK6, iArr[0], z6, this.H, this.J, this.X, i8, this.a0, iArr2[0], this.c0, z13, iArr[1] == 3, z7, z4, z16, i14, i12, this.u, this.v, this.w, z15);
                                    r3 = r32;
                                    r4 = r42;
                                }
                                if (z || (dp4Var = this.e) == null) {
                                    jz3Var7 = jz3Var5;
                                    jz3Var8 = jz3Var6;
                                    jz3Var9 = jz3Var4;
                                    i15 = 0;
                                    i16 = 8;
                                    z8 = true;
                                    i17 = 1;
                                } else {
                                    oo0 oo0Var3 = dp4Var.h;
                                    if (oo0Var3.j && dp4Var.i.j) {
                                        int i34 = oo0Var3.g;
                                        jz3Var7 = jz3Var5;
                                        gb2Var2.d(jz3Var7, i34);
                                        jz3Var8 = jz3Var6;
                                        gb2Var2.d(jz3Var8, this.e.i.g);
                                        jz3Var9 = jz3Var4;
                                        gb2Var2.d(jz3Var9, this.e.k.g);
                                        kc0 kc0Var6 = this.S;
                                        if (kc0Var6 == null || z4 || r4 == 0) {
                                            i15 = 0;
                                            i16 = 8;
                                            z9 = true;
                                        } else {
                                            z9 = true;
                                            z9 = true;
                                            if (zArr3[1]) {
                                                i15 = 0;
                                                i16 = 8;
                                                gb2Var2.f(gb2Var2.k(kc0Var6.K), jz3Var8, 0, 8);
                                            } else {
                                                i15 = 0;
                                                i16 = 8;
                                            }
                                        }
                                        i17 = i15;
                                        z8 = z9;
                                    }
                                }
                                if (this.p == 2) {
                                    i17 = i15;
                                }
                                if (i17 != 0 || this.l) {
                                    jz3Var10 = jz3Var7;
                                    jz3Var11 = jz3Var8;
                                } else {
                                    int i35 = (iArr3[z8 ? 1 : 0] == 2 && (this instanceof kc0)) ? z8 ? 1 : 0 : i15;
                                    int i36 = i35 != 0 ? i15 : i10;
                                    kc0 kc0Var7 = this.S;
                                    jz3 jz3VarK8 = kc0Var7 != null ? gb2Var2.k(kc0Var7.K) : null;
                                    kc0 kc0Var8 = this.S;
                                    jz3 jz3VarK9 = kc0Var8 != null ? gb2Var2.k(kc0Var8.I) : null;
                                    int i37 = this.Z;
                                    if (i37 <= 0) {
                                        ?? r27 = z15;
                                        if (this.f0 == i16) {
                                            lb0 lb0Var16 = lb0Var8;
                                            if (lb0Var16.f != null) {
                                                gb2Var2.e(jz3Var9, jz3Var7, i37, i16);
                                                gb2Var2.e(jz3Var9, gb2Var2.k(lb0Var16.f), lb0Var16.d(), i16);
                                                if (r4 != 0) {
                                                    gb2Var2.f(jz3VarK8, gb2Var2.k(lb0Var9), i15, 5);
                                                }
                                                r27 = i15;
                                            } else if (this.f0 == i16) {
                                                gb2Var2.e(jz3Var9, jz3Var7, lb0Var16.d(), i16);
                                                r27 = z15;
                                            } else {
                                                gb2Var2.e(jz3Var9, jz3Var7, i37, i16);
                                                r27 = z15;
                                            }
                                        }
                                        boolean z18 = zArr3[z8 ? 1 : 0];
                                        int i38 = i15;
                                        int i39 = iArr3[z8 ? 1 : 0];
                                        int i40 = this.Y;
                                        int i41 = this.b0;
                                        int i42 = iArr4[z8 ? 1 : 0];
                                        float f3 = this.d0;
                                        int i43 = iArr3[i38];
                                        boolean z19 = z8 ? 1 : 0;
                                        ?? r18 = z8;
                                        if (i43 != 3) {
                                            r18 = i38;
                                        }
                                        jz3Var11 = jz3Var8;
                                        jz3Var10 = jz3Var7;
                                        gb2Var2 = gb2Var;
                                        d(gb2Var2, false, r4, r3, z18, jz3VarK9, jz3VarK8, i39, i35, this.I, this.K, i40, i36, i41, i42, f3, z14, r18, z4, z7, z17, i12, i14, this.x, this.y, this.z, r27);
                                    }
                                }
                                if (z5) {
                                    int i44 = this.A;
                                    float f4 = this.B;
                                    if (i44 == 1) {
                                        ke keVarL = gb2Var2.l();
                                        keVarL.d.g(jz3Var11, -1.0f);
                                        keVarL.d.g(jz3Var10, 1.0f);
                                        keVarL.d.g(jz3Var3, f4);
                                        keVarL.d.g(jz3Var2, -f4);
                                        gb2Var2.c(keVarL);
                                    } else {
                                        ke keVarL2 = gb2Var2.l();
                                        keVarL2.d.g(jz3Var3, -1.0f);
                                        keVarL2.d.g(jz3Var2, 1.0f);
                                        keVarL2.d.g(jz3Var11, f4);
                                        keVarL2.d.g(jz3Var10, -f4);
                                        gb2Var2.c(keVarL2);
                                    }
                                }
                                if (lb0Var7.f()) {
                                    lb0 lb0Var17 = lb0Var7;
                                    jc0 jc0Var = lb0Var17.f.d;
                                    float radians = (float) Math.toRadians(this.D + 90.0f);
                                    int iD = lb0Var17.d();
                                    jz3 jz3VarK10 = gb2Var2.k(g(2));
                                    jz3 jz3VarK11 = gb2Var2.k(g(3));
                                    jz3 jz3VarK12 = gb2Var2.k(g(4));
                                    jz3 jz3VarK13 = gb2Var2.k(g(5));
                                    jz3 jz3VarK14 = gb2Var2.k(jc0Var.g(2));
                                    jz3 jz3VarK15 = gb2Var2.k(jc0Var.g(3));
                                    jz3 jz3VarK16 = gb2Var2.k(jc0Var.g(4));
                                    jz3 jz3VarK17 = gb2Var2.k(jc0Var.g(5));
                                    ke keVarL3 = gb2Var2.l();
                                    double d = radians;
                                    double dSin = Math.sin(d);
                                    double d2 = iD;
                                    keVarL3.d.g(jz3VarK15, 0.5f);
                                    keVarL3.d.g(jz3VarK17, 0.5f);
                                    keVarL3.d.g(jz3VarK11, -0.5f);
                                    keVarL3.d.g(jz3VarK13, -0.5f);
                                    keVarL3.b = -((float) (dSin * d2));
                                    gb2Var2.c(keVarL3);
                                    ke keVarL4 = gb2Var2.l();
                                    float fCos = (float) (Math.cos(d) * d2);
                                    keVarL4.d.g(jz3VarK14, 0.5f);
                                    keVarL4.d.g(jz3VarK16, 0.5f);
                                    keVarL4.d.g(jz3VarK10, -0.5f);
                                    keVarL4.d.g(jz3VarK12, -0.5f);
                                    keVarL4.b = -fCos;
                                    gb2Var2.c(keVarL4);
                                }
                                this.k = false;
                                this.l = false;
                            }
                            i11 = i33;
                            lb0Var5 = lb0Var;
                            i10 = i27;
                            i9 = 0;
                        } else if (i30 == 3 && i18 == 3) {
                            this.A = 1;
                            if (i9 == -1) {
                                float f5 = 1.0f / f;
                                this.B = f5;
                                f = f5;
                            }
                            i10 = (int) (i7 * f);
                            if (i28 != 3) {
                                i11 = i33;
                                lb0Var5 = lb0Var;
                                i9 = 1;
                                i12 = 4;
                            } else {
                                i11 = i33;
                                lb0Var5 = lb0Var;
                                i9 = 1;
                            }
                        }
                        z5 = true;
                        i12 = i18;
                        int[] iArr62 = this.t;
                        iArr62[0] = i11;
                        iArr62[1] = i12;
                        if (z5) {
                        }
                        if (z5) {
                        }
                        if (iArr[0] != 2) {
                        }
                        if (z6) {
                        }
                        lb0Var6 = this.O;
                        boolean z152 = !lb0Var6.f();
                        char c2 = '\b';
                        boolean z162 = zArr4[0];
                        boolean z172 = zArr4[1];
                        i13 = this.o;
                        iArr2 = this.C;
                        if (i13 != 2) {
                            lb0Var7 = lb0Var6;
                            r4 = i29;
                            iArr3 = iArr;
                            lb0Var8 = lb0Var5;
                            jz3Var2 = jz3VarK;
                            jz3Var3 = jz3VarK2;
                            iArr4 = iArr2;
                            jz3Var4 = jz3VarK5;
                            z7 = z3;
                            r3 = i5;
                            jz3Var5 = jz3VarK3;
                            lb0Var9 = lb0Var4;
                            jz3Var6 = jz3Var;
                            i14 = i11;
                            zArr3 = zArr2;
                        }
                        if (z) {
                            jz3Var7 = jz3Var5;
                            jz3Var8 = jz3Var6;
                            jz3Var9 = jz3Var4;
                            i15 = 0;
                            i16 = 8;
                            z8 = true;
                            i17 = 1;
                        }
                        if (this.p == 2) {
                        }
                        if (i17 != 0) {
                            jz3Var10 = jz3Var7;
                            jz3Var11 = jz3Var8;
                        }
                        if (z5) {
                        }
                        if (lb0Var7.f()) {
                        }
                        this.k = false;
                        this.l = false;
                    }
                    if (i9 == -1) {
                        if (z11 && !z12) {
                            this.A = 0;
                            i9 = 0;
                        } else if (!z11 && z12) {
                            this.A = 1;
                            if (i9 == -1) {
                                this.B = 1.0f / f;
                            }
                            i9 = 1;
                        }
                    }
                    if (i9 == 0 && (!lb0Var12.f() || !lb0Var4.f())) {
                        this.A = 1;
                    } else if (this.A == 1 && (!lb0Var2.f() || !lb0Var15.f())) {
                        this.A = 0;
                    }
                    if (this.A == -1 && (!lb0Var12.f() || !lb0Var4.f() || !lb0Var2.f() || !lb0Var15.f())) {
                        if (lb0Var12.f() && lb0Var4.f()) {
                            this.A = 0;
                        } else if (lb0Var2.f() && lb0Var15.f()) {
                            this.B = 1.0f / this.B;
                            this.A = 1;
                        }
                    }
                    int i45 = this.A;
                    if (i45 == -1) {
                        int i46 = this.u;
                        if (i46 > 0 && this.x == 0) {
                            this.A = 0;
                            i45 = 0;
                        } else if (i46 == 0 && this.x > 0) {
                            this.B = 1.0f / this.B;
                            this.A = 1;
                            i45 = 1;
                        }
                    }
                    i9 = i45;
                    i11 = i33;
                    lb0Var5 = lb0Var;
                    i10 = i27;
                    z5 = true;
                    i12 = i18;
                    int[] iArr622 = this.t;
                    iArr622[0] = i11;
                    iArr622[1] = i12;
                    if (z5) {
                    }
                    if (z5) {
                    }
                    if (iArr[0] != 2) {
                    }
                    if (z6) {
                    }
                    lb0Var6 = this.O;
                    boolean z1522 = !lb0Var6.f();
                    char c22 = '\b';
                    boolean z1622 = zArr4[0];
                    boolean z1722 = zArr4[1];
                    i13 = this.o;
                    iArr2 = this.C;
                    if (i13 != 2) {
                    }
                    if (z) {
                    }
                    if (this.p == 2) {
                    }
                    if (i17 != 0) {
                    }
                    if (z5) {
                    }
                    if (lb0Var7.f()) {
                    }
                    this.k = false;
                    this.l = false;
                }
                z5 = false;
                int[] iArr6222 = this.t;
                iArr6222[0] = i11;
                iArr6222[1] = i12;
                if (z5) {
                }
                if (z5) {
                }
                if (iArr[0] != 2) {
                }
                if (z6) {
                }
                lb0Var6 = this.O;
                boolean z15222 = !lb0Var6.f();
                char c222 = '\b';
                boolean z16222 = zArr4[0];
                boolean z17222 = zArr4[1];
                i13 = this.o;
                iArr2 = this.C;
                if (i13 != 2) {
                }
                if (z) {
                }
                if (this.p == 2) {
                }
                if (i17 != 0) {
                }
                if (z5) {
                }
                if (lb0Var7.f()) {
                }
                this.k = false;
                this.l = false;
            }
            lb0Var4 = lb0Var13;
            jz3Var = jz3VarK4;
            lb0Var5 = lb0Var;
            i10 = i27;
            i11 = i31;
            i12 = i32;
            z5 = false;
            int[] iArr62222 = this.t;
            iArr62222[0] = i11;
            iArr62222[1] = i12;
            if (z5) {
            }
            if (z5) {
            }
            if (iArr[0] != 2) {
            }
            if (z6) {
            }
            lb0Var6 = this.O;
            boolean z152222 = !lb0Var6.f();
            char c2222 = '\b';
            boolean z162222 = zArr4[0];
            boolean z172222 = zArr4[1];
            i13 = this.o;
            iArr2 = this.C;
            if (i13 != 2) {
            }
            if (z) {
            }
            if (this.p == 2) {
            }
            if (i17 != 0) {
            }
            if (z5) {
            }
            if (lb0Var7.f()) {
            }
            this.k = false;
            this.l = false;
        }
        i = 0;
        i2 = i;
        i3 = i2;
        i4 = this.f0;
        boolean[] zArr42 = this.R;
        int i222 = i2;
        if (i4 != 8) {
        }
        z2 = this.k;
        if (!z2) {
            if (z2) {
            }
            if (this.l) {
            }
            if (this.k) {
                ?? r122 = i;
                this.k = r122;
                this.l = r122;
                return;
            }
        }
        zArr = this.f;
        if (z) {
            lb0Var = lb0Var14;
            zArr2 = zArr;
        }
        if (this.S == null) {
        }
        i7 = this.T;
        i8 = this.a0;
        if (i7 >= i8) {
        }
        int i252 = this.U;
        lb0 lb0Var152 = lb0Var3;
        int i262 = this.b0;
        if (i252 >= i262) {
        }
        iArr = this.o0;
        int i282 = iArr[0];
        int i292 = i6;
        if (i282 == 3) {
        }
        int i302 = iArr[1];
        if (i302 == 3) {
        }
        i9 = this.W;
        this.A = i9;
        float f22 = this.V;
        this.B = f22;
        f = f22;
        int i312 = this.r;
        int i322 = this.s;
        if (f <= 0.0f) {
        }
        jz3Var = jz3VarK4;
        lb0Var5 = lb0Var;
        i10 = i27;
        i11 = i312;
        i12 = i322;
        z5 = false;
        int[] iArr622222 = this.t;
        iArr622222[0] = i11;
        iArr622222[1] = i12;
        if (z5) {
        }
        if (z5) {
        }
        if (iArr[0] != 2) {
        }
        if (z6) {
        }
        lb0Var6 = this.O;
        boolean z1522222 = !lb0Var6.f();
        char c22222 = '\b';
        boolean z1622222 = zArr42[0];
        boolean z1722222 = zArr42[1];
        i13 = this.o;
        iArr2 = this.C;
        if (i13 != 2) {
        }
        if (z) {
        }
        if (this.p == 2) {
        }
        if (i17 != 0) {
        }
        if (z5) {
        }
        if (lb0Var7.f()) {
        }
        this.k = false;
        this.l = false;
    }

    public boolean c() {
        return this.f0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0493 A[PHI: r0
      0x0493: PHI (r0v15 int) = (r0v14 int), (r0v19 int), (r0v19 int), (r0v19 int) binds: [B:280:0x0483, B:282:0x0489, B:283:0x048b, B:285:0x048f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(gb2 gb2Var, boolean z, boolean z2, boolean z3, boolean z4, jz3 jz3Var, jz3 jz3Var2, int i, boolean z5, lb0 lb0Var, lb0 lb0Var2, int i2, int i3, int i4, int i5, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f2, boolean z11) {
        boolean z12;
        boolean z13;
        int iMin;
        boolean z14;
        boolean z15;
        int i10;
        int i11;
        boolean z16;
        jz3 jz3VarK;
        jz3 jz3VarK2;
        lb0 lb0Var3;
        jz3 jz3Var3;
        boolean z17;
        int i12;
        jz3 jz3Var4;
        jz3 jz3Var5;
        jz3 jz3Var6;
        jz3 jz3Var7;
        int i13;
        int i14;
        int i15;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        jc0 jc0Var;
        int i16;
        int i17;
        lb0 lb0Var4;
        boolean z22;
        int iMin2;
        boolean z23;
        int i18;
        HashSet hashSet;
        boolean z24;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z25;
        boolean z26;
        int i24;
        gb2 gb2Var2 = gb2Var;
        int i25 = i8;
        int i26 = i9;
        jz3 jz3VarK3 = gb2Var2.k(lb0Var);
        jz3 jz3VarK4 = gb2Var2.k(lb0Var2);
        jz3 jz3VarK5 = gb2Var2.k(lb0Var.f);
        jz3 jz3VarK6 = gb2Var2.k(lb0Var2.f);
        boolean zF = lb0Var.f();
        boolean zF2 = lb0Var2.f();
        boolean zF3 = this.O.f();
        int i27 = zF2 ? (zF ? 1 : 0) + 1 : zF ? 1 : 0;
        if (zF3) {
            i27++;
        }
        int i28 = i27;
        int i29 = z6 ? 3 : i6;
        int iG = fw.G(i);
        boolean z27 = (iG == 0 || iG == 1 || iG != 2 || i29 == 4) ? false : true;
        int i30 = this.h;
        if (i30 == -1 || !z) {
            i30 = i3;
            z12 = z27;
        } else {
            this.h = -1;
            z12 = false;
        }
        int i31 = this.i;
        if (i31 == -1 || z) {
            z13 = z12;
        } else {
            this.i = -1;
            i30 = i31;
            z13 = false;
        }
        boolean z28 = z13;
        if (this.f0 == 8) {
            z14 = false;
            iMin = 0;
        } else {
            iMin = i30;
            z14 = z28;
        }
        if (z11) {
            if (!zF && !zF2 && !zF3) {
                gb2Var2.d(jz3VarK3, i2);
            } else if (zF && !zF2) {
                z15 = z14;
                i10 = 8;
                gb2Var2.e(jz3VarK3, jz3VarK5, lb0Var.d(), 8);
            }
            z15 = z14;
            i10 = 8;
        } else {
            z15 = z14;
            i10 = 8;
        }
        if (z15) {
            if (i28 == 2 || z6 || !(i29 == 1 || i29 == 0)) {
                if (i25 == -2) {
                    i25 = iMin;
                }
                if (i26 == -2) {
                    i26 = iMin;
                }
                if (iMin > 0 && i29 != 1) {
                    iMin = 0;
                }
                if (i25 > 0) {
                    gb2Var2.f(jz3VarK4, jz3VarK3, i25, 8);
                    iMin = Math.max(iMin, i25);
                }
                if (i26 > 0) {
                    if (!z2 || i29 != 1) {
                        gb2Var2.g(jz3VarK4, jz3VarK3, i26, 8);
                    }
                    iMin = Math.min(iMin, i26);
                }
                if (i29 == 1) {
                    if (z2) {
                        gb2Var2.e(jz3VarK4, jz3VarK3, iMin, 8);
                    } else if (z8) {
                        gb2Var2.e(jz3VarK4, jz3VarK3, iMin, 5);
                        gb2Var2.g(jz3VarK4, jz3VarK3, iMin, 8);
                    } else {
                        gb2Var2.e(jz3VarK4, jz3VarK3, iMin, 5);
                        gb2Var2.g(jz3VarK4, jz3VarK3, iMin, 8);
                    }
                } else if (i29 == 2) {
                    int i32 = lb0Var.e;
                    if (i32 == 3 || i32 == 5) {
                        jz3VarK = gb2Var2.k(this.S.g(3));
                        jz3VarK2 = gb2Var2.k(this.S.g(5));
                    } else {
                        jz3VarK = gb2Var2.k(this.S.g(2));
                        jz3VarK2 = gb2Var2.k(this.S.g(4));
                    }
                    ke keVarL = gb2Var2.l();
                    int i33 = i25;
                    keVarL.d.g(jz3VarK4, -1.0f);
                    keVarL.d.g(jz3VarK3, 1.0f);
                    keVarL.d.g(jz3VarK2, f2);
                    keVarL.d.g(jz3VarK, -f2);
                    gb2Var2.c(keVarL);
                    if (z2) {
                        z15 = false;
                    }
                    z16 = z4;
                    i11 = i33;
                } else {
                    i11 = i25;
                    z16 = true;
                }
            } else {
                int iMax = Math.max(i25, iMin);
                if (i26 > 0) {
                    iMax = Math.min(i26, iMax);
                }
                gb2Var2.e(jz3VarK4, jz3VarK3, iMax, 8);
                z16 = z4;
                i11 = i25;
                z15 = false;
            }
            if (z11 || z8) {
                boolean z29 = z16;
                if (i28 >= 2 && z2 && z29) {
                    gb2Var2.f(jz3VarK3, jz3Var, 0, 8);
                    lb0 lb0Var5 = this.L;
                    boolean z30 = z || lb0Var5.f == null;
                    if (!z && (lb0Var3 = lb0Var5.f) != null) {
                        jc0 jc0Var2 = lb0Var3.d;
                        if (jc0Var2.V != 0.0f) {
                            int[] iArr = jc0Var2.o0;
                            z30 = iArr[0] == 3 && iArr[1] == 3;
                        }
                    }
                    if (z30) {
                        gb2Var2.f(jz3Var2, jz3VarK4, 0, 8);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!zF && !zF2 && !zF3) {
                lb0Var4 = lb0Var2;
                jz3Var6 = jz3VarK4;
                z17 = z16;
                jz3Var3 = jz3VarK6;
            } else if (!zF || zF2) {
                if (zF || !zF2) {
                    jz3Var3 = jz3VarK6;
                    if (zF && zF2) {
                        jc0 jc0Var3 = lb0Var.f.d;
                        jc0 jc0Var4 = lb0Var2.f.d;
                        z17 = z16;
                        kc0 kc0Var = this.S;
                        int i34 = 6;
                        if (z15) {
                            if (i29 == 0) {
                                if (i26 != 0 || i11 != 0) {
                                    i22 = 5;
                                    i23 = 5;
                                    z25 = true;
                                    z26 = false;
                                    z19 = true;
                                } else if (jz3VarK5.Y && jz3Var3.Y) {
                                    gb2Var2.e(jz3VarK3, jz3VarK5, lb0Var.d(), 8);
                                    gb2Var2.e(jz3VarK4, jz3Var3, -lb0Var2.d(), 8);
                                    return;
                                } else {
                                    i22 = 8;
                                    i23 = 8;
                                    z25 = false;
                                    z26 = true;
                                    z19 = false;
                                }
                                if ((jc0Var3 instanceof wj) || (jc0Var4 instanceof wj)) {
                                    gb2Var2 = gb2Var;
                                    i12 = i29;
                                    jz3Var5 = jz3VarK3;
                                    jz3Var6 = jz3VarK4;
                                    z20 = z26;
                                    jz3Var4 = jz3Var2;
                                    i14 = i22;
                                    jz3Var7 = jz3VarK5;
                                    i13 = 6;
                                    z18 = z25;
                                    i15 = 4;
                                    if (z19 || jz3Var7 != jz3Var3 || jc0Var3 == kc0Var) {
                                        z21 = true;
                                    } else {
                                        z19 = false;
                                        z21 = false;
                                    }
                                    if (z18) {
                                        jc0Var = jc0Var4;
                                        i16 = i11;
                                        i17 = i12;
                                        lb0Var4 = lb0Var2;
                                        z22 = z2;
                                    } else {
                                        if (z15 || z7 || z9 || jz3Var7 != jz3Var || jz3Var3 != jz3Var4) {
                                            z22 = z2;
                                            z24 = z21;
                                            i19 = i14;
                                        } else {
                                            i13 = 8;
                                            z22 = false;
                                            i19 = 8;
                                            z24 = false;
                                        }
                                        jz3 jz3Var8 = jz3Var7;
                                        i16 = i11;
                                        i17 = i12;
                                        jc0Var = jc0Var4;
                                        lb0Var4 = lb0Var2;
                                        gb2Var2.b(jz3Var5, jz3Var8, lb0Var.d(), f, jz3Var3, jz3Var6, lb0Var2.d(), i13);
                                        jz3Var7 = jz3Var8;
                                        i14 = i19;
                                        z21 = z24;
                                    }
                                    if (this.f0 != 8 && ((hashSet = lb0Var4.a) == null || hashSet.size() <= 0)) {
                                        return;
                                    }
                                    if (z19) {
                                        if (z22 && jz3Var7 != jz3Var3 && !z15 && ((jc0Var3 instanceof wj) || (jc0Var instanceof wj))) {
                                            i14 = 6;
                                        }
                                        gb2Var2.f(jz3Var5, jz3Var7, lb0Var.d(), i14);
                                        gb2Var2.g(jz3Var6, jz3Var3, -lb0Var4.d(), i14);
                                    }
                                    if (z22 || !z10 || (jc0Var3 instanceof wj) || (jc0Var instanceof wj) || jc0Var == kc0Var) {
                                        iMin2 = i15;
                                        z23 = z21;
                                    } else {
                                        iMin2 = 6;
                                        i14 = 6;
                                        z23 = true;
                                    }
                                    if (z23) {
                                        if (z20 && (!z9 || z3)) {
                                            if (jc0Var3 != kc0Var && jc0Var != kc0Var) {
                                                i34 = iMin2;
                                            }
                                            if ((jc0Var3 instanceof nq1) || (jc0Var instanceof nq1)) {
                                                i34 = 5;
                                            }
                                            if ((jc0Var3 instanceof wj) || (jc0Var instanceof wj)) {
                                                i34 = 5;
                                            }
                                            iMin2 = Math.max(z9 ? 5 : i34, iMin2);
                                        }
                                        if (z22) {
                                            iMin2 = Math.min(i14, iMin2);
                                            int i35 = (z6 && !z9 && (jc0Var3 == kc0Var || jc0Var == kc0Var)) ? 4 : iMin2;
                                            gb2Var2.e(jz3Var5, jz3Var7, lb0Var.d(), i35);
                                            gb2Var2.e(jz3Var6, jz3Var3, -lb0Var4.d(), i35);
                                        }
                                    }
                                    if (z22) {
                                        int iD = jz3Var == jz3Var7 ? lb0Var.d() : 0;
                                        if (jz3Var7 != jz3Var) {
                                            gb2Var2.f(jz3Var5, jz3Var, iD, 5);
                                        }
                                    }
                                    if (z22 || !z15 || i4 != 0 || i16 != 0) {
                                        i18 = 5;
                                        i24 = i18;
                                    } else if (z15 && i17 == 3) {
                                        gb2Var2.f(jz3Var6, jz3Var5, 0, 8);
                                        i18 = 5;
                                        i24 = i18;
                                    } else {
                                        i18 = 5;
                                        gb2Var2.f(jz3Var6, jz3Var5, 0, 5);
                                        i24 = i18;
                                    }
                                } else {
                                    gb2Var2 = gb2Var;
                                    jz3Var5 = jz3VarK3;
                                    jz3Var6 = jz3VarK4;
                                    z20 = z26;
                                    i14 = i22;
                                    jz3Var7 = jz3VarK5;
                                    i13 = 6;
                                    z18 = z25;
                                    i15 = i23;
                                    i12 = i29;
                                    jz3Var4 = jz3Var2;
                                    if (z19) {
                                        z21 = true;
                                        if (z18) {
                                        }
                                        if (this.f0 != 8) {
                                        }
                                        if (z19) {
                                        }
                                        if (z22) {
                                            iMin2 = i15;
                                            z23 = z21;
                                            if (z23) {
                                            }
                                            if (z22) {
                                            }
                                            if (z22) {
                                                i18 = 5;
                                                i24 = i18;
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (i29 == 2) {
                                    if ((jc0Var3 instanceof wj) || (jc0Var4 instanceof wj)) {
                                        gb2Var2 = gb2Var;
                                        i12 = i29;
                                        jz3Var5 = jz3VarK3;
                                        jz3Var6 = jz3VarK4;
                                        jz3Var7 = jz3VarK5;
                                        i13 = 6;
                                        i14 = 5;
                                    } else {
                                        gb2Var2 = gb2Var;
                                        i12 = i29;
                                        jz3Var5 = jz3VarK3;
                                        jz3Var6 = jz3VarK4;
                                        jz3Var7 = jz3VarK5;
                                        i13 = 6;
                                        i14 = 5;
                                        i15 = 5;
                                        z18 = true;
                                        z19 = true;
                                        z20 = false;
                                        jz3Var4 = jz3Var2;
                                        if (z19) {
                                        }
                                    }
                                } else if (i29 == 1) {
                                    gb2Var2 = gb2Var;
                                    i12 = i29;
                                    jz3Var5 = jz3VarK3;
                                    jz3Var6 = jz3VarK4;
                                    jz3Var7 = jz3VarK5;
                                    i13 = 6;
                                    i14 = 8;
                                } else if (i29 == 3) {
                                    i12 = i29;
                                    if (this.A != -1) {
                                        if (z6) {
                                            if (i7 == 2 || i7 == 1) {
                                                i20 = 5;
                                                i21 = 4;
                                            } else {
                                                i20 = 8;
                                                i21 = 5;
                                            }
                                            i15 = i21;
                                            jz3Var5 = jz3VarK3;
                                            jz3Var6 = jz3VarK4;
                                            jz3Var7 = jz3VarK5;
                                            i13 = 6;
                                            z18 = true;
                                            z19 = true;
                                            z20 = true;
                                            jz3Var4 = jz3Var2;
                                        } else if (i26 > 0) {
                                            gb2Var2 = gb2Var;
                                            jz3Var4 = jz3Var2;
                                            jz3Var5 = jz3VarK3;
                                            jz3Var6 = jz3VarK4;
                                            jz3Var7 = jz3VarK5;
                                            i13 = 6;
                                            i14 = 5;
                                        } else {
                                            if (i26 != 0 || i11 != 0) {
                                                gb2Var2 = gb2Var;
                                                jz3Var4 = jz3Var2;
                                                jz3Var5 = jz3VarK3;
                                                jz3Var6 = jz3VarK4;
                                                jz3Var7 = jz3VarK5;
                                                i13 = 6;
                                                i14 = 5;
                                                i15 = 4;
                                            } else if (z9) {
                                                i20 = (jc0Var3 == kc0Var || jc0Var4 == kc0Var) ? 5 : 4;
                                                jz3Var4 = jz3Var2;
                                                jz3Var5 = jz3VarK3;
                                                jz3Var6 = jz3VarK4;
                                                jz3Var7 = jz3VarK5;
                                                i13 = 6;
                                                i15 = 4;
                                                z18 = true;
                                                z19 = true;
                                                z20 = true;
                                            } else {
                                                gb2Var2 = gb2Var;
                                                jz3Var4 = jz3Var2;
                                                jz3Var5 = jz3VarK3;
                                                jz3Var6 = jz3VarK4;
                                                jz3Var7 = jz3VarK5;
                                                i13 = 6;
                                                i14 = 5;
                                                i15 = 8;
                                            }
                                            z18 = true;
                                            z19 = true;
                                            z20 = true;
                                            if (z19) {
                                            }
                                        }
                                        i14 = i20;
                                        gb2Var2 = gb2Var;
                                        if (z19) {
                                        }
                                    } else if (z9) {
                                        gb2Var2 = gb2Var;
                                        jz3Var4 = jz3Var2;
                                        jz3Var5 = jz3VarK3;
                                        jz3Var6 = jz3VarK4;
                                        jz3Var7 = jz3VarK5;
                                        i14 = 8;
                                        i13 = z2 ? 5 : 4;
                                    } else {
                                        gb2Var2 = gb2Var;
                                        jz3Var4 = jz3Var2;
                                        jz3Var5 = jz3VarK3;
                                        jz3Var6 = jz3VarK4;
                                        jz3Var7 = jz3VarK5;
                                        i14 = 8;
                                        i13 = 8;
                                    }
                                    i15 = 5;
                                    z18 = true;
                                    z19 = true;
                                    z20 = true;
                                    if (z19) {
                                    }
                                } else {
                                    i12 = i29;
                                    gb2Var2 = gb2Var;
                                    jz3Var4 = jz3Var2;
                                    jz3Var5 = jz3VarK3;
                                    jz3Var6 = jz3VarK4;
                                    jz3Var7 = jz3VarK5;
                                    i13 = 6;
                                    i14 = 5;
                                    i15 = 4;
                                    z18 = false;
                                    z19 = false;
                                }
                                i15 = 4;
                                z18 = true;
                                z19 = true;
                                z20 = false;
                                jz3Var4 = jz3Var2;
                                if (z19) {
                                }
                            }
                            if (z22 && z17) {
                                int iD2 = lb0Var4.f != null ? lb0Var4.d() : 0;
                                if (jz3Var3 != jz3Var2) {
                                    gb2Var2.f(jz3Var2, jz3Var6, iD2, i24);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i12 = i29;
                        if (jz3VarK5.Y && jz3Var3.Y) {
                            gb2Var.b(jz3VarK3, jz3VarK5, lb0Var.d(), f, jz3Var3, jz3VarK4, lb0Var2.d(), 8);
                            if (z2 && z17) {
                                int iD3 = lb0Var2.f != null ? lb0Var2.d() : 0;
                                if (jz3Var3 != jz3Var2) {
                                    gb2Var.f(jz3Var2, jz3VarK4, iD3, 5);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        gb2Var2 = gb2Var;
                        jz3Var4 = jz3Var2;
                        jz3Var5 = jz3VarK3;
                        jz3Var6 = jz3VarK4;
                        jz3Var7 = jz3VarK5;
                        i13 = 6;
                        i14 = 5;
                        i15 = 4;
                        z18 = true;
                        z19 = true;
                        z20 = false;
                        if (z19) {
                        }
                        if (z22) {
                            return;
                        } else {
                            return;
                        }
                    }
                } else {
                    jz3Var3 = jz3VarK6;
                    gb2Var2.e(jz3VarK4, jz3Var3, -lb0Var2.d(), 8);
                    if (z2) {
                        gb2Var2.f(jz3VarK3, jz3Var, 0, 5);
                        lb0Var4 = lb0Var2;
                        i18 = 5;
                        jz3Var6 = jz3VarK4;
                        z17 = z16;
                        z22 = z2;
                        i24 = i18;
                        if (z22) {
                        }
                    }
                }
                lb0Var4 = lb0Var2;
                jz3Var6 = jz3VarK4;
                z17 = z16;
            } else {
                lb0Var4 = lb0Var2;
                jz3Var6 = jz3VarK4;
                z17 = z16;
                jz3Var3 = jz3VarK6;
                z22 = z2;
                i24 = (z2 && (lb0Var.f.d instanceof wj)) ? 8 : 5;
                if (z22) {
                }
            }
            i18 = 5;
            z22 = z2;
            i24 = i18;
            if (z22) {
            }
        } else if (z5) {
            gb2Var2.e(jz3VarK4, jz3VarK3, 0, 3);
            if (i4 > 0) {
                gb2Var2.f(jz3VarK4, jz3VarK3, i4, i10);
            }
            if (i5 < Integer.MAX_VALUE) {
                gb2Var2.g(jz3VarK4, jz3VarK3, i5, i10);
            }
        } else {
            gb2Var2.e(jz3VarK4, jz3VarK3, iMin, i10);
        }
        z16 = z4;
        i11 = i25;
        if (z11) {
        }
        boolean z292 = z16;
        if (i28 >= 2) {
        }
    }

    public final void e(gb2 gb2Var) {
        gb2Var.k(this.H);
        gb2Var.k(this.I);
        gb2Var.k(this.J);
        gb2Var.k(this.K);
        if (this.Z > 0) {
            gb2Var.k(this.L);
        }
    }

    public final void f() {
        if (this.d == null) {
            ks1 ks1Var = new ks1(this);
            ks1Var.h.e = 4;
            ks1Var.i.e = 5;
            ks1Var.f = 0;
            this.d = ks1Var;
        }
        if (this.e == null) {
            dp4 dp4Var = new dp4(this);
            oo0 oo0Var = new oo0(dp4Var);
            dp4Var.k = oo0Var;
            dp4Var.l = null;
            dp4Var.h.e = 6;
            dp4Var.i.e = 7;
            oo0Var.e = 8;
            dp4Var.f = 1;
            this.e = dp4Var;
        }
    }

    public lb0 g(int i) {
        switch (fw.G(i)) {
            case 0:
                return null;
            case 1:
                return this.H;
            case 2:
                return this.I;
            case 3:
                return this.J;
            case 4:
                return this.K;
            case 5:
                return this.L;
            case 6:
                return this.O;
            case 7:
                return this.M;
            case 8:
                return this.N;
            default:
                xe.i(ha0.A(i));
                return null;
        }
    }

    public final int h(int i) {
        int[] iArr = this.o0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int i() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final jc0 j(int i) {
        lb0 lb0Var;
        lb0 lb0Var2;
        if (i != 0) {
            if (i == 1 && (lb0Var2 = (lb0Var = this.K).f) != null && lb0Var2.f == lb0Var) {
                return lb0Var2.d;
            }
            return null;
        }
        lb0 lb0Var3 = this.J;
        lb0 lb0Var4 = lb0Var3.f;
        if (lb0Var4 == null || lb0Var4.f != lb0Var3) {
            return null;
        }
        return lb0Var4.d;
    }

    public final jc0 k(int i) {
        lb0 lb0Var;
        lb0 lb0Var2;
        if (i != 0) {
            if (i == 1 && (lb0Var2 = (lb0Var = this.I).f) != null && lb0Var2.f == lb0Var) {
                return lb0Var2.d;
            }
            return null;
        }
        lb0 lb0Var3 = this.H;
        lb0 lb0Var4 = lb0Var3.f;
        if (lb0Var4 == null || lb0Var4.f != lb0Var3) {
            return null;
        }
        return lb0Var4.d;
    }

    public void l(StringBuilder sb) {
        sb.append("  " + this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.T);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.U);
        sb.append("\n");
        sb.append("    actualLeft:" + this.X);
        sb.append("\n");
        sb.append("    actualTop:" + this.Y);
        sb.append("\n");
        n(sb, "left", this.H);
        n(sb, "top", this.I);
        n(sb, "right", this.J);
        n(sb, "bottom", this.K);
        n(sb, "baseline", this.L);
        n(sb, "centerX", this.M);
        n(sb, "centerY", this.N);
        int i = this.T;
        int i2 = this.a0;
        int[] iArr = this.C;
        int i3 = iArr[0];
        int i4 = this.u;
        int i5 = this.r;
        float f = this.w;
        int[] iArr2 = this.o0;
        int i6 = iArr2[0];
        float[] fArr = this.j0;
        float f2 = fArr[0];
        m(sb, "    width", i, i2, i3, i4, i5, f, i6);
        int i7 = this.U;
        int i8 = this.b0;
        int i9 = iArr[1];
        int i10 = this.x;
        int i11 = this.s;
        float f3 = this.z;
        int i12 = iArr2[1];
        float f4 = fArr[1];
        m(sb, "    height", i7, i8, i9, i10, i11, f3, i12);
        float f5 = this.V;
        int i13 = this.W;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i13);
            sb.append("");
            sb.append("],\n");
        }
        E(sb, "    horizontalBias", this.c0, 0.5f);
        E(sb, "    verticalBias", this.d0, 0.5f);
        D(this.h0, 0, "    horizontalChainStyle", sb);
        D(this.i0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int o() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.T;
    }

    public final int p() {
        kc0 kc0Var = this.S;
        return kc0Var != null ? kc0Var.w0 + this.X : this.X;
    }

    public final int q() {
        kc0 kc0Var = this.S;
        return kc0Var != null ? kc0Var.x0 + this.Y : this.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r(int i) {
        if (i == 0) {
            return (this.H.f != null ? 1 : 0) + (this.J.f != null ? 1 : 0) < 2;
        }
        if ((this.I.f != null ? 1 : 0) + (this.K.f != null ? 1 : 0) + (this.L.f != null ? 1 : 0) < 2) {
        }
    }

    public final boolean s(int i, int i2) {
        lb0 lb0Var;
        lb0 lb0Var2;
        lb0 lb0Var3;
        lb0 lb0Var4;
        if (i == 0) {
            lb0 lb0Var5 = this.H;
            lb0 lb0Var6 = lb0Var5.f;
            if (lb0Var6 == null || !lb0Var6.c || (lb0Var4 = (lb0Var3 = this.J).f) == null || !lb0Var4.c) {
                return false;
            }
            return (lb0Var4.c() - lb0Var3.d()) - (lb0Var5.d() + lb0Var5.f.c()) >= i2;
        }
        lb0 lb0Var7 = this.I;
        lb0 lb0Var8 = lb0Var7.f;
        if (lb0Var8 == null || !lb0Var8.c || (lb0Var2 = (lb0Var = this.K).f) == null || !lb0Var2.c) {
            return false;
        }
        return (lb0Var2.c() - lb0Var.d()) - (lb0Var7.d() + lb0Var7.f.c()) >= i2;
    }

    public final void t(int i, int i2, int i3, int i4, jc0 jc0Var) {
        g(i).a(jc0Var.g(i2), i3, i4);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.g0 != null ? fw.y(new StringBuilder("id: "), this.g0, " ") : "");
        sb.append("(");
        sb.append(this.X);
        sb.append(", ");
        sb.append(this.Y);
        sb.append(") - (");
        sb.append(this.T);
        sb.append(" x ");
        return fw.w(")", sb, this.U);
    }

    public final boolean u(int i) {
        lb0 lb0Var;
        lb0 lb0Var2;
        int i2 = i * 2;
        lb0[] lb0VarArr = this.P;
        lb0 lb0Var3 = lb0VarArr[i2];
        lb0 lb0Var4 = lb0Var3.f;
        return (lb0Var4 == null || lb0Var4.f == lb0Var3 || (lb0Var2 = (lb0Var = lb0VarArr[i2 + 1]).f) == null || lb0Var2.f != lb0Var) ? false : true;
    }

    public final boolean v() {
        lb0 lb0Var = this.H;
        lb0 lb0Var2 = lb0Var.f;
        if (lb0Var2 != null && lb0Var2.f == lb0Var) {
            return true;
        }
        lb0 lb0Var3 = this.J;
        lb0 lb0Var4 = lb0Var3.f;
        return lb0Var4 != null && lb0Var4.f == lb0Var3;
    }

    public final boolean w() {
        lb0 lb0Var = this.I;
        lb0 lb0Var2 = lb0Var.f;
        if (lb0Var2 != null && lb0Var2.f == lb0Var) {
            return true;
        }
        lb0 lb0Var3 = this.K;
        lb0 lb0Var4 = lb0Var3.f;
        return lb0Var4 != null && lb0Var4.f == lb0Var3;
    }

    public final boolean x() {
        return this.g && this.f0 != 8;
    }

    public boolean y() {
        if (this.k) {
            return true;
        }
        return this.H.c && this.J.c;
    }

    public boolean z() {
        if (this.l) {
            return true;
        }
        return this.I.c && this.K.c;
    }
}
